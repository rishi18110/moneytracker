package com.moneytracker.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.money.moneytrackerdao.UsersDao;
import com.money.moneytrackerpojo.Users;


/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistrationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		System.out.println(name);
		String username = request.getParameter("username");
		System.out.println(username);
		String email = request.getParameter("email");
		System.out.println(email);
		String address = request.getParameter("address");
		System.out.println(address);
		String mobile = request.getParameter("mobile");
		System.out.println(mobile);
		String password = request.getParameter("password");
		System.out.println(password);
		
		
		if (name != null && email != null && mobile!=null && username != null && address!=null && password!=null ) {
			//java.util.Date dtDob = DateUtils.convertDate(dob);
			//Customer c = new Customer(name, email, dtDob);
			UsersDao userdao = new UsersDao();
	
			Users user = new Users(name,username,email,mobile,address,password);
			userdao.create(user);
			//CustomersDao cd = new CustomersDao();
			//cd.create(c);
		}
		response.sendRedirect("LoginServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		doGet(request, response);
	}

}
