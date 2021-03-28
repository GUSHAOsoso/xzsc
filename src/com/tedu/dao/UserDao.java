package com.tedu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;
import com.tedu.jdbc.JDBC;

import po.Book;
import po.Cart;
import po.CartAndBook;
import po.User;

public class UserDao {
	//ajax校验  注册用户名 是否已经存在
	public User ajaxCheckUname(String uname,int role) {
		User user = null;
		Connection conn = JDBC.getConnection();
		String sql = "select * from t_user where uname=? and role=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, uname);
			ps.setInt(2, role);
			ResultSet res = ps.executeQuery();
			if(res.next()) {
				user = new User();
				user.setEmail(res.getString("email"));
				user.setPhone(res.getString("phone"));
				user.setRole(res.getInt("role"));
				user.setUname(res.getString("uname"));
				user.setUpwd(res.getString("upwd"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBC.closeConnection(conn);
		}
		return user;
	}
	//ajax校验  注册邮箱 是否已经存在
	public User ajaxEmailUname(String email,int role) {
		User user = null;
		Connection conn = JDBC.getConnection();
		String sql = "select * from t_user where email=? and role=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setInt(2, role);
			ResultSet res = ps.executeQuery();
			if(res.next()) {
				user = new User();
				user.setEmail(res.getString("email"));
				user.setPhone(res.getString("phone"));
				user.setRole(res.getInt("role"));
				user.setUname(res.getString("uname"));
				user.setUpwd(res.getString("upwd"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBC.closeConnection(conn);
		}
		return user;
	}
	
	//ajax校验  注册手机号 是否已经存在
	public User ajaxCheckPhone(String phone,int role) {
		User user = null;
		Connection conn = JDBC.getConnection();
		String sql = "select * from t_user where phone=? and role=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, phone);
			ps.setInt(2, role);
			ResultSet res = ps.executeQuery();
			if(res.next()) {
				user = new User();
				user.setEmail(res.getString("email"));
				user.setPhone(res.getString("phone"));
				user.setRole(res.getInt("role"));
				user.setUname(res.getString("uname"));
				user.setUpwd(res.getString("upwd"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBC.closeConnection(conn);
		}
		return user;
	}
	//注册用户
 	public int insert(User user) {
		Connection conn = JDBC.getConnection();
		String sql = "insert into t_user (phone,uname,upwd,email,role) values(?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getPhone());
			ps.setString(2, user.getUname());
			ps.setString(3, user.getUpwd());
			ps.setString(4, user.getEmail());
			ps.setInt(5, user.getRole());
			int row = ps.executeUpdate();
			System.out.println("受影响的行数："+row);
			return row;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBC.closeConnection(conn);
		}
	return 0;
	}
	//登录时，判断用户是否存在
	public User selectByLogin(String uname,String upwd,int role){
		User user = null;
		Connection conn = JDBC.getConnection();
		String sql = "select * from t_user where uname=? and upwd=? and role=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, uname);
			ps.setString(2, upwd);
			ps.setInt(3, role);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				user = new User();
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setRole(rs.getInt("role"));
				user.setUname(rs.getString("uname"));
				user.setUpwd(rs.getString("upwd"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBC.closeConnection(conn);
		}
		return user;
	}
	//检查密码是否和原密码一致
	public User ajaxCheckUpwd(String upwd,String phone,int role) {
		User user = null;
		Connection conn = JDBC.getConnection();
		String sql = "select * from t_user where phone=? and upwd=? and role=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, phone);
			ps.setString(2, upwd);
			ps.setInt(3, role);
			ResultSet res = ps.executeQuery();
			if(res.next()) {
				user = new User();
				user.setEmail(res.getString("email"));
				user.setPhone(res.getString("phone"));
				user.setRole(res.getInt("role"));
				user.setUname(res.getString("uname"));
				user.setUpwd(res.getString("upwd"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBC.closeConnection(conn);
		}
		return user;
	}
	//更改密码
	public void updateUpwd(User user,String npwd) {
		Connection conn = JDBC.getConnection();
		String sql = "update t_user set upwd=? where phone=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, npwd);
			ps.setString(2, user.getPhone());
			int row = ps.executeUpdate();
			System.out.println("受影响的行数"+row);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBC.closeConnection(conn);
		}
	}
}
