package com.xawl.study.dao.impl;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.xawl.study.model.Login_Log;
@Repository
public class Login_LogDao extends BaseDaoImpl {

	public boolean AddLogin_Log(Login_Log log) {// 添加访问日志
		boolean isok = false;
		try {
			getSessionFactory().getCurrentSession().save(log);
		} catch (Exception e) {
		}
		return isok;
	}
}
