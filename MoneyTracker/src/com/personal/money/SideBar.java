package com.personal.money;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SideBar
 */
@WebServlet("/SideBar")
public class SideBar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SideBar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
	out.println("<div id=\"sidebar\">");
	out.println("<div class=\"box2\">");
	out.println("<div class=\"title\">");
	out.println("<h2>Masters</h2>");
		out.println("</div>");
		out.println("<ul class=\"style2\">");
		out.println("<li><a href=\"http://localhost:8082/MoneyTracker/ExpenseCategory\">Expense Category</a></li>");
		out.println("<li><a href=\"http://localhost:8082/MoneyTracker/IncomeCategory\">Income Category</a></li>");
		out.println("<li><a href=\"http://localhost:8082/MoneyTracker/Expenses\">Expenses </a></li>");
		out.println("<li><a href=\"#\">CashBook </a></li>");
		out.println("<li><a href=\"#\">BankBook</a></li>");
		out.println("<li><a href=\"#\">DayBook </a></li>");
		out.println("<li><a href=\"#\">BalanceSheet</a></li>");
		out.println("</ul>");	
		out.println("</div>");
		out.println("</div>");
		out.println("</div>");
		out.println("</div>");
	}

}
