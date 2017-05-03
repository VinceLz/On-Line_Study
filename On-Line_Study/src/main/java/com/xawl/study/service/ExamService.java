package com.xawl.study.service;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder.In;

import com.xawl.study.model.Exam;
import com.xawl.study.model.Page;
import com.xawl.study.model.Paper;
import com.xawl.study.model.Question;

public interface ExamService {

	List<Paper> findAllPaper(Page page);

	int findAllResourceCount();

	Paper getByPaper(int pid);

	Question getQuestion(int questionId);

	void saveExam(Exam exam);

	Exam getExam(Integer attribute, String attribute2);

	List<Paper> getAllPaper();

	void addQuest(Question question);

	List<Exam> getAllQuest();

	List<Exam> getAllQuest(int id);

	void deleteByPaper(String attribute);

	void updatePaper(Paper p);
}
