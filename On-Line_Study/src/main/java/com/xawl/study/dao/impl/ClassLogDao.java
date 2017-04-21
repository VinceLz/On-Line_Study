package com.xawl.study.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.xawl.study.model.ClassLog;
@Repository
public class ClassLogDao extends BaseDaoImpl {

	// 添加课程信息
	public void addClass(ClassLog c) {
		Session session = getSessionFactory().getCurrentSession();
		session.save(c);

	}

	// 查找所有课程
	public List<ClassLog> findAllClass() {
		Session session = getSessionFactory().getCurrentSession();
		Query query = session.createQuery("from ClassLog");
		List<ClassLog> classLogList = query.list();
		return classLogList;
	}

	// 按课程id查课程
	public ClassLog findClassById(int id) {
		Session session = getSessionFactory().getCurrentSession();
		Query query = session.createQuery("from ClassLog as c where c.id = "
				+ id);
		ClassLog classLog = (ClassLog) query.uniqueResult();

		return classLog;
	}

	// 按兴趣id查课程
	public List<ClassLog> findClassByInterestID(int interestId) {
		Session session = getSessionFactory().getCurrentSession();
		Query query = session
				.createQuery("from ClassLog as c where c.belongToInterestID = "
						+ interestId);
		List<ClassLog> classLogList = query.list();
		return classLogList;
	}

	// 按课程名id查课程
	public List<ClassLog> findClassByClassNameId(int classNameId) {
		Session session = getSessionFactory().getCurrentSession();
		Query query = session
				.createQuery("from ClassLog as c where c.classNameID = "
						+ classNameId);
		List<ClassLog> classLogList = query.list();

		return classLogList;
	}

	// 删除课程
	public void deleteClassById(int id) {
		Session session = getSessionFactory().getCurrentSession();
		ClassLogDao classLogDao = new ClassLogDao();
		ClassLog classLog = classLogDao.findClassById(id);
		if (classLog == null) {
			System.out.println("该课程不存在！");
		} else {
			session.delete(classLog);
		}

	}
}
