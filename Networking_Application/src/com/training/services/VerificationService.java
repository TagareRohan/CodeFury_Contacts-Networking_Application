package com.training.services;

import com.training.ifaces.Verification;
import com.training.models.Admin;
import com.training.models.User;
import com.training.utils.AdminParser;
import com.training.utils.ConnectionUtility;

import java.sql.*;
import java.sql.Date;
import java.util.*;
import java.io.*;

public class VerificationService implements Verification {
	
	Connection derbyConnection = null;

	/**
	 * 
	 */
	public VerificationService() {
		super();
		this.derbyConnection = ConnectionUtility.getDerbyConnection();
	}

	@Override
	public boolean verifyAdmin(String userName, String password) {
		
		AdminParser parser=new AdminParser();
		boolean verified = false;
			try {
				List<Admin> adminList=parser.adminDetails();
				 for(Admin item:adminList)
				    {	
				    	if(item.getUsername().equals(userName) && item.getPassword().equals(password))
				    	{
				    		verified = true;
				    	}
				    	else
				    	{
				    		verified = false;
				    	}
				    }
			} //catch (ParserConfigurationException | SAXException | IOException e) {
			catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println("Exception occurred while parsing xml file." + e.getMessage());
			}
			return verified;
	}

	@Override
	public int verifyUser(String userName, String password) throws Exception {
		String sql1 = "select * from users where username=?";
		PreparedStatement pstmt = null;
//		boolean verified = false;
		
		pstmt = this.derbyConnection.prepareStatement(sql1);
		pstmt.setString(1, userName);
		
		ResultSet result = pstmt.executeQuery();
		
		String passFromDb;
		int userId;
		
		if (result.next()) {
			passFromDb = result.getString("password");
		} else {
			throw new Exception("User does not exists");
		}
		
		if (passFromDb.equals(password)) {
//			verified = true;
			userId = result.getInt("id");
		} else {
//			verified = false;
			throw new Exception("Wrong password.");
		}
		return userId;
	}

	@Override
	public boolean registerUser(User user) {
		String sql = "insert into users(fullName, email, phoneNumber, gender, dateOfBirth, address, city, state, country, company, image, username, password) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";

		PreparedStatement pstmt = null;
//		InputStream imageInputStream = new ByteArrayInputStream(user.getImage());
		InputStream fin=null;
		try {
			fin = new FileInputStream("C:\\Users\\manan\\git\\CodeFury_Extra\\Contacts_Networking_Application\\profile.png");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int rowUpdated = 0;
		
		try {
			pstmt = this.derbyConnection.prepareStatement(sql);
			
			pstmt.setString(1, user.getFullName());
			pstmt.setString(2, user.getEmail());
			pstmt.setLong(3, user.getPhoneNumber());
			pstmt.setString(4, user.getGender());
//			System.out.println(user.getDateOfBirth());
			pstmt.setDate(5, Date.valueOf(user.getDateOfBirth()));
			pstmt.setString(6, user.getAddress());
			pstmt.setString(7, user.getCity());
			pstmt.setString(8, user.getState());
			pstmt.setString(9, user.getCountry());
			pstmt.setString(10, user.getCompany());
			pstmt.setBlob(11,fin);
//			System.out.println(user.getUsername());
//			System.out.println(user.getPassword());
			pstmt.setString(12, user.getUsername());
			pstmt.setString(13, user.getPassword());
			
			rowUpdated = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
		}
		
		return rowUpdated==1 ? true:false;
	}

}