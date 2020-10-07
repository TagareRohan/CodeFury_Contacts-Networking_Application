package com.training.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.daos.AdminDaoImpl;



/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminDaoImpl service = null;
	RequestDispatcher dispatcher = null;

    /**
     * Default constructor. 
     */
    public AdminServlet() {
        // TODO Auto-generated constructor stub
    	this.service=new AdminDaoImpl();
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
		
//		if(request.getParameter("submit").equals("adminLogin"))
//		{
//			String adminUserName=request.getParameter("adminUserName");
//			String password=request.getParameter("password");
//			if(adminUserName.equals(password))
//			{
//				String fullName=service.findUser(adminUserName);
//				
//				request.setAttribute("fullName", fullName);
//				dispatcher=request.getRequestDispatcher("adminHome.jsp");
//				dispatcher.forward(request, response);
//			}
//		}
		
		//doGet(request, response);
	}

}
