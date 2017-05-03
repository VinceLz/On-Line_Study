package com.xawl.study.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.xawl.study.model.ClassLog;
@Repository
public class ClassLogDao extends BaseDaoImpl {

	// ��ӿγ���Ϣ
	public void addClass(ClassLog c) {
		Session session = getSessionFactory().getCurrentSession();
		session.save(c);

	}

	// �������пγ�
	public List<ClassLog> findAllClass() {
		Session session = getSessionFactory().getCurrentSession();
		Query query = session.createQuery("from ClassLog");
		List<ClassLog> classLogList = query.list();
		return classLogList;
	}

	// ���γ�id��γ�
	public ClassLog findClassById(int id) {
		Session session = getSessionFactory().getCurrentSession();
		Query query = session.createQuery("from ClassLog as c where c.id = "
				+ id);
		ClassLog classLog = (ClassLog) query.uniqueResult();

		return classLog;
	}

	// ����Ȥid��γ�
	public List<ClassLog> findClassByInterestID(int interestId) {
		Session session = getSessionFactory().getCurrentSession();
		Query query = session
				.createQuery("from ClassLog as c where c.belongToInterestID = "
						+ interestId);
		List<ClassLog> classLogList = query.list();
		return classLogList;
	}

	// ���γ���id��γ�
	public List<ClassLog> findClassByClassNameId(int classNameId) {
		Session session = getSessionFactory().getCurrentSession();
		Query query = session
				.createQuery("from ClassLog as c where c.classNameID = "
						+ classNameId);
		List<ClassLog> classLogList = query.list();

		return classLogList;
	}

	// ɾ���γ�
	public void deleteClassById(int id) {
		Session session = getSessionFactory().getCurrentSession();
		ClassLogDao classLogDao = new ClassLogDao();
		ClassLog classLog = classLogDao.findClassById(id);
		if (classLog == null) {
			System.out.println("�ÿγ̲����ڣ�");
		} else {
			session.delete(classLog);
		}

	}
}
