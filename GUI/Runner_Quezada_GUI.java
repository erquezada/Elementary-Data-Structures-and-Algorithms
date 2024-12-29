import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

class Circle {
    private double radius;

    public Circle() {}

    public Circle(double radius) {
        this.radius = radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double getArea() {
        return Math.PI * radius * radius; // Use Math.PI for precision
    }
}

public class Runner_Quezada_GUI {
    private static Circle[] circles = new Circle[10];
    private static Circle[] circlesTwo = new Circle[3];

    public static void main(String[] args) throws FileNotFoundException {
        JFrame frame = new JFrame("Circle Operations");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JLabel inputLabel = new JLabel("Enter the radius values (comma-separated):");
        JTextField inputField = new JTextField(20);
        JButton loadButton = new JButton("Load Circles");
        JButton countButton = new JButton("Count Larger Circles");
        JButton sumAreaButton = new JButton("Sum of Areas");
        JButton mergeButton = new JButton("Merge Circles");

        JTextArea outputArea = new JTextArea(10, 40);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        frame.add(inputLabel);
        frame.add(inputField);
        frame.add(loadButton);
        frame.add(countButton);
        frame.add(sumAreaButton);
        frame.add(mergeButton);
        frame.add(scrollPane);

        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String inputText = inputField.getText();
                    String[] radiiStrings = inputText.split(",");
                    for (int i = 0; i < radiiStrings.length; i++) {
                        double radius = Double.parseDouble(radiiStrings[i].trim());
                        circles[i] = new Circle(radius);
                    }
                    outputArea.setText("Circles loaded:\n");
                    for (int i = 0; i < circles.length; i++) {
                        if (circles[i] != null) {
                            outputArea.append("Radius: " + circles[i].getRadius() + ", Area: " + circles[i].getArea() + "\n");
                        }
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter valid numbers for the radius.");
                }
            }
        });

        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Circle givenCircle = new Circle(4); // Example fixed circle
                int count = countLarger(circles, givenCircle);
                outputArea.append("Circles larger than the given circle: " + count + "\n");
            }
        });

        sumAreaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double sum = sumArea(circles);
                outputArea.append("Sum of areas: " + sum + "\n");
            }
        });

        mergeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                circlesTwo[0] = new Circle(4.6);
                circlesTwo[1] = new Circle(2.5);
                circlesTwo[2] = new Circle(3.25);

                Circle[] mergedCircles = merge(circles, circlesTwo);
                outputArea.append("Merged circles: " + Arrays.deepToString(mergedCircles) + "\n");
            }
        });

        frame.setVisible(true);
    }

    public static int countLarger(Circle[] r, Circle given) {
        int count = 0;
        for (int i = 0; i < r.length; i++) {
            if (r[i] != null && r[i].getArea() > given.getArea()) {
                count++;
            }
        }
        return count;
    }

    public static double sumArea(Circle[] c1) {
        double sum = 0;
        for (int i = 0; i < c1.length; i++) {
            if (c1[i] != null) {
                sum += c1[i].getArea();
            }
        }
        return sum;
    }

    public static Circle[] merge(Circle[] c1, Circle[] c2) {
        Circle[] mergedCircle = new Circle[c1.length + c2.length];
        int i;
        for (i = 0; i < c1.length; i++) {
            mergedCircle[i] = c1[i];
        }
        for (int j = 0; j < c2.length; j++) {
            mergedCircle[i] = c2[j];
            i++;
        }
        return mergedCircle;
    }
}
