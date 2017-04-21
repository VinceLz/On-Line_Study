package com.xawl.study.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Forum")
public class Forum {
private int id;
private String title;
private String content;
private String picture;
private String pub_date;
private String last_update_date;
private int support;
private String pub_account;
private int category_id;
private String resv1;
private String resv2;
private String userURL;
public String getUserURL() {
	return userURL;
}
public void setUserURL(String userURL) {
	this.userURL = userURL;
}
@Id
@GeneratedValue
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public String getPicture() {
	return picture;
}
public void setPicture(String picture) {
	this.picture = picture;
}
public String getPub_date() {
	return pub_date;
}
public void setPub_date(String pub_date) {
	this.pub_date = pub_date;
}
public String getLast_update_date() {
	return last_update_date;
}
public void setLast_update_date(String last_update_date) {
	this.last_update_date = last_update_date;
}
public int getSupport() {
	return support;
}
public void setSupport(int support) {
	this.support = support;
}
public String getPub_account() {
	return pub_account;
}
public void setPub_account(String pub_account) {
	this.pub_account = pub_account;
}
public int getCategory_id() {
	return category_id;
}
public void setCategory_id(int category_id) {
	this.category_id = category_id;
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
