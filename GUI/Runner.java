import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CircleGUI extends JFrame {
    private JTextField radiusField;
    private JLabel radiusLabel, priceLabel;
    private JButton calculateButton;
    private Circle circle;

    public CircleGUI() {
        // Initialize the frame
        setTitle("Circle Calculator");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Initialize components
        radiusLabel = new JLabel("Enter Radius:");
        radiusField = new JTextField(10);
        calculateButton = new JButton("Calculate");
        priceLabel = new JLabel("Price: $0.0");

        // Add components to the frame
        add(radiusLabel);
        add(radiusField);
        add(calculateButton);
        add(priceLabel);

        // Initialize Circle object
        circle = new Circle();

        // Add button listener
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double radius = Double.parseDouble(radiusField.getText());
                    circle.setRadius(radius);
                    double price = circle.getPrice();
                    priceLabel.setText("Price: $" + price);
                } catch (NumberFormatException ex) {
                    priceLabel.setText("Invalid input!");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CircleGUI().setVisible(true);
            }
        });
    }
}

class Circle {
    private double radius;

    public Circle() {
        this.radius = 0;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double getPrice() {
        // Price is calculated as a simple formula: price = radius * 0.5
        return radius * 0.5;
    }
}
