package real_estate_app;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import real_estate_app_users.Login;
import real_estate_app_users.User_Registration;

import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;

public class Home_Screen extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home_Screen frame = new Home_Screen();
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
	public Home_Screen() {
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
		panel_1.setBorder(new CompoundBorder());
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
		
		JLabel lblNewLabel_1 = new JLabel("WELCOME !");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 21));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(47, 135, 140, 38);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_1);
		
		Border title_border = BorderFactory.createMatteBorder(0, 0, 2, 0, Color.YELLOW);
		lblNewLabel_1.setBorder(title_border);
		

		jLabel_Image.setIcon(new ImageIcon(Login.class.getResource("/images/building.png")));
		jLabel_Image.setVerticalAlignment(SwingConstants.BOTTOM);
		
		JLabel lblNewLabel_3 = new JLabel("Property Management Software");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(99, 74, 241, 29);
		panel_1.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Register as New User");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User_Registration reg_win = new User_Registration();
				reg_win.setVisible(true);
				reg_win.pack();
				reg_win.setBounds(100, 100, 770, 482);
				reg_win.setLocationRelativeTo(null);
				//close startup
				dispose();				
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBackground(new Color(230, 230, 250));
		btnNewButton.setBounds(134, 215, 181, 38);
		panel_1.add(btnNewButton);
		
		JButton btnLogIn = new JButton("Log In\r\n");
		btnLogIn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login = new Login();
				login.setVisible(true);
				login.pack();
				login.setBounds(100, 100, 770, 482);
				login.setLocationRelativeTo(null);
				//close startup
				dispose();
			}
		});
		btnLogIn.setFont(new Font("Arial", Font.BOLD, 16));
		btnLogIn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLogIn.setBackground(new Color(230, 230, 250));
		btnLogIn.setBounds(134, 289, 181, 38);
		panel_1.add(btnLogIn);
		
		
		
	}
}
