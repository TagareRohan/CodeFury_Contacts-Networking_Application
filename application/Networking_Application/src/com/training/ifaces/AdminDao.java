package com.training.ifaces;

import java.util.*;

import com.training.models.User;

public interface AdminDao {
	
	
	boolean loginAdmin(String adminUsername, String adminPassword);
	boolean disableUser(int id);
	boolean deleteUser(int id);
	Collection<User> showSummary();
	Collection<User> viewUsersToDisable();
	Collection<User> viewUsersToDelete();
	
}