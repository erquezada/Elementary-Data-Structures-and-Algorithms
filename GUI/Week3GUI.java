import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Week3GUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Week3GUI().createAndShowGUI());
    }

    public void createAndShowGUI() {
        // Create frame
        JFrame frame = new JFrame("Week 3 GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new BorderLayout());

        // Create panels
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(5, 2));

        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new BorderLayout());

        // Create text fields, buttons, and labels
        JTextField matrixSizeField = new JTextField(10);
        JTextArea resultArea = new JTextArea(10, 30);
        resultArea.setEditable(false);

        JTextField maxArrayField = new JTextField(10);
        JTextField uniqueArrayField = new JTextField(10);
        JTextField findElementField = new JTextField(10);
        JTextField targetField = new JTextField(10);

        JButton calculateButton = new JButton("Calculate");

        // Add components to input panel
        inputPanel.add(new JLabel("Matrix Size:"));
        inputPanel.add(matrixSizeField);
        inputPanel.add(new JLabel("Max Array (comma-separated):"));
        inputPanel.add(maxArrayField);
        inputPanel.add(new JLabel("Unique Array Row (comma-separated):"));
        inputPanel.add(uniqueArrayField);
        inputPanel.add(new JLabel("Find Element Array (comma-separated):"));
        inputPanel.add(findElementField);
        inputPanel.add(new JLabel("Target to Find:"));
        inputPanel.add(targetField);

        // Add button listener
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    resultArea.setText("");  // Clear previous results

                    // Get user inputs
                    int matrixSize = Integer.parseInt(matrixSizeField.getText());
                    String[] maxArrayStr = maxArrayField.getText().split(",");
                    int[] maxArray = new int[maxArrayStr.length];
                    for (int i = 0; i < maxArrayStr.length; i++) {
                        maxArray[i] = Integer.parseInt(maxArrayStr[i].trim());
                    }
                    String[] uniqueArrayStr = uniqueArrayField.getText().split(",");
                    int[] uniqueArray = new int[uniqueArrayStr.length];
                    for (int i = 0; i < uniqueArrayStr.length; i++) {
                        uniqueArray[i] = Integer.parseInt(uniqueArrayStr[i].trim());
                    }
                    String[] findArrayStr = findElementField.getText().split(",");
                    int[] findArray = new int[findArrayStr.length];
                    for (int i = 0; i < findArrayStr.length; i++) {
                        findArray[i] = Integer.parseInt(findArrayStr[i].trim());
                    }
                    int target = Integer.parseInt(targetField.getText());

                    // Call methods and display results
                    resultArea.append("Sum of diagonal elements: " + sumMatrix(matrixSize) + "\n");
                    resultArea.append("Max difference: " + maxDifference(maxArray) + "\n");
                    resultArea.append("Is element unique: " + isElementUnique(uniqueArray, 0) + "\n");
                    resultArea.append("Element found at index: " + findElement(findArray, target) + "\n");
                } catch (Exception ex) {
                    resultArea.setText("Error: Invalid input");
                }
            }
        });

        // Add components to frame
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(new JScrollPane(resultArea), BorderLayout.CENTER);
        frame.add(calculateButton, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    // The sumMatrix method for the GUI
    public int sumMatrix(int n) {
        int total = 0;
        int[][] M = new int[n][n];

        // For simplicity, just using random values for matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                M[i][j] = (int) (Math.random() * 10);
                if (i == j) total += M[i][j];
            }
        }
        return total;
    }

    // The maxDifference method for the GUI
    public int maxDifference(int[] maxArray) {
        int maxDifference = maxArray[1] - maxArray[0];
        for (int i = 0; i < maxArray.length; i++) {
            for (int j = i + 1; j < maxArray.length; j++) {
                if (maxArray[j] - maxArray[i] > maxDifference)
                    maxDifference = maxArray[j] - maxArray[i];
            }
        }
        return maxDifference;
    }

    // The isElementUnique method for the GUI
    public boolean isElementUnique(int[] uniqueArray, int num) {
        for (int i = 0; i < uniqueArray.length; i++) {
            for (int j = i + 1; j < uniqueArray.length; j++) {
                if (uniqueArray[j] == uniqueArray[i]) {
                    return false;
                }
            }
        }
        return true;
    }

    // The findElement method for the GUI
    public int findElement(int[] myArray, int target) {
        for (int i = 0; i < myArray.length; i++) {
            if (myArray[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
