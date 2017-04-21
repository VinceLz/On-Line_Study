
 package com.xawl.study.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import cn.itcast.servlet.BaseServlet;

import com.xawl.study.model.Administrator;
import com.xawl.study.service.AdminService;

public class AdminChangeImage extends BaseServlets {
	@Autowired
	AdminService as ;
	public String ChangeImage(HttpServletRequest request,
			HttpServletResponse response) {
		String picture = "header_images/"
				+ (String) request.getSession().getAttribute("picture");
		
		Administrator admin = new Administrator();
		admin.setAccount((String) request.getSession().getAttribute("admin"));
		admin.setPicture(request.getSession().getAttribute("img") + ";"
				+ picture);
		if (as.UpdatePictureByAccount(admin)) {
			return "f:/UpdateAdminInfoServlet?method=update";
		}else{
			return "f:/err.jsp";
		}
	}
}
