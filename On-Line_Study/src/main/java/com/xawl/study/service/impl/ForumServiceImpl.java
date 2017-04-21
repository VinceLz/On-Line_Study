package com.xawl.study.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xawl.study.dao.impl.ForumDao;
import com.xawl.study.model.Forum;
import com.xawl.study.model.Page;
import com.xawl.study.service.ForumService;

@Service
public class ForumServiceImpl implements ForumService {
	@Autowired
	ForumDao dao;

	public boolean addForum(Forum forum) {// 添加帖子
		return dao.addForum(forum);
	}

	public List<Forum> FindForumByCategory_id(int id) {// 按照分类id查询帖子
		return dao.FindForumByCategory_id(id);
	}

	public List<Forum> FindForumBySupport(Page page) {// 按照点赞热度查询帖子
		return dao.FindForumBySupport(page);
	}

	public int FindForumBySupportCount() {// 按照点赞热度查询帖子
		return dao.FindForumBySupportCount();
	}

	public List<Forum> FindForumByPub_Date() {// 按照添加日期查询帖子
		return dao.FindForumByPub_Date();
	}

	public List<Forum> FindForumByPub_DateNoPage() {// 按照添加日期查询帖子
		return dao.FindForumByPub_DateNoPage();
	}

	public List<Forum> FindForumByPub_Account(String account) {// 按照账号查询帖子
		return dao.FindForumByPub_Account(account);
	}

	public List<Forum> FindForumByPub_AccountAndCategory_id(String account,
			int sategoryId) {// 按照账号和种类查询帖子
		return dao.FindForumByPub_AccountAndCategory_id(account, sategoryId);
	}

	public Forum FindForumByID(int id) {// 按照id查询帖子，唯一
		return dao.FindForumByID(id);
	}

	public int FindForumByAccountNotPageCount(String account) {// 按照发布帖子的人查询帖子数量,不分页
		return dao.FindForumByAccountNotPageCount(account);
	}

	public List<Forum> FindForumByAccountNotPage(String account) {// 按照发布帖子的人查询帖子,不分页
		return dao.FindForumByAccountNotPage(account);
	}

	public List<Forum> FindForumByAccountPage(String account, Page page) {// 按照发布帖子的人查询帖子
		return dao.FindForumByAccountPage(account, page);
	}
}
