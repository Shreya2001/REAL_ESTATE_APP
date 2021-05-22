package real_estate_app_users;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import real_estate_app.THE_CONNECTION;

import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class updatePassword extends JFrame {

	private JPanel contentPane;
	private static User up;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updatePassword frame = new updatePassword(up);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public boolean verifyFields(String s1) {
		String s2=String.valueOf(passwordField.getPassword());
		String s3=String.valueOf(passwordField_1.getPassword()) ;
		
		if(s3.trim().equals("")||s2.trim().equals("")) {
			JOptionPane.showMessageDialog(null, "One or More Fields Are Empty!","Empty Fields",2);
			return false;
		}
		else if(!s1.equals(s2)) {
			JOptionPane.showMessageDialog(null, "Existing Password does not match Old Password","Old Password Incorrect",2);
			return false;
		}
		return true;
	}
	
	/**
	 * Create the frame.
	 */
	public updatePassword(User user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("PropertyWare - Property Management System");
		Image icon = Toolkit.getDefaultToolkit().getImage("D:/Eclipse%20Workspace/REAL_ESTATE_APP/src/images/icon.png");
		setIconImage(icon);
		setBounds(100, 100, 553, 343);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("UPDATE PASSWORD");
		lblNewLabel.setBounds(91, 11, 342, 51);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(0, 139, 139));
		lblNewLabel.setFont(new Font("Lucida Sans", Font.BOLD, 33));
		lblNewLabel.setAlignmentX(0.5f);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("Enter The Old and New Password");
		lblNewLabel_3.setForeground(new Color(0, 141, 139));
		lblNewLabel_3.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(126, 55, 280, 29);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1 = new JLabel("Old Password");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(126, 125, 107, 17);
		panel.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(227, 120, 141, 29);
		panel.add(passwordField);
		
		JLabel lblNewLabel_1_1 = new JLabel("New Password");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(126, 185, 107, 17);
		panel.add(lblNewLabel_1_1);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(227, 180, 141, 29);
		panel.add(passwordField_1);
		
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
		btnBack.setBounds(280, 238, 119, 36);
		btnBack.setFont(new Font("Arial", Font.PLAIN, 14));
		btnBack.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBack.setBackground(new Color(230, 230, 250));
		panel.add(btnBack);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String newP = String.valueOf(passwordField_1.getPassword());
				String oldP = user.getPassword();
				if(verifyFields(user.getPassword())) {
					Statement ps;
					ResultSet rs;
					String registerUserQuery="UPDATE `users` SET `password`='"+newP+"' WHERE `username`='"+user.getUsername()+"'";
					try {
						ps = THE_CONNECTION.getConnection().createStatement();
												
								
						if(ps.executeUpdate(registerUserQuery)!=0) {
							JOptionPane.showMessageDialog(null, "Your Password has been Updated Successfully!");
							user.setPassword(newP);
						}
						else {
							JOptionPane.showMessageDialog(null, "Old Password does not match to Existing Password!","Incorrect Existing Password",2);
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
		btnUpdate.setBounds(114, 238, 119, 36);
		btnUpdate.setFont(new Font("Arial", Font.PLAIN, 14));
		btnUpdate.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnUpdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUpdate.setBackground(new Color(230, 230, 250));
		panel.add(btnUpdate);
	}
}
