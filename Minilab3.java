import java.lang.Math;
public class Minilab3 {
    public static void main(String[] args) {

        System.out.println("The number of guesses is: " + guessingGame(26));
    }
    public static boolean findAtEven(int[] A, int e) {
        for (int i = 0; i < A.length; i += 2) {
            if (A[i] == e) {
                return true;
            }
        }
        return false;
    }
    public static int guessingGame(int maxValue) {
        int guessCounter = 0;
        int randomNumber = (int) (Math.random() * maxValue);
        for (int i = 1; i < maxValue; i++) {
            if (i == randomNumber) {
                break;
            } else {
                guessCounter++;
            }
        }
        return guessCounter;
    }
    public static int crossDiagonals(int[][] A) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i][A.length-1-i];
        }
        System.out.println(sum);
        return sum;
    }
    public static int maxProduct(int[] A) {
        int maxProduct = 0;
        for (int i = 0; i < A.length; i++) { // i += i/2
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] * A[j] > maxProduct) {
                    maxProduct = A[i] * A[j];
                }
            }
        }
        return maxProduct;
    }
    public static void weirdBubble(int[] A) {
        boolean swap;
        int start =0;
        int end = A.length-1;
        while (start != end) {
            swap = bubblingUp(A, start, end);
            if (!swap) return;
            end--;

            swap = bubblingDown(A, start, end);
            if (!swap) return;
            start++;
        }
    }
    public static boolean bubblingUp(int[] A, int start, int end) {
        boolean swap = false;
        int temp;
        for (int i = start; i < end; i++) {
            if (A[i] > A[i + 1]) {
                temp = A[i];
                A[i] = A[i + 1];
                A[i + 1] = temp;
                swap = true;
            }
        }
        return swap;
    }
    public static boolean bubblingDown(int[] A, int start, int end) {
        boolean swap = false;
        int temp;
        for(int i = end - 1; i >= start+1; i--) {
            if (A[i] < A[i - 1]) {
                temp = A[i];
                A[i] = A[i-1];
                A[i-1] = temp;
                swap = true;
            }
        }
        return swap;
    }
}