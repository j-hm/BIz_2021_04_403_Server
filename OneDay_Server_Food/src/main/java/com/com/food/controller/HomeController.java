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

@WebServlet("/")
public class HomeController extends HttpServlet {

	private FoodService fService;

	public HomeController() {
		fService = new FoodServiceImplV1();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		List<MyDTO> myList = fService.selectAll();
		System.out.println(myList);
		req.setAttribute("MYLIST", myList);
		RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/views/home.jsp");
		disp.forward(req, resp);
	}
}
