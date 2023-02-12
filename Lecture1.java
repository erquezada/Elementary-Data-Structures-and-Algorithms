public class Lecture1 {
    public static void main(String[] args) {
        //create an array.
        int i = 10;
        int[] myArray = {2,5,7,8};
        printArray(myArray); // 2 5 7 8
        myMethod_int(i);
        System.out.println("Value of 'i' in main method after call is: " + i); // 13

        // passing array to a method
        myMethod2_array(myArray);
        System.out.println("Value of array at index zero after method call is: " + myArray[0]); // 12
        printArray(myArray); // 12 5 7 8

        //2D Array
        System.out.println();
        System.out.println("------ 2D Array ------");
        int[][] aa = {
                {10, 5, 3, 20},
                {20, 11, 30, 50, 100, 200},
                {25, 30}
        };
        int[][] bb = new int[3][4];
        print2DArray(aa);
        System.out.println();
        System.out.println("Another 2D Array");
        print2DArray(bb);

        int[][] cc = new int[5][];
        //System.out.println(cc[0][1]);
        //cc[0][0] = new int[1];
        for(int k = 0; k < cc.length; k++) {
            cc[k] = new int[k+1];
        }
        System.out.println("Diagonal array");
        print2DArray(cc);


    }
    public static void print2DArray(int[][] arr) {
        for(int row = 0; row < arr.length; row++) {
            for(int column = 0; column < arr[row].length; column++) {
                System.out.print(arr[row][column] + " ");
            }
            System.out.println();
        }

    }
    static void printArray(int[] arr) {
        //method for iterating through array and printing the array.
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void myMethod_int(int a) {
        //method for changing value of integer.
        a += 3;
        System.out.println("The value of 'a' within the method is: " + a);
    }
    public static void myMethod2_array(int[] b) {
        //method for changing the values within array.
        b[0] = b[0] + 10;
    }
}

