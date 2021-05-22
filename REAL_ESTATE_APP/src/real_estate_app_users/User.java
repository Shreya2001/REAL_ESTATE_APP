package real_estate_app_users;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import real_estate_app.Main_Menu;
import real_estate_app.THE_CONNECTION;

public class User {
	
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private long number;
	private int age;
	private String gender;
	private String usertype;
	private String fullname;
	
	public User() {
		this.username="";
		this.password="";
		this.firstname="";
		this.lastname="";
		this.number=0;
		this.age=0;
		this.gender="";
		this.usertype="";
		this.fullname="";
	}
	
	public User(String username, String password, String firstname, String lastname, 
			long number, int age, String gender, String usertype) {
		this.username=username;
		this.password=password;
		this.firstname=firstname;
		this.lastname=lastname;
		this.number=number;
		this.age=age;
		this.gender=gender;
		this.usertype=usertype;
		this.fullname=firstname.concat(" ").concat(lastname);
	}
	
	public void SetData(String username) {
		try {
			String sql="SELECT * FROM `users` WHERE `username`='"+username+"'";

            PreparedStatement statement=THE_CONNECTION.getConnection().prepareStatement(sql);
            ResultSet result=statement.executeQuery();
            if(result.next()) {
               	String s1=result.getString(2);
               	String s2=result.getString(3);
               	String s3=result.getString(4);
               	String s4=result.getString(5);
               	String s5=result.getString(8);
               	String s6=result.getString(9);
               	int i1 = Integer.valueOf(result.getString(7));
               	long l1=Long.valueOf(result.getString(6));
               	
               	this.username=s1;
        		this.password=s2;
        		this.firstname=s3;
        		this.lastname=s4;
        		this.number=l1;
        		this.age=i1;
        		this.gender=s5;
        		this.usertype=s6;
        		this.fullname=s3.concat(" ").concat(s4);
            }
		}catch(SQLException ex){
				ex.printStackTrace();
			}
	}
	
	public void UserLogin(String username, String password, Login lg) {
		try {
			PreparedStatement ps;
			ResultSet rs;
			
			String selectuery="SELECT * FROM `users` WHERE `username` = ? AND password = ?";
			
			ps = THE_CONNECTION.getConnection().prepareStatement(selectuery);
			ps.setString(1, username);
			ps.setString(2, password);
			
			rs=ps.executeQuery();
			
			if(rs.next()) {
				Main_Menu mainform = new Main_Menu(username);
				mainform.setVisible(true);
				mainform.pack();
											
				mainform.setBounds(100, 100, 770, 482);
				mainform.setLocationRelativeTo(null);
				//close login
				lg.dispose();
				
			}
			else {
				JOptionPane.showMessageDialog(null, "Invalid Username or Password","Wrong Data",2);
				
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
	}
	
	public void UpdateData(String first, String last, long mob, int age_no) {
		this.firstname=first;
		this.lastname=last;
		this.fullname=first.concat(" ").concat(last);
		this.number=mob;
		this.age=age_no;
	}
	
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public long getNumber() {
		return number;
	}
	
	public void setNumber(long number) {
		this.number = number;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getUserType() {
		return usertype;
	}
	
	public void setUserType(String usertype) {
		this.usertype = usertype;
	}
	
	public String getFullName() {
		return fullname;
	}
	
	public void setFullName(String fullname) {
		this.fullname = firstname.concat(" ").concat(lastname);
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", firstname=" + firstname + ", lastname="
				+ lastname + ", number=" + number + ", age=" + age + ", gender=" + gender + ", usertype=" + usertype
				+ "]";
	}
	
	
}
