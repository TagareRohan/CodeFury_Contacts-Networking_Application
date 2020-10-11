package com.training.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.training.models.Contact;
import com.training.models.Person;
import com.training.models.User;
import com.training.services.UserDaoImpl;
import com.training.services.VerificationService;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDispatcher dispatcher=null;
	UserDaoImpl service;
	VerificationService verify;
	HttpSession session;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
        verify=new VerificationService();
        service=new UserDaoImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String userAction=request.getParameter("userAction");
		session=request.getSession(false);

		
		if(request.getSession(false)==null)
		{
			dispatcher=request.getRequestDispatcher("index.html");
			dispatcher.forward(request, response);
		}
		else
		{
			if(userAction.equals("addNewContact"))
			{
				dispatcher=request.getRequestDispatcher("addNewContact.jsp");
				dispatcher.forward(request, response);
			}
			
			else if(userAction.equals("viewFriendRequests"))
			{
				Collection<User> friendRequests=service.viewFriendRequests((Integer)session.getAttribute("sessionId"));
				
				request.setAttribute("friendRequests", friendRequests);
				
				dispatcher=request.getRequestDispatcher("viewFriendRequest.jsp");
				dispatcher.forward(request, response);
			}
			
			else if(userAction.equals("searchUser"))
			{
				dispatcher=request.getRequestDispatcher("searchUser.jsp");
				dispatcher.forward(request, response);
			}
			
			else if(userAction.equals("viewBlockedList"))
			{
				
				Collection<User> blockedUsers=service.viewBlockedUsers((Integer)session.getAttribute("sessionId"));
				
				request.setAttribute("blockedList", blockedUsers);
				
				dispatcher=request.getRequestDispatcher("viewBlockedList.jsp");
				dispatcher.forward(request, response);
			}
			
			else if(userAction.equals("viewFriendList"))
			{
				Collection<User> friendList=service.viewFriends((Integer)session.getAttribute("sessionId"));
				
				request.setAttribute("friendList", friendList);
				dispatcher=request.getRequestDispatcher("viewFriendList.jsp");
				dispatcher.forward(request, response);
			}
			
			else if(userAction.equals("viewContactList"))
			{
				Collection<Contact> contactList=service.viewContacts((Integer)session.getAttribute("sessionId"));
				
				request.setAttribute("contactList",contactList);
				dispatcher=request.getRequestDispatcher("viewContactList.jsp");
				dispatcher.forward(request, response);
			}
			
			else if(userAction.equals("backToHome"))
			{
				dispatcher=request.getRequestDispatcher("userHome.jsp");
				dispatcher.forward(request, response);
			}
			
			else if(userAction.equals("userLogout"))
			{
				session.invalidate();
				dispatcher=request.getRequestDispatcher("index.html");
				dispatcher.forward(request, response);
			}
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		session=request.getSession(false);
		
		String userAction=request.getParameter("userAction");
		
		if(request.getSession(false)==null)
		{
			dispatcher=request.getRequestDispatcher("index.html");
			dispatcher.forward(request, response);
		}
		else
		{	
			System.out.println(userAction);
			if(userAction.equals("addNewContact"))
			{
				String fullName=request.getParameter("fullName");
				String email=request.getParameter("email");
				long phoneNumber=Long.parseLong(request.getParameter("phoneNumber"));
				String gender=request.getParameter("gender");
				LocalDate dateOfBirth=LocalDate.parse(request.getParameter("dateOfBirth"));
				System.out.println(dateOfBirth);
				String address=request.getParameter("address");
				String city=request.getParameter("city");
				String state=request.getParameter("state");
				String country=request.getParameter("country");
				String company=request.getParameter("company");
				byte[] image=request.getParameter("image").getBytes();
				
				service.addContact((Integer)session.getAttribute("sessionId"),
						new Contact(fullName, email, phoneNumber, gender, dateOfBirth,
								address, city, state, country,
								company, image));
				
				request.setAttribute("result", "Operation successful");
				dispatcher=request.getRequestDispatcher("userResult.jsp");
				dispatcher.forward(request, response);
				
			}
			if(userAction.equals("blockUser"))
			{
				int blockId=Integer.parseInt(request.getParameter("userId"));
				
				service.blockUser((Integer)session.getAttribute("userId"),blockId);
				
				request.setAttribute("result","Operation successful");
				dispatcher=request.getRequestDispatcher("userResult.jsp");
				dispatcher.forward(request, response);
				
			}
			if(userAction.equals("unBlockUser"))
			{
				int blockId=Integer.parseInt(request.getParameter("userId"));
				
				service.unblockUser((Integer)session.getAttribute("userId"),blockId);
				
				request.setAttribute("result","Operation successful");
				dispatcher=request.getRequestDispatcher("userResult.jsp");
				dispatcher.forward(request, response);
				
			}
			if(userAction.equals("sendRequest"))
			{
				int friendId=Integer.parseInt(request.getParameter("userId"));
				
				service.sendRequest((Integer)session.getAttribute("sessionId"),friendId);
				request.setAttribute("result","Operation successful");
				dispatcher=request.getRequestDispatcher("userResult.jsp");
				dispatcher.forward(request, response);
			}
			if(userAction.equals("declineRequest"))
			{
				int friendId=Integer.parseInt(request.getParameter("userId"));
				
				service.declineRequest((Integer)session.getAttribute("sessionId"),friendId);
				request.setAttribute("result","Operation successful");
				dispatcher=request.getRequestDispatcher("userResult.jsp");
				dispatcher.forward(request, response);
			}
			if(userAction.equals("addFriend"))
			{
				int friendId=Integer.parseInt(request.getParameter("userId"));
				
				service.addFriend((Integer)session.getAttribute("sessionId"),friendId);
				
				request.setAttribute("result","Operation successful");
				dispatcher=request.getRequestDispatcher("userResult.jsp");
				dispatcher.forward(request, response);
				
			}
			if(userAction.equals("searchUser"))
			{
				String name=request.getParameter("userName");
				
				Person user=service.searchUser(name);
				
				request.setAttribute("userInfo", user);
				dispatcher=request.getRequestDispatcher("userInfo.jsp");
				dispatcher.forward(request, response);
			}
			
			
		}
		
		
		
		
		
		
		//doGet(request, response);
	}

}