package com.xawl.study.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.servlet.BaseServlet;

public class loginservlet extends BaseServlets {
   public void login(HttpServletRequest reauest,HttpServletResponse response) throws IOException{
	   String name=reauest.getParameter("name");
	   PrintWriter out = response.getWriter();
	   out.print(name);
	   System.out.println(name);
   }
}
