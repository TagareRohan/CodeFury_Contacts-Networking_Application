/**
 * 
 */
package com.training.daos;

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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Collection<Contact> viewContacts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Person> viewFriends() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Person> searchUsers(String nameEmail) {
		return null;
		// TODO Auto-generated method stub

	}

	@Override
	public Collection<Person> viewBlockedUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean registerUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean loginUser(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean logoutUser() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean sendRequest(Person user1, Person user2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean blockUser(Person user1, Person user2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean unblockUser(Person user1, Person user2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addFriend(Person user1, Person user2) {
		// TODO Auto-generated method stub
		return false;
	}


}
