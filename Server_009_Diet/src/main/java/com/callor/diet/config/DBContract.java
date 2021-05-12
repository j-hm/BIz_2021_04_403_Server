package com.callor.diet.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContract {
	private static Connection dbConn;
	static {
		String jdbcDriver = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "food";
		String password = "food";
		
		if(dbConn == null) {
			try {
				Class.forName(jdbcDriver);
				dbConn = DriverManager.getConnection(url, username, password);
				System.out.println("오라클 접속 완료");
			} catch (ClassNotFoundException e) {
				System.out.println("oracle6.jar 을 확인하세요");
			} catch (SQLException e) {
				System.out.println("=".repeat(30));
				System.out.println(jdbcDriver);
				System.out.println(url);
				System.out.println(password);
				System.out.println("-".repeat(30));
				System.out.println("오라클 DBMS 접속 오류");
				System.out.println("접속 정보를 확인하세요");
				System.out.println("=".repeat(30));
			}
		}
	}
}
