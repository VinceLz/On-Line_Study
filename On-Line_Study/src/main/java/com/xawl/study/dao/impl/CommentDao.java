package com.xawl.study.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.xawl.study.model.Comment;
import com.xawl.study.model.Page;
@Repository
public class CommentDao extends BaseDaoImpl {
	public boolean AddComment(Comment comment) {
		boolean isok = false;
		Session session = getSessionFactory().getCurrentSession();
		try {
			session.save(comment);
			if (comment.getComment_to_user_acct() == null) {
				new ForumDao().UpdateForumCommentCountByForumId(comment
						.getResv1());
			}
			isok = true;

		} catch (Exception e) {
		}

		return isok;
	}

	public List<Comment> queryByPage(Page page) {
		List<Comment> comment = new ArrayList<Comment>();
		Session session = getSessionFactory().getCurrentSession();
		Query query = session.createQuery("from Comment");
		// ����ÿҳ��ʾ���ٸ������ö������
		query.setMaxResults(page.getEveryPage());
		// �������
		query.setFirstResult(page.getBeginIndex());
		comment = query.list();

		return comment;
	}

	public int CountComment() {// �õ�����Ա������
		int sum = 0;
		Session session = getSessionFactory().getCurrentSession();
		Query query = session.createQuery("from Comment");
		List<Comment> admin = new ArrayList<Comment>();
		admin = query.list();
		sum = admin.size();

		return sum;
	}

	public List<Comment> FindAllComment() {// ��ȡ���й���Ա����Ϣ
		List<Comment> comment = new ArrayList<Comment>();
		Session session = getSessionFactory().getCurrentSession();
		Query query = session.createQuery("from Comment");
		comment = query.list();

		return comment;
	}

	public List<Comment> FindForumCommentByUserAccount(String account,
			Page page, int a) {// ��ѯһ���û�����̳�ı��ظ������еĵ�����
		List<Comment> comment = new ArrayList<Comment>();
		Session session = getSessionFactory().getCurrentSession();
		Query query = session
				.createQuery("from Comment c where c.comment_type=1 and c.resv2=0 and c.comment_to_user_acct='"
						+ account + "' order by c.read_state desc");
		query.setMaxResults(page.getEveryPage());
		query.setFirstResult(page.getBeginIndex());
		comment = query.list();
		return comment;
	}

	public int FindForumCommentByUserAccountCount(String account) {// ��ѯһ���û�����̳�ı��ظ�����������
		List<Comment> comment = new ArrayList<Comment>();
		Session session = getSessionFactory().getCurrentSession();
		Query query = session
				.createQuery("from Comment c where c.comment_type=1 and c.resv2=0 and c.comment_to_user_acct='"
						+ account + "'");
		comment = query.list();
		return comment.size();
	}

	public int FindForumCommentByNotReadAndUserAccountCount(String account) {// ��ѯһ���û�����̳�ı��ظ���δ������������
		List<Comment> comment = new ArrayList<Comment>();
		Session session = getSessionFactory().getCurrentSession();
		Query query = session
				.createQuery("from Comment c where c.comment_type=1 and c.resv2=0 and c.read_state=1 and c.comment_to_user_acct='"
						+ account + "'");
		comment = query.list();
		return comment.size();
	}

	public boolean SetCommentReadById(String id) {// �޸�δ������Ϊ�Ѷ�������id
		Session session = getSessionFactory().getCurrentSession();
		Query query = session
				.createQuery("update Comment c set c.read_state=0 where c.id="
						+ id);
		int i = query.executeUpdate();
		if (i > 0) {
			return true;
		}
		return false;
	}

	public boolean SetCommentReadAll(String account) {// �޸�δ������Ϊ�Ѷ���ȫ���޸�
		Session session = getSessionFactory().getCurrentSession();
		Query query = session
				.createQuery("update Comment c set c.read_state=0 where c.comment_to_user_acct='"
						+ account + "'");
		int i = query.executeUpdate();
		if (i > 0) {
			return true;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	public List<Comment> FindCommentByRES(int res, int type) {// ��ȡ��Դid�µ�������������
		List<Comment> comment = new ArrayList<Comment>();
		try {
			Session session = getSessionFactory().getCurrentSession();
			Query query = null;
			if (type == 1) {
				query = session
						.createQuery("from Comment as c where c.resv2='0' and c.comment_type="
								+ type
								+ " and c.resv1="
								+ res
								+ " order by c.comment_date asc");
			} else {
				query = session
						.createQuery("from Comment as c where c.resv2='0' and c.comment_type="
								+ type
								+ " and c.resv1="
								+ res
								+ " order by c.comment_date desc");
			}
			comment = query.list();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return comment;
	}

	@SuppressWarnings("unchecked")
	public List<Comment> FindCommentByRESFirst(int res, int type, Page page) {// ��ȡ��Դid�µ�������������
		List<Comment> comment = new ArrayList<Comment>();
		try {
			Session session = getSessionFactory().getCurrentSession();
			Query query = null;
			if (type == 1) {
				query = session
						.createQuery("from Comment as c where c.resv2='0' and c.comment_type="
								+ type
								+ " and c.resv1="
								+ res
								+ " and c.father_id=0 order by c.comment_date asc");
			} else {
				query = session
						.createQuery("from Comment as c where c.resv2='0' and c.comment_type="
								+ type
								+ " and c.resv1="
								+ res
								+ " and c.father_id=0  order by c.comment_date desc");
			}
			query.setMaxResults(page.getEveryPage());
			query.setFirstResult(page.getBeginIndex());
			comment = query.list();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return comment;
	}

	public int FindCommentByRESCount(int res, int type) {// ��ȡ��Դid�µ�����������������
		List<Comment> comment = new ArrayList<Comment>();
		try {
			Session session = getSessionFactory().getCurrentSession();
			Query query = null;
			if (type == 1) {
				query = session
						.createQuery("from Comment as c where c.resv2='0' and c.comment_type="
								+ type
								+ " and c.resv1="
								+ res
								+ " and c.father_id=0 order by c.comment_date asc");
			} else {
				query = session
						.createQuery("from Comment as c where c.resv2='0' and c.comment_type="
								+ type
								+ " and c.resv1="
								+ res
								+ " and c.father_id=0  order by c.comment_date desc");
			}
			comment = query.list();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return comment.size();
	}

	public List<Comment> queryByPageAndRES(Page page, int res) {
		List<Comment> comment = new ArrayList<Comment>();
		Session session = getSessionFactory().getCurrentSession();
		Query query = session.createQuery("from Comment as c where c.resv1="
				+ res);
		// ����ÿҳ��ʾ���ٸ������ö������
		query.setMaxResults(page.getEveryPage());
		// �������
		query.setFirstResult(page.getBeginIndex());
		comment = query.list();

		return comment;
	}
}
