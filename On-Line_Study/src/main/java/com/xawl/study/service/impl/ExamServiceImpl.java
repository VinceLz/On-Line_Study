package com.xawl.study.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.xawl.study.dao.impl.ExamDao;
import com.xawl.study.model.Exam;
import com.xawl.study.model.Page;
import com.xawl.study.model.Paper;
import com.xawl.study.model.Question;
import com.xawl.study.service.ExamService;

@Service
public class ExamServiceImpl implements ExamService {

	@Autowired
	private ExamDao examDao;

	@Override
	public List<Paper> findAllPaper(Page page) {
		return examDao.findAllPaper(page);
	}

	@Override
	public int findAllResourceCount() {
		return examDao.findAllResourceCount();
	}

	@Override
	public Paper getByPaper(int pid) {
		return examDao.getByPaper(pid);
	}

	@Override
	public Question getQuestion(int questionId) {
		return examDao.getQuestion(questionId);
	}

	@Override
	public void saveExam(Exam exam) {
		examDao.saveExam(exam);
	}

	@Override
	public Exam getExam(Integer attribute, String attribute2) {
		return examDao.getExam(attribute, attribute2);
	}

	@Override
	public List<Paper> getAllPaper() {
		return examDao.getAllPaper();
	}

	@Override
	public void addQuest(Question question) {
		examDao.addQuest(question);
	}

}
