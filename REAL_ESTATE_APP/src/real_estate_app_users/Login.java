package real_estate_app_users;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.awt.event.*;
import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.xdevapi.Statement;

import real_estate_app.Home_Screen;
import real_estate_app.Main_Menu;
import real_estate_app.THE_CONNECTION;

import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField jTextField_Username;
	private JPasswordField jpasswordField1;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("PropertyWare - Property Management System");
		Image icon = Toolkit.getDefaultToolkit().getImage("D:/Eclipse%20Workspace/REAL_ESTATE_APP/src/images/icon.png");
		setIconImage(icon);
		setBounds(100, 100, 770, 482);
		contentPane = new JPanel();
		this.setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JSplitPane splitPane = new JSplitPane();
		contentPane.add(splitPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		splitPane.setLeftComponent(panel);
		panel.setLayout(new BorderLayout(0, 0));
		panel.setBackground(Color.WHITE);
		
		JLabel jLabel_Image = new JLabel("");
		jLabel_Image.setBackground(Color.WHITE);
		jLabel_Image.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(jLabel_Image);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(51, 51, 102));
		panel_1.setForeground(Color.WHITE);
		splitPane.setRightComponent(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PROPERTYWARE");
		lblNewLabel.setBounds(78, 39, 268, 57);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setAlignmentY(Component.TOP_ALIGNMENT);
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Lucida Sans", Font.BOLD, 30));
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("LOGIN");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 21));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(47, 121, 74, 38);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_1);
		
		Border title_border = BorderFactory.createMatteBorder(0, 0, 2, 0, Color.YELLOW);
		lblNewLabel_1.setBorder(title_border);
		
		JLabel icon_label = new JLabel("");
		icon_label.setBounds(47, 194, 45, 38);
		panel_1.add(icon_label);

		jLabel_Image.setIcon(new ImageIcon(Login.class.getResource("/images/building.png")));
		jLabel_Image.setVerticalAlignment(SwingConstants.BOTTOM);
		
		icon_label.setIcon(new ImageIcon(Login.class.getResource("/images/person.png")));
		
		JLabel pwd_label = new JLabel("");
		pwd_label.setBounds(47, 266, 45, 38);
		panel_1.add(pwd_label);
		
		pwd_label.setIcon(new ImageIcon(Login.class.getResource("/images/key.png")));
		
		JLabel lblNewLabel_2 = new JLabel("User ID");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(89, 205, 74, 14);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Password");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(89, 279, 74, 14);
		panel_1.add(lblNewLabel_2_1);
		
		jTextField_Username = new JTextField();
		jTextField_Username.setText("username");
		jTextField_Username.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(jTextField_Username.getText().trim().toLowerCase().equals("username")) {
					jTextField_Username.setText("");
					jTextField_Username.setForeground(Color.black);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(jTextField_Username.getText().trim().equals("") || jTextField_Username.getText().trim().toLowerCase().equals("username")){
		
					jTextField_Username.setText("Username");
					jTextField_Username.setForeground(new Color(102,102,153));
				}
				
			}
		});
		jTextField_Username.setForeground(new Color(102, 102, 153));
		jTextField_Username.setFont(new Font("Arial", Font.PLAIN, 14));
		jTextField_Username.setBounds(173, 198, 197, 29);
		panel_1.add(jTextField_Username);
		jTextField_Username.setColumns(10);
		
		jpasswordField1 = new JPasswordField();
		jpasswordField1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				String password = String.valueOf(jpasswordField1.getPassword());
				if(password.trim().toLowerCase().equals("")) {
					jpasswordField1.setText("");
					jpasswordField1.setForeground(Color.black);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				String password = String.valueOf(jpasswordField1.getPassword());
				
				if(password.trim().equals("") || password.trim().toLowerCase().equals("")){
					
					jpasswordField1.setText("");
					jpasswordField1.setForeground(new Color(102,102,153));
				}
			}
		});
		jpasswordField1.setForeground(new Color(102, 102, 153));
		jpasswordField1.setFont(new Font("Arial", Font.PLAIN, 14));
		jpasswordField1.setBounds(173, 272, 181, 29);
		panel_1.add(jpasswordField1);
		
		JButton jButton_Login = new JButton("ENTER");
		jButton_Login.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		jButton_Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username=jTextField_Username.getText();
				String password=String.valueOf(jpasswordField1.getPassword());
				
				PreparedStatement ps;
				ResultSet rs;
				
				String selectuery="SELECT * FROM `users` WHERE `username` = ? AND password = ?";
				
				if(username.trim().toLowerCase().equals("username") ||
						password.trim().toLowerCase().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Enter Your Username and Password", "Empty Field", 2);
				}
				else {
					try {
						ps = THE_CONNECTION.getConnection().prepareStatement(selectuery);
						ps.setString(1, username);
						ps.setString(2, password);
						
						rs=ps.executeQuery();
						
						if(rs.next()) {
							Main_Menu mainform = new Main_Menu(username);
							mainform.setVisible(true);
							mainform.pack();
														
							mainform.setBounds(100, 100, 770, 482);
							mainform.setLocationRelativeTo(null);
							//close login
							dispose();
						}
						else {
							JOptionPane.showMessageDialog(null, "Invalid Username or Password","Wrong Data",2);
							
						}
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				
			}
		});
		jButton_Login.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jButton_Login.setBackground(new Color(230, 230, 250));
		jButton_Login.setForeground(Color.BLACK);
		jButton_Login.setFont(new Font("Arial", Font.PLAIN, 16));
		jButton_Login.setBounds(47, 349, 88, 38);
		panel_1.add(jButton_Login);
		
		JLabel lblNewLabel_3 = new JLabel("Property Management Software");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(99, 74, 241, 29);
		panel_1.add(lblNewLabel_3);
		
		JButton jButton_Cancel = new JButton("CANCEL");
		jButton_Cancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jButton_Cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home_Screen start_up = new Home_Screen();
				start_up.setVisible(true);
				start_up.pack();
				start_up.setBounds(100, 100, 770, 482);
				start_up.setLocationRelativeTo(null);
				//close login
				dispose();
			}
		});
		jButton_Cancel.setForeground(Color.BLACK);
		jButton_Cancel.setFont(new Font("Arial", Font.PLAIN, 16));
		jButton_Cancel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		jButton_Cancel.setBackground(new Color(230, 230, 250));
		jButton_Cancel.setBounds(163, 349, 88, 38);
		panel_1.add(jButton_Cancel);
		
		
	}
}
