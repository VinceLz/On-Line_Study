package com.xawl.study.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.xawl.study.model.IndexModel;
@Repository
public class IndexModelDao extends BaseDaoImpl{
	
	
	//添加首页方案
	public boolean addIndexModel(IndexModel index){
		boolean isok = false;
		Session session = getSessionFactory().getCurrentSession();
		
		index.setIsUse(1);//默认为不启用
		try{
			session.save(index);
			isok = true;
		}catch(Exception e){
			isok = false;			
		}
		return isok;
	}
	
	//查找所有首页方案
	public List<IndexModel> findAllIndex(){
		Session session = getSessionFactory().getCurrentSession();
		Query query = session.createQuery("from IndexModel");
		List<IndexModel> IndexModelList = query.list();
		return IndexModelList;
	}
	
	//查找启用的首页方案
	public IndexModel findUseModel(){
		Session session = getSessionFactory().getCurrentSession();
		Query query = session.createQuery("from IndexModel as i where i.isUse = 0 ");
		IndexModel indexModel = (IndexModel) query.uniqueResult();
		return indexModel;		
	}
	
	//按照id查首页方案
	public IndexModel findIndexModelById(int id){
		Session session = getSessionFactory().getCurrentSession();
		Query query = session.createQuery("from IndexModel as i where i.indexId =" + id);
		IndexModel indexModel = (IndexModel) query.uniqueResult();
		return indexModel;	
	}
	
	//删除首页方案
	public boolean deleteIndexModelById(IndexModel index){
		Session session = getSessionFactory().getCurrentSession();
		boolean isok = false;
		try{
			session.delete(index);
			isok = true;
		}catch(Exception e){
			isok = false;
		}
		return isok;
		
	}
	
	//启用首页方案
	public boolean doUseIndexModel(int id){
		boolean isok = false;
		Session session = getSessionFactory().getCurrentSession();
		Query query = session.createQuery("update IndexModel as i set i.isUse = 0 where i.indexId =" + id);
		query.executeUpdate();
		return isok;
	}

	//关闭已经启用的方案
	public boolean closeUseIndex() {
		boolean isok = false;
		try{
			Session session = getSessionFactory().getCurrentSession();
			Query query = session.createQuery("update IndexModel as i set i.isUse = 1 where i.isUse = 0");
			query.executeUpdate();
			isok = true;
		}catch(Exception e){
			isok = false;
		}
		return isok;
	}
	
	//修改首页方案
	public boolean updateIndexModel(int indexId,IndexModel newIndexModel){
		boolean isok = false;
		Session session = getSessionFactory().getCurrentSession();
		
		IndexModel indexModel = new IndexModel();
		Query query = session.createQuery("from IndexModel as i where i.indexId = " + indexId);
		indexModel = (IndexModel) query.uniqueResult();
		
		try{
			indexModel = newIndexModel;
			indexModel.setIndexId(indexId);
			session.clear();
			session.update(indexModel);
			isok=true;
		}catch(Exception e){
			throw new RuntimeException("方案不存在，更新失败！");
		}
		return isok;
	}

	//按id和图片位置修改首页方案
	public boolean updateImage(int indexId, String location, String relativePath) {
		boolean isok = false;
		try{
			Session session = getSessionFactory().getCurrentSession();
			Query query = session.createQuery("update IndexModel as i set i." + location +"='" + "/"+relativePath +"' where i.indexId =" +indexId);
			query.executeUpdate();
			
			isok = true;
		}catch(Exception e){
			isok = false;
		}
		return isok;
	}
	
}
