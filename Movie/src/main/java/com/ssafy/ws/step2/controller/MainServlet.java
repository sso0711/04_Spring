package com.ssafy.ws.step2.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.ws.step2.dao.MovieDao;
import com.ssafy.ws.step2.dto.Movie;
import com.ssafy.ws.step2.service.MainService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/movie")
public class MainServlet extends HttpServlet implements ControllerHelper {
	
	private MainService service = MainService.getInstance();
	
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = getActionParameter(request, response);
        switch (action) {
        case "index" -> forward(request, response, "/index.jsp");
        // END
        case "regist-form" -> forward(request, response, "/regist_form.jsp");
        // END
        case "list" -> {
            request.setAttribute("list", service.getList());
            forward(request, response, "/list.jsp");
        }
        case "detail" -> detail(request, response);
        case "delete" -> delete(request, response);
        // 오류 처리 방식: 잘못된 action 요청이 들어오면 404 에러를 발생
        default -> response.sendError(HttpServletResponse.SC_NOT_FOUND); // 404 처리
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = getActionParameter(request, response);
        switch (action) {
        	case "regist" -> regist(request, response);
        	// END
        }
    }

    private void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
			String title = request.getParameter("title");
			String director = request.getParameter("director");
			String genre = request.getParameter("genre");
			int runningTime = Integer.parseInt(request.getParameter("runningTime"));
	
			Movie movie = new Movie(title, director, genre, runningTime);
			
			service.regist(movie);
			// request.setAttribute("result", movie);
			
            String alertMsg = "등록되었습니다. 로그인 후 사용해주세요.";
            
            //request.setAttribute("alertMsg", alertMsg);
            HttpSession session = request.getSession();
            session.setAttribute("alertMsg",alertMsg);
            
            // forward(request, response, "regist_result.jsp");
            redirect(request, response, "/");
            
        } catch (NumberFormatException e) {
            e.printStackTrace();
            request.setAttribute("alertMsg", e.getMessage());
            forward(request, response,"/regist_form.jsp");
        } catch (RuntimeException e) {
            e.printStackTrace();
            redirect(request, response, "http://www.google.com/");
        }
    }
    
    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
        	
        	int code = Integer.parseInt(request.getParameter("code"));

            Movie movie = service.get(code);

            request.setAttribute("movie", movie);

            forward(request, response, "/detail.jsp");
        	
        	
        } catch (NumberFormatException e) {
            e.printStackTrace();
            request.setAttribute("alertMsg", e.getMessage());
            forward(request, response,"/regist_form.jsp");
        } catch (RuntimeException e) {
            e.printStackTrace();
            redirect(request, response, "http://www.google.com/");
        }
    }
    
    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int code = Integer.parseInt(request.getParameter("code"));

            service.delete(code);

            // 삭제 후 목록으로 이동
            redirect(request, response, "/movie?action=list");
        	
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