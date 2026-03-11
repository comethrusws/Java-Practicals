package TextInputComponents;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Image;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class TextInputComponents extends JFrame implements ActionListener {
    JLabel nameLabel, passwordLabel, addressLabel;
    JLabel nameIcon, passwordIcon, addressIcon;
    JTextField nameField;
    JPasswordField passwordField;
    JTextArea addressField;
    JScrollPane scrollPane;
    JButton submitButton, clearButton;
    JPanel panel;
    
    public TextInputComponents() {
        setTitle("Text Input Components");
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(240, 240, 240));
        
        ImageIcon originalIcon = new ImageIcon(getClass().getResource("/logo_slack.png"));
        Image scaledImage = originalIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(scaledImage);
        
        nameIcon = new JLabel(icon);
        nameIcon.setBounds(30, 50, 20, 25);
        panel.add(nameIcon);
        
        nameLabel = new JLabel("User:");
        nameLabel.setBounds(55, 50, 100, 25);
        panel.add(nameLabel);
        
        nameField = new JTextField();
        nameField.setBounds(160, 50, 250, 25);
        panel.add(nameField);
        
        passwordIcon = new JLabel(icon);
        passwordIcon.setBounds(30, 80, 20, 25);
        panel.add(passwordIcon);
        
        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(55, 80, 100, 25);
        panel.add(passwordLabel);
        
        passwordField = new JPasswordField();
        passwordField.setBounds(160, 80, 250, 25);
        panel.add(passwordField);
        
        // Address with icon
        addressIcon = new JLabel(icon);
        addressIcon.setBounds(30, 110, 20, 25);
        panel.add(addressIcon);
        
        addressLabel = new JLabel("Address:");
        addressLabel.setBounds(55, 110, 100, 25);
        panel.add(addressLabel);
        
        addressField = new JTextArea();
        addressField.setLineWrap(true);
        addressField.setWrapStyleWord(true);
        
        scrollPane = new JScrollPane(addressField);
        scrollPane.setBounds(160, 110, 250, 100);
        panel.add(scrollPane);
        
        submitButton = new JButton("Submit");
        submitButton.setBounds(160, 220, 100, 30);
        submitButton.addActionListener(this);
        panel.add(submitButton);
        
        clearButton = new JButton("Clear");
        clearButton.setBounds(270, 220, 100, 30);
        clearButton.addActionListener(this);
        panel.add(clearButton);
        
        add(panel);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            String name = nameField.getText();
            String password = new String(passwordField.getPassword());
            String address = addressField.getText();
            
            if (name.isEmpty() || password.isEmpty() || address.isEmpty()) {
                JOptionPane.showMessageDialog(this, 
                    "Please fill all fields", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, 
                    "Name: " + name + "\nPassword: " + password + "\nAddress: " + address, 
                    "Success", 
                    JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (e.getSource() == clearButton) {
            nameField.setText("");
            passwordField.setText("");
            addressField.setText("");
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TextInputComponents();
            }
        });
    }
}