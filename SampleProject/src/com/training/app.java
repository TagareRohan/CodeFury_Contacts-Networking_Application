package com.training;

import com.training.dao.UserService;
import com.training.model.User;

public class app {
	
	public static void main(String args[])
	{
		UserService service = new UserService();
		
		User ram = new User("ram", "ram");
		
		boolean result = service.addUser(ram);
		System.out.println(result);
		System.out.println(service.findUser("ram","ram"));
	}

}
