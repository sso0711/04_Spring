package com.ssafy.live.controller;

import java.io.IOException;
import java.util.Arrays;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet(description = "인사하는 서블릿", urlPatterns = { "/hello" })
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public HelloServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.printf("요청 정보 분석 %s, 요청 방식: %s%n", request.getRequestURL(), request.getMethod());
		System.out.println("파라미터 정보");
		request.getParameterMap().forEach((k,v) ->{
			System.out.printf("name: %s, v: %s\n", k, Arrays.toString(v));
		});
		System.out.println("----------------------------------------------------------");
		
		String param = request.getParameter("name");
		
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().append("Served at: ").append("안녕" + param);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public void init(ServletConfig config) throws ServletException {
		System.out.println("무거운 자원 초기화:");
		super.init(config);
	}
	
	public void destroy() {
		System.out.println("init에서 초기화한 자원 반환");
		super.destroy();
	}

}
