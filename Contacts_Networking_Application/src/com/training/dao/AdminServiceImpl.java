package com.training.dao;

import java.sql.Connection;
import java.util.*;

import com.training.ifaces.AdminServices;
import com.training.models.User;
import com.training.utils.ConnectionUtility;

public class AdminServiceImpl implements AdminServices{

	List<User> userList;
	Connection derbyConnection;
	
	public AdminServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
		userList=new ArrayList<>();
		this.derbyConnection=ConnectionUtility.getDerbyConnection();
	}

	@Override
	public String findUser(String userName) {
		// TODO Auto-generated method stub
		
		for(User user:userList)
		{
			if(user.getUsername().equals(userName))
			{
				return user.getFullName();
			}
		}
		
		return null;
	}

	@Override
	public boolean deactivateUser(String userName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean disableUser(String userName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

}
