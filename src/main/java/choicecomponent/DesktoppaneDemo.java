package choicecomponent;

import javax.swing.*;
import java.awt.FlowLayout;

public class DesktoppaneDemo extends JFrame {

    JDesktopPane desktopPane;
    JInternalFrame if1, if2, if3, if4, if5;
    JLabel enterLabel, resultLabel;
    JTextField numberField;
    JButton calc;

    public DesktoppaneDemo() {
        setTitle("JDesktopPane Demonstration");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        desktopPane = new JDesktopPane();

        if1 = new JInternalFrame("factorial)", true, false, false, false);
        if1.setSize(250, 150);
        if1.setLocation(30, 30);
        
        enterLabel = new JLabel("enter number:");
        numberField = new JTextField(5);
        calc = new JButton("calculate");
        resultLabel = new JLabel("result: ");
        if1.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));

        
        calc.addActionListener(e -> {
            try {
                long num = Long.parseLong(numberField.getText().trim());
                if (num < 0) {
                    resultLabel.setText("result: invalid");
                } else {
                    long fact = 1;
                    for (long i = 1; i <= num; i++) {
                        fact *= i;
                    }
                    resultLabel.setText("result: " + fact);
                }
            } catch (NumberFormatException ex) {
                resultLabel.setText("result: error");
            }
        });
        
        if1.add(enterLabel);
        if1.add(numberField);
        if1.add(calc);
        if1.add(resultLabel);
        if1.setVisible(true);

        if2 = new JInternalFrame("closable ", false, true, false, false);
        if2.setSize(200, 150);
        if2.setLocation(250, 30);
        if2.setVisible(true);

        if3 = new JInternalFrame("maximizable ", false, false, true, false);
        if3.setSize(200, 150);
        if3.setLocation(30, 200);
        if3.setVisible(true);

        if4 = new JInternalFrame("iconifiable ", false, false, false, true);
        if4.setSize(200, 150);
        if4.setLocation(250, 200);
        if4.setVisible(true);
        
        if5 = new JInternalFrame("all attributes true", true, true, true, true);
        if5.setSize(250, 150);
        if5.setLocation(480, 115);
        if5.setVisible(true);

        desktopPane.add(if1);
        desktopPane.add(if2);
        desktopPane.add(if3);
        desktopPane.add(if4);
        desktopPane.add(if5);

        setContentPane(desktopPane);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DesktoppaneDemo frame = new DesktoppaneDemo();
            frame.setVisible(true);
        });
    }
}
