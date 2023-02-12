import java.util.Scanner;
public class EvenOdd {
    public static void main(String[] args) {
       // Take a positive integer and return true if the integer is an odd int, or return false if it is even integer
       System.out.println("Enter a number");
     
       Scanner scnr = new Scanner(System.in);
        int n = scnr.nextInt();
        if (n % 2 == 1) {
            System.out.println("Odd");
        } else { 
            System.out.println("Even");
        }
    }
}