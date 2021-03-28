package com.gongda.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tedu.jdbc.JDBC;

import po.Book;
import po.OrderStatus;

public class OrderListAllServletDao {
	public List<OrderStatus> selectAllOrderList() {
		List<OrderStatus> list = new ArrayList<OrderStatus>();
		Connection conn = JDBC.getConnection();
		String sql = "select rid,uid,oid,sta,aid,payment,placed from t_order";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				OrderStatus book = new OrderStatus();
				book.setUid(rs.getString("uid"));
				book.setOid(rs.getString("oid"));
				book.setSta(rs.getString("sta"));
				book.setAid(rs.getString("aid"));
				book.setPayment(rs.getDouble("payment"));
				book.setPlaced(rs.getDate("placed"));
				list.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<OrderStatus> selectAllOrderList1(String sta) {
		List<OrderStatus> list = new ArrayList<OrderStatus>();
		Connection conn = JDBC.getConnection();
		String sql = "select rid,uid,oid,sta,aid,payment,placed from t_order t where t.sta = '"+sta+"'";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				OrderStatus book = new OrderStatus();
				book.setUid(rs.getString("uid"));
				book.setOid(rs.getString("oid"));
				book.setSta(rs.getString("sta"));
				book.setAid(rs.getString("aid"));
				book.setPayment(rs.getDouble("payment"));
				book.setPlaced(rs.getDate("placed"));
				list.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
