import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
public class Lab3_Runner_Quezada {
	//main method
	public static void main(String[] args) throws FileNotFoundException {
		//read file and scan file
		File fileReader = new File("input.txt");
		Scanner scnr = new Scanner(fileReader);

		// instantiate object
		Box[] Boxes = new Box[6];
		int i = 0;

		// parse values from txt file into box object
		while (scnr.hasNextDouble()) {
			Box box = new Box();
			box.setLength(scnr.nextDouble());
			box.setWidth(scnr.nextDouble());
			box.setHeight(scnr.nextDouble());
			Boxes[i] = box;
			i++;
		}
		///call methods
		printMethods(Boxes);
	}
	public static void printMethods(Box[] myBoxes) {
		// print method
		System.out.println("Average surface area: " + averageSurfaceArea(myBoxes));
		System.out.print("Box indices with larger surface area are: "); findBoxIndicesGreaterThanAverage(myBoxes);
		findLargestBox(myBoxes);
		System.out.println("Number of boxes with surface area larger than average surface area: " + countBoxesGreaterThanAverage(myBoxes));
		System.out.println("Number of boxes with surface area smaller than average surface area: " + countBoxesLesserThanAverage(myBoxes));

	}
	public static double averageSurfaceArea(Box[] myBoxes) {
		//initialize variables
		double sum = 0;
		double average;
		int i;

		//loop through array and sum the values of surface area
		for(i = 0; i < myBoxes.length; i++) {
			sum += myBoxes[i].getSurfaceArea();
		}

		//calculate average surface area
		average = sum / myBoxes.length;
		double roundedAverage = Math.ceil(average*100)/100;
		return roundedAverage;
	}
	public static void findLargestBox(Box[] myBoxes) {
		//initialize variables
		int i;
		int index = 0;
		//set a starting point for comparing one object against other objects
		Box largestBox = myBoxes[0];
		//loop through array and if a box is greater than the point then the starting
		// point receives the value of the box with the largest surface area
		for (i = 0; i < myBoxes.length; i++) {
			if(myBoxes[i].compareTo(largestBox) > 0) {
				largestBox = myBoxes[i];
			}
			//retrieve the index of the box with the largest surface area
			if(myBoxes[i] == largestBox) {
				index = i;
			}
		}
		//print index and dimensions of the box
		System.out.println();
		System.out.println("The largest box has index: " + index + ", surface area "
				+ largestBox.getSurfaceArea() +
				", and dimensions: length is " + largestBox.getLength() +
				", width is " + largestBox.getWidth() +
				", height is " + largestBox.getHeight());
	}
	public static int countBoxesGreaterThanAverage(Box[] myBoxes) {
		//initialize variables
		int counter = 0;
		double sum = 0;
		double average;

		//loop through array and sum the values of surface area
		for(int i = 0; i < myBoxes.length; i++) {
			sum += myBoxes[i].getSurfaceArea();
			//calculate average
			average = sum / myBoxes.length;

			// update counter for each box that has a surface area that is larger than the average surface area
			if(myBoxes[i].getSurfaceArea() < average) {
				counter++;
			}
		}
		return counter;
	}
	public static int countBoxesLesserThanAverage(Box[] myBoxes) {
		//initialize variables
		int counter = 0;
		double sum = 0;
		double average;
		//loop through array and sum the values of surface area
		for(int i = 0; i < myBoxes.length; i++) {
			sum += myBoxes[i].getSurfaceArea();

			//calculate average
			average = sum / myBoxes.length;

			// update counter for each box that has a surface area that is smaller than the average surface area
			if(myBoxes[i].getSurfaceArea() > average) {
				counter++;
			}
		}
		return counter;
	}
	public static void findBoxIndicesGreaterThanAverage(Box[] myBoxes) {
		//store average surface method in a variable
		double averageSurfaceArea = averageSurfaceArea(myBoxes);

		//loop through array and find the indices of the boxes with a larger surface area than the average surface area
		for (int i = 0; i < myBoxes.length; i++) {
			if(myBoxes[i].getSurfaceArea() > averageSurfaceArea) {
				//print the indices
				System.out.print(i < myBoxes.length  - i ? i + ", " : i);
			}
		}
	}
}