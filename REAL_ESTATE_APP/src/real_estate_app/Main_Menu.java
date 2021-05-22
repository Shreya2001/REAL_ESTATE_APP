package real_estate_app;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import packers_and_movers.packersMoversWindow;
import real_estate_app_property.deleteProperty;
import real_estate_app_property.propertyWindow;
import real_estate_app_property.searchProperty;
import real_estate_app_property.viewProperty;
import real_estate_app_users.User;
import real_estate_app_users.userProfile;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Main_Menu extends JFrame {

	private JPanel contentPane;
	private static String user_name;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_Menu frame = new Main_Menu(user_name);
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
	public Main_Menu(String str) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("PropertyWare - Property Management System");
		Image icon = Toolkit.getDefaultToolkit().getImage("D:/Eclipse%20Workspace/REAL_ESTATE_APP/src/images/icon.png");
		setIconImage(icon);
		setBounds(100, 100, 770, 482);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		
		this.setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
				
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("PROPERTYWARE");
		lblNewLabel.setBounds(255, 11, 284, 51);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(0, 139, 139));
		lblNewLabel.setFont(new Font("Lucida Sans", Font.BOLD, 33));
		lblNewLabel.setAlignmentX(0.5f);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("Property Management Software");
		lblNewLabel_3.setForeground(new Color(0, 141, 139));
		lblNewLabel_3.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(265, 46, 261, 29);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1 = new JLabel("Welcome");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 17));
		lblNewLabel_1.setBounds(76, 103, 85, 29);
		panel.add(lblNewLabel_1);
		
		User user = new User();
		user.SetData(str);
				
		JLabel label_name = new JLabel(user.getFullName()+" !");
		label_name.setFont(new Font("Arial", Font.BOLD, 17));
		label_name.setBounds(159, 103, 295, 29);
		panel.add(label_name);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setDividerSize(0);
		splitPane.setBorder(null);
		splitPane.setResizeWeight(0.5);
		splitPane.setBackground(new Color(0,0,0,0));
		splitPane.setBounds(10, 150, 726, 274);
		panel.add(splitPane);
		
		JPanel panel_1 = new JPanel();
				
		panel_1.setBackground(new Color(0, 0, 0, 0));
		splitPane.setLeftComponent(panel_1);
		
		JButton btnNewButton = new JButton("Search Item");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchProperty search = new searchProperty();
				search.setVisible(true);
				search.pack();
				search.setBounds(100, 100, 770, 482);
				search.setLocationRelativeTo(null);				
			}
		});
		JButtonFormat(btnNewButton);
		btnNewButton.setLocation(270, 30);
		btnNewButton.setSize(97,85);
		
		JButton btnNewButton_2 = new JButton("View Property");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewProperty view = new viewProperty(user.getUsername());
				view.setVisible(true);
				view.pack();		
				view.setBounds(100, 100, 770, 482);
				view.setLocationRelativeTo(null);
				//close menu
				dispose();
			}
		});
		JButtonFormat(btnNewButton_2);
		btnNewButton_2.setLocation(400, 30);
		btnNewButton_2.setSize(97,85);
		
		JButton btnNewButton_3 = new JButton("My Profile");
		btnNewButton_3.addActionListener(new ActionListener() {
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
		JButtonFormat(btnNewButton_3);
		btnNewButton_3.setLocation(270, 138);
		btnNewButton_3.setSize(97, 85);
		panel_1.setLayout(null);
		panel_1.add(btnNewButton_2);
		panel_1.add(btnNewButton);
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Services");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				packersMoversWindow transport = new packersMoversWindow();
				transport.frame.setVisible(true);
				transport.frame.pack();
				transport.frame.setBounds(350, 60, 770, 600);
				transport.frame.setLocationRelativeTo(null);				
			}
		});
		JButtonFormat(btnNewButton_4);
		btnNewButton_4.setBounds(400, 138, 97, 85);
		panel_1.add(btnNewButton_4);
		if(user.getUserType().equalsIgnoreCase("seller")) {
			panel_1.setVisible(false);
		}
		
		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel_2.setBackground(new Color(0,0,0,0));
		splitPane.setRightComponent(panel_2);
		if(user.getUserType().equalsIgnoreCase("buyer")) {
			panel_2.setVisible(false);
		}
		
		JButton btnNewButton_5 = new JButton("List Property");
		btnNewButton_5.setBounds(270,30,97,85);
		JButtonFormat(btnNewButton_5);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				propertyWindow prop = new propertyWindow(user.getUsername());
				prop.frame.setVisible(true);
				prop.frame.pack();
				prop.frame.setBounds(350, 60, 770, 630);
				prop.frame.setLocationRelativeTo(null);
				//close main-menu
				dispose();
				
				/*Home_Screen home=new Home_Screen();
				home.setVisible(true);
				home.pack();
				dispose();*/
			}
		});
		panel_2.setLayout(null);
		panel_2.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("View Property");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewProperty view = new viewProperty(user.getUsername());
				view.setVisible(true);
				view.pack();		
				view.setBounds(100, 100, 770, 482);
				view.setLocationRelativeTo(null);
				//close menu
				dispose();
			}
		});
		JButtonFormat(btnNewButton_6);
		btnNewButton_6.setBounds(400,30,97,85);
		panel_2.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Remove Item");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteProperty prop = new deleteProperty(user.getUsername());
				prop.frame.setVisible(true);
				prop.frame.pack();
				prop.frame.setBounds(350, 60, 770, 482);
				prop.frame.setLocationRelativeTo(null);
				//close main-menu
				dispose();
			}
		});
		
		JButtonFormat(btnNewButton_7);
		btnNewButton_7.setBounds(270,138,97,85);
		panel_2.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("My Profile");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userProfile profile = new userProfile(user);
				profile.setVisible(true);
				profile.pack();
				profile.setBounds(100, 100, 770, 482);
				profile.setLocationRelativeTo(null);
				//close login
				dispose();
			}
		});
		JButtonFormat(btnNewButton_8);
		btnNewButton_8.setBounds(400,138,97,85);
		panel_2.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("Log Out");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Thank you for using PropertyWare!");
				//close main menu
				dispose();
			}
		});
		JButtonFormat(btnNewButton_9);
		btnNewButton_9.setBounds(625,48,97,29);
		panel.add(btnNewButton_9);
		
		JLabel back_label = new JLabel("");
		back_label.setBounds(0, 0,746,435);
		panel.add(back_label);
		back_label.setIcon(new ImageIcon(Main_Menu.class.getResource("/images/back.jpg")));
		
		
			
	}
}
