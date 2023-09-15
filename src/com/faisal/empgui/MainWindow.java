package com.faisal.empgui;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
					Files.createDirectories(Paths.get(System.getProperty("user.home"), "/emp-images"));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);


		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(10, 42, 564, 308);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));

		JPanel wlcPanel = new WelcomePanel();
		layeredPane.add(wlcPanel, "name_19251693424100");
		layeredPane.setLayer(wlcPanel, 0);

		JPanel showEmpPanel = new ShowEmployeePanel();
		layeredPane.add(showEmpPanel, "name_228655723198400");

		JPanel addDistPanel = new AddDistrictPanel();
		layeredPane.add(addDistPanel, "name_125723207752000");

		JPanel showDistPanel = new ShowDistrictPanel();
		layeredPane.add(showDistPanel, "name_127500599036700");

		JPanel addUpzPanel = new AddUpazillaPanel();
		layeredPane.add(addUpzPanel, "name_164650998022500");


		JPanel showUpzPanel = new ShowUpazillaPanel();
		layeredPane.add(showUpzPanel, "name_173752868045100");

		JPanel addEmpPanel = new AddEmployeePanel();
		layeredPane.add(addEmpPanel, "name_176624290242800");

		JPanel srchEmpPanel = new SearchEmployeePanel();
		layeredPane.add(srchEmpPanel, "name_229282184965900");


		JPanel menuPanel = new JPanel();
		menuPanel.setBounds(10, 11, 564, 27);
		contentPane.add(menuPanel);
		menuPanel.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(10, 0, 564, 22);
		menuPanel.add(menuBar);

		JMenu configMenu = new JMenu("Configuration");
		menuBar.add(configMenu);

		JMenuItem addDistMenuItem = new JMenuItem("Add District");
		addDistMenuItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				layeredPane.removeAll();
				layeredPane.add(addDistPanel);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		configMenu.add(addDistMenuItem);

		JMenuItem showDistMenu = new JMenuItem("Show District");
		showDistMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				layeredPane.removeAll();
				layeredPane.add(showDistPanel);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		configMenu.add(showDistMenu);

		JMenuItem addUpzMenu = new JMenuItem("Add Upazilla");
		addUpzMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				layeredPane.removeAll();
				layeredPane.add(addUpzPanel);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		configMenu.add(addUpzMenu);

		JMenuItem showUpzMenu = new JMenuItem("Show Upazilla");
		showUpzMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				layeredPane.removeAll();
				layeredPane.add(showUpzPanel);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		configMenu.add(showUpzMenu);

		JMenu empMenu = new JMenu("Employee");
		menuBar.add(empMenu);

		JMenuItem addEmpMenu = new JMenuItem("Add");
		addEmpMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				layeredPane.removeAll();
				layeredPane.add(addEmpPanel);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		empMenu.add(addEmpMenu);

		JMenuItem showEmpMenu = new JMenuItem("Show");
		showEmpMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				layeredPane.removeAll();
				layeredPane.add(showEmpPanel);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		empMenu.add(showEmpMenu);

		JMenuItem searchEmpMenu = new JMenuItem("Search");
		searchEmpMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				layeredPane.removeAll();
				layeredPane.add(srchEmpPanel);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		empMenu.add(searchEmpMenu);	
		
	}
	
	
}
