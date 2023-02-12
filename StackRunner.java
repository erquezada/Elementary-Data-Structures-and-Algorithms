import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.StringTokenizer;
class StackRunner{

    public static void main(String[] args) throws Exception{
        String path = "input.txt"; // input file
       try {
           BufferedReader reader = new BufferedReader(new FileReader(path)); // read file
           String line;
           while ((line = reader.readLine()) != null) { // scan the file line by line
               if(line.trim().length()==0) continue;
               if(line.charAt(0) == 'b'){
                   System.out.println("The line is: " + line + " line" );
                   System.out.println("Checking the balace of the expression.");
                   System.out.println("The expression: " + line);
                   if(isBalanced(line))
                       System.out.println("The expression is balanced.");
                   else
                       System.out.println("The expression is imbalanced.");
                   System.out.println("-------------------------");
               }
               else if(line.charAt(0) == 'p'){
                   System.out.println("The line is " + line + " line");
                   if(evaluatePostfix(line) == Double.NEGATIVE_INFINITY){
                       System.out.println("The line contains an invalid postfix expression");
                   }

                   else{
                       System.out.println("The evaluation of this postfix expression is: " + evaluatePostfix(line));
                   }
                   System.out.println("-------------------------");
               }
               else if(line.charAt(0) != 'p' && line.charAt(0) != 'b'){
                   System.out.println("The line is " + line + line);
                   System.out.println("The line does not start with a 'b' or a 'p'. This program will skip this line.");
                   System.out.println("-------------------------");
               }
           }
       } catch (FileNotFoundException e) {
           e.printStackTrace();
           System.out.println("Error. Check code for correctness");

       }
    }
    /**
     * Evaluate the postfix expression in the incoming String.
     * Operators and operands are separated by spaces. See
     * the assignment description for further details.
     * @param postfix
     * @return the evaluated postfix value.
     */
    static double evaluatePostfix(String postfix){
        Stack myStack = new Stack(); // create stack to evaluate expression
        postfix = postfix.trim();
        String[] postfixArray = postfix.split(" "); //create array to contain the postfix expression
        for (String s : postfixArray) { // iterate through the array
            if (isNumber(s)) { // if a character of a string is a number, push that onto the stack
                myStack.push(Double.parseDouble(s));
            } else if ( // else check if the character of a string is an operator
                    s.equals("*") ||
                            s.equals("+") ||
                            s.equals("-") ||
                            s.equals("/")) {
                Object operand1 = myStack.pop(); // num one
                Object operand2 = myStack.pop(); // num two
                if (operand1 == null || operand2 == null) throw new IllegalArgumentException("Invalid postfix expression: " + postfix);
                if (s.equals("+")) myStack.push((double) operand2 + (double) operand1);
                if (s.equals("-")) myStack.push((double) operand2 - (double) operand1);
                if (s.equals("/")) myStack.push((double) operand2 / (double) operand1);
                if (s.equals("*")) myStack.push((double) operand2 * (double) operand1);
            }
        }
        if (myStack.isEmpty()) {
            throw new IllegalArgumentException("Invalid postfix expression: " + postfix);
        }
        return (double) myStack.pop();
    }
    /**
     * The method checks if a string is a double
     * precision number.
     * @param tk
     * @return true if the param string is a double precision number
     *         false otherwise.
     */
    static boolean isNumber(String tk){
        if (tk==null)
            return false;
        tk=tk.trim();
        if (tk.equals(""))
            return false;

        try{
            double number = Double.parseDouble(tk);
        }catch(NumberFormatException excp){
            return false;
        }
        return true;
    }

    /**
     * The method should consider only start '(' and
     * end parentheses ')'. Other characters in the
     * incoming parameter string should be ignored.
     * The method must use a Stack to determine
     * if the incoming string contains a balanced
     * expression or not. See
     * the assignment description for further details.
     * @param expr
     * @return true if the expression in the String is balanced
     * otherwise, false.
     */
    static boolean isBalanced(String expr){
        Stack myStack = new Stack(); //create a new stack
        for (int i = 0; i < expr.length(); i++) { // iterate through the expression
            if(expr.charAt(i)=='(') myStack.push('('); // if the character is open parentheses, push onto stack
            else if(expr.charAt(i) == ')') { // if the character is closing parentheses check to see if the stack is balanced
                if (myStack.isEmpty()) { // stack not balanced return false
                    return false;
                }
                myStack.pop(); // pop elements
            }
        }
        return myStack.isEmpty(); // return stack
    }
}