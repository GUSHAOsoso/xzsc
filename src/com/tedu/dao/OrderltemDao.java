package com.tedu.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.tedu.jdbc.JDBC;

import po.Book;
import po.Cart;
import po.CartAndBook;
import po.OrderItem;
import po.OrderStatus;

//购物车进行下单，然后生成订单列表
public class OrderltemDao {
	//去到可以选择地址的页面
	public ArrayList<CartAndBook> selectAllCartAndBook(String itemIds){
		ArrayList<CartAndBook> list = new ArrayList<CartAndBook>();
		System.out.println(itemIds);
		Connection conn = JDBC.getConnection();
		//select * from where field in (value1,value2,value3,…)查询多个字段
		//select * from where field not in (value1,value2,value3,…)
		String sql="select b.*,c.count,c.uid,c.rid,c.book from "
				+"t_cart c inner join t_book b "
				+"on c.book=b.isbn where c.rid IN ("+itemIds+")";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet res = ps.executeQuery();
			while(res.next()) {
				Cart cart = new Cart();
				cart.setCount(res.getInt("count"));
				cart.setUid(res.getString("uid"));
				cart.setRid(res.getInt("rid"));
				cart.setBook(res.getString("book"));
				Book book = new Book();
				book.setIsbn(res.getString("isbn"));
				book.setTitle(res.getString("title"));
				book.setAuthor(res.getString("author"));
				book.setPrice(res.getDouble("price"));
				book.setPress(res.getString("press"));
				book.setEdition(res.getInt("edition"));
				book.setPublished(res.getDate("published"));
				book.setPackaging(res.getString("packaging"));
				book.setWords(res.getInt("words"));
				book.setFormat(res.getString("format"));
				book.setForm(res.getString("form"));
				book.setPages(res.getInt("pages"));
				CartAndBook cartAndBook = new CartAndBook();
				cartAndBook.setBook(book);
				cartAndBook.setCart(cart);
				list.add(cartAndBook);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBC.closeConnection(conn);
		}	
		return list;
	}
	//往t_oitem中添加数据
	public int insertOitem(OrderItem orderItem) {
		Connection conn = JDBC.getConnection();
		String sql = "insert into t_oitem(product,price,count,oid) values(?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, orderItem.getProduct());
			ps.setDouble(2, orderItem.getPrice());
			ps.setInt(3, orderItem.getCount());
			ps.setString(4, orderItem.getOid());
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
	public int insertOrder(OrderStatus orderStatus) {
		Connection conn = JDBC.getConnection();
		String sql = "insert into t_order(uid,oid,sta,payment) values(?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, orderStatus.getUid());
			ps.setString(2, orderStatus.getOid());
			ps.setString(3, orderStatus.getSta());
			ps.setDouble(4, orderStatus.getPayment());
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
	public int insertOrderPlaced(String rid, java.util.Date str1,String uid) {
		Connection conn = JDBC.getConnection();
		String sql = "update t_order set aid=?,placed=? where uid=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			System.out.println(str1);
			ps.setString(1, rid);
			ps.setTimestamp(2,new java.sql.Timestamp(str1.getTime()));
			ps.setString(3, uid);
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
	public int deleteCart(String book) {
		Connection conn = JDBC.getConnection();
		String sql = "delete from t_cart where rid IN ("+book+")";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			System.out.println(book);
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
}
