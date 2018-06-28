package com.money.moneytrackerdao;


import com.money.moneytrackerpojo.BankBook;
import com.money.moneytrackerpojo.CashBook;
import com.money.utilities.ConnectionPool;
import com.money.utilities.DateUtils;

import java.sql.*;
import java.util.*;



public class CashBookDao {
	public void create(CashBook cashbook) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "insert into cash_book (account, tran_date , amount , userid , operation ) "
					+ "values(?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, cashbook.getAccount());
			java.sql.Date dt = new java.sql.Date(cashbook.getTran_date().getTime());
			ps.setDate(2, dt);
			ps.setDouble(3, cashbook.getAmount());
			ps.setInt(4, cashbook.getUserid());
			ps.setString(5,cashbook.getOperation());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public void edit(CashBook cashbook) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "update cash_book "
					+ "set account = ?,tran_date = ?, amount = ? ,userid = ? ,operation = ?  where acid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, cashbook.getAccount());
			java.sql.Date dt = new java.sql.Date(cashbook.getTran_date().getTime());
			ps.setDate(2, dt);
			ps.setDouble(3, cashbook.getAmount());
			ps.setInt(4, cashbook.getUserid());
			ps.setString(5,cashbook.getOperation());
			ps.setInt(6, cashbook.getAcid());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public void remove(int acid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "delete from cash_book where acid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, acid);
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public CashBook find(int acid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		CashBook cashbook = new CashBook();
		try {
			String sql = "select * from cash_book where acid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, acid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				cashbook.setAcid(acid);
				cashbook.setAccount(rs.getString("account"));
				java.sql.Date dt = rs.getDate("tran_date");
				cashbook.setTran_date(new java.util.Date(dt.getTime()));
				cashbook.setAmount(rs.getDouble("amount"));
				cashbook.setUserid(rs.getInt("userid"));
				cashbook.setOperation(rs.getString("operation"));		
				}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return cashbook;
	}

	public ArrayList<CashBook> findAll() {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<CashBook> cashbook = new ArrayList<CashBook>();
		try {
			String sql = "select * from cash_book";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CashBook cashbooks = new CashBook();
				cashbooks.setAcid(rs.getInt("acid"));
				cashbooks.setAccount(rs.getString("account"));
				java.sql.Date dt = rs.getDate("tran_date");
				cashbooks.setTran_date(new java.util.Date(dt.getTime()));
				cashbooks.setAmount(rs.getDouble("amount"));
				cashbooks.setUserid(rs.getInt("userid"));
				cashbooks.setOperation(rs.getString("operation"));
				cashbook.add(cashbooks);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row.");
		} finally {
			pool.putConnection(conn);
		}
		return cashbook;
	}
	
	public ArrayList<CashBook> findAllDateWise(String sdate, String edate, int userId){
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		
		java.util.Date dt1 = DateUtils.convertDate(sdate);
		java.util.Date dt2 = DateUtils.convertDate(edate);
	
	System.out.println(dt1);
		System.out.println(dt2);
//		
		ArrayList<CashBook> cashbooksList = new ArrayList<CashBook>();
		try {
			String sql = "select * from cash_book where userid=? and tran_date between ? and ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ps.setDate(2, new java.sql.Date(dt1.getTime()));
			ps.setDate(3, new java.sql.Date(dt2.getTime()));
			
			ResultSet rs = ps.executeQuery();
			
			System.out.println(userId);
			System.out.println( new java.sql.Date(dt1.getTime()));
			System.out.println( new java.sql.Date(dt2.getTime()));
			
			while (rs.next()) {
				CashBook cashbooks = new CashBook();
				cashbooks.setAcid(rs.getInt("acid"));
				cashbooks.setAccount(rs.getString("account"));
				java.sql.Date dt = rs.getDate("tran_date");
				cashbooks.setTran_date(new java.util.Date(dt.getTime()));
				cashbooks.setAmount(rs.getDouble("amount"));
				cashbooks.setUserid(rs.getInt("userid"));
				cashbooks.setOperation(rs.getString("operation"));
				cashbooksList.add(cashbooks);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row.");
		} finally {
			pool.putConnection(conn);
		}
		return cashbooksList;
		
}

	public double closingBalance(int userid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		
		double closingBal = 0.0;
		try{
			String sql = "select(SELECT sum(amount) as total_payment FROM cash_book b where userid = ? and operation ='receive') - (SELECT sum(amount) as total_receivied FROM cash_book b where userid = ? and operation='pay') as 'Closing Balance' from dual";
			//System.out.println(sql);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userid);
			ps.setInt(2, userid);
			ResultSet rs = ps.executeQuery();
			rs.next();
			String  value = rs.getString("Closing Balance");
			System.out.println(value);
			if (value != null){
			closingBal= Double.parseDouble(value);
			}
				
			}catch (SQLException sq) {
					System.out.println("Unable to create a new row." + sq);
			} finally {
					pool.putConnection(conn);
			}
		return closingBal;
	}


	public static void main(String args[]) {
		// java.util.Date dt = DateUtils.convertDate("24-10-2015");
		// CashBook cashbook = new CashBook("xyz",dt,20000d,1,"deposit");
		 //CashBookDao cashbookDao = new CashBookDao();
		 //cashbookDao.create(cashbook);

		//CashBook cashbook = new CashBook(1,"abc",dt,20000d,1,"deposit");
		// CashBookDao cashbookDao = new CashBookDao();
		// cashbookDao.edit(cashbook);

		// CashBookDao cashbookDao = new CashBookDao();
		 //cashbookDao.remove(2);

		 //CashBookDao cashbookDao = new CashBookDao();
		 //CashBook cashbook = cashbookDao.find(1);
		 //System.out.println(cashbook);

		//CashBookDao cashbookDao = new CashBookDao();
		// ArrayList<CashBook> al = cashbookDao.findAll();
		//for (CashBook cashbook : al)
		//System.out.println(cashbook);
		
		
//		CashBookDao cashbookDao = new CashBookDao();
//		double cashbook = cashbookDao.closingBalance(2);
//		System.out.println(cashbook);

		// CashBookDao cashbookDao = new CashBookDao();
		// ArrayList<CashBook> al = cashbookDao.findAllByName("S");
		// for (CashBook cashbook : al)
		// System.out.println(cashbook);
		 
//		 	CashBookDao cashbookDao = new CashBookDao();
//			 ArrayList<CashBook> al = cashbookDao.findAllDateWise("2016-10-01", "2016-10-03", 2);
//			 for (CashBook cashbook : al)
//			 System.out.println(cashbook);
//		 

	
	
	}

}
