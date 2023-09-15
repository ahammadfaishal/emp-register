package com.faisal.empgui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
		JComboBox cmbSrchThana = new JComboBox();
		lblSrchDist.setLabelFor(cmbSrchDist);
		cmbSrchDist.setBounds(97, 80, 101, 24);
		cmbSrchDist.setModel(new DefaultComboBoxModel(getDistricts()));
		add(cmbSrchDist);
		cmbSrchDist.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				var selectedDist = (District) arg0.getItem();
				DB_UTIL db = new DB_UTIL();
				var upazillas = db.getUpazillaByDistrictId(selectedDist.getId());
				var model = new Vector<NameValueDto<Integer>>();
				for (var element : upazillas) {
					model.addElement(element);
				}
				cmbSrchThana.setModel(new DefaultComboBoxModel(model));
			}
		});

		JLabel lblSrchThana = new JLabel("Thana");
		lblSrchThana.setForeground(new Color(255, 255, 255));
		lblSrchThana.setBounds(16, 105, 81, 24);
		add(lblSrchThana);

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

		JLabel lblImage = new JLabel("");
		JLabel lblName = new JLabel("");
		JLabel lblNID = new JLabel("");
		JLabel lblPhone = new JLabel("");
		JLabel lblEmail = new JLabel("");
		JLabel lblAddress = new JLabel("");

		JButton btnSrch = new JButton("Search");

		btnSrch.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSrch.setForeground(new Color(255, 255, 255));
		btnSrch.setBackground(new Color(46, 139, 87));
		btnSrch.setBounds(109, 255, 90, 33);
		add(btnSrch);
		btnSrch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (txtSrchName.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Name field is empty!");
					return;
				}

				DB_UTIL db = new DB_UTIL();
				var selectedDist = (District) cmbSrchDist.getSelectedItem();
				var selectedUpz = (NameValueDto<Integer>) cmbSrchThana.getSelectedItem();
				int selectedUpzId = 0;
				if (selectedUpz != null) {
					selectedUpzId = selectedUpz.getValue();
				}

				var employee = db.searchEmployee(selectedDist.getId(), selectedUpzId, txtSrchName.getText(),
						txtSrchPhone.getText(), txtSrchEmail.getText(), txtSrchNid.getText());
				if (employee != null) {
					lblName.setText(employee.getName());
					lblNID.setText(employee.getNID());
					lblPhone.setText(employee.getPhone());
					lblEmail.setText(employee.getEmail());
					lblAddress.setText(employee.getAddress());
					if (!employee.getImageUrl().equals("")) {
						Path sourcePath = (Path) Paths.get(System.getProperty("user.home"), "/emp-images",
								employee.getImageUrl());
						var img = new ImageIcon(sourcePath.toString()).getImage().getScaledInstance(120, 100,
								Image.SCALE_SMOOTH);

						lblImage.setIcon(new ImageIcon(img));
					}
				} else {
					JOptionPane.showMessageDialog(null, "No record found!");
				}
			}
		});

		lblImage.setForeground(new Color(255, 255, 255));
		lblImage.setBounds(400, 10, 120, 100);
		add(lblImage);

		lblName.setForeground(new Color(255, 255, 255));
		lblName.setBounds(250, 100, 150, 24);
		add(lblName);

		lblNID.setForeground(new Color(255, 255, 255));
		lblNID.setBounds(250, 125, 150, 24);
		add(lblNID);

		lblPhone.setForeground(new Color(255, 255, 255));
		lblPhone.setBounds(250, 150, 150, 24);
		add(lblPhone);

		lblEmail.setForeground(new Color(255, 255, 255));
		lblEmail.setBounds(250, 175, 150, 24);
		add(lblEmail);

		lblAddress.setForeground(new Color(255, 255, 255));
		lblAddress.setBounds(250, 200, 150, 24);
		add(lblAddress);
	}

	private Vector getDistricts() {
		DB_UTIL db = new DB_UTIL();
		var districts = db.getDistrict();
		var model = new Vector<District>();
		for (var element : districts) {
			model.addElement(element);
		}

		return model;
	}
}
