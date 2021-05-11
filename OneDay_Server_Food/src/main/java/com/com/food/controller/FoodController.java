package com.com.food.controller;

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

import com.com.food.model.FoodDTO;
import com.com.food.model.FoodVO;
import com.com.food.model.MyDTO;
import com.com.food.service.FoodService;
import com.com.food.service.impl.FoodServiceImplV1;

@WebServlet("/food/*")
public class FoodController extends HttpServlet {

	private FoodService fService;
	private String subPath = null;

	public FoodController() {
		fService = new FoodServiceImplV1();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		subPath = req.getPathInfo();
		if (subPath.equals("/serch")) {
			req.getRequestDispatcher("/WEB-INF/views/food_serch.jsp").forward(req, resp);
		} else if (subPath.equals("/info")) {
			String f_code = req.getParameter("f_code");
			System.out.println(f_code);
			ServletContext app = this.getServletContext();
			app.setAttribute("f_code", f_code);
			req.getRequestDispatcher("/WEB-INF/views/food_info.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		subPath = req.getPathInfo();
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();

		if (subPath.equals("/serch")) {

			String f_name = req.getParameter("f_name");
			if (f_name == null || f_name.equals("")) {
				out.println("입력하신 식품이 없습니다");
				out.println("다시 입력해주세요");
			} else {
				List<FoodDTO> foodList = fService.findByFood(f_name);
				req.setAttribute("FOODLIST", foodList);
				RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/views/food_serch.jsp");
				disp.forward(req, resp);
			}

		} else if (subPath.equals("/info")) {
			//
			String mf_date = req.getParameter("mf_date");
			String mf_fcode = req.getParameter("mf_fcode");
			String count = req.getParameter("mf_count");
			if (count == null || count.equals("")) {
				out.println("빈 칸이 없도록 입력해주세요");
			} else {
				Integer mf_count = Integer.valueOf(count);

				FoodVO foodVO = new FoodVO();
				foodVO.setMf_date(mf_date);
				foodVO.setMf_fcode(mf_fcode);
				foodVO.setMf_count(mf_count);
				int result = fService.insert(foodVO);
				req.setAttribute("FOOD", foodVO);
				if (result > 0) {
					req.getRequestDispatcher("/WEB-INF/views/food_log.jsp").forward(req, resp);
				} else {
					out.println("<p>추가실패");
				}
				out.close();
			}
		}
	}
}
