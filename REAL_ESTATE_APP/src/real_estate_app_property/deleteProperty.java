package real_estate_app_property;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JPanel;
import javax.swing.Icon;
import javax.swing.JTable;
import java.awt.Component;
import java.awt.Cursor;

import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;
import real_estate_app.Main_Menu;
import real_estate_app.THE_CONNECTION;

import java.awt.Color;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.UIManager;
public class deleteProperty {

	public JFrame frame;
	private Property P;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnNewButton;
	private JButton btnCancel;
	DefaultTableModel model;
	private static String user;
	//public void addRows();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					deleteProperty window = new deleteProperty(user);
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
	public deleteProperty(String s) {
		initialize(s);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String s) {
		frame = new JFrame();
		frame.setTitle("PropertyWare - Property Management System");
		Image icon = Toolkit.getDefaultToolkit().getImage("D:/Eclipse%20Workspace/REAL_ESTATE_APP/src/images/icon.png");
		frame.setIconImage(icon);
		frame.setFont(new Font("Arial", Font.PLAIN, 14));
		frame.setTitle("DELETE PROPERTY DIALOG BOX");
		frame.setBounds(380, 120, 770, 482);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setForeground(new Color(220, 220, 220));
		panel.setBackground(new Color(176, 196, 222));
		panel.setBounds(0, 0, 756, 445);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("DELETE PROPERTY");
		lblNewLabel.setBounds(204, 11, 342, 51);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(51, 0, 102));
		lblNewLabel.setFont(new Font("Lucida Sans", Font.BOLD, 33));
		lblNewLabel.setAlignmentX(0.5f);
		panel.add(lblNewLabel);
		
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
			String queryString = "SELECT id, pType, pListing, pAddress, pCost FROM property_list WHERE username='"+s+"'";
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
		
		JLabel lblNewLabel_1 = new JLabel("SELECT THE PROPERTY THAT IS TO BE DELETED");
		lblNewLabel_1.setForeground(new Color(51, 0, 102));
		lblNewLabel_1.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 17));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(167, 52, 411, 29);
		panel.add(lblNewLabel_1);
		
			
		
		
		btnNewButton = new JButton("DELETE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				Statement statement;
				//ResultSet rs;
				try {
					int i = table.getSelectedRow();
					Object pId = table.getValueAt(i, 0);
					String pId1 = pId.toString();
					String queryString = "DELETE FROM property_list WHERE id='" + pId1 + "'";
					statement = THE_CONNECTION.getConnection().createStatement();
					statement.executeUpdate(queryString);
					//rs = statement.executeQuery(queryString);
					THE_CONNECTION.getConnection().close();
					
					model.removeRow(i);
					JOptionPane.showMessageDialog(null, "Property Successfully Deleted!");
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			
			}
			
		});
		btnNewButton.setFont(new Font("Lucida Sans", Font.BOLD, 16));
		btnNewButton.setBounds(217, 367, 115, 36);
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNewButton.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBackground(new Color(230, 230, 250));
		panel.add(btnNewButton);
		
		btnCancel = new JButton("BACK");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main_Menu mainform = new Main_Menu(s);
				mainform.setVisible(true);
				mainform.pack();
				mainform.setBounds(100, 100, 770, 482);
				mainform.setLocationRelativeTo(null);
				//close login
				frame.dispose();
			}
		});
		btnCancel.setFont(new Font("Lucida Sans", Font.BOLD, 16));
		btnCancel.setBounds(404, 367, 115, 36);
		btnCancel.setFont(new Font("Arial", Font.PLAIN, 14));
		btnCancel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancel.setBackground(new Color(230, 230, 250));
		panel.add(btnCancel);
	}

}
