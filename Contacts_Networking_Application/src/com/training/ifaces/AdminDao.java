/**
 * 
 */
package com.training.ifaces;

import java.util.Collection;

import com.training.entity.Person;
import com.training.entity.User;

/**
 * @author manan
 *
 */
public interface AdminDao {

	boolean loginAdmin(String adminUsername, String adminPassword);
	boolean disableUser(int id);
	boolean deleteUser(int id);
	Collection<User> showSummary();
	Collection<User> viewUsersToDisable();
}
