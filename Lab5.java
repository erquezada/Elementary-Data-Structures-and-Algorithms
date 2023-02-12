import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Lab5 {
    public static void main(String[] args)  {
        // You are not allowed to change the main method.
        String inputfilename = "input.txt";
        String outputfilename = "output.txt";
        PlanetLinkedList solarSystem = constructLLFromFile(inputfilename);

        solarSystem.printLL();

        System.out.println();

        System.out.println("Number of nodes in the linked list: " + solarSystem.countNodes());

        System.out.println();

        System.out.println("I will find diameter 4879 in the linked list.");
        solarSystem.search(4879);
        System.out.println();

        System.out.println("I will find diameter 12756 in the linked list.");
        solarSystem.search(12756);
        System.out.println();

        System.out.println("I will find Neptune in the linked list.");
        solarSystem.search("Neptune");
        System.out.println();

        System.out.println("I will find Pluto in the linked list.");
        solarSystem.search("Pluto");
        System.out.println();

        System.out.println("I will find Jupiter in the linked list.");
        solarSystem.search("Jupiter");
        System.out.println();

        System.out.println("I am going to remove the current head.");
        solarSystem.remove(0);

        System.out.println();

        solarSystem.printLL();

        System.out.println();

        System.out.println("I am going to insert a new record in position 4.");

        Planet aNewPlanet = new Planet("Jupiter", 142984, 67);
        solarSystem.insert(aNewPlanet, 4);

        System.out.println();

        solarSystem.printLL();

        System.out.println("I am going to insert a new planet in position 5.");

        aNewPlanet = new Planet("Uranus", 51118, 27);
        solarSystem.insert(aNewPlanet, 5);

        System.out.println();

        solarSystem.printLL();

        System.out.println("I am going to insert a new planet in position 7.");

        aNewPlanet = new Planet("Neptune", 49528, 14);
        solarSystem.insert(aNewPlanet, 7);

        System.out.println();

        solarSystem.printLL();


        System.out.println();
        System.out.println("I am going to swap position 0 and 3.");
        solarSystem.swap(0, 3);

        System.out.println();
        solarSystem.printLL();

        System.out.println();
        System.out.println("I am going to swap position 1 and 7.");
        solarSystem.swap(1, 7);

        System.out.println();
        System.out.println("I am going to swap position 1 and 4.");
        solarSystem.swap(1, 4);

        System.out.println();
        solarSystem.printLL();

        System.out.println();
        System.out.println("I am going to write the linked list to file: " + outputfilename);
        solarSystem.writeLinkedListToFile(outputfilename);

    }
    static PlanetLinkedList constructLLFromFile(String theInputFile) {
        System.out.println("Constructing the linked list from " + theInputFile);
        // Change the body of this method to construct the required linked list.

        try {
            File file = new File(theInputFile); // read file
            Scanner fileScanner = new Scanner(file); // scan file
            String name = fileScanner.nextLine(); // parse strings from file
            long diameter = Long.parseLong(fileScanner.nextLine()); // parse longs from file
            int moon = Integer.parseInt(fileScanner.nextLine()); // parse ints from file
            Planet head = new Planet(name, diameter, moon); // initial planet to be the head node
            Planet temp = head; // temp planet to be used as a placeholder

            while (fileScanner.hasNextLine()) { // scan through the other lines of the file
                name = fileScanner.nextLine(); //  parse strings from file
                diameter = Long.parseLong(fileScanner.nextLine()); // parse longs from file
                moon = Integer.parseInt(fileScanner.nextLine()); // parse ints from file
                temp.next = new Planet(name,diameter, moon); // temp's next pointer receives a new planet object so long as there is a data to be parsed from file
                temp = temp.next; // temp points to a next planet
            }
            return new PlanetLinkedList(head); // return link list

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}