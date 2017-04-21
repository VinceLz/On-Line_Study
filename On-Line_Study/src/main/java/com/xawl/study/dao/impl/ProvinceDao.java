package com.xawl.study.dao.impl;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.xawl.study.model.Province;
@Repository
public class ProvinceDao extends BaseDaoImpl{
	public List<Province> GetAllProvinceList(){
		Session session = getSessionFactory().getCurrentSession();
		Query query=session.createQuery("from Province");
		List<Province> allProvince=query.list();
		
		return allProvince;
	}
	public String getProvinceNameByID(String id){
		Session session = getSessionFactory().getCurrentSession();
		Query query=session.createQuery("from Province as p where p.provinceID='"+id+"'");
		Province province=(Province) query.uniqueResult();
		
		return province.getProvince();
	}
}
