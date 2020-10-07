/**
 * 
 */
package com.training.services;

import java.util.Collection;

import com.training.entity.Person;
import com.training.ifaces.AdminDao;

/**
 * @author manan
 *
 */
public class AdminDaoImpl implements AdminDao {

	@Override
	public boolean disableUser(Person user) {
		// TODO Add code to disable user by checking the no. of times he has been blocked from relationship table.
		return false;
	}

	@Override
	public boolean deleteUser(Person user) {
		// TODO Add code to delete user from user table.
		return false;
	}

	@Override
	public Collection<?> showSummary() {
		// TODO Add code to view summary of all users in the DB (Dont know what will be returned so i put a collection )
		return null;
		
	}

	@Override
	public boolean loginAdmin(String adminUsername, String adminPassword) {
		// TODO Add code to authorize admin login
		return false;
	}

	@Override
	public boolean logoutAdmin() {
		// TODO add code to logout admin (maybe this is not needed.)
		return false;
	}
	
}
