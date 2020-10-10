package com.training.services;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.training.entity.Admin;
import com.training.xmlParser.AdminParser;

public class Verification {
	
	public boolean verifyAdmin(String userName,String password)
	{	AdminParser parser=new AdminParser();
		try {
			List<Admin> adminList=parser.adminDetails();
			 for(Admin item:adminList)
			    {	
			    	if(item.getUsername().equals(userName) && item.getPassword().equals(password))
			    	{
			    		return true;
			    	}
			    	else
			    	{
			    		return false;
			    	}
			    }
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
			System.out.println("Exception occurred while parsing xml file");
		}
		return false;
	}
	
	public boolean verifyUser(String userName,String password)
	{
		return false;
	}
	
	public boolean registerUser()
	{
		return false;
	}

}
