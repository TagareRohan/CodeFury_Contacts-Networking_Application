package com.training.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.dao.Verification;
import com.training.models.User;

/**
 * Servlet implementation class NavigationServlet
 */
@WebServlet("/NavigationServlet")
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Verification verify;
	
	RequestDispatcher dispatcher=null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavigationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String input=request.getParameter("submit");
		
		if(input.equals("adminLogin"))
		{
			dispatcher=request.getRequestDispatcher("adminLogin.jsp");
		}
		else if(input.equals("userSignup"))
		{
			dispatcher=request.getRequestDispatcher("userSignup.jsp");
		}
		else if(input.equals("userLogin"))
		{
			dispatcher=request.getRequestDispatcher("userLogin.jsp");
		}
		
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
			
			verify.registerUser(new User());
			
			request.setAttribute("userName", userName);
			
			dispatcher=request.getRequestDispatcher("userLogin.jsp");
			dispatcher.forward(request, response);
		}
		
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
		
		//doGet(request, response);
	}

}