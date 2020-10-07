package com.training.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.daos.UserDaoImpl;


/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDaoImpl service = null;
	RequestDispatcher dispatcher=null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        this.service = new UserDaoImpl();
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
		
//		String login=request.getParameter("submit");
//		
//		if(login.equals("userLogin"))
//		{
//			String userName=request.getParameter("userName");
//			String password=request.getParameter("password");
//			if(userName.equals(password))
//			{
//				String fullName=service.findUser(userName);
//				
//				request.setAttribute("fullName", fullName);
//				dispatcher=request.getRequestDispatcher("userHome.jsp");
//				dispatcher.forward(request, response);
//			}
//		}
//		else if(login.equals("userSignUp"))
//		{
//			String userName=request.getParameter("userName");
//			String fullName=request.getParameter("fullName");
//			
//			service.addUser(new User(0,fullName,userName,"female"));
//			request.setAttribute("fullName", fullName);
//			
//			dispatcher=request.getRequestDispatcher("userHome.jsp");
//			dispatcher.forward(request, response);
//		}
		
		//doGet(request, response);
	}

}
