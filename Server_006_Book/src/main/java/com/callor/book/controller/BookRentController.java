package com.callor.book.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.callor.book.model.BookRentDTO;
import com.callor.book.model.BookRentVO;
import com.callor.book.service.BookRentService;
import com.callor.book.service.impl.BookRentServiceImplV1;

/*
 * 웹브라우저의 리퀘스트를 처리할 클래스
 */
@WebServlet("/rent/*")
public class BookRentController extends HttpServlet{
	private static final long serialVersionUID = 921652892464670154L;

	
	protected BookRentService brService;
	public BookRentController() {
		brService = new BookRentServiceImplV1();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String subPath = req.getPathInfo();
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		if(subPath.equals("/list")) {
			//도서대여 전체목록
			brService.selectAll();
			out.println("도서대여 전체목록 보기");
		}else if(subPath.equals("/seq")) {
			//주문번호로 찾기
			String strSeq = req.getParameter("id");
			Long nSeq = Long.valueOf(strSeq);
			BookRentDTO brDTO = brService.findById(nSeq);
			//view에서 보여줄 데이터 생성
			ServletContext app = this.getServletContext();
			//brService가 리턴한 brDTO를
			//app 객체에 BOOK이라는 속성변수로 세팅하기
			app.setAttribute("BOOK", brDTO);
			//book.jsp파일을 읽어서
			//app에 세팅한 book변수와 함께 렌더링을 하라
			RequestDispatcher disp = app.getRequestDispatcher("/WEB-INF/views/book.jsp");
			//렌더링 된 뷰 데이터를 웹브라우저로 response하라
			disp.forward(req, resp);
			
		}else if(subPath.equals("/isbn")) {
			// 도서코드로 찾기
			brService.findByBISBN("ibsn");
		}else if(subPath.equals("/buyer")) {
			//회원코드로 찾기
			brService.findByBuyerCode("buyercode");
		}else if(subPath.equals("/rent")) {
			//대여정보 추가, 대여하기
			BookRentVO bookRentVO = new BookRentVO();
			brService.insert(bookRentVO);
		}else if(subPath.equals("/return")) {
			//
			BookRentVO bookRentVO = new BookRentVO();
			brService.update(bookRentVO);
		}else{
			
		}
	}	
	
}
