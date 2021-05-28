package com.callor.todo.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/*
 * 싱클톤 패턴
 */
public class DBContract {

	private static final Logger log = LoggerFactory.getLogger("TODO");
	private static Connection dbConn;
	/*
	 *  static 초기화 블럭 : 
	 *  static으로 선언된 변수나 객체를 프로젝트가 시작될 때 
	 *  자동으로 생성하는 코드를 작성하는 부분
	 *  
	 *  Connection 객체인 dbConn을 사용할 준비를 하기
	 *  DB server와 연동을 시작하여 연결 session을 생성해둔다
	 *  필요할 때 get() method를 호출
	 */
	static {
		String jdbcDriver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/mydb";
		String user = "gbUser";
		String padd = "12345";
		try {
			Class.forName(jdbcDriver);
			if(dbConn == null) {
				dbConn = DriverManager.getConnection(url, user, padd);
			}
			log.debug("~MySQL 연결 완료~");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// get Instance method
	// Instance : 사용준비(생성된, 초기화된) 객체
	// private static으로 선언된 변수, 객체를
	//다른 곳에서 사용할 수 있도록 제공하는 method
	public static Connection getDbConn() {
		return dbConn;
	}
	
}
