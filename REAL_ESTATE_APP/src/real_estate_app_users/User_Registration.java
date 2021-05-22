package real_estate_app_users;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import real_estate_app.Home_Screen;
import real_estate_app.THE_CONNECTION;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

public class User_Registration extends JFrame {

	private JPanel contentPane;
	private JTextField user_name;
	private JTextField first_name;
	private JTextField last_name;
	private JTextField contact_num;
	private JTextField age_num;
	private JPasswordField pwd;

	
	/**
	 * Create a Function to verify any empty fields
	 */
	public boolean verifyFields() {
		String uname = user_name.getText();
		String fname = first_name.getText();
		String lname = last_name.getText();
		String phnum = contact_num.getText();
		String ageno = age_num.getText();
		String passd = String.valueOf(pwd.getPassword());
		
		if(uname.trim().equals("")||fname.trim().equals("") ||
				lname.trim().equals("") ||phnum.trim().equals("")||
				ageno.trim().equals("") || passd.trim().equals("")) {
			JOptionPane.showMessageDialog(null, "One or More Fields Are Empty!","Empty Fields",2);
			return false;
		}
		
		else {
			return true;
		}
	}
	
	/**
	 * Create a function to check if username already exists in database
	 */
	public boolean checkUsername(String username) {
		PreparedStatement st;
		ResultSet rs;
		boolean username_exist=false;
		
		String query ="SELECT * FROM `users` WHERE `username` = ?";
		
		try {
			st=THE_CONNECTION.getConnection().prepareStatement(query);
			st.setString(1, username);
			rs=st.executeQuery();
			
			if(rs.next()) {
				username_exist=true;
				JOptionPane.showMessageDialog(null, "This Username is Already Take, Choose Another","Username Failed", 2);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return username_exist;
	}
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User_Registration frame = new User_Registration();
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
	public User_Registration() {
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
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("USER REGISTRATION");
		lblNewLabel.setForeground(new Color(51, 51, 102));
		lblNewLabel.setHorizontalTextPosition(JLabel.CENTER);
		lblNewLabel.setAlignmentY(Component.TOP_ALIGNMENT);
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel.setFont(new Font("Lucida Sans", Font.BOLD, 28));
		lblNewLabel.setBounds(222, 11, 306, 58);
		
		panel.add(lblNewLabel);
		
		Border title_border = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(51, 51, 102));
		lblNewLabel.setBorder(title_border);
		
		JLabel label_1 = new JLabel("Username");
		label_1.setFont(new Font("Arial", Font.PLAIN, 14));
		label_1.setBounds(55, 138, 78, 19);
		panel.add(label_1);
		
		user_name = new JTextField();
		user_name.setFont(new Font("Courier New", Font.PLAIN, 14));
		user_name.setBounds(135, 134, 145, 27);
		panel.add(user_name);
		user_name.setColumns(10);
		
		JLabel label_2 = new JLabel("First Name");
		label_2.setFont(new Font("Arial", Font.PLAIN, 14));
		label_2.setBounds(55, 188, 78, 19);
		panel.add(label_2);
		
		first_name = new JTextField();
		first_name.setFont(new Font("Courier New", Font.PLAIN, 14));
		first_name.setColumns(10);
		first_name.setBounds(135, 184, 145, 27);
		panel.add(first_name);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Arial", Font.PLAIN, 14));
		lblLastName.setBounds(55, 238, 78, 19);
		panel.add(lblLastName);
		
		last_name = new JTextField();
		last_name.setFont(new Font("Courier New", Font.PLAIN, 14));
		last_name.setColumns(10);
		last_name.setBounds(135, 234, 145, 27);
		panel.add(last_name);
		
		JLabel lblLastName_1 = new JLabel("Contact No.");
		lblLastName_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblLastName_1.setBounds(55, 288, 78, 19);
		panel.add(lblLastName_1);
		
		JLabel show_valid = new JLabel("");
		show_valid.setFont(new Font("Tahoma", Font.PLAIN, 9));
		show_valid.setForeground(Color.RED);
		show_valid.setBounds(133, 311, 93, 9);
		panel.add(show_valid);
		
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
		contact_num.setBounds(135, 284, 145, 27);
		panel.add(contact_num);
		
		JLabel lblLastName_2 = new JLabel("Age");
		lblLastName_2.setFont(new Font("Arial", Font.PLAIN, 14));
		lblLastName_2.setBounds(446, 138, 32, 19);
		panel.add(lblLastName_2);
		
		JLabel show_valid1 = new JLabel("");
		show_valid1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		show_valid1.setForeground(Color.RED);
		show_valid1.setBounds(488, 153, 93, 19);
		panel.add(show_valid1);
		
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
		age_num.setBounds(488, 130, 145, 27);
		panel.add(age_num);
		
		JLabel gender_choice = new JLabel("Gender");
		gender_choice.setFont(new Font("Arial", Font.PLAIN, 14));
		gender_choice.setBounds(427, 189, 78, 19);
		panel.add(gender_choice);
		
		JRadioButton gen_male = new JRadioButton("Male");
		gen_male.setFont(new Font("Arial", Font.PLAIN, 14));
		gen_male.setBounds(494, 188, 67, 23);
		panel.add(gen_male);
		
		JRadioButton gen_female = new JRadioButton("Female");
		gen_female.setFont(new Font("Arial", Font.PLAIN, 14));
		gen_female.setBounds(561, 188, 78, 23);
		panel.add(gen_female);
		
		JRadioButton gen_other = new JRadioButton("Others");
		gen_other.setFont(new Font("Arial", Font.PLAIN, 14));
		gen_other.setBounds(643, 188, 78, 23);
		panel.add(gen_other);
		
		JLabel add_in_1 = new JLabel("User Type");
		add_in_1.setFont(new Font("Arial", Font.PLAIN, 14));
		add_in_1.setBounds(408, 240, 78, 19);
		panel.add(add_in_1);
		
		pwd = new JPasswordField();
		pwd.setBounds(489, 283, 153, 27);
		pwd.setFont(new Font("Courier New", Font.PLAIN, 14));
		panel.add(pwd);
		
		
		JComboBox occupation = new JComboBox();
		occupation.setFont(new Font("Courier New", Font.PLAIN, 14));
		occupation.setModel(new DefaultComboBoxModel(new String[] {"Buyer", "Seller"}));
		occupation.setBounds(489, 239, 131, 22);
		panel.add(occupation);
		
		JButton register_btn = new JButton("REGISTER");
		register_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String uname = user_name.getText();
				String fname = first_name.getText();
				String lname = last_name.getText();
				String phnum = contact_num.getText();
				String ageno = age_num.getText();
				String passd = String.valueOf(pwd.getPassword());
				String gender = "Male";
				String occup = occupation.getSelectedItem().toString();
				if(gen_female.isSelected()) {
					gender = "Female";
				}
				else if(gen_other.isSelected()) {
					gender = "Others";
				}
							
				
				if(verifyFields()) {
					if(!checkUsername(uname)) {
						PreparedStatement ps;
						ResultSet rs;
						String registerUserQuery="INSERT INTO `users` (`username`,`password`,`fname`,`lname`,`number`,`age`,`gender`,`usertype`) VALUES (?,?,?,?,?,?,?,?)";
						
						try {
							ps = THE_CONNECTION.getConnection().prepareStatement(registerUserQuery);
							ps.setString(1, uname);
							ps.setString(2, passd);
							ps.setString(3, fname);
							ps.setString(4, lname);
							ps.setString(5, phnum);
							ps.setString(6, ageno);
							ps.setString(7, gender);
							ps.setString(8, occup);
							
							if(ps.executeUpdate()!=0) {
								JOptionPane.showMessageDialog(null, "Your Account has been Created!");
							}
							else {
								JOptionPane.showMessageDialog(null, "Error: Check Your Information");
							}						
							
							Login login = new Login();
							login.setVisible(true);
							login.pack();
							login.setBounds(100, 100, 770, 482);
							login.setLocationRelativeTo(null);
							//close registeration
							dispose();						
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
	
						
					}
				}
			}
		});
		register_btn.setFont(new Font("Arial", Font.PLAIN, 14));
		register_btn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		register_btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		register_btn.setBackground(new Color(230, 230, 250));
		register_btn.setBounds(235, 358, 119, 37);
		panel.add(register_btn);
		
		JLabel password = new JLabel("Password");
		password.setFont(new Font("Arial", Font.PLAIN, 14));
		password.setBounds(414, 288, 62, 19);
		panel.add(password);
		
		JButton cancel_btn = new JButton("CANCEL");
		cancel_btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cancel_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home_Screen start_up = new Home_Screen();
				start_up.setVisible(true);
				start_up.pack();
				start_up.setBounds(100, 100, 770, 482);
				start_up.setLocationRelativeTo(null);
				//close registeration
				dispose();
			}
		});
		cancel_btn.setFont(new Font("Arial", Font.PLAIN, 14));
		cancel_btn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		cancel_btn.setBackground(new Color(230, 230, 250));
		cancel_btn.setBounds(375, 358, 119, 37);
		panel.add(cancel_btn);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Your Personal Details In the Empty Spaces");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(232, 80, 282, 14);
		panel.add(lblNewLabel_1);
		
		
		
		
	}
}
