package com.money.moneytrackerdao;



import java.sql.*;
import java.util.*;

import com.money.moneytrackerpojo.ExpensesCategory;
import com.money.moneytrackerpojo.IncomeCategory;
import com.money.utilities.ConnectionPool;



public class ExpensesCategoryDao {
	public void create(ExpensesCategory expensescategory) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "insert into expenses_category (exp_catname , exp_catdetails ,userid) "
					+ "values(?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, expensescategory.getExp_catname());
			ps.setString(2, expensescategory.getExp_catdetails());
			ps.setInt(3, expensescategory.getUserid());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public void edit(ExpensesCategory expensescategory) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "update expenses_category "
					+ "set exp_catname = ?, exp_catdetails = ? , userid = ? where exp_catid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, expensescategory.getExp_catname());
			ps.setString(2, expensescategory.getExp_catdetails());
			ps.setInt(3, expensescategory.getUserid());
			ps.setInt(4, expensescategory.getExp_catid());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public void remove(int exp_catid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "delete from expenses_category where exp_catid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, exp_catid);
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public ExpensesCategory find(int exp_catid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ExpensesCategory expensescategory = new ExpensesCategory();
		try {
			String sql = "select * from expenses_category where exp_catid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, exp_catid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				expensescategory.setExp_catid(exp_catid);
				expensescategory.setExp_catname(rs.getString("exp_catname"));
				expensescategory.setExp_catdetails(rs.getString("exp_catdetails"));
				expensescategory.setUserid(rs.getInt("userid"));
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return expensescategory;
	}

	public ArrayList<ExpensesCategory> findAll() {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<ExpensesCategory> expensescategorylist = new ArrayList<ExpensesCategory>();
		try {
			String sql = "select * from expenses_category";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ExpensesCategory expensescategory = new ExpensesCategory();
				expensescategory.setExp_catid(rs.getInt("exp_catid"));
				expensescategory.setExp_catname(rs.getString("exp_catname"));
				expensescategory.setExp_catdetails(rs.getString("exp_catdetails"));
				expensescategory.setUserid(rs.getInt("userid"));
				expensescategorylist.add(expensescategory);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row.");
		} finally {
			pool.putConnection(conn);
		}
		return expensescategorylist;
	}
	public ArrayList<ExpensesCategory> findAll(int userid){
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<ExpensesCategory> expensescategorylist = new ArrayList<ExpensesCategory>();
		try {
			String sql = "select * from expenses_category where userid =?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,userid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ExpensesCategory expensesCategory = new ExpensesCategory();
				
				expensesCategory.setUserid(userid);
				expensesCategory.setExp_catid(rs.getInt("exp_catid"));
				expensesCategory.setExp_catname(rs.getString("exp_catname"));
				expensesCategory.setExp_catdetails(rs.getString("exp_catdetails"));
				
			}
		} catch (SQLException sq) {
			System.out.println("Unable to fetch a  row.");
		} finally {
			pool.putConnection(conn);
		}
		return expensescategorylist;
	}

	public static void main(String args[]) {

		// ExpensesCategory expensescategory = new ExpensesCategory("xyz","abc",2);
		// ExpensesCategoryDao expensescategoryDao = new ExpensesCategoryDao();
		//expensescategoryDao.create(expensescategory);

		//ExpensesCategory expensescategory = new ExpensesCategory(1,"SSS","abc",1);
		// ExpensesCategoryDao expensescategoryDao = new ExpensesCategoryDao();
		 //expensescategoryDao.edit(expensescategory);

		 //ExpensesCategoryDao expensescategoryDao = new ExpensesCategoryDao();
		// expensescategoryDao.remove(2);

		// ExpensesCategoryDao expensescategoryDao = new ExpensesCategoryDao();
		//ExpensesCategory expensescategory = expensescategoryDao.find(1);
		// System.out.println(expensescategory);

		ExpensesCategoryDao expensescategoryDao = new ExpensesCategoryDao();
		 ArrayList<ExpensesCategory> al = expensescategoryDao.findAll();
		for (ExpensesCategory expensescategory : al)
		System.out.println(expensescategory);

		// UsersDao userDao = new UsersDao();
		// ArrayList<Users> al = userDao.findAllByName("S");
		// for (Users user : al)
		// System.out.println(user);
	}


}
