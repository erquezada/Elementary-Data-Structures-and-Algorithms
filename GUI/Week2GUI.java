import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Week2GUI extends JFrame {

    private JTextArea textArea;

    public Week2GUI() {
        // Set up the frame
        setTitle("Week 2 Problems");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create a text area to display results
        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        // Create buttons for each problem
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1));

        JButton button1 = new JButton("Problem 1: Reverse Array");
        JButton button2 = new JButton("Problem 2: Check Duplicates");
        JButton button3 = new JButton("Problem 3: Max Difference");
        JButton button4 = new JButton("Problem 4: 2D Array");
        JButton button5 = new JButton("Problem 5: Double Characters");
        JButton button6 = new JButton("Problem 6: Double Characters 2");

        // Add buttons to the panel
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(button5);
        panel.add(button6);
        add(panel, BorderLayout.EAST);

        // Add action listeners to buttons
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] A = {1, 2, 3, 4, 5};
                int[] C = reverse(A);
                textArea.setText("Original Array: " + Arrays.toString(A) + "\nReversed Array: " + Arrays.toString(C));
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] myArray = {1, 2, 3, 4, 5, 6};
                boolean hasDuplicates = checkForDuplicates(myArray);
                textArea.setText("Array has duplicates: " + hasDuplicates);
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] maxArray = {1, 3, 7, 9, 101};
                int maxDiff = checkMaxDifference(maxArray, maxArray.length);
                textArea.setText("Max Difference: " + maxDiff);
            }
        });

        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[][] b = {
                        {1, 2, 2, 7, 8},
                        {1, 2, 3, 4, 5, 6, 7, 8, 9},
                        {1, 3, 4, 5, 6, 7, 8, 9}};
                textArea.setText("2D Array Displayed.\n" + Arrays.deepToString(b));
            }
        });

        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String result = doubleCharacters("abc");
                textArea.setText("Double Characters: " + result);
            }
        });

        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String result = doubleCharacters2("abbcdde");
                textArea.setText("Double Characters 2: " + result);
            }
        });
    }

    // Methods from the original code
    public static int[] reverse(int[] A) {
        int[] B = new int[A.length];
        int j = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            B[j] = A[i];
            j++;
        }
        return B;
    }

    public static boolean checkForDuplicates(int[] myArray) {
        for (int i = 0; i < myArray.length; i++) {
            for (int j = i + 1; j < myArray.length; j++) {
                if (myArray[i] == myArray[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int checkMaxDifference(int[] maxArray, int arraySize) {
        int maxDifference = maxArray[1] - maxArray[0];
        for (int i = 0; i < arraySize; i++) {
            for (int j = i + 1; j < arraySize; j++) {
                if (maxArray[j] - maxArray[i] > maxDifference)
                    maxDifference = maxArray[j] - maxArray[i];
            }
        }
        return maxDifference;
    }

    public static String doubleCharacters(String str) {
        String finalString = "";
        for (int i = 0; i < str.length(); i++) {
            char x = str.charAt(i);
            finalString = finalString + x + x;
        }
        return finalString;
    }

    public static String doubleCharacters2(String str) {
        String finalString = "";
        for (int i = 0; i < str.length(); i++) {
            char x = str.charAt(i);
            if ((i + 1) >= str.length()) {
                if (str.charAt(i) == str.charAt(i - 1)) {
                    return finalString + x;
                } else {
                    return finalString + x + x;
                }
            }
            if (str.charAt(i) == str.charAt(i + 1)) {
                finalString = finalString + x + x;
                i++;
            } else {
                finalString = finalString + x + x;
            }
        }
        return finalString;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Week2GUI frame = new Week2GUI();
                frame.setVisible(true);
            }
        });
    }
}
