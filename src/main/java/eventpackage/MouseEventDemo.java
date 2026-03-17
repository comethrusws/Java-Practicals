package eventpackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseEventDemo extends JFrame implements MouseListener, MouseMotionListener, MouseWheelListener {

    private JLabel statusLabel;
    private JPanel mousePanel;
    private JTextArea eventLog;

    public MouseEventDemo() {
        setTitle("Mouse Event Demo");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        statusLabel = new JLabel("Perform a mouse action in the gray area", JLabel.CENTER);
        statusLabel.setFont(new Font("Arial", Font.BOLD, 14));
        statusLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(statusLabel, BorderLayout.NORTH);

        mousePanel = new JPanel();
        mousePanel.setBackground(Color.LIGHT_GRAY);
        mousePanel.addMouseListener(this);
        mousePanel.addMouseMotionListener(this);
        mousePanel.addMouseWheelListener(this);
        add(mousePanel, BorderLayout.CENTER);

        eventLog = new JTextArea();
        eventLog.setEditable(false);
        eventLog.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(eventLog);
        scrollPane.setPreferredSize(new Dimension(250, 0));
        scrollPane.setBorder(BorderFactory.createTitledBorder("Event Log"));
        add(scrollPane, BorderLayout.EAST);

        setVisible(true);
    }

    private void logEvent(String eventName, MouseEvent e) {
        statusLabel.setText(eventName + " at (" + e.getX() + ", " + e.getY() + ")");
        eventLog.append(eventName + " at (" + e.getX() + ", " + e.getY() + ")\n");
        eventLog.setCaretPosition(eventLog.getDocument().getLength());
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        logEvent("Mouse Clicked", e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        logEvent("Mouse Pressed", e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        logEvent("Mouse Released", e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        logEvent("Mouse Entered", e);
        mousePanel.setBackground(Color.CYAN);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        logEvent("Mouse Exited", e);
        mousePanel.setBackground(Color.LIGHT_GRAY);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        logEvent("Mouse Dragged", e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        logEvent("Mouse Moved", e);
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        statusLabel.setText("Mouse Wheel Moved. Rotation: " + e.getWheelRotation());
        eventLog.append("Mouse Wheel scrolled. Rotation: " + e.getWheelRotation() + "\n");
        eventLog.setCaretPosition(eventLog.getDocument().getLength());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MouseEventDemo::new);
    }
}
