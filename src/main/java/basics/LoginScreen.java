import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginScreen extends JFrame implements ActionListener {
    
    // Components
    private JLabel titleLabel, userLabel, passLabel;
    private JTextField userField;
    private JPasswordField passField;
    private JButton loginButton, clearButton;
    
    public LoginScreen() {
        // Set up the frame
        setTitle("Login Screen");
        setBounds(600, 50, 400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        // Create main panel with null layout for absolute positioning
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(new Color(240, 240, 240));
        
        // Title label
        titleLabel = new JLabel("User Login");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBounds(130, 20, 150, 30);
        mainPanel.add(titleLabel);
        
        // Username label and field
        userLabel = new JLabel("Username:");
        userLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        userLabel.setBounds(50, 80, 100, 25);
        mainPanel.add(userLabel);
        
        userField = new JTextField();
        userField.setBounds(150, 80, 180, 25);
        mainPanel.add(userField);
        
        // Password label and field
        passLabel = new JLabel("Password:");
        passLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        passLabel.setBounds(50, 120, 100, 25);
        mainPanel.add(passLabel);
        
        passField = new JPasswordField();
        passField.setBounds(150, 120, 180, 25);
        mainPanel.add(passField);
        
        // Login button
        loginButton = new JButton("Login");
        loginButton.setBounds(150, 170, 80, 30);
        loginButton.setBackground(new Color(70, 130, 180));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusPainted(false);
        loginButton.addActionListener(this);
        mainPanel.add(loginButton);
        
        // Clear button
        clearButton = new JButton("Clear");
        clearButton.setBounds(250, 170, 80, 30);
        clearButton.setBackground(new Color(192, 192, 192));
        clearButton.setFocusPainted(false);
        clearButton.addActionListener(this);
        mainPanel.add(clearButton);
        
        // Add panel to frame
        add(mainPanel);
        
        // Make frame visible
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String username = userField.getText();
            String password = new String(passField.getPassword());
            
            // Simple validation (you can modify this logic)
            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, 
                    "Please enter both username and password", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
            } else if (username.equals("admin") && password.equals("admin123")) {
                JOptionPane.showMessageDialog(this, 
                    "Login Successful!", 
                    "Success", 
                    JOptionPane.INFORMATION_MESSAGE);
                // You can add code here to open a new window or perform other actions
            } else {
                JOptionPane.showMessageDialog(this, 
                    "Invalid username or password", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == clearButton) {
            userField.setText("");
            passField.setText("");
        }
    }
    
    public static void main(String[] args) {
        // Use SwingUtilities to ensure thread safety
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginScreen();
            }
        });
    }
}