import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lab2 {
    // used as a key for checking the correct answers of multiplication table
    static int[][] multiplicationKey = {
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12},
            {2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24},
            {3, 6, 9, 12, 15, 18, 21, 24, 27, 30, 33, 36},
            {4, 8, 12, 16, 20, 24, 28, 32, 36, 40, 44, 48},
            {5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60},
            {6, 12, 18, 24, 30, 36, 42, 48, 54, 60, 66, 72},
            {7, 14, 21, 28, 35, 42, 49, 56, 63, 70, 77, 84},
            {8, 16, 24, 32, 40, 48, 56, 64, 72, 80, 88, 96},
            {9, 18, 27, 36, 45, 54, 63, 72, 81, 90, 99, 108},
            {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120},
            {11, 22, 33, 44, 55, 66, 77, 88, 99, 110, 121, 132},
            {12, 24, 36, 48, 60, 72, 84, 96, 108, 120, 132, 144}
    };
    //main method
    public static void main(String[] args) throws FileNotFoundException {
        File txtFile = new File("input.txt");
        Scanner fileScanner = new Scanner(txtFile);
        int rows = 12;
        int columns = 12;
        int [][] twelveTimesMultTable = new int[rows][columns];
        while(fileScanner.hasNextLine()) {
            for (rows = 0; rows < 12 ; rows++) {
                String[] line = fileScanner.nextLine().trim().split("," + " ");
                for (columns = 0; columns < 12; columns++) {
                    twelveTimesMultTable[rows][columns] = Integer.parseInt(line[columns]);
                }
            }
        }
        //call count mistake method
        System.out.println("The total number of mistakes are: " + countMistake(twelveTimesMultTable));

        //call isRowCorrect method
        Scanner userInputScanner = new Scanner(System.in);
        System.out.println("Select a row");
        int userInputRow = userInputScanner.nextInt();
        System.out.println(isRowCorrect(twelveTimesMultTable, userInputRow));

        //call isColumnCorrect method
        System.out.println("Select a column");
        int userInputColumn = userInputScanner.nextInt();
        System.out.println(isColumnCorrect(twelveTimesMultTable, userInputColumn));

        //call printLowerTriangle method
        printLowerTriangle(twelveTimesMultTable);
    }
    // method to count the number of mistakes
    public static int countMistake(int[][] twelveTimesMultTable) {
        int row;
        int column;
        int counter = 0;
        for (row = 0; row < twelveTimesMultTable.length; row++){
            for(column = 0; column < twelveTimesMultTable[row].length; column++) {
                if(twelveTimesMultTable[row][column] != multiplicationKey[row][column]){
                    counter+=1;
                    System.out.println("Line " + row + ", column " + column + ": " + twelveTimesMultTable[row][column] + " is incorrect should be: " + multiplicationKey[row][column]);
                }
            }
        }
        return counter;
    }
    // method to see if row is correct
    public static boolean isRowCorrect(int[][] twelveTimesMultTable,int userInputRow) {
        for (int column = 0; column < twelveTimesMultTable[userInputRow].length; column++) {
                if (twelveTimesMultTable[userInputRow][column] != multiplicationKey[userInputRow][column]) {
                    return false;
                }
        }
        return true;
    }
    // method to see if column is correct
   public static boolean isColumnCorrect(int[][] twelveTimesMultTable, int userInputColumn) {
        for(int row = 0; row < twelveTimesMultTable.length; row++) {
            for(int column = 0; column < twelveTimesMultTable[userInputColumn].length; column++) {
                if(twelveTimesMultTable[userInputColumn][row] != multiplicationKey[userInputColumn][row]) {
                    return false;
                }
            }
        }
        return true;
    }
    // method to print lower triangle
    public static void printLowerTriangle(int[][] twelveTimesMultTable) {
        for (int row = 0; row < twelveTimesMultTable.length; row++) {
            for (int column = 0; column < twelveTimesMultTable[0].length; column++) {
                if(twelveTimesMultTable[row][column] == multiplicationKey[row][column]) {
                    if (row >= column) {
                        System.out.print(twelveTimesMultTable[row][column] + " ");
                    }
                }
            }
            System.out.println();
        }
    }
}

