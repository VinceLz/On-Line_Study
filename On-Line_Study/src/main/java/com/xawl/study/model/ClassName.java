package com.xawl.study.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * °à¼¶±í
 * 
 */
@Entity
@Table(name = "classname")
public class ClassName {

	private int classId;
	private String ClassName;

	public String getClassName() {
		return ClassName;
	}

	@Id
	@GeneratedValue
	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public void setClassName(String className) {
		ClassName = className;
	}

}
