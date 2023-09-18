import java.util.Arrays;

public class ArraysPractice {

    public static void main(String[] args) {
	// write your code here
        int[] myArray = {1,2,3,4,5,6,7,8,9,10};
        int[][] myMatrix = {
                                {1,2,3,4},
                                {5,6,7,8},
                                {9,10,11,12},
                                {13,14,15,16}
                            };
        System.out.println("Sum of 1D array: "+ sum(myArray));
        System.out.println("Sum of 2D array: " + sum2D(myMatrix));
        System.out.println("Sum of diagonal elements: " + sumDiagonal(myMatrix));
        System.out.println("Sum of a row: " + sumRow(myMatrix));
        System.out.println("Sum of a column: " + sumCol(myMatrix));

        System.out.println("Product of 1D array: " + product(myArray));
        System.out.println("Product of 2D array: " + product2D(myMatrix));
        System.out.println("Product of diagonal elements: " + productDiagonal(myMatrix));
        System.out.println("Product of a row: " + productRow(myMatrix));
        System.out.println("Product of a column: " + productCol(myMatrix));

        System.out.println("Average of 1D array: " + average(myArray));
        System.out.println("Average of 2D array: " + averageMatrix(myMatrix));
        System.out.println("Average of a row: " + averageRow(myMatrix));
        System.out.println("Average of a column: " + averageCol(myMatrix));
        System.out.println("Average of a diagonal: " + averageDiagonal(myMatrix));

        System.out.println("Minimum value in 1D array: " + min(myArray));
        System.out.println("Minimum value in 2D array: " + minMatrix(myMatrix));
        System.out.println("Minimum value of a row: " + minRow(myMatrix));
        System.out.println("Minimum value of a column: " + minCol(myMatrix));
        System.out.println("Minimum value of a diagonal: " + minDiagonal(myMatrix));

        System.out.println("Maximum value in 1D array: " + max(myArray));
        System.out.println("Maximum value in 2D array: " + maxMatrix(myMatrix));
        System.out.println("Maximum value of a row: " + maxRow(myMatrix));
        System.out.println("Maximum value of a column: " + maxCol(myMatrix));
        System.out.println("Maximum value of a diagonal: " + maxDiagonal(myMatrix));

        System.out.println();
        System.out.println("Printing 1D array: ");
        printForwards(myArray);
        System.out.println();
        System.out.println("Printing 1D array backwards: ");
        printBackwards(myArray);
        System.out.println();
        System.out.println("Printing odd values of 1D array: ");
        findOdd(myArray);
        System.out.println();
        System.out.println("Printing even values of 1D array: ");
        findEven(myArray);
        System.out.println();

        System.out.println("Printing 2D array: ");
        printForwardsMatrix(myMatrix);
        System.out.println();
        System.out.println("Printing 2D array backwards: ");
        printBackwardsMatrix(myMatrix);
        System.out.println();
        System.out.println("Printing diagonal elements of 2D array:");
        printDiagonal(myMatrix);
        System.out.println();
        System.out.println("Printing odd values of 2D array: ");
        findOddMatrix(myMatrix);

        System.out.println();
        System.out.println("Printing even values of 2D array: ");
        findEvenMatrix(myMatrix);
        System.out.println();
        System.out.println("Printing a row from 2D array: ");
        printRow(myMatrix);
        System.out.println();
        System.out.println("Printing a column from 2D array: ");
        printCol(myMatrix);
        System.out.println();
        int[][] findItMatrix = {
                                    {1,2,2,1},
                                    {2,5,1,3},
                                    {4,3,5,3},
                                    {4,7,9,1}
                                };
        findIt(findItMatrix,3);
    }
    public static int sum(int[] arr) { // 1D Array, iterative
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
    public static int sum2D(int[][] mat) { // 2D Array, iterative
        int sum = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                sum += mat[i][j];
            }
        }
        return sum;
    }
    public static int sumDiagonal(int[][] mat) {
        int sum = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if(i == j) {
                    sum += mat[i][j];
                }
            }
        }
        return sum;
    }
    public static int sumRow(int[][] mat) {
        int sum = 0;
        for (int i = 0; i < mat.length; i++) {
            sum += mat[1][i];
        }
        return sum;
    }
    public static int sumCol(int[][] mat){
        int sum = 0;
        for (int i = 0; i < mat.length; i++) {
            sum += mat[i][0];
        }
        return sum;
    }
    public static int product(int[] arr) {
        int product = 1;
        for (int i = 0; i < arr.length; i++) {
            product = product * arr[i];
        }
        return product;
    }
    public static int product2D(int[][] mat) { // 2D Array, iterative
        int product = 1;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                product = product * mat[i][j];
            }
        }
        return product;
    }
    public static int productDiagonal(int[][] mat) {
        int product = 1;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if(i == j) {
                    product = product * mat[i][j];
                }
            }
        }
        return product;
    }
    public static int productRow(int[][] mat) {
        int product = 1;
        for (int i = 0; i < mat.length; i++) {
            product = product * mat[1][i];
        }
        return product;
    }
    public static int productCol(int[][] mat){
        int product = 1;
        for (int i = 0; i < mat.length; i++) {
            product = product * mat[i][0];
        }
        return product;
    }
    public static int average(int[] arr) {
        int average;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        average = sum / arr.length;
        return average;
    }
    public static double averageMatrix(int[][] mat) {
        int countElements = 0;
        double average;
        double sum = 0;
        for (int i = 0; i < mat.length; i++){
            for (int j = 0; j < mat[i].length; j++) {
                sum += mat[i][j];
                countElements++;
            }
        }
        average = sum / countElements;
        return average;
    }
    public static double averageRow(int[][] mat) {
        int countElements = 0;
        double average;
        double sum = 0;
        for (int i = 0; i < mat.length; i++) {
            sum += mat[1][i];
            countElements++;
        }
        average = sum /countElements;
        return average;
    }
    public static double averageCol(int[][] mat){
        int countElements = 0;
        double average;
        double sum = 0;
        for (int i = 0; i < mat.length; i++) {
            sum += mat[i][0];
            countElements++;
        }
        average = sum /countElements;
        return average;
    }
    public static double averageDiagonal(int[][] mat) {
        double sum = 0;
        double average;
        int countElements = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if(i == j) {
                    sum += mat[i][j];
                    countElements++;
                }
            }
        }
        average = sum / countElements;
        return average;
    }
    public static int min(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }
    public static int minMatrix(int[][] mat) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if(mat[i][j] < min) {
                min = mat[i][j];
                }
            }
        }
        return min;
    }
    public static int minRow(int[][] mat) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] < min) {
                    min = mat[2][j];
                }
            }
        }
        return min;
    }
    public static int minCol(int[][] mat) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[j][i] < min) {
                    min = mat[i][1];
                }
            }
        }
        return min;
    }
    public static int minDiagonal(int[][] mat) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if(i == j) {
                    int holderOne = mat[0][0];
                    int holderTwo = mat[1][1];
                    int holderThree = mat[2][2];
                    int holderFour = mat[3][3];
                    int[] diagonals = {holderOne, holderTwo, holderThree, holderFour};
                    for (int k = 0; k < diagonals.length; k++) {
                        if(diagonals[k] < min) {
                            min = diagonals[k];
                        }
                    }
                }
            }
        }
        return min;
    }
    public static int max(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
    public static int maxMatrix(int[][] mat) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if(mat[i][j] > max) {
                    max = mat[i][j];
                }
            }
        }
        return max;
    }
    public static int maxRow(int[][] mat) {
        int min = Integer.MIN_VALUE;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] > min) {
                    min = mat[2][j];
                }
            }
        }
        return min;
    }
    public static int maxCol(int[][] mat) {
        int min = Integer.MIN_VALUE;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[j][i] > min) {
                    min = mat[i][2];
                }
            }
        }
        return min;
    }
    public static int maxDiagonal(int[][] mat) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if(i == j) {
                    int holderOne = mat[0][0];
                    int holderTwo = mat[1][1];
                    int holderThree = mat[2][2];
                    int holderFour = mat[3][3];
                    int[] diagonals = {holderOne, holderTwo, holderThree, holderFour};
                    for (int k = 0; k < diagonals.length; k++) {
                        if(diagonals[k] > max) {
                            max = diagonals[k];
                        }
                    }
                }
            }
        }
        return max;
    }
    public static void findEven(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]%2==0) {
                System.out.print(arr[i]+ ", ");
            }
        }
    }
    public static void findEvenMatrix(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                if(mat[i][j]%2==0) {
                    System.out.print(mat[i][j]+ ", ");
                }
            }
            System.out.println();
        }
    }
    public static void findOdd(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]%2!=0) {
                System.out.print(arr[i]+ ", ");
            }
        }
    }
    public static void findOddMatrix(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                if(mat[i][j]%2!=0) {
                    System.out.print(mat[i][j]+ ", ");
                }
            }
            System.out.println();
        }
    }
    public static void printForwards(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
    }
    public static void printForwardsMatrix(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                System.out.print(mat[i][j] + ", ");
            }
            System.out.println();
        }
    }
    public static void printDiagonal(int[][] mat) {
        for(int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                if (i == j) {
                    System.out.print(mat[i][j] + ", ");
                }
            }
        }
    }
    public static void printBackwards(int[] arr) {
        for(int i = arr.length-1; i >= 0; i--) {
            System.out.print(arr[i]+ ", ");
        }
    }
    public static void printBackwardsMatrix(int[][] mat) {
        for(int i = mat.length-1; i >= 0; i--) {
            for(int j = mat[i].length-1; j >= 0; j--) {
                System.out.print(mat[i][j]+ ", ");
            }
            System.out.println();
        }
    }
    public static void printRow(int[][] mat) {
        for(int i = 0; i < mat.length; i++) {
            System.out.print(mat[i][1] + ", ");
        }
    }
    public static void printCol(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            System.out.println(mat[1][i] + ", ");
        }
    }
    public static void findIt(int[][] a, int v){
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            for(int j = 0; j < a[i].length; j++) {
                if(v <= a[i][j]) {
                    count++;
                }
            }
            System.out.println(count);
            count = 0;
        }
    }
}