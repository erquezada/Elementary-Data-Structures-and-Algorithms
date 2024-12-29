import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StackGUI {

    private static Stack stack = new Stack();  // Create an instance of the Stack class
    private static JTextArea stackDisplay;
    private static JTextField inputField;

    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Stack Operations");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        // Create the layout
        frame.setLayout(new BorderLayout());

        // Stack display area
        stackDisplay = new JTextArea();
        stackDisplay.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(stackDisplay);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Input field for pushing items onto the stack
        JPanel inputPanel = new JPanel();
        frame.add(inputPanel, BorderLayout.NORTH);
        inputPanel.setLayout(new FlowLayout());

        inputField = new JTextField(15);
        inputPanel.add(inputField);

        // Buttons panel for stack operations
        JPanel buttonPanel = new JPanel();
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Push button
        JButton pushButton = new JButton("Push");
        pushButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputText = inputField.getText();
                if (!inputText.isEmpty()) {
                    stack.push(inputText);  // Push the item onto the stack
                    inputField.setText("");  // Clear the input field
                    updateStackDisplay();
                } else {
                    JOptionPane.showMessageDialog(frame, "Please enter an item to push.");
                }
            }
        });
        buttonPanel.add(pushButton);

        // Pop button
        JButton popButton = new JButton("Pop");
        popButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object poppedItem = stack.pop();  // Pop the item from the stack
                if (poppedItem != null) {
                    updateStackDisplay();
                }
            }
        });
        buttonPanel.add(popButton);

        // Peek button
        JButton peekButton = new JButton("Peek");
        peekButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object topItem = stack.peek();  // Peek at the top item
                if (topItem != null) {
                    JOptionPane.showMessageDialog(frame, "Top item: " + topItem);
                }
            }
        });
        buttonPanel.add(peekButton);

        // Clear stack button
        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stack.popAll();  // Clear the stack
                updateStackDisplay();
            }
        });
        buttonPanel.add(clearButton);

        // Set frame visible
        frame.setVisible(true);
    }

    // Method to update the stack display area
    private static void updateStackDisplay() {
        StringBuilder displayText = new StringBuilder();
        Object topItem = stack.peek();
        if (topItem != null) {
            displayText.append("Top of the stack: ").append(topItem).append("\n");
        }
        displayText.append("Stack contents:\n");

        // Traverse the stack and display its contents
        Node current = stack.getTop();
        while (current != null) {
            displayText.append(current.info).append("\n");
            current = current.next;
        }
        stackDisplay.setText(displayText.toString());
    }
}

class Stack {
    private Node top;

    public Stack() {
        top = null;
    }

    public boolean isEmpty() {
        return (top == null);
    }

    public void push(Object newItem) {
        top = new Node(newItem, top);
    }

    public Object pop() {
        if (isEmpty()) {
            System.out.println("Trying to pop when stack is empty");
            return null;
        } else {
            Node temp = top;
            top = top.next;
            return temp.info;
        }
    }

    public void popAll() {
        top = null;
    }

    public Object peek() {
        if (isEmpty()) {
            System.out.println("Trying to peek when stack is empty");
            return null;
        } else {
            return top.info;
        }
    }

    public Node getTop() {
        return top;
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
