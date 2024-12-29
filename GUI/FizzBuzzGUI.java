import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class FizzBuzzGUI {

    public static void main(String[] args) {
        // Initialize the frame and setup the GUI components
        JFrame frame = new JFrame("FizzBuzz GUI");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Create components
        JLabel label = new JLabel("Enter a string for FizzBuzz processing:");
        JTextField inputField = new JTextField(20);
        JTextArea outputArea = new JTextArea(10, 30);
        outputArea.setEditable(false);
        JButton processButton = new JButton("Process FizzBuzz");
        
        // Set up layout
        frame.setLayout(new FlowLayout());
        frame.add(label);
        frame.add(inputField);
        frame.add(processButton);
        frame.add(new JScrollPane(outputArea));
        
        // Action listener for button
        processButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String inputString = inputField.getText();
                if (inputString != null && !inputString.isEmpty()) {
                    String[] fizzBuzzResult = fizzBuzz(0, inputString.length() - 1);
                    String notReplaced = notReplace(inputString);
                    outputArea.setText("FizzBuzz Output:\n" + Arrays.toString(fizzBuzzResult) +
                            "\n\nString after replacement:\n" + notReplaced);
                } else {
                    outputArea.setText("Please enter a valid string.");
                }
            }
        });
        
        // Display the frame
        frame.setVisible(true);
    }

    public static String[] fizzBuzz(int start, int end) {
        String[] answer = new String[end - start];
        int index = 0;
        for (int i = start; i < end; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                answer[index] = "FizzBuzz";
            } else if (i % 3 == 0) {
                answer[index] = "Fizz";
            } else if (i % 5 == 0) {
                answer[index] = "Buzz";
            } else {
                answer[index] = "" + i;
            }
            index++;
        }
        return answer;
    }

    public static String notReplace(String str) {
        return str.replaceAll("(?<!\\p{Alpha})is(?!\\p{Alpha})", "is not");
    }
}
