package real_estate_app;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import real_estate_app_property.Property;

	
public class Test {
	
		public static void main (String[] args) {
			
			System.out.println("Hello, World");
			ArrayList<Property> p=ListProperty("House / Villa", "Semi - Furnished", "2", "2");
			
			System.out.print(p.size());
			System.out.print(p.get(1).getpListing());
		}

public static ArrayList<Property> ListProperty(String type, String furn, String room_no, String bath_no){
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
					
			propertiesList.add(property);
		}
		
	}catch(Exception ex){
		System.out.println(ex.getMessage());
	}
	
	return propertiesList;
}
}




