import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {
    private JTextField display;
    private double num1 = 0, num2 = 0, result = 0;
    private String operator = "";
    private boolean startNewNumber = true;
    
    public Calculator() {
        setTitle("Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(5, 5));
        
        display = new JTextField("0");
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 24));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setBackground(Color.WHITE);
        display.setPreferredSize(new Dimension(300, 50));
        add(display, BorderLayout.NORTH);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 5, 5)); 
        panel.setBackground(new Color(240, 240, 240));

        String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "C", "0", "=", "+"
        };
        
        JButton btn[] = new JButton[16];
        for(int i = 0; i < btn.length; i++) {
            btn[i] = new JButton(buttonLabels[i]);
            btn[i].setFont(new Font("Arial", Font.BOLD, 18));  // Added font
            
            if (buttonLabels[i].matches("[0-9]")) {
                btn[i].setBackground(new Color(200, 220, 255));
            } else if (buttonLabels[i].equals("=")) {
                btn[i].setBackground(new Color(150, 255, 150));
            } else if (buttonLabels[i].equals("C")) {
                btn[i].setBackground(new Color(255, 150, 150));
            } else {
                btn[i].setBackground(new Color(255, 200, 100));
            }
            
            btn[i].setFocusPainted(false);
            btn[i].addActionListener(this);  // Add action listener
            panel.add(btn[i]);
        }
    
        add(panel, BorderLayout.CENTER);

        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        
        if (command.matches("[0-9]")) {
            if (startNewNumber) {
                display.setText(command);
                startNewNumber = false;
            } else {
                display.setText(display.getText() + command);
            }
        }
        else if (command.equals("C")) {
            display.setText("0");
            num1 = 0;
            num2 = 0;
            result = 0;
            operator = "";
            startNewNumber = true;
        }
        else if (command.matches("[+\\-*/]")) {
            num1 = Double.parseDouble(display.getText());
            operator = command;
            startNewNumber = true;
        }
        else if (command.equals("=")) {
            num2 = Double.parseDouble(display.getText());
            
            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        display.setText("Error");
                        startNewNumber = true;
                        return;
                    }
                    break;
            }
            
            if (result == (long) result) {
                display.setText(String.valueOf((long) result));
            } else {
                display.setText(String.valueOf(result));
            }
            
            startNewNumber = true;
            num1 = result;
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Calculator();
            }
        });
    }
}