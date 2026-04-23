package com.ssafy.exam.controller;

import java.io.IOException;

import com.ssafy.exam.model.service.CarServiceImpl;
import com.ssafy.exam.model.dto.Car;
import com.ssafy.exam.model.service.CarService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/main")
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
				forward(request, response,"/list.jsp");
			}
			case "car-form" -> forward(request, response,"/regist.jsp");
			// case "detail" -> detail(request,response);
		}
	}
	

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = getActionParameter(request, response);
		switch(action) {
			case "regist" -> regist(request,response);
			case "edit" -> regist(request,response);
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
		
		String alertMsg = "등록되었습니다. 로그인 후 사용해주세요.";
        HttpSession session = request.getSession();
        session.setAttribute("alertMsg", alertMsg);
        redirect(request, response, "/");
	}
}
