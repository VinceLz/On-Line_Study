package com.xawl.study.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.xawl.study.model.IndexModel;
@Repository
public class IndexModelDao extends BaseDaoImpl{
	
	
	//�����ҳ����
	public boolean addIndexModel(IndexModel index){
		boolean isok = false;
		Session session = getSessionFactory().getCurrentSession();
		
		index.setIsUse(1);//Ĭ��Ϊ������
		try{
			session.save(index);
			isok = true;
		}catch(Exception e){
			isok = false;			
		}
		return isok;
	}
	
	//����������ҳ����
	public List<IndexModel> findAllIndex(){
		Session session = getSessionFactory().getCurrentSession();
		Query query = session.createQuery("from IndexModel");
		List<IndexModel> IndexModelList = query.list();
		return IndexModelList;
	}
	
	//�������õ���ҳ����
	public IndexModel findUseModel(){
		Session session = getSessionFactory().getCurrentSession();
		Query query = session.createQuery("from IndexModel as i where i.isUse = 0 ");
		IndexModel indexModel = (IndexModel) query.uniqueResult();
		return indexModel;		
	}
	
	//����id����ҳ����
	public IndexModel findIndexModelById(int id){
		Session session = getSessionFactory().getCurrentSession();
		Query query = session.createQuery("from IndexModel as i where i.indexId =" + id);
		IndexModel indexModel = (IndexModel) query.uniqueResult();
		return indexModel;	
	}
	
	//ɾ����ҳ����
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
	
	//������ҳ����
	public boolean doUseIndexModel(int id){
		boolean isok = false;
		Session session = getSessionFactory().getCurrentSession();
		Query query = session.createQuery("update IndexModel as i set i.isUse = 0 where i.indexId =" + id);
		query.executeUpdate();
		return isok;
	}

	//�ر��Ѿ����õķ���
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
	
	//�޸���ҳ����
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
			throw new RuntimeException("���������ڣ�����ʧ�ܣ�");
		}
		return isok;
	}

	//��id��ͼƬλ���޸���ҳ����
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
