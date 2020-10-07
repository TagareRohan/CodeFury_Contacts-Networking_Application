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
	boolean addContact(Person user, Contact contact);
	Collection<Contact> viewContacts();
	Collection<Person> viewFriends();
	Collection<Person> searchUsers(String nameEmail);
	Collection<Person> viewBlockedUsers();
	boolean sendRequest(Person user1, Person user2);
	boolean addFriend(Person user1, Person user2);
	boolean blockUser(Person user1, Person user2);
	boolean unblockUser(Person user1, Person user2);
	boolean logoutUser();
	
}
