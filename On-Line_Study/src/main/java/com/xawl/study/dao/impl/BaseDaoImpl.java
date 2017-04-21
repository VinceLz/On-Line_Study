package com.xawl.study.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.xawl.study.dao.BaseDao;

/**
 * 
 * @author kernel dao层基类实现
 * @param <T>
 */
@Repository
public class BaseDaoImpl<T> implements BaseDao {
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
