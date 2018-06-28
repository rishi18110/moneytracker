package com.money.moneytrackerdao;

import java.sql.*;
import java.util.*;

import com.money.moneytrackerpojo.Users;
import com.money.utilities.ConnectionPool;



public class UsersDao {

	public void create(Users user) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "insert into users (username, password ,name , address , mobile , email) "
					+ "values(?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getName());
			ps.setString(4, user.getAddress());
			ps.setString(5, user.getMobile());
			ps.setString(6, user.getEmail());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public void edit(Users user) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "update users "
					+ "set username = ?,password = ?, name = ? ,address = ? ,mobile = ? ,email = ? where uid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getName());
			ps.setString(4, user.getAddress());
			ps.setString(5, user.getMobile());
			ps.setString(6, user.getEmail());
			ps.setInt(7, user.getUid());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public void remove(int uid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "delete from users where uid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public Users find(int uid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		Users user = new Users();
		try {
			String sql = "select * from users where uid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user.setUid(uid);
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setAddress(rs.getString("address"));
				user.setMobile(rs.getString("mobile"));
				user.setEmail(rs.getString("email"));
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return user;
	}

	public int checkAvailablity(String username) {
		int id=-1;
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		Users user = new Users();
		try {
			String sql = "select * from users where username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				id = rs.getInt("uid");
				
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return id;
	}

	public int checkAvailablity(String username,String pwd) {
		int id=-1;
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		Users user = new Users();
		try {
			String sql = "select * from users where username = ? and password=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, pwd);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				id++;
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return id;
	}

	public static Users authenticate(String email ,String pwd) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		Users user = new Users();
		try {
			String sql = "select * from users where email = ? and password=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, pwd);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user.setUid(rs.getInt("uid"));
				user.setEmail(email);
				user.setUsername(rs.getString("username"));
				user.setPassword(pwd);
				user.setName(rs.getString("name"));
				user.setAddress(rs.getString("address"));
				user.setMobile(rs.getString("mobile"));
				
				
			}
			else{
				
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return user;
	}

	public ArrayList<Users> findAll() {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<Users> listUsers = new ArrayList<Users>();
		try {
			String sql = "select * from users";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Users user = new Users();
				user.setUid(rs.getInt("uid"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setAddress(rs.getString("address"));
				user.setMobile(rs.getString("mobile"));
				user.setEmail(rs.getString("email"));
				listUsers.add(user);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row.");
		} finally {
			pool.putConnection(conn);
		}
		return listUsers;
	}

	public static void main(String args[]) {
		// java.util.Date dt = DateUtils.convertDate("24-10-2015");
		// Users user = new Users("rahul","rahul","rahul","mig 61","8349786543","rahul@gmail.com");
		// UsersDao userDao = new UsersDao();
		// userDao.create(user);

		// Users user = new Users(1,"ram","ram","ram","mig 61","8349786543","ram@gmail.com");
		// UsersDao userDao = new UsersDao();
		// userDao.edit(user);

		// UsersDao userDao = new UsersDao();
		// userDao.remove(2);

		// UsersDao userDao = new UsersDao();
		// Users user = userDao.find(1);
		// System.out.println(user);

		//UsersDao userDao = new UsersDao();
		// ArrayList<Users> al = userDao.findAll();
		//for (Users user : al)
		//System.out.println(user);

		// UsersDao userDao = new UsersDao();
		// ArrayList<Users> al = userDao.findAllByName("S");
		// for (Users user : al)
		// System.out.println(user);
		
//		 UsersDao userDao = new UsersDao();
//		int  userid = userDao.checkAvailablity("shubham");
//		if(userid > -1){
//			System.out.println("username exist");
//		}
//		else{
//			System.out.println("username not exist");
//		}
		
//		 UsersDao userDao = new UsersDao();
//		int check = userDao.checkAvailablity("arjun","qwerty");
//			if(check > -1){
//				System.out.println("user available");
//			}
//			else{
//				System.out.println("user not Available");
//			}
//		
		 UsersDao userDao = new UsersDao();
		 Users user = userDao.authenticate("18110gupta@gmail.com","heavenraj12");
	 System.out.println(user);
	}

}
