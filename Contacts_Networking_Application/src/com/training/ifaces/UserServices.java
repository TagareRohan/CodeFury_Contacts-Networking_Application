package com.training.ifaces;

import com.training.models.User;

public interface UserServices {

	public boolean addUser(User user);
	public String findUser(String userName);
	
}
