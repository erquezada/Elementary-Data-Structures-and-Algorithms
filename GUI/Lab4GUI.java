import javax.swing.*;
import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lab4GUI {

    public static void main(String[] args) {
        // Set up the frame for the GUI
        JFrame frame = new JFrame("Capital Analysis");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Set up the panel and layout
        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);

        // Create UI components (labels, buttons, text area for output)
        JLabel label = new JLabel("Choose a CSV file and analyze:");
        label.setBounds(20, 20, 300, 30);
        panel.add(label);

        JButton browseButton = new JButton("Browse");
        browseButton.setBounds(20, 60, 100, 30);
        panel.add(browseButton);

        JTextArea textArea = new JTextArea();
        textArea.setBounds(20, 100, 540, 200);
        textArea.setEditable(false);
        panel.add(textArea);

        JButton analyzeButton = new JButton("Analyze");
        analyzeButton.setBounds(140, 60, 100, 30);
        panel.add(analyzeButton);

        // Add action listener for "Browse" button to select file
        browseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    String path = fileChooser.getSelectedFile().getAbsolutePath();
                    textArea.setText("File selected: " + path + "\n");
                    analyzeButton.setEnabled(true);
                    analyzeButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            String[][] statesAndCapitals = parseArray(path);
                            StringBuilder output = new StringBuilder();
                            output.append(largestCapName(statesAndCapitals));
                            output.append(mostVowels(statesAndCapitals));
                            output.append(mostPopulated(statesAndCapitals));
                            output.append(secMostPopulated(statesAndCapitals));
                            output.append(thirdMostPopulated(statesAndCapitals));
                            output.append(largestStateName(statesAndCapitals));

                            textArea.setText(output.toString());
                        }
                    });
                }
            }
        });

        // Make frame visible
        frame.setVisible(true);
    }

    // Method to parse the CSV file and load into a 2D array
    public static String[][] parseArray(String path) {
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
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringArray;
    }

    // Helper method to extract states from the 2D array
    public static String[] getStates(String[][] data) {
        String[] states = new String[data.length];
        for(int i = 0; i < states.length; i++) {
            states[i] = data[i][0];
        }
        return states;
    }

    // Helper method to extract capitals from the 2D array
    public static String[] getCapitals(String[][] data) {
        String[] capitals = new String[data.length];
        for(int i = 0; i < capitals.length; i++) {
            capitals[i] = data[i][1];
        }
        return capitals;
    }

    // Helper method to extract population from the 2D array
    public static int[] getPopulation(String[][] data) {
        int[] populationOfCapitals = new int[data.length];
        for(int i = 0; i < populationOfCapitals.length; i++) {
            populationOfCapitals[i] = Integer.parseInt(data[i][2]);
        }
        return populationOfCapitals;
    }

    // Method to find the capital with the largest name
    public static String largestCapName(String[][] data){
        StringBuilder result = new StringBuilder("------------Analyzing capital names------------\n");
        int largestCapitalName = 0;
        String printLargestCapName = "";
        String[] listOfCapitals = getCapitals(data);
        for (String listOfCapital : listOfCapitals) {
            if (listOfCapital.length() > largestCapitalName) {
                largestCapitalName = listOfCapital.length();
                printLargestCapName = listOfCapital;
            }
        }
        result.append("The capital with the largest name: ").append(printLargestCapName).append("\n");
        return result.toString();
    }

    // Method to find the capital with the most vowels
    public static String mostVowels(String[][] data){
        StringBuilder result = new StringBuilder("------------Analyzing vowels------------\n");
        String[] countVowelsInArray = getCapitals(data);
        int maxVowel = 0;
        String tempCapName = "";
        for (String s : countVowelsInArray) {
            int vowelCounter = 0;
            String temp = s.toLowerCase();
            for (int j = 0; j < temp.length(); j++) {
                char ch = temp.charAt(j);
                if ("aeiou".indexOf(ch) != -1) {
                    vowelCounter++;
                    if (vowelCounter >= maxVowel) {
                        maxVowel = vowelCounter;
                        tempCapName = s;
                    }
                }
            }
        }
        result.append("Capital with the most vowels: ").append(tempCapName).append("\n");
        return result.toString();
    }

    // Method to find the most populated capital
    public static String mostPopulated(String[][] data){
        StringBuilder result = new StringBuilder("--------------Analyzing population--------------\n");
        int max = Integer.MIN_VALUE;
        String printMostPopulatedStateCapital = "";
        String printMostPopulatedStateName = "";
        String[] listOfStates = getStates(data);
        String[] listOfCapitals = getCapitals(data);
        int[] capitalsPopulation = getPopulation(data);
        for(int i = 0; i < capitalsPopulation.length; i++) {
            if (capitalsPopulation[i] > max) {
                max = capitalsPopulation[i];
                printMostPopulatedStateCapital = listOfCapitals[i];
                printMostPopulatedStateName = listOfStates[i];
            }
        }
        result.append("Most populated capital: ").append(printMostPopulatedStateCapital)
              .append(" in ").append(printMostPopulatedStateName)
              .append("\nThe population is: ").append(max).append("\n");
        return result.toString();
    }

    // Method to find the second most populated capital
    public static String secMostPopulated(String[][] data) {
        StringBuilder result = new StringBuilder();
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        String printMostPopulatedStateCapital = "";
        String printMostPopulatedStateName = "";
        int[] capitalsPopulation = getPopulation(data);
        String[] listOfCapitals = getCapitals(data);
        String[] listOfStates = getStates(data);
        for (int i = 0; i < capitalsPopulation.length; i++) {
            if (capitalsPopulation[i] > max) {
                secondMax = max;
                max = capitalsPopulation[i];
            } else if (capitalsPopulation[i] > secondMax) {
                secondMax = capitalsPopulation[i];
                printMostPopulatedStateCapital = listOfCapitals[i];
                printMostPopulatedStateName = listOfStates[i];
            }
        }
        result.append("Second most populated capital: ").append(printMostPopulatedStateCapital)
              .append(" in ").append(printMostPopulatedStateName)
              .append("\nThe population is: ").append(secondMax).append("\n");
        return result.toString();
    }

    // Method to find the third most populated capital
    public static String thirdMostPopulated(String[][] data) {
        StringBuilder result = new StringBuilder();
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int thirdMax = Integer.MIN_VALUE;
        int[] capitalsPopulation = getPopulation(data);
        String[] listOfCapitals = getCapitals(data);
        String[] listOfStates = getStates(data);
        for (int i : capitalsPopulation) {
            if (max < i) {
                max = i;
            }
        }
        for (int i : capitalsPopulation) {
            if (secondMax < i && max > i) {
                secondMax = i;
            }
        }
        for (int i = 0; i < capitalsPopulation.length; i++) {
            if (thirdMax < capitalsPopulation[i] && secondMax > capitalsPopulation[i]) {
                thirdMax = capitalsPopulation[i];
                result.append("Third most populated capital: ").append(listOfCapitals[i])
                      .append(" in ").append(listOfStates[i])
                      .append("\nThe population is: ").append(thirdMax).append("\n");
            }
        }
        return result.toString();
    }

    // Method to find the state with the largest name
    public static String largestStateName(String[][] data) {
        StringBuilder result = new StringBuilder("------------Analyzing state names------------\n");
        int largestStateName = 0;
        String printLargestStateName = "";
        String[] listOfStates = getStates(data);
        for (String listOfState : listOfStates) {
            if (listOfState.length() > largestStateName) {
                largestStateName = listOfState.length();
                printLargestStateName = listOfState;
            }
        }
        result.append("The state with the largest name: ").append(printLargestStateName).append("\n");
        return result.toString();
    }
}
