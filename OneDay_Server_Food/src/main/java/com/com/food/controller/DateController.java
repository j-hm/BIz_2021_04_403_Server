package com.com.food.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.com.food.model.MyDTO;
import com.com.food.service.FoodService;
import com.com.food.service.impl.FoodServiceImplV1;

@WebServlet("/SerchByDate/")
public class DateController extends HttpServlet {
	private FoodService fService;

	public DateController() {
		fService = new FoodServiceImplV1();
	}

	@Override

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();

		String my_date = req.getParameter("my_date");
		if (my_date == null || my_date.equals("")) {
			out.println("입력하신 날짜에 데이터가 없습니다");
			out.println("YYYY-MM-DD 형식의 날짜를 입력해주세요");
		} else {
			List<MyDTO> myList = fService.findByDate(my_date);
			req.setAttribute("MYLIST", myList);
			RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/views/date_serch.jsp");
			disp.forward(req, resp);
		}

	}
}