package com.callor.db.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.callor.db.model.BookVO;
import com.callor.db.service.BookService;

public class BookServiceImplV1 implements BookService{

	protected Connection dbConn;
	public BookServiceImplV1() {
		this.dbConnection();
	}
	
	//DB에 연결하여 CRUD를 구현하기 위한 준비를 하는 메서드
	private void dbConnection() {
		
		/*
		 * WAS프로젝트에서 ojdbc.jar를 이용할 경우
		 * 톰캣 푤더 lib에 복사해 넣을것
		 */
		String dbDriver = "oracle.jdbc.OracleDriver";
		//프로젝트에서 SQL을 실행하면
		//url로 설정된 통로를 통해서 명령을 전달하고
		//결과를 받겠다
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "bookuser";
		String password = "bookuser";
		
		try {
			// 오라클에 접속할 미들웨어를 실행하라
			// java7이상에서는 선택적이다
			Class.forName(dbDriver);
			//url, user, password 정보를 사용하여 오라클에 접속하라
			dbConn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void insert(BookVO bookvo) {
		// TODO Auto-generated method stub
		
	}

	// bk_isbn = 1 OR 1 = 1 -> 조심해야하는 조건 다 날라가고 다 조회됨ㅋㅋ
	@Override
	public List<BookVO> selectAll() {
		// TODO 전체 도서 정보 조회 후 return
		
		//SQL을 DBMS로 전할 때 사용할 보조 도구
		PreparedStatement pStr = null;
		String sql = "SELECT * FROM tbl_books";
		
		//문자열로 되어있는 SQL명령을
		//url을 통해 DB로 전송하기 위하여 Packing하라
		/*
		 * packet으로 만들어라
		 * 네트워크를 통해서 데이터를 주고 받으려면
		 * 데이터 외에 여러가지 정보들이 포함되어야 한다
		 * 받는 곳 주소, 보내는 곳 주소...
		 */
		try {
			pStr = dbConn.prepareStatement(sql);
			//Packing된 명령을 DBMS로 전송하라
			//ResultSet 타입의 데이터로 리턴해준다
			ResultSet result = pStr.executeQuery();
			
			List<BookVO> bookList = new ArrayList<BookVO>();
			//while(true) {
			while(result.next()) {
				// 리턴받은 결과에서 데이터 1개를 읽을 준비 시~작!
				// 읽은 데이터가 있으면 true를 리턴하고
				// 더 이상 읽을 데이터가 없으면 false 리턴
				//if(!result.next()) break; 
				BookVO bookVO = new BookVO();
				bookVO.setBk_isbn(result.getString("bk_isbn"));
				bookVO.setBk_Title(result.getString("bk_title"));
				
				bookVO.setBk_ccode(result.getString("bk_ccode"));
				bookVO.setBk_acode(result.getString("bk_acode"));
				bookVO.setBk_date(result.getString("bk_date"));
				bookVO.setBk_price(result.getInt("bk_price"));
				bookVO.setBk_page(result.getInt("bk_page"));
				
				bookList.add(bookVO);
				System.out.println(bookVO.toString());
			}// end while
			result.close();
			pStr.close();
			return bookList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public BookVO findById(String bk_isbn) {
		PreparedStatement pStr = null;
		String sql = "SELECT * FROM view_도서정보 WHERE ISBN = '" + bk_isbn + "'";
		
		try {
			pStr = dbConn.prepareStatement(sql);
			ResultSet result = pStr.executeQuery();
			result.next();
			
			BookVO bookVO = new BookVO();
			bookVO.setBk_Title(result.getString("도서명"));
			bookVO.setBk_isbn(result.getString("ISBN"));
			bookVO.setBk_ccode(result.getString("출판사명"));
			bookVO.setBk_acode(result.getString("저자명"));
			return bookVO;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<BookVO> findByTitle(String bk_title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookVO> findByComp(String bk_comp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(BookVO bookVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String bk_isbn) {
		// TODO 전달받은 데이터 삭제
		String sql = "DELETE FROM tbl_books WHERE bk_isbn = '" + bk_isbn + "'"; // 이런코드 쓰면 데이터 다 날라간다^^...
	}

}
