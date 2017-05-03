package com.xawl.study.util;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xawl.study.model.Err_Log;
import com.xawl.study.model.Student;
import com.xawl.study.service.Err_LogService;
import com.xawl.study.servlet.ServletUtil;

@Component
public class LogFilter implements Filter {
	@Autowired
	Err_LogService err_LogService;
	@Autowired
	ServletUtil servletUtil;

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		servletUtil.AddAccess_Log((HttpServletRequest) request);
		servletUtil
				.GetNotRedMessageCountToRequest((HttpServletRequest) request);// ��δ������Ϣ�������뵽�û�request��

		try {
			chain.doFilter(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			Throwable rootCause = e;

			String message = e.getMessage();
			if (rootCause.getCause() instanceof IOException) {
				request.setAttribute("errMessage", "�����ʵ���Դ�����ڻ��ѱ�ɾ�����������԰�");
				request.getRequestDispatcher(
						"/User/Jsp/error/ResourceNotFond.jsp").forward(request,
						response);
				// ((HttpServletResponse)
				// response).sendRedirect(((HttpServletRequest)
				// request).getContextPath()+"/IndexDoorServlet?method=forowdNotice");
			}
			if (rootCause.getCause() instanceof NullPointerException) {
				request.setAttribute("errMessage", "���������ԴҲ��Ҫһ���ĸ�������������������������");
				request.getRequestDispatcher("/User/Jsp/error/NullPointErr.jsp")
						.forward(request, response);
			}
			if (rootCause.getCause() instanceof InvocationTargetException) {
				request.setAttribute("errMessage", "�������ϵͳ�ڲ�����");
				request.getRequestDispatcher("/User/Jsp/error/NullPointErr.jsp")
						.forward(request, response);
			}
			if (rootCause.getCause() instanceof NumberFormatException) {
				request.setAttribute("errMessage",
						"����ת���������������ǲ�������Ѳ������ֵ��ı���������");
				request.getRequestDispatcher("/User/Jsp/error/NullPointErr.jsp")
						.forward(request, response);
			}

			while (rootCause.getCause() != null) {
				rootCause = rootCause.getCause();

				Student stu = new Student();
				try {
					stu = (Student) ((HttpServletRequest) request).getSession()
							.getAttribute("user");
				} catch (Exception e2) {
					// TODO: handle exception
				}
				Err_Log err_Log = new Err_Log();
				err_Log.setInsert_time(new java.util.Date().toLocaleString());
				if (stu != null) {
					err_Log.setOper_user(stu.getAccount());
				} else {
					err_Log.setOper_user("�ο�");
				}
				err_Log.setErr_info(rootCause.getMessage());
				err_LogService.addLog(err_Log);
			}
			chain.doFilter(request, response);
			// request.getRequestDispatcher("/IndexDoorServlet?method=indexDoor").forward(request,
			// response);
		}

	}

	public void init(FilterConfig arg0) throws ServletException {

	}

	public void destroy() {

	}

}
