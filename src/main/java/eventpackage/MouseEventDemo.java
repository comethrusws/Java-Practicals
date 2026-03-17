package eventpackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseEventDemo extends JFrame implements MouseListener, MouseMotionListener, MouseWheelListener {

    private JLabel statusLabel;
    private JPanel mousePanel;

    public MouseEventDemo() {
        setTitle("Mouse Event Demo");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        statusLabel = new JLabel("Perform a mouse action", JLabel.CENTER);
        add(statusLabel, BorderLayout.SOUTH);

        mousePanel = new JPanel();
        mousePanel.setBackground(Color.LIGHT_GRAY);
        mousePanel.addMouseListener(this);
        mousePanel.addMouseMotionListener(this);
        mousePanel.addMouseWheelListener(this);
        add(mousePanel, BorderLayout.CENTER);

        setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        statusLabel.setText("Mouse Clicked at (" + e.getX() + ", " + e.getY() + ")");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        statusLabel.setText("Mouse Pressed at (" + e.getX() + ", " + e.getY() + ")");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        statusLabel.setText("Mouse Released at (" + e.getX() + ", " + e.getY() + ")");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        statusLabel.setText("Mouse Entered at (" + e.getX() + ", " + e.getY() + ")");
        mousePanel.setBackground(Color.CYAN);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        statusLabel.setText("Mouse Exited");
        mousePanel.setBackground(Color.LIGHT_GRAY);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        statusLabel.setText("Mouse Dragged at (" + e.getX() + ", " + e.getY() + ")");
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        statusLabel.setText("Mouse Moved at (" + e.getX() + ", " + e.getY() + ")");
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        statusLabel.setText("Mouse Wheel Moved. Rotation: " + e.getWheelRotation());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MouseEventDemo::new);
    }
}
