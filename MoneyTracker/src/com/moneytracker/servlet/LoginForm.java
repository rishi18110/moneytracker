package com.moneytracker.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.money.moneytrackerdao.UsersDao;
import com.money.moneytrackerpojo.Users;


/**
 * Servlet implementation class LoginForm
 */
@WebServlet("/LoginForm")
public class LoginForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginForm() {
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
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		
		System.out.println("email : " + email);
		System.out.println("password: " + password);
		
		if ( email == null && password == null)
			response.sendRedirect("LoginForm");
		
		Users user1 = UsersDao.authenticate(email,password);
		System.out.println(user1);
		
		if (user1.getPassword()!= null) {
			HttpSession session = request.getSession();
			
			session.setAttribute("username", user1.getName());
			
			session.setAttribute("userEmail", email);
			response.sendRedirect("LoginSuccess");
		} else {
			response.sendRedirect("LoginServlet");
		}
		
		
		
	}

}
