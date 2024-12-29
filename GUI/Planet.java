import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lab5GUI extends JFrame {
    private PlanetLinkedList solarSystem;
    private JTextArea displayArea;
    private JTextField searchField, insertField, swapField1, swapField2;

    public Lab5GUI() {
        // Set up the frame
        setTitle("Planet Linked List");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the layout and components
        setLayout(new BorderLayout());
        
        // Create the display area
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);
        add(scrollPane, BorderLayout.CENTER);

        // Create a panel for buttons and text fields
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(6, 2));

        // Add controls for search, insert, and swap
        controlPanel.add(new JLabel("Search by Diameter or Name:"));
        searchField = new JTextField();
        controlPanel.add(searchField);

        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(new SearchAction());
        controlPanel.add(searchButton);

        controlPanel.add(new JLabel("Insert Planet (Name, Diameter, Moons):"));
        insertField = new JTextField();
        controlPanel.add(insertField);

        JButton insertButton = new JButton("Insert");
        insertButton.addActionListener(new InsertAction());
        controlPanel.add(insertButton);

        controlPanel.add(new JLabel("Swap Positions (Index 1, Index 2):"));
        swapField1 = new JTextField();
        swapField2 = new JTextField();
        controlPanel.add(swapField1);
        controlPanel.add(swapField2);

        JButton swapButton = new JButton("Swap");
        swapButton.addActionListener(new SwapAction());
        controlPanel.add(swapButton);

        // Add remove button
        JButton removeButton = new JButton("Remove Head");
        removeButton.addActionListener(new RemoveAction());
        controlPanel.add(removeButton);

        add(controlPanel, BorderLayout.SOUTH);

        // Load the linked list
        String inputfilename = "input.txt";
        solarSystem = constructLLFromFile(inputfilename);
        updateDisplay();

    }

    // Update the display area
    private void updateDisplay() {
        displayArea.setText(""); // Clear previous text
        solarSystem.printLL();
    }

    // Action for searching planets
    private class SearchAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String searchTerm = searchField.getText();
            try {
                long diameter = Long.parseLong(searchTerm);
                solarSystem.search(diameter);
            } catch (NumberFormatException ex) {
                solarSystem.search(searchTerm);
            }
            updateDisplay();
        }
    }

    // Action for inserting planets
    private class InsertAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String input = insertField.getText();
            String[] parts = input.split(",");
            if (parts.length == 3) {
                String name = parts[0].trim();
                long diameter = Long.parseLong(parts[1].trim());
                int moons = Integer.parseInt(parts[2].trim());
                Planet newPlanet = new Planet(name, diameter, moons);
                solarSystem.insert(newPlanet, 4); // Example: Always inserting at position 4
                updateDisplay();
            }
        }
    }

    // Action for swapping planets
    private class SwapAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int index1 = Integer.parseInt(swapField1.getText());
            int index2 = Integer.parseInt(swapField2.getText());
            solarSystem.swap(index1, index2);
            updateDisplay();
        }
    }

    // Action for removing the head of the list
    private class RemoveAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            solarSystem.remove(0);
            updateDisplay();
        }
    }

    // Method to construct the linked list from the file
    static PlanetLinkedList constructLLFromFile(String theInputFile) {
        System.out.println("Constructing the linked list from " + theInputFile);
        try {
            File file = new File(theInputFile); // read file
            Scanner fileScanner = new Scanner(file); // scan file
            String name = fileScanner.nextLine(); // parse strings from file
            long diameter = Long.parseLong(fileScanner.nextLine()); // parse longs from file
            int moon = Integer.parseInt(fileScanner.nextLine()); // parse ints from file
            Planet head = new Planet(name, diameter, moon); // initial planet to be the head node
            Planet temp = head; // temp planet to be used as a placeholder

            while (fileScanner.hasNextLine()) { // scan through the other lines of the file
                name = fileScanner.nextLine(); // parse strings from file
                diameter = Long.parseLong(fileScanner.nextLine()); // parse longs from file
                moon = Integer.parseInt(fileScanner.nextLine()); // parse ints from file
                temp.next = new Planet(name, diameter, moon); // temp's next pointer receives a new planet object so long as there is data to be parsed from file
                temp = temp.next; // temp points to a next planet
            }
            return new PlanetLinkedList(head); // return linked list

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Main method to launch the GUI
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Lab5GUI gui = new Lab5GUI();
            gui.setVisible(true);
        });
    }
}