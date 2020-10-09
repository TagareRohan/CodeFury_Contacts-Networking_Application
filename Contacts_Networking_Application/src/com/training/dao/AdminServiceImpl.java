package com.training.dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

import com.training.ifaces.AdminServices;
import com.training.models.User;
import com.training.utils.ConnectionUtility;

public class AdminServiceImpl implements AdminServices{

	ArrayList<User> userList;
	Connection derbyConnection;
	
	public AdminServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
		userList=new ArrayList<>();
		this.derbyConnection=ConnectionUtility.getDerbyConnection();
	}

	

	

	@Override
	public boolean disableUser(long id) {
		// TODO Auto-generated method stub
		String sql = "update users set disabled=? where Id=?";

		PreparedStatement pstmt = null;
		int rowUpdated = 0;

		try {
			pstmt = this.derbyConnection.prepareStatement(sql);
	
			//pstmt.setInt(1,0);
			
			pstmt.setInt(1, 1);
			pstmt.setInt(2, (int)id);
			
			
			
			rowUpdated = pstmt.executeUpdate();
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
	
		}

		return rowUpdated==1 ? true:false;
		
	}





	@Override
	public ArrayList<User> showAllUsers() {
		// TODO Auto-generated method stub
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
			
				long id=(long)result.getInt("id");
				String city=result.getString("city");
				String state=result.getString("state");
				String country=result.getString("country");
				
				
				
				User user=new User(null, null, 0, null, null, null, city, state, country, null, null, null, id);
				
				
				this.userList.add(user);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.userList;
	
}





	@Override
	public boolean enableUser(long id) {
		// TODO Auto-generated method stub
		String sql = "update users set disabled=? where Id=?";

		PreparedStatement pstmt = null;
		int rowUpdated = 0;

		try {
			pstmt = this.derbyConnection.prepareStatement(sql);
	
			//pstmt.setInt(1,0);
			
			pstmt.setInt(1, 0);
			pstmt.setInt(2, (int)id);
			
			
			
			rowUpdated = pstmt.executeUpdate();
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
	
		}

		return rowUpdated==1 ? true:false;
	}





	@Override
	public boolean deleteUser(long i) {
		// TODO Auto-generated method stub
		
		String sql = "delete from users where id = ?";
		
		java.sql.PreparedStatement pstmt = null;
		
		int result = 0;
		
		User deletedUser=null;
		
		try {
			pstmt = this.derbyConnection.prepareStatement(sql);
			
			pstmt.setInt(1, (int)i);
						
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result == 1 ? true : false;
	}

	

}
