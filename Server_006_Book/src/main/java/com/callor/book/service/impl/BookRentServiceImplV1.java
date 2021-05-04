package com.callor.book.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.callor.book.model.BookRentDTO;
import com.callor.book.model.BookRentVO;
import com.callor.book.persistence.DBContract;
import com.callor.book.service.BookRentService;

public class BookRentServiceImplV1 implements BookRentService{

	protected Connection dbConn;
	public BookRentServiceImplV1() {
		dbConn = DBContract.getDBConnection();
	}
	/*
	 * exception 처리 방법 2가지
	 * 1. try-catch를 사용하기 : "직접" exception이 발생할 코드를 감싸서 처리하기
	 * 2. throws를 사용하기 : "떠넘기기" method throws를 추가해 호출한 메서드에게 익셉션을 되돌려 보내기
	 * 						  호출한 곳에서 대신 exception 처리하기
	 * 						  직접 처리하는 코드가 없어 다소 간소회 된다
	 */
	protected List<BookRentDTO> select(PreparedStatement pStr) throws SQLException{
		List<BookRentDTO> brList = new ArrayList<BookRentDTO>();
		ResultSet rSet = pStr.executeQuery();
		while(rSet.next()) {
			BookRentDTO brDTO = new BookRentDTO();
			brDTO.setBr_seq(rSet.getLong("주문번호"));
			brDTO.setBr_bcode(rSet.getString("회원코드"));
			brDTO.setBr_bname(rSet.getString("회원명"));
			brDTO.setBr_tel(rSet.getString("회원연락처"));
			brDTO.setBr_isbn(rSet.getString("ISBN"));
			brDTO.setBr_title(rSet.getString("도서명"));
			brDTO.setBr_price(rSet.getInt("대여금"));
			brDTO.setBr_edate(rSet.getString("반납일"));
			brList.add(brDTO);
		}
		return brList;
	}
	
	@Override
	public List<BookRentDTO> selectAll() {
		// TODO 전체리스트
		String sql = " SELECT * FROM view_도서대여정보 ";
		PreparedStatement pStr = null;
		try {
			pStr = dbConn.prepareStatement(sql);
			List<BookRentDTO> brList = this.select(pStr);
			pStr.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public BookRentDTO findById(Long seq) {
		// TODO PK로 조회하기
		/*
		 * DB Injection코드에 매우 취약한 코드
		 * 만약 매개변수로 직접 SQL명령문을 다음과 같이 만들면
		 * "WHERE 도서명 = " + title;
		 * title변수 값에 1 OR 1 = 1과 같은 문자열을 담아서 보내면
		 * 실제 쿼리는
		 * WHERE 도서명 = 1 OR 1 = 1
		 *            false OR true
		 * 로 읽혀 DELETE 명령문을 쓸 경우 true값을 읽어 전부 삭제되어 버림
		 * 
		 * Prepare...를 사용할 떄는 조건문의 변수가 포함될 위치에 ?기호를 사용한다
		 */
		String sql = " SELECT * FROM view_도서대여정보 ";
		sql += " WHERE 주문번호 = ? "; 
		
		PreparedStatement pStr = null;
		try {
			//아래 2개 코드에 의해 WHERE 주문번호 = seq값 형식의 SQL이 만들어진다
			pStr = dbConn.prepareStatement(sql);
			pStr.setLong(1, seq);
//			ResultSet rSet = pStr.executeQuery();
//			if(rSet.next()) {
//				//VOㅇ에 담기
//			}
//			rSet.close();
			//PK로 조회를 했기 때문에 List에는 1개 밖에 데이터가 없다!
			//List의 0번 데이터만 get하여 DTO에 담기
			List<BookRentDTO> brList = this.select(pStr);
			BookRentDTO brDTO = null;
			if(brList != null && brList.size() > 0) {
				brDTO = brList.get(0);
			}
			pStr.close();
			return brDTO;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<BookRentDTO> findByBISBN(String isbn) {
		// TODO ISBN으로 조회
		String sql = " SELECT * FROM view_도서대여정보 ";
		sql += " WHERE ISBN = ? ";
		PreparedStatement pStr = null;
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, isbn);
			List<BookRentDTO> brList = this.select(pStr);
			pStr.close();
			return brList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<BookRentDTO> findByBookName(String name) {
		// TODO 도서명으로 조회
		String sql = " SELECT * FROM view_도서대여정보 ";
		sql += " WHERE 도서명 LIKE '%' || ? || '%' ";
		PreparedStatement pStr = null;
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, name);
			List<BookRentDTO> brList = this.select(pStr);
			pStr.close();
			return brList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<BookRentDTO> findByBuyerCode(String bCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookRentDTO> findByBuyerName(String bName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookRentDTO> findByOverDue(String eDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void findByterm(String sDate, String eDate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int insert(BookRentVO bookRentVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(BookRentVO bookRentVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Long seq) {
		// TODO Auto-generated method stub
		return 0;
	}

}
