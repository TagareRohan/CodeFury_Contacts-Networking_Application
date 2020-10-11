package com.training.ifaces;

import java.util.*;

import com.training.models.Contact;
import com.training.models.Person;
import com.training.models.User;

public interface UserDao {
	
	
	boolean addContact(int id, Contact contact);
	boolean editContact(int id, Contact contact);
	boolean addFriend(int userId1, int userId2);
	
	Collection<Contact> viewContacts(int id);
	Collection<User> viewFriends(int id);
	Collection<User> viewBlockedUsers(int userId);
	
	Person searchUser(String nameEmail);
	
	boolean blockUser(int userId1, int userId2);
	boolean unblockUser(int userId1, int userId2);
	
	boolean sendRequest(int userId1, int userId2);
	boolean declineRequest(int userId1, int userId2);
	Set<User> viewFriendRequests(int userId);
	
}