package com.gongda.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tedu.jdbc.JDBC;

import po.User;

public class AdminDao {
	// 登录时，判断用户是否存在
	public User selectByLogin(String uname, String upwd, int role) {
		User user = null;
		Connection conn = JDBC.getConnection();
		String sql = "select * from t_user where uname=? and upwd=? and role=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, uname);
			ps.setString(2, upwd);
			ps.setInt(3, role);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
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
		} finally {
			JDBC.closeConnection(conn);
		}
		return user;
	}
}
