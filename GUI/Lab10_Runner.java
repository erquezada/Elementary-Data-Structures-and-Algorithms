import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

class BinaryTree {
    private Node root;

    private class Node {
        String value;
        Node left, right;

        Node(String item) {
            value = item;
            left = right = null;
        }
    }

    public BinaryTree() {
        root = null;
    }

    public boolean insertBST(String value) {
        root = insertBSTRec(root, value);
        return true;
    }

    private Node insertBSTRec(Node root, String value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }
        if (value.compareTo(root.value) < 0) {
            root.left = insertBSTRec(root.left, value);
        } else if (value.compareTo(root.value) > 0) {
            root.right = insertBSTRec(root.right, value);
        }
        return root;
    }

    public boolean searchBT(String value) {
        return searchBTRec(root, value) != null;
    }

    private Node searchBTRec(Node root, String value) {
        if (root == null || root.value.equals(value)) {
            return root;
        }
        if (value.compareTo(root.value) < 0) {
            return searchBTRec(root.left, value);
        } else {
            return searchBTRec(root.right, value);
        }
    }

    public int size() {
        return sizeRec(root);
    }

    private int sizeRec(Node root) {
        if (root == null) return 0;
        return 1 + sizeRec(root.left) + sizeRec(root.right);
    }

    public void printBT() {
        printBTRec(root, 0);
    }

    private void printBTRec(Node root, int level) {
        if (root != null) {
            printBTRec(root.right, level + 1);
            System.out.println(" ".repeat(level * 4) + root.value);
            printBTRec(root.left, level + 1);
        }
    }

    public void printAscending() {
        printAscendingRec(root);
    }

    private void printAscendingRec(Node root) {
        if (root != null) {
            printAscendingRec(root.left);
            System.out.print(root.value + " ");
            printAscendingRec(root.right);
        }
    }

    public void printDescending() {
        printDescendingRec(root);
    }

    private void printDescendingRec(Node root) {
        if (root != null) {
            printDescendingRec(root.right);
            System.out.print(root.value + " ");
            printDescendingRec(root.left);
        }
    }

    public String[] getAsArray() {
        java.util.List<String> list = new java.util.ArrayList<>();
        toArrayRec(root, list);
        return list.toArray(new String[0]);
    }

    private void toArrayRec(Node root, java.util.List<String> list) {
        if (root != null) {
            toArrayRec(root.left, list);
            list.add(root.value);
            toArrayRec(root.right, list);
        }
    }
}

public class BinaryTreeGUI extends JFrame {
    private BinaryTree bst;
    private JTextArea outputArea;
    private JTextField inputField;

    public BinaryTreeGUI() {
        bst = new BinaryTree();

        // Setup the JFrame
        setTitle("Binary Tree Visualization");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Setup output area to display tree results
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        add(scrollPane, BorderLayout.CENTER);

        // Input field and buttons panel
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        inputField = new JTextField(15);
        inputPanel.add(inputField);

        JButton insertButton = new JButton("Insert Node");
        JButton searchButton = new JButton("Search Node");
        JButton printAscButton = new JButton("Print Ascending");
        JButton printDescButton = new JButton("Print Descending");
        JButton getArrayButton = new JButton("Get Array");

        inputPanel.add(insertButton);
        inputPanel.add(searchButton);
        inputPanel.add(printAscButton);
        inputPanel.add(printDescButton);
        inputPanel.add(getArrayButton);

        add(inputPanel, BorderLayout.SOUTH);

        // Add action listeners to buttons
        insertButton.addActionListener(e -> insertNode());
        searchButton.addActionListener(e -> searchNode());
        printAscButton.addActionListener(e -> printAscending());
        printDescButton.addActionListener(e -> printDescending());
        getArrayButton.addActionListener(e -> getArray());

        // Populate the initial tree
        bst.insertBST("Pluto");
        bst.insertBST("Mercury");
        bst.insertBST("Jupiter");
        bst.insertBST("Neptune");
        bst.insertBST("Saturn");
        bst.insertBST("Venus");
        bst.insertBST("Earth");
        bst.insertBST("Mars");
        bst.insertBST("Uranus");

        // Display initial tree structure
        outputArea.append("Initial BST:\n");
        bst.printBT();
        outputArea.append("\n---------------------------\n");
    }

    // Insert node into the tree
    private void insertNode() {
        String value = inputField.getText();
        if (value.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a value.");
            return;
        }
        boolean result = bst.insertBST(value);
        outputArea.append("Inserting node: " + value + "\n");
        outputArea.append("Insert successful: " + result + "\n");
        inputField.setText("");
    }

    // Search node in the tree
    private void searchNode() {
        String value = inputField.getText();
        if (value.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a value.");
            return;
        }
        boolean result = bst.searchBT(value);
        outputArea.append("Searching for node: " + value + "\n");
        outputArea.append("Found: " + result + "\n");
        inputField.setText("");
    }

    // Print tree in ascending order
    private void printAscending() {
        outputArea.append("Printing tree in ascending order: \n");
        bst.printAscending();
        outputArea.append("\n---------------------------\n");
    }

    // Print tree in descending order
    private void printDescending() {
        outputArea.append("Printing tree in descending order: \n");
        bst.printDescending();
        outputArea.append("\n---------------------------\n");
    }

    // Display tree as an array
    private void getArray() {
        String[] strArray = bst.getAsArray();
        outputArea.append("Tree as an array: \n");
        outputArea.append(Arrays.toString(strArray) + "\n");
        outputArea.append("---------------------------\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BinaryTreeGUI frame = new BinaryTreeGUI();
            frame.setVisible(true);
        });
    }
}
