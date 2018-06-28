package com.money.moneytrackerdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.money.moneytrackerpojo.Expenses;
import com.money.moneytrackerpojo.Incomes;
import com.money.utilities.ConnectionPool;
import com.money.utilities.DateUtils;



public class IncomesDao {
	
	public void create(Incomes incomes) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "insert into incomes ( inc_ac ,userid , inc_catid , amount , tran_date , receiveby , remark) "
					+ "values(?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, incomes.getInc_ac());
			ps.setInt(2, incomes.getUserid());
			ps.setInt(3, incomes.getInc_catid());
			ps.setDouble(4, incomes.getAmount());
			java.sql.Date dt = new java.sql.Date(incomes.getTran_date().getTime());
			ps.setDate(5, dt);
			ps.setString(6, incomes.getReceiveby());
			ps.setString(7, incomes.getRemark());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public void edit(Incomes incomes) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "update incomes "
					+ "set inc_ac = ?,userid = ?, inc_catid = ? ,amount = ? ,tran_date = ? ,receiveby = ? ,remark = ? where inc_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, incomes.getInc_ac());
			ps.setInt(2, incomes.getUserid());
			ps.setInt(3, incomes.getInc_catid());
			ps.setDouble(4, incomes.getAmount());
			java.sql.Date dt = new java.sql.Date(incomes.getTran_date().getTime());
			ps.setDate(5, dt);
			ps.setString(6, incomes.getReceiveby());
			ps.setString(7, incomes.getRemark());
			ps.setInt(8, incomes.getInc_id());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public void remove(int inc_id) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "delete from incomes where inc_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, inc_id);
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public Incomes find(int inc_id) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		Incomes incomes = new Incomes();
		try {
			String sql = "select * from incomes where inc_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, inc_id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				incomes.setInc_id(inc_id);
				incomes.setInc_ac(rs.getString("inc_ac"));
				incomes.setUserid(rs.getInt("userid"));
				incomes.setInc_catid(rs.getInt("inc_catid"));
				incomes.setAmount(rs.getDouble("amount"));
				java.sql.Date dt = rs.getDate("tran_date");
				incomes.setTran_date(new java.util.Date(dt.getTime()));
				incomes.setReceiveby(rs.getString("receiveby"));
				incomes.setRemark(rs.getString("remark"));
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return incomes;
	}

	public ArrayList<Incomes> findAll() {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<Incomes> listIncomes = new ArrayList<Incomes>();
		try {
			String sql = "select * from incomes";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Incomes incomes = new Incomes();
				incomes.setInc_id(rs.getInt("inc_id"));
				incomes.setInc_ac(rs.getString("inc_ac"));
				incomes.setUserid(rs.getInt("userid"));
				incomes.setInc_catid(rs.getInt("inc_catid"));
				incomes.setAmount(rs.getDouble("amount"));
				java.sql.Date dt = rs.getDate("tran_date");
				incomes.setTran_date(new java.util.Date(dt.getTime()));
				incomes.setReceiveby(rs.getString("receiveby"));
				incomes.setRemark(rs.getString("remark"));			
				listIncomes.add(incomes);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row.");
		} finally {
			pool.putConnection(conn);
		}
		return listIncomes;
	}

	public ArrayList<Incomes> findAllDateWise(String sdate, String edate, int userId){
			ConnectionPool pool = ConnectionPool.getInstance();
			pool.initialize();
			Connection conn = pool.getConnection();
			
			java.util.Date dt1 = DateUtils.convertDate(sdate);
			java.util.Date dt2 = DateUtils.convertDate(edate);
		
	//	System.out.println(dt1);
	//		System.out.println(dt2);
			
			ArrayList<Incomes> listIncomes = new ArrayList<Incomes>();
			try {
				String sql = "select * from incomes where userid=? and tran_date between ? and ? ";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, userId);
				ps.setDate(2, new java.sql.Date(dt1.getTime()));
				ps.setDate(3, new java.sql.Date(dt2.getTime()));
				ResultSet rs = ps.executeQuery();
	//		System.out.println(userId);
	//		System.out.println( new java.sql.Date(dt1.getTime()));
	//			System.out.println( new java.sql.Date(dt2.getTime()));
				while (rs.next()) {
					Incomes incomes = new Incomes();
					incomes.setInc_id(rs.getInt("inc_id"));
					incomes.setInc_ac(rs.getString("inc_ac"));
					incomes.setUserid(rs.getInt("userid"));
					incomes.setInc_catid(rs.getInt("inc_catid"));
					incomes.setAmount(rs.getDouble("amount"));
					java.sql.Date dt = rs.getDate("tran_date");
					incomes.setTran_date(new java.util.Date(dt.getTime()));
					incomes.setReceiveby(rs.getString("receiveby"));
					incomes.setRemark(rs.getString("remark"));			
					listIncomes.add(incomes);
				}
			} catch (SQLException sq) {
				System.out.println("Unable to create a new row."+sq);
			} finally {
				pool.putConnection(conn);
			}
			return listIncomes;
	}

	public static void main(String args[]) {
		 //java.util.Date dt = DateUtils.convertDate("24-10-2015");
		//Incomes incomes = new Incomes("xyz",1,1,2000d,dt,"cash","deposit");
		// IncomesDao incomesDao = new IncomesDao();
		//incomesDao.create(incomes);

		//Incomes incomes = new Incomes(1,"abs",1,1,2000d,dt,"cash","deposit");
		// IncomesDao incomesDao = new IncomesDao();
		//incomesDao.edit(incomes);

		// IncomesDao incomesDao = new IncomesDao();
		// incomesDao.remove(2);

		 //IncomesDao incomesDao = new IncomesDao();
		// Incomes incomes = incomesDao.find(1);
		// System.out.println(incomes);

		//IncomesDao incomesDao = new IncomesDao();
		// ArrayList<Incomes> al = incomesDao.findAll();
		//for (Incomes incomes : al)
	//	System.out.println(incomes);
	
//		IncomesDao incomesDao = new IncomesDao();
//		 ArrayList<Incomes> al = incomesDao.findAllDateWise("2016-09-01","2016-09-02",1);
//		for (Incomes incomes : al)
//			System.out.println(incomes);
	
	}


}
