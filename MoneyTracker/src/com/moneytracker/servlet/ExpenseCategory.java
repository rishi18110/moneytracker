package com.moneytracker.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ExpenseCategory
 */
@WebServlet("/ExpenseCategory")
public class ExpenseCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExpenseCategory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		
		
		
	  // enter your content here
		
out.println("<div id=\"page\" class=\"container\">");	 
out.println("<div id=\"content\">");
out.println("<form id=\"categoriesForm\" name=\"categoriesForm\"  method=\"post\" action=\"CategoriesController\">");
out.println("<table border=\"1\">");
out.println("<tr>");
out.println(" <td id=\"expcat\" colspan=\"3\"><p>Expense Category</p></td>");
out.println("</tr>");
out.println("<tr>");
out.println("<td>Category Name</td>");
out.println("<td colspan=\"2\"><input type=\"text\" name=\"fname\"></td>"); 
out.println(" </tr>");
out.println("<tr>");
out.println("<td>Category Detail</td>");
out.println("<td colspan=\"2\" ><textarea name=\"comments\" id=\"comments\" ></textarea></td>");    
out.println("</tr>");
out.println("<tr>");
out.println("<td><button type=\"button\" >Submit</button></td>");
out.println("<td colspan=\"1.5\"><button type=\"button\">Cancel</button></td>");
out.println("</tr>");
out.println("</table>");
out.println("</form>");
out.println("</div>");

rd = request.getRequestDispatcher("SideBar");
rd.include(request, response);
rd = request.getRequestDispatcher("FooterDown");
rd.include(request, response);
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
