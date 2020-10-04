package com.training.ifaces;

import com.training.models.User;

public interface AdminServices {

	public String findUser(String userName);
	public boolean deactivateUser(String userName);
	public boolean disableUser(String userName);
	public boolean addUser(User user);
	
}
