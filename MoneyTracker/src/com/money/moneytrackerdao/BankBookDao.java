package com.money.moneytrackerdao;


import java.sql.*;
import java.util.*;



import com.money.moneytrackerpojo.BankBook;
import com.money.utilities.ConnectionPool;
import com.money.utilities.DateUtils;



public class BankBookDao {
	public void create(BankBook bankbook) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "insert into bank_book (account, tran_date , amount , userid , operation ) "
					+ "values(?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, bankbook.getAccount());
			java.sql.Date dt = new java.sql.Date(bankbook.getTran_date().getTime());
			ps.setDate(2, dt);
			ps.setDouble(3, bankbook.getAmount());
			ps.setInt(4, bankbook.getUserid());
			ps.setString(5,bankbook.getOperation());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}
	
	public ArrayList<BankBook> findAllDateWise(String sdate, String edate, int userId){
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		
		java.util.Date dt1 = DateUtils.convertDate(sdate);
		java.util.Date dt2 = DateUtils.convertDate(edate);
	
//		System.out.println(dt1);
//		System.out.println(dt2);
//		
		ArrayList<BankBook> bankbooks = new ArrayList<BankBook>();
		try {
			String sql = "select * from bank_book where userid=? and tran_date between ? and ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ps.setDate(2, new java.sql.Date(dt1.getTime()));
			ps.setDate(3, new java.sql.Date(dt2.getTime()));
			ResultSet rs = ps.executeQuery();
//			System.out.println(userId);
//			System.out.println( new java.sql.Date(dt1.getTime()));
//			System.out.println( new java.sql.Date(dt1.getTime()));
			
			while (rs.next()) {
				BankBook bankbook = new BankBook();
				bankbook.setAcid(rs.getInt("acid"));
				bankbook.setAccount(rs.getString("account"));
				java.sql.Date dt = rs.getDate("tran_date");
				bankbook.setTran_date(new java.util.Date(dt.getTime()));
				bankbook.setAmount(rs.getDouble("amount"));
				bankbook.setUserid(rs.getInt("userid"));
				bankbook.setOperation(rs.getString("operation"));
				bankbooks.add(bankbook);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row.");
		} finally {
			pool.putConnection(conn);
		}
		return bankbooks;
}

	public void edit(BankBook bankbook) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "update bank_book "
					+ "set account = ?,tran_date = ?, amount = ? ,userid = ? ,operation = ?  where acid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, bankbook.getAccount());
			java.sql.Date dt = new java.sql.Date(bankbook.getTran_date().getTime());
			ps.setDate(2, dt);
			ps.setDouble(3, bankbook.getAmount());
			ps.setInt(4, bankbook.getUserid());
			ps.setString(5,bankbook.getOperation());
			ps.setInt(6, bankbook.getAcid());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}
	public double closingBalance(int userid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		
		double closingBal = 0.0;
		try{
			String sql = "select(SELECT sum(amount) as total_payment FROM bank_book b where userid = ? and operation ='receive') - (SELECT sum(amount) as total_receivied FROM bank_book b where userid = ? and operation='pay') as 'Closing Balance' from dual";
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
		

	public void remove(int acid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "delete from bank_book where acid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, acid);
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public BankBook find(int acid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		BankBook bankbook = new BankBook();
		try {
			String sql = "select * from bank_book where acid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, acid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				bankbook.setAcid(acid);
				bankbook.setAccount(rs.getString("account"));
				java.sql.Date dt = rs.getDate("tran_date");
				bankbook.setTran_date(new java.util.Date(dt.getTime()));
				bankbook.setAmount(rs.getDouble("amount"));
				bankbook.setUserid(rs.getInt("userid"));
				bankbook.setOperation(rs.getString("operation"));		
				}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return bankbook;
	}

	public ArrayList<BankBook> findAll() {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<BankBook> bankbooks = new ArrayList<BankBook>();
		try {
			String sql = "select * from bank_book";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				BankBook bankbook = new BankBook();
				bankbook.setAcid(rs.getInt("acid"));
				bankbook.setAccount(rs.getString("account"));
				java.sql.Date dt = rs.getDate("tran_date");
				bankbook.setTran_date(new java.util.Date(dt.getTime()));
				bankbook.setAmount(rs.getDouble("amount"));
				bankbook.setUserid(rs.getInt("userid"));
				bankbook.setOperation(rs.getString("operation"));
				bankbooks.add(bankbook);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row.");
		} finally {
			pool.putConnection(conn);
		}
		return bankbooks;
	}

	public static void main(String args[]) {
		 //java.util.Date dt = DateUtils.convertDate("24-10-2015");
		 //BankBook bankbook = new BankBook("xyz",dt,20000d,1,"deposit");
		// BankBookDao bankbook1``````Dao = new BankBookDao();
		// bankbookDao.create(bankbook);

		//BankBook bankbook = new BankBook(1,"abc",dt,20000d,1,"deposit");
		// BankBookDao bankbookDao = new BankBookDao();
		// bankbookDao.edit(bankbook);

		// BankBookDao bankbookDao = new BankBookDao();
		// bankbookDao.remove(2);

		 //BankBookDao bankbookDao = new BankBookDao();
		 //BankBook bankbook = bankbookDao.find(1);
		 //System.out.println(bankbook);

//		 BankBookDao bankbookDao = new BankBookDao();
//		 double bankbook = bankbookDao.closingBalance(1);
//		 System.out.println(bankbook);
//		
		//BankBookDao bankbookDao = new BankBookDao();
		 //ArrayList<BankBook> al = bankbookDao.findAll();
		//for (BankBook bankbook : al)
		//System.out.println(bankbook);

		// BankBookDao bankbookDao = new BankBookDao();
		// ArrayList<BankBook> al = bankbookDao.findAllByName("S");
		// for (BankBook bankbook : al)
		// System.out.println(bankbook);
	
//		 BankBookDao bankbookDao = new BankBookDao();
//		 ArrayList<BankBook> al = bankbookDao.findAllDateWise("2016-11-09", "2016-11-10", 1);
//		 for (BankBook bankbook : al)
//		 System.out.println(bankbook);
	}

}
