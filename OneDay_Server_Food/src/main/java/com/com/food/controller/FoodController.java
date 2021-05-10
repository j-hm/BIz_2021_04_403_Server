package com.com.food.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.com.food.model.FoodVO;
import com.com.food.service.FoodService;
import com.com.food.service.impl.FoodServiceImplV1;

@WebServlet("/food/")
public class FoodController extends HttpServlet{

	private FoodService fService;
	public FoodController() {
		fService = new FoodServiceImplV1();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/views/food_info.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String mf_date = req.getParameter("mf_date");
		String mf_fcode = req.getParameter("mf_fcode");
		String count = req.getParameter("mf_count");
		Integer mf_count = Integer.valueOf(count);
		
		FoodVO foodVO = new FoodVO();
		foodVO.setMf_date(mf_date);
		foodVO.setMf_fcode(mf_fcode);
		foodVO.setMf_count(mf_count);
		int result = fService.insert(foodVO);
		PrintWriter out = resp.getWriter();
		if(result > 0) {
			out.println("<p>============================");
			out.println("<p>기록완료");
			out.println("<p>============================");
			out.println();
			out.printf("날짜 : <p>%s",foodVO.getMf_date());
			out.println();
			out.printf("식품코드 : <p>%s",foodVO.getMf_fcode());
			out.println();
			out.printf("섭취량 : <p>%s",foodVO.getMf_count());
			out.println("<p>============================");
			out.println("<form action=" + "" + "/HelpDiet/"+ "" + ">");
			out.println( "<p><button>뒤로가기</button> </p>");
			out.println("</form>");
		} else {
			out.println("<p>추가실패");
		}
		
		out.close();

	}
	
	
	
}
