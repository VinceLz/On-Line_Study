package com.xawl.study.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "t_paper")
public class Paper {

	private int id;
	private String paperName;
	private Date joinDate;
	private Set<Question> questions = new HashSet<Question>();
	private int category; // ����id
	private int type;//�������� ��2�� 1����doc 2 ����¼��
	private int answerOpen;//�Ǹ�����
	private int lengthTime;
	public int getAnswerOpen() {
		return answerOpen;
	}
	

	public int getLengthTime() {
		return lengthTime;
	}


	public void setLengthTime(int lengthTime) {
		this.lengthTime = lengthTime;
	}


	public void setAnswerOpen(int answerOpen) {
		this.answerOpen = answerOpen;
	}

	@Id
	@GeneratedValue(generator = "_native")
	@GenericGenerator(name = "_native", strategy = "native")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPaperName() {
		return paperName;
	}

	public void setPaperName(String paperName) {
		this.paperName = paperName;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	@OneToMany(mappedBy = "paper", fetch = FetchType.EAGER)
	public Set<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	

}
