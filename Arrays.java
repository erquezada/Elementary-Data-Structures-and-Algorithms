public class Arrays {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};

        print1DArray(arr);
        System.out.println();
        printReverseArray(arr);
        System.out.println();
        System.out.println(sum(arr));
        System.out.println();
        System.out.println(average(arr));
        System.out.println();
        System.out.println(findMax(arr));
        System.out.println();
        System.out.println(findMin(arr));
        System.out.println();
        print2DArray(matrix);
        System.out.println();
        print2DArrayReverse(matrix);
        System.out.println();
        System.out.println(sum2DArray(matrix));
        System.out.println();
        System.out.println(sumDiagonal(matrix));
        System.out.println();
        System.out.println(sumAntiDiagonal(matrix));
    }
    public static void print1DArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public static void printReverseArray(int[] arr) {
        for(int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
    }
    public static int sum(int[] arr) {
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            sum+= arr[i];
        }
        return sum;
    }
    public static double average(int[] arr) {
        double average = 0;
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            sum +=arr[i];
        }
        average = sum/arr.length;
        return average;
    }
    public static int findMax(int[] arr) {
        int max = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
    public static int findMin(int[] arr) {
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }
    public static void print2DArray(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void print2DArrayReverse(int[][] matrix) {
        for(int i = matrix.length - 1; i >= 0; i--) {
            for(int j = matrix[i].length - 1; j >= 0; j--) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int sum2DArray(int[][] matrix) {
        int sum = 0;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++){
                sum+= matrix[i][j];
            }
        }
        return sum;
    }
    public static int sumDiagonal(int[][] matrix) {
        int sum = 0;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(i == j) {
                    sum+= matrix[i][j];
                }
            }
            
        }
        return sum;
    }
    public static int sumAntiDiagonal(int[][] matrix) {
        int sum = 0;
        int length = matrix.length;
        for(int i = 0; i < matrix.length; i++) {
                    sum+= matrix[i][length-i-1];
        }
        return sum;
    }
}