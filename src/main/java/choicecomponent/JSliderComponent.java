package choicecomponent;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.util.Hashtable;

public class JSliderComponent extends JFrame implements ChangeListener {

    private JSlider slider;
    private JTextField valueTxt;
    private JLabel titleLabel, valueLabel;
    private JPanel mainPanel, displayPanel;

    public JSliderComponent() {
        setTitle("JSlider Demonstration");
        setSize(500, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        Color bg        = new Color(30, 30, 30);
        Color surface   = new Color(45, 45, 45);
        Color accent    = new Color(100, 180, 255);
        Color textColor = new Color(220, 220, 220);

        mainPanel = new JPanel(new BorderLayout(10, 15));
        mainPanel.setBackground(bg);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(25, 30, 25, 30));

        titleLabel = new JLabel("Volume Control", SwingConstants.CENTER);
        titleLabel.setForeground(accent);
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        Hashtable<Integer, JLabel> labelTable = new Hashtable<>();
        String[] levels = {"Silent", "Low", "Medium", "High", "Max"};
        int[]    values = {0, 25, 50, 75, 100};
        for (int i = 0; i < levels.length; i++) {
            JLabel lbl = new JLabel(levels[i]);
            lbl.setForeground(textColor);
            labelTable.put(values[i], lbl);
        }

        slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
        slider.setMajorTickSpacing(25);
        slider.setMinorTickSpacing(5);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setPaintTrack(true);
        slider.setLabelTable(labelTable);
        slider.setBackground(bg);
        slider.setForeground(accent);
        slider.addChangeListener(this);
        mainPanel.add(slider, BorderLayout.CENTER);

        displayPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        displayPanel.setBackground(bg);

        valueLabel = new JLabel("Value:");
        valueLabel.setForeground(textColor);

        valueTxt = new JTextField(String.valueOf(slider.getValue()), 5);
        valueTxt.setEditable(false);
        valueTxt.setHorizontalAlignment(JTextField.CENTER);
        valueTxt.setBackground(surface);
        valueTxt.setForeground(accent);
        valueTxt.setCaretColor(accent);
        valueTxt.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(accent, 1),
            BorderFactory.createEmptyBorder(2, 8, 2, 8)
        ));

        displayPanel.add(valueLabel);
        displayPanel.add(valueTxt);
        mainPanel.add(displayPanel, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        valueTxt.setText(String.valueOf(slider.getValue()));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new JSliderComponent());
    }
}