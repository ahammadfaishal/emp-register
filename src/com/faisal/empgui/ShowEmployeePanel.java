package com.faisal.empgui;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ShowEmployeePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	private JTable tblEmp;
	
	public ShowEmployeePanel() {
		setBackground(new Color(0, 139, 139));		
		setLayout(null);
		
		tblEmp = new JTable();
		var empModel = new DefaultTableModel(
				new Object[][] {
						{ "Faisal AL Mahmud", "189649875465", "01671358954", "faisa.dev@pm.me", "Comilla", null },
						{ "Shariful Alam", "19879465461", "0197654654", "sharif@xpertsolvers.com", "Chittagong", null },
						{ "Shamim Hossain", "19197846546", "0164678465", "hmshamim@gmail.com", "Comilla", null },
						{ "Shawon Ashik", "164679846546", "0174654945", "shawon@xpertsolvers.com", "Tangail", null },
						{ "Hadi Bhuyan", "1979846546", "0176465464", "hadi@commengine.xyz", "Feni", null },
						{ "Maksud Alam", "165498754654", "0169459878", "maksud@gmail.com", "Dhaka", null },
						{ "Ishti Alam", "197845464654", "0174564984", "ishiti@gmail.com", null, null }, },
				new String[] { "Employee Name", "NID", "Phone", "Email", "Address", "Photo" }) {
			Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class, String.class,
					Byte.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		
		tblEmp.setModel(empModel);
		tblEmp.getColumnModel().getColumn(0).setResizable(false);
		tblEmp.getColumnModel().getColumn(1).setResizable(false);
		tblEmp.getColumnModel().getColumn(2).setResizable(false);
		tblEmp.getColumnModel().getColumn(3).setResizable(false);
		tblEmp.getColumnModel().getColumn(4).setResizable(false);
		tblEmp.getColumnModel().getColumn(5).setResizable(false);
		tblEmp.setBounds(10, 130, 544, 112);
		add(tblEmp);
	}

}
