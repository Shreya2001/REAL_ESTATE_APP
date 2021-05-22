package real_estate_app_property;
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
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;
import real_estate_app.THE_CONNECTION;

import java.sql.*;
import javax.swing.JScrollPane;

public class searchProperty extends JFrame {

	private JPanel contentPane;
	private JTextField propRoom;
	private JTextField propBath;
	private JTable table=new JTable();
	private JComboBox propType;
	private JComboBox propCondition;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					searchProperty frame = new searchProperty();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public boolean verifyFields() {
		String bath = propBath.getText();
		String room = propRoom.getText();
				
		if(bath.trim().equals("")||room.trim().equals("")) {
			JOptionPane.showMessageDialog(null, "One or More Fields Are Empty!","Empty Fields",2);
			return false;
		}
		
		else {
			return true;
		}
	}
	
	public boolean verifyValidity(String type,String furn, String room_no, String bath_no) {
		Statement st;
		ResultSet rs;
		boolean validity=false;
		
		String searchQuery = "SELECT * FROM property_list WHERE pType = '"+type+"' AND pFurnish = '"+furn+"' AND pRooms = '"+room_no+"' AND pBathrooms = '"+bath_no+"'";
		
		try {
			Connection con=THE_CONNECTION.getConnection();
			
			st=con.createStatement();
			rs=st.executeQuery(searchQuery);
				if(!rs.next()) {
					JOptionPane.showMessageDialog(null, "Such Property Does Not Exist!","Non-Existent Record",2);
					return validity=true;
				}
			}catch(SQLException ex) {
				ex.printStackTrace();
				}
		
		return validity=false;
	}
	
	public ArrayList<Property> ListProperty(String type, String furn, String room_no, String bath_no){
		ArrayList<Property> propertiesList = new ArrayList<Property>();
		
		Statement st;
		ResultSet rs;
		
		try {
			Connection con=THE_CONNECTION.getConnection();
			
			String searchQuery = "SELECT * FROM property_list WHERE pType = '"+type+"' AND pFurnish = '"+furn+"' AND pRooms = '"+room_no+"' AND pBathrooms = '"+bath_no+"'";
			st=con.createStatement();
			rs=st.executeQuery(searchQuery);
			
			Property property=new Property();
			
			while(rs.next()) {
				property = new Property(
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7),
						rs.getString(8),
						rs.getString(9),
						rs.getString(10),
						rs.getString(11),
						rs.getString(12),
						rs.getString(12),
						rs.getString(2));
						
				int i=Integer.parseInt(rs.getString(1));
				property.setpId(i);
				propertiesList.add(property);
			}
			
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		
		return propertiesList;
	}
	
	
	
	public void findProperties() {
		ArrayList<Property> properties = ListProperty(propType.getSelectedItem().toString(), propCondition.getSelectedItem().toString(), propRoom.getText(), propBath.getText());
		
		DefaultTableModel dtm = new DefaultTableModel() {
			@Override
			    public boolean isCellEditable(int row, int column) {
		       //all cells are un-editable
		       return false;
		    }
		};
		dtm.setColumnIdentifiers(new Object [] {"ID","Type","Furnishing","Address","Rooms","Bathrooms","Cost","Seller"});
		
		
		Object[] row=new Object[8];
		
		for(int i=0; i<properties.size(); i++) {
			row[0]=properties.get(i).getpId();
			row[1]=properties.get(i).getpType();
			row[2]=properties.get(i).getpFurnishedStatus();
			row[3]=properties.get(i).getpAddress();
			row[4]=properties.get(i).getpRooms();
			row[5]=properties.get(i).getpBathrooms();
			row[6]=properties.get(i).getpCost();
			row[7]=properties.get(i).getpUsername();
			dtm.addRow(row);
		}
		
		
		table.setModel(dtm);
		//layout settings
		table.getColumnModel().getColumn(0).setPreferredWidth(1);
		table.getColumnModel().getColumn(1).setPreferredWidth(55);
		table.getColumnModel().getColumn(2).setPreferredWidth(85);
		table.getColumnModel().getColumn(3).setPreferredWidth(150);
		table.getColumnModel().getColumn(4).setPreferredWidth(40);
		table.getColumnModel().getColumn(5).setPreferredWidth(51);
		table.getColumnModel().getColumn(6).setPreferredWidth(37);
		table.getColumnModel().getColumn(7).setPreferredWidth(48);
		
	}
	
	/**
	 * Create the frame.
	 */
	public searchProperty() {
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
		
		
		JLabel lblNewLabel = new JLabel("SEARCH PROPERTY");
		lblNewLabel.setBounds(214, 11, 342, 51);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(0, 139, 139));
		lblNewLabel.setFont(new Font("Lucida Sans", Font.BOLD, 33));
		lblNewLabel.setAlignmentX(0.5f);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("PropertyWare - Property Management Software");
		lblNewLabel_3.setForeground(new Color(0, 141, 139));
		lblNewLabel_3.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(191, 46, 411, 29);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1 = new JLabel("Filters");
		lblNewLabel_1.setFont(new Font("Lucida Sans", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(56, 102, 62, 29);
		panel.add(lblNewLabel_1);
		
		Border title_border = BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK);
		lblNewLabel_1.setBorder(title_border);
		
		JLabel lblNewLabel_2 = new JLabel("Property Type");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_2.setBounds(94, 142, 90, 16);
		panel.add(lblNewLabel_2);
		
		propType = new JComboBox();
		propType.setFont(new Font("Courier New", Font.PLAIN, 12));
		propType.setModel(new DefaultComboBoxModel(new String[] {"Flat", "House / Villa", "Shop / Showroom", "Office Space"}));
		propType.setBounds(194, 140, 148, 22);
		panel.add(propType);
		
		JLabel lblNewLabel_2_1 = new JLabel("Condition");
		lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_2_1.setBounds(408, 142, 90, 16);
		panel.add(lblNewLabel_2_1);
		
		propCondition = new JComboBox();
		propCondition.setModel(new DefaultComboBoxModel(new String[] {"Non - Furnished", "Semi - Furnished", "Fully - Furnished"}));
		propCondition.setFont(new Font("Courier New", Font.PLAIN, 12));
		propCondition.setBounds(490, 140, 148, 22);
		panel.add(propCondition);
		
		JLabel lblNewLabel_2_2 = new JLabel("Rooms");
		lblNewLabel_2_2.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_2_2.setBounds(152, 184, 90, 16);
		panel.add(lblNewLabel_2_2);
		
		propRoom = new JTextField();
		propRoom.setBounds(209, 182, 96, 20);
		panel.add(propRoom);
		propRoom.setColumns(10);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Bathrooms");
		lblNewLabel_2_2_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_2_2_1.setBounds(346, 184, 90, 16);
		panel.add(lblNewLabel_2_2_1);
		
		propBath = new JTextField();
		propBath.setColumns(10);
		propBath.setBounds(423, 182, 96, 20);
		panel.add(propBath);
		
		JButton btnView = new JButton("VIEW");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				Object pId = table.getValueAt(i, 0);
				String s = pId.toString();
				Integer pId2 = Integer.parseInt(s); 
				showProperty prop = new showProperty(pId2);
				prop.frame.setVisible(true);
				prop.frame.pack();
				prop.frame.setBounds(350, 60, 770, 480);
				prop.frame.setLocationRelativeTo(null);	
			}
		});
		btnView.setFont(new Font("Arial", Font.PLAIN, 14));
		btnView.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnView.setBackground(new Color(230, 230, 250));
		btnView.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnView.setBounds(256, 388, 115, 36);
		panel.add(btnView);
		btnView.setVisible(false);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(56, 238, 633, 127);
		panel.add(scrollPane);
		
		
		scrollPane.setViewportView(table);
		
		JButton propButton = new JButton("SEARCH");
		propButton.setFont(new Font("Arial", Font.PLAIN, 14));
		propButton.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		propButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		propButton.setBackground(new Color(230, 230, 250));
		propButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(verifyFields()) {
					if(!verifyValidity(propType.getSelectedItem().toString(), propCondition.getSelectedItem().toString(), 
							propRoom.getText(), propBath.getText())){
							findProperties();
							btnView.setVisible(true);
					}
				}
			}
		});
		propButton.setBounds(549, 173, 89, 29);
		panel.add(propButton);
				
		JButton btnNewButton = new JButton("CLOSE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//close search
				dispose();
			}
		});
		btnNewButton.setBounds(423, 388, 115, 36);
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNewButton.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBackground(new Color(230, 230, 250));
		panel.add(btnNewButton);
		
		
	}
}
