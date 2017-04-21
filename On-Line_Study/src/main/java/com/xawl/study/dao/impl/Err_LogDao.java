package com.xawl.study.dao.impl;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.xawl.study.model.Err_Log;

@Repository
public class Err_LogDao extends BaseDaoImpl {

	public boolean addLog(Err_Log err_Log) {
		boolean isok = false;
		try {
			getSessionFactory().getCurrentSession().save(err_Log);
			isok = true;
		} catch (Exception e) {
			throw new RuntimeException("¥ÌŒÛ»’÷æ≤Â»Î ß∞‹£°");
		}

		return isok;

	}
}
