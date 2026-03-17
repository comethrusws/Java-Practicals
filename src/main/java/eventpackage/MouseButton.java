package eventpackage;

import javax.swing.*;
import java.awt.event.*;

public class MouseButton extends JFrame implements MouseListener {

    private JButton button;
    private JPanel panel;

    public MouseButton() {
        setTitle("zis buttom movesa!");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);
        panel.addMouseListener(this);

        button = new JButton("click me");
        button.setBounds(200, 200, 100, 40);
        panel.add(button);

        add(panel);
        setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        button.setLocation(x - button.getWidth() / 2, y - button.getHeight() / 2);
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MouseButton::new);
    }
}
