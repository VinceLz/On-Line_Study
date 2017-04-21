package com.xawl.study.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.xawl.study.model.City;
@Repository
public class CityDao extends BaseDaoImpl{
	public List<City> GetListByProvince(String provinceID){
		Session session = getSessionFactory().getCurrentSession();
		Query query=session.createQuery("from City as c where c.fatherID='"+provinceID+"'");
		List<City> allCity=query.list();
		
		return allCity;
		
	}
	public String getCityNameByCityID(String pid){
		Session session = getSessionFactory().getCurrentSession();
		Query query=session.createQuery("from City as c where c.cityID='"+pid+"'");
		City city=(City) query.uniqueResult();
		
		return city.getCity();
	}
}
