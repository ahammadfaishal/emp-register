package com.faisal.empgui;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ShowDistrictPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	private JTable tblDistList;
	public ShowDistrictPanel() {

		setForeground(new Color(255, 255, 255));
		setBackground(new Color(0, 139, 139));
		setLayout(null);

		tblDistList = new JTable();
		var _districts = new ArrayList<District>() {
			{
				add(new District("Comilla", "Comilla"));
				add(new District("Dhaka", "Savar"));
				add(new District("Rajshahi", "Rajshahi"));
				add(new District("Rajshahi", "Natore"));
				add(new District("Comilla", "Chadpur"));
				add(new District("Comilla", "Noakhali"));
				add(new District("Comilla", "Feni"));
				add(new District("Comilla", "B Baria"));
				add(new District("Dhaka", "Dhaka"));
				add(new District("Dhaka", "Narayanganj"));
				add(new District("Chittagong", "Chittagong"));
			}
		};
		var tableModel = new DefaultTableModel();
		tableModel.addColumn("Division_name");
		tableModel.addColumn("District_name");
		tableModel.addRow(new Object[] { "Division", "District" });
		for (var element : _districts) {
			tableModel.addRow(new Object[] { element.getDivision(), element.getDistrict() });
		}

		tblDistList.setModel(tableModel);
		tblDistList.getColumnModel().getColumn(0).setResizable(false);
		tblDistList.getColumnModel().getColumn(1).setResizable(false);
		tblDistList.setBounds(111, 50, 350, 216);
		add(tblDistList);

		JLabel lblNewLabel = new JLabel("Districts");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(111, 21, 116, 24);
		add(lblNewLabel);
		
	}

}
