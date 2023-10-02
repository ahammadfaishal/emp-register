package com.faisal.empgui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ShowDistrictPanel extends JPanel {

    /**
     * Create the panel.
     */
    private JTable tblDistList;

    public ShowDistrictPanel() {

        setForeground(new Color(255, 255, 255));
        setBackground(new Color(0, 139, 139));
        setLayout(null);

        DB_UTIL db = new DB_UTIL();
        var _districts = db.getDistrict();

        tblDistList = new JTable();
        var tableModel = new DefaultTableModel() {
            boolean[] columnEditables = new boolean[]{false, false};

            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        };
        tableModel.addColumn("Division");
        tableModel.addColumn("District");
        for (var element : _districts) {
            tableModel.addRow(new Object[]{element.getDivision(), element.getDistrict()});
        }

        tblDistList.setModel(tableModel);
        tblDistList.getColumnModel().getColumn(0).setResizable(false);
        tblDistList.getColumnModel().getColumn(1).setResizable(false);
        tblDistList.setBounds(111, 50, 350, 216);

        var scroll_table = new JScrollPane(tblDistList); // add table to scroll panel
        scroll_table.setBounds(110, 49, 350, 216);
        scroll_table.setVisible(true);
        add(scroll_table);

        JLabel lblNewLabel = new JLabel("Districts");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setBackground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel.setBounds(111, 21, 116, 24);
        add(lblNewLabel);

    }

}
