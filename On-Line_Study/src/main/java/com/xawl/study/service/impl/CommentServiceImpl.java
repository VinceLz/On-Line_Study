package com.xawl.study.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xawl.study.dao.impl.CommentDao;
import com.xawl.study.model.Comment;
import com.xawl.study.model.Page;
import com.xawl.study.service.CommentService;
@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	CommentDao commentDao;
	public boolean AddComment(Comment comment) {
		return commentDao.AddComment(comment);
	}
	public List<Comment> queryByPage(Page page) {
		return commentDao.queryByPage(page);
	}
	public int CountComment() {// �õ����۵�����
		return commentDao.CountComment();
	}
	public List<Comment> FindAllComment() {// ��ȡ�������۵���Ϣ
		return commentDao.FindAllComment();
	}
	public List<Comment> FindCommentByRES(int res,int type) {// ��ȡ�������۵���Ϣ
		return commentDao.FindCommentByRES(res,type);
	}
	public List<Comment> FindCommentByRESFirst(int res,int type,Page page) {//��ȡ��Դid�µ�������������
		return commentDao.FindCommentByRESFirst(res, type, page);
	}
	public int FindCommentByRESCount(int res,int type) {//��ȡ��Դid�µ�����������������
		return commentDao.FindCommentByRESCount(res, type);
	}

		
	public List<Comment> queryByPageAndRES(Page page,int res) {
		return commentDao.queryByPageAndRES(page, res);
	}
	public List<Comment> FindForumCommentByUserAccount(String account,Page page,int a) {// ��ѯһ���û�����̳�ı��ظ���δ��������
		return commentDao.FindForumCommentByUserAccount(account,page,a);
	}
	public int FindForumCommentUserAccountCount(String account) {// ��ѯһ���û�����̳�ı��ظ�����������
		return commentDao.FindForumCommentByUserAccountCount(account);
	}
	public int FindForumCommentByNotReadAndUserAccountCount(String account) {// ��ѯһ���û�����̳�ı��ظ���δ������������
		return commentDao.FindForumCommentByNotReadAndUserAccountCount(account);
	}
	public boolean SetCommentReadById(String id) {// ��ѯһ���û�����̳�ı��ظ���δ������������
		return commentDao.SetCommentReadById(id);
	}
	public boolean SetCommentReadAll(String account) {// �޸�δ������Ϊ�Ѷ���ȫ���޸�
		return commentDao.SetCommentReadAll( account);
	}
}
