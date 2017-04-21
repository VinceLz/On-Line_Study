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
	

	//添加种类
	public String addCategory(Category c){
		if(categoryDao.addCategory(c)){
			return "添加成功！";
		}else{
			return "添加失败！";
		}
	}
	
	//依据ID查种类
	public Category findCategoryById(int cId){
		return categoryDao.findCategoryById(cId);
	}
	
	//删除种类
	public String deleteCategoryById(int cId){
		if(categoryDao.deleteCategoryById(cId)){
			return "删除成功！";
		}else{
			return "删除失败！";
		}
	}
	
	//查看所有种类
	public List<Category> findAllCategory(){
		return categoryDao.findAllCategory();
	}
	
	//分页
	public List<Category> queryByPage(Page page){
		return categoryDao.queryByPage(page);
	}
	
	// 得到种类总数
	public int countCategory(){
		return categoryDao.countCategory();
	}
	
	//修改种类
	public String updateCategory(int cId,Category category){
		if(categoryDao.updateCategory(cId,category)){
			return "更新成功！";
		}else{
			return "更新失败！";
		}
	}

	//根据兴趣分类id查种类
	public List<Category> findCategoryListByInterestId(int interestId) {
		List<Category> categoryList = categoryDao.findCategoryListByInterestId(interestId);
		return categoryList;
	}
}
