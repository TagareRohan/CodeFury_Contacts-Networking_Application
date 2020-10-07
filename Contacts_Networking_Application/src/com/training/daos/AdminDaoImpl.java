/**
 * 
 */
package com.training.daos;

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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUser(Person user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Collection<?> showSummary() {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean loginAdmin(String adminUsername, String adminPassword) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean logoutAdmin() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
