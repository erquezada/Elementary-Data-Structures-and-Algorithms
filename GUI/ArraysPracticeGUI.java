import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class ArraysPracticeGUI {
    
    // GUI components
    private JFrame frame;
    private JTextArea outputArea;
    private JTextField inputField;
    private JButton calculateButton;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ArraysPracticeGUI gui = new ArraysPracticeGUI();
            gui.createAndShowGUI();
        });
    }

    // Method to create and show GUI
    public void createAndShowGUI() {
        frame = new JFrame("Array Operations");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new BorderLayout());

        // Input field
        inputField = new JTextField();
        inputField.setPreferredSize(new Dimension(400, 30));
        frame.add(inputField, BorderLayout.NORTH);

        // Calculate button
        calculateButton = new JButton("Calculate Operations");
        frame.add(calculateButton, BorderLayout.CENTER);

        // Output area
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setPreferredSize(new Dimension(400, 200));
        JScrollPane scrollPane = new JScrollPane(outputArea);
        frame.add(scrollPane, BorderLayout.SOUTH);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText().trim();
                if (input.isEmpty()) {
                    outputArea.setText("Please enter a valid matrix or array.");
                    return;
                }
                int[][] matrix = parseMatrix(input);
                if (matrix == null) {
                    outputArea.setText("Invalid Matrix Input. Please follow the format: row1, column1,column2; row2, column1,column2; ...");
                    return;
                }
                performMatrixOperations(matrix);
            }
        });

        frame.setVisible(true);
    }

    // Parse 2D matrix from input string with improved error handling
    private int[][] parseMatrix(String input) {
        try {
            String[] rows = input.split(";");
            int[][] matrix = new int[rows.length][];
            
            for (int i = 0; i < rows.length; i++) {
                String[] columns = rows[i].split(",");
                matrix[i] = new int[columns.length];
                for (int j = 0; j < columns.length; j++) {
                    matrix[i][j] = Integer.parseInt(columns[j].trim());
                }
            }
            return matrix;
        } catch (Exception e) {
            return null;  // Return null if parsing fails
        }
    }

    // Perform operations on 2D matrix with added checks for null matrix
    private void performMatrixOperations(int[][] matrix) {
        if (matrix == null) {
            outputArea.setText("Invalid Matrix Input. Please follow the format: row1, column1,column2; row2, column1,column2; ...");
            return;
        }
        
        StringBuilder result = new StringBuilder();
        result.append("Matrix: \n").append(matrixToString(matrix)).append("\n");
        
        result.append("Sum: ").append(sum(matrix)).append("\n");
        result.append("Product: ").append(product(matrix)).append("\n");
        result.append("Average: ").append(average(matrix)).append("\n");
        result.append("Min: ").append(min(matrix)).append("\n");
        result.append("Max: ").append(max(matrix)).append("\n");
        result.append("Diagonal Values: ").append(diagonalValues(matrix)).append("\n");
        
        outputArea.setText(result.toString());
    }

    // Convert matrix to string representation
    private String matrixToString(int[][] mat) {
        StringBuilder sb = new StringBuilder();
        for (int[] row : mat) {
            sb.append(Arrays.toString(row)).append("\n");
        }
        return sb.toString();
    }

    // Sum of all elements in the 2D array
    public static int sum(int[][] mat) {
        int sum = 0;
        for (int[] row : mat) {
            sum += Arrays.stream(row).sum();
        }
        return sum;
    }

    // Product of all elements in the 2D array
    public static int product(int[][] mat) {
        int product = 1;
        for (int[] row : mat) {
            for (int num : row) {
                product *= num;
            }
        }
        return product;
    }

    // Average of all elements in the 2D array
    public static double average(int[][] mat) {
        return Arrays.stream(mat).flatMapToInt(Arrays::stream).average().orElse(Double.NaN);
    }

    // Min value in the 2D array
    public static int min(int[][] mat) {
        return Arrays.stream(mat).flatMapToInt(Arrays::stream).min().orElse(Integer.MAX_VALUE);
    }

    // Max value in the 2D array
    public static int max(int[][] mat) {
        return Arrays.stream(mat).flatMapToInt(Arrays::stream).max().orElse(Integer.MIN_VALUE);
    }

    // Diagonal values of the 2D array
    public static String diagonalValues(int[][] mat) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mat.length; i++) {
            if (i < mat[i].length) {
                sb.append(mat[i][i]).append(" ");
            }
        }
        return sb.toString().trim();
    }
}
