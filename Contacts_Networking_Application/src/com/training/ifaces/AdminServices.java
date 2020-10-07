package com.training.ifaces;

import java.util.*;

import com.training.models.User;

public interface AdminServices {

	public Map<String,String> searchUser(String userName);
	public boolean deleteUser(String userName);
	public boolean disableUser(String userName);
	public Map<String,String> viewUsersToDisable();
	public Map<String,String> viewUsersToDelete();
	
	
}