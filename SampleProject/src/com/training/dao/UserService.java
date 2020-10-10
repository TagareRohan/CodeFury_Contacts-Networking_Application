package com.training.dao;

import com.training.model.User;

import com.training.utils.ConnectionUtility;

import java.util.ArrayList;
import java.util.List;
import java.math.BigInteger; 
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException; 

public class UserService {

	List<User> userList;
	private Connection derbyConnection;
	
	public UserService() {
		super();
		// TODO Auto-generated constructor stub
		userList=new ArrayList<>();
		this.derbyConnection = ConnectionUtility.getDerbyConnection();
	}

	
	public boolean addUser(User user)
	{ 
		/*
		 * String hash = this.getMd5(user.getPw()); user.setPw(hash);
		 * if(userList.add(user)) { return true; }
		 * 
		 * return false;
		 */
		
		String sql = "insert into userdetails values(?,?)";
		PreparedStatement pstmt = null;
		int rowUpdated = 0;
		
		
		try
		{
			 pstmt = this.derbyConnection.prepareStatement(sql);
			
			
			pstmt.setString(1, user.getName());
			
			//converting password into Md5 encrpyted string using MD5 before storing it to database
			pstmt.setString(2, getMd5(user.getPw()) );
			
			rowUpdated = pstmt.executeUpdate();
		} 
		
		catch(SQLException e){
			e.printStackTrace();
		} 
		finally
		{
			try{
				pstmt.close();
			} catch(SQLException e){
				e.printStackTrace();
				
			}
		}
		
		return rowUpdated ==1?true:false;
		
	
	}

	
	public User findUser(String userName,String pass) {
		// TODO Auto-generated method stub
		
		/*
		 * for(User user:userList) { if(user.getName().equals(userName)) { return user;
		 * } }
		 * 
		 * 
		 * return null;
		 */	 
		
		String sql = "Select * from userdetails where name = ?";
		PreparedStatement pstmt = null;
		User user = null;
		boolean flag = false;
		try{
			pstmt = this.derbyConnection.prepareStatement(sql);
			pstmt.setString(1,userName);
			java.sql.ResultSet result = pstmt.executeQuery();
			while(result.next())
			{
				 
				String name = result.getString("name");
				String pw = result.getString("pw");
				
				
				//Checking if the provided password produces same encryption as stored in database
				String secure = getMd5(pass);
				if(pw.equals(secure))
				{
					flag = true;
				}  
				//User user;
				if(flag==true){
				       user = new User(name, pw);
						}
			}
			 
			
					
						
					
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		if(flag==false)System.out.println("Password wrong");
		return user;
	} 
	
	
	// Method for encryption using MD5
/////////////////////////////////////////////////////
	
	
	public static String getMd5(String input) 
    { 
        try { 
  
            // Static getInstance method is called with hashing MD5 
            MessageDigest md = MessageDigest.getInstance("MD5"); 
  
            // digest() method is called to calculate message digest 
            //  of an input digest() return array of byte 
            byte[] messageDigest = md.digest(input.getBytes()); 
  
            // Convert byte array into signum representation 
            BigInteger no = new BigInteger(1, messageDigest); 
  
            // Convert message digest into hex value 
            String hashtext = no.toString(16); 
            while (hashtext.length() < 32) { 
                hashtext = "0" + hashtext; 
            } 
            return hashtext; 
        } 
        catch (NoSuchAlgorithmException e) { 
            throw new RuntimeException(e); 
        } 
}
}
