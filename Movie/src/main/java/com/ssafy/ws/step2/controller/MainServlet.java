package com.ssafy.ws.step2.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.ws.step2.dto.Movie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/main")
public class MainServlet extends HttpServlet implements ControllerHelper {

	// 서버 메모리에 저장된 영화목록
	private List<Movie> movieList = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = getActionParameter(request, response);
        switch (action) {
        case "index" -> forward(request, response, "/index.jsp");
        // END
        case "regist-form" -> forward(request, response, "/regist_form.jsp");
        // END
        case "regist" -> regist(request, response);
        // END
        case "list" -> {
            request.setAttribute("list", movieList);
            forward(request, response, "/list.jsp");
        }
        // 오류 처리 방식: 잘못된 action 요청이 들어오면 404 에러를 발생
        default -> response.sendError(HttpServletResponse.SC_NOT_FOUND); // 404 처리
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = getActionParameter(req, resp);
        switch (action) {
        }
    }

    private void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
			String title = request.getParameter("title");
			String director = request.getParameter("director");
			String genre = request.getParameter("genre");
			int runningTime = Integer.parseInt(request.getParameter("runningTime"));
	
			Movie movie = new Movie(title, director, genre, runningTime);
			
			movieList.add(movie);
			
            request.setAttribute("result", movie);
        	//  forward vs redirect 차이는?
            forward(request, response, "regist_result.jsp");
            
        } catch (NumberFormatException e) {
            e.printStackTrace();
            request.setAttribute("alertMsg", e.getMessage());
            forward(request, response,"/regist_form.jsp");
        } catch (RuntimeException e) {
            e.printStackTrace();
            redirect(request, response, "http://www.google.com/");
        }
    }
}