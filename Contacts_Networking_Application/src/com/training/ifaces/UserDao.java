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

	boolean addContact(int id, Contact contact);
	Collection<Contact> viewContacts(int id);
	Collection<User> viewFriends(int id);
	Person searchUser(String nameEmail);
	Collection<User> viewBlockedUsers(int userId);
	boolean sendRequest(int userId1, int userId2);
	boolean addFriend(int userId1, int userId2);
	boolean blockUser(int userId1, int userId2);
	boolean unblockUser(int userId1, int userId2);
	boolean declineRequest(int userId1, int userId2);
	boolean editContact(int id, Contact contact);
	
}
