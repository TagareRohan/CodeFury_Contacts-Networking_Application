package com.training.dao;

import java.util.ArrayList;
import java.util.List;

import com.training.ifaces.UserServices;
import com.training.models.User;

public class UserServiceImpl implements UserServices {

	List<User> userList;
	
	public UserServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
		userList=new ArrayList<>();
	}

	@Override
	public boolean addUser(User user)
	{
		if(userList.add(user))
		{
			return true;
		}
		
		return false;
	}

	@Override
	public String findUser(String userName) {
		// TODO Auto-generated method stub
		
		for(User user:userList)
		{
			if(user.getUserName().equals(userName))
			{
				return user.getFullName();
			}
		}
		
		
		return null;
	}
}
