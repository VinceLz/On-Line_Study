package com.xawl.study.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.servlet.BaseServlet;

public class AdminChangeCountServlet extends BaseServlets {
	public String change(HttpServletRequest request, HttpServletResponse responsse)
			throws IOException {
		String count = request.getParameter("count");
		request.getSession().setAttribute("page", "1");
		request.getSession().setAttribute("count", count);
		return "f:/AdminShowUserInfoServlet?method=showinfo&count="
						+ request.getSession().getAttribute("count") + "&page="
						+ request.getSession().getAttribute("page") ;
	}
}
