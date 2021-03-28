package com.tedu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.tedu.jdbc.JDBC;

import po.Address;
import po.User;

public class AddressDao {
	public void insert(Address address) {
		Connection conn = JDBC.getConnection();
		String sql = "insert into t_address(uid,address,added,receiver,rphone) values(?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, address.getUid());
			ps.setString(2, address.getAddress());
			ps.setDate(3, new java.sql.Date(address.getAdded().getTime()));
			ps.setString(4, address.getReceiver());
			ps.setString(5, address.getRphone());
			int row = ps.executeUpdate();
			System.out.println("受影响的行数"+row);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBC.closeConnection(conn);
		}
	}
	public ArrayList<Address> selectAddressByUser(User user){
		ArrayList<Address> list = new ArrayList<Address>();
		Connection conn = JDBC.getConnection();
		String sql = "select * from t_address where uid=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getPhone());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Address address = new Address();
				address.setAdded(rs.getDate("added"));
				address.setAddress(rs.getString("address"));
				address.setReceiver(rs.getString("receiver"));
				address.setRid(rs.getInt("rid"));
				address.setRphone(rs.getString("rphone"));
				address.setUid(rs.getString("uid"));
				list.add(address);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBC.closeConnection(conn);
		}		
		return list;		
	}
}
