package real_estate_app_property;

import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.SwingConstants;


import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import real_estate_app.Main_Menu;

import java.awt.Cursor;

public class propertyWindow {

	public JFrame frame;
	private JTextField address;
	private JTextField rooms;
	private JTextField bathrooms;
	private JTextField balconies;
	private JTextField area;
	private JTextField deposit;
	private JTextField cost;
	private JTextField description;
	private static String user_name;

	
	public boolean verifyFields() {
		String address1 = address.getText();
		String rooms1 = rooms.getText();
		String bathrooms1 = bathrooms.getText();
		String balconies1 = balconies.getText();
		String area1 = area.getText();
		String deposit1 = deposit.getText();
		String cost1 = cost.getText();
		String description1 = description.getText();
		
		if(address1.trim().equals("")||rooms1.trim().equals("") ||
				bathrooms1.trim().equals("") ||balconies1.trim().equals("")||
				area1.trim().equals("") || deposit1.trim().equals("") ||
				cost1.trim().equals("")  ) {
			JOptionPane.showMessageDialog(null, "One or More Fields Are Empty!","Empty Fields",2);
			return false;
		}
		
		else {
			return true;
		}
	}
	
	public void close() {
		WindowEvent closeWindow = new WindowEvent(frame, WindowEvent.WINDOW_CLOSING);
		java.awt.Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					propertyWindow window = new propertyWindow(user_name);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void JButtonFormat(JButton btn) {
		btn.setFont(new Font("Arial", Font.PLAIN, 14));
		btn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn.setBackground(new Color(230, 230, 250));
	}
	
	/**
	 * Create the application.
	 */
	
	public propertyWindow(String uname) {
		frame = new JFrame();
		//frame.setVisible(true);
		frame.setTitle("PropertyWare - Property Management System");
		Image icon = Toolkit.getDefaultToolkit().getImage("D:/Eclipse%20Workspace/REAL_ESTATE_APP/src/images/icon.png");
		frame.setIconImage(icon);
		frame.setBackground(Color.WHITE);
		frame.setForeground(new Color(0, 102, 102));
		frame.setBounds(350, 60, 770, 630);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		JLabel lblNewLabel = new JLabel("LIST A PROPERTY");
		lblNewLabel.setBounds(214, 11, 342, 51);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(0, 139, 139));
		lblNewLabel.setFont(new Font("Lucida Sans", Font.BOLD, 33));
		lblNewLabel.setAlignmentX(0.5f);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1_1 = new JLabel("PropertyWare - Property Management Software");
		lblNewLabel_1_1.setForeground(new Color(0, 141, 139));
		lblNewLabel_1_1.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 17));
		lblNewLabel_1_1.setBounds(191, 46, 411, 29);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JPanel panel = new JPanel();
		panel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.setBounds(10, 10, 766, 693);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Property Type");
		lblNewLabel_1.setBounds(153, 139, 125, 35);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 16));
		
		final JComboBox pType = new JComboBox();
		pType.setBounds(322, 139, 228, 35);
		panel.add(pType);
		pType.setFont(new Font("Courier New", Font.PLAIN, 14));
		pType.setEditable(false);
		
		pType.addItem("Flat");
		pType.addItem("House / Villa");
		pType.addItem("Shop / Showroom");
		pType.addItem("Office Space");
		pType.setSelectedItem("Select a Property Type");
		JLabel lblNewLabel_2 = new JLabel("PROPERTY DETAILS");
		lblNewLabel_2.setBounds(56, 102, 178, 29);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Lucida Sans", Font.PLAIN, 18));
		Border title_border = BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK);
		lblNewLabel_2.setBorder(title_border);
		
		JLabel lblNewLabel_9 = new JLabel("For ");
		lblNewLabel_9.setBounds(180, 185, 87, 29);
		panel.add(lblNewLabel_9);
		lblNewLabel_9.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.RIGHT);
		
		final JComboBox pDetails = new JComboBox();
		pDetails.setBounds(323, 186, 228, 28);
		panel.add(pDetails);
		pDetails.setEditable(false);
		pDetails.setFont(new Font("Courier New", Font.PLAIN, 16));
		pDetails.setSelectedItem("Select Property For - ");
		pDetails.addItem("Sale");
		pDetails.addItem("Rent / Lease");
		pDetails.addItem("PG / Hostel");
		
		JLabel lblNewLabel_6 = new JLabel("Furnished Status");
		lblNewLabel_6.setBounds(122, 225, 145, 35);
		panel.add(lblNewLabel_6);
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6.setFont(new Font("Arial", Font.PLAIN, 16));
		
		final JComboBox furnishing = new JComboBox();
		furnishing.setBounds(323, 225, 228, 34);
		panel.add(furnishing);
		furnishing.setEditable(false);
		furnishing.setFont(new Font("Courier New", Font.PLAIN, 16));
		
		furnishing.addItem("Non - Furnished");
		furnishing.addItem("Semi - Furnished");
		furnishing.addItem("Fully - Furnished");
		
		JLabel lblNewLabel_4 = new JLabel("No. of Rooms ");
		lblNewLabel_4.setBounds(122, 271, 145, 28);
		panel.add(lblNewLabel_4);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 16));
		
		JLabel lblNewLabel_4_1 = new JLabel("Area( in sqft )");
		lblNewLabel_4_1.setBounds(122, 309, 145, 28);
		panel.add(lblNewLabel_4_1);
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4_1.setFont(new Font("Arial", Font.PLAIN, 16));
		
		area = new JTextField();
		area.setBounds(277, 309, 87, 28);
		panel.add(area);
		area.setHorizontalAlignment(SwingConstants.CENTER);
		area.setFont(new Font("Consolas", Font.PLAIN, 16));
		area.setColumns(10);
		
		rooms = new JTextField();
		rooms.setBounds(277, 271, 87, 28);
		panel.add(rooms);
		rooms.setHorizontalAlignment(SwingConstants.CENTER);
		rooms.setFont(new Font("Consolas", Font.PLAIN, 16));
		rooms.setColumns(10);
		
		bathrooms = new JTextField();
		bathrooms.setBounds(501, 271, 87, 28);
		panel.add(bathrooms);
		bathrooms.setHorizontalAlignment(SwingConstants.CENTER);
		bathrooms.setFont(new Font("Consolas", Font.PLAIN, 16));
		bathrooms.setColumns(10);
		
		balconies = new JTextField();
		balconies.setBounds(501, 309, 87, 28);
		panel.add(balconies);
		balconies.setHorizontalAlignment(SwingConstants.CENTER);
		balconies.setFont(new Font("Consolas", Font.PLAIN, 16));
		balconies.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Bathroom(s)");
		lblNewLabel_5.setBounds(346, 270, 145, 28);
		panel.add(lblNewLabel_5);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 16));
		
		JLabel lblNewLabel_4_2 = new JLabel("Balconies");
		lblNewLabel_4_2.setBounds(356, 309, 135, 28);
		panel.add(lblNewLabel_4_2);
		lblNewLabel_4_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4_2.setFont(new Font("Arial", Font.PLAIN, 16));
		
		JLabel lblNewLabel_3 = new JLabel("ADDRESS  ");
		lblNewLabel_3.setBounds(122, 348, 145, 43);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 16));
		
		address = new JTextField();
		address.setBounds(277, 348, 330, 54);
		panel.add(address);
		address.setFont(new Font("Consolas", Font.PLAIN, 14));
		address.setColumns(10);
		
		JLabel lblNewLabel_3_1 = new JLabel("Add Description");
		lblNewLabel_3_1.setBounds(132, 412, 135, 43);
		panel.add(lblNewLabel_3_1);
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3_1.setFont(new Font("Arial", Font.PLAIN, 16));
		
		description = new JTextField();
		description.setBounds(277, 412, 330, 43);
		panel.add(description);
		description.setFont(new Font("Consolas", Font.PLAIN, 14));
		description.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("DEPOSIT"); 
		lblNewLabel_7.setBounds(154, 465, 112, 35);
		panel.add(lblNewLabel_7);
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_7.setFont(new Font("Arial", Font.PLAIN, 16));
		
		deposit = new JTextField();
		deposit.setBounds(279, 470, 105, 32);
		panel.add(deposit);
		deposit.setHorizontalAlignment(SwingConstants.CENTER);
		deposit.setFont(new Font("Consolas", Font.PLAIN, 16));
		deposit.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("COST");
		lblNewLabel_8.setBounds(394, 468, 87, 28);
		panel.add(lblNewLabel_8);
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_8.setFont(new Font("Arial", Font.PLAIN, 16));
		
		cost = new JTextField();
		cost.setBounds(497, 470, 105, 32);
		panel.add(cost);
		cost.setHorizontalAlignment(SwingConstants.CENTER);
		cost.setFont(new Font("Consolas", Font.PLAIN, 16));
		cost.setColumns(10);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.setBounds(232, 536, 152, 35);
		panel.add(btnNewButton);
		JButtonFormat(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12;
				s2 = pType.getSelectedItem().toString();
				s3 = furnishing.getSelectedItem().toString();
				s4 = pDetails.getSelectedItem().toString();
				s5 = address.getText();
				s6 = description.getText();
				s7 = rooms.getText();
				s8 = bathrooms.getText();
				s9 = balconies.getText();
				s10 = area.getText();
				s11 = deposit.getText();
				s12 = cost.getText();
				try {
					
					if( verifyFields() ) {
					Property P = new Property(s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,uname);
					P.addToDatabase();
					JOptionPane.showMessageDialog(null, "PROPERTY SUCCESSFULLY ADDED.");
					Main_Menu mainform = new Main_Menu(uname);
					mainform.setVisible(true);
					mainform.pack();
					mainform.setBounds(100, 100, 770, 482);
					mainform.setLocationRelativeTo(null);
					//close login
					frame.dispose();
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Please Enter Valid Details.");
				}
			}
		});
		
		
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 16));
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.setBounds(418, 536, 152, 35);
		panel.add(btnCancel);
		JButtonFormat(btnCancel);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main_Menu mainform = new Main_Menu(uname);
				mainform.setVisible(true);
				mainform.pack();
				mainform.setBounds(100, 100, 770, 482);
				mainform.setLocationRelativeTo(null);
				//close login
				frame.dispose();
			}
		});
		btnCancel.setFont(new Font("Arial", Font.PLAIN, 16));
		
				
		

	}
}
