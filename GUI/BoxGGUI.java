import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Generic BoxG class
class BoxG<DIM> {
    DIM length;
    DIM width;
    DIM height;

    // Default constructor
    BoxG() {}

    // Constructor with parameters
    BoxG(DIM l, DIM w, DIM h) {
        length = l;
        width = w;
        height = h;
    }

    public String toString() {
        return "Length: " + length + "\tWidth: " + width + "\tHeight: " + height;
    }
}

// Main class to create the GUI
public class BoxGGUI extends JFrame {
    private JTextField lengthField, widthField, heightField;
    private JTextArea resultArea;
    private JButton createButton;
    private BoxG<Double> box;

    public BoxGGUI() {
        setTitle("Generic Box Dimensions");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Layout
        setLayout(new GridLayout(5, 2));

        // Labels and text fields
        add(new JLabel("Length:"));
        lengthField = new JTextField();
        add(lengthField);

        add(new JLabel("Width:"));
        widthField = new JTextField();
        add(widthField);

        add(new JLabel("Height:"));
        heightField = new JTextField();
        add(heightField);

        // Button to create the box
        createButton = new JButton("Create Box");
        add(createButton);

        // Text area to display the result
        resultArea = new JTextArea();
        resultArea.setEditable(false);
        add(new JScrollPane(resultArea));

        // Button action
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Get input values
                    double length = Double.parseDouble(lengthField.getText());
                    double width = Double.parseDouble(widthField.getText());
                    double height = Double.parseDouble(heightField.getText());

                    // Create a new BoxG object with the given dimensions
                    box = new BoxG<>(length, width, height);

                    // Display the box information in the result area
                    resultArea.setText("Box Created: \n" + box.toString());
                } catch (NumberFormatException ex) {
                    resultArea.setText("Please enter valid numerical values.");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BoxGGUI().setVisible(true);
            }
        });
    }
}
