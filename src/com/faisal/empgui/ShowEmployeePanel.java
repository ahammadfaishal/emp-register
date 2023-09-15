package com.faisal.empgui;

import java.awt.Color;
import java.awt.Image;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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

		DB_UTIL db = new DB_UTIL();
		var employees = db.getEmployees();

		var tableModel = new DefaultTableModel() {
			@Override
			public Class<?> getColumnClass(int column) {
				if (column == 5)
					return ImageIcon.class;
				return Object.class;
			}
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		
		tableModel.addColumn("Employee Name");
		tableModel.addColumn("NID");
		tableModel.addColumn("Phone");
		tableModel.addColumn("Email");
		tableModel.addColumn("Address");
		tableModel.addColumn("Photo");
		for (var element : employees) {
			tableModel.addRow(new Object[] { element.getName(), element.getNID(), element.getPhone(),
					element.getEmail(), element.getAddress(), getImage(element.getImageUrl()) });
		}

		tblEmp.setModel(tableModel);
		tblEmp.setBounds(10, 31, 544, 250);
		tblEmp.setRowHeight(60);
		var scroll_table = new JScrollPane(tblEmp); // add table to scroll panel
		scroll_table.setBounds(9, 30, 544, 250);
		scroll_table.setVisible(true);
		add(scroll_table);
	}

	private ImageIcon getImage(String imageUrl) {
		var imageIcon = new ImageIcon();
		if (!imageUrl.equals("")) {
			Path sourcePath = (Path) Paths.get(System.getProperty("user.home"), "/emp-images", imageUrl);
			var img = new ImageIcon(sourcePath.toString()).getImage()
			.getScaledInstance(80, 60, Image.SCALE_SMOOTH);
			
			imageIcon = new ImageIcon(img);
		}
		return imageIcon;
	}
}
