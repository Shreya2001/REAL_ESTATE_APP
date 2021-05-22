package real_estate_app_users;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import real_estate_app.THE_CONNECTION;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class updateProfile extends JFrame {

	private JPanel contentPane;
	private JTextField first_name;
	private JTextField last_name;
	private JTextField contact_num;
	private JTextField age_num;
	private static User u;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updateProfile frame = new updateProfile(u);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public boolean verifyFields() {
		String fname = first_name.getText();
		String lname = last_name.getText();
		String phnum = contact_num.getText();
		String ageno = age_num.getText();
		
		if(fname.trim().equals("") || lname.trim().equals("") ||phnum.trim().equals("")|| ageno.trim().equals("")) {
			JOptionPane.showMessageDialog(null, "One or More Fields Are Empty!","Empty Fields",2);
			return false;
		}
		
		else {
			return true;
		}
	}

	/**
	 * Create the frame.
	 */
	public updateProfile(User user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("PropertyWare - Property Management System");
		Image icon = Toolkit.getDefaultToolkit().getImage("D:/Eclipse%20Workspace/REAL_ESTATE_APP/src/images/icon.png");
		setIconImage(icon);
		setBounds(100, 100, 638, 372);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("UPDATE PROFILE");
		lblNewLabel.setBounds(130, 11, 342, 51);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(0, 139, 139));
		lblNewLabel.setFont(new Font("Lucida Sans", Font.BOLD, 33));
		lblNewLabel.setAlignmentX(0.5f);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("Enter Modified Details");
		lblNewLabel_3.setForeground(new Color(0, 141, 139));
		lblNewLabel_3.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(210, 51, 195, 29);
		panel.add(lblNewLabel_3);
		
		JLabel label = new JLabel("First Name");
		label.setFont(new Font("Arial", Font.PLAIN, 15));
		label.setBounds(53, 119, 108, 18);
		panel.add(label);
		
		first_name = new JTextField();
		first_name.setHorizontalAlignment(SwingConstants.LEFT);
		first_name.setFont(new Font("Courier New", Font.PLAIN, 14));
		first_name.setBounds(132, 112, 124, 29);
		panel.add(first_name);
		first_name.setColumns(10);
		
		JLabel label_l = new JLabel("Last Name");
		label_l.setFont(new Font("Arial", Font.PLAIN, 15));
		label_l.setBounds(347, 119, 108, 18);
		panel.add(label_l);
		
		last_name = new JTextField();
		last_name.setFont(new Font("Courier New", Font.PLAIN, 14));
		last_name.setColumns(10);
		last_name.setBounds(426, 112, 124, 29);
		panel.add(last_name);
		
		JLabel show_valid = new JLabel("");
		show_valid.setForeground(Color.RED);
		show_valid.setBounds(435, 178, 96, 14);
		panel.add(show_valid);
		
		JLabel show_valid1 = new JLabel("");
		show_valid1.setForeground(Color.RED);
		show_valid1.setBounds(435, 218, 96, 14);
		panel.add(show_valid1);
		
		
		contact_num = new JTextField();
		contact_num.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String ph = contact_num.getText();
				int len = ph.length();
				char c = e.getKeyChar();
				
				if(e.getKeyChar()>='0' && e.getKeyChar()<='9') {
					if(len<10) {
						contact_num.setEditable(true);
					}
					else {
						//not editable if length more than 10 digits
						contact_num.setEditable(false);
					}
				}else {
					//allow for keys 'back space' or 'delete' for editing 
					if(e.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE || e.getExtendedKeyCode()==KeyEvent.VK_DELETE) {
						//then allow editable
						contact_num.setEditable(true);
					}else {
						contact_num.setEditable(false);
					}
				}
			}
			
			@Override
			public void keyTyped(KeyEvent evt) {
				try {
					int i =Integer.parseInt(contact_num.getText());
					show_valid.setText("");
				}catch(NumberFormatException e1) {
					show_valid.setText("Invalid Number");
				}
			}
		});
		contact_num.setFont(new Font("Courier New", Font.PLAIN, 14));
		contact_num.setColumns(10);
		contact_num.setBounds(306, 163, 124, 29);
		panel.add(contact_num);
		
		JLabel mob_no = new JLabel("Mobile Number");
		mob_no.setFont(new Font("Arial", Font.PLAIN, 15));
		mob_no.setBounds(188, 167, 108, 18);
		panel.add(mob_no);
		
		JLabel age_no = new JLabel("Age");
		age_no.setFont(new Font("Arial", Font.PLAIN, 15));
		age_no.setBounds(188, 207, 108, 18);
		panel.add(age_no);
		
		age_num = new JTextField();
		age_num.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent en) {
				try {
					int j =Integer.parseInt(age_num.getText());
					show_valid1.setText("");
				}catch(NumberFormatException en1) {
					show_valid1.setText("Invalid Age");
				}
			}
		});
		age_num.setFont(new Font("Courier New", Font.PLAIN, 14));
		age_num.setColumns(10);
		age_num.setBounds(306, 203, 124, 29);
		panel.add(age_num);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setFont(new Font("Arial", Font.PLAIN, 14));
		btnUpdate.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnUpdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUpdate.setBackground(new Color(230, 230, 250));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				String fname = first_name.getText();
				String lname = last_name.getText();
				String phnum = contact_num.getText();
				String ageno = age_num.getText();
				
				if(verifyFields()) {
					Statement ps;
					ResultSet rs;
					String registerUserQuery="UPDATE `users` SET `fname`='"+fname+"', `lname`='"+lname+"', `number`='"+phnum+"', `age`='"+ageno+"' WHERE `username`='"+user.getUsername()+"'";
					
					try {
						ps = THE_CONNECTION.getConnection().createStatement();
												
								
						if(ps.executeUpdate(registerUserQuery)!=0) {
							JOptionPane.showMessageDialog(null, "Your Account has been Updated Successfully!");
							user.UpdateData(first_name.getText(),last_name.getText(), 
									Long.parseLong(contact_num.getText()) , Integer.parseInt(age_num.getText()));
						}
						else {
							JOptionPane.showMessageDialog(null, "Error: Check Your Information");
						}						
									
						userProfile profile = new userProfile(user);
						profile.setVisible(true);
						profile.pack();
						profile.setBounds(100, 100, 770, 482);
						profile.setLocationRelativeTo(null);
						//close menu
						dispose();
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnUpdate.setBounds(188, 275, 119, 36);
		panel.add(btnUpdate);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userProfile profile = new userProfile(user);
				profile.setVisible(true);
				profile.pack();
				profile.setBounds(100, 100, 770, 482);
				profile.setLocationRelativeTo(null);
				//close menu
				dispose();
			}
		});
		btnBack.setBounds(335, 276, 119, 36);
		btnBack.setFont(new Font("Arial", Font.PLAIN, 14));
		btnBack.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBack.setBackground(new Color(230, 230, 250));
		panel.add(btnBack);
		
		
		
	}
}
