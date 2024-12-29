import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;

public class Lab2Prep {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println();

        // array one
        int[][] sampleArray = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println();
        print2DArray(sampleArray);

        // array two
        int[][] sampleArrayTwo = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println();
        print2DArray(sampleArrayTwo);

        System.out.println();
        rowSimilarity(sampleArray, sampleArrayTwo);
        columnSimilarity(sampleArray, sampleArrayTwo);
        createMultiplicationTable();
        readMultiplicationTable();
        printLowerTriangle(sampleArray);
    }

    public static void print2DArray(int[][] sampleArray) {
        System.out.println("This is method one: print2DArray");
        for (int row = 0; row < sampleArray.length; row++) {
            for (int column = 0; column < sampleArray[row].length; column++) {
                System.out.print(sampleArray[row][column] + " ");
            }
            System.out.println();  // Add a new line after each row
        }
    }

    public static void rowSimilarity(int[][] sampleArray, int[][] sampleArrayTwo) {
        System.out.println("This is method two: rowSimilarity");
        for (int i = 0; i < sampleArray.length; i++) {
            for (int j = 0; j < sampleArrayTwo.length; j++) {
                if (Arrays.equals(sampleArray[i], sampleArrayTwo[j])) {
                    System.out.println("Row " + i + " in first array is similar to row " + j + " in second array");
                }
            }
        }
    }

    public static void columnSimilarity(int[][] sampleArray, int[][] sampleArrayTwo) {
        System.out.println("This is method three: columnSimilarity");
        for (int i = 0; i < sampleArray[0].length; i++) {
            int[] col = getColumn(sampleArray, i);
            for (int j = 0; j < sampleArrayTwo[0].length; j++) {
                int[] colTwo = getColumn(sampleArrayTwo, j);
                if (Arrays.equals(col, colTwo)) {
                    System.out.println("Column " + i + " in first array is similar to column " + j + " in second array");
                }
            }
        }
    }

    private static int[] getColumn(int[][] array, int column) {
        int[] col = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            col[i] = array[i][column];
        }
        return col;
    }

    public static void createMultiplicationTable() {
        System.out.println("This is method four: createMultiplicationTable");
        System.out.println("Input a number to use as the limit to the multiplication table");
        System.out.println("Input a number to see its multiplication table up to the number you have chosen.");

        try (Scanner userInput = new Scanner(System.in)) {
            int multiplicand = userInput.nextInt();
            int upperLimit = userInput.nextInt();

            for (int multiplier = 1; multiplier <= upperLimit; multiplier++) {
                int product = multiplicand * multiplier;
                System.out.println(product);
            }
        }
    }

    public static void readMultiplicationTable() throws FileNotFoundException {
        System.out.println("This is method five: readMultiplicationTable");
        File txtFile = new File("Lab 2 2D Arrays and File Reading /3.txt");
        Scanner fileScanner = new Scanner(txtFile);
        int[][] threeTimesMultiplicationTable = new int[12][3];

        int row = 0;
        while (fileScanner.hasNextLine() && row < 12) {
            String[] line = fileScanner.nextLine().trim().split(",\\s*");
            for (int col = 0; col < 3; col++) {
                threeTimesMultiplicationTable[row][col] = Integer.parseInt(line[col]);
            }
            row++;
        }

        System.out.println(Arrays.deepToString(threeTimesMultiplicationTable));
        fileScanner.close();  // Make sure to close the scanner
    }

    public static void printLowerTriangle(int[][] sampleArray) {
        System.out.println("This is method six: printLowerTriangle");
        for (int row = 0; row < sampleArray.length; row++) {
            for (int column = 0; column <= row; column++) {
                System.out.print(sampleArray[row][column] + " ");
            }
            System.out.println();
        }
    }
}
