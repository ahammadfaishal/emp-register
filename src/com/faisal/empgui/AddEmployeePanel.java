package com.faisal.empgui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.toedter.calendar.JDateChooser;

public class AddEmployeePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	
	private JTextField txtFName;
	private JTextField txtMName;
	private JTextField txtLName;
	private JTextField txtNID;
	private JTextField txtPhone;
	private JTextField txtEmail;
	
	public AddEmployeePanel() {

		setBackground(new Color(0, 139, 139));
		setLayout(null);
		
		JLabel lblFName = new JLabel("First name");
		lblFName.setForeground(new Color(255, 255, 255));
		lblFName.setBounds(34, 61, 81, 24);
		add(lblFName);

		txtFName = new JTextField();
		lblFName.setLabelFor(txtFName);
		txtFName.setBounds(125, 61, 101, 24);
		add(txtFName);
		txtFName.setColumns(10);

		JLabel lblMName = new JLabel("Middle name");
		lblMName.setForeground(new Color(255, 255, 255));
		lblMName.setBounds(34, 86, 81, 24);
		add(lblMName);

		txtMName = new JTextField();
		lblMName.setLabelFor(txtMName);
		txtMName.setBounds(125, 86, 101, 24);
		add(txtMName);
		txtMName.setColumns(10);

		JLabel lblLName = new JLabel("Last name");
		lblLName.setForeground(new Color(255, 255, 255));
		lblLName.setBounds(34, 111, 81, 24);
		add(lblLName);

		txtLName = new JTextField();
		lblLName.setLabelFor(txtLName);
		txtLName.setBounds(125, 111, 101, 24);
		add(txtLName);
		txtLName.setColumns(10);

		JLabel lblGender = new JLabel("Gender");
		lblGender.setForeground(new Color(255, 255, 255));
		lblGender.setBounds(34, 135, 81, 24);
		add(lblGender);

		JComboBox cmbGender = new JComboBox();
		lblGender.setLabelFor(cmbGender);
		cmbGender.setModel(new DefaultComboBoxModel(Gender.values()));
		cmbGender.setBounds(125, 135, 101, 24);
		add(cmbGender);

		JLabel lblNID = new JLabel("NID");
		lblNID.setForeground(new Color(255, 255, 255));
		lblNID.setBounds(34, 160, 46, 24);
		add(lblNID);

		txtNID = new JTextField();
		lblNID.setLabelFor(txtNID);
		txtNID.setBounds(125, 160, 101, 24);
		add(txtNID);
		txtNID.setColumns(10);

		JLabel lblDOB = new JLabel("Date of birth");
		lblDOB.setForeground(new Color(255, 255, 255));
		lblDOB.setBounds(34, 185, 81, 24);
		add(lblDOB);

		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setForeground(new Color(255, 255, 255));
		lblPhone.setBounds(34, 210, 81, 24);
		add(lblPhone);

		txtPhone = new JTextField();
		lblPhone.setLabelFor(txtPhone);
		txtPhone.setBounds(125, 210, 101, 24);
		add(txtPhone);
		txtPhone.setColumns(10);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(new Color(255, 255, 255));
		lblEmail.setBounds(34, 235, 81, 24);
		add(lblEmail);

		txtEmail = new JTextField();
		lblEmail.setLabelFor(txtEmail);
		txtEmail.setBounds(125, 235, 101, 24);
		add(txtEmail);
		txtEmail.setColumns(10);

		JDateChooser dob = new JDateChooser();
		lblDOB.setLabelFor(dob);
		dob.setBounds(125, 185, 101, 24);
		add(dob);

		JLabel lblEmpDivision = new JLabel("Division");
		lblEmpDivision.setForeground(new Color(255, 255, 255));
		lblEmpDivision.setBounds(269, 160, 81, 24);
		add(lblEmpDivision);

		JComboBox cmbEmpDiv = new JComboBox();
		lblEmpDivision.setLabelFor(cmbEmpDiv);
		cmbEmpDiv.setModel(new DefaultComboBoxModel(Divisions.values()));
		cmbEmpDiv.setBounds(351, 160, 101, 24);
		add(cmbEmpDiv);

		JLabel lblEmpDist = new JLabel("District");
		lblEmpDist.setForeground(new Color(255, 255, 255));
		lblEmpDist.setBounds(269, 185, 81, 24);
		add(lblEmpDist);

		JComboBox cmbEmpDist = new JComboBox();
		cmbEmpDist.setModel(new DefaultComboBoxModel(new String[] {"Comilla", "Dhaka ", "Savar", "Narayangonj", "Natore", "Chapai", "Chadpur"}));
		lblEmpDist.setLabelFor(cmbEmpDist);
		cmbEmpDist.setBounds(351, 185, 101, 24);
		add(cmbEmpDist);

		JLabel lblEmpThana = new JLabel("Thana");
		lblEmpThana.setForeground(new Color(255, 255, 255));
		lblEmpThana.setBounds(269, 210, 81, 24);
		add(lblEmpThana);

		JComboBox cmbEmpThana = new JComboBox();
		cmbEmpThana.setModel(new DefaultComboBoxModel(new String[] {"Comilla", "Laksam", "Comilla Sadar", "Chandina", "Daudkandi"}));
		lblEmpThana.setLabelFor(cmbEmpThana);
		cmbEmpThana.setBounds(351, 210, 101, 24);
		add(cmbEmpThana);

		JLabel lblAddress = new JLabel("Address");
		lblAddress.setForeground(new Color(255, 255, 255));
		lblAddress.setBounds(269, 235, 81, 24);
		add(lblAddress);

		JTextArea txaAddress = new JTextArea();
		lblAddress.setLabelFor(txaAddress);
		txaAddress.setBounds(351, 235, 101, 24);
		add(txaAddress);

		JLabel lblImageContainer = new JLabel("Image");
		lblImageContainer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
				FileNameExtensionFilter filer = new FileNameExtensionFilter("*.Images","jpg", "png");
				fileChooser.addChoosableFileFilter(filer);
				int result = fileChooser.showSaveDialog(null);
				if(result == JFileChooser.APPROVE_OPTION) {
					File file = fileChooser.getSelectedFile();
					String path = file.getAbsolutePath();
					lblImageContainer.setIcon(ResizeImage(path, lblImageContainer.getWidth(), lblImageContainer.getHeight()));
				}
			}
		});
		lblImageContainer.setForeground(new Color(135, 206, 250));
		lblImageContainer.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblImageContainer.setBorder(BorderFactory.createLineBorder(new Color(144, 238, 144)));
		lblImageContainer.setHorizontalAlignment(SwingConstants.CENTER);
		lblImageContainer.setBounds(331, 20, 121, 103);
		add(lblImageContainer);		
	}

	public ImageIcon ResizeImage(String imagepath, int widhth, int height) {
		ImageIcon icon = new ImageIcon(imagepath);
		Image img = icon.getImage();
		Image scaledImg = img.getScaledInstance(widhth, height, Image.SCALE_SMOOTH);
		return new ImageIcon(scaledImg);
	}
}
