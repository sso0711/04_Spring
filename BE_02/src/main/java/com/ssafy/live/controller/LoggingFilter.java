package com.ssafy.live.controller;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/*")
public class LoggingFilter extends HttpFilter implements Filter {

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.printf("요청 정보 분석 %s, 요청 방식: %s%n",request.getRequestURI(), request.getMethod());
		System.out.println("파라미터 정보");
		request.getParameterMap().forEach((k,v)-> {
			System.out.printf("name: %s, v: %s\n", k, Arrays.toString(v));
		});
		System.out.println("----------------------------------------------");
		
		// 다음 필터 호출, 없다면 Servlet 호출
		super.doFilter(request, response, chain);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
