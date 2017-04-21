package com.xawl.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xawl.study.dao.impl.CommentDao;
import com.xawl.study.model.Comment;
import com.xawl.study.model.Page;

public interface CommentService {

	public boolean AddComment(Comment comment);

	public List<Comment> queryByPage(Page page);

	public int CountComment();

	public List<Comment> FindAllComment();

	public List<Comment> FindCommentByRES(int res, int type);

	public List<Comment> FindCommentByRESFirst(int res, int type, Page page);

	public int FindCommentByRESCount(int res, int type);

	public List<Comment> queryByPageAndRES(Page page, int res);

	public List<Comment> FindForumCommentByUserAccount(String account,
			Page page, int a);

	public int FindForumCommentUserAccountCount(String account);

	public int FindForumCommentByNotReadAndUserAccountCount(String account);

	public boolean SetCommentReadById(String id);

	public boolean SetCommentReadAll(String account);
}
