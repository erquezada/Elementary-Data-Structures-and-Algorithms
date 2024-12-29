import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PuzzlesGUI {

    // Define a method to determine the rule of the sequence and return the next number
    public static int nextNumber(int n) {
        String result = "";
        String str = String.valueOf(n);
        int count = 1;

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                count++;
            } else {
                result += count + "" + str.charAt(i - 1);
                count = 1;
            }
        }

        result += count + "" + str.charAt(str.length() - 1);
        return Integer.parseInt(result);
    }

    // Define a method to print out the sequence of N numbers that start with S and follow the rule
    public static String getSequence(int s, int n) {
        int[] sequence = new int[n];
        sequence[0] = s;

        for (int i = 1; i < n; i++) {
            sequence[i] = nextNumber(sequence[i - 1]);
        }

        StringBuilder sb = new StringBuilder();
        for (int num : sequence) {
            sb.append(num).append(" ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        // Set up the JFrame for the GUI
        JFrame frame = new JFrame("Sequence Generator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        // Create the input panel
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2));

        JLabel startLabel = new JLabel("Starting Number:");
        JTextField startField = new JTextField("2");

        JLabel lengthLabel = new JLabel("Sequence Length:");
        JTextField lengthField = new JTextField("6");

        inputPanel.add(startLabel);
        inputPanel.add(startField);
        inputPanel.add(lengthLabel);
        inputPanel.add(lengthField);

        // Create the button and the output text area
        JButton generateButton = new JButton("Generate Sequence");
        JTextArea outputArea = new JTextArea(5, 20);
        outputArea.setEditable(false);

        // Add the components to the frame
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(generateButton, BorderLayout.CENTER);
        frame.add(new JScrollPane(outputArea), BorderLayout.SOUTH);

        // Add an action listener to the button
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int start = Integer.parseInt(startField.getText());
                    int length = Integer.parseInt(lengthField.getText());

                    if (length <= 0) {
                        JOptionPane.showMessageDialog(frame, "Please enter a positive number for sequence length.");
                        return;
                    }

                    String sequence = getSequence(start, length);
                    outputArea.setText(sequence);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter valid numbers.");
                }
            }
        });

        // Make the frame visible
        frame.setVisible(true);
    }
}
