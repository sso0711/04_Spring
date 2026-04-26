package com.ssafy.exam.filter;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

// main의 모든 기능은 loginUser여야 가능 !
@WebFilter("/member/*")
public class SessionFilter extends HttpFilter {
	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
		String uri = req.getRequestURI();
		
		HttpSession session = req.getSession();
		if(session.getAttribute("loginUser") != null) {
			chain.doFilter(req, res);
		} else {
			session.setAttribute("alertMsg", "로그인 후 사용해주세요.");
			res.sendRedirect(req.getContextPath() + "/main?action=login-form");
		}
	}
}
// END
