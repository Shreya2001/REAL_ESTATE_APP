package packers_and_movers;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;

import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class packersMoversWindow {

	public JFrame frame;
	private packersInfo pkMv;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					packersMoversWindow window = new packersMoversWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void close() {
		WindowEvent closeWindow = new WindowEvent(frame, WindowEvent.WINDOW_CLOSING);
		java.awt.Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
	}

	/**
	 * Create the application.
	 */
	public packersMoversWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("PropertyWare - Property Management System");
		Image icon = Toolkit.getDefaultToolkit().getImage("D:/Eclipse%20Workspace/REAL_ESTATE_APP/src/images/icon.png");
		frame.setIconImage(icon);
		frame.setBounds(380, 120, 770, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.menu);
		panel.setBounds(0, 0, 756, 563);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PACKERS AND MOVERS");
		lblNewLabel.setBounds(173, 11, 424, 51);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(0, 139, 139));
		lblNewLabel.setFont(new Font("Lucida Sans", Font.BOLD, 33));
		lblNewLabel.setAlignmentX(0.5f);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabeltext = new JLabel("Select the Source and Destination and Obtain Transport Charges");
		lblNewLabeltext.setForeground(new Color(0, 141, 139));
		lblNewLabeltext.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 15));
		lblNewLabeltext.setBounds(141, 49, 554, 29);
		panel.add(lblNewLabeltext);
		
		final JComboBox FromLocation = new JComboBox();
		FromLocation.setFont(new Font("Arial", Font.PLAIN, 14));
		FromLocation.setBackground(new Color(255, 255, 255));
		FromLocation.setBounds(213, 95, 131, 26);
		panel.add(FromLocation);
		
		FromLocation.addItem("Kanyakumari");
		FromLocation.addItem("Chennai");
		FromLocation.addItem("Goa");
		FromLocation.addItem("Pune");
		FromLocation.addItem("Mumbai");
		FromLocation.addItem("Ahmedabad");
		FromLocation.addItem("Delhi");
		FromLocation.addItem("WestBengal");
		FromLocation.setSelectedItem("Select a City");
		
		final JComboBox ToLocation = new JComboBox();
		ToLocation.setFont(new Font("Arial", Font.PLAIN, 14));
		ToLocation.setBackground(Color.WHITE);
		ToLocation.setBounds(431, 95, 131, 26);
		panel.add(ToLocation);
		
		ToLocation.setSelectedItem("Select a City");
		ToLocation.addItem("Kanyakumari");
		ToLocation.addItem("Chennai");
		ToLocation.addItem("Goa");
		ToLocation.addItem("Pune");
		ToLocation.addItem("Mumbai");
		ToLocation.addItem("Ahmedabad");
		ToLocation.addItem("Delhi");
		ToLocation.addItem("WestBengal");
		
		
		
		JLabel lblNewLabel_1 = new JLabel("1. AGENCY");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(103, 251, 98, 22);
		panel.add(lblNewLabel_1);
		
		JButton Close = new JButton("CLOSE");
		Close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		Close.setBackground(new Color(0, 102, 102));
		Close.setForeground(new Color(255, 255, 255));
		Close.setBounds(222, 140, 131, 32);
		Close.setFont(new Font("Arial", Font.PLAIN, 14));
		Close.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		Close.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Close.setBounds(379, 140, 122, 32);
		panel.add(Close);
		
		
		
		
		JLabel lblNewLabel_1_1 = new JLabel("AGENT");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_1.setBounds(141, 279, 98, 22);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("CONTACT");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_1_1.setBounds(368, 279, 98, 22);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("CHARGE");
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_2.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1_1_2.setBackground(Color.WHITE);
		lblNewLabel_1_1_2.setBounds(141, 307, 98, 22);
		panel.add(lblNewLabel_1_1_2);
		
		
		
		
		
		JLabel lblNewLabel_1_2 = new JLabel("2. AGENCY");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1_2.setBackground(Color.WHITE);
		lblNewLabel_1_2.setBounds(103, 353, 98, 22);
		panel.add(lblNewLabel_1_2);
		
		
		
		JLabel lblNewLabel_1_1_7 = new JLabel("AGENT");
		lblNewLabel_1_1_7.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_7.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1_1_7.setBackground(Color.WHITE);
		lblNewLabel_1_1_7.setBounds(141, 381, 98, 22);
		panel.add(lblNewLabel_1_1_7);
		
		
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("CONTACT");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_1_1_1.setBounds(368, 381, 98, 22);
		panel.add(lblNewLabel_1_1_1_1);
		
		
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("CHARGE");
		lblNewLabel_1_1_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_2_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1_1_2_1.setBackground(Color.WHITE);
		lblNewLabel_1_1_2_1.setBounds(141, 409, 98, 22);
		panel.add(lblNewLabel_1_1_2_1);
		
		
		
		JLabel lblNewLabel_1_3 = new JLabel("3. AGENCY");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_3.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1_3.setBackground(Color.WHITE);
		lblNewLabel_1_3.setBounds(103, 454, 98, 22);
		panel.add(lblNewLabel_1_3);
		
		
		
		JLabel lblNewLabel_1_1_8 = new JLabel("AGENT");
		lblNewLabel_1_1_8.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_8.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1_1_8.setBackground(Color.WHITE);
		lblNewLabel_1_1_8.setBounds(141, 482, 98, 22);
		panel.add(lblNewLabel_1_1_8);
		
		
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("CONTACT");
		lblNewLabel_1_1_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_2.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1_1_1_2.setBackground(Color.WHITE);
		lblNewLabel_1_1_1_2.setBounds(368, 482, 98, 22);
		panel.add(lblNewLabel_1_1_1_2);
		
		
		
		JLabel lblNewLabel_1_1_2_2 = new JLabel("CHARGE");
		lblNewLabel_1_1_2_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_2_2.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1_1_2_2.setBackground(Color.WHITE);
		lblNewLabel_1_1_2_2.setBounds(141, 510, 98, 22);
		panel.add(lblNewLabel_1_1_2_2);
		
		
		
		JLabel lblNewLabel_1_4 = new JLabel("DISTANCE ESTIMATED");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_4.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1_4.setBackground(Color.WHITE);
		lblNewLabel_1_4.setBounds(195, 198, 181, 26);
		panel.add(lblNewLabel_1_4);
		
		
		
		pkMv = new packersInfo();
		pkMv.declareAgencies();
		
		JLabel distance = new JLabel();
		distance.setOpaque(true);
		distance.setHorizontalAlignment(SwingConstants.CENTER);
		distance.setFont(new Font("Arial", Font.BOLD, 14));
		distance.setBackground(Color.WHITE);
		distance.setBounds(386, 198, 122, 26);
		panel.add(distance);
		distance.setText("");
		
		String agency_1 = pkMv.getA1().getAgency();
		JLabel Agency1 = new JLabel(agency_1);
		Agency1.setOpaque(true);
		Agency1.setHorizontalAlignment(SwingConstants.CENTER);
		Agency1.setFont(new Font("Arial", Font.PLAIN, 14));
		Agency1.setBackground(Color.WHITE);
		Agency1.setBounds(211, 251, 142, 22);
		panel.add(Agency1);
		
		String agent_1 = pkMv.getA1().getAgent();
		JLabel Agent1 = new JLabel(agent_1);
		Agent1.setOpaque(true);
		Agent1.setHorizontalAlignment(SwingConstants.CENTER);
		Agent1.setFont(new Font("Arial", Font.PLAIN, 14));
		Agent1.setBackground(Color.WHITE);
		Agent1.setBounds(247, 279, 119, 22);
		panel.add(Agent1);
		
		
		JLabel Charge1 = new JLabel();
		Charge1.setOpaque(true);
		Charge1.setHorizontalAlignment(SwingConstants.CENTER);
		Charge1.setFont(new Font("Arial", Font.PLAIN, 14));
		Charge1.setBackground(Color.WHITE);
		Charge1.setBounds(247, 307, 119, 22);
		panel.add(Charge1);
		Charge1.setText("");
		
		Long cLong1 = pkMv.getA1().getContact();
		String contaString1 = Long.toString(cLong1);
		JLabel Contact1 = new JLabel(contaString1);
		Contact1.setOpaque(true);
		Contact1.setHorizontalAlignment(SwingConstants.CENTER);
		Contact1.setFont(new Font("Arial", Font.PLAIN, 14));
		Contact1.setBackground(Color.WHITE);
		Contact1.setBounds(473, 279, 131, 22);
		panel.add(Contact1);
		
		String agency_2 = pkMv.getA2().getAgency();
		JLabel Agency2 = new JLabel(agency_2);
		Agency2.setOpaque(true);
		Agency2.setHorizontalAlignment(SwingConstants.CENTER);
		Agency2.setFont(new Font("Arial", Font.PLAIN, 14));
		Agency2.setBackground(Color.WHITE);
		Agency2.setBounds(211, 353, 142, 22);
		panel.add(Agency2);
		
		String agent_2 = pkMv.getA2().getAgent();
		JLabel Agent2 = new JLabel(agent_2);
		Agent2.setOpaque(true);
		Agent2.setHorizontalAlignment(SwingConstants.CENTER);
		Agent2.setFont(new Font("Arial", Font.PLAIN, 14));
		Agent2.setBackground(Color.WHITE);
		Agent2.setBounds(247, 381, 119, 22);
		panel.add(Agent2);
		
		Long cLong = pkMv.getA2().getContact();
		String contaString2 = Long.toString(cLong);
		JLabel Contact2 = new JLabel(contaString2);
		Contact2.setOpaque(true);
		Contact2.setHorizontalAlignment(SwingConstants.CENTER);
		Contact2.setFont(new Font("Arial", Font.PLAIN, 14));
		Contact2.setBackground(Color.WHITE);
		Contact2.setBounds(473, 381, 131, 22);
		panel.add(Contact2);
		
		
		JLabel Charge2 = new JLabel();
		Charge2.setOpaque(true);
		Charge2.setHorizontalAlignment(SwingConstants.CENTER);
		Charge2.setFont(new Font("Arial", Font.PLAIN, 14));
		Charge2.setBackground(Color.WHITE);
		Charge2.setBounds(247, 409, 119, 22);
		panel.add(Charge2);
		Charge2.setText("");
		
		String agency_3 = pkMv.getA3().getAgency();
		JLabel Agency3 = new JLabel(agency_3);
		Agency3.setOpaque(true);
		Agency3.setHorizontalAlignment(SwingConstants.CENTER);
		Agency3.setFont(new Font("Arial", Font.PLAIN, 14));
		Agency3.setBackground(Color.WHITE);
		Agency3.setBounds(211, 454, 165, 22);
		panel.add(Agency3);
		
		String agent_3 = pkMv.getA3().getAgent();
		JLabel Agent3 = new JLabel(agent_3);
		Agent3.setOpaque(true);
		Agent3.setHorizontalAlignment(SwingConstants.CENTER);
		Agent3.setFont(new Font("Arial", Font.PLAIN, 14));
		Agent3.setBackground(Color.WHITE);
		Agent3.setBounds(247, 482, 119, 22);
		panel.add(Agent3);
		
		Long cLong3 = pkMv.getA3().getContact();
		String contaString3 = Long.toString(cLong3);
		JLabel Contact3 = new JLabel(contaString3);
		Contact3.setOpaque(true);
		Contact3.setHorizontalAlignment(SwingConstants.CENTER);
		Contact3.setFont(new Font("Arial", Font.PLAIN, 14));
		Contact3.setBackground(Color.WHITE);
		Contact3.setBounds(473, 482, 131, 22);
		panel.add(Contact3);
		
		
		JLabel Charge3 = new JLabel();
		Charge3.setOpaque(true);
		Charge3.setHorizontalAlignment(SwingConstants.CENTER);
		Charge3.setFont(new Font("Arial", Font.PLAIN, 14));
		Charge3.setBackground(Color.WHITE);
		Charge3.setBounds(247, 510, 119, 22);
		panel.add(Charge3);
		Charge3.setText("");
		
		JButton Compute = new JButton("COMPUTE");
		Compute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String fL = FromLocation.getSelectedItem().toString();
				String tL = ToLocation.getSelectedItem().toString();
				String fLocation = fL.toLowerCase();
				String tLocation = tL.toLowerCase();
				
				packersInfo pkMv1 = new packersInfo(fLocation,tLocation);
				long d = pkMv1.getD().getDistance();
				String dString = Long.toString(d);
				
				int ch1 = pkMv1.getCharge1();
				String ch1String = Integer.toString(ch1);
				int ch2 = pkMv1.getCharge2();
				String ch2String = Integer.toString(ch2);
				int ch3 = pkMv1.getCharge3();
				String ch3String = Integer.toString(ch3);
				
				distance.setText(dString);
				Charge1.setText(ch1String);
				Charge2.setText(ch2String);
				Charge3.setText(ch3String);
			}
		});
		
		Compute.setBackground(new Color(0, 102, 102));
		Compute.setForeground(new Color(255, 255, 255));
		Compute.setBounds(222, 140, 131, 32);
		Compute.setFont(new Font("Arial", Font.PLAIN, 14));
		Compute.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		Compute.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.add(Compute);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("TO:");
		lblNewLabel_1_4_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_4_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1_4_1.setBackground(Color.WHITE);
		lblNewLabel_1_4_1.setBounds(103, 95, 98, 26);
		panel.add(lblNewLabel_1_4_1);
		
		JLabel lblNewLabel_1_4_1_1 = new JLabel("FROM:");
		lblNewLabel_1_4_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_4_1_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1_4_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_4_1_1.setBounds(323, 95, 98, 26);
		panel.add(lblNewLabel_1_4_1_1);
		
	}

}
