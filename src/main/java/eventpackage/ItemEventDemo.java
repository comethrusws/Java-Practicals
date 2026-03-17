package eventpackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ItemEventDemo extends JFrame implements ItemListener {
    private JCheckBox javaBox, pythonBox, rustBox;
    private JRadioButton maleRadio, femaleRadio;
    private JLabel statusLabel;

    public ItemEventDemo() {
        // window setup
        setTitle("item event demo");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // main panel with boxlayout
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // funny status label at the top
        statusLabel = new JLabel("pick something or whatever...");
        statusLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        statusLabel.setFont(new Font("Arial", Font.ITALIC, 14));
        mainPanel.add(statusLabel);
        mainPanel.add(Box.createVerticalStrut(20));

        // checkbox group
        JPanel checkPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        checkPanel.setBorder(BorderFactory.createTitledBorder("what do u like?"));
        javaBox = new JCheckBox("java");
        pythonBox = new JCheckBox("python");
        rustBox = new JCheckBox("rust");
        checkPanel.add(javaBox);
        checkPanel.add(pythonBox);
        checkPanel.add(rustBox);
        mainPanel.add(checkPanel);
        mainPanel.add(Box.createVerticalStrut(10));

        // radio group
        JPanel radioPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        radioPanel.setBorder(BorderFactory.createTitledBorder("gender check:"));
        maleRadio = new JRadioButton("male");
        femaleRadio = new JRadioButton("female");
        ButtonGroup bg = new ButtonGroup();
        bg.add(maleRadio);
        bg.add(femaleRadio);
        radioPanel.add(maleRadio);
        radioPanel.add(femaleRadio);
        mainPanel.add(radioPanel);

        // adding listeners
        javaBox.addItemListener(this);
        pythonBox.addItemListener(this);
        rustBox.addItemListener(this);
        maleRadio.addItemListener(this);
        femaleRadio.addItemListener(this);

        add(mainPanel);
        setVisible(true);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        Object source = e.getSource();
        int state = e.getStateChange();
        String name = "";

        if (source == javaBox) name = "java";
        else if (source == pythonBox) name = "python";
        else if (source == rustBox) name = "rust";
        else if (source == maleRadio) name = "male";
        else if (source == femaleRadio) name = "female";

        if (state == ItemEvent.SELECTED) {
            System.out.println("yo u picked " + name + "... nice taste");
            statusLabel.setText("u selected " + name + "... dont regret it later");
        } else {
            System.out.println("rip " + name + "... u dropped it");
            statusLabel.setText("u deselected " + name + "... loyalty where?");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ItemEventDemo());
    }
}
