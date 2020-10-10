package com.training.ifaces;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

import com.training.models.Contact;
import com.training.models.Person;
import com.training.models.User;

public interface UserDAO {

	public boolean addUser(User user);
	public boolean sendRequest(long userId1,long userId2);
	public boolean acceptRequest(long userId1,long userId2);
	public boolean declineRequest(long userId1,long userId2);
	public boolean blockUser(long userId1,long userId2);
	public boolean unblockUser(long userId1,long userId2);
	public User findUser(String userName);
	public boolean addContact(Contact contact);
	public boolean editContact(Contact contact);
	Set<Contact> viewContacts(User user);
	Set<User> viewFriends(long id);
	Set<User> viewBlockedUsers(long userId);
	
}
