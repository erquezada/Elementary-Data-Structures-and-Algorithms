public class Lecture6 {
    public static void main(String[] args) {
       /* * print anti diagonals
       * print anti diagonal sums
       *  */

        int[][] nums = {
                {1,2,3,4},
                {2,3,4,5},
                {3,4,5,6},
                {6,7,8,9}
        };
        printDiagonal(nums);
        System.out.println("The sum is: " + printDiagonalSum(nums));
    }
   public static void printDiagonal(int[][] anArray) {
        for(int row = 0; row < anArray.length; row++) {
            for(int col = 0; col < anArray[row].length; col++) {
                if(row == col)
                    System.out.print(anArray[row][col] + " ");
                else System.out.print(" ");
            }
            System.out.println();
        }
    }
    public static int printDiagonalSum(int[][] anArray) {
        int sumDiagonal = 0;
        for(int row = 0; row < anArray.length; row++) {
            for(int col = 0 ; col < anArray[row].length; col++)
                if(row == col) {
                    sumDiagonal+=anArray[row][col];
                }
                else System.out.print(" ");
        }
        System.out.println();
        return sumDiagonal;
    }
}
