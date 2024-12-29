import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Week4_Sample_Questions_GUI {
    public static void main(String[] args) {
        // Initialize the frame and panels
        JFrame frame = new JFrame("Week 4 Sample Questions");
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Create buttons for each functionality
        JButton mergeButton = new JButton("Merge Arrays");
        JButton printOddButton = new JButton("Print Odd Numbers");
        JButton printSumButton = new JButton("Print Sums Less Than 100");
        JButton printFirstLastButton = new JButton("Print First and Last Row/Column");
        JButton isRaggedButton = new JButton("Check If Ragged");

        // Add buttons to the panel
        panel.add(mergeButton);
        panel.add(printOddButton);
        panel.add(printSumButton);
        panel.add(printFirstLastButton);
        panel.add(isRaggedButton);

        // Text area to display the results
        JTextArea textArea = new JTextArea(15, 30);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(scrollPane);

        // Add the panel to the frame
        frame.add(panel);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Define the data
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {6, 7, 8, 9, 10};
        int[][] mat = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };

        // Merge arrays
        mergeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] mergedArray = merge(a, b);
                textArea.setText("Merged Array: " + arrayToString(mergedArray));
            }
        });

        // Print odd numbers
        printOddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String result = printOdd(mat);
                textArea.setText(result);
            }
        });

        // Print sums less than 100
        printSumButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String result = printSum(mat);
                textArea.setText(result);
            }
        });

        // Print first and last row/column
        printFirstLastButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String result = printFirstLast(mat);
                textArea.setText(result);
            }
        });

        // Check if ragged
        isRaggedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean result = isRagged(mat);
                textArea.setText("Is Ragged: " + result);
            }
        });
    }

    // Method to convert an array to string
    public static String arrayToString(int[] a) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            sb.append(a[i]).append(" ");
        }
        return sb.toString().trim();
    }

    // Method to merge two arrays
    public static int[] merge(int[] a, int[] b) {
        int[] mergedArray = new int[a.length + b.length];
        int i;
        for (i = 0; i < a.length; i++) {
            mergedArray[i] = a[i];
        }
        for (int j = 0; j < b.length; j++) {
            mergedArray[i] = b[j];
            i++;
        }
        return mergedArray;
    }

    // Method to print odd numbers in the matrix
    public static String printOdd(int[][] mat) {
        StringBuilder result = new StringBuilder("Printing odd numbers:\n");
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] % 2 == 1) {
                    result.append(mat[i][j]).append(" ");
                }
            }
        }
        return result.toString();
    }

    // Method to print sums less than 100
    public static String printSum(int[][] mat) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < mat.length; i++) {
            int sum = 0;
            for (int j = 0; j < mat[i].length; j++) {
                sum += mat[i][j];
                if (sum < 100) {
                    result.append(sum).append(" ");
                }
            }
        }
        return result.toString();
    }

    // Method to print first and last row/column
    public static String printFirstLast(int[][] mat) {
        StringBuilder result = new StringBuilder();

        // First row
        result.append("First Row:\n");
        for (int i = 0; i < mat[0].length; i++) {
            result.append(mat[0][i]).append(" ");
        }
        result.append("\nFirst Column:\n");

        // First column
        for (int i = 0; i < mat.length; i++) {
            result.append(mat[i][0]).append(" ");
        }

        return result.toString();
    }

    // Method to check if the matrix is ragged
    public static boolean isRagged(int[][] mat) {
        if (mat.length == 0) {
            return false; // empty array is not ragged
        }
        int rowLength = mat[0].length;
        for (int i = 1; i < mat.length; i++) {
            if (mat[i].length != rowLength) {
                return true; // found a row with different length
            }
        }
        return false; // all rows have the same length
    }
}
