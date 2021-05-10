package com.com.food.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContract {
	private static Connection dbConn;
	static{
		String jdbcDriver = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "food";
		String password = "food";
		
		try {
			Class.forName(jdbcDriver);
			dbConn = DriverManager.getConnection(url, username, password);
			System.out.println("DB Connection OK!!");
		} catch (ClassNotFoundException e) {
			System.out.println("오라클 DB Driver 없음");
		} catch (SQLException e) {
			System.out.println("오라클 DB 연결 오류!");
		}
	}// end static
	
	public static Connection getDBConnection() {
		return dbConn;
	}
}
