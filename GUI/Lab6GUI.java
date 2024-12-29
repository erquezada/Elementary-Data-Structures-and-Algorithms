import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Lab6GUI extends JFrame {
    // TextArea to display results
    private JTextArea outputArea;
    
    // TextField for user input
    private JTextField inputField;
    
    // Constructor to set up the GUI
    public Lab6GUI() {
        // Set the title and layout for the JFrame
        setTitle("Lab 6 GUI");
        setLayout(new BorderLayout());

        // Create the output area
        outputArea = new JTextArea(20, 50);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        add(scrollPane, BorderLayout.CENTER);

        // Create the input field
        inputField = new JTextField(30);
        add(inputField, BorderLayout.NORTH);

        // Create buttons to test each method
        JPanel buttonPanel = new JPanel();
        add(buttonPanel, BorderLayout.SOUTH);

        JButton countDigitsButton = new JButton("Test countDigits");
        countDigitsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                outputArea.append("Testing countDigits for: " + input + "\n");
                outputArea.append("Result: " + countDigits(input) + "\n\n");
            }
        });

        JButton hasCapitalButton = new JButton("Test hasCapital");
        hasCapitalButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                outputArea.append("Testing hasCapital for: " + input + "\n");
                outputArea.append("Result: " + hasCapital(input) + "\n\n");
            }
        });

        JButton checkPalindromeButton = new JButton("Test checkPalindrome");
        checkPalindromeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                outputArea.append("Testing checkPalindrome for: " + input + "\n");
                outputArea.append("Result: " + checkPalindrome(input) + "\n\n");
            }
        });

        JButton reverseStringButton = new JButton("Test reverseString");
        reverseStringButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                outputArea.append("Testing reverseString for: " + input + "\n");
                outputArea.append("Result: " + reverseString(input) + "\n\n");
            }
        });

        JButton updateStringButton = new JButton("Test updateString");
        updateStringButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                String unexpectedChars = JOptionPane.showInputDialog("Enter characters to remove:");
                outputArea.append("Testing updateString for: " + input + "\n");
                outputArea.append("Removing characters: " + unexpectedChars + "\n");
                outputArea.append("Result: " + updateString(input, unexpectedChars) + "\n\n");
            }
        });

        // Add buttons to the panel
        buttonPanel.add(countDigitsButton);
        buttonPanel.add(hasCapitalButton);
        buttonPanel.add(checkPalindromeButton);
        buttonPanel.add(reverseStringButton);
        buttonPanel.add(updateStringButton);

        // Set the default close operation and window size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setVisible(true);
    }

    // Recursive method to count digits
    static int countDigits(String str){
        if(str.length() == 0) return 0;
        int count = 0;
        if(Character.isDigit(str.charAt(0))) count++;
        return count + countDigits(str.substring(1));
    }

    // Recursive method to check if a string has a capital letter
    static boolean hasCapital(String str){
        if(str.length() == 0) return false;
        if(Character.isUpperCase(str.charAt(0))) return true;
        return hasCapital(str.substring(1));
    }

    // Recursive method to check if a string is a palindrome
    static boolean checkPalindrome(String str){
        if(str.length() == 0 || str.length() == 1) return true;
        if(str.charAt(0) == str.charAt(str.length() - 1))
            return checkPalindrome(str.substring(1, str.length() - 1));
        return false;
    }

    // Recursive method to reverse a string
    static String reverseString(String str){
        if(str.length() == 0) return "";
        if(str.length() == 1) return str;
        return reverseString(str.substring(1)) + str.charAt(0);
    }

    // Recursive method to remove unexpected characters
    static String updateString(String given, String unexpectedCh){
        if(given.length() == 0) return "";
        if(unexpectedCh.length() == 0) return given;
        if(unexpectedCh.contains(""+given.charAt(0))) return "" + updateString(given.substring(1), unexpectedCh);
        else return given.charAt(0) + updateString(given.substring(1),unexpectedCh);
    }

    public static void main(String[] args) {
        // Launch the GUI application
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Lab6GUI();
            }
        });
    }
}
