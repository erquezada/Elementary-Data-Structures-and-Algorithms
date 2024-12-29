import javax.swing.*;
import java.awt.*;

public class Lecture6 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Lecture6().createAndShowGUI());
    }

    public void createAndShowGUI() {
        JFrame frame = new JFrame("Anti-Diagonal Viewer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new BorderLayout());

        int[][] nums = {
                {1, 2, 3, 4},
                {2, 3, 4, 5},
                {3, 4, 5, 6},
                {6, 7, 8, 9}
        };

        // Create the text area to display matrix and results
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Create a button to display the diagonal and the sum
        JButton button = new JButton("Show Diagonal and Sum");
        button.addActionListener(e -> {
            StringBuilder sb = new StringBuilder();
            sb.append("Matrix:\n");
            for (int[] row : nums) {
                for (int num : row) {
                    sb.append(num).append(" ");
                }
                sb.append("\n");
            }
            sb.append("\nAnti Diagonal:\n");
            sb.append(printDiagonal(nums));
            sb.append("\nThe sum is: ").append(printDiagonalSum(nums));
            textArea.setText(sb.toString());
        });

        frame.add(button, BorderLayout.SOUTH);

        // Show the GUI
        frame.setVisible(true);
    }

    // Combined print and sum of diagonals
    public String printDiagonal(int[][] anArray) {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < anArray.length; row++) {
            for (int col = 0; col < anArray[row].length; col++) {
                if (row == col) {
                    sb.append(anArray[row][col]).append(" ");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    // Return the sum of diagonal elements
    public int printDiagonalSum(int[][] anArray) {
        int sumDiagonal = 0;
        for (int row = 0; row < anArray.length; row++) {
            if (row < anArray[row].length) {
                sumDiagonal += anArray[row][row];
            }
        }
        return sumDiagonal;
    }
}
