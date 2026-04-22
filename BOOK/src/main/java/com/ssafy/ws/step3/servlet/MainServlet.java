package com.ssafy.ws.step3.servlet;

import java.io.IOException;
import java.io.PrintWriter;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.ssafy.ws.step3.dto.Book;

@WebServlet("/main")
public class MainServlet extends HttpServlet implements ControllerHelper {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		try {
			String action = request.getParameter("action");
			if ("regist".equals(action)) {
				regist(request, response);
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
			responseHtml("Error", "Invalid request. " + e.getMessage(), response);
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid action");
		}

	}

	private void regist(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		try {
			String isbn = request.getParameter("isbn");
			String title = request.getParameter("title");
			String author = request.getParameter("author");
			int price = parseInt(request.getParameter("price"));
			String desc = request.getParameter("desc");
	
			Book book = new Book(isbn, title, author, price, desc);
			responseHtml("입력 내용", book.toString(), response);
		} catch (Exception e) {
			e.printStackTrace();
			responseHtml("Error", "Invalid request. " + e.getMessage(), response);
		}

		
	}

	private int parseInt(String value) {
		try {
			return Integer.parseInt(value);
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	private String escapeHtml(String value) {
		if (value == null) {
			return "";
		}

		return value.replace("&", "&amp;")
				.replace("<", "&lt;")
				.replace(">", "&gt;")
				.replace("\"", "&quot;")
				.replace("'", "&#39;");
	}
}
