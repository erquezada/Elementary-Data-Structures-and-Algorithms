import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

class Box {
    private double length, width, height;

    // Getters and Setters for Box
    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    // Surface area method
    public double getSurfaceArea() {
        return 2 * (length * width + length * height + width * height);
    }

    // Compare surface area method
    public int compareTo(Box o) {
        double mySurfaceArea = this.getSurfaceArea();
        double otherSurfaceArea = o.getSurfaceArea();
        return Double.compare(mySurfaceArea, otherSurfaceArea);
    }
}

public class Lab3_Runner_Quezada_GUI extends JFrame {
    private JTextArea resultArea;
    private JButton openFileButton, calculateButton;
    private Box[] boxes = new Box[6];  // Array to hold box objects
    private JFileChooser fileChooser;

    public Lab3_Runner_Quezada_GUI() {
        setTitle("Box Surface Area Calculator");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Set layout
        setLayout(new BorderLayout());

        // Initialize components
        resultArea = new JTextArea();
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);

        openFileButton = new JButton("Open File");
        calculateButton = new JButton("Calculate");

        JPanel panel = new JPanel();
        panel.add(openFileButton);
        panel.add(calculateButton);

        // Add components to frame
        add(panel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // File chooser
        fileChooser = new JFileChooser();

        // Open file button action
        openFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    try {
                        loadBoxesFromFile(selectedFile);
                    } catch (FileNotFoundException ex) {
                        resultArea.setText("File not found!");
                    }
                }
            }
        });

        // Calculate button action
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (boxes[0] != null) {
                    printMethods();
                } else {
                    resultArea.setText("No boxes loaded.");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Lab3_Runner_Quezada_GUI().setVisible(true);
            }
        });
    }

    // Load boxes from file
    private void loadBoxesFromFile(File file) throws FileNotFoundException {
        Scanner scnr = new Scanner(file);
        int i = 0;

        // Read box data from file
        while (scnr.hasNextDouble() && i < boxes.length) {
            Box box = new Box();
            box.setLength(scnr.nextDouble());
            box.setWidth(scnr.nextDouble());
            box.setHeight(scnr.nextDouble());
            boxes[i] = box;
            i++;
        }
        scnr.close();
    }

    // Print methods results
    private void printMethods() {
        resultArea.setText("");
        resultArea.append("Average surface area: " + averageSurfaceArea() + "\n");
        resultArea.append("Box indices with larger surface area: ");
        findBoxIndicesGreaterThanAverage();
        resultArea.append("\n");
        findLargestBox();
        resultArea.append("Number of boxes with surface area larger than average: " + countBoxesGreaterThanAverage() + "\n");
        resultArea.append("Number of boxes with surface area smaller than average: " + countBoxesLesserThanAverage() + "\n");
    }

    // Calculate average surface area
    private double averageSurfaceArea() {
        double sum = 0;
        for (Box box : boxes) {
            if (box != null) {
                sum += box.getSurfaceArea();
            }
        }
        double average = sum / boxes.length;
        return Math.ceil(average * 100) / 100;
    }

    // Find the box with the largest surface area
    private void findLargestBox() {
        int index = 0;
        Box largestBox = boxes[0];
        for (int i = 0; i < boxes.length; i++) {
            if (boxes[i] != null && boxes[i].compareTo(largestBox) > 0) {
                largestBox = boxes[i];
                index = i;
            }
        }
        resultArea.append("The largest box has index: " + index + ", surface area " +
                largestBox.getSurfaceArea() + ", and dimensions: length is " + largestBox.getLength() +
                ", width is " + largestBox.getWidth() + ", height is " + largestBox.getHeight() + "\n");
    }

    // Count boxes with surface area greater than average
    private int countBoxesGreaterThanAverage() {
        int count = 0;
        double avg = averageSurfaceArea();
        for (Box box : boxes) {
            if (box != null && box.getSurfaceArea() > avg) {
                count++;
            }
        }
        return count;
    }

    // Count boxes with surface area smaller than average
    private int countBoxesLesserThanAverage() {
        int count = 0;
        double avg = averageSurfaceArea();
        for (Box box : boxes) {
            if (box != null && box.getSurfaceArea() < avg) {
                count++;
            }
        }
        return count;
    }

    // Find the box indices with larger surface area than average
    private void findBoxIndicesGreaterThanAverage() {
        for (int i = 0; i < boxes.length; i++) {
            if (boxes[i] != null && boxes[i].getSurfaceArea() > averageSurfaceArea()) {
                resultArea.append(i + " ");
            }
        }
    }
}