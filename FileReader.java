import java.io.File;
import java.util.Scanner;

public class FileReader {
    public static void main(String[] args) {
        try {
            File inputFile = new File("input.txt");
            if (!inputFile.exists()) {
                System.out.println("Error: input file not found.");
                return;
            }

            Scanner scanner = new Scanner(inputFile);
            String line = scanner.nextLine();
            Scanner lineScanner = new Scanner(line);
            int first = lineScanner.nextInt();
            int second = lineScanner.nextInt();
            System.out.println(first);
            System.out.println(second);
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}