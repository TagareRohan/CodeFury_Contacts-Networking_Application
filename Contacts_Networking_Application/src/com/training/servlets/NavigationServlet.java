package com.training.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NavigationServlet
 */
@WebServlet("/NavigationServlet")
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
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
		
		if(input.equals("userLogin"))
		{
			dispatcher=request.getRequestDispatcher("userLogin.jsp");
		}
		else if(input.equals("userSignup"))
		{
			dispatcher=request.getRequestDispatcher("userSignup.jsp");
		}
		else if(input.equals("userLogin"))
		{
			dispatcher=request.getRequestDispatcher("userLogin.jsp");
		}
		
		dispatcher.forward(request, response);
		//doGet(request, response);
	}

}
