package com.xawl.study.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminLoginOutServlet extends BaseServlets {
	public String logout(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		request.getSession().invalidate();
		//response.sendRedirect("Admin/index.jsp");
		return "r:/Admin/index.jsp";
	}
}
