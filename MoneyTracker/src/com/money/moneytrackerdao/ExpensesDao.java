package com.money.moneytrackerdao;



import java.sql.*;
import java.util.*;

import com.money.moneytrackerpojo.BankBook;
import com.money.moneytrackerpojo.Expenses;
import com.money.utilities.ConnectionPool;
import com.money.utilities.DateUtils;



public class ExpensesDao {
	
	public void create(Expenses expenses) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "insert into expenses ( exp_ac ,userid , exp_catid , amount , tran_date , payby , remark) "
					+ "values(?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, expenses.getExp_ac());
			ps.setInt(2, expenses.getUserid());
			ps.setInt(3, expenses.getExp_catid());
			ps.setDouble(4, expenses.getAmount());
			java.sql.Date dt = new java.sql.Date(expenses.getTran_date().getTime());
			ps.setDate(5, dt);
			ps.setString(6, expenses.getPayby());
			ps.setString(7, expenses.getRemark());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}
	
	public ArrayList<Expenses> findAllDateWise(String sdate, String edate, int userId){
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		
		java.util.Date dt1 = DateUtils.convertDate(sdate);
		java.util.Date dt2 = DateUtils.convertDate(edate);
	
//		System.out.println(dt1);
//		System.out.println(dt2);
//		
		ArrayList<Expenses> listExpenses = new ArrayList<Expenses>();
		try {
			String sql = "select * from expenses where userid=? and tran_date between ? and ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ps.setDate(2, new java.sql.Date(dt1.getTime()));
			ps.setDate(3, new java.sql.Date(dt2.getTime()));
			ResultSet rs = ps.executeQuery();
//			System.out.println(userId);
//			System.out.println( new java.sql.Date(dt1.getTime()));
//			System.out.println( new java.sql.Date(dt1.getTime()));
			
			while (rs.next()) {
				Expenses expenses = new Expenses();
				expenses.setExp_id(rs.getInt("exp_id"));
				expenses.setExp_ac(rs.getString("exp_ac"));
				expenses.setUserid(rs.getInt("userid"));
				expenses.setExp_catid(rs.getInt("exp_catid"));
				expenses.setAmount(rs.getDouble("amount"));
				java.sql.Date dt = rs.getDate("tran_date");
				expenses.setTran_date(new java.util.Date(dt.getTime()));			expenses.setPayby(rs.getString("payby"));
				expenses.setRemark(rs.getString("remark"));			
				listExpenses.add(expenses);

			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row.");
		} finally {
			pool.putConnection(conn);
		}
		return listExpenses;
}


	public void edit(Expenses expenses) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "update expenses "
					+ "set exp_ac = ?,userid = ?, exp_catid = ? ,amount = ? ,tran_date = ? ,payby = ? ,remark = ? where exp_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, expenses.getExp_ac());
			ps.setInt(2, expenses.getUserid());
			ps.setInt(3, expenses.getExp_catid());
			ps.setDouble(4, expenses.getAmount());
			java.sql.Date dt = new java.sql.Date(expenses.getTran_date().getTime());
			ps.setDate(5, dt);
			ps.setString(6, expenses.getPayby());
			ps.setString(7, expenses.getRemark());
			ps.setInt(8, expenses.getExp_id());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public void remove(int exp_id) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "delete from expenses where exp_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, exp_id);
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public Expenses find(int exp_id) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		Expenses expenses = new Expenses();
		try {
			String sql = "select * from expenses where exp_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, exp_id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				expenses.setExp_id(exp_id);
				expenses.setExp_ac(rs.getString("exp_ac"));
				expenses.setUserid(rs.getInt("userid"));
				expenses.setExp_catid(rs.getInt("exp_catid"));
				expenses.setAmount(rs.getDouble("amount"));
				java.sql.Date dt = rs.getDate("tran_date");
				expenses.setTran_date(new java.util.Date(dt.getTime()));
				expenses.setPayby(rs.getString("payby"));
				expenses.setRemark(rs.getString("remark"));
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return expenses;
	}

	public ArrayList<Expenses> findAll() {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<Expenses> listExpenses = new ArrayList<Expenses>();
		try {
			String sql = "select * from expenses";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Expenses expenses = new Expenses();
				expenses.setExp_id(rs.getInt("exp_id"));
				expenses.setExp_ac(rs.getString("exp_ac"));
				expenses.setUserid(rs.getInt("userid"));
				expenses.setExp_catid(rs.getInt("exp_catid"));
				expenses.setAmount(rs.getDouble("amount"));
				java.sql.Date dt = rs.getDate("tran_date");
				expenses.setTran_date(new java.util.Date(dt.getTime()));			expenses.setPayby(rs.getString("payby"));
				expenses.setRemark(rs.getString("remark"));			
				listExpenses.add(expenses);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row.");
		} finally {
			pool.putConnection(conn);
		}
		return listExpenses;
	}
	
	public ArrayList<Expenses> findAll(int userid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<Expenses> listExpenses = new ArrayList<Expenses>();
		try {
			String sql = "select * from expenses where userid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,userid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Expenses expenses = new Expenses();
				expenses.setExp_id(rs.getInt("exp_id"));
				expenses.setExp_ac(rs.getString("exp_ac"));
				expenses.setUserid(userid);
				expenses.setExp_catid(rs.getInt("exp_catid"));
				expenses.setAmount(rs.getDouble("amount"));
				java.sql.Date dt = rs.getDate("tran_date");
				expenses.setTran_date(new java.util.Date(dt.getTime()));			
				expenses.setPayby(rs.getString("payby"));
				expenses.setRemark(rs.getString("remark"));			
				listExpenses.add(expenses);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row.");
		} finally {
			pool.putConnection(conn);
		}
		return listExpenses;
	}
	

	public static void main(String args[]) {
		java.util.Date dt = DateUtils.convertDate("24-10-2015");
		//Expenses expenses = new Expenses("xyz",1,1,2000d,dt,"cash","deposit");
		// ExpensesDao expensesDao = new ExpensesDao();
		//expensesDao.create(expenses);

		//Expenses expenses = new Expenses(1,"abc",1,1,2000d,dt,"cash","deposit");
		// ExpensesDao expensesDao = new ExpensesDao();
		//expensesDao.edit(expenses);

		 //ExpensesDao expensesDao = new ExpensesDao();
		// expensesDao.remove(2);

		// ExpensesDao expensesDao = new ExpensesDao();
		// Expenses expenses = expensesDao.find(1);
		// System.out.println(expenses);

		//ExpensesDao expensesDao = new ExpensesDao();
		// ArrayList<Expenses> al = expensesDao.findAll();
		//for (Expenses expenses : al)
		//System.out.println(expenses);
		
		

//		ExpensesDao expensesDao = new ExpensesDao();
//		 ArrayList<Expenses> al = expensesDao.findAll(1);
//		for (Expenses expenses : al)
//		System.out.println(expenses);
		
		ExpensesDao expensesDao = new ExpensesDao();
	ArrayList<Expenses> al = expensesDao.findAllDateWise("2016-09-15","2016-09-20", 1);
		for (Expenses expenses : al)
		System.out.println(expenses);
	}


}
