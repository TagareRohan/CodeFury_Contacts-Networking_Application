package com.training.ifaces;

import java.util.*;

import com.training.models.Contact;
import com.training.models.Friend;
import com.training.models.User;

public interface UserServices {

	public boolean addNewContact(String userName);
<<<<<<< HEAD
	public Map<String, String> searchUser(String userName);
	public List<Friend> viewFriendList();
	public List<Contact> viewContactList();
	
=======
	public boolean addNewFriend(String userName);
	public boolean block(String userName);
	public boolean unBlock(String userName);
>>>>>>> branch 'rohan_branch' of https://github.com/TagareRohan/CodeFury_Contacts-Networking_Application.git
	
	public Map<String, String> searchUser(String userName);
	public List<Friend> viewFriendList();
	public List<Contact> viewContactList();
	public List<User> viewBlockedList();
	
	
}