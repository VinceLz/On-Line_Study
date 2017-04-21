package com.xawl.study.dao.impl;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.xawl.study.model.Acc_Log;

@Repository
public class Acc_LogDao extends BaseDaoImpl {
	public boolean AddAcc_Log(Acc_Log log) {// 添加访问日志
		Session session = getSessionFactory().getCurrentSession();
		boolean isok = false;
		try {
			session.save(log);
			isok = true;
		} catch (Exception e) {
			isok = false;
		}
		return isok;
	}
}
