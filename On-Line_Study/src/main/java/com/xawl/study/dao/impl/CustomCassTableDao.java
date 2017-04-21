package com.xawl.study.dao.impl;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.xawl.study.model.CustomClassTable;
@Repository
public class CustomCassTableDao extends BaseDaoImpl {
	public boolean addCustomCassTable(CustomClassTable cct) {// Ìí¼ÓCustomCass
		boolean isok = false;
		Session session = getSessionFactory().getCurrentSession();
		try {
			session.save(cct);
			isok = true;
		} catch (Exception e) {
		}

		return isok;
	}

}
