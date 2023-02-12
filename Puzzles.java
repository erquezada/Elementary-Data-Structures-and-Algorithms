public class Puzzles {

    // Define a method to determine the rule of the sequence and return the next number
    public static int nextNumber(int n) {
      // Initialize the result to an empty string
      String result = "";
      // Convert the integer n to a string
      String str = String.valueOf(n);
      // Initialize a count variable to keep track of how many times each character appears
      int count = 1;
      // Loop through the characters of the string, starting from the second character
      for (int i = 1; i < str.length(); i++) {
        // If the current character is the same as the previous character, increase the count
        if (str.charAt(i) == str.charAt(i - 1)) {
          count++;
        } else {
          // Otherwise, add the count and the previous character to the result
          result += count + "" + str.charAt(i - 1);
          // Reset the count to 1
          count = 1;
        }
      }
      // Add the last count and character to the result
      result += count + "" + str.charAt(str.length() - 1);
      // Convert the result back to an integer and return it
      return Integer.parseInt(result);
    }
  
    // Define a method to print out the sequence of N numbers that start with S and follow the rule
    public static void printSequence(int s, int n) {
      // Initialize an array to hold the sequence
      int[] sequence = new int[n];
      // The first number in the sequence is S
      sequence[0] = s;
      // Loop through the rest of the sequence and calculate each number using the nextNumber method
      for (int i = 1; i < n; i++) {
        sequence[i] = nextNumber(sequence[i - 1]);
      }
      // Print out the sequence
      for (int num: sequence) {
        System.out.print(num + " ");
      }
    }
  
    public static void main(String[] args) {
      // Call the printSequence method with S=2 and N=6
      printSequence(2, 6);
    }
  }