package com.faisal.empgui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SearchEmployeePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	private JTextField txtSrchName;
	private JTextField txtSrchPhone;
	private JTextField txtSrchEmail;
	private JTextField txtSrchNid;
	
	public SearchEmployeePanel() {
		setBackground(new Color(0, 139, 139));
		setLayout(null);

		JLabel lblSearchBy = new JLabel("Search By");
		lblSearchBy.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSearchBy.setForeground(new Color(255, 255, 255));
		lblSearchBy.setBounds(16, 11, 119, 41);
		add(lblSearchBy);

		JLabel lblSrchDist = new JLabel("District");
		lblSrchDist.setForeground(new Color(255, 255, 255));
		lblSrchDist.setBounds(16, 80, 81, 24);
		add(lblSrchDist);

		JComboBox cmbSrchDist = new JComboBox();
		lblSrchDist.setLabelFor(cmbSrchDist);
		cmbSrchDist.setBounds(97, 80, 101, 24);
		add(cmbSrchDist);

		JLabel lblSrchThana = new JLabel("Thana");
		lblSrchThana.setForeground(new Color(255, 255, 255));
		lblSrchThana.setBounds(16, 105, 81, 24);
		add(lblSrchThana);

		JComboBox cmbSrchThana = new JComboBox();
		lblSrchThana.setLabelFor(cmbSrchThana);
		cmbSrchThana.setBounds(97, 105, 101, 24);
		add(cmbSrchThana);

		JLabel lblSrchName = new JLabel("Name");
		lblSrchName.setForeground(new Color(255, 255, 255));
		lblSrchName.setBounds(16, 130, 81, 24);
		add(lblSrchName);

		txtSrchName = new JTextField();
		lblSrchName.setLabelFor(txtSrchName);
		txtSrchName.setBounds(97, 130, 101, 24);
		add(txtSrchName);
		txtSrchName.setColumns(10);

		JLabel lblSrchPhone = new JLabel("Phone");
		lblSrchPhone.setForeground(new Color(255, 255, 255));
		lblSrchPhone.setBounds(16, 154, 81, 24);
		add(lblSrchPhone);

		txtSrchPhone = new JTextField();
		lblSrchPhone.setLabelFor(txtSrchPhone);
		txtSrchPhone.setBounds(97, 154, 101, 24);
		add(txtSrchPhone);
		txtSrchPhone.setColumns(10);

		JLabel lblSrchEmail = new JLabel("Email");
		lblSrchEmail.setForeground(new Color(255, 255, 255));
		lblSrchEmail.setBounds(16, 179, 81, 24);
		add(lblSrchEmail);

		txtSrchEmail = new JTextField();
		lblSrchEmail.setLabelFor(txtSrchEmail);
		txtSrchEmail.setBounds(97, 179, 101, 24);
		add(txtSrchEmail);
		txtSrchEmail.setColumns(10);

		JLabel lblSrchNid = new JLabel("NID");
		lblSrchNid.setForeground(new Color(255, 255, 255));
		lblSrchNid.setBounds(16, 204, 81, 24);
		add(lblSrchNid);

		txtSrchNid = new JTextField();
		lblSrchNid.setLabelFor(txtSrchNid);
		txtSrchNid.setBounds(97, 204, 101, 24);
		add(txtSrchNid);
		txtSrchNid.setColumns(10);

		JButton btnNewButton_1 = new JButton("Search");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(46, 139, 87));
		btnNewButton_1.setBounds(109, 255, 90, 33);
		add(btnNewButton_1);
	}

}
