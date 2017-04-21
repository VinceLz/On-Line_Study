package com.xawl.study.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import cn.itcast.servlet.BaseServlet;

import com.xawl.study.model.Administrator;
import com.xawl.study.service.AdminService;

public class AdminLoginServlet extends BaseServlets {
	@Autowired
	AdminService as;
	public String login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
            String name=request.getParameter("username");
            String password=request.getParameter("password");
            String code=request.getParameter("code");
            Administrator admin=new Administrator();
            if(request.getSession().getAttribute("random").equals(code))
            {
            	admin.setAccount(name);
                admin.setPwd(password);//f
                if(as.AdminLogin(admin)){
                	as.UpdateLoginTimeByAccount(admin);
                	//request.getRequestDispatcher("/Admin/index.jsp").forward(request, response);
                	String Agent = request.getHeader("User-Agent");
                	StringTokenizer st = new StringTokenizer(Agent,";");
                	//得到用户的浏览器名
                	String userbrowser = st.nextToken();
                	//得到用户的操作系统名
                	String useros = st.nextToken();
                	String os = System.getProperty("os.name");
                    String ip=request.getServerName(); 
                    request.getSession().setAttribute("userbrowser", userbrowser);
                    request.getSession().setAttribute("useros", useros);
                    request.getSession().setAttribute("UIP", request.getRemoteAddr());
                	request.getSession().setAttribute("os", os);	
                	request.getSession().setAttribute("count","5");
                	request.getSession().setAttribute("page", 1);
                	request.getSession().setAttribute("ip", ip);
                	Administrator administrator=new Administrator();
                	administrator=as.FindAdminByAccount(admin);
                	request.getSession().setAttribute("logintime", administrator.getLogintime());
                	request.getSession().setAttribute("nakename",administrator.getNikename() );
                	request.getSession().setAttribute("grade",administrator.getRank() );
                	request.getSession().setAttribute("admin", name);
                	String[] str= as.FindAdminByAccount(admin).getPicture().split(";");      	
                	request.getSession().setAttribute("img", str[str.length-1]);
                	request.getSession().setAttribute("time", new Date().toLocaleString());
                	//response.sendRedirect("Admin/index.jsp");
                	//request.getRequestDispatcher("Admin/index.jsp").forward(request, response);
                	return "f:Admin/index.jsp";
                }else{
                	//response.sendRedirect("Admin/Error/UserNameError.jsp");
                	//request.getRequestDispatcher("/Admin/Error/UserNaemError.jsp").forward(request, response);
                	return "f:/Admin/Error/UserNameError.jsp";
                }
            }else{
            	//response.sendRedirect("Admin/Error/CodeError.jsp");
            	return "f:Admin/Error/CodeError.jsp";
            	//request.getRequestDispatcher("/Admin/Error/CodeError.jsp").forward(request, response);
            }
            
	}

}
