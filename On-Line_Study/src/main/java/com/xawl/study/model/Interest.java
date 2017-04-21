package com.xawl.study.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Interest {
	private int id;// 内部编号
	private String interestName;// 兴趣名称
	private String attribute;// 兴趣属性
	private String isuse;
	private String src;

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInterestName() {
		return interestName;
	}

	public void setInterestName(String interestName) {
		this.interestName = interestName;
	}

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public String getIsuse() {
		return isuse;
	}

	public void setIsuse(String isuse) {
		this.isuse = isuse;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

}
