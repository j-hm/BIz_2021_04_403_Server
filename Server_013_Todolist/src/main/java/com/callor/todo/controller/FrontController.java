package com.callor.todo.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.callor.todo.command.HomeCommandImplV1;
import com.callor.todo.command.TodoCommand;

@WebServlet("/")
public class FrontController extends HttpServlet{

	protected Map<String, TodoCommand> commmands;
	
	// FrontController가 최초 호출될 때
	// 한 번 실행되어서
	// 여러가지 변수 등을 초기화 하는 코드
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//web에서 요청한 path가져오기
		String urlPath = req.getRequestURI();
		String path = urlPath.substring(req.getContextPath().length());
		TodoCommand subCommand = commmands.get(path);
		if(subCommand != null) {
			subCommand.execute(req, res);
		}
	}

	// doGet(), doPost()로 분리하여 요청을 처리하던 방식을
	// 한 개의 메서드에서 동시에 처리하기
	@Override
	public void init(ServletConfig config) throws ServletException {
		commmands = new HashMap<String, TodoCommand>();
		commmands.put("/", new HomeCommandImplV1());
	}

}
