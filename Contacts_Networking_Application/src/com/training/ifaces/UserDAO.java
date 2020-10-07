package com.training.ifaces;

import java.util.ArrayList;
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
	public User findUser(String userName);
	boolean addContact(Contact contact);
	TreeSet<Contact> viewContacts();
	TreeSet<Person> viewFriends();
	ArrayList<User> searchUsers();
	TreeSet<Person> viewBlockedUsers();
	
}
