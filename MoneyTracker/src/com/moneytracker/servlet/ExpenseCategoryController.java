package com.moneytracker.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.money.moneytrackerdao.ExpensesCategoryDao;
import com.money.moneytrackerpojo.ExpensesCategory;



/**
 * Servlet implementation class ExpenseCategoryController
 */
@WebServlet("/ExpenseCategoryController")
public class ExpenseCategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExpenseCategoryController() {
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
		int exp_catId = 0;
		if (request.getParameter("exp_catid") != null && request.getParameter("exp_catid").trim().length()>0)
			exp_catId = Integer.parseInt(request.getParameter("exp_catid"));
		String categoryName = request.getParameter("categoryName");
		if (categoryName == null) {
			categoryName = new String();
		}
		String categoryDetails = request.getParameter("categoryDetails");
		if (categoryDetails == null) {
			categoryDetails = new String();
		}
		String operation = request.getParameter("operation");
		if (operation == null) {
			operation = new String();
		}
		int userid = 0;
		if (request.getParameter("userid") != null && request.getParameter("userid").trim().length()>0)
			exp_catId = Integer.parseInt(request.getParameter("userid"));
		
		ExpensesCategoryDao catDao = new ExpensesCategoryDao();

		if (operation.equals("create")) {
			ExpensesCategory cat = new ExpensesCategory (exp_catId, categoryName, categoryDetails,userid);
			catDao.create(cat);
		} else if (operation.equals("edit")) {
			ExpensesCategory cat = new ExpensesCategory (exp_catId, categoryName, categoryDetails,userid);
			catDao.edit(cat);
		} else if (operation.equals("remove")) {
			ExpensesCategory cat = new ExpensesCategory (exp_catId);
		} 

		ArrayList<ExpensesCategory> catList = catDao.findAll();
		request.setAttribute("catList", catList);
		RequestDispatcher rd = request.getRequestDispatcher("ExpenseCategory");
		rd.forward(request, response);

	}

}
