package com.xawl.study.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.xawl.study.model.Category;
import com.xawl.study.model.Page;
@Repository
public class CategoryDao extends BaseDaoImpl<Category> {

	// �������
	public boolean addCategory(Category c) {
		boolean isok = false;
		Session session = getSessionFactory().getCurrentSession();
		try {
			session.save(c);
			isok = true;
		} catch (Exception e) {
			isok = false;
		}

		return isok;
	}

	// ����ID������
	public Category findCategoryById(int cId) {
		Session session = getSessionFactory().getCurrentSession();
		Query query = session
				.createQuery("from Category as c where c.categoryId = " + cId);
		Category category = (Category) query.uniqueResult();
		return category;
	}

	// ɾ������
	public boolean deleteCategoryById(int cId) {
		boolean isok = false;
		Session session = getSessionFactory().getCurrentSession();
		Category category = findCategoryById(cId);
		try {
			session.delete(category);
			isok = true;
		} catch (Exception e) {
			isok = false;
		}

		return isok;
	}

	// �鿴��������
	public List<Category> findAllCategory() {
		Session session = getSessionFactory().getCurrentSession();
		Query query = session.createQuery("from Category");
		List<Category> categoryList = query.list();

		return categoryList;
	}

	// ��ҳ
	public List<Category> queryByPage(Page page) {
		List<Category> categoryList = new ArrayList<Category>();
		Session session = getSessionFactory().getCurrentSession();
		Query query = session.createQuery("from Category");
		// ����ÿҳ��ʾ���ٸ������ö������
		query.setMaxResults(page.getEveryPage());
		// �������
		query.setFirstResult(page.getBeginIndex());
		categoryList = query.list();

		return categoryList;
	}

	// �õ���������
	public int countCategory() {
		int sum = 0;
		Session session = getSessionFactory().getCurrentSession();
		Query query = session.createQuery("from Category");
		List<Category> categoryList = new ArrayList<Category>();
		categoryList = query.list();
		sum = categoryList.size();
		return sum;
	}

	// ��������
	public boolean updateCategory(int cId, Category newCategory) {
		boolean isok = false;
		Session session = getSessionFactory().getCurrentSession();
		Category category = new Category();

		Query query = session
				.createQuery("from Category as c where c.categoryId = " + cId);
		category = (Category) query.uniqueResult();
		try {
			category = newCategory;
			category.setCategoryId(cId);
			session.clear();
			session.update(category);

			isok = true;
		} catch (Exception e) {
			throw new RuntimeException("���಻���ڣ�����ʧ�ܣ�");
		}
		return isok;
	}

	// ������Ȥ����id������
	public List<Category> findCategoryListByInterestId(int id) {
		List<Category> categoryList = new ArrayList<Category>();
		Session session = getSessionFactory().getCurrentSession();
		Query query = session
				.createQuery("from Category as c where c.beLongToInterestID = ?");
		query.setInteger(0, id);
		categoryList = query.list();

		return categoryList;
	}
}
