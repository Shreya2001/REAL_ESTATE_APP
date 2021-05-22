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
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import real_estate_app.Main_Menu;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class userProfile extends JFrame {

	private JPanel contentPane;
	private static User user_pro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					userProfile frame = new userProfile(user_pro);
					frame.setVisible(true);
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
	 * Create the frame.
	 */
	public userProfile(User u) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("PropertyWare - Property Management System");
		Image icon = Toolkit.getDefaultToolkit().getImage("D:/Eclipse%20Workspace/REAL_ESTATE_APP/src/images/icon.png");
		setIconImage(icon);
		setBounds(100, 100, 770, 482);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("USER PROFILE");
		lblNewLabel.setBounds(214, 11, 342, 51);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(0, 139, 139));
		lblNewLabel.setFont(new Font("Lucida Sans", Font.BOLD, 33));
		lblNewLabel.setAlignmentX(0.5f);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("Your Personal Details");
		lblNewLabel_3.setForeground(new Color(0, 141, 139));
		lblNewLabel_3.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(297, 52, 195, 29);
		panel.add(lblNewLabel_3);
		
		JLabel Name = new JLabel("UserName : ");
		Name.setFont(new Font("Arial", Font.BOLD, 15));
		Name.setBounds(251, 121, 99, 17);
		panel.add(Name);
		
		JLabel lblNewLabel_1 = new JLabel(u.getUsername());
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(424, 122, 225, 15);
		panel.add(lblNewLabel_1);
		
		JLabel Name_1 = new JLabel("Name : ");
		Name_1.setFont(new Font("Arial", Font.BOLD, 15));
		Name_1.setBounds(251, 166, 78, 17);
		panel.add(Name_1);
		
		JLabel lblNewLabel_1_1 = new JLabel(u.getFullName());
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(424, 167, 225, 15);
		panel.add(lblNewLabel_1_1);
		
		JLabel Name_1_1 = new JLabel("Mobile Number :");
		Name_1_1.setFont(new Font("Arial", Font.BOLD, 15));
		Name_1_1.setBounds(251, 208, 142, 17);
		panel.add(Name_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel(String.valueOf(u.getNumber()));
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(424, 209, 225, 15);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel Name_1_2 = new JLabel("Age : ");
		Name_1_2.setFont(new Font("Arial", Font.BOLD, 15));
		Name_1_2.setBounds(251, 253, 78, 17);
		panel.add(Name_1_2);
		
		JLabel lblNewLabel_1_1_2 = new JLabel(String.valueOf(u.getAge()));
		lblNewLabel_1_1_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_1_2.setBounds(424, 254, 225, 15);
		panel.add(lblNewLabel_1_1_2);
		
		JLabel Name_1_3 = new JLabel("Gender : ");
		Name_1_3.setFont(new Font("Arial", Font.BOLD, 15));
		Name_1_3.setBounds(251, 298, 103, 17);
		panel.add(Name_1_3);
		
		JLabel lblNewLabel_1_1_3 = new JLabel(u.getGender());
		lblNewLabel_1_1_3.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_1_3.setBounds(424, 299, 225, 15);
		panel.add(lblNewLabel_1_1_3);
		
		JLabel Name_1_4 = new JLabel("User Mode : ");
		Name_1_4.setFont(new Font("Arial", Font.BOLD, 15));
		Name_1_4.setBounds(251, 343, 99, 17);
		panel.add(Name_1_4);
		
		JLabel lblNewLabel_1_1_4 = new JLabel(u.getUserType());
		lblNewLabel_1_1_4.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_1_4.setBounds(424, 344, 225, 15);
		panel.add(lblNewLabel_1_1_4);
		
		JButton btnUpdate = new JButton("CHANGE PASSWORD");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updatePassword pass = new updatePassword(u);
				pass.setVisible(true);
				pass.pack();
				pass.setBounds(100, 100, 553, 343);
				pass.setLocationRelativeTo(null);
				//close menu
				dispose();
			}
		});
		btnUpdate.setBounds(310, 387, 156, 37);
		JButtonFormat(btnUpdate);
		panel.add(btnUpdate);
		
		JButton btnPass = new JButton("UPDATE PROFILE");
		btnPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateProfile profile = new updateProfile(u);
				profile.setVisible(true);
				profile.pack();
				profile.setBounds(100, 100, 638, 372);
				profile.setLocationRelativeTo(null);
				//close menu
				dispose();
			}
		});
		btnPass.setBounds(144, 388, 132, 37);
		JButtonFormat(btnPass);
		panel.add(btnPass);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main_Menu mainform = new Main_Menu(u.getUsername());
				mainform.setVisible(true);
				mainform.pack();
				mainform.setBounds(100, 100, 770, 482);
				mainform.setLocationRelativeTo(null);
				//close login
				dispose();
			}
		});
		btnBack.setBounds(500, 387, 119, 37);
		JButtonFormat(btnBack);
		panel.add(btnBack);
		
	}
}
