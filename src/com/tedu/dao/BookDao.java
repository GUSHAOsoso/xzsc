package com.tedu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tedu.jdbc.JDBC;

import po.Book;

public class BookDao {
	//查找所有书籍
	public List<Book> selectAll(){
		List<Book> list = new ArrayList<Book>();
		Connection conn = JDBC.getConnection();
		String sql = "select isbn,title,author,price,press,edition,published,pages,words,packaging,format,form from t_book";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Book book = new Book();
				book.setIsbn(rs.getString("isbn"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setPrice(rs.getDouble("price"));
				book.setPress(rs.getString("press"));
				book.setEdition(rs.getInt("edition"));
				book.setPublished(rs.getDate("published"));
				book.setPackaging(rs.getString("packaging"));
				book.setWords(rs.getInt("words"));
				book.setFormat(rs.getString("format"));
				book.setForm(rs.getString("form"));
				book.setPages(rs.getInt("pages"));

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
	//根据书名或作者名查找书籍
		public List<Book> selectSearch(String search){
			List<Book> list = new ArrayList<Book>();
			Connection conn = JDBC.getConnection();
			String sql = "select isbn,title,author,price,press,edition,published,pages,words,packaging,format,form from t_book where "
					+ "title like '%"+search+"%' or author like '%"+search+"%' ";
			try {
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					Book book = new Book();
					book.setIsbn(rs.getString("isbn"));
					book.setTitle(rs.getString("title"));
					book.setAuthor(rs.getString("author"));
					book.setPrice(rs.getDouble("price"));
					book.setPress(rs.getString("press"));
					book.setEdition(rs.getInt("edition"));
					book.setPublished(rs.getDate("published"));
					book.setPackaging(rs.getString("packaging"));
					book.setWords(rs.getInt("words"));
					book.setFormat(rs.getString("format"));
					book.setForm(rs.getString("form"));
					book.setPages(rs.getInt("pages"));
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
	
	//商品页面详情
	//根据isbn查找书籍，显示当前商品详情
	public Book selectByisbn(String isbn){
		Book book = null;
		Connection conn = JDBC.getConnection();
		String sql = "select * from t_book where isbn=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, isbn);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				book = new Book();
				book.setIsbn(rs.getString("isbn"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setPrice(rs.getDouble("price"));
				book.setPress(rs.getString("press"));
				book.setEdition(rs.getInt("edition"));
				book.setPublished(rs.getDate("published"));
				book.setPackaging(rs.getString("packaging"));
				book.setWords(rs.getInt("words"));
				book.setFormat(rs.getString("format"));
				book.setForm(rs.getString("form"));
				book.setPages(rs.getInt("pages"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBC.closeConnection(conn);
		}
		return book;
	}
}
