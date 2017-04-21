package com.xawl.study.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.xawl.study.model.Forum_category;
@Repository
public class Forum_categoryDao extends BaseDaoImpl{
	
	public boolean addForum_category(Forum_category forum){//添加帖子
		boolean isok = false;
		Session session = getSessionFactory().getCurrentSession();
		try{
			session.save(forum);
			isok = true;
		}catch(Exception e){
			isok = false;			
		}
		return isok;	
	}
	@SuppressWarnings("unchecked")
	public List<Forum_category> FindForum_categoryBySupport(){//按照点赞热度查询帖子
		Session session = getSessionFactory().getCurrentSession();
		List<Forum_category> forumList=new ArrayList<Forum_category>();
		try {
			Query query = session.createQuery("from Forum_category as f  order by f.resv1 desc");
			query.setMaxResults(4);
			forumList=query.list();
			return forumList;
		} catch (Exception e) {
		}
		return forumList;
		
	}
}
