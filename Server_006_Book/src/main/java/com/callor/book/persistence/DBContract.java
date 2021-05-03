package com.callor.book.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * DB연동을 위한 dbConnect 객체를 미리 생성해두고 
 * 필요할 때 사용할 수 있도록하는 클래스
 * static class로 생성
 * 클래스에 포함된 필드변수, 멤버 메서드 중
 * 1개라도 static키워드가 부착되면 static class가 된다
 * 프로젝트가 run되는 순간 미리 객체로 생성되어
 * 준비되는 클래스 
 */
public class DBContract {

	private static Connection dbConn = null;
	//static으로 선언된 dbConn 객체를 초기화 하는 코드
	static {
		String jdbcDriver = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "bookuser";
		String password = "bookuser";
		
		try {
			//java 1.7이상에서는 사용하지 않아도 되는 코드
			Class.forName(jdbcDriver);
			if(dbConn == null) {
				dbConn = DriverManager.getConnection(url, username, password);
			}
			System.out.println("오라클 접속 완료 :) ");
		} catch (ClassNotFoundException e) {
			System.out.println("오라클 Driver를 찾을 수 없음");
			System.out.println("오라클 Ojdbc6.jar를 확인하세요");
		} catch (SQLException e) {
			System.out.println("=".repeat(30));
			System.out.println("오라클 DBMS연결 실패");
			System.out.println("접속정보를 확인하세요");
			System.out.println("-".repeat(30));
			System.out.println("URL : " + url);
			System.out.println("USER : " + username);
			System.out.println("PW : " + password);
			System.out.println("=".repeat(30));
		}
	}//  end static
	
	public static Connection getDBConnection() {
		return dbConn;
	}
}
