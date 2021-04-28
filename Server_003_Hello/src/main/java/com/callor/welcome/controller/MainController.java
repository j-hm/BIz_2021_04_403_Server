package com.callor.welcome.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Controller : Web Server App에서 
 * 		Web Application Service(WAS) : 서비스 개념
 * 		Web Application Server(WAS) : 소프트웨어, 시스템
 * 
 * Req를 먼저 받은 main class이다
 * 클래스 이름은 특별히 중요하지 않다
 */
//WebServlet Annotation
//지금부터 이 클래스로 생성된 객체는
//웹서비스에서 리퀘스트를 처리할 객체이다
//main()메서드의 역할을 수행한다
//실제 리퀘스트를 처리하기 위해서는 많은 코드를 작성해야한다
//그런데 네트워크와 관련된 코드는 너무 복잡하고 다양한 기술을 요구하기 때문에
//코드를 직접 작성하는 것은 너무 어렵다
//java에서 제공하는 JDK를 상속받아서 대부분의 기능을 처리
//꼭 필요한 기능만 구현하게 된다

//WebServlet Annotation을 가지고 있는 클래스는
//톰캣에 의해 관리되고 사용자의 리퀘스트에 따라 톰캣이 클래스의 메서드를 호출하고
//기능을 수행한다

//만약 사용자가 http://lacalhost:8080/welcome/home 이라고 요청을 하면
//		1.현재 컴퓨터에 시작한 톰캣이 응답을 수신한다
//		http://lacalhost:8080 : 톰캣을 호툴하는 리퀘스트
//		2.톰캣 이후에 보내지는 문자열을 분석하기 시작한다
//		/welcome 부분을 분석하여
//		Run As Server로 시작된 프로젝트 중에서
//		root Context가 welcome인 프로젝트를 찾는다
//		3.프로젝트가 있으면 /home 문자열을 다시 분석하여 프로젝트 내의 클래스 중에서
//		@WebServlet("/home") Annotation으로 설정된 클래스를 찾는다
//		4.클래스 내의 doGet(...)메서드를 호출한다.
//		5.doGet(...)메서드의 코드를 재정의(@Overriding)하여 서비스를 구현하게 된다
@WebServlet("/home")
public class MainController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.println("this is Main Controller");
		out.print("<a href='");
		out.print("http://localhost");
		out.print(":8080");
		out.print("/welcome/book'>");
		out.println("Book 으로</a>");
		out.close();
	}
}
