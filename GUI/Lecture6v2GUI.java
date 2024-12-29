import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lecture6v2GUI {

    public static void main(String[] args) {
        // Set up the main frame
        JFrame frame = new JFrame("1D Array Operations");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Create text areas for input and output
        JTextArea inputText = new JTextArea(5, 20);
        inputText.setLineWrap(true);
        inputText.setWrapStyleWord(true);
        JScrollPane inputScroll = new JScrollPane(inputText);
        inputScroll.setBorder(BorderFactory.createTitledBorder("Enter 1D Array Elements (comma-separated)"));

        JTextArea outputText = new JTextArea(10, 20);
        outputText.setEditable(false);
        JScrollPane outputScroll = new JScrollPane(outputText);
        outputScroll.setBorder(BorderFactory.createTitledBorder("Results"));

        // Create a panel for buttons
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JButton processButton = new JButton("Process Array");
        panel.add(processButton);

        // Add components to the frame
        frame.add(inputScroll, BorderLayout.NORTH);
        frame.add(outputScroll, BorderLayout.CENTER);
        frame.add(panel, BorderLayout.SOUTH);

        // Add button action listener
        processButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputText.getText();
                String[] inputArray = input.split(",");
                int[] a1D = new int[inputArray.length];

                // Convert input string array to integer array
                for (int i = 0; i < inputArray.length; i++) {
                    try {
                        a1D[i] = Integer.parseInt(inputArray[i].trim());
                    } catch (NumberFormatException ex) {
                        outputText.setText("Invalid input. Please enter only numbers.");
                        return;
                    }
                }

                // Perform operations
                StringBuilder result = new StringBuilder();
                result.append("Sum: " + findSum(a1D) + "\n");
                result.append("Min: " + findMin(a1D) + "\n");
                result.append("Max: " + findMax(a1D) + "\n");

                result.append("\nArray printed forwards: ");
                for (int i = 0; i < a1D.length; i++) {
                    result.append(a1D[i] + " ");
                }

                result.append("\nArray printed backwards: ");
                for (int i = a1D.length - 1; i >= 0; i--) {
                    result.append(a1D[i] + " ");
                }

                // Display the result in the output area
                outputText.setText(result.toString());
            }
        });

        // Show the frame
        frame.setVisible(true);
    }

    public static int findSum(int[] a1D) {
        int sum = 0;
        for (int i = 0; i < a1D.length; i++) {
            sum += a1D[i];
        }
        return sum;
    }

    public static int findMin(int[] a1D) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < a1D.length; i++) {
            if (min > a1D[i]) {
                min = a1D[i];
            }
        }
        return min;
    }

    public static int findMax(int[] a1D) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < a1D.length; i++) {
            if (max < a1D[i]) {
                max = a1D[i];
            }
        }
        return max;
    }
}
