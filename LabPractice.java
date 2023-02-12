import java.io.*;
import java.util.Scanner;
public class LabPractice {
    public static void main(String[] args) throws IOException {
        String text = readString("sample.txt");
        //System.out.println(text);
        String[] words = readArray("sample.txt");
        for(int i = 0; i < words.length; i++) {
            System.out.println(words[i] + " ");
        }
        mostVowels(words);
    }
    public static String readString(String file) {
        String text = "";
        try {
            Scanner s = new Scanner(new File(file));
            while(s.hasNextLine()) {
                text = text + s.next() + " ";
            }
        }
        catch(FileNotFoundException e) {
            System.out.println("Error");
        }
        return text;
    }
    public static String[] readArray(String file) {
        int count = 0;
        try {
            Scanner s1 = new Scanner(new File(file));
            while(s1.hasNextLine()) {
                count++;
                s1.next();
            }
            String[] words = new String[count];
            Scanner s2 = new Scanner(new File(file));
            for(int i = 0; i < count; i++) {
                words[i] = s2.next();
            }
            return words;
        } catch(FileNotFoundException e) {
            System.out.println("File not found!");
        }
        return null;
    }
    public static void mostVowels(String[] words) {
        int maxVowel = 0;
        String tempWord = words.length > 0 ? words[0] : "";
        for (int i = 0; i < words.length; i++) {
            int count = 0;
            String temp = words[i].toLowerCase();
            for (int j = 0; j < temp.length(); j++) {
                char ch = temp.charAt(j);
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    count++;
                }
            }
            if (count > maxVowel) {
                maxVowel = count;
                tempWord = words[i];
            }
        }
        System.out.println("The word with the most vowels: " + tempWord);
    }    
}
