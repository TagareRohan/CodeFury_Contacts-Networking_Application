 /**
 * 
 */
package com.training.services;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

import com.training.entity.Contact;
import com.training.entity.Person;
import com.training.entity.User;
import com.training.ifaces.UserDao;
import com.training.utils.ConnectionUtility;
import com.training.utils.NameComparator;

/**
 * @author manan
 *
 */
public class UserDaoImpl implements UserDao {

	Connection derbyConnection = null;
	
	
	/**
	 * 
	 */
	public UserDaoImpl() {
		super();
		
		this.derbyConnection = ConnectionUtility.getDerbyConnection();
	}
	
	
	private Person getObjFromId(int id) {
		//TODO Add code to get User object from ID.
		return null;
		
	}

	@Override
	public boolean addContact(User user, Contact contact) {
		// TODO Add code to update to add contact to contact table.
		String sql = "insert into contacts(userid,fullName,email,phoneNumber,gender,dateOfBirth,address,"
				+ "city,state,country,company,image) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?)";

		PreparedStatement pstmt = null;
		InputStream imageInputStream = new ByteArrayInputStream(contact.getImage());
		int rowUpdated = 0;

		try {
			pstmt = this.derbyConnection.prepareStatement(sql);
			
			pstmt.setInt(1, user.getId());
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
			pstmt.setBlob(12,imageInputStream);
			
			rowUpdated = pstmt.executeUpdate();
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
	
		}

		return rowUpdated==1 ? true:false;
	}

	@Override
	public Collection<Contact> viewContacts(User user) {
		// TODO View all contacts related to user.
		TreeSet<Contact> contacts=new TreeSet<>(new NameComparator());
		String sql = "select * from contacts where userid=?";
		
		PreparedStatement pstmt = null;
		
		try {
			
			pstmt = this.derbyConnection.prepareStatement(sql);
			pstmt.setInt(1, user.getId());
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
			
//				int id=result.getInt("userid");
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
				
				Contact contact=new Contact(fullName, email, phoneNumber, gender, dateOfBirth, address, city, state, country, company, barr);
				
			
				System.err.println(contacts.add(contact));
			}
			
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		
		return contacts;
	}

	@Override
	public Collection<User> viewFriends(int userId) {
		// TODO View all friends of a user.
		String sql = "SELECT users.id,users.username,"
				+ " from users left outer join relationship "
				+ "on (users.id=relationship.userid1 or users.id=relationship.userid2) "
				+ "where relationship.status=? and users.id=?";
		Set<User> sortedFriends=new TreeSet<>();
		PreparedStatement pstmt = null;
		
		try {
			
			pstmt = this.derbyConnection.prepareStatement(sql);
			pstmt.setInt(1, 1);
			pstmt.setInt(2, userId);
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
			
				int id=result.getInt("id");
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
									address, city, state, country, company, barr, id, username);
				
				
				sortedFriends.add(user);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sortedFriends;
	}

	@Override
	public Person searchUser(String nameEmail) {
		
		String sql = "select * from users where username=? or email=?";
		
		PreparedStatement pstmt = null;
		
		User user = null;
		
			try {
				pstmt = this.derbyConnection.prepareStatement(sql);
				
				pstmt.setString(1, nameEmail);
				pstmt.setString(2, nameEmail);
				ResultSet result = pstmt.executeQuery();
				//System.out.println(result);
				if(result.next()) {
					
					int id= result.getInt("id");
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
					
					byte imageAsByteArray[]=image.getBytes(1,(int)image.length());//1 means first image
					
					user=new User(fullName, email, phoneNumber, gender, dateOfBirth, address, city, state, country, company, imageAsByteArray, id, username);
				} else {
					throw new Exception("User not found.");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}
			
			return user;
		// TODO Search for other users with either name or email.

	}

	@Override
	public Collection<Person> viewBlockedUsers() {
		// TODO view all user blocked by a user.
		return null;
	}

	@Override
	public boolean registerUser(User user) {
		// TODO you should know what to do here
		String sql = "insert into users(fullName, email, phoneNumber, gender, dateOfBirth, address, city, state, country, company, image, username, password) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";

		PreparedStatement pstmt = null;
		InputStream imageInputStream = new ByteArrayInputStream(user.getImage());
		int rowUpdated = 0;
		
		try {
			pstmt = this.derbyConnection.prepareStatement(sql);
			
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
			pstmt.setBlob(11,imageInputStream);
			pstmt.setString(12, user.getUsername());
			
			rowUpdated = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
		}
		
		return rowUpdated==1 ? true:false;
	}

	@Override
	public boolean loginUser(String username, String password) {
		// TODO if you dont know what to do here you should not be editing this code
		return false;
	}

	@Override
	public boolean sendRequest(int userId1, int userId2) {
		// TODO send a friend request from user1 to user2
		String sql = "insert into relationship "
				+ "values(?,?,?,?)";

		PreparedStatement pstmt = null;
		
	
		int rowUpdated = 0;

		try {
			pstmt = this.derbyConnection.prepareStatement(sql);
	
			//pstmt.setInt(1,0);
			
			
			pstmt.setInt(1, userId1);
			pstmt.setInt(2, userId2);
			pstmt.setInt(3, 0);
			pstmt.setInt(4, userId1);
			rowUpdated = pstmt.executeUpdate();
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
	
		}

		return rowUpdated==1 ? true:false;
	}

	@Override
	public boolean blockUser(int userId1, int userId2) {
		// TODO user1 blocks user2 add code.
		String sql = "update relationship set status=?, actionId=? where userId1=? and userId2=?";

		PreparedStatement pstmt = null;
		int rowUpdated = 0;

		try {
			pstmt = this.derbyConnection.prepareStatement(sql);
	
			//pstmt.setInt(1,0);
			
			pstmt.setInt(1, 3);
			pstmt.setInt(2, userId2);
			pstmt.setInt(3, userId1);
			pstmt.setInt(4, userId2);
			
			
			rowUpdated = pstmt.executeUpdate();
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
	
		}

		return rowUpdated==1 ? true:false;
	}

	@Override
	public boolean unblockUser(int userId1, int userId2) {
		// TODO user 1 finally unblocked user2 add code
		String sql = "delete from relationship where actionId=? and status=? and (userid1=? or userid2=?)";
		
		java.sql.PreparedStatement pstmt = null;
		
		int result = 0;
		
		User user=null;
		
		try {
			pstmt = this.derbyConnection.prepareStatement(sql);
			
			pstmt.setInt(1, userId1);
			pstmt.setInt(2, 3);
			pstmt.setInt(3, userId2);
			pstmt.setInt(4, userId2);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result==1 ? true:false; 
	}

	@Override
	public boolean addFriend(int userId1, int userId2) {
		// TODO add friend is called when user 1 accepts user2's friend request or vice-versa
		String sql = "update relationship set status=?, actionId=? where userId1=? and userId2=?";

		PreparedStatement pstmt = null;
		int rowUpdated = 0;

		try {
			pstmt = this.derbyConnection.prepareStatement(sql);
	
			//pstmt.setInt(1,0);
			
			pstmt.setInt(1, 1);
			pstmt.setInt(2, userId2);
			pstmt.setInt(3, userId1);
			pstmt.setInt(4, userId2);
			
			
			rowUpdated = pstmt.executeUpdate();
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
	
		}

		return rowUpdated==1 ? true:false;
	}

	@Override
	public boolean declineRequest(int userId1, int userId2) {
		// TODO Auto-generated method stub
		String sql = "update relationship set status=?, actionId=? where userId1=? and userId2=?";

		PreparedStatement pstmt = null;
		int rowUpdated = 0;

		try {
			pstmt = this.derbyConnection.prepareStatement(sql);
	
			//pstmt.setInt(1,0);
			
			pstmt.setInt(1, 2);
			pstmt.setInt(2, userId2);
			pstmt.setInt(3, userId1);
			pstmt.setInt(4, userId2);
			
			
			rowUpdated = pstmt.executeUpdate();
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
	
		}

		return rowUpdated==1 ? true:false;
		
	}

}
