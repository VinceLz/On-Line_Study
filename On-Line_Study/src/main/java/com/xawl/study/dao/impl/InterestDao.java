package com.xawl.study.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.xawl.study.model.ClassName;
import com.xawl.study.model.Interest;
import com.xawl.study.model.Page;

@Repository
public class InterestDao extends BaseDaoImpl {
	public boolean addInterest(Interest inter) {// �����Ȥ
		boolean isok = false;
		Session session = getSessionFactory().getCurrentSession();

		try {
			session.save(inter);
			isok = true;
		} catch (Exception e) {
			isok = false;
		}
		return isok;
	}

	public List<Interest> findInteresByAttribute(String attribute) {// ������Ȥ���Բ�ѯ��Ȥ
		List<Interest> inter = new ArrayList<Interest>();
		Session session = getSessionFactory().getCurrentSession();
		try {
			Query query = session
					.createQuery("from Interest as inn where inn.attribute='"
							+ attribute + "'");
			inter = query.list();

		} catch (Exception e) {
			throw new RuntimeException("����ʧ�ܣ�δ֪���󣡣�");
		}
		return inter;
	}

	public List<Interest> findInteresByInterestName(String name) {// ������Ȥ���Ʋ�ѯ��Ȥ
		List<Interest> inter = new ArrayList<Interest>();
		Session session = getSessionFactory().getCurrentSession();
		try {
			Query query = session
					.createQuery("from Interest as inn where inn.interestName='"
							+ name + "'");
			inter = query.list();

		} catch (Exception e) {
			throw new RuntimeException("����ʧ�ܣ�δ֪���󣡣�");
		}
		return inter;
	}

	public Interest findInteresById(int id) {// ������ȤId��ѯ��Ȥ
		Interest inter = new Interest();
		Session session = getSessionFactory().getCurrentSession();
		try {
			Query query = session
					.createQuery("from Interest as inn where inn.id=" + id);
			inter = (Interest) query.uniqueResult();
		} catch (Exception e) {
			throw new RuntimeException("����ʧ�ܣ�δ֪���󣡣�");
		}
		return inter;
	}

	// ����������Ȥ
	public List<Interest> findAllInterest() {
		Session session = getSessionFactory().getCurrentSession();
		Query query = session.createQuery("from Interest");
		List<Interest> interestList = query.list();

		return interestList;
	}

	// ����������Ȥ,��ҳ��ʾ
	public List<Interest> findAllInterestPage(Page page) {
		Session session = getSessionFactory().getCurrentSession();
		Query query = session.createQuery("from Interest");
		// ����ÿҳ��ʾ���ٸ������ö������
		query.setMaxResults(page.getEveryPage());
		// �������
		query.setFirstResult(page.getBeginIndex());
		List<Interest> interestList = query.list();
		return interestList;
	}

	// ����������Ȥ,��ҳ��ʾ,���ǲ���ʾ����Ϊ�յ���Ȥ
	public List<Interest> findAllInterestPageAttributeNotNull(Page page) {
		Session session = getSessionFactory().getCurrentSession();
		Query query = session
				.createQuery("from Interest as inter where inter.attribute!='"
						+ "��" + "'");
		// ����ÿҳ��ʾ���ٸ������ö������
		query.setMaxResults(page.getEveryPage());
		// �������
		query.setFirstResult(page.getBeginIndex());
		List<Interest> interestList = query.list();

		return interestList;
	}

	// ����������Ȥ,����ҳ��ʾ,������ʾ����Ϊ�յ���Ȥ
	public List<Interest> findAllInterestPageAttributeNull() {
		Session session = getSessionFactory().getCurrentSession();
		Query query = session
				.createQuery("from Interest as inter where inter.attribute='"
						+ "��" + "'");
		List<Interest> interestList = query.list();

		return interestList;
	}

	public List<Interest> FindIsUseInterest() {// ������Ȥ�Ƿ����ò�����Ȥ
		Session session = getSessionFactory().getCurrentSession();
		Query query = session
				.createQuery("from Interest as inter where inter.isuse='��'");
		List<Interest> interestList = query.list();

		return interestList;
	}

	public int CountInterest() {// �õ���Ȥ�����������ڷ�ҳ��ʾ
		int sum = 0;
		Session session = getSessionFactory().getCurrentSession();
		Query query = session.createQuery("from Interest");
		List<Interest> stu = new ArrayList<Interest>();
		stu = query.list();
		sum = stu.size();
		return sum;
	}

	public boolean UpdateInterestById(Interest inter) {// ������ȤID�޸���Ȥ��Ϣ
		boolean isok = false;
		Session session = getSessionFactory().getCurrentSession();
		try {
			session.saveOrUpdate(inter);

			isok = true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return isok;
	}

	public boolean UpdateInterestByInterestName(Interest inter) {// ������ȤID�޸���Ȥ��Ϣ
		boolean isok = false;
		Session session = getSessionFactory().getCurrentSession();
		Interest interest = new Interest();
		try {
			Query query = session
					.createQuery("from Interest as inter where inter.interestName='"
							+ inter.getInterestName() + "'");
			interest = (Interest) query.uniqueResult();
			inter.setId(interest.getId());
			session.saveOrUpdate(inter);

			isok = true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isok;
	}

	public boolean DeleteInterestById(Interest inter) {// ɾ����Ȥ
		boolean isok = false;
		Session session = getSessionFactory().getCurrentSession();
		try {
			session.delete(inter);

			isok = true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isok;
	}

	public List<ClassName> getAllClass() {
		Session session = getSessionFactory().getCurrentSession();
		List list = session.createQuery("from ClassName").list();
		return list;
	}
}
