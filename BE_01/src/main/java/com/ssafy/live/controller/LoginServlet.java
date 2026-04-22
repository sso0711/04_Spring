package com.ssafy.live.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		System.out.println("LoginServlet 생성자 호출");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		// 로그인 페이지 (간단 form)
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().append("<html><body><h1>login</h1></body></html>");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {

	    request.setCharacterEncoding("UTF-8");

	    String id = request.getParameter("id");
	    String pw = request.getParameter("pw");

	    if ("ssafy".equals(id) && "1234".equals(pw)) {
	        response.sendRedirect("success.html");
	    } else {
	        response.sendRedirect("fail.html");
	    }
	}
}