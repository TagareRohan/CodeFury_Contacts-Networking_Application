package com.training.dao;

import java.sql.Connection;
import java.util.*;

import com.training.ifaces.AdminServices;
import com.training.models.User;
import com.training.utils.ConnectionUtility;

public class AdminServiceImpl implements AdminServices{

	Map<String,String> userList;
	Connection derbyConnection;
	
	public AdminServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
		userList=new HashMap<>();
		this.derbyConnection=ConnectionUtility.getDerbyConnection();
	}

	@Override
	public String getStatistics() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteUser(String userName) {
		// TODO Auto-generated method stub
		
		
		return false;
	}

	@Override
	public boolean disableUser(String userName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Map<String, String> viewUsersToDisable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> viewUsersToDelete() {
		// TODO Auto-generated method stub
		return null;
	}

	

}