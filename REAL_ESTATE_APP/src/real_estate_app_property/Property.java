package real_estate_app_property;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import real_estate_app.THE_CONNECTION;

import java.sql.SQLException;

public class Property {
	
	private int pId=0;
	private String pRooms;
	private String pBathrooms;
	private String pArea;
	private String pBalconies;
	private String pDeposit;
	private String pCost;
	private String pUsername;
	private String pType;
	private String pFurnishedStatus;
	private String pListing;
	private String pAddress;
	private String pDescription;
	
	
	
	public Property () {
		this.pUsername="";
		this.pType="";
		this.pFurnishedStatus="";
		this.pListing="";
		this.pAddress="";
		this.pDescription="";
		this.pRooms="";
		this.pBathrooms="";
		this.pBalconies="";
		this.pDeposit="";
		this.pCost="";
	}
	
	
	public Property(String pType, String pFurnishedStatus, String pListing, 
			String pAddress, String pDescription, String pRooms, String pBathrooms, 
			String pBalconies, String pArea, String pDeposit, String pCost, String usern) {
		
		this.pUsername=usern;
		this.pType=pType;
		this.pFurnishedStatus=pFurnishedStatus;
		this.pListing=pListing;
		this.pAddress=pAddress;
		this.pDescription=pDescription;
		this.pRooms=pRooms;
		this.pBathrooms=pBathrooms;
		this.pBalconies=pBalconies;
		this.pArea=pArea;
		this.pDeposit=pDeposit;
		this.pCost=pCost;
	}
	
	
	public void addToDatabase() {
		
		String jdbcURL = "jdbc:mysql://localhost:3306/java_rst_db";
		String dbUsername = "root";
		String dbPassword = "2708";
		
		try {
			
			Connection connection = DriverManager.getConnection(jdbcURL,dbUsername,dbPassword);
			
			String sql = "INSERT INTO property_list (username, pType, pFurnish, pListing, pAddress,"
					+ " pDescription, pRooms, pBathrooms, pBalconies, pArea, pDeposit, pCost)"
					+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, pUsername);
			statement.setString(2, pType);
			statement.setString(3, pFurnishedStatus);
			statement.setString(4, pListing);
			statement.setString(5, pAddress);
			statement.setString(6, pDescription);
			statement.setString(7, pRooms);
			statement.setString(8, pBathrooms);
			statement.setString(9, pBalconies);
			statement.setString(10, pArea);
			statement.setString(11, pDeposit);
			statement.setString(12, pCost);
			
			int rows = statement.executeUpdate();
			
			if( rows > 0 ) {
				System.out.println("Property Added Successfully to the Database.");
			}
			
				
			connection.close();
			
		} catch ( SQLException e ) {
			e.printStackTrace();
		}
		
	}

	
public int retrieveFromDatabase( int propertyID ) {
		
		Statement statement;
		ResultSet rs;
		try {
			String queryString = "SELECT * FROM property_list WHERE id=" + propertyID ;
			statement = THE_CONNECTION.getConnection().createStatement();
			rs = statement.executeQuery(queryString);
			while( rs.next() ) {
				pId = propertyID;
				pRooms = rs.getString("pRooms");
				pBathrooms = rs.getString("pBathrooms");
				pArea = rs.getString("pArea");
				pBalconies = rs.getString("pBalconies");
				pCost = rs.getString("pCost");
				pDeposit = rs.getString("pDeposit");
				pFurnishedStatus = rs.getString("pFurnish");
				pAddress = rs.getString("pAddress");
				pDescription = rs.getString("pDescription");
				pUsername = rs.getString("username");
				pType = rs.getString("pType");
				pListing = rs.getString("pListing");
			}
			THE_CONNECTION.getConnection().close();
			return 1;
			
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		return -1;
}


	
	
	public int getpId() {
		return pId;
	}


	public String getpRooms() {
		return pRooms;
	}


	public String getpBathrooms() {
		return pBathrooms;
	}


	public String getpArea() {
		return pArea;
	}


	public String getpBalconies() {
		return pBalconies;
	}


	public String getpDeposit() {
		return pDeposit;
	}


	public String getpCost() {
		return pCost;
	}


	public String getpUsername() {
		return pUsername;
	}


	public String getpType() {
		return pType;
	}


	public String getpFurnishedStatus() {
		return pFurnishedStatus;
	}


	public String getpListing() {
		return pListing;
	}


	public String getpAddress() {
		return pAddress;
	}


	public String getpDescription() {
		return pDescription;
	}


	public void setpId(int pId) {
		this.pId = pId;
	}


	public void setpRooms(String pRooms) {
		this.pRooms = pRooms;
	}


	public void setpBathrooms(String pBathrooms) {
		this.pBathrooms = pBathrooms;
	}


	public void setpArea(String pArea) {
		this.pArea = pArea;
	}


	public void setpBalconies(String pBalconies) {
		this.pBalconies = pBalconies;
	}


	public void setpDeposit(String pDeposit) {
		this.pDeposit = pDeposit;
	}


	public void setpCost(String pCost) {
		this.pCost = pCost;
	}


	public void setpUsername(String pUsername) {
		this.pUsername = pUsername;
	}


	public void setpType(String pType) {
		this.pType = pType;
	}


	public void setpFurnishedStatus(String pFurnishedStatus) {
		this.pFurnishedStatus = pFurnishedStatus;
	}


	public void setpListing(String pListing) {
		this.pListing = pListing;
	}


	public void setpAddress(String pAddress) {
		this.pAddress = pAddress;
	}


	public void setpDescription(String pDescription) {
		this.pDescription = pDescription;
	}


	

}
