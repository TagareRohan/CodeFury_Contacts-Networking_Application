/**
 * 
 */
package com.training.services;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.training.entity.Admin;
import com.training.entity.User;
import com.training.ifaces.Verification;
import com.training.utils.AdminParser;
import com.training.utils.ConnectionUtility;

/**
 * @author manan
 *
 */
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
			} catch (ParserConfigurationException | SAXException | IOException e) {
				// TODO Auto-generated catch block
				System.err.println("Exception occurred while parsing xml file." + e.getMessage());
			}
			return verified;
	}

	@Override
	public boolean verifyUser(String userName, String password) throws Exception {
		String sql = "select * from users where username=?";
		PreparedStatement pstmt = null;
		boolean verified = false;
		
		pstmt = this.derbyConnection.prepareStatement(sql);
		pstmt.setString(1, userName);
		
		ResultSet result = pstmt.executeQuery();
		
		String passFromDb;
		
		if (result.next()) {
			passFromDb = result.getString("password");
		} else {
			throw new Exception("User does not exists");
		}
		
		if (passFromDb.equals(password)) {
			verified = true;
		} else {
			verified = false;
		}
		return verified;
	}

	@Override
	public boolean registerUser(User user) {
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

}
