/**
 * 
 */
package com.training.ifaces;

import java.util.Collection;

import com.training.entity.Contact;
import com.training.entity.Person;
import com.training.entity.User;

/**
 * @author manan
 *
 */
public interface UserDao {

	boolean registerUser(User user);
	boolean loginUser(String username, String password);
	boolean addContact(User user, Contact contact);
	Collection<Contact> viewContacts(User user);
	Collection<User> viewFriends(int id);
	Person searchUser(String nameEmail);
	Collection<Person> viewBlockedUsers();
	boolean sendRequest(int userId1, int userId2);
	boolean addFriend(int userId1, int userId2);
	boolean blockUser(int userId1, int userId2);
	boolean unblockUser(int userId1, int userId2);
	boolean declineRequest(int userId1, int userId2);
	boolean logoutUser();
	
}
