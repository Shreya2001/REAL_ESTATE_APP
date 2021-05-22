package real_estate_app_property;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import real_estate_app.Main_Menu;
import real_estate_app.THE_CONNECTION;
import real_estate_app_users.User;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class viewProperty extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	DefaultTableModel model;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private static String uname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewProperty frame = new viewProperty(uname);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public String getQuery(String uname) {
		User user = new User();
		user.SetData(uname);
		String Query="";
		
		if(user.getUserType().toString().equalsIgnoreCase("seller")) {
			Query="SELECT id, pType, pListing, pAddress, pCost FROM property_list WHERE username='"+uname+"'";
		}
		else if(user.getUserType().toString().equalsIgnoreCase("buyer")){
			Query="SELECT id, pType, pListing, pAddress, pCost FROM property_list";
		}
		return Query;
	}
	
	
	/**
	 * Create the frame.
	 */
	public viewProperty(String s) {
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
		
		
		JLabel lblNewLabel = new JLabel("VIEW PROPERTY");
		lblNewLabel.setBounds(199, 11, 342, 51);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(0, 139, 139));
		lblNewLabel.setFont(new Font("Lucida Sans", Font.BOLD, 33));
		lblNewLabel.setAlignmentX(0.5f);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("Click on the Property you wish to View");
		lblNewLabel_3.setForeground(new Color(0, 141, 139));
		lblNewLabel_3.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(214, 48, 332, 29);
		panel.add(lblNewLabel_3);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(72, 120, 610, 206);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setFont(new Font("Arial", Font.PLAIN, 14));
		table.setBackground(new Color(240, 248, 255));
		model = new DefaultTableModel() {
				@Override
			    public boolean isCellEditable(int row, int column) {
		       //all cells are un-editable
		       return false;
		    }
		};
		Object[] column = {"Property ID","Type","Listing","Address","Rent / Cost"};
		final Object[] row = new Object[5];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		
		table.getColumnModel().getColumn(0).setPreferredWidth(5);
		table.getColumnModel().getColumn(1).setPreferredWidth(25);
		table.getColumnModel().getColumn(2).setPreferredWidth(30);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(40);
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		table.setDefaultRenderer(String.class, centerRenderer);
		
		Statement statement;
		ResultSet rs;
		try {
			String queryString = getQuery(s);
			statement = THE_CONNECTION.getConnection().createStatement();
			rs = statement.executeQuery(queryString);
			while( rs.next() ) {
				
				int userId = rs.getInt("id");
				String type = rs.getString("pType");
				String listing = rs.getString("pListing");
				String address = rs.getString("pAddress");
				String cost = rs.getString("pCost");
				
				row[0] = userId;
				row[1] = type;
				row[2] = listing;
				row[3] = address;
				row[4] = cost;
				model.addRow(row);
				
				
			}
			THE_CONNECTION.getConnection().close();
			
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
	
		btnNewButton = new JButton("VIEW");
		btnNewButton.addActionListener(new ActionListener() {
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
		btnNewButton.setBounds(263, 370, 115, 36);
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNewButton.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBackground(new Color(230, 230, 250));
		panel.add(btnNewButton);
		
		btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main_Menu mainform = new Main_Menu(s);
				mainform.setVisible(true);
				mainform.pack();
				mainform.setBounds(100, 100, 770, 482);
				mainform.setLocationRelativeTo(null);
				//close login
				dispose();
			}
		});
		btnNewButton_1.setBounds(419, 370, 115, 36);
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNewButton_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setBackground(new Color(230, 230, 250));
		panel.add(btnNewButton_1);
	
	}

}
