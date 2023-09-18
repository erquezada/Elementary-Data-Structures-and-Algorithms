import java.util.Arrays;

public class MyClass {
  //  For the following 2D array, complete the following method body so that the method prints the rows whose sum is less than 100.
    public static void main(String[] args) {
        int[][] table = {
                {21, 62, 39},
                {49, 17, 12},
                {42, 25, 93}
        };
        printSum(table);
        printOdd(table);

        printEven(table);
    }
    public static void printSum (int[][] mat){
        int sum = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                sum += mat[i][j];
            }
            if (sum <= 100) {
                System.out.println(Arrays.toString(mat[i]));
            }
            sum = 0;
        }
    }
    public static void printOdd(int[][] mat){
        for (int i = 0; i <mat.length; i++) {
            for (int j = 0; j <mat[i].length; j++) {
                if(mat[i][j]%2==1) System.out.print(mat[i][j] + " ");
                else System.out.print("-");
            }
            System.out.println();
        }
    }
    public static void printEven(int[][] mat){
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if(mat[i][j]%2==0) System.out.println(mat[i][j] + " ");
                else System.out.print("-");
            }
            System.out.println();
        }
    }
}