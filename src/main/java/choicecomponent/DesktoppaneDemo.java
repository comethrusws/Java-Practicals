package choicecomponent;

import javax.swing.*;

public class DesktoppaneDemo extends JFrame {

    public DesktoppaneDemo() {
        setTitle("JDesktopPane Demonstration");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JDesktopPane desktopPane = new JDesktopPane();

        JInternalFrame if1 = new JInternalFrame("if1: Resizable Only", true, false, false, false);
        if1.setSize(200, 150);
        if1.setLocation(30, 30);
        if1.setVisible(true);

        JInternalFrame if2 = new JInternalFrame("if2: Closable Only", false, true, false, false);
        if2.setSize(200, 150);
        if2.setLocation(250, 30);
        if2.setVisible(true);

        JInternalFrame if3 = new JInternalFrame("if3: Maximizable Only", false, false, true, false);
        if3.setSize(200, 150);
        if3.setLocation(30, 200);
        if3.setVisible(true);

        JInternalFrame if4 = new JInternalFrame("if4: Iconifiable Only", false, false, false, true);
        if4.setSize(200, 150);
        if4.setLocation(250, 200);
        if4.setVisible(true);
        
        JInternalFrame if5 = new JInternalFrame("if5: All Attributes True", true, true, true, true);
        if5.setSize(250, 150);
        if5.setLocation(480, 115);
        if5.setVisible(true);

        desktopPane.add(if1);
        desktopPane.add(if2);
        desktopPane.add(if3);
        desktopPane.add(if4);
        desktopPane.add(if5);

        setContentPane(desktopPane);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DesktoppaneDemo frame = new DesktoppaneDemo();
            frame.setVisible(true);
        });
    }
}
