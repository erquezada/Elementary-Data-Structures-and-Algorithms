import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Lecture1GUI {
    public static void main(String[] args) {
        // Set up the main window (JFrame)
        JFrame frame = new JFrame("Lecture1 GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new BorderLayout());

        // Create a panel to hold buttons and text output
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        frame.add(panel, BorderLayout.CENTER);

        // Create a text area for displaying the results
        JTextArea textArea = new JTextArea(10, 30);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane, BorderLayout.SOUTH);

        // Create a button to print array
        JButton printArrayButton = new JButton("Print Array");
        printArrayButton.addActionListener(e -> {
            int[] myArray = {2, 5, 7, 8};
            printArray(myArray, textArea);
        });
        panel.add(printArrayButton);

        // Create a button to modify the integer
        JButton modifyIntButton = new JButton("Modify Integer");
        modifyIntButton.addActionListener(e -> {
            int i = 10;
            myMethod_int(i, textArea);
            textArea.append("Value of 'i' after call is: " + i + "\n"); // i is not modified in main method
        });
        panel.add(modifyIntButton);

        // Create a button to modify array
        JButton modifyArrayButton = new JButton("Modify Array");
        modifyArrayButton.addActionListener(e -> {
            int[] myArray = {2, 5, 7, 8};
            myMethod2_array(myArray);
            textArea.append("Array after modification: ");
            printArray(myArray, textArea);
        });
        panel.add(modifyArrayButton);

        // Create a button to print 2D array
        JButton print2DArrayButton = new JButton("Print 2D Array");
        print2DArrayButton.addActionListener(e -> {
            int[][] aa = {
                    {10, 5, 3, 20},
                    {20, 11, 30, 50, 100, 200},
                    {25, 30}
            };
            textArea.append("\n------ 2D Array ------\n");
            print2DArray(aa, textArea);
        });
        panel.add(print2DArrayButton);

        // Create a button to print diagonal 2D array
        JButton printDiagonalButton = new JButton("Print Diagonal 2D Array");
        printDiagonalButton.addActionListener(e -> {
            int[][] cc = new int[5][];
            for (int k = 0; k < cc.length; k++) {
                cc[k] = new int[k + 1];
            }
            textArea.append("\nDiagonal array:\n");
            print2DArray(cc, textArea);
        });
        panel.add(printDiagonalButton);

        // Display the frame
        frame.setVisible(true);
    }

    // Method for printing 1D array in the text area
    static void printArray(int[] arr, JTextArea textArea) {
        textArea.append(Arrays.toString(arr).replaceAll("[\\[\\],]", "") + "\n");
    }

    // Method for printing 2D array in the text area
    public static void print2DArray(int[][] arr, JTextArea textArea) {
        for (int[] row : arr) {
            textArea.append(Arrays.toString(row).replaceAll("[\\[\\],]", "") + "\n");
        }
    }

    // Method for modifying the integer (doesn't affect the value in main method)
    public static void myMethod_int(int a, JTextArea textArea) {
        a += 3;
        textArea.append("The value of 'a' within the method is: " + a + "\n");
    }

    // Method for modifying values within the array
    public static void myMethod2_array(int[] b) {
        b[0] = b[0] + 10;
    }
}
