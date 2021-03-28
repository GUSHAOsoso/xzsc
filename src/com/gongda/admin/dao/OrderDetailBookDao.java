package com.gongda.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.tedu.dao.*;
import com.tedu.jdbc.JDBC;

import po.OrderItem;
import po.Address;
import po.OrderStatus;


public class OrderDetailBookDao {
	//收件人，电话，地址
	public List<Address> selectAddress(String aid,String uid) {
		List<Address> list = new ArrayList<Address>();
		Connection conn = JDBC.getConnection();
		String sql = "select uid,address,receiver,rphone from t_address where address = ? and uid = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, aid);
			ps.setString(2, uid);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Address book = new Address();
				book.setUid(rs.getString("uid"));
				book.setAddress(rs.getString("address"));
				book.setReceiver(rs.getString("receiver"));
				book.setRphone(rs.getString("rphone"));
				list.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBC.closeConnection(conn);
		}
		return list;
	}
	//状态
	public List<OrderStatus> selectOrder(String uid, String oid) {
		List<OrderStatus> list = new ArrayList<OrderStatus>();
		Connection conn = JDBC.getConnection();
		String sql = "select uid,oid,sta,aid,payment,placed from t_order where uid = ? and oid = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, uid);
			ps.setString(2, oid);
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
		}finally {
			JDBC.closeConnection(conn);
		}
		return list;
	}

	public List<OrderItem> selectOrderItem(String oid) {
		List<OrderItem> list = new ArrayList<OrderItem>();
		Connection conn = JDBC.getConnection();
		String sql = "select product,price,count,oid from t_oitem where oid = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, oid);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				OrderItem book = new OrderItem();
				book.setProduct(rs.getString("product"));
				book.setPrice(rs.getDouble("price"));
				book.setCount(rs.getInt("count"));
				book.setOid(rs.getString("oid"));
				list.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBC.closeConnection(conn);
		}
		return list;
	}

	public String selectTitle(String isbn) {
		String title = null;
		Connection conn = JDBC.getConnection();
		String sql = "select title from t_book where isbn = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, isbn);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				title = rs.getString("title");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBC.closeConnection(conn);
		}
		return title;
	}

}
