package com.faisal.empgui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

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

		JComboBox divisionComboBox = new JComboBox();
		divisionComboBox.setModel(new DefaultComboBoxModel(Divisions.values()));
		divisionComboBox.setBounds(266, 99, 101, 24);
		add(divisionComboBox);

		JLabel lblDistDdl = new JLabel("District");
		lblDistDdl.setHorizontalAlignment(SwingConstants.LEFT);
		lblDistDdl.setBounds(163, 134, 81, 24);
		add(lblDistDdl);

		JComboBox distDdl = new JComboBox();
		lblDistDdl.setLabelFor(distDdl);
		distDdl.setModel(new DefaultComboBoxModel(new String[] { "Comilla", "Chadpur", "B Baria", "Savar" }));
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
