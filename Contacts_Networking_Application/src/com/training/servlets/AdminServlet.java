package com.training.servlets;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.models.User;
import com.training.services.AdminDaoImpl;
import com.training.services.VerificationService;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminDaoImpl service;
	RequestDispatcher dispatcher;
	VerificationService verify;

    /**
     * Default constructor. 
     */
    public AdminServlet() {
        // TODO Auto-generated constructor stub
    	service=new AdminDaoImpl();
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
		
		
		
		String adminAction=request.getParameter("adminAction");
		
		if(request.getSession(false)==null)
		{
			dispatcher=request.getRequestDispatcher("index.html");
			dispatcher.forward(request, response);
		}
		else
		{
			if(adminAction.equals("showSummary"))
			{
				Collection<User> allUsers=service.showSummary();
				
				request.setAttribute("summary", allUsers);
				
				dispatcher=request.getRequestDispatcher("showSummary.jsp");
				dispatcher.forward(request, response);
			}
			else if(adminAction.equals("disableUser"))
			{
				Collection<User> userList=service.viewUsersToDisable();
				
				ArrayList<String> users=null;
				
				for(User use: userList)
				{
					users.add(use.getUsername());
				}
				
				request.setAttribute("disableList", users);
				
				dispatcher=request.getRequestDispatcher("disableUser.jsp");
				dispatcher.forward(request, response);
			}
			else if(adminAction.equals("deleteUser"))
			{
				Collection<User> userList=service.viewUsersToDelete();
				
				ArrayList<String> users=null;
				
				for(User use: userList)
				{
					users.add(use.getUsername());
				}
				
				request.setAttribute("deleteList", users);
				
				dispatcher=request.getRequestDispatcher("deleteUser.jsp");
				dispatcher.forward(request, response);
			}
			
			
			if(request.getParameter("deleteUsers").equals("deleteUsers"))
			{
				String[] userList=request.getParameterValues("deleteList");
				
				int[] userIdList=null;
				
				for(int i=0;i<userList.length;i++)
				{
					userIdList[i]=Integer.parseInt(userList[i]);
				}
				
				
				for(int userId: userIdList)
				{
					service.deleteUser(userId);
				}
				
				request.setAttribute("status", "operation successful");
				dispatcher=request.getRequestDispatcher("adminResult.jsp");
				dispatcher.forward(request, response);			}
			
			if(request.getParameter("disableUsers").equals("disableUsers"))
			{
				String[] userList=request.getParameterValues("disableList");
				
				int[] userIdList=null;
				
				for(int i=0;i<userList.length;i++)
				{
					userIdList[i]=Integer.parseInt(userList[i]);
				}
				
				
				for(int userId: userIdList)
				{
					service.disableUser(userId);
				}
				
				request.setAttribute("status", "operation successful");
				dispatcher=request.getRequestDispatcher("adminResult.jsp");
				dispatcher.forward(request, response);
			}
			
			if(request.getParameter("backToHome").equals("backToHome"))
			{
				dispatcher=request.getRequestDispatcher("adminHome.jsp");
				dispatcher.forward(request, response);
			}
		}
		
		
		
		//doGet(request, response);
	}

}