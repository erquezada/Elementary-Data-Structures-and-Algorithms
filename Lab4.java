import java.io.*;
public class Lab4 {
    public static void main(String[] args) {
        // file with path
        String path = "input.csv";
        //call methods
        String[][] statesAndCapitals = parseArray(path);
        largestCapName(statesAndCapitals);
        mostVowels(statesAndCapitals);
        mostPopulated(statesAndCapitals);
        secMostPopulated(statesAndCapitals);
        thirdMostPopulated(statesAndCapitals);
    }
    public static String[][] parseArray(String path) {
        // method to read array
        String[][] stringArray = new String[50][3];
        String line;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            int row = 0;
            while((line = reader.readLine()) != null) {
                String[] tokens = line.split(",");
                for(int column = 0; column < tokens.length; column++) {
                    stringArray[row][column] = String.valueOf(tokens[column]);
                }
                row++;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return stringArray;
    }
    public static String[] getStates(String[][] data) {
        // helper method to extract states column into a 1d array
        String[] states = new String[data.length];
        for(int i = 0; i < states.length; i++) {
            states[i] = data[i][0];
        }
        return states;
    }
    public static String[] getCapitals(String[][] data) {
        // helper method to extract capitals column into a 1d array
        String[] capitals = new String[data.length];
        for(int i = 0; i < capitals.length; i++) {
            capitals[i] = data[i][1];
        }
        return capitals;
    }
    public static int[] getPopulation(String[][] data) {
        // helper method to extract population column into a 1d array
        int[] populationOfCapitals = new int[data.length];
        for(int i = 0; i < populationOfCapitals.length; i++) {
            populationOfCapitals[i] = Integer.parseInt(data[i][2]);
        }
        return populationOfCapitals;
    }
    public static void largestCapName(String[][] data){
        // initialize variables
        System.out.println("------------Analyzing capital names------------");
        int largestCapitalName = 0; //used as a placeholder for max
        int loopCount = 0;
        String printLargestCapName = "";
        String[] listOfCapitals = getCapitals(data); // create an array to get information of the columns containing the capitals
        for (String listOfCapital : listOfCapitals) { // for loop to iterate through the strings of the array
            if (listOfCapital.length() > largestCapitalName) { // compare the length of the string against the max
                largestCapitalName = listOfCapital.length();
                printLargestCapName = listOfCapital;
                // max placeholder receives the string with most characters in it.
            }
            loopCount++; // counter to see how many times loop ran
        }
        // print data to console
        System.out.println("The capital with the largest name: " + printLargestCapName);
        System.out.println("The loop(s) ran: " + loopCount + " times.");
        System.out.println();
    }
    public static void mostVowels(String[][] data){
        //initialize variables
        String[] countVowelsInArray = getCapitals(data); // receive the column with capitals from 2d array
        int maxVowel = 0;
        int loopCount = 0;
        String temp;
        String tempCapName = "";
        for (String s : countVowelsInArray) { // iterate at the array level
            int vowelCounter = 0; // count the vowels in a string
            temp = s; // temp receives the elements of the array
            temp = temp.toLowerCase(); // converts the string to lowercase
            for (int j = 0; j < temp.length(); j++) { // iterate through array at the individual string level
                char ch = temp.charAt(j);
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowelCounter++;  // increment counter for every vowel found in element of array
                    if (vowelCounter >= maxVowel) { // if counter is greater than max
                        maxVowel = vowelCounter; // max receives the element with most vowels
                        tempCapName = s;
                    }
                }
            }
            loopCount++; // loop counter
        }
        //Print data to console
        // create an array that maps to each vowel
        // count the number of times that a vowel appears within a string.
        // compare the two strings against each other
        System.out.println("Capital with the most vowels: " + tempCapName);
        System.out.println("The loop(s) ran: " + loopCount + " times.");
        System.out.println();
    }
    public static void mostPopulated(String[][] data){
        //initialize variables
        System.out.println("--------------Analyzing population--------------");
        int max = Integer.MIN_VALUE;
        int loopCount = 0;
        String printMostPopulatedStateCapital = "";
        String printMostPopulatedStateName = "";
        String[] listOfStates = getStates(data); // create an array to get information of the columns containing the states
        String[] listOfCapitals = getCapitals(data); // create an array to take information of the columns containing the capitals
        int[] capitalsPopulation = getPopulation(data); // create an array to take information of the columns containing the population count of the capitals
        for(int i = 0; i < capitalsPopulation.length; i++) { // iterate through the array containing the population of the capitals
            if (capitalsPopulation[i] > max) { // compare the index of the array against the max
                max = capitalsPopulation[i];
                printMostPopulatedStateCapital = listOfCapitals[i];
                printMostPopulatedStateName = listOfStates[i];
                // max receives the element with most population
            }
            loopCount++; // loop counter
        }
        //Print data to console
        System.out.println("Most populated capital: "  + printMostPopulatedStateCapital + " in " + printMostPopulatedStateName);
        System.out.println("The population is: " + max);
        System.out.println("The loop(s) ran: " + loopCount + " times.");
        System.out.println();
    }
    public static void secMostPopulated(String[][] data) {
        //initialize variables
        int loopCount = 0;
        String printMostPopulatedStateCapital = "";
        String printMostPopulatedStateName = "";
        int max = Integer.MIN_VALUE; // first max
        int secondMax = Integer.MIN_VALUE; // second max
        int[] capitalsPopulation = getPopulation(data);
        String[] listOfCapitals = getCapitals(data);
        String[] listOfStates = getStates(data);
        for(int i = 0; i < capitalsPopulation.length; i++) { // traverse through array
            if(capitalsPopulation[i] > max) { // if a value within the array is greater than the first max
                secondMax = max; // the second max swaps with the first max
                max = capitalsPopulation[i]; // the first max receives the value with the highest population in array
            } else if(capitalsPopulation[i] > secondMax) { // else the second max receives the value with the second-highest population in array
                secondMax = capitalsPopulation[i];
                printMostPopulatedStateCapital = listOfCapitals[i];
                printMostPopulatedStateName = listOfStates[i];
            }
            loopCount++; // loop counter
        }
        //Print data to console
        System.out.println("Second most populated capital: " + printMostPopulatedStateCapital + " in " + printMostPopulatedStateName);
        System.out.println("The population is: " + secondMax);
        System.out.println("The loop(s) ran: " + loopCount + " times.");
        System.out.println();
    }
    public static void thirdMostPopulated(String[][] data) {
        // initialize variables
        int loopCount = 0;
        String printMostPopulatedStateCapital = "";
        String printMostPopulatedStateName = "";
        int max = Integer.MIN_VALUE; //first max
        int secondMax = Integer.MIN_VALUE; // second max
        int thirdMax = Integer.MIN_VALUE; // third max
        int[] capitalsPopulation = getPopulation(data);
        String[] listOfCapitals = getCapitals(data);
        String[] listOfStates = getStates(data);
        for (int i : capitalsPopulation) { // enhanced for-loop for iterating through array
            if (max < i) { // find the first max in array
                max = i;
            }
        }
        for (int i : capitalsPopulation) {
            if (secondMax < i && max > i) { // find the second max in array
                secondMax = i;
            }

        }
        for (int i = 0; i < capitalsPopulation.length; i++) { // finding the third max in array
            if(thirdMax < capitalsPopulation[i] && secondMax>capitalsPopulation[i]){ // if the third max is lesser than a value in the array and the two previous max values
                thirdMax = capitalsPopulation[i]; // third max receives the third-highest value in array
                printMostPopulatedStateCapital = listOfCapitals[i];
                printMostPopulatedStateName = listOfStates[i];
            }
            loopCount++;
        }
        //Print data to console
        System.out.println("Third most populated capital: " + printMostPopulatedStateCapital + " in " + printMostPopulatedStateName);
        System.out.println("The population is: " + thirdMax);
        System.out.println("The loop(s) ran: " + loopCount + " times.");
    }
}