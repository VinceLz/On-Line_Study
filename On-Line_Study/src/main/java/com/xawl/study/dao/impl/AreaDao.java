package com.xawl.study.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.xawl.study.model.Area;
@Repository
public class AreaDao extends BaseDaoImpl {

	public List<Area> GetAreaByCity(String cityID) {
		Session session = getSessionFactory().getCurrentSession();
		Query query = session.createQuery("from Area as a where a.fatherID='"
				+ cityID + "'");
		List<Area> allArea = query.list();
		return allArea;
	}

}
