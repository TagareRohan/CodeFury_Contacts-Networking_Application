package com.training.ifaces;

import java.util.ArrayList;

import com.training.models.User;

public interface AdminServices {

	public ArrayList<User> showAllUsers();
	public boolean enableUser(long id);
	public boolean disableUser(long id);
	public boolean deleteUser(User user);
	
}
