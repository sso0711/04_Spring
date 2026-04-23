package com.ssafy.ws.step3.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface ControllerHelper {

    default String getActionParameter(HttpServletRequest request) {
        String action = request.getParameter("action");
        if (action == null || action.isBlank()) {
            action = "index";
        }
        return action;
    }

    default void redirect(HttpServletRequest request, HttpServletResponse response, String path) throws IOException {
        if (path.startsWith("http")) {
            response.sendRedirect(path);
            return;
        }
        response.sendRedirect(request.getContextPath() + path);
    }

    default void forward(HttpServletRequest request, HttpServletResponse response, String path)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(path);
        dispatcher.forward(request, response);
    }
}
