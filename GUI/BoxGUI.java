import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoxGUI extends JFrame {
    private JTextField widthField, heightField, lengthField;
    private JTextArea resultArea;
    private JButton calculateButton, compareButton;
    private Box box1, box2;

    public BoxGUI() {
        setTitle("Box Volume Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Layout
        setLayout(new GridLayout(5, 2));

        // Labels and TextFields
        add(new JLabel("Width:"));
        widthField = new JTextField();
        add(widthField);

        add(new JLabel("Height:"));
        heightField = new JTextField();
        add(heightField);

        add(new JLabel("Length:"));
        lengthField = new JTextField();
        add(lengthField);

        // Buttons
        calculateButton = new JButton("Calculate Volume");
        add(calculateButton);

        compareButton = new JButton("Compare Boxes");
        add(compareButton);

        // TextArea for results
        resultArea = new JTextArea();
        resultArea.setEditable(false);
        add(new JScrollPane(resultArea));

        // Button actions
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double width = Double.parseDouble(widthField.getText());
                double height = Double.parseDouble(heightField.getText());
                double length = Double.parseDouble(lengthField.getText());
                box1 = new Box(width, height, length);
                resultArea.setText("Box 1: \n" + box1.toString());
            }
        });

        compareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (box1 != null && box2 != null) {
                    int comparisonResult = box1.compareTo(box2);
                    String comparisonMessage;
                    if (comparisonResult > 0) {
                        comparisonMessage = "Box 1 is larger than Box 2";
                    } else if (comparisonResult < 0) {
                        comparisonMessage = "Box 1 is smaller than Box 2";
                    } else {
                        comparisonMessage = "Both boxes have the same volume";
                    }
                    resultArea.append("\n" + comparisonMessage);
                } else {
                    resultArea.setText("Please calculate both boxes before comparing.");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BoxGUI().setVisible(true);
            }
        });
    }

    // Box class
    public class Box {
        private double width, height, length;

        Box(double w, double h, double l) {
            width = w;
            height = h;
            length = l;
        }

        private double getVolume() {
            return width * height * length;
        }

        public int compareTo(Box o) {
            double myVol = this.getVolume();
            double thatVol = o.getVolume();
            if (myVol > thatVol)
                return 1;
            else if (myVol < thatVol)
                return -1;
            else
                return 0;
        }

        public String toString() {
            return "Width: " + width +
                    "\tHeight: " + height +
                    "\tLength: " + length +
                    "\tVolume: " + getVolume();
        }
    }
}
