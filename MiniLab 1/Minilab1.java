/* CS2401: MINILAB 1
 * Due: by 11:59PM on Sunday January, 30
 * Where: on Gradescope -- see instructions by your TA, Nathan Aun
 */

/***********************************************************************************
 * RUBRICS:
 * For each of the problems:
 * 	- 5 pts for a correct signature of the method
 * 	- 10 pts for a correct body of the method
 * 	- 10 pts for testing the method using JUnit test cases:
 * 		2 pts per test case; 5 test cases per method
 * 		Your JUnit test cases should be written in a file called Minilab1Tester.java.
 ***********************************************************************************/

public class Minilab1 {
    public static boolean isSorted(int[] myArray) {
        int num = myArray.length;
        if (num == 1) return true;
        int index = 0;
        for (int i = 1; i < num; i++) {
            if (myArray[i] < myArray[i - 1]) {
                if(index != 0) return false;
                index = i;
            }
        }
        if(index == 0 || index == 1 || index == num - 1) return true;
        return myArray[index - 1] <= myArray[index + 1] || myArray[index - 2] <= myArray[index];
    }
    public static boolean isRowUnique(int[][] board, int n) {
        for (int i = 0; i < board[n].length; i++) {
            for (int j = i + 1; j < board[n].length; j++ ) {
                if (board[n][j] == board[n][i]) {
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean isColUnique(int[][] board, int n) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[n][i] == n) {
                    return false;
                }
            }
        }
        return true;
    }
    public static String concatIfMirrored(String str1, String str2) {
        if (str1.length() == str2.length()) {
            int n = str1.length();
            int i = 0;
            while (i < n) {

                if(str1.charAt(i) != str2.charAt(n-1-i)) {
                    return "";
                }
                return str1 + str2;
            }
        }
        return str1;
    }
    public static boolean isRowUniqueBonus (int [][] board, int n) {
        for (int i = 0; i < board[n].length; i++) {
            for (int j = i + 1; j < board[n].length; j++) {
                if (board[n][j] == board[n][i]) {
                    return false;
                }
            }
        }
        return true;
    }
}


