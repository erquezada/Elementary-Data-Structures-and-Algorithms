import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Scanner;

public class Lab8GUI {

    private static JTextArea textArea;
    private static JTextArea timeArea;
    
    public static void main(String[] args) {
        // Set up the GUI
        JFrame frame = new JFrame("Box Sorting Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);

        // Set up layout
        frame.setLayout(new BorderLayout());
        
        // Text area for displaying the boxes
        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane, BorderLayout.CENTER);
        
        // Text area for displaying the runtime summary
        timeArea = new JTextArea();
        timeArea.setEditable(false);
        timeArea.setPreferredSize(new Dimension(200, 100));
        JScrollPane timeScrollPane = new JScrollPane(timeArea);
        frame.add(timeScrollPane, BorderLayout.SOUTH);
        
        // Buttons for sorting
        JPanel buttonPanel = new JPanel();
        frame.add(buttonPanel, BorderLayout.NORTH);
        
        JButton bubbleSortButton = new JButton("Bubble Sort");
        bubbleSortButton.addActionListener(e -> performBubbleSort());
        buttonPanel.add(bubbleSortButton);
        
        JButton selectionSortButton = new JButton("Selection Sort");
        selectionSortButton.addActionListener(e -> performSelectionSort());
        buttonPanel.add(selectionSortButton);
        
        JButton mergeSortButton = new JButton("Merge Sort");
        mergeSortButton.addActionListener(e -> performMergeSort());
        buttonPanel.add(mergeSortButton);
        
        JButton reloadButton = new JButton("Reload Data");
        reloadButton.addActionListener(e -> reloadData());
        buttonPanel.add(reloadButton);
        
        // Initial data load
        reloadData();

        frame.setVisible(true);
    }
    
    /**
     * Reload the data from the input file.
     */
    private static void reloadData() {
        String fileName = "input.txt";
        Box[] allBoxes = getBoxArrayFromDataFile(fileName);

        if (allBoxes != null) {
            displayAllBoxes(allBoxes);
        } else {
            textArea.setText("No array constructed. Array is null.\n");
        }
    }

    /**
     * Perform bubble sort on the array of boxes.
     */
    private static void performBubbleSort() {
        String fileName = "input.txt";
        Box[] allBoxes = getBoxArrayFromDataFile(fileName);

        if (allBoxes != null) {
            textArea.setText("Sorting using Bubble Sort...\n");

            long start = System.nanoTime();
            bubbleSort(allBoxes);
            long end = System.nanoTime();
            long bubbleSortTime = (end - start);

            displayAllBoxes(allBoxes);
            timeArea.setText("Time taken by Bubble Sort: " + bubbleSortTime + " ns\n");
        } else {
            textArea.setText("No array constructed. Array is null.\n");
        }
    }

    /**
     * Perform selection sort on the array of boxes.
     */
    private static void performSelectionSort() {
        String fileName = "input.txt";
        Box[] allBoxes = getBoxArrayFromDataFile(fileName);

        if (allBoxes != null) {
            textArea.setText("Sorting using Selection Sort...\n");

            long start = System.nanoTime();
            selectionSort(allBoxes);
            long end = System.nanoTime();
            long selectionSortTime = (end - start);

            displayAllBoxes(allBoxes);
            timeArea.setText("Time taken by Selection Sort: " + selectionSortTime + " ns\n");
        } else {
            textArea.setText("No array constructed. Array is null.\n");
        }
    }

    /**
     * Perform merge sort on the array of boxes.
     */
    private static void performMergeSort() {
        String fileName = "input.txt";
        Box[] allBoxes = getBoxArrayFromDataFile(fileName);

        if (allBoxes != null) {
            textArea.setText("Sorting using Merge Sort...\n");

            long start = System.nanoTime();
            mergeSort(allBoxes);
            long end = System.nanoTime();
            long mergeSortTime = (end - start);

            displayAllBoxes(allBoxes);
            timeArea.setText("Time taken by Merge Sort: " + mergeSortTime + " ns\n");
        } else {
            textArea.setText("No array constructed. Array is null.\n");
        }
    }

    /**
     * Display the boxes in the text area.
     */
    private static void displayAllBoxes(Box[] theBoxes) {
        StringBuilder displayText = new StringBuilder();
        for (Box box : theBoxes) {
            displayText.append(box.toString()).append("\n");
        }
        textArea.setText(displayText.toString());
    }

    /**
     * Bubble sort the boxes based on their volume.
     * @param theBoxes
     */
    static void bubbleSort(Box[] theBoxes) {
        boolean needNextPass = true;
        for (int k = 1; k < theBoxes.length && needNextPass; k++) {
            needNextPass = false;
            for (int i = 0; i < theBoxes.length - k; i++) {
                if (theBoxes[i].compareTo(theBoxes[i + 1]) > 0) {
                    Box temp = theBoxes[i];
                    theBoxes[i] = theBoxes[i + 1];
                    theBoxes[i + 1] = temp;
                    needNextPass = true;
                }
            }
        }
    }

    /**
     * Selection sort the boxes based on their volume.
     * @param theBoxes
     */
    static void selectionSort(Box[] theBoxes) {
        for (int i = 0; i < theBoxes.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < theBoxes.length; j++) {
                if (theBoxes[minIndex].compareTo(theBoxes[j]) > 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                Box temp = theBoxes[i];
                theBoxes[i] = theBoxes[minIndex];
                theBoxes[minIndex] = temp;
            }
        }
    }

    /**
     * Merge sort the boxes based on their volume.
     * @param theBoxes
     */
    static void mergeSort(Box[] theBoxes) {
        if (theBoxes.length > 1) {
            Box[] firstHalf = new Box[theBoxes.length / 2];
            System.arraycopy(theBoxes, 0, firstHalf, 0, theBoxes.length / 2);
            mergeSort(firstHalf);

            Box[] secondHalf = new Box[theBoxes.length - firstHalf.length];
            System.arraycopy(theBoxes, firstHalf.length, secondHalf, 0, secondHalf.length);
            mergeSort(secondHalf);

            merge(firstHalf, secondHalf, theBoxes);
        }
    }

    public static void merge(Box[] list1, Box[] list2, Box[] temp) {
        int current1 = 0;
        int current2 = 0;
        int current3 = 0;
        while (current1 < list1.length && current2 < list2.length) {
            if (list1[current1].compareTo(list2[current2]) < 0)
                temp[current3++] = list1[current1++];
            else
                temp[current3++] = list2[current2++];
        }
        while (current1 < list1.length)
            temp[current3++] = list1[current1++];
        while (current2 < list2.length)
            temp[current3++] = list2[current2++];
    }

    /**
     * Load box data from the file.
     * @param fileName
     * @return
     */
    static Box[] getBoxArrayFromDataFile(String fileName) {
        Box[] myBoxes = new Box[10];
        try {
            File file = new File(fileName);
            Scanner scnr = new Scanner(file);

            for (int i = 0; i < myBoxes.length; i++) {
                myBoxes[i] = new Box(scnr.nextDouble(), scnr.nextDouble(), scnr.nextDouble());
            }
        } catch (Exception e) {
            System.out.println("Error reading the file.");
        }
        return myBoxes;
    }
}
