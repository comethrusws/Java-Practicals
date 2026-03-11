import javax.swing.*;
import java.awt.*;

public class GridBagLayoutDemo extends JFrame {
    public GridBagLayoutDemo() {
        setTitle("GridBagLayout Demo");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(new Color(240, 240, 240));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Button 1 - Wide button spanning 2 columns
        JButton btn1 = new JButton("so so wide");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.weightx = 2.0;
        gbc.weighty = 1.0;
        panel.add(btn1, gbc);

        // Button 2 - Tall button spanning 2 rows
        JButton btn2 = new JButton("long button hehe");
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 2.0;
        panel.add(btn2, gbc);

        // Button 3 - Regular size
        JButton btn3 = new JButton("Button 3");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        panel.add(btn3, gbc);

        // Button 4 - Regular size
        JButton btn4 = new JButton("Button 4");
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(btn4, gbc);

        // Button 5 - Big button spanning 2x2
        JButton btn5 = new JButton("THIS IS B I G.");
        btn5.setBackground(new Color(100, 150, 250));
        btn5.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.gridheight = 2;
        gbc.weightx = 2.0;
        gbc.weighty = 2.0;
        panel.add(btn5, gbc);

        // Button 6 - Regular size
        JButton btn6 = new JButton("Button 6");
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        panel.add(btn6, gbc);

        // Button 8 - Long horizontal button spanning 3 columns
        JButton btn8 = new JButton("mmmmmmmmmm very long");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        gbc.weightx = 3.0;
        gbc.weighty = 1.0;
        panel.add(btn8, gbc);

        // "Good" button - spans 1.5 width
        JButton btnGood = new JButton("GOOD");
        btnGood.setBackground(new Color(46, 204, 113));
        btnGood.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.weightx = 2.0;
        gbc.weighty = 1.0;
        panel.add(btnGood, gbc);

        // "Bad" button
        JButton btnBad = new JButton("BAD");
        btnBad.setBackground(new Color(231, 76, 60));
        btnBad.setForeground(Color.WHITE);
        gbc.gridx = 2;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        panel.add(btnBad, gbc);
    
        add(panel);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GridBagLayoutDemo();
            }
        });
    }
}