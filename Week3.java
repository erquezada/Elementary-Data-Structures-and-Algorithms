import java.util.Scanner;
public class Week3 {
    public static void main(String[] args) {
        System.out.println(sumMatrix());

        System.out.println("");
        System.out.println("The difference for this array is: ");
        int [] maxArray = {1, 3, 70, 9, 101, 300, 125};
        System.out.println(maxDifference(maxArray, 7));

        System.out.println("");
        Scanner uniqueNumElement = new Scanner(System.in);
        int [][] uniqueArray = {
                {1,2,2,3},
                {3,4,1,2},
        };
        System.out.println("");
        int num = uniqueNumElement.nextInt();
        System.out.println(isElementUnique(uniqueArray, num));

        System.out.println("");
        int [] myArray = {1,2,3,4,5};
        int target = 4;
        System.out.println(findElement(myArray, target));
    }
    public static int sumMatrix() {
        int n;
        int M [][];
        int total = 0;
        Scanner scnr = new Scanner(System.in);

        System.out.println("Enter the size of the square matrix: " );
        n = scnr.nextInt();

        M = new int[n][n];

        System.out.println("Enter the " + (n*n) + " Elements of the matrix");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                M[i][j] = scnr.nextInt();
                if (i == j) total += M[i][j];
            }
        }
        System.out.println("Matrix: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(M[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("The sum of the diagonal elements of the matrix array is : ");
        return total;
    }
    public static int maxDifference(int[] maxArray, int arraySize) {
        // 1D array
        int maxDifference = maxArray[1] - maxArray[0];
        for (int i = 0; i < arraySize; i++) {
            for (int j = i + 1; j < arraySize; j++) {
                if(maxArray[j] - maxArray[i] > maxDifference)
                    maxDifference = maxArray[j] - maxArray[i];
            }
        }
        return maxDifference;
    }
    public static boolean isElementUnique(int [][] uniqueArray, int num) {
        for (int i = 0; i < uniqueArray[num].length; i++) {
            for (int j = i + 1; j < uniqueArray[num].length; j++ ) {
                if (uniqueArray[num][j] == uniqueArray[num][i]) {
                    return false;
                }
            }
        }
        return true;
    }
    public static int findElement (int[] myArray, int target) {
        for (int i = 0; i < myArray.length; i++) {
            if(myArray[i] == target) {
                return i;
            }
        }
        return -1;
    }
}