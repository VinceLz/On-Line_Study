package com.xawl.study.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="customclasstable")
public class CustomClassTable{

	private int id;
	private String studentid;
	private char condition;
	private int classid;
	private Date datetime;
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStuddentid() {
		return studentid;
	}
	public void setStuddentid(String studdentid) {
		this.studentid = studdentid;
	}
	public char getConditon() {
		return condition;
	}
	public void setConditon(char conditon) {
		this.condition = conditon;
	}
	public int getClassid() {
		return classid;
	}
	public void setClassid(int classid) {
		this.classid = classid;
	}

	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
}
