package com.money.moneytrackerdao;


import java.sql.*;
import java.util.*;

import com.money.moneytrackerpojo.IncomeCategory;
import com.money.utilities.ConnectionPool;



public class IncomeCategoryDao {

	public void create(IncomeCategory incomecategory) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "insert into income_category (inc_catname , inc_catdetails ,userid) "
					+ "values(?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, incomecategory.getInc_catname());
			ps.setString(2, incomecategory.getInc_catdetails());
			ps.setInt(3, incomecategory.getUserid());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public void edit(IncomeCategory incomecategory) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "update income_category "
					+ "set inc_catname = ?, inc_catdetails = ? , userid = ? where inc_catid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, incomecategory.getInc_catname());
			ps.setString(2, incomecategory.getInc_catdetails());
			ps.setInt(3, incomecategory.getUserid());
			ps.setInt(4, incomecategory.getInc_catid());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public void remove(int inc_catid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "delete from income_category where inc_catid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, inc_catid);
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public IncomeCategory find(int inc_catid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		IncomeCategory incomecategory = new IncomeCategory();
		try {
			String sql = "select * from income_category where inc_catid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, inc_catid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				incomecategory.setInc_catid(inc_catid);
				incomecategory.setInc_catname(rs.getString("inc_catname"));
				incomecategory.setInc_catdetails(rs.getString("inc_catdetails"));
				incomecategory.setUserid(rs.getInt("userid"));
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return incomecategory;
	}

	public ArrayList<IncomeCategory> findAll() {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<IncomeCategory> incomecategorylist = new ArrayList<IncomeCategory>();
		try {
			String sql = "select * from income_category";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				IncomeCategory incomecategory = new IncomeCategory();
				incomecategory.setInc_catid(rs.getInt("inc_catid"));
				incomecategory.setInc_catname(rs.getString("inc_catname"));
				incomecategory.setInc_catdetails(rs.getString("inc_catdetails"));
				incomecategory.setUserid(rs.getInt("userid"));
				incomecategorylist.add(incomecategory);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row.");
		} finally {
			pool.putConnection(conn);
		}
		return incomecategorylist;
	}
	
	public ArrayList<IncomeCategory> findAll(int userid){
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<IncomeCategory> incomecategorylist = new ArrayList<IncomeCategory>();
		try {
			String sql = "select * from income_category where userid =?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,userid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				IncomeCategory incomecategory = new IncomeCategory();
				
				incomecategory.setUserid(userid);
				incomecategory.setInc_catid(rs.getInt("inc_catid"));
				incomecategory.setInc_catname(rs.getString("inc_catname"));
				incomecategory.setInc_catdetails(rs.getString("inc_catdetails"));
				incomecategorylist.add(incomecategory);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to fetch a  row.");
		} finally {
			pool.putConnection(conn);
		}
		return incomecategorylist;
	}
	public static void main(String args[]) {

		//IncomeCategory incomecategory = new IncomeCategory("xyz","abc",2);
		// IncomeCategoryDao incomecategoryDao = new IncomeCategoryDao();
		//incomecategoryDao.create(incomecategory);

		//IncomeCategory incomecategory = new IncomeCategory(1,"SSS","abc",1);
		//IncomeCategoryDao incomecategoryDao = new IncomeCategoryDao();
		//incomecategoryDao.edit(incomecategory);

		 //IncomeCategoryDao incomecategoryDao = new IncomeCategoryDao();
		//incomecategoryDao.remove(2);

		// IncomeCategoryDao incomecategoryDao = new IncomeCategoryDao();
		//IncomeCategory incomecategory = incomecategoryDao.find(1);
		// System.out.println(incomecategory);
//
//		IncomeCategoryDao incomecategoryDao = new IncomeCategoryDao();
//    	ArrayList<IncomeCategory> al = incomecategoryDao.findAll();
//		for (IncomeCategory incomecategory : al)
//        System.out.println(incomecategory);
		
//		
//	IncomeCategoryDao incomecategoryDao = new IncomeCategoryDao();
//    	ArrayList<IncomeCategory> al = incomecategoryDao.findAll(1);
//		for (IncomeCategory incomecategory : al)
//       System.out.println(incomecategory);
		
		
		// IncomeCategoryDao incomecategoryDao = new IncomeCategoryDao();
		// ArrayList<IncomeCategory> al = incomecategoryDao.findAllByName("S");
		// for (IncomeCategory incomecategory : al)
		// System.out.println(incomecategory);
	}

}

