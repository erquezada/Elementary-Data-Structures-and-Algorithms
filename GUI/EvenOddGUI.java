import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EvenOddGUI {
    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Even or Odd Checker");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Create components
        JLabel promptLabel = new JLabel("Enter a number:");
        JTextField numberInput = new JTextField(10);
        JButton checkButton = new JButton("Check");
        JLabel resultLabel = new JLabel("Result: ");
        
        // Set layout
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        
        // Add components to frame
        frame.add(promptLabel);
        frame.add(numberInput);
        frame.add(checkButton);
        frame.add(resultLabel);
        
        // Set visibility
        frame.setVisible(true);
        
        // Add ActionListener to the button
        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int n = Integer.parseInt(numberInput.getText());
                    if (n % 2 == 0) {
                        resultLabel.setText("Result: Even");
                    } else {
                        resultLabel.setText("Result: Odd");
                    }
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Invalid input, please enter an integer.");
                }
            }
        });
    }
}
