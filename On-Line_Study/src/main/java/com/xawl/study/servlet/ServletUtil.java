package com.xawl.study.servlet;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.xawl.study.dao.impl.CommentDao;
import com.xawl.study.model.Acc_Log;
import com.xawl.study.model.Student;
import com.xawl.study.service.Acc_LogService;

@Service
public class ServletUtil {

	@Autowired
	CommentDao commentDao;

	@Autowired
	Acc_LogService acc_LogService;

	public void GetNotRedMessageCountToRequest(HttpServletRequest request) {
		// 获取未读消息数量
		try {
			int num1 = commentDao
					.FindForumCommentByNotReadAndUserAccountCount(((Student) request
							.getSession().getAttribute("user")).getAccount());
			request.setAttribute("notice", num1);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void AddAccess_Log(HttpServletRequest request) {
		String uri = request.getRequestURI();
		String account = "";
		try {
			account = ((Student) request.getSession().getAttribute("user"))
					.getAccount();
		} catch (Exception e) {
			// TODO: handle exception
			account = "游客访问";
		}

		Acc_Log acc_Log = new Acc_Log();
		acc_Log.setAcc_ip(request.getLocalAddr());
		acc_Log.setAcc_month(new Date().getMonth() + 1 + "");
		acc_Log.setAcc_time(new Date().toLocaleString());
		acc_Log.setAcc_url(uri);
		acc_Log.setRerv1(account);
		acc_LogService.AddLogin_Log(acc_Log);
	}
}
