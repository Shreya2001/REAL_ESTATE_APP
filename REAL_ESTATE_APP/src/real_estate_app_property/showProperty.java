package real_estate_app_property;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import real_estate_app_users.User;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class showProperty {

		public JFrame frame;
		private Property P;
		private static int pID;

		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						showProperty window = new showProperty(pID);
						window.frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

		/**
		 * Create the application.
		 */
		public showProperty(int pId) {
			initialize(pId);
		}

		/**
		 * Initialize the contents of the frame.
		 */
		private void initialize(int pId) {
			frame = new JFrame();
			frame.setTitle("PropertyWare - Property Management System");
			Image icon = Toolkit.getDefaultToolkit().getImage("D:/Eclipse%20Workspace/REAL_ESTATE_APP/src/images/icon.png");
			frame.setIconImage(icon);
			frame.setBounds(380, 120, 770, 482);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			JPanel panel = new JPanel();
			panel.setFont(new Font("Arial", Font.PLAIN, 14));
			panel.setBounds(0, 0, 756, 445);
			frame.getContentPane().add(panel);
			panel.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("PROPERTY DETAILS");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setForeground(new Color(0, 139, 139));
			lblNewLabel.setFont(new Font("Lucida Sans", Font.BOLD, 33));
			lblNewLabel.setAlignmentX(0.5f);
			lblNewLabel.setBounds(211, 23, 348, 32);
			panel.add(lblNewLabel);
			
			
			//String id = Integer.toString(P.getID());
			JLabel lblNewLabel_1 = new JLabel("PROPERTY ID");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 15));
			lblNewLabel_1.setBounds(65, 78, 119, 32);
			panel.add(lblNewLabel_1);
			
			JLabel lblNewLabel_1_1 = new JLabel("SELLER");
			lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 15));
			lblNewLabel_1_1.setBounds(65, 343, 119, 32);
			panel.add(lblNewLabel_1_1);
			
			JLabel lblNewLabel_1_1_1 = new JLabel("PROPERTY TYPE");
			lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_1_1_1.setFont(new Font("Arial", Font.BOLD, 15));
			lblNewLabel_1_1_1.setBounds(55, 116, 129, 32);
			panel.add(lblNewLabel_1_1_1);
			
			JLabel lblNewLabel_1_1_1_1 = new JLabel("LISTING");
			lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 15));
			lblNewLabel_1_1_1_1.setBounds(65, 153, 119, 32);
			panel.add(lblNewLabel_1_1_1_1);
			
			JLabel lblNewLabel_1_1_1_1_1 = new JLabel("FURNISHED STATUS");
			lblNewLabel_1_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_1_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 15));
			lblNewLabel_1_1_1_1_1.setBounds(10, 196, 174, 32);
			panel.add(lblNewLabel_1_1_1_1_1);
			
			JLabel lblNewLabel_1_1_1_2 = new JLabel("ADDRESS ");
			lblNewLabel_1_1_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_1_1_1_2.setFont(new Font("Arial", Font.BOLD, 15));
			lblNewLabel_1_1_1_2.setBounds(65, 288, 119, 32);
			panel.add(lblNewLabel_1_1_1_2);
			
			JLabel lblNewLabel_1_1_1_2_1 = new JLabel("DESCRIPTION");
			lblNewLabel_1_1_1_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_1_1_1_2_1.setFont(new Font("Arial", Font.BOLD, 15));
			lblNewLabel_1_1_1_2_1.setBounds(65, 233, 119, 32);
			panel.add(lblNewLabel_1_1_1_2_1);
			
			P = new Property();
			P.retrieveFromDatabase(pId);	//I have used the Property ID here.
			
			User seller = new User();
			seller.SetData(P.getpUsername());
			
			
			//String idString = Integer.toString(P.getID());
			JLabel propID = new JLabel(Integer.toString(P.getpId()));
			propID.setOpaque(true);
			propID.setHorizontalTextPosition(SwingConstants.CENTER);
			propID.setHorizontalAlignment(SwingConstants.CENTER);
			propID.setBackground(new Color(255, 255, 255));
			propID.setFont(new Font("Arial", Font.PLAIN, 13));
			propID.setBounds(194, 83, 95, 26);
			panel.add(propID);
			
			
			JLabel propUsername = new JLabel(seller.getFullName());
			propUsername.setOpaque(true);
			propUsername.setHorizontalTextPosition(SwingConstants.CENTER);
			propUsername.setHorizontalAlignment(SwingConstants.CENTER);
			propUsername.setFont(new Font("Arial", Font.PLAIN, 14));
			propUsername.setBackground(Color.WHITE);
			propUsername.setBounds(194, 348, 154, 26);
			panel.add(propUsername);
			
			JLabel propType = new JLabel(P.getpType());
			propType.setOpaque(true);
			propType.setHorizontalTextPosition(SwingConstants.CENTER);
			propType.setHorizontalAlignment(SwingConstants.CENTER);
			propType.setFont(new Font("Arial", Font.PLAIN, 14));
			propType.setBackground(Color.WHITE);
			propType.setBounds(194, 119, 95, 26);
			panel.add(propType);
			
			JLabel propListing = new JLabel(P.getpListing());
			propListing.setOpaque(true);
			propListing.setHorizontalTextPosition(SwingConstants.CENTER);
			propListing.setHorizontalAlignment(SwingConstants.CENTER);
			propListing.setFont(new Font("Arial", Font.PLAIN, 14));
			propListing.setBackground(Color.WHITE);
			propListing.setBounds(194, 158, 95, 26);
			panel.add(propListing);
			
			JLabel lblNewLabel_1_3 = new JLabel("No. of Rooms");
			lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_1_3.setFont(new Font("Arial", Font.BOLD, 15));
			lblNewLabel_1_3.setBounds(440, 78, 119, 32);
			panel.add(lblNewLabel_1_3);
			
			JLabel propRooms = new JLabel(P.getpRooms());
			propRooms.setOpaque(true);
			propRooms.setHorizontalTextPosition(SwingConstants.CENTER);
			propRooms.setHorizontalAlignment(SwingConstants.CENTER);
			propRooms.setFont(new Font("Arial", Font.PLAIN, 14));
			propRooms.setBackground(Color.WHITE);
			propRooms.setBounds(569, 83, 95, 26);
			panel.add(propRooms);
			
			JLabel lblNewLabel_1_1_2 = new JLabel("No. of Bathrooms");
			lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_1_1_2.setFont(new Font("Arial", Font.BOLD, 15));
			lblNewLabel_1_1_2.setBounds(421, 113, 138, 32);
			panel.add(lblNewLabel_1_1_2);
			
			JLabel propBathrooms = new JLabel(P.getpBathrooms());
			propBathrooms.setOpaque(true);
			propBathrooms.setHorizontalTextPosition(SwingConstants.CENTER);
			propBathrooms.setHorizontalAlignment(SwingConstants.CENTER);
			propBathrooms.setFont(new Font("Arial", Font.PLAIN, 14));
			propBathrooms.setBackground(Color.WHITE);
			propBathrooms.setBounds(569, 118, 95, 26);
			panel.add(propBathrooms);
			
			JLabel lblNewLabel_1_1_1_3 = new JLabel("No. of Balconies");
			lblNewLabel_1_1_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_1_1_1_3.setFont(new Font("Arial", Font.BOLD, 15));
			lblNewLabel_1_1_1_3.setBounds(421, 153, 138, 32);
			panel.add(lblNewLabel_1_1_1_3);
			
			JLabel propBalconies = new JLabel(P.getpBalconies());
			propBalconies.setOpaque(true);
			propBalconies.setHorizontalTextPosition(SwingConstants.CENTER);
			propBalconies.setHorizontalAlignment(SwingConstants.CENTER);
			propBalconies.setFont(new Font("Arial", Font.PLAIN, 14));
			propBalconies.setBackground(Color.WHITE);
			propBalconies.setBounds(569, 156, 95, 26);
			panel.add(propBalconies);
			
			JLabel lblNewLabel_1_1_1_1_2 = new JLabel("AREA( in sqft )");
			lblNewLabel_1_1_1_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_1_1_1_1_2.setFont(new Font("Arial", Font.BOLD, 15));
			lblNewLabel_1_1_1_1_2.setBounds(440, 190, 119, 32);
			panel.add(lblNewLabel_1_1_1_1_2);
			
			JLabel propArea = new JLabel(P.getpArea());
			propArea.setOpaque(true);
			propArea.setHorizontalTextPosition(SwingConstants.CENTER);
			propArea.setHorizontalAlignment(SwingConstants.CENTER);
			propArea.setFont(new Font("Arial", Font.PLAIN, 14));
			propArea.setBackground(Color.WHITE);
			propArea.setBounds(569, 195, 95, 26);
			panel.add(propArea);
			
			JLabel propFurnish = new JLabel(P.getpFurnishedStatus());
			propFurnish.setOpaque(true);
			propFurnish.setHorizontalTextPosition(SwingConstants.CENTER);
			propFurnish.setHorizontalAlignment(SwingConstants.CENTER);
			propFurnish.setFont(new Font("Arial", Font.PLAIN, 14));
			propFurnish.setBackground(Color.WHITE);
			propFurnish.setBounds(194, 196, 139, 26);
			panel.add(propFurnish);
			
			JLabel lblNewLabel_1_1_1_3_1 = new JLabel("DEPOSIT ");
			lblNewLabel_1_1_1_3_1.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_1_1_1_3_1.setFont(new Font("Arial", Font.BOLD, 15));
			lblNewLabel_1_1_1_3_1.setBounds(440, 233, 119, 32);
			panel.add(lblNewLabel_1_1_1_3_1);
			
			JLabel lblNewLabel_1_1_1_1_2_1 = new JLabel("COST  ");
			lblNewLabel_1_1_1_1_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_1_1_1_1_2_1.setFont(new Font("Arial", Font.BOLD, 15));
			lblNewLabel_1_1_1_1_2_1.setBounds(440, 270, 119, 32);
			panel.add(lblNewLabel_1_1_1_1_2_1);
			
			JLabel propDeposit = new JLabel(P.getpDeposit());
			propDeposit.setOpaque(true);
			propDeposit.setHorizontalTextPosition(SwingConstants.CENTER);
			propDeposit.setHorizontalAlignment(SwingConstants.CENTER);
			propDeposit.setFont(new Font("Arial", Font.PLAIN, 14));
			propDeposit.setBackground(Color.WHITE);
			propDeposit.setBounds(569, 236, 95, 26);
			panel.add(propDeposit);
			
			JLabel propCost = new JLabel(P.getpCost());
			propCost.setOpaque(true);
			propCost.setHorizontalTextPosition(SwingConstants.CENTER);
			propCost.setHorizontalAlignment(SwingConstants.CENTER);
			propCost.setFont(new Font("Arial", Font.PLAIN, 14));
			propCost.setBackground(Color.WHITE);
			propCost.setBounds(569, 276, 95, 26);
			panel.add(propCost);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(194, 290, 210, 40);
			panel.add(scrollPane);
			
			JLabel propAddress = new JLabel(P.getpAddress());
			scrollPane.setViewportView(propAddress);
			propAddress.setBackground(new Color(255, 255, 255));
			propAddress.setOpaque(true);
			propAddress.setFont(new Font("Arial", Font.PLAIN, 14));
			
			JScrollPane scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(194, 237, 210, 38);
			panel.add(scrollPane_1);
			
			
			JLabel propDescription = new JLabel(P.getpDescription());
			scrollPane_1.setViewportView(propDescription);
			propDescription.setHorizontalAlignment(SwingConstants.LEFT);
			propDescription.setOpaque(true);
			propDescription.setHorizontalTextPosition(SwingConstants.CENTER);
			propDescription.setFont(new Font("Arial", Font.PLAIN, 14));
			propDescription.setBackground(Color.WHITE);
			
			JLabel lblNewLabel_1_1_3 = new JLabel("CONTACT");
			lblNewLabel_1_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_1_1_3.setFont(new Font("Arial", Font.BOLD, 15));
			lblNewLabel_1_1_3.setBounds(440, 343, 119, 32);
			panel.add(lblNewLabel_1_1_3);
			
			JLabel propUsername_1 = new JLabel(String.valueOf(seller.getNumber()));
			propUsername_1.setOpaque(true);
			propUsername_1.setHorizontalTextPosition(SwingConstants.CENTER);
			propUsername_1.setHorizontalAlignment(SwingConstants.CENTER);
			propUsername_1.setFont(new Font("Arial", Font.PLAIN, 14));
			propUsername_1.setBackground(Color.WHITE);
			propUsername_1.setBounds(569, 348, 154, 26);
			panel.add(propUsername_1);
			
			JButton btnNewButton = new JButton("CLOSE");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
				}
			});
			btnNewButton.setBounds(335, 397, 119, 37);
			btnNewButton.setFont(new Font("Arial", Font.PLAIN, 14));
			btnNewButton.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
			btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnNewButton.setBackground(new Color(230, 230, 250));
			panel.add(btnNewButton);
		}
	}

