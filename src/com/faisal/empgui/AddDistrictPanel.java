package com.faisal.empgui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class AddDistrictPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	private JTextField txtDist;
	
	public AddDistrictPanel() {

		setBackground(new Color(0, 139, 139));
		setForeground(new Color(65, 105, 225));
		setLayout(null);

		JLabel divLabel = new JLabel("Division");
		divLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		divLabel.setHorizontalAlignment(SwingConstants.CENTER);
		divLabel.setBounds(149, 106, 81, 24);
		add(divLabel);

		JComboBox distCombo = new JComboBox();
		divLabel.setLabelFor(distCombo);
		distCombo.setModel(new DefaultComboBoxModel(Divisions.values()));
		distCombo.setBounds(241, 106, 132, 24);
		add(distCombo);

		JLabel distLabel = new JLabel("District");
		distLabel.setLabelFor(distLabel);
		distLabel.setHorizontalAlignment(SwingConstants.CENTER);
		distLabel.setBounds(149, 141, 81, 24);
		add(distLabel);

		txtDist = new JTextField();
		txtDist.setBounds(241, 141, 132, 24);
		add(txtDist);
		txtDist.setColumns(10);


		JButton btnDistSave = new JButton("Save");
		btnDistSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Divisions selectedType = (Divisions) distCombo.getSelectedItem();
				//_districts.add(new District(selectedType.name(), txtDist.getText()));
				//tblDistList.repaint();
				//layeredPane.removeAll();
				//layeredPane.add(panel_2);
				//layeredPane.repaint();
				//layeredPane.revalidate();

				distCombo.setSelectedIndex(0);
				txtDist.setText("");
			}
		});
		btnDistSave.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDistSave.setForeground(new Color(255, 255, 255));
		btnDistSave.setBackground(new Color(46, 139, 87));
		btnDistSave.setBounds(283, 205, 90, 33);
		add(btnDistSave);

		JButton btnNewButton = new JButton("Clear");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				distCombo.setSelectedIndex(0);
				txtDist.setText("");
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(119, 136, 153));
		btnNewButton.setBounds(180, 205, 90, 33);
		add(btnNewButton);
	}

}
