package com.xawl.study.dao.impl;

import java.nio.channels.SeekableByteChannel;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.xawl.study.model.Exam;
import com.xawl.study.model.Page;
import com.xawl.study.model.Paper;
import com.xawl.study.model.Question;

@Repository
public class ExamDao extends BaseDaoImpl<Paper> {

	public List<Paper> findAllPaper(Page page) {
		Session session = getSessionFactory().getCurrentSession();
		Query query = session.createQuery("from Paper");
		query.setMaxResults(page.getEveryPage());
		// …Ë÷√∆µ„
		query.setFirstResult(page.getBeginIndex());
		List<Paper> resourceList = query.list();
		return resourceList;
	}

	public int findAllResourceCount() {
		Session session = getSessionFactory().getCurrentSession();
		int sum = session.createQuery("from Paper").list().size();
		return sum;
	}

	public Paper getByPaper(int pid) {
		Session session = getSessionFactory().getCurrentSession();
		Object object = session.get(Paper.class, pid);
		return (Paper) object;
	}

	public Question getQuestion(int questionId) {
		Session currentSession = getSessionFactory().getCurrentSession();
		return (Question) currentSession.get(Question.class, questionId);

	}

	public void saveExam(Exam exam) {
		Session currentSession = getSessionFactory().getCurrentSession();
		currentSession.save(exam);
	}

	public Exam getExam(Integer attribute, String attribute2) {

		Session currentSession = getSessionFactory().getCurrentSession();
		Query createQuery = currentSession
				.createQuery("from Exam ex where ex.paper.id=" + attribute
						+ " and ex.student.id=" + "'" + attribute2 + "'");
		List list = createQuery.list();
		if (list.size() == 0) {
			return null;
		}
		return (Exam) list.get(0);
	}

	public List<Paper> getAllPaper() {
		Session currentSession = getSessionFactory().getCurrentSession();
		List list = currentSession.createQuery("from Paper").list();
		return list;
	}
	
	public void addQuest(Question question) {
		Session currentSession = getSessionFactory().getCurrentSession();
		currentSession.save(question);
	}

}
