import javax.swing.*;
import java.io.File;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FileReaderGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("File Reader");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Create a JTextArea to display results
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Create a JButton to open a file dialog
        JButton openButton = new JButton("Open File");
        frame.add(openButton, BorderLayout.NORTH);

        // Add button action
        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(frame);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File inputFile = fileChooser.getSelectedFile();
                    try {
                        Scanner scanner = new Scanner(inputFile);
                        if (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            Scanner lineScanner = new Scanner(line);
                            int first = lineScanner.nextInt();
                            int second = lineScanner.nextInt();
                            textArea.setText("First number: " + first + "\nSecond number: " + second);
                        } else {
                            textArea.setText("Error: No content in file.");
                        }
                        scanner.close();
                    } catch (Exception ex) {
                        textArea.setText("Error: " + ex.getMessage());
                    }
                }
            }
        });

        frame.setVisible(true);
    }
}
