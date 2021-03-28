package com.tedu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tedu.jdbc.JDBC;

import po.Book;
import po.Cart;
import po.CartAndBook;
import po.User;
//把商品加入购物车，根据用户手机号，书籍单号唯一来确定
public class CartDao {
	//ajax添加购物车
	public void insert(Cart cart) {
		Connection conn = JDBC.getConnection();
		String sql = "insert into t_cart(uid,book,count) values(?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, cart.getUid());
			ps.setString(2, cart.getBook());
			ps.setInt(3, cart.getCount());
			int row = ps.executeUpdate();
			System.out.println("受影响的行数："+row);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBC.closeConnection(conn);
		}
	}
	//查询所有的购物车信息
	public List<CartAndBook> selectAllCartAndBook(User user){
		List<CartAndBook> list = new ArrayList<CartAndBook>();
		Connection conn = JDBC.getConnection();
		String sql = "select b.*,c.count,c.uid,c.rid from "
				+"t_cart c inner join t_book b "
				+"on c.book=b.isbn where c.uid=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getPhone());
			ResultSet res = ps.executeQuery();
			while(res.next()) {
				Cart cart = new Cart();
				cart.setCount(res.getInt("count"));
				cart.setUid(res.getString("uid"));
				cart.setRid(res.getInt("rid"));
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
	//ajax，购物车页面删除选中的商品
	public void deleteByRid(int rid) {
		Connection conn = JDBC.getConnection();
		String sql = "delete from t_cart where rid=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, rid);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBC.closeConnection(conn);
		}
	}
	//ajax，修改购物车中，书本的数量
	public void updateCartNumByRid(int rid,int num) {
		Connection conn = JDBC.getConnection();
		String sql = "update t_cart set count=? where rid=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			ps.setInt(2, rid);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBC.closeConnection(conn);
		}
	}
}
