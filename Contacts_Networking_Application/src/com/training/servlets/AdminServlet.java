package com.training.servlets;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.dao.AdminServiceImpl;
import com.training.dao.Verification;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminServiceImpl service;
	RequestDispatcher dispatcher;
	Verification verify;

    /**
     * Default constructor. 
     */
    public AdminServlet() {
        // TODO Auto-generated constructor stub
    	service=new AdminServiceImpl();
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
		
		if(request.getParameter("submit").equals("adminLogin"))
		{
			String adminUserName=request.getParameter("adminUserName");
			String password=request.getParameter("password");
			if(verify.verifyAdmin(adminUserName,password))
			{
						
				request.setAttribute("userName", adminUserName);
				dispatcher=request.getRequestDispatcher("adminHome.jsp");
				dispatcher.forward(request, response);
			}
			
		}
		
		String adminAction=request.getParameter("adminAction");
		
		if(adminAction.equals("searchUser"))
		{
			dispatcher=request.getRequestDispatcher("searchUser.jsp");
			dispatcher.forward(request, response);
		}
		else if(adminAction.equals("disableUser"))
		{
			Map<String,String> userList=service.viewUsersToDisable();
			request.setAttribute("disableList", userList);
			
			dispatcher=request.getRequestDispatcher("disableUser.jsp");
			dispatcher.forward(request, response);
		}
		else if(adminAction.equals("deleteUser"))
		{
			Map<String,String> userList=service.viewUsersToDelete();
			request.setAttribute("deleteList", userList);
			
			dispatcher=request.getRequestDispatcher("deleteUser.jsp");
			dispatcher.forward(request, response);
		}
		
		if(request.getParameter("searchUser").equals("searchUser"))
		{
			String userName=request.getParameter("userName");
			
			Map<String,String> userList=service.searchUser(userName);
			request.setAttribute("result", userList);			
			
			dispatcher=request.getRequestDispatcher("adminResult.jsp");
			dispatcher.forward(request, response);
			
		}
		
		if(request.getParameter("deleteUsers").equals("deleteUsers"))
		{
			String[] userList=request.getParameterValues("deleteList");
			
			for(String user: userList)
			{
				service.deleteUser(user);
			}
			
			dispatcher=request.getRequestDispatcher("adminResult.jsp");
		}
		
		if(request.getParameter("disableUsers").equals("disableUsers"))
		{
			String[] userList=request.getParameterValues("disableList");
			
			for(String user: userList)
			{
				service.disableUser(user);
			}
			
			dispatcher=request.getRequestDispatcher("adminResult.jsp");
		}
		
		//doGet(request, response);
	}

}