import java.util.Arrays;
import java.lang.Math;
public class Search {

    public static void main(String[] args) {
	// write your code here

        // generate a random array of doubles
        double[] sampleArray = new double[100000];
        int max = sampleArray.length; // set max to be 10K for test 1
        int min = 1; // set min to be 0
        int range = max - min + 1; // find the rage


        for (int i = 0; i <= sampleArray.length-1; i++) {
            sampleArray[i] = (Math.random()* range) + min; // populate with random values
        }
        double indexer = Math.floor(sampleArray[(int) (Math.random()*range)+min]); // use a random indexer to search for a value within the array

        System.out.println("The number we are looking for: " + indexer);
        //System.out.println("Found at index: " + iterativeBinarySearch(sampleArray, indexer));
        //Arrays.sort(sampleArray); // sort the arrays
        System.out.println("-------");
        long sum = 0;
        long executionTime;
        for(int i = 0; i <= 20; i++) {
            long start = System.nanoTime();
            iterativeLinearSearch(sampleArray, indexer);
            long end = System.nanoTime();
            executionTime = end - start;
            sum += executionTime;
        }
        long average = sum  / 20;
        System.out.println("Linear Search run time is: " + average);

        System.out.println("---------");

        long sumSortingArray = 0;
        for(int i = 0; i <= 20; i++) {
            long begin = System.nanoTime();
            Arrays.sort(sampleArray);
            long finish = System.nanoTime();
            long time = finish - begin;
            sumSortingArray += time;
        }
        long averageSortingTime = sumSortingArray /20;
        System.out.println("Arrays.sort run time: " + averageSortingTime);

        System.out.println("-------");

        long sumRecursive = 0;
        long executionTimeRecursive;
        for(int i = 0; i <= 20; i++) {
            long startRecursive = System.nanoTime();
            recursiveBinarySearch(sampleArray, indexer);
            long endRecursive = System.nanoTime();

            executionTimeRecursive = endRecursive - startRecursive;
            sumRecursive += executionTimeRecursive;
        }
        long averageRecursive = sumRecursive / 20;
        System.out.println("Recursive Binary Search Run time is: " + averageRecursive);
        //System.out.println("Found at index: " + recursiveBinarySearch(sampleArray,indexer));

        System.out.println("-------");


        long sumIterativeBinary = 0;
        long executionTimeIterativeBinary;
        for(int i = 0; i <= 20; i++) {
            long startIterativeBinary = System.nanoTime();
            iterativeBinarySearch(sampleArray, indexer);
            long endIterativeBinary = System.nanoTime();

            executionTimeIterativeBinary = endIterativeBinary - startIterativeBinary;
            sumIterativeBinary += executionTimeIterativeBinary;
        }
        long averageIterative = sumIterativeBinary / 20;
        System.out.println("Iterative Binary Search Run time is: " + averageIterative);

    }
    public static int iterativeLinearSearch(double[] myArray, double key) {
        // declare an indexer

        for (int i = 0; i < myArray.length; i++) { // iterate across the entire array
            if (myArray[i] == key) { // if a value within the array matches our key
                key = myArray[i];// the key receives the value of the array
                return (int) key; // return the index position where the key was found
            }
        }
        return -1; // if not found return -1
    }
    public static int recursiveBinarySearch(double[] myArray, double key){
        int low = 0; // set a low point
        int high = myArray.length - 1; // set  a high point
        return recursiveBinarySearch(myArray, key,low, high); // recursive call on the searching portion of binary search
    }
    public static int recursiveBinarySearch(double[] myArray, double key, int low, int high) {
        if (low > high) return -low - 1; // if no match is found return -1
        int mid = (low + high) / 2; // find the middle part of the array
        if (key < myArray[mid]) return recursiveBinarySearch(myArray, key, low, mid - 1); // if key is less than your partition perform a recursive call
            // until match found
        else if (key == myArray[mid]) return mid; // if key is in the middle of the array, match found
        else return recursiveBinarySearch(myArray, key, mid + 1, high); // else search on the right side of the array
    }
    public static int iterativeBinarySearch(double[] myArray, double key) {
        int low = 0;
        int high = myArray.length - 1;
        int mid;
        while (high >= low) { // while low is less than or equal high, iterate through the array until match is found
            mid = (low + high) / 2; // find the middle part of the array
            // {1,2,3,4} key = 3
            if (key < myArray[mid]) high = mid - 1; // if the array is in the middle of the array, match found
            else if (key == myArray[mid]) return mid; // if key is less than your partition, move up one element until match is found
            else low = mid + 1; // else move down one element until match is found
        }
        return -low-1; // return the index
    }
}