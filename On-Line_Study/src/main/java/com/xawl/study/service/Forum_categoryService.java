package com.xawl.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xawl.study.dao.impl.Forum_categoryDao;
import com.xawl.study.model.Forum_category;

public interface Forum_categoryService {

	public boolean addForum_category(Forum_category forum);

	public List<Forum_category> FindForum_categoryBySupport();
}
