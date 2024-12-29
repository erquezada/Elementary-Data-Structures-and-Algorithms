import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class StackRunnerGUI {
    private static JTextArea inputArea;
    private static JTextArea outputArea;
    private static JButton evaluateButton;
    private static JButton balanceButton;
    private static JButton loadFileButton;
    private static JFileChooser fileChooser;
    private static Stack myStack = new Stack();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Stack Operations GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        // Layout
        frame.setLayout(new BorderLayout());

        // Input Area (where users input the expression)
        inputArea = new JTextArea(5, 40);
        JScrollPane inputScroll = new JScrollPane(inputArea);
        inputArea.setWrapStyleWord(true);
        inputArea.setLineWrap(true);
        frame.add(inputScroll, BorderLayout.NORTH);

        // Output Area (to display the result)
        outputArea = new JTextArea(10, 40);
        JScrollPane outputScroll = new JScrollPane(outputArea);
        outputArea.setEditable(false);
        frame.add(outputScroll, BorderLayout.CENTER);

        // Panel for buttons
        JPanel buttonPanel = new JPanel();
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Load File Button
        loadFileButton = new JButton("Load File");
        loadFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadFile();
            }
        });
        buttonPanel.add(loadFileButton);

        // Balance Button
        balanceButton = new JButton("Check Balance");
        balanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkBalance();
            }
        });
        buttonPanel.add(balanceButton);

        // Evaluate Button
        evaluateButton = new JButton("Evaluate Postfix");
        evaluateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evaluatePostfix();
            }
        });
        buttonPanel.add(evaluateButton);

        // Set up file chooser for loading files
        fileChooser = new JFileChooser();

        // Display the frame
        frame.setVisible(true);
    }

    // Method to load file content into input area
    private static void loadFile() {
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                StringBuilder content = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line).append("\n");
                }
                inputArea.setText(content.toString());
            } catch (IOException e) {
                outputArea.setText("Error reading the file.");
            }
        }
    }

    // Method to check balance of parentheses
    private static void checkBalance() {
        String input = inputArea.getText().trim();
        if (input.isEmpty()) {
            outputArea.setText("Please enter an expression.");
        } else {
            if (isBalanced(input)) {
                outputArea.setText("The expression is balanced.");
            } else {
                outputArea.setText("The expression is imbalanced.");
            }
        }
    }

    // Method to evaluate postfix expression
    private static void evaluatePostfix() {
        String input = inputArea.getText().trim();
        if (input.isEmpty()) {
            outputArea.setText("Please enter a postfix expression.");
        } else {
            try {
                double result = evaluatePostfixExpression(input);
                outputArea.setText("The evaluation of this postfix expression is: " + result);
            } catch (IllegalArgumentException e) {
                outputArea.setText("Invalid postfix expression.");
            }
        }
    }

    // Method to evaluate postfix expressions
    static double evaluatePostfixExpression(String postfix) {
        Stack stack = new Stack();
        String[] postfixArray = postfix.split(" ");
        for (String token : postfixArray) {
            if (isNumber(token)) {
                stack.push(Double.parseDouble(token));
            } else if (token.equals("*") || token.equals("+") || token.equals("-") || token.equals("/")) {
                double operand1 = (double) stack.pop();
                double operand2 = (double) stack.pop();
                if (token.equals("+")) stack.push(operand2 + operand1);
                if (token.equals("-")) stack.push(operand2 - operand1);
                if (token.equals("*")) stack.push(operand2 * operand1);
                if (token.equals("/")) stack.push(operand2 / operand1);
            }
        }
        return (double) stack.pop();
    }

    // Method to check if string is a number
    static boolean isNumber(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Method to check balance of parentheses
    static boolean isBalanced(String expr) {
        Stack stack = new Stack();
        for (int i = 0; i < expr.length(); i++) {
            if (expr.charAt(i) == '(') stack.push('(');
            else if (expr.charAt(i) == ')') {
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}

class Stack {
    private Node top;

    public Stack() {
        top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(Object newItem) {
        top = new Node(newItem, top);
    }

    public Object pop() {
        if (isEmpty()) return null;
        Node temp = top;
        top = top.next;
        return temp.info;
    }

    public Object peek() {
        return isEmpty() ? null : top.info;
    }
}

class Node {
    Object info;
    Node next;

    public Node(Object info, Node next) {
        this.info = info;
        this.next = next;
    }
}
