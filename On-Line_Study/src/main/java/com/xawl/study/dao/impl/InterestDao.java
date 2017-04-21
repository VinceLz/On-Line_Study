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
	public boolean addInterest(Interest inter) {// 添加兴趣
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

	public List<Interest> findInteresByAttribute(String attribute) {// 按照兴趣属性查询兴趣
		List<Interest> inter = new ArrayList<Interest>();
		Session session = getSessionFactory().getCurrentSession();
		try {
			Query query = session
					.createQuery("from Interest as inn where inn.attribute='"
							+ attribute + "'");
			inter = query.list();

		} catch (Exception e) {
			throw new RuntimeException("查找失败，未知错误！！");
		}
		return inter;
	}

	public List<Interest> findInteresByInterestName(String name) {// 按照兴趣名称查询兴趣
		List<Interest> inter = new ArrayList<Interest>();
		Session session = getSessionFactory().getCurrentSession();
		try {
			Query query = session
					.createQuery("from Interest as inn where inn.interestName='"
							+ name + "'");
			inter = query.list();

		} catch (Exception e) {
			throw new RuntimeException("查找失败，未知错误！！");
		}
		return inter;
	}

	public Interest findInteresById(int id) {// 按照兴趣Id查询兴趣
		Interest inter = new Interest();
		Session session = getSessionFactory().getCurrentSession();
		try {
			Query query = session
					.createQuery("from Interest as inn where inn.id=" + id);
			inter = (Interest) query.uniqueResult();
		} catch (Exception e) {
			throw new RuntimeException("查找失败，未知错误！！");
		}
		return inter;
	}

	// 查找所有兴趣
	public List<Interest> findAllInterest() {
		Session session = getSessionFactory().getCurrentSession();
		Query query = session.createQuery("from Interest");
		List<Interest> interestList = query.list();

		return interestList;
	}

	// 查找所有兴趣,分页显示
	public List<Interest> findAllInterestPage(Page page) {
		Session session = getSessionFactory().getCurrentSession();
		Query query = session.createQuery("from Interest");
		// 设置每页显示多少个，设置多大结果。
		query.setMaxResults(page.getEveryPage());
		// 设置起点
		query.setFirstResult(page.getBeginIndex());
		List<Interest> interestList = query.list();
		return interestList;
	}

	// 查找所有兴趣,分页显示,但是不显示详情为空的兴趣
	public List<Interest> findAllInterestPageAttributeNotNull(Page page) {
		Session session = getSessionFactory().getCurrentSession();
		Query query = session
				.createQuery("from Interest as inter where inter.attribute!='"
						+ "无" + "'");
		// 设置每页显示多少个，设置多大结果。
		query.setMaxResults(page.getEveryPage());
		// 设置起点
		query.setFirstResult(page.getBeginIndex());
		List<Interest> interestList = query.list();

		return interestList;
	}

	// 查找所有兴趣,不分页显示,但是显示详情为空的兴趣
	public List<Interest> findAllInterestPageAttributeNull() {
		Session session = getSessionFactory().getCurrentSession();
		Query query = session
				.createQuery("from Interest as inter where inter.attribute='"
						+ "无" + "'");
		List<Interest> interestList = query.list();

		return interestList;
	}

	public List<Interest> FindIsUseInterest() {// 按照兴趣是否启用查找兴趣
		Session session = getSessionFactory().getCurrentSession();
		Query query = session
				.createQuery("from Interest as inter where inter.isuse='是'");
		List<Interest> interestList = query.list();

		return interestList;
	}

	public int CountInterest() {// 得到兴趣总条数，用于分页显示
		int sum = 0;
		Session session = getSessionFactory().getCurrentSession();
		Query query = session.createQuery("from Interest");
		List<Interest> stu = new ArrayList<Interest>();
		stu = query.list();
		sum = stu.size();
		return sum;
	}

	public boolean UpdateInterestById(Interest inter) {// 按照兴趣ID修改兴趣信息
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

	public boolean UpdateInterestByInterestName(Interest inter) {// 按照兴趣ID修改兴趣信息
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

	public boolean DeleteInterestById(Interest inter) {// 删除兴趣
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
