package com.ssafy.exam.controller;

import java.io.IOException;



import com.ssafy.exam.model.service.CarServiceImpl;
import com.ssafy.exam.model.service.CarService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet()
public class CarController extends HttpServlet implements ControllerHelper {

	private final CarService mService = CarServiceImpl.getService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		}
	

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}


}
