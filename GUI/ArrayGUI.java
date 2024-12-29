import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ArrayGUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ArrayGUI().createAndShowGUI());
    }

    private void createAndShowGUI() {
        // Frame setup
        JFrame frame = new JFrame("Array Operations");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(new BorderLayout());

        // Text area to display results
        JTextArea resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Button Panel for various operations
        JPanel panel = new JPanel(new GridLayout(0, 1));

        String[] buttonLabels = {
            "Print 1D Array", "Print Reverse Array", "Sum of Array", "Average of Array", 
            "Max of Array", "Min of Array", "Print 2D Array", "Sum of 2D Array", 
            "Sum Diagonal", "Sum Anti-Diagonal", "Check if Sorted", "Second Largest Number"
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(createActionListener(label, resultArea));
            panel.add(button);
        }

        frame.add(panel, BorderLayout.WEST);

        // Sample Arrays for testing
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        // Make the frame visible
        frame.setVisible(true);
    }

    // Helper method to create action listeners for buttons
    private ActionListener createActionListener(String label, JTextArea resultArea) {
        return e -> {
            switch (label) {
                case "Print 1D Array":
                    resultArea.setText(print1DArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
                    break;
                case "Print Reverse Array":
                    resultArea.setText(printReverseArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
                    break;
                case "Sum of Array":
                    resultArea.setText("Sum: " + sum(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
                    break;
                case "Average of Array":
                    resultArea.setText("Average: " + average(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
                    break;
                case "Max of Array":
                    resultArea.setText("Max: " + findMax(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
                    break;
                case "Min of Array":
                    resultArea.setText("Min: " + findMin(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
                    break;
                case "Print 2D Array":
                    resultArea.setText(print2DArray(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
                    break;
                case "Sum of 2D Array":
                    resultArea.setText("Sum of 2D Array: " + sum2DArray(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
                    break;
                case "Sum Diagonal":
                    resultArea.setText("Diagonal Sum: " + sumDiagonal(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
                    break;
                case "Sum Anti-Diagonal":
                    resultArea.setText("Anti-Diagonal Sum: " + sumAntiDiagonal(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
                    break;
                case "Check if Sorted":
                    resultArea.setText("Is sorted: " + isSorted(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
                    break;
                case "Second Largest Number":
                    resultArea.setText("Second Largest: " + findSecondLargest(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
                    break;
            }
        };
    }

    // Methods for array operations (reduced to more efficient code)

    public String print1DArray(int[] arr) {
        return arrayToString(arr, " ");
    }

    public String printReverseArray(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            sb.append(arr[i]).append(" ");
        }
        return sb.toString();
    }

    private String arrayToString(int[] arr, String delimiter) {
        StringBuilder sb = new StringBuilder();
        for (int val : arr) {
            sb.append(val).append(delimiter);
        }
        return sb.toString();
    }

    public int sum(int[] arr) {
        return arraySum(arr);
    }

    public double average(int[] arr) {
        return (double) arraySum(arr) / arr.length;
    }

    private int arraySum(int[] arr) {
        int sum = 0;
        for (int val : arr) {
            sum += val;
        }
        return sum;
    }

    public int findMax(int[] arr) {
        return arrayExtrema(arr, true);
    }

    public int findMin(int[] arr) {
        return arrayExtrema(arr, false);
    }

    private int arrayExtrema(int[] arr, boolean findMax) {
        int extrema = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if ((findMax && arr[i] > extrema) || (!findMax && arr[i] < extrema)) {
                extrema = arr[i];
            }
        }
        return extrema;
    }

    public String print2DArray(int[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for (int[] row : matrix) {
            for (int val : row) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public int sum2DArray(int[][] matrix) {
        int sum = 0;
        for (int[] row : matrix) {
            for (int val : row) {
                sum += val;
            }
        }
        return sum;
    }

    public int sumDiagonal(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    public int sumAntiDiagonal(int[][] matrix) {
        int sum = 0;
        int length = matrix.length;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][length - i - 1];
        }
        return sum;
    }

    public boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public int findSecondLargest(int[] arr) {
        int largest = Integer.MIN_VALUE, secondLargest = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }
        return secondLargest;
    }
}
