package com.faisal.empgui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddDistrictPanel extends JPanel {

    /**
     * Create the panel.
     */
    private JTextField txtDist;

    public AddDistrictPanel() {

        setBackground(new Color(0, 139, 139));
        setForeground(new Color(65, 105, 225));
        setLayout(null);

        JLabel divLabel = new JLabel("Division");
        divLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
        divLabel.setHorizontalAlignment(SwingConstants.CENTER);
        divLabel.setBounds(149, 106, 81, 24);
        add(divLabel);

        JComboBox distCombo = new JComboBox();
        divLabel.setLabelFor(distCombo);
        distCombo.setModel(new DefaultComboBoxModel(Divisions.values()));
        distCombo.setBounds(241, 106, 132, 24);
        add(distCombo);

        JLabel distLabel = new JLabel("District");
        distLabel.setLabelFor(distLabel);
        distLabel.setHorizontalAlignment(SwingConstants.CENTER);
        distLabel.setBounds(149, 141, 81, 24);
        add(distLabel);

        txtDist = new JTextField();
        txtDist.setBounds(241, 141, 132, 24);
        add(txtDist);
        txtDist.setColumns(10);


        JButton btnDistSave = new JButton("Save");
        btnDistSave.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Divisions selectedType = (Divisions) distCombo.getSelectedItem();
                DB_UTIL db = new DB_UTIL();
                db.insertDistrict(selectedType.ordinal(), txtDist.getText());
                distCombo.setSelectedIndex(0);
                txtDist.setText("");
            }
        });
        btnDistSave.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnDistSave.setForeground(new Color(255, 255, 255));
        btnDistSave.setBackground(new Color(46, 139, 87));
        btnDistSave.setBounds(283, 205, 90, 33);
        add(btnDistSave);

        JButton btnClear = new JButton("Clear");
        btnClear.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                distCombo.setSelectedIndex(0);
                txtDist.setText("");
            }
        });
        btnClear.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnClear.setForeground(new Color(255, 255, 255));
        btnClear.setBackground(new Color(119, 136, 153));
        btnClear.setBounds(180, 205, 90, 33);
        add(btnClear);
    }

}
