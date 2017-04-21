package com.xawl.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xawl.study.dao.impl.CategoryDao;
import com.xawl.study.model.Category;
import com.xawl.study.model.Page;

public interface CategoryService {

	// 添加种类
	public String addCategory(Category c);

	// 依据ID查种类
	public Category findCategoryById(int cId);

	// 删除种类
	public String deleteCategoryById(int cId);

	// 查看所有种类
	public List<Category> findAllCategory();

	// 分页
	public List<Category> queryByPage(Page page);

	// 得到种类总数
	public int countCategory();

	// 修改种类
	public String updateCategory(int cId, Category category);

	// 根据兴趣分类id查种类
	public List<Category> findCategoryListByInterestId(int interestId);
}
