package com.ssafy.live.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/main")
public class MainServlet extends HttpServlet implements ControllerHelper {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = preProcessing(request, response);
		switch (action) {
			case "guguform" -> guguform(request, response);
			case "gugu" -> gugu(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = preProcessing(request, response);
		
		switch (action) {
		}

	}

	protected void guguform(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// action=gugu 는 화면에 보이지 않지만 자동으로 전송되는 값
		// method="post"로 보내면 위의 doPost()로 간다.
		
		String html = """
		<form action="/BE_02/main">
			<input type="hidden" name="action" value="gugu">
			<input type="number" name="dan">
			<button>submit</button>
		</form>
		""";
		responseHtml("구구단 입력", html, response);
	}

	protected void gugu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String danParam = request.getParameter("dan");
			if (danParam == null || danParam.isBlank()) {
				throw new IllegalArgumentException("Please enter a dan value.");
			}

			int dan = Integer.parseInt(danParam);
			GuguService service = new GuguService();
			String result = service.gugu(dan);
			responseHtml("Result", result, response);
		} catch (Exception e) {
			e.printStackTrace();
			responseHtml("Error", "Invalid request. " + e.getMessage(), response);
		}
	}
}
