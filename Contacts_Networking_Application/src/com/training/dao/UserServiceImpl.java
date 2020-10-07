package com.training.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.training.ifaces.UserServices;
import com.training.models.Contact;
import com.training.models.Friend;
import com.training.models.User;

public class UserServiceImpl implements UserServices {

	List<User> userList;
	
	public UserServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
		userList=new ArrayList<>();
	}

	@Override
	public boolean addNewContact(String userName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Map<String, String> searchUser(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Friend> viewFriendList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contact> viewContactList() {
		// TODO Auto-generated method stub
		return null;
	}

	
}