package com.ssafy.exam.controller;

import java.io.IOException;

import com.ssafy.exam.model.service.CarServiceImpl;
import com.ssafy.exam.model.dto.Member;
import com.ssafy.exam.model.dto.Car;
import com.ssafy.exam.model.service.CarService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet({"/main", "/member"})
public class CarController extends HttpServlet implements ControllerHelper {

	private static final long serialVersionUID = 1L;
	
	private final CarService mService = CarServiceImpl.getService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = getActionParameter(request, response);
		switch(action) {
			case "index" -> forward(request, response, "/index.jsp"); 
			case "list" -> {
				request.setAttribute("list", mService.selectAll());
				forward(request, response,"car/list.jsp");
			}
			case "regist-form" -> forward(request, response,"car/regist-form.jsp");
			case "login-form" -> forward(request, response,"/login-form.jsp");
			case "modify-form" -> modifyForm(request,response);
			case "detail" -> detail(request,response);
			case "delete" -> delete(request, response);
			case "logout" -> logout(request, response);
			// default -> response.sendError(HttpServletResponse.SC_NOT_FOUND); // 404 처리
	        default -> forward(request, response, "/error/404.jsp");
		}
	}
	

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = getActionParameter(request, response);
		switch(action) {
			case "regist" -> regist(request,response);
			case "modify" -> modify(request,response);
			case "login" -> login(request,response);
			// default -> response.sendError(HttpServletResponse.SC_NOT_FOUND); // 404 처리
	        default -> forward(request, response, "/error/404.jsp");
		}
	}
	
	private void regist (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String code = request.getParameter("code");
		String model = request.getParameter("model");
		int price = Integer.parseInt(request.getParameter("price"));
		String vendor = request.getParameter("vendor");
		String size = request.getParameter("size");
		
		Car car = new Car(code, model, price, vendor, size);
		
		mService.insert(car);
		
		String alertMsg = "등록되었습니다.";
        HttpSession session = request.getSession();
        session.setAttribute("alertMsg", alertMsg);
        redirect(request, response, "/");
	}
	
	private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
        	String code = request.getParameter("code");

            Car car= mService.get(code);

            request.setAttribute("car", car);

	        forward(request, response, "/car/detail.jsp");
        	
        } catch (NumberFormatException e) {
            e.printStackTrace();
            request.setAttribute("alertMsg", e.getMessage());
	        forward(request, response,"/car/list.jsp");
        } catch (RuntimeException e) {
            e.printStackTrace();
            redirect(request, response, "http://www.google.com/");
        }
    }
	
	private void modifyForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        	String code = request.getParameter("code");

            Car car= mService.get(code);

            request.setAttribute("car", car);

            forward(request, response, "/modify-form.jsp");
    }
	
	private void modify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        	
			String code = request.getParameter("code");
			String model = request.getParameter("model");
			int price = Integer.parseInt(request.getParameter("price"));
			String vendor = request.getParameter("vendor");
			String size = request.getParameter("size");

            Car car = new Car(code, model, price, vendor, size);
            
            mService.modify(car);
            
            String alertMsg = "수정되었습니다.";
            HttpSession session = request.getSession();
            session.setAttribute("alertMsg", alertMsg);
	            redirect(request, response, "/main?action=list");
	}        	

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		mService.delete(code);

		HttpSession session = request.getSession();
		session.setAttribute("alertMsg", "삭제되었습니다.");
		redirect(request, response, "/member?action=list");
	}
	
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		String rememberMe = request.getParameter("remember-me");

		Member member = mService.login(email, pass);
		
		
		// 성공
        if(member != null) {
        	HttpSession session = request.getSession();
        	session.setAttribute("loginUser", member);
        	session.setAttribute("alertMsg", "로그인되었습니다.");

			Cookie cookie = new Cookie("rememberId", email);
			cookie.setPath(request.getContextPath());
			
			if (rememberMe != null) {
				cookie.setMaxAge(60 * 60 * 24 * 30);
			} else {
				cookie.setMaxAge(0);
			}
			response.addCookie(cookie);

        	redirect(request, response, "/main");
        // 실패
        }else {
        	request.setAttribute("alertMsg", "login fail");
        	forward(request, response, "/login-form.jsp");
        }
		
	}
	
	private void logout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
    	request.getSession().invalidate();
    	redirect(request,response,"/main");
    }

}
