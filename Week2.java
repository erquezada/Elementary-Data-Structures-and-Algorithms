import java.util.Arrays;

public class Week2 {
	public static void main(String[] args) {
		//Problem 1
		int [] A = {1,2, 3, 4, 5};
		for(int i =0; i > A.length; i++){
			System.out.println(A[i]);
		}
		int [] C = reverse(A);
		for(int i =0; i < C.length; i++){
			System.out.println(C[i]);
		}
		//Problem 2
		int[] myArray = {1, 2, 3, 4, 5, 6};
		System.out.println(checkForDuplicates(myArray));

		//Problem 3
		int [] maxArray = {1, 3, 7, 9, 101};
		System.out.println(checkMaxDifference(maxArray, 5));

		//Problem 4
		int [][] b = {
				{1, 2, 2, 7, 8},
				{1, 2, 3, 4, 5, 6, 7, 8, 9},
				{1,  3, 4, 5, 6, 7, 8, 9}};

		//Problem 5
		System.out.println(doubleCharacters("abc"));

		//Problem 6
		System.out.println(doubleCharacters2("abbcdde"));
	}
	public static int [] reverse(int [] A){
		int [] B = new int[A.length];
		int j = 0;
		for(int i =A.length -1 ; i>=0; i--){
			B[j] = A[i];
			j++;
		}
		return B;
	}
	public static String doubleCharacters(String str){
		String finalString = "";
		for(int i =0; i < str.length(); i++){
			char x = str.charAt(i);
			finalString = finalString + x +x;
			System.out.println(finalString);
		}
		return finalString;
	}
	public static String doubleCharacters2(String str){
		String finalString = "";
		for(int i =0; i < str.length(); i++){
			char x = str.charAt(i);
			if((i+1) >= str.length()) {
				if (str.charAt(i) == str.charAt(i - 1)) {
					return finalString + x;
				} else {
					return finalString + x + x;
				}
			}
			if(str.charAt(i)==str.charAt(i+1)){
				finalString = finalString + x + x;
				//System.out.println(finalString);
				i++;
			}
			else{
				finalString = finalString + x +x;
				//System.out.println(finalString);
			}
		}
		return finalString;
	}
	public static int checkMaxDifference(int[] maxArray, int arraySize) {
		int maxDifference = maxArray[1] - maxArray[0];
		for (int i = 0; i < arraySize; i++) {
			for (int j = i + 1; j < arraySize; j++) {
				if(maxArray[j] - maxArray[i] > maxDifference)
					maxDifference = maxArray[j] - maxArray[i];
			}
		}
		return maxDifference;
	}
	public static boolean checkForDuplicates(int[] myArray) {
		// Given a 1D array of integers, design a method,
		// called checkForDuplicates, that checks if this array has duplicates.
		// Your method returns a boolean value.
		for (int i = 0; i < myArray.length; i++) {
			if (!Arrays.equals(myArray, myArray)) {
				//System.out.println("This array has no duplicates");
				return true;
			} else {
				//System.out.println("This array has duplicates");
				return false;
			}
		}
		return false;
	}
}