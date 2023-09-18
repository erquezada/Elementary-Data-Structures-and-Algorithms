import java.util.Arrays;

public class FizzBuzz {

    public static void main(String[] args) {
	// write your code here
        String someStrings = "Hello, my name is Alan Turing. How are you?";
        System.out.println(Arrays.toString(fizzBuzz(0, someStrings.length()-1)));
        String isString = "This is right";
        System.out.println(notReplace(isString));
    }
    public static String[] fizzBuzz(int start, int end) {
        String[] answer = new String[end-start];
        int index = 0;
        for(int i = start; i < end; i++){
            if(i % 3 == 0 && i % 5 == 0){
                answer[index] = "FizzBuzz";
            }
            else if(i % 3 == 0){
                answer[index] = "Fizz";
            } else if(i % 5 == 0){
                answer[index] = "Buzz";
            } else {
                answer[index] = "" + i;
            }
            index++;
        }
        return answer;
    }
    public static String notReplace(String str) {
        return str.replaceAll("(?<!\\p{Alpha})is(?!\\p{Alpha})", "is not");
    }
}
