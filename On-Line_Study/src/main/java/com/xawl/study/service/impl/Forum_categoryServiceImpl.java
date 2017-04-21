package com.xawl.study.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xawl.study.dao.impl.Forum_categoryDao;
import com.xawl.study.model.Forum_category;
import com.xawl.study.service.Forum_categoryService;

@Service
public class Forum_categoryServiceImpl implements Forum_categoryService{
	@Autowired
	private Forum_categoryDao categoryDao;
	public boolean addForum_category(Forum_category forum){//添加帖子
		return categoryDao.addForum_category(forum);
	}
	public List<Forum_category> FindForum_categoryBySupport(){//按照点赞热度查询帖子
		return categoryDao.FindForum_categoryBySupport();
	}
}
