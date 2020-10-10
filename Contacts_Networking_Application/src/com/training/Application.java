package com.training;

import java.time.LocalDate;
import java.util.ArrayList;

import com.training.dao.AdminServiceImpl;
import com.training.dao.UserServiceImpl;
import com.training.ifaces.AdminServices;
import com.training.models.Contact;
import com.training.models.User;
import com.training.utils.ConnectionUtility;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ConnectionUtility.getDerbyConnection();
		UserServiceImpl userService=new UserServiceImpl();
		AdminServiceImpl adminService=new AdminServiceImpl();
//		User batman=new User("Diana Prince", "diana@abc.com",3333333333l, "Female", LocalDate.parse("2020-01-08"), 
//								"Somewhere in Amazon", "Amazon", "Nebraska", "US", "Justice League", null, 
//								"wonderwoman", "diana123");
//		userService.addUser(batman);
		
//		Contact contact=new Contact(201l,"Batwoman", "batwoman@abc.com",3333333333l, "Male", LocalDate.parse("2020-01-08"), 
//				"Somewhere in Amazon", "Amazon", "Nebraska", "US", "Justice League", null);
//		System.out.println(userService.addContact(contact));
		
		//userService.viewBlockedUsers(201).forEach(System.out::println);
		
		ArrayList<User> userList=new ArrayList<User>();
		System.out.println(adminService.deleteUser(201));
		
		userList.forEach(System.out::println);
		
		
		//System.out.println(adminService.enableUser(303));
		//System.out.println(adminService.showAllUsers());
		//System.out.println(adminService.deleteUser(304));
		//System.out.println(userList);
		//User bats=userService.findUser("batman");
//		System.out.println(userService.sendRequest(301, 308));
//		System.out.println(userService.sendRequest(301, 302));
//		System.out.println(userService.sendRequest(301, 303));
//		System.out.println(userService.sendRequest(302, 307));
//		System.out.println(userService.sendRequest(303, 306));
//		System.out.println(userService.acceptRequest(301, 308));
//		System.out.println(userService.acceptRequest(301, 302));
//		System.out.println(userService.acceptRequest(302, 307));
//		System.out.println(userService.acceptRequest(303, 306));
//      System.out.println(userService.declineRequest(1, 301));
//		System.out.println(userService.blockUser(308, 301));
//		System.out.println(userService.blockUser(303, 301));
//		System.out.println(userService.blockUser(303, 306));
		//System.out.println(bats);
		userService.viewFriendRequests(303).forEach(System.out::println);
	}

}
