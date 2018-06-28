package com.personal.money;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Header
 */
@WebServlet("/Header")
public class Header extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Header() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

out.println("<div id=\"wrapper\">");
out.println("<div id=\"header-wrapper\">");
out.println("<div id=\"header\" class=\"container\">");
out.println("<div id=\"logo\">");
out.println("<h1><a href=\"#\">MoneyTracker</a></h1>");
out.println("<p>TrackMoney <a href=\"http://templated.co\" rel=\"nofollow\">SaveMoney</a></p>");
out.println("</div>");
out.println("</div>");
out.println("</div>");
out.println("<div id=\"menu-wrapper\">");
out.println("<div id=\"menu\" class=\"container\">");
out.println("<ul>");
out.println("<li class=\"current_page_item\"><a href=\"#\">Homepage</a></li>");
out.println("<li><a href=\"#\">About</a></li>");
out.println("<li><a href=\"#\">Portfolio</a></li>");
out.println("<li><a href=\"#\">Blog</a></li>");
out.println("<li><a href=\"http://localhost:8083/MoneyTracker/LogoutServlet\"> Logout </a></li>");
out.println("</ul>");
out.println("</div>");
out.println("	</div>");
	
				
	
		
	}

	
	

}
