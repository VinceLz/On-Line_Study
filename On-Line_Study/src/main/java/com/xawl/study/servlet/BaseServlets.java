package com.xawl.study.servlet;

import javax.servlet.ServletException;

import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.itcast.servlet.BaseServlet;

public class BaseServlets extends BaseServlet {
	public void init() throws ServletException {
		super.init();
		WebApplicationContextUtils
				.getWebApplicationContext(getServletContext())
				.getAutowireCapableBeanFactory().autowireBean(this);
	}

}
