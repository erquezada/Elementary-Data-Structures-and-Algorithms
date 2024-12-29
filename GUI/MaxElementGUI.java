import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MaxElementGUI {

    // Array of integers
    static int arr[] = {10, 324, 45, 90, 9808};

    // Method to find the largest element in arr[]
    static int largest() {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        return max;
    }

    // Method to find the smallest element in arr[]
    static int smallest() {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min)
                min = arr[i];
        }
        return min;
    }

    // Method to find the sum of all elements in arr[]
    static int sum() {
        int total = 0;
        for (int num : arr) {
            total += num;
        }
        return total;
    }

    // Method to find the average of the elements in arr[]
    static double average() {
        return sum() / (double) arr.length;
    }

    public static void main(String[] args) {
        // Create a JFrame window
        JFrame frame = new JFrame("Array Operations");

        // Create a JLabel to display the result
        JLabel label = new JLabel("Choose an operation.", SwingConstants.CENTER);
        label.setBounds(50, 50, 300, 30);

        // Create buttons for each operation
        JButton largestButton = new JButton("Find Largest");
        largestButton.setBounds(120, 100, 150, 30);

        JButton smallestButton = new JButton("Find Smallest");
        smallestButton.setBounds(120, 140, 150, 30);

        JButton sumButton = new JButton("Find Sum");
        sumButton.setBounds(120, 180, 150, 30);

        JButton averageButton = new JButton("Find Average");
        averageButton.setBounds(120, 220, 150, 30);

        // Action listener for the "Find Largest" button
        largestButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int max = largest();
                label.setText("Largest element: " + max);
            }
        });

        // Action listener for the "Find Smallest" button
        smallestButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int min = smallest();
                label.setText("Smallest element: " + min);
            }
        });

        // Action listener for the "Find Sum" button
        sumButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int total = sum();
                label.setText("Sum of elements: " + total);
            }
        });

        // Action listener for the "Find Average" button
        averageButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double avg = average();
                label.setText("Average: " + avg);
            }
        });

        // Set layout to null for absolute positioning
        frame.setLayout(null);

        // Add components to the frame
        frame.add(label);
        frame.add(largestButton);
        frame.add(smallestButton);
        frame.add(sumButton);
        frame.add(averageButton);

        // Set up the frame
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Center the window
        frame.setVisible(true);
    }
}
