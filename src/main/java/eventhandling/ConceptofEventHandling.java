package eventhandling;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConceptofEventHandling implements ActionListener {
    private JFrame frame;
    private JButton button;
    private JLabel label;

    public ConceptofEventHandling() {
        // 1. Create the frame
        frame = new JFrame("Concept of Event Handling");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        // 2. Create the components (Event Sources)
        label = new JLabel("Click the button to trigger an event.");
        button = new JButton("Click Me!");

        // 3. Register the Event Listener to the Event Source
        // 'this' refers to the current class implementing ActionListener
        button.addActionListener(this);

        // 4. Add components to the frame
        frame.add(label);
        frame.add(button);

        // 5. Make the frame visible
        frame.setVisible(true);
    }

    // 6. Provide the Event Handler implementation
    // This method is called automatically when the button is clicked
    @Override
    public void actionPerformed(ActionEvent e) {
        // e.getSource() determines which component triggered the event
        if (e.getSource() == button) {
            label.setText("Button was clicked! Event Handled.");
            label.setForeground(Color.RED);
            
            // Optionally, show a popup dialog
            JOptionPane.showMessageDialog(frame, "Event handled successfully!");
        }
    }

    public static void main(String[] args) {
        // Run the application
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ConceptofEventHandling();
            }
        });
    }
}
