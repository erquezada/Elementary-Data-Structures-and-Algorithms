import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.lang.Math;

public class SearchGUI {
    public static void main(String[] args) {
        // Initialize the JFrame
        JFrame frame = new JFrame("Search Algorithm Performance");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        // Create components
        JTextArea resultArea = new JTextArea();
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);

        JButton startButton = new JButton("Start Search");
        startButton.addActionListener(e -> runSearchAlgorithms(resultArea));

        // Layout setup
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(startButton, BorderLayout.SOUTH);

        // Display the frame
        frame.add(panel);
        frame.setVisible(true);
    }

    public static void runSearchAlgorithms(JTextArea resultArea) {
        // generate a random array of doubles
        double[] sampleArray = new double[100000];
        int max = sampleArray.length;
        int min = 1;
        int range = max - min + 1;

        for (int i = 0; i < sampleArray.length; i++) {
            sampleArray[i] = (Math.random() * range) + min;
        }
        double indexer = Math.floor(sampleArray[(int) (Math.random() * range) + min]);

        // Display the number we're looking for
        resultArea.setText("The number we are looking for: " + indexer + "\n");

        // Run the search algorithms and display the results
        resultArea.append("-------\n");

        // Linear Search performance
        long sum = 0;
        for (int i = 0; i <= 20; i++) {
            long start = System.nanoTime();
            iterativeLinearSearch(sampleArray, indexer);
            long end = System.nanoTime();
            sum += end - start;
        }
        long averageLinear = sum / 20;
        resultArea.append("Linear Search run time is: " + averageLinear + " ns\n");

        // Sorting performance
        long sumSortingArray = 0;
        for (int i = 0; i <= 20; i++) {
            long begin = System.nanoTime();
            Arrays.sort(sampleArray);
            long finish = System.nanoTime();
            sumSortingArray += finish - begin;
        }
        long averageSortingTime = sumSortingArray / 20;
        resultArea.append("Arrays.sort run time: " + averageSortingTime + " ns\n");

        // Recursive Binary Search performance
        long sumRecursive = 0;
        for (int i = 0; i <= 20; i++) {
            long startRecursive = System.nanoTime();
            recursiveBinarySearch(sampleArray, indexer);
            long endRecursive = System.nanoTime();
            sumRecursive += endRecursive - startRecursive;
        }
        long averageRecursive = sumRecursive / 20;
        resultArea.append("Recursive Binary Search Run time is: " + averageRecursive + " ns\n");

        // Iterative Binary Search performance
        long sumIterativeBinary = 0;
        for (int i = 0; i <= 20; i++) {
            long startIterativeBinary = System.nanoTime();
            iterativeBinarySearch(sampleArray, indexer);
            long endIterativeBinary = System.nanoTime();
            sumIterativeBinary += endIterativeBinary - startIterativeBinary;
        }
        long averageIterative = sumIterativeBinary / 20;
        resultArea.append("Iterative Binary Search Run time is: " + averageIterative + " ns\n");
    }

    public static int iterativeLinearSearch(double[] myArray, double key) {
        for (int i = 0; i < myArray.length; i++) {
            if (myArray[i] == key) {
                return i; // return the index position where the key was found
            }
        }
        return -1; // if not found return -1
    }

    public static int recursiveBinarySearch(double[] myArray, double key) {
        int low = 0;
        int high = myArray.length - 1;
        return recursiveBinarySearch(myArray, key, low, high);
    }

    public static int recursiveBinarySearch(double[] myArray, double key, int low, int high) {
        if (low > high) return -low - 1; 
        int mid = (low + high) / 2;
        if (key < myArray[mid]) return recursiveBinarySearch(myArray, key, low, mid - 1);
        else if (key == myArray[mid]) return mid;
        else return recursiveBinarySearch(myArray, key, mid + 1, high);
    }

    public static int iterativeBinarySearch(double[] myArray, double key) {
        int low = 0;
        int high = myArray.length - 1;
        int mid;
        while (high >= low) {
            mid = (low + high) / 2;
            if (key < myArray[mid]) high = mid - 1;
            else if (key == myArray[mid]) return mid;
            else low = mid + 1;
        }
        return -low - 1;
    }
}
