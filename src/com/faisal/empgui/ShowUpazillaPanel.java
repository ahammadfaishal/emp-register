package com.faisal.empgui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ShowUpazillaPanel extends JPanel {

    /**
     * Create the panel.
     */
    private JTable tblUpazilla;

    public ShowUpazillaPanel() {
        setBackground(new Color(0, 139, 139));
        setLayout(null);

        tblUpazilla = new JTable();

        DB_UTIL db = new DB_UTIL();
        var upazillas = db.getUpazilla();


        var tableModel = new DefaultTableModel() {
            boolean[] columnEditables = new boolean[]{false, false, false};

            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        };
        tableModel.addColumn("Division");
        tableModel.addColumn("District");
        tableModel.addColumn("Upazilla");
        for (var element : upazillas) {
            tableModel.addRow(new Object[]{element.getDivision(), element.getDistrict(), element.getUpazillaName()});
        }
        tblUpazilla.setModel(tableModel);

        tblUpazilla.getColumnModel().getColumn(0).setResizable(false);
        tblUpazilla.getColumnModel().getColumn(1).setResizable(false);
        tblUpazilla.getColumnModel().getColumn(2).setResizable(false);
        tblUpazilla.setBounds(96, 49, 379, 84);

        var scroll_table = new JScrollPane(tblUpazilla); // add table to scroll panel
        scroll_table.setBounds(95, 50, 379, 84);
        scroll_table.setVisible(true);
        add(scroll_table);
    }

}
