package com.xawl.study.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.xawl.study.model.Page;
import com.xawl.study.model.Student;
import com.xawl.study.model.Teach_Class;

@Repository
public class StudentDao extends BaseDaoImpl {

	public StudentDao() {
		// TODO Auto-generated constructor stub
	}

	public Student findUserByAccount(String account) {// 按照用户名查找用户信息
		Student stu = new Student();
		/*
		 * Session session = cf.configure().buildSessionFactory()
		 * .getCurrentSession();
		 */
		Session session = getSessionFactory().getCurrentSession();
		Query query = session.createQuery("from Student as s where s.account='"
				+ account + "'");
		stu = (Student) query.uniqueResult();

		return stu;
	}

	public List<Teach_Class> findByClassid(String classid) {// 按照用户名查找用户信息

		Session session = getSessionFactory().getCurrentSession();
		List list = session.createQuery(
				"from Teach_Class t where t.classid=" + classid).list();
		return list;
	}

	public Student findUserByEmail(String email) {// 按照用户邮箱查找单个用户信息
		Student stu = new Student();
		Session session = getSessionFactory().getCurrentSession();
		try {
			Query query = session
					.createQuery("from Student as s where s.e_mail='" + email
							+ "'");
			stu = (Student) query.uniqueResult();
		} catch (Exception e) {

		}
		return stu;
	}

	public boolean addUser(Student stu) {// 添加用户
		boolean isok = false;
		Session session = getSessionFactory().getCurrentSession();
		session.save(stu);
		isok = true;
		return isok;
	}

	public boolean compUser(Student user) {// 判断用户是否存在true表示存在，false表示不存在
		boolean isok = false;
		Session session = getSessionFactory().getCurrentSession();
		Query query = session.createQuery("from Student as s");
		List<Student> list = query.list();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getE_mail().equals((user.getE_mail()))
					|| list.get(i).getAccount().equals((user.getAccount()))) {
				isok = true;
			}

		}
		return isok;
	}

	public boolean deleteUserByAccount(String account) {// 按照用户账号删除用户，返回值表示删除的结果
		boolean isok = false;
		Session session = getSessionFactory().getCurrentSession();
		Query query = session.createQuery("from Student as s where s.account='"
				+ account + "'");
		Student s = (Student) query.uniqueResult();
		try {
			s.setAccount(account);
			session.delete(s);
			isok = true;
		} catch (Exception e) {
			throw new RuntimeException("用户账号不存在删除失败！");
		} finally {
			return isok;
		}
	}

	public boolean deleteUserByEmail(String email) {// 按照用户邮箱删除用户，返回值表示删除的结果
		boolean isok = false;
		Session session = getSessionFactory().getCurrentSession();
		Query query = session.createQuery("from Student as s where s.e_mail='"
				+ email + "'");
		Student s = (Student) query.uniqueResult();
		try {
			s.setE_mail(email);
			session.delete(s);
			isok = true;
		} catch (Exception e) {
			throw new RuntimeException("用户邮箱不存在，删除失败！");
		} finally {
			return isok;
		}
	}

	public boolean updateUserByAccount(String account, Student stu) {// 通过账号更新用户信息
		boolean isok = false;
		Session session = getSessionFactory().getCurrentSession();
		Query query = session.createQuery("from Student as s where s.account='"
				+ account + "'");
		Student s = (Student) query.uniqueResult();
		try {
			String id = s.getId();
			s = stu;
			s.setId(id);
			s.setAccount(account);
			session.clear();
			session.update(s);
			isok = true;
		} catch (Exception e) {
			throw new RuntimeException("用户账号不存在，更新失败！");
		} finally {
			return isok;
		}
	}

	@SuppressWarnings("finally")
	public boolean updateUserByEmail(String email, Student stu) {// 通过邮箱更新用户信息
		boolean isok = false;
		Session session = getSessionFactory().getCurrentSession();
		Query query = session.createQuery("from Student as s where s.e_mail='"
				+ email + "'");
		Student s = (Student) query.uniqueResult();
		try {
			String id = s.getId();
			s = stu;
			s.setId(id);
			s.setAccount(email);
			session.clear();
			session.update(s);
			isok = true;
		} catch (Exception e) {
			throw new RuntimeException("用户邮箱不存在，更新失败！");
		} finally {
			return isok;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Student> findAllUser() {// 获取数据库中的所有用户信息
		List<Student> allstudent = new ArrayList<Student>();
		Session session = getSessionFactory().getCurrentSession();
		Query query = session.createQuery("from Student");
		allstudent = query.list();
		return allstudent;
	}

	public Student loginByAccount(String account, String password) {// 通过用户账号验证用户能否登录
		// boolean isok=false;
		Student student = new Student();
		try {
			Session session = getSessionFactory().getCurrentSession();
			Query query = session
					.createQuery("from Student as student where student.account='"
							+ account + "'");
			student = (Student) query.uniqueResult();
			if (student.getPwd().equals(password)) {
				return student;
				// isok=true;
			}

			// return isok;
		} catch (Exception e) {
			// return isok;
			// throw new RuntimeException("登录失败");
		}
		return null;
	}

	public Student loginByEmail(String email, String password) {// 通过用户邮箱验证用户能否登录
		Student student = new Student();
		Session session = getSessionFactory().getCurrentSession();
		Query query = session
				.createQuery("from Student as student where student.e_mail='"
						+ email + "'");

		try {
			student = (Student) query.uniqueResult();
			if (student.getPwd().equals(password)) {

				return student;
			}
		} catch (Exception e) {
			// isok = false;
		}

		return null;
	}

	public List<Student> queryByPage(Page page) {
		List<Student> stu = new ArrayList<Student>();
		Session session = getSessionFactory().getCurrentSession();
		Query query = session.createQuery("from Student");
		// 设置每页显示多少个，设置多大结果。
		query.setMaxResults(page.getEveryPage());
		// 设置起点
		query.setFirstResult(page.getBeginIndex());
		stu = query.list();

		return stu;
	}

	public int CountStudent() {
		int sum = 0;
		Session session = getSessionFactory().getCurrentSession();
		Query query = session.createQuery("from Student");
		List<Student> stu = new ArrayList<Student>();
		stu = query.list();
		sum = stu.size();

		return sum;
	}
}
