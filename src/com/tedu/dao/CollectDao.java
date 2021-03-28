package com.tedu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.tedu.jdbc.JDBC;

import po.Book;
import po.Collect;
import po.User;

public class CollectDao {
	//判断当前的收藏夹是否已经收藏,收藏的话，图标会变化
	public Collect selectByCollect(Collect collect) {
		Connection conn = JDBC.getConnection();
		String sql = "select * from t_collect where book=? and uid=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, collect.getBook());
			ps.setString(2, collect.getUid());
			ResultSet res = ps.executeQuery();
			while(res.next()) {
				collect = new Collect();
				collect.setBook(res.getString("book"));
				collect.setRid(res.getInt("rid"));
				collect.setUid(res.getString("uid"));
				return collect;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBC.closeConnection(conn);
		}
		return null;
	}
	
	//ajax添加收藏夹
	public void insert(Collect collect) {
		Connection conn = JDBC.getConnection();
		String sql = "insert into t_collect (uid,book) values(?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, collect.getUid());
			ps.setString(2, collect.getBook());
			int row = ps.executeUpdate();
			System.out.println("受影响的行数："+row);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBC.closeConnection(conn);
		}
	}
	//ajax取消收藏夹
	public void delete(Collect collect) {
		Connection conn = JDBC.getConnection();
		String sql = "delete from t_collect where book=? and uid=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, collect.getBook());
			ps.setString(2, collect.getUid());
			int row = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBC.closeConnection(conn);
		}
	}
	//根据用户id，查询收藏夹的内容
	public ArrayList<Book> selectByCollect(User user){
		ArrayList<Book> list = new ArrayList<Book>();
		Connection conn = JDBC.getConnection();
		String sql = "select * from t_book where isbn in (select book from t_collect where uid=?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getPhone());
			ResultSet res = ps.executeQuery();
			while(res.next()) {
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
}
