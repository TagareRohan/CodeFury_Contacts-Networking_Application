package com.training;

import java.time.LocalDate;
import java.util.ArrayList;

import com.training.dao.UserServiceImpl;
import com.training.models.User;
import com.training.utils.ConnectionUtility;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ConnectionUtility.getDerbyConnection();
		UserServiceImpl userService=new UserServiceImpl();
		User batman=new User("Bruce Wayne", "bruce@abc.com",3333333333l, "Male", LocalDate.parse("2020-01-08"), 
								"Somewhere in Gotham", "Gotham", "Nebraska", "US", "Wayne Enterprises", null, 
								"batman", "batman123");
		userService.addUser(batman);
		ArrayList<User> userList=new ArrayList<User>();
		userList=userService.searchUsers();
		System.out.println(userList);
	}

}
