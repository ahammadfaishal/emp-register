package com.faisal.empgui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class WelcomePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public WelcomePanel() {
		setBackground(new Color(0, 139, 139));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to Employee Registration System");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(76, 82, 397, 30);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Assaignment: 03");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(466, 283, 88, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("IICT, BUET");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(10, 283, 60, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Faishal Ahammad");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(220, 133, 129, 14);
		add(lblNewLabel_3);
	}

}
