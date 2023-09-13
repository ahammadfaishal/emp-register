package com.faisal.empgui;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ShowUpazillaPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	private JTable tblUpazilla;
	public ShowUpazillaPanel() {
		setBackground(new Color(0, 139, 139));
		setLayout(null);

		tblUpazilla = new JTable();
		tblUpazilla.setModel(new DefaultTableModel(
				new Object[][] { { "Dhaka", "Savar", "Savar" }, { "Comilla", "Comilla", "Laksam" }, },
				new String[] { "Division Name", "District Name", "Upazilla Name" }) {
			boolean[] columnEditables = new boolean[] { false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tblUpazilla.getColumnModel().getColumn(0).setResizable(false);
		tblUpazilla.getColumnModel().getColumn(1).setResizable(false);
		tblUpazilla.getColumnModel().getColumn(2).setResizable(false);
		tblUpazilla.setBounds(96, 108, 379, 84);
		add(tblUpazilla);
	}

}
