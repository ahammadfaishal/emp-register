package com.faisal.empgui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class LoginFrame extends JFrame {

	private Image img_logo = new ImageIcon(LoginFrame.class.getResource("/res/bank.png")).getImage()
			.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
	private Image user_icon = new ImageIcon(LoginFrame.class.getResource("/res/user.png")).getImage()
			.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image lock_icon = new ImageIcon(LoginFrame.class.getResource("/res/lock.png")).getImage()
			.getScaledInstance(30, 30, Image.SCALE_SMOOTH);

	private JPanel contentPane;
	private JTextField txtUserName;
	private JPasswordField pwdField;
	private JPanel loginPanel;
	private JLabel lblLogo;
	private JLabel userNameIconLabel;
	private JLabel pwdIconLabel;
	private JLabel lblWarning;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setPreferredSize(new Dimension(0, 0));
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 128), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel userNamePanel = new JPanel();
		userNamePanel.setBackground(new Color(255, 255, 255));
		userNamePanel.setBounds(149, 186, 300, 30);
		contentPane.add(userNamePanel);
		userNamePanel.setLayout(null);

		txtUserName = new JTextField();
		txtUserName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtUserName.getText().equals("Username")) {
					txtUserName.setText("");
				} else {
					txtUserName.selectAll();
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtUserName.getText().equals("")) {
					txtUserName.setText("Username");
				}
			}
		});
		txtUserName.setBorder(null);
		txtUserName.setText("Username");
		txtUserName.setBounds(10, 2, 219, 28);
		userNamePanel.add(txtUserName);
		txtUserName.setColumns(10);

		userNameIconLabel = new JLabel();
		userNameIconLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		userNameIconLabel.setHorizontalAlignment(SwingConstants.CENTER);
		userNameIconLabel.setLabelFor(txtUserName);
		userNameIconLabel.setBounds(240, 2, 50, 28);
		userNameIconLabel.setIcon(new ImageIcon(user_icon));
		userNamePanel.add(userNameIconLabel);

		JPanel pwdPanel = new JPanel();
		pwdPanel.setBackground(new Color(255, 255, 255));
		pwdPanel.setBounds(149, 223, 300, 30);
		contentPane.add(pwdPanel);
		pwdPanel.setLayout(null);

		pwdField = new JPasswordField();
		pwdField.setEchoChar((char) 0);
		pwdField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (pwdField.getText().equals("Password")) {
					pwdField.setEchoChar('*');
					pwdField.setText("");
				} else {
					pwdField.selectAll();
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (pwdField.getText().equals("")) {
					pwdField.setText("Password");
					pwdField.setEchoChar((char) 0);
				}
			}
		});
		pwdField.setBorder(null);
		pwdField.setText("Password");
		pwdField.setBounds(10, 2, 220, 28);
		pwdPanel.add(pwdField);

		pwdIconLabel = new JLabel("");
		pwdIconLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pwdIconLabel.setLabelFor(pwdField);
		pwdIconLabel.setBounds(240, 2, 50, 28);
		pwdIconLabel.setIcon(new ImageIcon(lock_icon));
		pwdPanel.add(pwdIconLabel);

		loginPanel = new JPanel();
		loginPanel.setBackground(new Color(47, 79, 79));
		loginPanel.setBounds(149, 307, 300, 50);
		contentPane.add(loginPanel);
		loginPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("LOG IN");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (txtUserName.getText().equals("admin") && pwdField.getText().equals("123qwe")) {
					lblWarning.setText("Login successful");
					MainWindow main = new MainWindow();
					main.setVisible(true);
					LoginFrame.this.dispose();
				} else {
					lblWarning.setText("Incorrect username and password");
				}
			}
		});
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(89, 11, 112, 28);
		loginPanel.add(lblNewLabel);

		JLabel lblX = new JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Are you sure to close this application?", "Confirm",
						JOptionPane.YES_NO_OPTION) == 0) {
					LoginFrame.this.dispose();
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblX.setForeground(Color.RED);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblX.setForeground(Color.WHITE);
			}
		});
		lblX.setForeground(new Color(255, 255, 255));
		lblX.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setBounds(570, 11, 20, 20);
		contentPane.add(lblX);

		lblLogo = new JLabel("");
		lblLogo.setAlignmentY(Component.TOP_ALIGNMENT);
		lblLogo.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblLogo.setHorizontalTextPosition(SwingConstants.CENTER);
		lblLogo.setSize(new Dimension(90, 90));
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setBounds(149, 31, 300, 128);
		contentPane.add(lblLogo);
		lblLogo.setIcon(new ImageIcon(img_logo));

		lblWarning = new JLabel("");
		lblWarning.setForeground(new Color(255, 255, 0));
		lblWarning.setBounds(149, 276, 300, 25);
		contentPane.add(lblWarning);
		setUndecorated(true);
		setLocationRelativeTo(null);
	}
}
