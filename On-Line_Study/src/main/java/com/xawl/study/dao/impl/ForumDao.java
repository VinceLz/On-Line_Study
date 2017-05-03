package com.xawl.study.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.xawl.study.model.Forum;
import com.xawl.study.model.Page;
@Repository
public class ForumDao extends BaseDaoImpl{
	public boolean addForum(Forum forum){//�������
		boolean isok = false;
		try{
			getSessionFactory().getCurrentSession().save(forum);
			isok = true;
		}catch(Exception e){
			isok = false;			
		}
		return isok;	
	}
	public boolean UpdateForumCommentCountByForumId(String id) {
		Session session = getSessionFactory().getCurrentSession();
		Query query = session.createQuery("update Forum c set c.resv2=c.resv2+1 where c.id='"+id+"'");
		int i=query.executeUpdate();
		if(i>0){
			return true;
		}
		return false;
	}
	@SuppressWarnings("unchecked")
	public List<Forum> FindForumByCategory_id(int id){//���շ���id��ѯ����
		
		List<Forum> forumList=new ArrayList<Forum>();
		try {
			Query query = getSessionFactory().getCurrentSession().createQuery("from Forum as f where f.category_id="+id);
			forumList=query.list();
			return forumList;
		} catch (Exception e) {
		}
		return forumList;
		
	}
	
@SuppressWarnings("unchecked")
public List<Forum> FindForumByAccountPage(String account,Page page){//���շ������ӵ��˲�ѯ����
		List<Forum> forumList=new ArrayList<Forum>();
		try {
			Query query = getSessionFactory().getCurrentSession().createQuery("from Forum as f where f.pub_account="+account+" order by f.last_update_date desc ");
			query.setMaxResults(page.getEveryPage());
			query.setFirstResult(page.getBeginIndex());
			forumList=query.list();
			return forumList;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return forumList;
		
	}
public List<Forum> FindForumByAccountNotPage(String account ){//���շ������ӵ��˲�ѯ����,����ҳ
	List<Forum> forumList=new ArrayList<Forum>();
	try {
		Query query = getSessionFactory().getCurrentSession().createQuery("from Forum as f where f.pub_account="+account+" order by f.last_update_date desc ");
		forumList=query.list();
		return forumList;
	} catch (Exception e) {
		// TODO: handle exception
	}
	return forumList;
}
public int FindForumByAccountNotPageCount(String account ){//���շ������ӵ��˲�ѯ��������,����ҳ
	List<Forum> forumList=new ArrayList<Forum>();
	try {
		Query query = getSessionFactory().getCurrentSession().createQuery("from Forum as f where f.pub_account="+account+" order by f.last_update_date desc ");
		forumList=query.list();
		return forumList.size();
	} catch (Exception e) {
		// TODO: handle exception
	}
	return forumList.size();
}
	@SuppressWarnings("unchecked")
	public List<Forum> FindForumBySupport(Page page){//���յ����ȶȲ�ѯ����
		
		List<Forum> forumList=new ArrayList<Forum>();
		try {
			Query query = getSessionFactory().getCurrentSession().createQuery("from Forum as f where f.resv1=0 order by f.support desc");
			query.setMaxResults(page.getEveryPage());
			query.setFirstResult(page.getBeginIndex());
			forumList=query.list();
			return forumList;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return forumList;
		
	}
	@SuppressWarnings("unchecked")
	public int FindForumBySupportCount(){//���յ����ȶȲ�ѯ����
		
		List<Forum> forumList=new ArrayList<Forum>();
		try {
			Query query = getSessionFactory().getCurrentSession().createQuery("from Forum as f where f.resv1=0 order by f.support desc");
			forumList=query.list();
			return forumList.size();
		} catch (Exception e) {
		}
		return forumList.size();
		
	}
	@SuppressWarnings("unchecked")
	public List<Forum> FindForumByPub_Date(){//����������ڲ�ѯ����
		
		List<Forum> forumList=new ArrayList<Forum>();
		try {
			Query query = getSessionFactory().getCurrentSession().createQuery("from Forum as f where f.resv1=0 order by f.pub_date desc");
			query.setMaxResults(4);
			forumList=query.list();
			return forumList;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return forumList;
		
	}
	public List<Forum> FindForumByPub_DateNoPage(){//����������ڲ�ѯ����
		
		List<Forum> forumList=new ArrayList<Forum>();
		try {
			Query query = getSessionFactory().getCurrentSession().createQuery("from Forum as f where f.resv1=0 order by f.support desc");
			forumList=query.list();
			return forumList;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return forumList;
		
	}
	@SuppressWarnings("unchecked")
	public List<Forum> FindForumByPub_Account(String account){//�����˺Ų�ѯ����
		
		List<Forum> forumList=new ArrayList<Forum>();
		try {
			Query query = getSessionFactory().getCurrentSession().createQuery("from Forum as f where f.pub_account ="+account);
			forumList=query.list();
			return forumList;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return forumList;
		
	}
	@SuppressWarnings("unchecked")
	public List<Forum> FindForumByPub_AccountAndCategory_id(String account,int sategoryId){//�����˺ź������ѯ����
		
		List<Forum> forumList=new ArrayList<Forum>();
		try {
			Query query = getSessionFactory().getCurrentSession().createQuery("from Forum as f where f.pub_account ="+account +" and f.category_id="+sategoryId);
			forumList=query.list();
			return forumList;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return forumList;
		
	}
	public Forum FindForumByID(int id){//����id��ѯ���ӣ�Ψһ
		
		Forum forum=new Forum();
		try {
			Query query = getSessionFactory().getCurrentSession().createQuery("from Forum as f where f.id ="+id );
			forum=(Forum) query.uniqueResult();
			Query query1 = getSessionFactory().getCurrentSession().createQuery("update Forum as f set f.support=f.support+1 where f.id="+id);
			int i=query1.executeUpdate();
			return forum;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return forum;
		
	}
}
