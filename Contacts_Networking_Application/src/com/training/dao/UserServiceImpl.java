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
import java.util.Set;
import java.util.TreeSet;

import com.training.ifaces.UserDAO;
import com.training.models.Contact;
import com.training.models.Person;
import com.training.models.User;
import com.training.utils.ConnectionUtility;
import com.training.utils.NameComparator;

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
		String sql = "select * from users where username=? or email=?";
		
		PreparedStatement pstmt = null;
		
		User user = null;
		
		try {
			pstmt = this.derbyConnection.prepareStatement(sql);
			
			pstmt.setString(1, userName);
			pstmt.setString(2, userName);
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
		String sql = "insert into contacts(userid,fullName,email,phoneNumber,gender,dateOfBirth,address,"
				+ "city,state,country,company,image) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?)";

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
			
			pstmt.setInt(1, (int)contact.getUserId());
			pstmt.setString(2, contact.getFullName());
			pstmt.setString(3, contact.getEmail());
			pstmt.setLong(4, contact.getPhoneNumber());
			pstmt.setString(5, contact.getGender());
			pstmt.setDate(6, Date.valueOf(contact.getDateOfBirth()));
			pstmt.setString(7, contact.getAddress());
			pstmt.setString(8, contact.getCity());
			pstmt.setString(9, contact.getState());
			pstmt.setString(10, contact.getCountry());
			pstmt.setString(11, contact.getCompany());
			pstmt.setBlob(12,fin);
			
			rowUpdated = pstmt.executeUpdate();
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
	
		}

		return rowUpdated==1 ? true:false;
	
	}

	@Override
	public TreeSet<Contact> viewContacts(User user) {
		// TODO Auto-generated method stub
		TreeSet<Contact> contacts=new TreeSet<>(new NameComparator());
		String sql = "select * from contacts where userid=?";
		
		PreparedStatement pstmt = null;
		
		try {
			
			pstmt = this.derbyConnection.prepareStatement(sql);
			pstmt.setInt(1, (int)user.getId());
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
			
				long id=(long)result.getInt("userid");
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
				
				
				byte barr[]=image.getBytes(1,(int)image.length());//1 means first image  
	              
				//FileOutputStream fout=new FileOutputStream("D:\\HSBC\\CodeFury\\CodeFury_Contacts-Networking_Application\\Contacts_Networking_Application\\sonoo.jpg");  
				//fout.write(barr);  
				              
				//fout.close();  
				
				Contact contact=new Contact(id,fullName, email, phoneNumber, gender, dateOfBirth, 
									address, city, state, country, company, barr);
				
			
				System.out.println(contacts.add(contact));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return contacts;
	}

	@Override
	public Set<User> viewFriends(long userId) {
		// TODO Auto-generated method stub
		String sql = " select * from users where username in( SELECT users.username from users inner join "
				+ "relationship on (users.id=relationship.userid1) where userid2=? and relationship.status=1 union  "
				+ "SELECT users.username from users inner join relationship on (users.id=relationship.userid2) "
				+ "where userid1=? and relationship.status=1 )";
		Set<User> sortedFriends=new TreeSet<>(new NameComparator());
		PreparedStatement pstmt = null;
		
		try {
			
			pstmt = this.derbyConnection.prepareStatement(sql);
			pstmt.setInt(1, (int)userId);
			pstmt.setInt(2, (int)userId);
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
				
				
				sortedFriends.add(user);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sortedFriends;
	}
	
	

	

	@Override
	public Set<User> viewBlockedUsers(long userId) {
		// TODO Auto-generated method stub
		String sql = " select * from users where username in( SELECT users.username from users inner join "
				+ "relationship on (users.id=relationship.userid1) where userid2=? and relationship.status=3 union  "
				+ "SELECT users.username from users inner join relationship on (users.id=relationship.userid2) "
				+ "where userid1=? and relationship.status=3 )";
		Set<User> sortedFriends=new TreeSet<>(new NameComparator());
		PreparedStatement pstmt = null;
		
		try {
			
			pstmt = this.derbyConnection.prepareStatement(sql);
			pstmt.setInt(1, (int)userId);
			pstmt.setInt(2, (int)userId);
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
				
				
				sortedFriends.add(user);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sortedFriends;
	}

	@Override
	public boolean sendRequest(long userId1, long userId2) {
		// TODO Auto-generated method stub
		if(userId1>userId2) {
			long temp=userId1;
			userId1=userId2;
			userId2=temp;
		}
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
		if(userId1>userId2) {
			long temp=userId1;
			userId1=userId2;
			userId2=temp;
		}
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

	@Override
	public boolean editContact(Contact contact) {
		return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean unblockUser(long userId1, long userId2) {
		// TODO Auto-generated method stub
		String sql = "delete from relationship where actionId=? and status=? and (userid1=? or userid2=?)";
		
		java.sql.PreparedStatement pstmt = null;
		
		int result = 0;
		
		User user=null;
		
		try {
			pstmt = this.derbyConnection.prepareStatement(sql);
			
			pstmt.setInt(1, (int)userId1);
			pstmt.setInt(2, 3);
			pstmt.setInt(3, (int)userId2);
			pstmt.setInt(4, (int)userId2);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result==1 ? true:false; 
		
	}
}
