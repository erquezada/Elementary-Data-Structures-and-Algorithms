import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class Lab1GUI {
    private static JTextArea textArea;
    private static int[][] gradeBook;
    private static int rows = 10;
    private static int columns = 3;

    public static void main(String[] args) {
        // Create the JFrame (window) for the GUI
        JFrame frame = new JFrame("Grade Book Analysis");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        
        // Create a JTextArea to display output
        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane);

        // Create a button to load the file and perform analysis
        JButton loadButton = new JButton("Load Grade Book");
        loadButton.addActionListener(e -> loadFileAndProcessData());

        // Layout
        JPanel panel = new JPanel();
        panel.add(loadButton);
        frame.add(panel, "North");

        frame.setVisible(true);
    }

    // Method to load the file and process the data
    public static void loadFileAndProcessData() {
        gradeBook = new int[rows][columns];

        try {
            File txtFile = new File("Lab 1 Arrays and File Reading/Lab1_Inputfile1_Quezada.txt");
            Scanner fileScanner = new Scanner(txtFile);
            int row = 0;
            while (fileScanner.hasNextLine() && row < rows) {
                String[] line = fileScanner.nextLine().trim().split(", ");
                if (line.length == columns) {
                    for (int col = 0; col < columns; col++) {
                        gradeBook[row][col] = Integer.parseInt(line[col]);
                    }
                    row++;
                } else {
                    textArea.append("Error: Invalid data format in the file.\n");
                    return;
                }
            }

            // Call helper methods
            textArea.append("Grade Book Analysis Results:\n\n");
            displayMidtermAverages();
            displayHighestMidtermScores();
            displayLowestMidtermScores();
            displayStudentAverages();

        } catch (FileNotFoundException e) {
            textArea.append("Error: File not found.\n");
        } catch (NumberFormatException e) {
            textArea.append("Error: Invalid number format in the file.\n");
        }
    }

    // Method to calculate and display the midterm averages
    public static void displayMidtermAverages() {
        for (int col = 0; col < columns; col++) {
            int sum = 0;
            for (int row = 0; row < rows; row++) {
                sum += gradeBook[row][col];
            }
            int average = sum / rows;
            textArea.append("Average score for midterm " + (col + 1) + ": " + average + "\n");
        }
    }

    // Method to display the highest score for each student
    public static void displayHighestMidtermScores() {
        for (int row = 0; row < rows; row++) {
            int highestScore = gradeBook[row][0];
            for (int col = 1; col < columns; col++) {
                if (gradeBook[row][col] > highestScore) {
                    highestScore = gradeBook[row][col];
                }
            }
            textArea.append("Student " + (row + 1) + " highest score: " + highestScore + "\n");
        }
    }

    // Method to display the lowest score for each midterm
    public static void displayLowestMidtermScores() {
        for (int col = 0; col < columns; col++) {
            int lowestScore = gradeBook[0][col];
            for (int row = 1; row < rows; row++) {
                if (gradeBook[row][col] < lowestScore) {
                    lowestScore = gradeBook[row][col];
                }
            }
            textArea.append("Lowest score for midterm " + (col + 1) + ": " + lowestScore + "\n");
        }
    }

    // Method to calculate and display the average score for each student
    public static void displayStudentAverages() {
        for (int row = 0; row < rows; row++) {
            int sum = 0;
            for (int col = 0; col < columns; col++) {
                sum += gradeBook[row][col];
            }
            int average = sum / columns;
            textArea.append("Student " + (row + 1) + " average score: " + average + "\n");
        }
    }
}
