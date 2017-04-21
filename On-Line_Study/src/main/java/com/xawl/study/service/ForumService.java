package com.xawl.study.service;

import java.util.List;

import com.xawl.study.model.Forum;
import com.xawl.study.model.Page;

public interface ForumService {

	public boolean addForum(Forum forum);

	public List<Forum> FindForumByCategory_id(int id);

	public List<Forum> FindForumBySupport(Page page);

	public int FindForumBySupportCount();

	public List<Forum> FindForumByPub_Date();

	public List<Forum> FindForumByPub_DateNoPage();

	public List<Forum> FindForumByPub_Account(String account);

	public List<Forum> FindForumByPub_AccountAndCategory_id(String account,
			int sategoryId);

	public Forum FindForumByID(int id);

	public int FindForumByAccountNotPageCount(String account);

	public List<Forum> FindForumByAccountNotPage(String account);

	public List<Forum> FindForumByAccountPage(String account, Page page);
}
