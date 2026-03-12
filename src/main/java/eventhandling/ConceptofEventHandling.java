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
        frame = new JFrame("Concept of Event Handling");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        label = new JLabel("Click the button to trigger an event.");
        button = new JButton("Click Me!");

        button.addActionListener(this);

        frame.add(label);
        frame.add(button);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // e.getSource() determines which component triggered the event
        if (e.getSource() == button) {
            label.setText("Button was clicked! Event Handled.");
            label.setForeground(Color.RED);
            button.setBackground(Color.GREEN);
            button.setOpaque(true);
            
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
