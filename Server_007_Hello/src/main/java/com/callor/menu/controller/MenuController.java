package com.callor.menu.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 웹브라우저를 통해서 /hello/menu라는 요청이 오면
 * 응답할 클래스
 * 
 * HttpServlet클래스
 * 
 *웹에서 "hello/menu" 라는 요청이 들어오면 컨트롤러의 코드가 반응하도록 설정
 *
 */
@WebServlet("/menu")
public class MenuController extends HttpServlet{

	//컨트롤러가 반응할 때 실행될 메서드
	//톰캣이 호출하여 여러가지 정보를 전달해줄 메서드
	//톰캣이 전달하는 정보는 HttpServletRequest req, HttpServletResponse resp 클래스의 객체를 통해 받을 수 있다.
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String servletName = this.getServletName(); // 웹브라우저의 요청(req)에 반응한 클래스 이름이 무엇인지 확인할 때
		System.out.println("Servlet Name : " + servletName);
		
		String rootPath = req.getContextPath(); // 현재 프로젝트의 컨텍스트(context) 값이 무엇인지 확인할 때
		System.out.println("Root Path : " + rootPath);
		
		String queryString = req.getQueryString(); // 요청 path에 부착된 질의데이터 보기
		System.out.println("QuerySting : " + queryString);
		
		String strId = req.getParameter("id");
		System.out.println("ID값 : " + strId);
		
		PrintWriter out = resp.getWriter();
		//전달받은 id변수에 담긴 값에 따라 기능수행
		if(strId.equals("rent")) {
			//도서대여처리
			resp.sendRedirect("/hello/rent/list");
		} else if(strId.equals("book")) {
			//초기화면의 메뉴에서 도서정보를 클릭하면 처리할 부분
			//도서정보처리
			//여기에서 처리할 코드는 도서 정보를 변수에 세팅하고 book.jsp에 보내서 보여주기!
			resp.sendRedirect("/hello/book/list");
			
		} else if(strId.equals("author")) {
			//저자정보처리
		} else if(strId.equals("comp")) {
			//출판사 정보처리
		} else if(strId.equals("buyer")) {
			//회원정보처리
		}
	}
}