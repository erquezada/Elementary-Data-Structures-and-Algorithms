public class Lecture6v2 {

    public static void main(String[] args) {
	// write your code here
        // 1D Arrays and 2D Arrays

        // Find sum, find largest, find smallest, find the numbers that are greater than a certain number,
        // find average, print forwards, print backwards, print the numbers whose sum is greater than a certain number.
        // print lower triangle, print upper triangle, print diagonals, print sum of diagonals

        int[] a1D = {1,2,3,4,5};
        System.out.println(findSum(a1D));
        System.out.println(findMin(a1D));
        System.out.println(findMax(a1D));

        System.out.println();

        for(int i = 0; i < a1D.length; i++) {
            System.out.print(a1D[i]);
        }

        System.out.println();
        System.out.println();

        for(int i = a1D.length-1; i >= 0; i--) {
            System.out.print(a1D[i]);
        }

    }
    public static int findSum(int[] a1D) {
        int sum = 0;
        for(int i = 0; i < a1D.length; i++) {
            sum += a1D[i];
        }
        return sum;
    }
    public static int findMin(int[] a1D) {
        int min = 1000;
        for(int i = 0; i < a1D.length; i++) {
            if(min > a1D[i]) {
                min = a1D[i];
            }
        }
        return min;
    }
    public static int findMax(int[] a1D) {
        int max = 0;
        for(int i = 0; i < a1D.length; i++) {
            if(max < a1D[i]) {
                max = a1D[i];
            }
        }
        return max;
    }
}
