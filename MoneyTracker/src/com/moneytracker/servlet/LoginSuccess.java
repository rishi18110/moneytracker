package com.moneytracker.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginSuccess
 */
@WebServlet("/LoginSuccess")
public class LoginSuccess extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginSuccess() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">");
		out.println("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
		out.println("<head>");
		out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");
		out.println("<title>MoneyTracker</title>");
		out.println("<meta name=\"keywords\" content=\"\" />");
		out.println("<meta name=\"description\" content=\"\" />");
		out.println("<link href=\"http://fonts.googleapis.com/css?family=Chivo:400,900\" rel=\"stylesheet\"/>");
		out.println("<link href=\"temp5/default.css\" rel=\"stylesheet\" type=\"text/css\" media=\"all\"/>");
		out.println("<link href=\"temp5/fonts.css\" rel=\"stylesheet\" type=\"text/css\" media=\"all\" />");
		
		out.println("<link href=\"temp5/default_ie6.css\" rel=\"stylesheet\" type=\"text/css\"/>");
		out.println("</head>");
		out.println("<body>");
		
		RequestDispatcher rd = null;
		rd = request.getRequestDispatcher("Header");
		rd.include(request, response);
		
		
		out.println("<div id=\"page\" class=\"container\">");
		out.println("<div id=\"content\">");
		out.println("<div class=\"title\">");
		out.println("<h2>MoneyAccounting</h2>");
		out.println("<span class=\"byline\">Phasellus nec erat sit amet nibh pellentesque congue</span> </div>");
		out.println("<p>This is <strong>ClearFigure</strong>, a free, fully standards-compliant CSS template designed by <a href=\"http://templated.co\" rel=\"nofollow\">TEMPLATED</a>. The photos in this template are from <a href=\"http://fotogrph.com/\"> Fotogrph</a>. This free template is released under the <a href=\"http://templated.co/license\">Creative Commons Attribution</a> license, so you're pretty much free to do whatever you want with it (even use it commercially) provided you give us credit for it. Have fun :) </p>");
		out.println("<p>Consectetuer adipiscing elit. Nam pede erat, porta eu, lobortis eget, tempus et, tellus. Etiam neque. Vivamus consequat lorem at nisl. Nullam non wisi a sem semper eleifend. Donec mattis libero eget urna. Duis pretium velit ac mauris. Proin eu wisi suscipit nulla suscipit interdum. Aenean lectus lorem, imperdiet at, ultrices eget, ornare et, wisi. Pellentesque adipiscing purus ac magna. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.  Nullam non wisi a sem semper eleifend. Donec mattis libero eget urna. </p>");
		out.println("</div>");
		
		
		rd = request.getRequestDispatcher("SideBar");
		rd.include(request, response);
		rd = request.getRequestDispatcher("FooterUp");
		rd.include(request, response);
		rd = request.getRequestDispatcher("FooterDown");
		rd.include(request, response);
		
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
