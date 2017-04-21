package com.xawl.study.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.xawl.study.model.Administrator;
import com.xawl.study.service.AdminService;

public class UpdateAdminInfoServlet extends BaseServlets {
	@Autowired
	AdminService as;
	@Autowired
	Administrator ad;

	public String update(HttpServletRequest request,
			HttpServletResponse response) {
		ad.setAccount((String) request.getSession().getAttribute("admin"));
		Administrator admin = as.FindAdminByAccount(ad);
		String[] str = admin.getPicture().split(";");
		request.getSession().setAttribute("nakename", admin.getNikename());
		request.getSession().setAttribute("img", str[str.length - 1]);
		return "f:/Admin/index.jsp";

	}
}
