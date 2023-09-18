import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
public class Runner_Quezada{
	public static void main(String[] args) throws FileNotFoundException {
		//read file and scan file
		File fileReader = new File("input.txt");
		Scanner scnr = new Scanner(fileReader);

		// instantiate object
		Circle[] circles = new Circle[10];
		Circle[] circlesTwo = new Circle[3];
		// for merging two cricles
		circlesTwo[0] = new Circle(4.6);
		circlesTwo[1] = new Circle(2.5);
		circlesTwo[2] = new Circle(3.25);
		int i = 0;

		// parse values from txt file into box object
		while (scnr.hasNextDouble()) {
			double radius = scnr.nextDouble();
			Circle myCircles = new Circle();
			myCircles.setRadius(radius);
			circles[i] = myCircles;
			i++;
		}
		for (int j = 0; j < circles.length; j++) {
			System.out.println(circles[j].getRadius());
		}

		for(int k = 0; k < circlesTwo.length; k++) {
			System.out.println(circlesTwo[k].getRadius());
		}
		Circle givenCircle = new Circle(4);
		System.out.println("Circles that are larger than given circle are: " + countLarger(circles, givenCircle));
		printArray(circles);
		reverseArray(circles);
		System.out.println("Sum of the area for all circles is: " + sumArea(circles));
		System.out.println();
		printOdd(circles);
		System.out.println("Merged two circle arrays: " + Arrays.deepToString(merge(circles, circlesTwo)));
	}
	public static int countLarger(Circle[] r, Circle given) { //Status: Method countLarger counts the circles of the array whose area is greater than a given starting circle.
		// This is a int method, so it does return the counter of the circles of the array whose area is greater than a given starting point. Method is working properly.
		int count = 0;
		for(int i = 0; i < r.length; i++) {
			if(r[i].getArea() > given.getArea()) {
				count++;
			}
		}
		return count;
	}
	public static void printArray(Circle[] r) {// not required but helps to know how to print forwards and backwards :)
		int i;
		System.out.println("Printing forwards");
		for(i = 0; i < r.length; i++) {
			System.out.println(r[i].getRadius());
		}
	}
	public static void reverseArray(Circle[] r) {//Status: Method reverseArray reverses the order of the Circles,
		// so instead of printing forwards from first circle (0th), we print from the last circle all the way to the first circle.
		// This is a void method, so it does not return anything. This method is working properly
		int i;
		for (i = 0; i < r.length / 2; i++) {
			Circle temp = r[i];
			r[i] = r[r.length - 1 - i];
			r[r.length - 1 - i] = temp;
		}
		System.out.println("Printing backwards");
		for(int j = 0; j < r.length; j++) {
			System.out.println(r[j].getRadius());
		}
	}
	public static Circle[] merge(Circle[] c1, Circle[] c2) {//Status: Method merge combines two distinct arrays of type circle and returns a new unique array of type circle.
		//This method is an array of object Circle, so it returns the memory address of the merged circle object.
		// Method is working properly.
		Circle[] mergedCircle = new Circle[c1.length + c2.length];
		int i;
		for (i = 0; i < c1.length; i++) {
			mergedCircle[i] = c1[i];
		}
		for(int j = 0; j < c2.length; j++) {
			mergedCircle[i] = c2[j];
			i++;
		}
		return mergedCircle;
	}
	public static void printOdd(Circle[] c1) {//Status: Method printOdd prints the areas of the circles whose area is odd.
		// This is a void method, so it does not return anything. This method is working properly
		for(int i = 0; i < c1.length; i++) {
			if(c1[i].getArea()%2!=0) {
				System.out.println(c1[i].getArea());
			}
		}
	}
	public static double sumArea(Circle[] c1) {//Status: Method sumArea sum the area of the circles.
		// This is a double method, so it does return the sum of the areas for the circles. Method is working properly
		double sum = 0;
		for(int i = 0; i < c1.length; i++) {
			sum += c1[i].getArea();
		}
		return sum;
	}
}