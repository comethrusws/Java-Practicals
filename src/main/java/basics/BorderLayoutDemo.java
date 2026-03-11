import javax.swing.*;
import java.awt.*;

public class BorderLayoutDemo extends JFrame {
    String[] directions= {"North", "South", "East", "West", "Center"};
    public BorderLayoutDemo() {
        setTitle("BorderLayout Demo");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(5, 10)); 
        panel.setBackground(new Color(240, 240, 240));
        JButton btn[] = new JButton[5];
        for(int i=0; i<btn.length; i++) {
            btn[i] = new JButton("Button " + (i+1));
            panel.add(btn[i], directions[i]);
        }
        
        add(panel);

        setResizable(false);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BorderLayoutDemo();
            }
        });
    }
}