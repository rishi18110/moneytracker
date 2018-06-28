package com.personal.money;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FooterDown
 */
@WebServlet("/FooterDown")
public class FooterDown extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FooterDown() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		out.println("<div id=\"copyright\" class=\"container\">");
		out.println("<p>&copy; Untitled. All rights reserved. | Photos by <a href=\"http://fotogrph.com/\">Razor</a> | Design by <a href=\"http://templated.co\" rel=\"nofollow\">Razor</a>.</p>");
			out.println("</div>");
	}

	
}
