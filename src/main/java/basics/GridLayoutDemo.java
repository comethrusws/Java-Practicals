import javax.swing.*;
import java.awt.*;

public class GridLayoutDemo extends JFrame {
    public GridLayoutDemo() {
        setTitle("GridLayout Demo");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3, 5, 5)); 
        panel.setBackground(new Color(240, 240, 240));

        JButton btn[] = new JButton[12];
        for(int i=0; i<btn.length; i++) {
            btn[i] = new JButton("Button " + (i+1));
            panel.add(btn[i]);
        }
    
        add(panel);

        setVisible(true);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GridLayoutDemo();
            }
        });
    }
}