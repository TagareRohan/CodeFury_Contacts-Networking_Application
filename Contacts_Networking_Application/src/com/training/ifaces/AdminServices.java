package com.training.ifaces;

import java.util.*;

import com.training.models.User;

public interface AdminServices {

	public String getStatistics();
	
	public boolean deleteUser(String userName);
	public boolean disableUser(String userName);
	public Map<String,String> viewUsersToDisable();
	public Map<String,String> viewUsersToDelete();
	
	
}