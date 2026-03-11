import javax.swing.*;
import java.awt.*;

public class FlowLayoutDemo extends JFrame {
    
    public FlowLayoutDemo() {
        setTitle("FlowLayout Demo");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));  // Default FlowLayout - CENTER aligned
        panel.setBackground(new Color(240, 240, 240));
        
        JButton btn[] = new JButton[5];
        for(int i=0; i<btn.length; i++) {
            btn[i] = new JButton("Button " + (i+1));
            panel.add(btn[i]);
        }
        
        // Add panel to frame
        add(panel);
        
        // Make frame visible
        setVisible(true);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FlowLayoutDemo();
            }
        });
    }
}