import java.io.File;
import java.util.Scanner;

public class Lab8 {
    public static void main(String[] args){
        String fileName = "input.txt";
        Box[] allBoxes = getBoxArrayFromDataFile(fileName);

        if (allBoxes!=null){
            System.out.println("Number of boxes in the array: "+ allBoxes.length);
        }else{
            System.out.println("No array constructed. Array is null. ");
        }

        System.out.println("The boxes are as follows:");
        displayAllBoxes(allBoxes);
        System.out.println("Sorting the array using bubbleSort");

        long start = System.nanoTime();
        bubbleSort(allBoxes);
        long end = System.nanoTime();
        long bubbleSortTime=(end-start);

        System.out.println("The array after bubble sort:");
        displayAllBoxes(allBoxes);

        System.out.println("Re-constructing the array from the input file.");
        allBoxes = getBoxArrayFromDataFile(fileName);
        if (allBoxes!=null){
            System.out.println("Number of boxes in the array: "+ allBoxes.length);
        }else{
            System.out.println("No array constructed. Array is null. ");
        }
        System.out.println("The boxes after re-reading the input file");
        displayAllBoxes(allBoxes);
        System.out.println("Sorting the array using selectionSort");
        start = System.nanoTime();
        selectionSort(allBoxes);
        end = System.nanoTime();
        long selectionSortTime=(end-start);

        System.out.println("The array after selection sort:");
        displayAllBoxes(allBoxes);

        System.out.println("Re-constructing the array from the input file.");
        allBoxes = getBoxArrayFromDataFile(fileName);
        if (allBoxes!=null){
            System.out.println("Number of boxes in the array: "+ allBoxes.length);
        }else{
            System.out.println("No array constructed. Array is null. ");
        }
        System.out.println("The boxes after re-reading the input file");
        displayAllBoxes(allBoxes);
        System.out.println("Sorting the array using mergeSort");
        start = System.nanoTime();
        mergeSort(allBoxes);
        end = System.nanoTime();
        long mergeSortTime=(end-start);

        System.out.println("The array after merge sort:");
        displayAllBoxes(allBoxes);

        System.out.println("********* Runtime summary: ***********");
        System.out.println("Time taken by bubble sort: "+bubbleSortTime+" ns");
        System.out.println("Time taken by selection sort: "+selectionSortTime+" ns");
        System.out.println("Time taken by merge sort: "+mergeSortTime+" ns");
    }

    /**
     * Change the body of this method to arrange the Box
     * objects in the array parameter in ascending order of
     * their volumes.
     * The method must use bubble sort.
     * @param theBoxes
     */
    static void bubbleSort(Box[] theBoxes) {
        // You are not allowed to change the header.
        // Change the body of this method.
      //  System.out.println("I have not yet implemented bubble sort");
        boolean needNextPass = true;
        for (int k = 1; k < theBoxes.length && needNextPass; k++) {
            // Array may be sorted and next pass not needed
            needNextPass = false;
            for (int i = 0; i < theBoxes.length - k; i++) {
                if (theBoxes[i].compareTo(theBoxes[i+1]) > 0) {
                    // Swap list[i] with list[i + 1]
                    Box temp = theBoxes[i];
                    theBoxes[i] = theBoxes[i + 1];
                    theBoxes[i + 1] = temp;
                    needNextPass = true; // Next pass still needed
                }
            }
        }
    }
    /**
     * Change the body of this method to arrange the Box
     * objects in the array parameter in ascending order of
     * their volumes.
     * The method must use selection sort.
     * @param theBoxes
     */
    static void selectionSort(Box[] theBoxes) {
        // You are not allowed to change the header.
        // Change the body of this method.
       // System.out.println("I have not yet implemented selection sort");
        for (int i=0; i<theBoxes.length-1; i++) {
            int minIndex = i; // Index of smallest remaining value.
            for (int j=i+1; j<theBoxes.length; j++) {
                if (theBoxes[minIndex].compareTo(theBoxes[j]) > 0) {
                    minIndex = j;  // Remember index of new minimum
                }
            }
            if (minIndex != i) {
                //Exchange current element with smallest remaining.
                Box temp = theBoxes[i];
                theBoxes[i] = theBoxes[minIndex];
                theBoxes[minIndex] = temp;
            }
        }
    }
    /**
     * Change the body of this method to arrange the Box
     * objects in the array parameter in ascending order of
     * their volumes.
     * The method must use merge sort.
     * @param theBoxes
     */
    static void mergeSort(Box[] theBoxes) {
        // You are not allowed to change the header.
        // Change the body of this method.
       // System.out.println("I have not yet implemented merge sort");
        if (theBoxes.length > 1) {
            // Merge sort the first half
            Box[] firstHalf = new Box[theBoxes.length / 2];
            System.arraycopy(theBoxes, 0, firstHalf, 0, theBoxes.length / 2);
            mergeSort(firstHalf);
            // Merge sort the second half
            int secondHalfLength = theBoxes.length - theBoxes.length / 2;
            Box[] secondHalf = new Box[secondHalfLength];
            System.arraycopy(theBoxes, theBoxes.length / 2, secondHalf, 0, secondHalfLength);
            mergeSort(secondHalf);
            // Merge firstHalf with secondHalf into list
            merge(firstHalf, secondHalf, theBoxes);
        }
    }
    /** Merge two sorted lists */
    public static void merge(Box[] list1, Box[] list2, Box[] temp) {
        int current1 = 0; // Current index in list1
        int current2 = 0; // Current index in list2
        int current3 = 0; // Current index in temp
        while (current1 < list1.length && current2 < list2.length) {
            if (list1[current1].compareTo(list2[current2]) < 0)
                temp[current3++] = list1[current1++];
            else
                temp[current3++] = list2[current2++];
        }
        while (current1 < list1.length)
            temp[current3++] = list1[current1++];
        while (current2 < list2.length)
            temp[current3++] = list2[current2++];
    }
    /**
     * Display width, length, height, volume of
     * each Box object in a sequence they appear
     * in the array of the parameter.
     * @param theBoxes
     */
    static void displayAllBoxes(Box[] theBoxes){
        // You are not allowed to change the header.
        // Change the body of this method.
      //  System.out.println("I have not yet implemented the display method.");
        for (int i = 0; i < theBoxes.length; i++) {
            System.out.println(theBoxes[i]);
        }
    }
    static Box[] getBoxArrayFromDataFile (String fileName){
        // You are not allowed to change the header.
        // Change the body of this method.
        Box[] myBoxes = new Box[10];
        try {
            File file = new File(fileName);
            Scanner scnr = new Scanner(file);

            for(int i = 0; i < myBoxes.length; i++) {
                myBoxes[i] = new Box(scnr.nextDouble(),scnr.nextDouble(),scnr.nextDouble());
            }
        }
        catch(Exception e) {
            System.out.println("I have not yet implemented the method to \nconstruct the array from file input.");

        }
        return myBoxes;
    }
}