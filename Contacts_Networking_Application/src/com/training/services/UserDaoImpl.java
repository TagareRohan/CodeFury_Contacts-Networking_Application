/**
 * 
 */
package com.training.services;

import java.sql.Connection;
import java.util.Collection;

import com.training.entity.Contact;
import com.training.entity.Person;
import com.training.entity.User;
import com.training.ifaces.UserDao;
import com.training.utils.ConnectionUtility;

/**
 * @author manan
 *
 */
public class UserDaoImpl implements UserDao {

	Connection derbyConnection = null;
	
	
	/**
	 * 
	 */
	public UserDaoImpl() {
		super();
		
		this.derbyConnection = ConnectionUtility.getDerbyConnection();
	}

	@Override
	public boolean addContact(Person user, Contact contact) {
		// TODO Add code to update to add contact to contact table.
		return false;
	}

	@Override
	public Collection<Contact> viewContacts(Person user) {
		// TODO View all contacts related to user.
		return null;
	}

	@Override
	public Collection<Person> viewFriends(Person user) {
		// TODO View all friends of a user.
		return null;
	}

	@Override
	public Collection<Person> searchUsers(String nameEmail) {
		return null;
		// TODO Search for other users with either name or email.

	}

	@Override
	public Collection<Person> viewBlockedUsers() {
		// TODO view all user blocked by a user.
		return null;
	}

	@Override
	public boolean registerUser(User user) {
		// TODO you should know what to do here
		return false;
	}

	@Override
	public boolean loginUser(String username, String password) {
		// TODO if you dont know what to do here you should not be editing this code
		return false;
	}

	@Override
	public boolean logoutUser() {
		// TODO I dont know if this is necessary or not
		return false;
	}

	@Override
	public boolean sendRequest(Person user1, Person user2) {
		// TODO send a friend request from user1 to user2
		return false;
	}

	@Override
	public boolean blockUser(Person user1, Person user2) {
		// TODO user1 blocks user2 add code.
		return false;
	}

	@Override
	public boolean unblockUser(Person user1, Person user2) {
		// TODO user 1 finally unblocked user2 add code
		return false;
	}

	@Override
	public boolean addFriend(Person user1, Person user2) {
		// TODO add friend is called when user 1 accepts user2's friend request or vice-versa
		return false;
	}


}
