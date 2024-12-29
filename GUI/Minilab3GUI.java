import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Minilab3GUI {
    public static void main(String[] args) {
        // Set up the frame
        JFrame frame = new JFrame("Minilab3 Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        // Set up panels
        JPanel inputPanel = new JPanel();
        JPanel resultPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(5, 2));

        // Labels and text fields
        JLabel guessLabel = new JLabel("Max Value for Guessing Game:");
        JTextField guessField = new JTextField("26");

        JLabel arrayLabel = new JLabel("Array (comma-separated):");
        JTextField arrayField = new JTextField("1,2,3,4,5");

        // Buttons for each operation
        JButton guessButton = new JButton("Start Guessing Game");
        JButton findButton = new JButton("Find at Even");
        JButton sumButton = new JButton("Sum Diagonals");
        JButton maxProductButton = new JButton("Max Product");
        JButton sortButton = new JButton("Sort with Weird Bubble");

        // Text Area to display results
        JTextArea resultArea = new JTextArea(10, 30);
        resultArea.setEditable(false);
        resultPanel.add(new JScrollPane(resultArea));

        // Add components to the input panel
        inputPanel.add(guessLabel);
        inputPanel.add(guessField);
        inputPanel.add(arrayLabel);
        inputPanel.add(arrayField);
        inputPanel.add(guessButton);
        inputPanel.add(findButton);
        inputPanel.add(sumButton);
        inputPanel.add(maxProductButton);
        inputPanel.add(sortButton);

        // Add panels to frame
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(resultPanel, BorderLayout.CENTER);

        // Action listeners for buttons
        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int maxValue = Integer.parseInt(guessField.getText());
                int guesses = guessingGame(maxValue);
                resultArea.setText("The number of guesses is: " + guesses);
            }
        });

        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] input = arrayField.getText().split(",");
                int[] array = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
                boolean found = findAtEven(array, 3); // Example value e = 3
                resultArea.setText("Found at even indices: " + found);
            }
        });

        sumButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] input = arrayField.getText().split(",");
                int[] array = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
                int[][] matrix = new int[3][3]; // Example 3x3 matrix
                // Fill with sample data for demonstration purposes
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        matrix[i][j] = (i + 1) * (j + 1);
                    }
                }
                int sum = crossDiagonals(matrix);
                resultArea.setText("Sum of diagonals: " + sum);
            }
        });

        maxProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] input = arrayField.getText().split(",");
                int[] array = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
                int product = maxProduct(array);
                resultArea.setText("Max product is: " + product);
            }
        });

        sortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] input = arrayField.getText().split(",");
                int[] array = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
                weirdBubble(array);
                resultArea.setText("Sorted Array: " + Arrays.toString(array));
            }
        });

        frame.setVisible(true);
    }

    public static boolean findAtEven(int[] A, int e) {
        for (int i = 0; i < A.length; i += 2) {
            if (A[i] == e) {
                return true;
            }
        }
        return false;
    }

    public static int guessingGame(int maxValue) {
        int guessCounter = 0;
        int randomNumber = (int) (Math.random() * maxValue);
        for (int i = 1; i < maxValue; i++) {
            if (i == randomNumber) {
                break;
            } else {
                guessCounter++;
            }
        }
        return guessCounter;
    }

    public static int crossDiagonals(int[][] A) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i][A.length - 1 - i];
        }
        return sum;
    }

    public static int maxProduct(int[] A) {
        int maxProduct = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] * A[j] > maxProduct) {
                    maxProduct = A[i] * A[j];
                }
            }
        }
        return maxProduct;
    }

    public static void weirdBubble(int[] A) {
        boolean swap;
        int start = 0;
        int end = A.length - 1;
        while (start != end) {
            swap = bubblingUp(A, start, end);
            if (!swap) return;
            end--;
            swap = bubblingDown(A, start, end);
            if (!swap) return;
            start++;
        }
    }

    public static boolean bubblingUp(int[] A, int start, int end) {
        boolean swap = false;
        int temp;
        for (int i = start; i < end; i++) {
            if (A[i] > A[i + 1]) {
                temp = A[i];
                A[i] = A[i + 1];
                A[i + 1] = temp;
                swap = true;
            }
        }
        return swap;
    }

    public static boolean bubblingDown(int[] A, int start, int end) {
        boolean swap = false;
        int temp;
        for (int i = end - 1; i >= start + 1; i--) {
            if (A[i] < A[i - 1]) {
                temp = A[i];
                A[i] = A[i - 1];
                A[i - 1] = temp;
                swap = true;
            }
        }
        return swap;
    }
}
