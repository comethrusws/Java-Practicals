package choicecomponent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RadioCheckComboList extends JFrame implements ActionListener {

    private JLabel genderLabel, courseLabel, collegeLabel, countryLabel;
    private JRadioButton male, female, notSpecified;
    private JCheckBox csit, bba, bca;
    private JComboBox<String> colleges;
    private JList<String> countries;
    private JButton submit, clear;
    private JPanel panel;

    public RadioCheckComboList() {
        setTitle("Radio Check Combo List");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(new Color(220, 250, 243));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        // --- Gender ---
        gbc.gridx = 0; gbc.gridy = 0;
        genderLabel = new JLabel("Gender:");
        panel.add(genderLabel, gbc);

        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        notSpecified = new JRadioButton("Not Specified");

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(notSpecified);

        gbc.gridx = 1; panel.add(male, gbc);
        gbc.gridx = 2; panel.add(female, gbc);
        gbc.gridx = 3; panel.add(notSpecified, gbc);

        // --- Course ---
        gbc.gridx = 0; gbc.gridy = 1;
        courseLabel = new JLabel("Course:");
        panel.add(courseLabel, gbc);

        csit = new JCheckBox("CSIT");
        bba = new JCheckBox("BBA");
        bca = new JCheckBox("BCA");

        gbc.gridx = 1; panel.add(csit, gbc);
        gbc.gridx = 2; panel.add(bba, gbc);
        gbc.gridx = 3; panel.add(bca, gbc);

        // --- College ---
        gbc.gridx = 0; gbc.gridy = 2;
        collegeLabel = new JLabel("College:");
        panel.add(collegeLabel, gbc);

        colleges = new JComboBox<>(new String[]{"Vedas", "DWIT", "Patan", "Ambition"});
        gbc.gridx = 1; gbc.gridwidth = 3; gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(colleges, gbc);
        gbc.gridwidth = 1; gbc.fill = GridBagConstraints.NONE;

        // --- Country ---
        gbc.gridx = 0; gbc.gridy = 3;
        countryLabel = new JLabel("Country:");
        panel.add(countryLabel, gbc);

        countries = new JList<>(new String[]{"Nepal", "UK", "Canada", "Australia", "Germany"});
        countries.setVisibleRowCount(3);
        JScrollPane countryScroll = new JScrollPane(countries);
        countryScroll.setPreferredSize(new Dimension(200, 70));
        gbc.gridx = 1; gbc.gridwidth = 3;
        panel.add(countryScroll, gbc);
        gbc.gridwidth = 1;

        // --- Buttons ---
        gbc.gridy = 4; gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        submit = new JButton("Submit");
        submit.addActionListener(this);
        panel.add(submit, gbc);

        gbc.gridx = 2;
        clear = new JButton("Clear");
        clear.addActionListener(this);
        panel.add(clear, gbc);

        add(panel);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            String gender = male.isSelected() ? "Male"
                          : female.isSelected() ? "Female"
                          : notSpecified.isSelected() ? "Not Specified"
                          : "None";

            StringBuilder courses = new StringBuilder();
            if (csit.isSelected()) courses.append("CSIT ");
            if (bba.isSelected())  courses.append("BBA ");
            if (bca.isSelected())  courses.append("BCA ");

            String college = (String) colleges.getSelectedItem();
            String country = countries.getSelectedValue();

            JOptionPane.showMessageDialog(this,
                "Gender:  " + gender + "\n" +
                "Courses: " + (courses.length() > 0 ? courses.toString().trim() : "None") + "\n" +
                "College: " + (college != null ? college : "None") + "\n" +
                "Country: " + (country != null ? country : "None")
            );

        } else if (e.getSource() == clear) {
            male.setSelected(false);
            female.setSelected(false);
            notSpecified.setSelected(false);
            csit.setSelected(false);
            bba.setSelected(false);
            bca.setSelected(false);
            colleges.setSelectedIndex(0);
            countries.clearSelection();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RadioCheckComboList());
    }
}