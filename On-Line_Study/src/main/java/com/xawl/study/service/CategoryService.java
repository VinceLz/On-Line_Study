package com.xawl.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xawl.study.dao.impl.CategoryDao;
import com.xawl.study.model.Category;
import com.xawl.study.model.Page;

public interface CategoryService {

	// �������
	public String addCategory(Category c);

	// ����ID������
	public Category findCategoryById(int cId);

	// ɾ������
	public String deleteCategoryById(int cId);

	// �鿴��������
	public List<Category> findAllCategory();

	// ��ҳ
	public List<Category> queryByPage(Page page);

	// �õ���������
	public int countCategory();

	// �޸�����
	public String updateCategory(int cId, Category category);

	// ������Ȥ����id������
	public List<Category> findCategoryListByInterestId(int interestId);
}
