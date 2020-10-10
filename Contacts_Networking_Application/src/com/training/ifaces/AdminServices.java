package com.training.ifaces;

import java.util.ArrayList;
import java.util.Collection;

import com.training.models.User;

public interface AdminServices {

	public ArrayList<User> showAllUsers();
	public boolean enableUser(long id);
	public boolean disableUser(long id);
	public boolean deleteUser(long id);
	public boolean deleteRelationship(long id);
	public boolean deleteUserFromContacts(long id);
	Collection<User> viewUsersToDisable();
	
	
}
