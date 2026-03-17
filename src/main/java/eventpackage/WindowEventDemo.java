package eventpackage;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowEventDemo extends JFrame implements WindowListener {

    private JLabel statusLabel;

    public WindowEventDemo() {
        setTitle("Window Event Demonstration");
        setSize(400, 300);
        
        // we do not exit on close by default so we can catch windowclosing,
        // but we'll manually exit when it closes if we want to.
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        statusLabel = new JLabel("sup brother?", SwingConstants.CENTER);
        add(statusLabel);
        
        // register the windowlistener
        addWindowListener(this);
        
        setVisible(true);
    }

    // --- windowlistener methods ---

    @Override
    public void windowOpened(WindowEvent e) {
        System.out.println("window opened for the first time... finally");
        statusLabel.setText("heheh hallo");
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("window closing... user clicked the cross button");
        statusLabel.setText("window closing? ts sad bruh...");
        
        // custom close confirmation
        int choice = JOptionPane.showConfirmDialog(this, 
            "sure to exit bro?", "Confirm Exit", 
            JOptionPane.YES_NO_OPTION);
            
        if (choice == JOptionPane.YES_OPTION) {
            // proceed to close the window
            e.getWindow().dispose();
            System.exit(0);
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {
        // this is called after the window has been closed/disposed
        System.out.println("window is closed completely now bye bye");
    }

    @Override
    public void windowIconified(WindowEvent e) {
        System.out.println("window minimized... hiding it from teacher maybe");
        statusLabel.setText("alt-tab pro max");
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        System.out.println("window brought back from minimized state... catching up with code");
        statusLabel.setText("teacher went back to podium lol");
    }

    @Override
    public void windowActivated(WindowEvent e) {
        System.out.println("window is focused now");
        statusLabel.setText("im awake im awake");
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        System.out.println("window lost focus... looking at another screen probably");
        statusLabel.setText("brb gonna text real quick");
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
