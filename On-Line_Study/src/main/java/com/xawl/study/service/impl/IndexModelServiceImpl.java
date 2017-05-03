package com.xawl.study.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xawl.study.dao.impl.IndexModelDao;
import com.xawl.study.model.IndexModel;
import com.xawl.study.service.IndexModelService;

@Service
public class IndexModelServiceImpl implements IndexModelService{
	@Autowired
	IndexModelDao indexModelDao ;
	//�����ҳ����
	public String addIndexModel(IndexModel index){
		if(indexModelDao.addIndexModel(index)){
			return "��ӳɹ���";
		}else{
			return "���ʧ�ܣ����Ժ����ԣ�";
		}
	}
	
	//����������ҳ����
	public List<IndexModel> findAllIndex(){
		return indexModelDao.findAllIndex();
	}
	
	//�������õ���ҳ����
	public IndexModel findUseModel(){
		return indexModelDao.findUseModel();
	}
	
	//����id����ҳ����
	public IndexModel findIndexModelById(int id){
		return indexModelDao.findIndexModelById(id);
	}
	
	//ɾ����ҳ����
	public String deleteIndexModelById(int id){
		IndexModel indexModel = new IndexModel();
		indexModel = this.findIndexModelById(id);
		if(indexModel != null){
			if(indexModelDao.deleteIndexModelById(indexModel)){
				return "ɾ���ɹ���";
			}else{
				return "δ֪ԭ��ɾ��ʧ�ܣ�";
			}			
		}else{
			return"����ҳ���������ڣ�ɾ��ʧ�ܣ�";
		}
	}

	//�ر��Ѿ����õķ���
	public boolean closeUseIndex() {
		return indexModelDao.closeUseIndex();
	}
	
	//��id�޸���ҳ����
	public String updateIndexModelById(int id,IndexModel indexModel){
		if(indexModelDao.updateIndexModel(id, indexModel)){
			return "���³ɹ���";
		}else{
			return "����ʧ�ܣ�";
		}
	}

	//��id��ͼƬλ���޸���ҳ����
	public String updateImage(int indexId, String location, String relativePath) {
		if(indexModelDao.updateImage(indexId, location,relativePath)){
			return "����ͼƬ�ɹ���";
		}else{
			return "����ͼƬʧ�ܣ�";
		}
		
	}
	
}
