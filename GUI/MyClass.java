import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class MyClass {

    public static void main(String[] args) {
        // Initialize the table
        int[][] table = {
                {21, 62, 39},
                {49, 17, 12},
                {42, 25, 93}
        };

        // Create the main window
        JFrame frame = new JFrame("Array Operations");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Create the panel for the buttons and results
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Create a text area to show the results
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setPreferredSize(new Dimension(350, 200));

        JScrollPane scrollPane = new JScrollPane(textArea);

        // Add a button to display rows whose sum is less than 100
        JButton sumButton = new JButton("Print Rows Sum Less Than 100");
        sumButton.addActionListener(e -> {
            textArea.setText(""); // Clear the text area before displaying new results
            printSum(table, textArea);
        });

        // Add a button to print odd numbers with dashes
        JButton oddButton = new JButton("Print Odd Numbers");
        oddButton.addActionListener(e -> {
            textArea.setText("");
            printOdd(table, textArea);
        });

        // Add a button to print even numbers with dashes
        JButton evenButton = new JButton("Print Even Numbers");
        evenButton.addActionListener(e -> {
            textArea.setText("");
            printEven(table, textArea);
        });

        // Add the components to the panel
        panel.add(sumButton);
        panel.add(oddButton);
        panel.add(evenButton);
        panel.add(scrollPane);

        // Add the panel to the frame
        frame.add(panel);
        frame.setVisible(true);
    }

    // Method to print rows whose sum is less than 100
    public static void printSum(int[][] mat, JTextArea textArea) {
        int sum = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                sum += mat[i][j];
            }
            if (sum <= 100) {
                textArea.append(Arrays.toString(mat[i]) + "\n");
            }
            sum = 0;
        }
    }

    // Method to print odd numbers, and dashes for others
    public static void printOdd(int[][] mat, JTextArea textArea) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] % 2 == 1) {
                    textArea.append(mat[i][j] + " ");
                } else {
                    textArea.append("- ");
                }
            }
            textArea.append("\n");
        }
    }

    // Method to print even numbers, and dashes for others
    public static void printEven(int[][] mat, JTextArea textArea) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] % 2 == 0) {
                    textArea.append(mat[i][j] + " ");
                } else {
                    textArea.append("- ");
                }
            }
            textArea.append("\n");
        }
    }
}
