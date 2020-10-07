package com.training.ifaces;

import java.util.*;

import com.training.models.Contact;
import com.training.models.Friend;
import com.training.models.User;

public interface UserServices {

	public boolean addNewContact(String userName);
	public Map<String, String> searchUser(String userName);
	public List<Friend> viewFriendList();
	public List<Contact> viewContactList();
	
	
}