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
	public int CountComment() {// 得到评论的数量
		return commentDao.CountComment();
	}
	public List<Comment> FindAllComment() {// 获取所有评论的信息
		return commentDao.FindAllComment();
	}
	public List<Comment> FindCommentByRES(int res,int type) {// 获取所有评论的信息
		return commentDao.FindCommentByRES(res,type);
	}
	public List<Comment> FindCommentByRESFirst(int res,int type,Page page) {//获取资源id下的所有正常评论
		return commentDao.FindCommentByRESFirst(res, type, page);
	}
	public int FindCommentByRESCount(int res,int type) {//获取资源id下的所有正常评论数量
		return commentDao.FindCommentByRESCount(res, type);
	}

		
	public List<Comment> queryByPageAndRES(Page page,int res) {
		return commentDao.queryByPageAndRES(page, res);
	}
	public List<Comment> FindForumCommentByUserAccount(String account,Page page,int a) {// 查询一个用户在论坛的被回复的未读的帖子
		return commentDao.FindForumCommentByUserAccount(account,page,a);
	}
	public int FindForumCommentUserAccountCount(String account) {// 查询一个用户在论坛的被回复的帖子数量
		return commentDao.FindForumCommentByUserAccountCount(account);
	}
	public int FindForumCommentByNotReadAndUserAccountCount(String account) {// 查询一个用户在论坛的被回复的未读的帖子数量
		return commentDao.FindForumCommentByNotReadAndUserAccountCount(account);
	}
	public boolean SetCommentReadById(String id) {// 查询一个用户在论坛的被回复的未读的帖子数量
		return commentDao.SetCommentReadById(id);
	}
	public boolean SetCommentReadAll(String account) {// 修改未读帖子为已读，全部修改
		return commentDao.SetCommentReadAll( account);
	}
}
