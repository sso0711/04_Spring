package com.ssafy.ws.step3.controller;

import java.io.IOException;

import com.ssafy.ws.step3.dto.Book;
import com.ssafy.ws.step3.service.BookService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/book")
public class MainServlet extends HttpServlet implements ControllerHelper {

    private static final long serialVersionUID = 1L;

    private final BookService service = BookService.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = getActionParameter(request);

        switch (action) {
        case "index":
            forward(request, response, "/index.jsp");
            break;
        case "regist-form":
            forward(request, response, "/regist-form.jsp");
            break;
        case "list":
            request.setAttribute("bookList", service.getList());
            forward(request, response, "/list.jsp");
            break;
        default:
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String action = getActionParameter(request);

        switch (action) {
        case "regist":
            regist(request, response);
            break;
        default:
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            break;
        }
    }

    private void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String isbn = request.getParameter("isbn");
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        int price = Integer.parseInt(request.getParameter("price"));
        String desc = request.getParameter("desc");

        Book book = new Book(isbn, title, author, price, desc);
        service.regist(book);

        request.setAttribute("book", book);
        forward(request, response, "/regist-result.jsp");
    }
}
