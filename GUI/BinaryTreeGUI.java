import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class TreeNode {
    Object item;
    TreeNode leftChild;
    TreeNode rightChild;

    public TreeNode(Object value) {
        item = value;
        leftChild = null;
        rightChild = null;
    }

    public TreeNode(Object value, TreeNode left, TreeNode right) {
        item = value;
        leftChild = left;
        rightChild = right;
    }
}

public class BinaryTreeGUI extends JFrame {
    private static TreeNode root;

    public BinaryTreeGUI() {
        setTitle("Binary Tree Visualization");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        root = createSampleTree(); // Sample tree for visualization
        setLayout(new BorderLayout());

        // Create a panel to display the tree
        TreePanel treePanel = new TreePanel();
        add(treePanel, BorderLayout.CENTER);

        // Create a control panel
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        // Button to add a new node
        JButton addButton = new JButton("Add Node");
        controlPanel.add(addButton);

        // Button to remove a node
        JButton removeButton = new JButton("Remove Node");
        controlPanel.add(removeButton);

        add(controlPanel, BorderLayout.SOUTH);

        // Action listener for the buttons
        addButton.addActionListener(e -> {
            String value = JOptionPane.showInputDialog("Enter value to add:");
            if (value != null && !value.trim().isEmpty()) {
                root = insertNode(root, value.trim());
                treePanel.repaint();
            }
        });

        removeButton.addActionListener(e -> {
            String value = JOptionPane.showInputDialog("Enter value to remove:");
            if (value != null && !value.trim().isEmpty()) {
                root = removeNode(root, value.trim());
                treePanel.repaint();
            }
        });
    }

    // Method to create a sample tree
    private TreeNode createSampleTree() {
        TreeNode node7 = new TreeNode("7");
        TreeNode node8 = new TreeNode("8");
        TreeNode node3 = new TreeNode("3", node7, node8);
        TreeNode node5 = new TreeNode("5");
        TreeNode node2 = new TreeNode("2", node3, node5);
        return new TreeNode("4", node2, null);
    }

    // Insert node in binary tree (basic binary insert)
    private TreeNode insertNode(TreeNode node, String value) {
        if (node == null) {
            return new TreeNode(value);
        }

        if (value.compareTo(node.item.toString()) < 0) {
            node.leftChild = insertNode(node.leftChild, value);
        } else if (value.compareTo(node.item.toString()) > 0) {
            node.rightChild = insertNode(node.rightChild, value);
        }

        return node;
    }

    // Remove node in binary tree (basic binary delete)
    private TreeNode removeNode(TreeNode node, String value) {
        if (node == null) {
            return null;
        }

        if (value.compareTo(node.item.toString()) < 0) {
            node.leftChild = removeNode(node.leftChild, value);
        } else if (value.compareTo(node.item.toString()) > 0) {
            node.rightChild = removeNode(node.rightChild, value);
        } else {
            // Node found
            if (node.leftChild == null) {
                return node.rightChild;
            } else if (node.rightChild == null) {
                return node.leftChild;
            }

            // Node has two children, get the inorder successor
            node.item = minValue(node.rightChild);
            node.rightChild = removeNode(node.rightChild, node.item.toString());
        }

        return node;
    }

    private String minValue(TreeNode node) {
        String minValue = node.item.toString();
        while (node.leftChild != null) {
            minValue = node.leftChild.item.toString();
            node = node.leftChild;
        }
        return minValue;
    }

    // TreePanel for drawing the binary tree
    private class TreePanel extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (root != null) {
                drawTree(g, root, getWidth() / 2, 50, 100);
            }
        }

        // Recursively draw the tree
        private void drawTree(Graphics g, TreeNode node, int x, int y, int xOffset) {
            if (node != null) {
                g.setColor(Color.BLACK);
                g.fillOval(x - 15, y - 15, 30, 30);
                g.setColor(Color.WHITE);
                g.drawString(node.item.toString(), x - 7, y + 5);

                if (node.leftChild != null) {
                    g.setColor(Color.RED);
                    g.drawLine(x, y, x - xOffset, y + 60);
                    drawTree(g, node.leftChild, x - xOffset, y + 60, xOffset / 2);
                }

                if (node.rightChild != null) {
                    g.setColor(Color.RED);
                    g.drawLine(x, y, x + xOffset, y + 60);
                    drawTree(g, node.rightChild, x + xOffset, y + 60, xOffset / 2);
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BinaryTreeGUI frame = new BinaryTreeGUI();
            frame.setVisible(true);
        });
    }
}
