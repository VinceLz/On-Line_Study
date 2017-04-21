package com.xawl.study.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xawl.study.dao.impl.CategoryDao;
import com.xawl.study.model.Category;
import com.xawl.study.model.Page;
import com.xawl.study.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	CategoryDao categoryDao ;
	

	//�������
	public String addCategory(Category c){
		if(categoryDao.addCategory(c)){
			return "��ӳɹ���";
		}else{
			return "���ʧ�ܣ�";
		}
	}
	
	//����ID������
	public Category findCategoryById(int cId){
		return categoryDao.findCategoryById(cId);
	}
	
	//ɾ������
	public String deleteCategoryById(int cId){
		if(categoryDao.deleteCategoryById(cId)){
			return "ɾ���ɹ���";
		}else{
			return "ɾ��ʧ�ܣ�";
		}
	}
	
	//�鿴��������
	public List<Category> findAllCategory(){
		return categoryDao.findAllCategory();
	}
	
	//��ҳ
	public List<Category> queryByPage(Page page){
		return categoryDao.queryByPage(page);
	}
	
	// �õ���������
	public int countCategory(){
		return categoryDao.countCategory();
	}
	
	//�޸�����
	public String updateCategory(int cId,Category category){
		if(categoryDao.updateCategory(cId,category)){
			return "���³ɹ���";
		}else{
			return "����ʧ�ܣ�";
		}
	}

	//������Ȥ����id������
	public List<Category> findCategoryListByInterestId(int interestId) {
		List<Category> categoryList = categoryDao.findCategoryListByInterestId(interestId);
		return categoryList;
	}
}
