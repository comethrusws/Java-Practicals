package choicecomponent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class MenuDemo extends JFrame {

    public MenuDemo() {
        setTitle("Menu Demonstration");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        Container contentPane = getContentPane();

        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        
        JMenu editMenu = new JMenu("Edit");
        editMenu.setMnemonic(KeyEvent.VK_E);
        
        JMenu optionsMenu = new JMenu("Options");
        optionsMenu.setMnemonic(KeyEvent.VK_O);
        
        JMenu helpMenu = new JMenu("Help");
        helpMenu.setMnemonic(KeyEvent.VK_H);

        JMenuItem openItem = new JMenuItem("Open...");
        openItem.setMnemonic(KeyEvent.VK_O);
        openItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
        openItem.addActionListener(e -> JOptionPane.showMessageDialog(this, "Open selected!"));
        
        JMenuItem saveItem = new JMenuItem("Save");
        saveItem.setMnemonic(KeyEvent.VK_S);
        saveItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
        saveItem.addActionListener(e -> {
            FileDialog fd = new FileDialog(this, "Save File", FileDialog.SAVE);
            fd.setVisible(true);
            if (fd.getFile() != null) {
                JOptionPane.showMessageDialog(this, "File saved as: " + fd.getFile());
            }
        });
        
        JMenuItem closeItem = new JMenuItem("Close");
        closeItem.setMnemonic(KeyEvent.VK_C);
        closeItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
        closeItem.addActionListener(e -> System.exit(0));

        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.addSeparator();
        fileMenu.add(closeItem);

        // --- Edit Menu Items ---
        JMenuItem statusItem = new JMenuItem("Status");
        statusItem.setMnemonic(KeyEvent.VK_S);
        statusItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
        statusItem.addActionListener(e -> JOptionPane.showMessageDialog(this, "Status selected!"));
        
        JMenuItem chooseColorItem = new JMenuItem("Choose Color...");
        chooseColorItem.setMnemonic(KeyEvent.VK_C);
        chooseColorItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx() | java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        chooseColorItem.addActionListener(e -> {
            Color newColor = JColorChooser.showDialog(this, "Select a Background Color", contentPane.getBackground());
            if (newColor != null) {
                contentPane.setBackground(newColor);
            }
        });

        JMenu toolsSubMenu = new JMenu("Tools");
        toolsSubMenu.setMnemonic(KeyEvent.VK_T);
        
        JMenuItem formatItem = new JMenuItem("Format");
        formatItem.setMnemonic(KeyEvent.VK_F);
        formatItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx() | java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        formatItem.addActionListener(e -> JOptionPane.showMessageDialog(this, "Format selected!"));
        
        JMenuItem settingsItem = new JMenuItem("Settings");
        settingsItem.setMnemonic(KeyEvent.VK_E);
        settingsItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_COMMA, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
        settingsItem.addActionListener(e -> JOptionPane.showMessageDialog(this, "Settings selected!"));
        
        toolsSubMenu.add(formatItem);
        toolsSubMenu.add(settingsItem);

        editMenu.add(statusItem);
        editMenu.add(chooseColorItem);
        editMenu.addSeparator();
        editMenu.add(toolsSubMenu);

        // --- Options Menu Items ---
        JCheckBoxMenuItem checkUncheckItem = new JCheckBoxMenuItem("Check/Uncheck Option");
        checkUncheckItem.setMnemonic(KeyEvent.VK_C);
        checkUncheckItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx() | java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        checkUncheckItem.addActionListener(e -> {
            System.out.println("Check/Uncheck updated: " + checkUncheckItem.isSelected());
        });
        
        JMenu toggleMenu = new JMenu("Toggle State");
        toggleMenu.setMnemonic(KeyEvent.VK_T);
        
        JRadioButtonMenuItem onButton = new JRadioButtonMenuItem("On", true);
        onButton.setMnemonic(KeyEvent.VK_O);
        onButton.addActionListener(e -> System.out.println("Toggle State set to ON"));
        
        JRadioButtonMenuItem offButton = new JRadioButtonMenuItem("Off", false);
        offButton.setMnemonic(KeyEvent.VK_F);
        offButton.addActionListener(e -> System.out.println("Toggle State set to OFF"));
        
        ButtonGroup toggleGroup = new ButtonGroup();
        toggleGroup.add(onButton);
        toggleGroup.add(offButton);
        
        toggleMenu.add(onButton);
        toggleMenu.add(offButton);

        optionsMenu.add(checkUncheckItem);
        optionsMenu.addSeparator();
        optionsMenu.add(toggleMenu);

        JMenuItem aboutItem = new JMenuItem("About");
        aboutItem.setMnemonic(KeyEvent.VK_A);
        aboutItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx() | java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        aboutItem.addActionListener(e -> {
            JOptionPane.showOptionDialog(
                    this,
                    "bla bla bla bla",
                    "About",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    new Object[]{"Got it", "what?", "this is crazy!"},  
                    "Got it"                  
            );
        });
        helpMenu.add(aboutItem);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(optionsMenu);
        menuBar.add(helpMenu);

        setJMenuBar(menuBar);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MenuDemo frame = new MenuDemo();
            frame.setVisible(true);
        });
    }
}
