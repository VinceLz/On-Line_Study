package com.xawl.study.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xawl.study.dao.impl.Login_LogDao;
import com.xawl.study.model.Login_Log;
import com.xawl.study.service.Login_LogService;

@Service
public class Login_LogServiceImpl implements Login_LogService {
	@Autowired
	Login_LogDao log;

	public boolean AddLogin_Log(Login_Log log) {// 添加访问日志
		return this.log.AddLogin_Log(log);
	}
}
