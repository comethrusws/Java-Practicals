package eventpackage;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowEventDemo extends JFrame implements WindowListener {

    private JLabel statusLabel;

    public WindowEventDemo() {
        setTitle("Window Event Demonstration");
        setSize(400, 300);
        
        // We do not exit on close by default so we can catch windowClosing,
        // but we'll manually exit when it closes if we want to.
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        statusLabel = new JLabel("Status: Window Created", SwingConstants.CENTER);
        add(statusLabel);
        
        // Register the WindowListener
        addWindowListener(this);
        
        setVisible(true);
    }

    // --- WindowListener Methods ---

    @Override
    public void windowOpened(WindowEvent e) {
        System.out.println("Window Opened: The window has become visible for the first time.");
        statusLabel.setText("Status: Window Opened");
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("Window Closing: The user is trying to close the window.");
        statusLabel.setText("Status: Window Closing...");
        
        // Custom close confirmation
        int choice = JOptionPane.showConfirmDialog(this, 
            "Are you sure you want to exit?", "Confirm Exit", 
            JOptionPane.YES_NO_OPTION);
            
        if (choice == JOptionPane.YES_OPTION) {
            // Proceed to close the window
            e.getWindow().dispose();
            System.exit(0);
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {
        // This is called after the window has been closed/disposed
        System.out.println("Window Closed: The window has successfully closed.");
    }

    @Override
    public void windowIconified(WindowEvent e) {
        System.out.println("Window Iconified: The window was minimized.");
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        System.out.println("Window Deiconified: The window was restored from minimized state.");
        statusLabel.setText("Status: Window Restored");
    }

    @Override
    public void windowActivated(WindowEvent e) {
        System.out.println("Window Activated: The window became the active/focused window.");
        statusLabel.setText("Status: Window Activated");
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        System.out.println("Window Deactivated: The window lost focus.");
        statusLabel.setText("Status: Window Deactivated");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new WindowEventDemo();
            }
        });
    }
}
