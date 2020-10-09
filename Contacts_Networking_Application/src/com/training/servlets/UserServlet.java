package com.training.servlets;

import java.io.IOException;
<<<<<<< HEAD
=======
import java.util.List;
>>>>>>> branch 'rohan_branch' of https://github.com/TagareRohan/CodeFury_Contacts-Networking_Application.git
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.dao.UserServiceImpl;
import com.training.dao.Verification;
<<<<<<< HEAD
=======
import com.training.models.Contact;
import com.training.models.Friend;
>>>>>>> branch 'rohan_branch' of https://github.com/TagareRohan/CodeFury_Contacts-Networking_Application.git
import com.training.models.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDispatcher dispatcher=null;
	UserServiceImpl service;
	Verification verify;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String login=request.getParameter("submit");
		
		if(login.equals("userLogin"))
		{
			String userName=request.getParameter("userName");
			String password=request.getParameter("password");
			if(verify.verifyUser(userName, password))
			{
				
				request.setAttribute("userName", userName);
				dispatcher=request.getRequestDispatcher("userHome.jsp");
				dispatcher.forward(request, response);
			}
		}
		else if(login.equals("userSignUp"))
		{
			String userName=request.getParameter("userName");
			String fullName=request.getParameter("fullName");
			
			/*
			 * ....
			 *  ....
			 *  
			 *  set other fields as well
			 */
<<<<<<< HEAD
			
			verify.registerUser();
			
			request.setAttribute("userName", userName);
=======
>>>>>>> branch 'rohan_branch' of https://github.com/TagareRohan/CodeFury_Contacts-Networking_Application.git
			
			verify.registerUser(new User());
			
			request.setAttribute("userName", userName);
			
			dispatcher=request.getRequestDispatcher("userLogin.jsp");
			dispatcher.forward(request, response);
		}
		
		String userAction=request.getParameter("userAction");
		
		if(userAction.equals("addNewContact"))
		{
			dispatcher=request.getRequestDispatcher("addNewContact.jsp");
			dispatcher.forward(request, response);
		}
		else if(userAction.equals("AddNewFriend"))
		{
			dispatcher=request.getRequestDispatcher("addNewFriend.jsp");
			dispatcher.forward(request, response);
		}
		else if(userAction.equals("blockUser"))
		{
			dispatcher=request.getRequestDispatcher("blockUser.jsp");
			dispatcher.forward(request, response);
		}
		else if(userAction.equals("searchUser"))
		{
			dispatcher=request.getRequestDispatcher("searchUser.jsp");
			dispatcher.forward(request, response);
		}
		else if(userAction.equals("viewBlockedList"))
		{
			dispatcher=request.getRequestDispatcher("viewBlockedList.jsp");
			dispatcher.forward(request, response);
		}
		else if(userAction.equals("viewFriendList"))
		{
			dispatcher=request.getRequestDispatcher("viewFriendList.jsp");
			dispatcher.forward(request, response);
		}
		else if(userAction.equals("viewContactList"))
		{
			dispatcher=request.getRequestDispatcher("viewContactList.jsp");
			dispatcher.forward(request, response);
		}
		
		if(request.getParameter("addNewContact").equals("addNewContact"))
		{
			List<Contact> contactList=service.viewContactList();
			String fullName=request.getParameter("fullName");
			String email=request.getParameter("email");
			
			/*
			 * set other parameters
			 * 
			 */
			
			contactList.add(new Contact());
			
			dispatcher=request.getRequestDispatcher("userResult.jsp");
			
		}
		if(request.getParameter("addNewFriend").equals("addNewFriend"))
		{
			List<Friend> friendList=service.viewFriendList();
			String fullName=request.getParameter("fullName");
			String email=request.getParameter("email");
			
			/*
			 * set other parameters
			 * 
			 */
			
			friendList.add(new Friend());
			
			dispatcher=request.getRequestDispatcher("userResult.jsp");
			
		}
		if(request.getParameter("blockUser").equals("blockUser"))
		{
			List<User> blockList=service.viewBlockedList();
			
			String blockUser=request.getParameter("blockUser");
			
			/*
			 * 
			 * 
			 */
			
			
			
			dispatcher=request.getRequestDispatcher("userResult.jsp");
			
		}
		
		
		
		
		//doGet(request, response);
	}

}