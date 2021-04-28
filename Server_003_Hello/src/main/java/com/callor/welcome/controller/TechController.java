package com.callor.welcome.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jam") //192.168.5.97
public class TechController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.println("<h1>집에 가고 싶다 〣(ºΔº)〣 </h1>");
		out.print("<a href='");
		out.print("http://localhost");
		out.print(":8080");
		out.print("/welcome/just'>");
		out.println("혜미가 집에 가고 싶은 이유는?</a>");
		out.close();
	}

	
}
