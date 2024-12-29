import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Planet class with additional functionalities
class Planet {
    private String name;
    private long diameter;
    private int moon;

    Planet next;

    Planet(String n, long d, int m) {
        name = n;
        diameter = d;
        moon = m;
    }

    String getName() {
        return name;
    }

    long getDiameter() {
        return diameter;
    }

    int getMoon() {
        return moon;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nDiameter: " + diameter + "\nMoon: " + moon;
    }
}

// GUI class for the Planet
public class PlanetGUI extends JFrame {
    private JTextArea displayArea;
    private JTextField nameField, diameterField, moonField;

    private Planet head;

    public PlanetGUI() {
        // Set up the frame
        setTitle("Planet Info");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Initialize components
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);
        add(scrollPane, BorderLayout.CENTER);

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(5, 2));

        controlPanel.add(new JLabel("Planet Name:"));
        nameField = new JTextField();
        controlPanel.add(nameField);

        controlPanel.add(new JLabel("Diameter (km):"));
        diameterField = new JTextField();
        controlPanel.add(diameterField);

        controlPanel.add(new JLabel("Number of Moons:"));
        moonField = new JTextField();
        controlPanel.add(moonField);

        JButton addButton = new JButton("Add Planet");
        addButton.addActionListener(new AddPlanetAction());
        controlPanel.add(addButton);

        JButton displayButton = new JButton("Display Planets");
        displayButton.addActionListener(new DisplayPlanetsAction());
        controlPanel.add(displayButton);

        add(controlPanel, BorderLayout.SOUTH);

        // Initialize head (Linked list start)
        head = null;
    }

    // ActionListener to add a new planet
    private class AddPlanetAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String name = nameField.getText();
            long diameter;
            int moon;

            // Validating the user input
            try {
                diameter = Long.parseLong(diameterField.getText());
                moon = Integer.parseInt(moonField.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(PlanetGUI.this, "Invalid input! Please enter valid numbers for diameter and moons.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Planet newPlanet = new Planet(name, diameter, moon);
            if (head == null) {
                head = newPlanet;
            } else {
                Planet temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = newPlanet;
            }

            JOptionPane.showMessageDialog(PlanetGUI.this, "Planet added successfully!");
        }
    }

    // ActionListener to display all planets
    private class DisplayPlanetsAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (head == null) {
                displayArea.setText("No planets to display.");
                return;
            }

            Planet temp = head;
            StringBuilder sb = new StringBuilder();
            while (temp != null) {
                sb.append(temp.toString()).append("\n\n");
                temp = temp.next;
            }
            displayArea.setText(sb.toString());
        }
    }

    // Main method to launch the GUI
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PlanetGUI gui = new PlanetGUI();
            gui.setVisible(true);
        });
    }
}
