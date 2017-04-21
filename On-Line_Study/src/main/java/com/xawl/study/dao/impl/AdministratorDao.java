package com.xawl.study.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.xawl.study.model.Administrator;
import com.xawl.study.model.Page;
@Repository
public class AdministratorDao extends BaseDaoImpl<Administrator> {

	public boolean AddAdministrator(Administrator admin) {
		Session session = getSessionFactory().getCurrentSession();
		boolean isok = false;
		try {
			session.save(admin);
			isok = true;

		} catch (Exception e) {
			isok = false;
		}
		return isok;
	}

	public List<Administrator> queryByPage(Page page) {
		List<Administrator> admin = new ArrayList<Administrator>();
		Session session = getSessionFactory().getCurrentSession();
		Query query = session.createQuery("from Administrator");
		// 设置每页显示多少个，设置多大结果。
		query.setMaxResults(page.getEveryPage());
		// 设置起点
		query.setFirstResult(page.getBeginIndex());
		admin = query.list();
		return admin;
	}

	public int CountAdmin() {// 得到管理员的数量
		int sum = 0;
		Session session = getSessionFactory().getCurrentSession();
		Query query = session.createQuery("from Administrator");
		List<Administrator> admin = new ArrayList<Administrator>();
		admin = query.list();
		sum = admin.size();
		return sum;
	}

	public boolean CheckAdmin(Administrator admin) {// 检查管理员账号是否存在
		boolean isok = false;
		Session session = getSessionFactory().getCurrentSession();
		Query query = session
				.createQuery("from Administrator as admin where admin.account="
						+ admin.getAccount() + "");
		try {
			Administrator ad = (Administrator) query.uniqueResult();
			if (ad != null) {
				isok = true;
			}

		} catch (HibernateException e) {
		}
		return isok;
	}

	public boolean AdminLogin(Administrator admin) {// 检查管理员登陆
		boolean isok = false;
		Session session = getSessionFactory().getCurrentSession();
		Administrator ad = new Administrator();
		try {
			Query query = session
					.createQuery("from Administrator as admin where admin.account='"
							+ admin.getAccount() + "'");
			ad = (Administrator) query.uniqueResult();
			if (admin.getPwd().equals(ad.getPwd())) {
				isok = true;
			}

		} catch (Exception e) {
		}
		return isok;
	}

	public Administrator FindAdminByAccount(Administrator ad) {// 按照账号查找管理员的信息
		Administrator admin = new Administrator();
		Session session = null;
		try {
			session = getSessionFactory().getCurrentSession();
		} catch (HibernateException e1) {
			e1.printStackTrace();
		}
		try {
			Query query = session
					.createQuery("from Administrator as admin where admin.account='"
							+ ad.getAccount() + "'");
			admin = (Administrator) query.uniqueResult();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return admin;
	}

	public List<Administrator> FindAllAdmin() {// 获取所有管理员的信息
		List<Administrator> alladmin = new ArrayList<Administrator>();
		Session session = getSessionFactory().getCurrentSession();
		Query query = session.createQuery("from Administrator");
		alladmin = query.list();

		return alladmin;
	}

	public boolean DeleteAdministratorByAccount(Administrator admin) {// 按照账号删除管理员账户
		boolean isok = false;
		Session session = getSessionFactory().getCurrentSession();
		Administrator ad = new Administrator();
		try {
			Query query = session
					.createQuery("from Administrator as admin where admin.account="
							+ admin.getAccount() + "");
			ad = (Administrator) query.uniqueResult();
			session.delete(ad);

			isok = true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isok;
	}

	public boolean UpdateLoginTiemByAccount(Administrator admin) {
		boolean isok = false;
		Session session = getSessionFactory().getCurrentSession();
		Query query = session
				.createQuery("from Administrator as ad where ad.account='"
						+ admin.getAccount() + "'");
		Administrator s = (Administrator) query.uniqueResult();
		Query query1 = session
				.createQuery("update Administrator as ad set ad.logintime=ad.logintime+1 where account='"
						+ admin.getAccount() + "'");
		int i = query1.executeUpdate();
		if (i > 0) {
			isok = true;
		}

		return isok;
	}

	public boolean UpdatePictureByAccount(Administrator admin) {
		boolean isok = false;
		Session session = getSessionFactory().getCurrentSession();
		Query query = session
				.createQuery("from Administrator as ad where ad.account='"
						+ admin.getAccount() + "'");
		Administrator s = (Administrator) query.uniqueResult();
		s.setPicture(admin.getPicture());

		try {
			session.update(s);
			isok = true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return isok;
	}

	public boolean UpdateAdminByAcount(Administrator admin) {// 按照账号更新管理员信息
		boolean isok = false;
		Session session = getSessionFactory().getCurrentSession();
		Query query = session
				.createQuery("from Administrator as ad where ad.account='"
						+ admin.getAccount() + "'");
		Administrator s = (Administrator) query.uniqueResult();
		int id = s.getId();
		admin.setId(id);
		try {
			session.saveOrUpdate(admin);
			isok = true;

		} catch (Exception e) {
			// TODO: handle exception
		}

		return isok;
	}

	public boolean UpdateAdminByAcountForNikeNameAndCell(Administrator admin) {// 按照账号更新管理员信息,自己修改信息时候调用
		boolean isok = false;
		Session session = getSessionFactory().getCurrentSession();
		Query query = session
				.createQuery("from Administrator as ad where ad.account='"
						+ admin.getAccount() + "'");
		Administrator s = (Administrator) query.uniqueResult();
		s.setCell(admin.getCell());
		s.setNikename(admin.getNikename());
		try {
			session.saveOrUpdate(s);
			isok = true;
		} catch (Exception e) {
		}
		return isok;
	}

	public boolean UpdateAdminPwdByAccount(Administrator admin) {// 按照账号更新管理员密码
		boolean isok = false;
		Session session = getSessionFactory().getCurrentSession();
		Query query = session
				.createQuery("from Administrator as ad where ad.account='"
						+ admin.getAccount() + "'");
		Administrator s = (Administrator) query.uniqueResult();
		/*
		 * int id = s.getId(); admin.setId(id);
		 */
		s.setPwd(admin.getPwd());
		try {
			session.saveOrUpdate(s);
			isok = true;
		} catch (Exception e) {
			// TODO: handle exception
		}

		return isok;
	}

	public boolean UpdateAdminById(Administrator admin) {// 按照账号更新管理员信息
		boolean isok = false;
		Session session = getSessionFactory().getCurrentSession();
		try {
			session.saveOrUpdate(admin);
			isok = true;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return isok;
	}

}
