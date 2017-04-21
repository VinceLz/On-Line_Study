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

	public boolean addForum(Forum forum) {// �������
		return dao.addForum(forum);
	}

	public List<Forum> FindForumByCategory_id(int id) {// ���շ���id��ѯ����
		return dao.FindForumByCategory_id(id);
	}

	public List<Forum> FindForumBySupport(Page page) {// ���յ����ȶȲ�ѯ����
		return dao.FindForumBySupport(page);
	}

	public int FindForumBySupportCount() {// ���յ����ȶȲ�ѯ����
		return dao.FindForumBySupportCount();
	}

	public List<Forum> FindForumByPub_Date() {// ����������ڲ�ѯ����
		return dao.FindForumByPub_Date();
	}

	public List<Forum> FindForumByPub_DateNoPage() {// ����������ڲ�ѯ����
		return dao.FindForumByPub_DateNoPage();
	}

	public List<Forum> FindForumByPub_Account(String account) {// �����˺Ų�ѯ����
		return dao.FindForumByPub_Account(account);
	}

	public List<Forum> FindForumByPub_AccountAndCategory_id(String account,
			int sategoryId) {// �����˺ź������ѯ����
		return dao.FindForumByPub_AccountAndCategory_id(account, sategoryId);
	}

	public Forum FindForumByID(int id) {// ����id��ѯ���ӣ�Ψһ
		return dao.FindForumByID(id);
	}

	public int FindForumByAccountNotPageCount(String account) {// ���շ������ӵ��˲�ѯ��������,����ҳ
		return dao.FindForumByAccountNotPageCount(account);
	}

	public List<Forum> FindForumByAccountNotPage(String account) {// ���շ������ӵ��˲�ѯ����,����ҳ
		return dao.FindForumByAccountNotPage(account);
	}

	public List<Forum> FindForumByAccountPage(String account, Page page) {// ���շ������ӵ��˲�ѯ����
		return dao.FindForumByAccountPage(account, page);
	}
}
