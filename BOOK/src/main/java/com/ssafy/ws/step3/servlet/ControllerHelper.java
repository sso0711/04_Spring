package com.ssafy.ws.step3.servlet;

import java.io.IOException;
import java.util.Arrays;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface ControllerHelper {
	default String preProcessing(HttpServletRequest request, HttpServletResponse response) {
//		System.out.printf("요청 정보 분석 %s, 요청 방식: %s%n",request.getRequestURI(), request.getMethod());
//		System.out.println("파라미터 정보");
//		request.getParameterMap().forEach((k,v)-> {
//			System.out.printf("name: %s, v: %s\n", k, Arrays.toString(v));
//		});
//		System.out.println("----------------------------------------------");
		
		// main으로 요청하면 자동으로 index.jsp로 연결된다
		String action = request.getParameter("action");
		if(action==null || action.isBlank()) {
			action = "index";
		}
		return action;
	}
	
	default void responseHtml(String title, String content, HttpServletResponse response) throws IOException {
		String html = "<html><body> <h1>%s</h1><div>%s</div></body></html>".formatted(title, content);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().append(html);
	}
}
