import java.io.*;
import java.util.Scanner;
class Lab1 {
    public static void main(String[] args) throws FileNotFoundException {
        File txtFile = new File("Lab1_Inputfile1_Quezada.txt");
        Scanner fileScanner = new Scanner(txtFile);
        int rows = 10;
        int columns = 3;
        int [][] gradeBook = new int[rows][columns];
        while(fileScanner.hasNextLine()) {
            for (rows = 0; rows < 10 ; rows++) {
                String[] line = fileScanner.nextLine().trim().split("," + " ");
                for (columns = 0; columns < 3; columns++) {
                    gradeBook[rows][columns] = Integer.parseInt(line[columns]);
                }
            }
        }
        //call helper methods
        highestMidtermScore(gradeBook);
        midtermAverage(gradeBook);
    }
    // method to calculate midterm averages
    public static void midtermAverage(int[][] gradeBook) {
        // create new array to store averages
        int rows;
        int columns;
        int[] midtermsAverage = new int[gradeBook[0].length];
        // iterate through rows and columns
        for (rows = 0; rows < gradeBook[rows].length; rows++) {
            int sum = 0;
        // calculate the average
            for (columns = 0; columns < gradeBook.length; columns++) {
                sum += gradeBook[columns][rows];
            }
            midtermsAverage[rows] = sum/gradeBook.length;
        }
        //call helper method
        printMidtermAverage(midtermsAverage);
    }
    //method to print averages
    public static void printMidtermAverage(int[] midtermsAverage) {
        //print averages
        System.out.println("Average of the first midterm: " + midtermsAverage[0]);
        System.out.println("Average of the second midterm: " + midtermsAverage[1]);
        System.out.println("Average of the third midterm: " + midtermsAverage[2]);
    }
    //method to compare the highest exam that a student scored
    public static void highestMidtermScore(int[][] gradeBook) {
        // create new array to store highest exams
        int[] studentsHighestExam = new int[gradeBook.length];
        int rows;
        int columns;
        // iterate through rows and columns
        for (rows = 0; rows < studentsHighestExam.length; rows++) {
            for (columns = 0; columns < gradeBook[0].length; columns++) {
            // compare a student's highest exam against the other midterms
                if (gradeBook[rows][columns] > studentsHighestExam[rows]) {
                    studentsHighestExam[rows] = gradeBook[rows][columns];
                }
            }
        }
        // call helper method
        printHighestMidtermScore(studentsHighestExam);
    }
    // method to print highest midterm score
    public static void printHighestMidtermScore(int[] studentsHighestExam) {
        for(int i=0; i < studentsHighestExam.length; i++){
            System.out.println("Student " + (i+1)+" highest score: " + studentsHighestExam[i]);
        }
    }
}

