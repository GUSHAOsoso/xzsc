package com.tedu.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;



public class JDBC {
	public static Connection getConnection(){
		Connection conn = null;
		Properties dbProps = new Properties();	
		try {
			dbProps.load(JDBC.class.getClassLoader().getResourceAsStream("jdbc.properties"));
			String driveClassName = dbProps.getProperty("jdbc.driverClassName");
			String url = dbProps.getProperty("jdbc.url");
			String username = dbProps.getProperty("jdbc.username");
			String password = dbProps.getProperty("jdbc.password");
			Class.forName(driveClassName);
			conn = DriverManager.getConnection(url, username, password);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	public static void closeConnection(Connection conn) {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		Connection conn = JDBC.getConnection();
		try {
			boolean flag = conn.isClosed();
			System.out.println(flag);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

