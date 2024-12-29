import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class LabPracticeGUI extends JFrame {
    private JTextArea textArea;
    private JButton loadButton, showWordsButton, mostVowelsButton;
    private JFileChooser fileChooser;
    private String[] words;

    public LabPracticeGUI() {
        setTitle("Lab Practice GUI");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set up text area to display content
        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        
        // Set up buttons
        loadButton = new JButton("Load File");
        showWordsButton = new JButton("Show Words");
        mostVowelsButton = new JButton("Word with Most Vowels");
        
        // File chooser to select file
        fileChooser = new JFileChooser();
        
        // Button listeners
        loadButton.addActionListener(new LoadFileAction());
        showWordsButton.addActionListener(new ShowWordsAction());
        mostVowelsButton.addActionListener(new MostVowelsAction());

        // Layout
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(loadButton);
        panel.add(showWordsButton);
        panel.add(mostVowelsButton);

        setLayout(new BorderLayout());
        add(panel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    private class LoadFileAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int returnValue = fileChooser.showOpenDialog(LabPracticeGUI.this);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                words = readArray(file);
                textArea.setText("File loaded successfully.\n");
            }
        }
    }

    private class ShowWordsAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (words != null) {
                textArea.setText("Words in the file:\n");
                for (String word : words) {
                    textArea.append(word + " ");
                }
                textArea.append("\n");
            } else {
                textArea.setText("No file loaded yet.\n");
            }
        }
    }

    private class MostVowelsAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (words != null && words.length > 0) {
                String wordWithMostVowels = mostVowels(words);
                textArea.setText("Word with most vowels: " + wordWithMostVowels + "\n");
            } else {
                textArea.setText("No file loaded yet.\n");
            }
        }
    }

    public String[] readArray(File file) {
        List<String> wordList = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                wordList.add(scanner.next());
            }
        } catch (FileNotFoundException e) {
            textArea.setText("File not found!\n");
            return null;
        }
        return wordList.toArray(new String[0]);
    }

    public String mostVowels(String[] words) {
        int maxVowelCount = 0;
        String wordWithMostVowels = words[0];
        
        for (String word : words) {
            int vowelCount = countVowels(word);
            if (vowelCount > maxVowelCount) {
                maxVowelCount = vowelCount;
                wordWithMostVowels = word;
            }
        }
        return wordWithMostVowels;
    }

    private int countVowels(String word) {
        int count = 0;
        for (char c : word.toLowerCase().toCharArray()) {
            if ("aeiou".indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LabPracticeGUI gui = new LabPracticeGUI();
            gui.setVisible(true);
        });
    }
}
