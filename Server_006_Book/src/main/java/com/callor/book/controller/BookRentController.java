package com.callor.book.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.callor.book.model.BookRentDTO;
import com.callor.book.model.BookRentVO;
import com.callor.book.model.BuyerDTO;
import com.callor.book.service.BookRentService;
import com.callor.book.service.BuyerService;
import com.callor.book.service.impl.BookRentServiceImplV1;
import com.callor.book.service.impl.BuyerServiceImplV1;

/*
 * 웹브라우저의 리퀘스트를 처리할 클래스
 */
@WebServlet("/rent/*")
public class BookRentController extends HttpServlet{
	private static final long serialVersionUID = 921652892464670154L;

	
	protected BookRentService brService;
	protected BuyerService buService;
	public BookRentController() {
		brService = new BookRentServiceImplV1();
		buService = new BuyerServiceImplV1();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//rent/*로 요청이 되면 *위치에 부착되는 Sub 요청을 분리해낸다
		//rent/seq 라고 요청을 하면 subPath에는 /seq라는 문자열이 담길 것이다.
		String subPath = req.getPathInfo();
		//아웃풋스트림을 사용하여 문자열 방식으로 응답하기 위한 준비
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		if(subPath.equals("/seq")) {
			//주문번호로 찾기
			String strSeq = req.getParameter("id");
			if(strSeq == null || strSeq.equals("")) {
				out.println("주문번호가 없음");
				out.close();
			} else {
				Long nSeq = Long.valueOf(strSeq);
				BookRentDTO brDTO = brService.findById(nSeq);
				//view에서 보여줄 데이터 생성
				/*
				 * ServletContext : 
				 * 톰캣을 기반으로 작성된 Web App Service에서 요청(Req) 응답(Resp)을 총괄하는 정보가 담긴 객체
				 * Web App Service를 구현하기 위하여
				 * Req, Resp를 처리하는 여러가지 기능을 구현해야하는데
				 * 그러한 기능을 미리 구현해 놓았기 때문에
				 * ServletContext를 geter하는 것만으로 충분하다
				 * 
				 * DB등으로부터 조회된 데이터를 Web에게 응답하고자 할 때
				 * 쉬운 방법으로 전달할 수 있도록 하는 기능이 미리 구현되어 있다
				 */
				ServletContext app = this.getServletContext();
				//brService가 리턴한 brDTO를
				//app 객체에 BOOK이라는 속성변수로 세팅하기
				//app 객체에 BOOK이라는 객체변수를 생성하고
				//BOOK변수에 brDTO 값을 저장한다
				//
				app.setAttribute("BOOK", brDTO);
				//book.jsp파일을 읽어서
				//app에 세팅한 book변수와 함께 렌더링을 하라
				RequestDispatcher disp = app.getRequestDispatcher("/WEB-INF/views/book.jsp");
				//렌더링 된 뷰 데이터를 웹브라우저로 response하라
				disp.forward(req, resp);					
			}
		} else if(subPath.equals("/list")) {
			//도서대여 전체목록
			brService.selectAll();
			out.println("도서대여 전체목록 보기");
		} else if(subPath.equals("/isbn")) {
			// 도서코드로 찾기
			brService.findByBISBN("ibsn");
		} else if(subPath.equals("/buyer")) {
			//회원코드로 찾기
			brService.findByBuyerCode("buyercode");
		} else if(subPath.equals("/order")) {
			//주문서작성의 처음화면 보여주기
			//회원이름 입력하는 화면
			//ServletContext app = req.getServletContext();
			RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/views/order.jsp");
			disp.forward(req, resp);
		} else if(subPath.equals("/order/page1")) {
			String bu_name = req.getParameter("bu_name");
			if(bu_name == null || bu_name.equals("")) {
				out.println("회원이름을 반드시 입력해야 합니다");
				out.close();
			} else {
				List<BuyerDTO> buList = buService.findByName(bu_name);
				System.out.println("=".repeat(50));
				for(BuyerDTO d: buList) {
					System.out.println(d.toString());
				}
				System.out.println("=".repeat(50));
				ServletContext app = req.getServletContext();
				app.setAttribute("BUYERS", buList);
				RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/views/page1.jsp");
				disp.forward(req, resp);
			}
		} else if(subPath.equals("/order/page2")) {
			String bu_code = req.getParameter("bu_code");
			BuyerDTO buyerDTO = buService.findById(bu_code);
			ServletContext app = req.getServletContext();
			app.setAttribute("BUYER", buyerDTO);
			RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/views/page2.jsp");
			disp.forward(req, resp);
		} else if(subPath.equals("/return")) {
			//
			BookRentVO bookRentVO = new BookRentVO();
			brService.update(bookRentVO);
		}else{
			
		}
	}	
	
}
