package com.callor.book.service;

import java.util.List;

import com.callor.book.model.BookDTO;
import com.callor.book.model.BookVO;

/*
 * DB연동하는 프로젝트에는 필수적으로 구현해야할 method가 있다
 * 필수 method는 반드시 table을 기준으로 CRUD를 구현한다
 * CREATE : insert()
 * READ : select()
 * UPDATE : update()
 * DELETE : delete()
 */
public interface BookService {
	//도서정보 데이터를 1개 전달받아서 DB insert 수행
	//도서정보 데이터는 ISBN, 도서명, 출판사코드, 저자코드, 발생일, 가격, 페이지의 데이터가 포함되어 있다
	//도서정보를 VO객체에 담아 전달받아서 DB에 insert 수행
	public void insert(BookVO bookVO);
	
	//도서정보 데이터를 모두 조회하여 return하는 기능 수행
	public List<BookDTO> selectAll();
		//도서 코드(ISBN) 1개 전달 받아서 도서 정보 1개를 return하는 기능을 수행할 메서드
		//PK 1개를 전달받아 조회하는 메서드는 0 OR 1개의 데이터만 리턴한다
		//데이터가 없을 때는 null을 있을때는 실제 데이터가 담긴 DTO가 리턴!
		public BookDTO findById(String bk_isbn);
		//도서명을 1개 전달 받아서 도서명으로 조회를 하고 결과를 return하는 기능 수행
		//포함된 문자열 여러개의 자료가 조회 따라서 리스트로
		public List<BookDTO> findByTitle(String bk_title);
		
	//변경할 도서 데이터 1개를 전달 받아서 데이터를 갱신, 변경, 수정하는 기능 수행
	public void update(BookVO bookVO);
	
	// 삭제할 도서의 ISBN을 1개 전달받아서 하나의 도서정보를 삭제하는 기능 수행
	public void delete(String bk_isbn);
}
