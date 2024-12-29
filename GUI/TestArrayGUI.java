import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestArrayGUI {

    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Test Array GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(new BorderLayout());

        // Create the text area to display results
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Create a button to run the example
        JButton button = new JButton("Run Test");
        frame.add(button, BorderLayout.SOUTH);

        // Action listener to run the example when button is clicked
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");  // Clear previous results
                int i = 10;
                int[] myArray = {2, 5, 7, 8};
                printArray(myArray, textArea);

                myMethod_int(i, textArea);
                textArea.append("i in main after the method call: " + i + "\n");

                // passing an array to a method
                myMethod_array(myArray);
                textArea.append("myArray after the method call: " + myArray[0] + "\n");
                printArray(myArray, textArea);

                textArea.append("\n------------ 2D array------------\n");

                // 2D array
                int[][] aa = {
                        {10, 5, 3, 20},
                        {20, 11, 30, 50, 100, 200},
                        {25, 30}
                };

                int[][] bb = new int[3][4];

                print2DArray(aa, textArea);
                textArea.append("\nAnother 2D array\n");
                print2DArray(bb, textArea);

                int[][] cc = new int[5][];
                for (int k = 0; k < cc.length; k++) {
                    cc[k] = new int[k + 1];
                }

                textArea.append("\nDiagonal 2D array\n");
                print2DArray(cc, textArea);

                // New function calls
                textArea.append("\n------------ Array Sum ------------\n");
                textArea.append("Sum of myArray: " + arraySum(myArray) + "\n");

                textArea.append("\n------------ Array Average ------------\n");
                textArea.append("Average of myArray: " + arrayAverage(myArray) + "\n");

                textArea.append("\n------------ Array Reverse ------------\n");
                textArea.append("Reversed myArray: ");
                arrayReverse(myArray, textArea);

                textArea.append("\n------------ 2D Array Sum ------------\n");
                textArea.append("Sum of 2D array aa: " + array2DSum(aa) + "\n");

                textArea.append("\n------------ Maximum Value in Array ------------\n");
                textArea.append("Maximum value in myArray: " + findMax(myArray) + "\n");

                textArea.append("\n------------ Transpose 2D Array ------------\n");
                textArea.append("Transpose of aa:\n");
                transpose2DArray(aa, textArea);
            }
        });

        // Show the frame
        frame.setVisible(true);
    }

    // Method to print 1D array to text area
    public static void printArray(int[] arr, JTextArea textArea) {
        for (int i = 0; i < arr.length; i++) {
            textArea.append(arr[i] + " ");
        }
        textArea.append("\n");
    }

    // Method to print 2D array to text area
    public static void print2DArray(int[][] arr, JTextArea textArea) {
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                textArea.append(arr[row][col] + " ");
            }
            textArea.append("\n");
        }
    }

    // Method to modify an integer and print it
    public static void myMethod_int(int a, JTextArea textArea) {
        a += 3;
        textArea.append("The value of a within the method is: " + a + "\n");
    }

    // Method to modify an array and print the result
    public static void myMethod_array(int[] b) {
        b[0] = b[0] + 10;
    }

    // New function to sum elements of a 1D array
    public static int arraySum(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }

    // New function to calculate the average of a 1D array
    public static double arrayAverage(int[] arr) {
        if (arr.length == 0) return 0;
        int sum = arraySum(arr);
        return (double) sum / arr.length;
    }

    // New function to reverse a 1D array
    public static void arrayReverse(int[] arr, JTextArea textArea) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        printArray(arr, textArea);
    }

    // New function to sum elements of a 2D array
    public static int array2DSum(int[][] arr) {
        int sum = 0;
        for (int[] row : arr) {
            for (int num : row) {
                sum += num;
            }
        }
        return sum;
    }

    // New function to find the maximum value in a 1D array
    public static int findMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    // New function to transpose a 2D array
    public static void transpose2DArray(int[][] arr, JTextArea textArea) {
        int rows = arr.length;
        int cols = arr[0].length;

        int[][] transposed = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposed[j][i] = arr[i][j];
            }
        }
        print2DArray(transposed, textArea);
    }
}
