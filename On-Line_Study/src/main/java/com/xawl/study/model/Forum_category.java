package com.xawl.study.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Forum_category")
public class Forum_category {
private int id;
private String name;
private String pub_date;
private String end_date;
private String resv1;
private String resv2;
@Id
@GeneratedValue
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPub_date() {
	return pub_date;
}
public void setPub_date(String pub_date) {
	this.pub_date = pub_date;
}
public String getEnd_date() {
	return end_date;
}
public void setEnd_date(String end_date) {
	this.end_date = end_date;
}
public String getResv1() {
	return resv1;
}
public void setResv1(String resv1) {
	this.resv1 = resv1;
}
public String getResv2() {
	return resv2;
}
public void setResv2(String resv2) {
	this.resv2 = resv2;
}

}
