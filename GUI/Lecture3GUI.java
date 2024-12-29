import javax.swing.*;
import java.awt.*;

public class Lecture3GUI extends JFrame {
    private JTextArea outputArea;
    private JButton runButton;

    public Lecture3GUI() {
        setTitle("Lecture 3: Arrays and Methods");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set up the layout
        setLayout(new BorderLayout());

        // Create a text area to display output
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        add(scrollPane, BorderLayout.CENTER);

        // Create a button to trigger the methods
        runButton = new JButton("Run Code");
        runButton.addActionListener(e -> runCode());
        add(runButton, BorderLayout.SOUTH);
    }

    private void runCode() {
        // Clear the output area
        outputArea.setText("");

        // Create an array and perform operations
        int i = 10;
        int[] myArray = {2, 5, 7, 8};
        printArray(myArray);
        myMethod_int(i);
        outputArea.append("Value of 'i' in main method after call is: " + i + "\n");

        // Passing array to a method
        myMethod2_array(myArray);
        outputArea.append("Value of array at index zero after method call is: " + myArray[0] + "\n");
        printArray(myArray);

        // 2D Array
        outputArea.append("\n------ 2D Array ------\n");
        int[][] aa = {
                {10, 5, 3, 20},
                {20, 11, 30, 50, 100, 200},
                {25, 30}
        };
        int[][] bb = new int[3][4];
        print2DArray(aa);
        outputArea.append("\nAnother 2D Array\n");
        print2DArray(bb);

        int[][] cc = new int[5][];
        for (int k = 0; k < cc.length; k++) {
            cc[k] = new int[k + 1];
        }
        outputArea.append("Diagonal array\n");
        print2DArray(cc);
    }

    private void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            outputArea.append(arr[i] + " ");
        }
        outputArea.append("\n");
    }

    private void print2DArray(int[][] arr) {
        for (int row = 0; row < arr.length; row++) {
            for (int column = 0; column < arr[row].length; column++) {
                outputArea.append(arr[row][column] + " ");
            }
            outputArea.append("\n");
        }
    }

    private void myMethod_int(int a) {
        a += 3;
        outputArea.append("The value of 'a' within the method is: " + a + "\n");
    }

    private void myMethod2_array(int[] b) {
        b[0] = b[0] + 10;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Lecture3GUI gui = new Lecture3GUI();
            gui.setVisible(true);
        });
    }
}
