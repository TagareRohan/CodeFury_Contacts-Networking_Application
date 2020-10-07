package com.training.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import com.training.ifaces.UserDAO;
import com.training.models.Contact;
import com.training.models.Person;
import com.training.models.User;
import com.training.utils.ConnectionUtility;

public class UserServiceImpl implements UserDAO {

	ArrayList<User> userList;
	private Connection derbyConnection;
	
	public UserServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
		userList=new ArrayList<>();
		this.derbyConnection = ConnectionUtility.getDerbyConnection();
		
	}

	@Override
	public boolean addUser(User user)
	{
		String sql = "insert into users(fullName,email,phoneNumber,gender,dateOfBirth,address,"
						+ "city,state,country,company,image,username,password) "
						+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		PreparedStatement pstmt = null;
		InputStream fin=null;
		try {
			fin = new FileInputStream("profile.png");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int rowUpdated = 0;
		
		try {
			pstmt = this.derbyConnection.prepareStatement(sql);
			
			//pstmt.setInt(1,0);
			pstmt.setString(1, user.getFullName());
			pstmt.setString(2, user.getEmail());
			pstmt.setLong(3, user.getPhoneNumber());
			pstmt.setString(4, user.getGender());
			pstmt.setDate(5, Date.valueOf(user.getDateOfBirth()));
			pstmt.setString(6, user.getAddress());
			pstmt.setString(7, user.getCity());
			pstmt.setString(8, user.getState());
			pstmt.setString(9, user.getCountry());
			pstmt.setString(10, user.getCompany());
			pstmt.setBlob(11,fin);
			pstmt.setString(12, user.getUsername());
			pstmt.setString(13, user.getPassword());
			//pstmt.setInt(14, user.getDeactivated());
			//pstmt.setInt(15, user.getDisabled());
			rowUpdated = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
		}
		
		return rowUpdated==1 ? true:false;
	}

	@Override
	public User findUser(String userName) {
		// TODO Auto-generated method stub
		String sql = "select * from users where username=?";
		
		PreparedStatement pstmt = null;
		
		User user = null;
		
		try {
			pstmt = this.derbyConnection.prepareStatement(sql);
			
			pstmt.setString(1, userName);
			ResultSet result = pstmt.executeQuery();
			//System.out.println(result);
			result.next();
			
			long id=(long)result.getInt("id");
			String fullName = result.getString("fullName");
			String email=result.getString("email");
			long phoneNumber=result.getLong("phoneNumber");
			String gender=result.getString("gender");
			LocalDate dateOfBirth=result.getDate("dateOfBirth").toLocalDate();
			String address=result.getString("address");
			String city=result.getString("city");
			String state=result.getString("state");
			String country=result.getString("country");
			String company=result.getString("company");
			Blob image=result.getBlob("image");
			String username=result.getString("username");
			
			byte barr[]=image.getBytes(1,(int)image.length());//1 means first image
			
			user=new User(fullName, email, phoneNumber, gender, dateOfBirth, 
					address, city, state, country, company, barr, username,id);
			
			return user;
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
		}
		return user;
	}

	@Override
	public boolean addContact(Contact contact) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TreeSet<Contact> viewContacts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TreeSet<Person> viewFriends() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<User> searchUsers() {
		// TODO Auto-generated method stub
		String sql = "select * from users";
		
		PreparedStatement pstmt = null;
		
		try {
			
			pstmt = this.derbyConnection.prepareStatement(sql);
			
			ResultSet result = pstmt.executeQuery();
			
			ResultSetMetaData metaData = result.getMetaData();
			
			int columnCount = metaData.getColumnCount();
			
			for(int i = 1; i<=columnCount; i++) {
				System.out.println("========= Columm:="+metaData.getColumnName(i));
			}
			
			DatabaseMetaData dbInfo = this.derbyConnection.getMetaData();
			
			System.out.println("Drvier Name:="+dbInfo.getDriverName());
			System.out.println("Product Version:="+dbInfo.getDatabaseProductVersion());
			
			while(result.next()) {
			
				long id=(long)result.getInt("id");
				String fullName = result.getString("fullName");
				String email=result.getString("email");
				long phoneNumber=result.getLong("phoneNumber");
				String gender=result.getString("gender");
				LocalDate dateOfBirth=result.getDate("dateOfBirth").toLocalDate();
				String address=result.getString("address");
				String city=result.getString("city");
				String state=result.getString("state");
				String country=result.getString("country");
				String company=result.getString("company");
				Blob image=result.getBlob("image");
				String username=result.getString("username");
				
				
				byte barr[]=image.getBytes(1,(int)image.length());//1 means first image  
	              
				//FileOutputStream fout=new FileOutputStream("D:\\HSBC\\CodeFury\\CodeFury_Contacts-Networking_Application\\Contacts_Networking_Application\\sonoo.jpg");  
				//fout.write(barr);  
				              
				//fout.close();  
				
				User user=new User(fullName, email, phoneNumber, gender, dateOfBirth, 
									address, city, state, country, company, barr, username,id);
				
				
				this.userList.add(user);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.userList;
	}

	@Override
	public TreeSet<Person> viewBlockedUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean sendRequest(long userId1, long userId2) {
		// TODO Auto-generated method stub
		String sql = "insert into relationship "
				+ "values(?,?,?,?)";

		PreparedStatement pstmt = null;
		
	
		int rowUpdated = 0;

		try {
			pstmt = this.derbyConnection.prepareStatement(sql);
	
			//pstmt.setInt(1,0);
			
			
			pstmt.setInt(1, (int)userId1);
			pstmt.setInt(2, (int)userId2);
			pstmt.setInt(3, 0);
			pstmt.setInt(4, (int)userId1);
			rowUpdated = pstmt.executeUpdate();
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
	
		}

		return rowUpdated==1 ? true:false;
		
	}

	@Override
	public boolean acceptRequest(long userId1, long userId2) {
		// TODO Auto-generated method stub
		String sql = "update relationship set status=?, actionId=? where userId1=? and userId2=?";

		PreparedStatement pstmt = null;
		int rowUpdated = 0;

		try {
			pstmt = this.derbyConnection.prepareStatement(sql);
	
			//pstmt.setInt(1,0);
			
			pstmt.setInt(1, 1);
			pstmt.setInt(2, (int)userId2);
			pstmt.setInt(3, (int)userId1);
			pstmt.setInt(4, (int)userId2);
			
			
			rowUpdated = pstmt.executeUpdate();
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
	
		}

		return rowUpdated==1 ? true:false;
	}

	@Override
	public boolean declineRequest(long userId1, long userId2) {
		// TODO Auto-generated method stub
		String sql = "update relationship set status=?, actionId=? where userId1=? and userId2=?";

		PreparedStatement pstmt = null;
		int rowUpdated = 0;

		try {
			pstmt = this.derbyConnection.prepareStatement(sql);
	
			//pstmt.setInt(1,0);
			
			pstmt.setInt(1, 2);
			pstmt.setInt(2, (int)userId2);
			pstmt.setInt(3, (int)userId1);
			pstmt.setInt(4, (int)userId2);
			
			
			rowUpdated = pstmt.executeUpdate();
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
	
		}

		return rowUpdated==1 ? true:false;
		
	}

	@Override
	public boolean blockUser(long userId1, long userId2) {
		// TODO Auto-generated method stub
		String sql = "update relationship set status=?, actionId=? where userId1=? and userId2=?";

		PreparedStatement pstmt = null;
		int rowUpdated = 0;

		try {
			pstmt = this.derbyConnection.prepareStatement(sql);
	
			//pstmt.setInt(1,0);
			
			pstmt.setInt(1, 3);
			pstmt.setInt(2, (int)userId2);
			pstmt.setInt(3, (int)userId1);
			pstmt.setInt(4, (int)userId2);
			
			
			rowUpdated = pstmt.executeUpdate();
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
	
		}

		return rowUpdated==1 ? true:false;
		
	}
}
