package com.gongda.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tedu.jdbc.JDBC;

public class OrderStatusUpdateDao {

	public int OrderStatusUpdate(String optionsRadios2,String oid) {
		Connection conn = JDBC.getConnection();
		String sql = "update t_order set sta = ? where oid = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, optionsRadios2);
			ps.setString(2, oid);
			int row = ps.executeUpdate();
			return row;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBC.closeConnection(conn);
		}
		return 0;
	}

}
