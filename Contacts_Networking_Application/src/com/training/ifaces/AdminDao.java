/**
 * 
 */
package com.training.ifaces;

import java.util.Collection;

import com.training.entity.Person;

/**
 * @author manan
 *
 */
public interface AdminDao {

	boolean loginAdmin(String adminUsername, String adminPassword);
	boolean disableUser(Person user);
	boolean deleteUser(Person user);
	Collection<?> showSummary();
	boolean logoutAdmin();
}
