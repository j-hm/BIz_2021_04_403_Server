package com.callor.guest.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.callor.guest.model.GuestBookVO;
import com.callor.guest.service.GuestBookService;
import com.callor.guest.service.impl.GuestBookServiceImplV1;
@WebServlet("/guest/*")
public class GuestBookController extends HttpServlet{

	protected GuestBookService gbService;
	public GuestBookController() {
	 gbService = new GuestBookServiceImplV1();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String subPath = req.getPathInfo();
		if(subPath.equals("/view")) {
			String strSeq = req.getParameter("gb_seq");
			Long gb_seq = Long.valueOf(strSeq);
			GuestBookVO gbVO = gbService.findById(gb_seq);
			req.setAttribute("GB", gbVO);
			//command(명령) 패턴(Delegate(대리) 패턴) : req.forward()를 다른 클래스에게 일임하기
			RequestForwardController.forward(req, resp, "view");
		} else if(subPath.equals("/insert")) {
			RequestForwardController.forward(req, resp, "write");
		}
	}
	
}
