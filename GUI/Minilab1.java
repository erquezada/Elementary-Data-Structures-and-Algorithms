public class Minilab1 {

    // Optimized version of isSorted method
    public static boolean isSorted(int[] myArray) {
        int num = myArray.length;
        if (num <= 1) return true;  // Arrays with 1 or fewer elements are always sorted
        for (int i = 1; i < num; i++) {
            if (myArray[i] < myArray[i - 1]) {
                return false;
            }
        }
        return true;  // Array is sorted if no violations found
    }

    // Combined unique check for rows (removing redundant code)
    public static boolean isRowUnique(int[][] board, int n) {
        for (int i = 0; i < board[n].length; i++) {
            for (int j = i + 1; j < board[n].length; j++) {
                if (board[n][i] == board[n][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    // Fixed the column check (previous version was comparing board[n][i] == n)
    public static boolean isColUnique(int[][] board, int n) {
        for (int i = 0; i < board.length; i++) {
            for (int j = i + 1; j < board.length; j++) {
                if (board[i][n] == board[j][n]) {
                    return false;
                }
            }
        }
        return true;
    }

    // Fixed and optimized concatIfMirrored method
    public static String concatIfMirrored(String str1, String str2) {
        if (str1.length() == str2.length()) {
            int n = str1.length();
            for (int i = 0; i < n; i++) {
                if (str1.charAt(i) != str2.charAt(n - 1 - i)) {
                    return "";  // Return empty string if not mirrored
                }
            }
            return str1 + str2;  // Concatenate if mirrored
        }
        return "";  // Return empty string if lengths are different
    }
}
