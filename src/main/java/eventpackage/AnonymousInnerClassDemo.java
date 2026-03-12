package eventpackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnonymousInnerClassDemo extends JFrame {

    private JButton button;
    private JLabel label;

    public AnonymousInnerClassDemo() {
        setTitle("tooby be good boy for master");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        label = new JLabel("click toby to chage toby's color");
        button = new JButton("click toby, masta!");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button.setBackground(Color.BLUE);
                button.setForeground(Color.WHITE);
                button.setOpaque(true);
                label.setText("tovy likes blue");
            }
        });

        add(label);
        add(button);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AnonymousInnerClassDemo();
            }
        });
    }
}
