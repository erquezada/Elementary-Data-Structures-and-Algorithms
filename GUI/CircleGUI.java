import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Circle extends Artifact {
    private double radius;

    public void setRadius(double r) {
        radius = r;
    }

    public double getRadius() {
        return radius;
    }

    public double getArea() {
        return Math.PI * radius * radius; // Using Math.PI for accuracy
    }

    public double getPrice() {
        System.out.println("The price is zero: ");
        return 0.0;
    }
}

public class CircleGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Circle Area and Price Calculator");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JLabel radiusLabel = new JLabel("Enter radius:");
        JTextField radiusInput = new JTextField(10);
        JButton calculateButton = new JButton("Calculate");
        JLabel areaLabel = new JLabel("Area: ");
        JLabel priceLabel = new JLabel("Price: ");

        frame.add(radiusLabel);
        frame.add(radiusInput);
        frame.add(calculateButton);
        frame.add(areaLabel);
        frame.add(priceLabel);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double radius = Double.parseDouble(radiusInput.getText());
                    Circle circle = new Circle();
                    circle.setRadius(radius);

                    double area = circle.getArea();
                    double price = circle.getPrice();

                    areaLabel.setText("Area: " + area);
                    priceLabel.setText("Price: " + price);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid number for the radius.");
                }
            }
        });

        frame.setVisible(true);
    }
}
