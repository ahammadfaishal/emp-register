package com.faisal.empgui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

public class AddUpazillaPanel extends JPanel {

    /**
     * Create the panel.
     */
    private JTextField txtThana;

    public AddUpazillaPanel() {
        setForeground(new Color(65, 105, 225));
        setBackground(new Color(0, 139, 139));
        setLayout(null);

        JLabel lblDivisionComboBox = new JLabel("Division");
        lblDivisionComboBox.setHorizontalAlignment(SwingConstants.LEFT);
        lblDivisionComboBox.setLabelFor(lblDivisionComboBox);
        lblDivisionComboBox.setBounds(163, 99, 81, 24);
        add(lblDivisionComboBox);

        JComboBox distDdl = new JComboBox();

        JComboBox divisionComboBox = new JComboBox();
        divisionComboBox.setModel(new DefaultComboBoxModel(Divisions.values()));
        divisionComboBox.setBounds(266, 99, 101, 24);
        add(divisionComboBox);
        divisionComboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent arg0) {
                Divisions selectedType = (Divisions) arg0.getItem();
                DB_UTIL db = new DB_UTIL();
                var districts = db.getDistrictsByDivisionId(selectedType.ordinal());
                var model = new Vector<NameValueDto<Integer>>();
                for (var element : districts) {
                    model.addElement(element);
                }
                distDdl.setModel(new DefaultComboBoxModel(model));
            }
        });

        JLabel lblDistDdl = new JLabel("District");
        lblDistDdl.setHorizontalAlignment(SwingConstants.LEFT);
        lblDistDdl.setBounds(163, 134, 81, 24);
        add(lblDistDdl);

        lblDistDdl.setLabelFor(distDdl);

        distDdl.setBounds(266, 135, 101, 24);
        add(distDdl);

        JLabel lblThana = new JLabel("Thana");
        lblThana.setHorizontalAlignment(SwingConstants.LEFT);
        lblThana.setBounds(163, 169, 81, 24);
        add(lblThana);

        txtThana = new JTextField();
        lblThana.setLabelFor(txtThana);
        txtThana.setBounds(266, 169, 101, 24);
        add(txtThana);
        txtThana.setColumns(10);

        JButton btnSaveThana = new JButton("Save");
        btnSaveThana.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                NameValueDto<Integer> selectedDist = (NameValueDto<Integer>) distDdl.getSelectedItem();
                DB_UTIL db = new DB_UTIL();
                db.insertUpazilla(selectedDist.getValue(), txtThana.getText());
                distDdl.setSelectedIndex(0);
                divisionComboBox.setSelectedIndex(0);
                txtThana.setText("");

                JOptionPane.showMessageDialog(null, "Upazilla saved successfully");
            }
        });
        btnSaveThana.setForeground(new Color(255, 255, 255));
        btnSaveThana.setBackground(new Color(46, 139, 87));
        btnSaveThana.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnSaveThana.setBounds(278, 227, 90, 33);
        add(btnSaveThana);

        JButton btnThanaClear = new JButton("Clear");
        btnThanaClear.setForeground(new Color(255, 255, 255));
        btnThanaClear.setBackground(new Color(119, 136, 153));
        btnThanaClear.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnThanaClear.setBounds(166, 227, 90, 33);
        add(btnThanaClear);
    }

}
