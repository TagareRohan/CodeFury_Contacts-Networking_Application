/**
 * 
 */
package com.training.services;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.training.entity.Person;
import com.training.entity.User;
import com.training.ifaces.AdminDao;
import com.training.utils.ConnectionUtility;

/**
 * @author manan
 *
 */
public class AdminDaoImpl implements AdminDao {

	List<User> userList;
	Connection derbyConnection;
	
	/**
	 * 
	 */
	public AdminDaoImpl() {
		super();
		this.derbyConnection = ConnectionUtility.getDerbyConnection();
		this.userList = new ArrayList<>();
	}

	@Override
	public boolean disableUser(int id) {
		// TODO Add code to disable user by checking the no. of times he has been blocked from relationship table.
		String sql = "select email from users where id=?";
		String sql1 = "insert into disabled(userid, email) values (?, ?)";
		String userEmail = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		ResultSet resultEmail = null;
		int rowUpdated = 0;
		boolean delete = false;

		try {
			pstmt = this.derbyConnection.prepareStatement(sql);
			
			pstmt.setInt(1, id);
			
			resultEmail = pstmt.executeQuery();
			
			if (resultEmail.next()) {
				userEmail = resultEmail.getString("email");
			}
			
			pstmt1 = this.derbyConnection.prepareStatement(sql1);
			
			pstmt1.setInt(1, id);
			pstmt1.setString(2, userEmail);
			
			rowUpdated = pstmt1.executeUpdate();
			
			delete = this.deleteUser(id);
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}finally {
	
		}

		return rowUpdated == 1 && delete == true ? true : false;
		
	}

	@Override
	public boolean deleteUser(int id) {
		// TODO Add code to delete user from user table.
		String sql = "delete from users where id = ?";
		
		java.sql.PreparedStatement pstmt = null;
		
		int result = 0;
		
		try {
			pstmt = this.derbyConnection.prepareStatement(sql);
			
			pstmt.setInt(1, (int)id);
						
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result == 1 ? true : false;
	}

	@Override
	public Collection<User> showSummary() {
		// TODO Add code to view summary of all users in the DB (Dont know what will be returned so i put a collection )
		String sql = "select id,city,state,country from users";
		
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
			
				int id=(int)result.getInt("id");
				String city=result.getString("city");
				String state=result.getString("state");
				String country=result.getString("country");
				
				
				
				User user=new User(city, state, country, id);
				
				
				this.userList.add(user);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.userList;
		
	}

	@Override
	public boolean loginAdmin(String adminUsername, String adminPassword) {
		// TODO Add code to authorize admin login (XML Parsing)
		
		
		return false;
	}

	@Override
	public Collection<User> viewUsersToDisable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<User> viewUsersToDelete() {
		// TODO Auto-generated method stub
		return null;
	}
	
}