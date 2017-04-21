package com.xawl.study.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="comment")
public class Comment {
	private int id;
	private String comment_user_acct;
	private String content;
	private String comment_date;
	private String resv1;
	private String resv2;
	private String comment_to_user_acct;
	private int comment_type;
	private int father_id;
	public int getRead_state() {
		return read_state;
	}
	public void setRead_state(int read_state) {
		this.read_state = read_state;
	}
	private int read_state;		
	@Id
    @GeneratedValue
	public int getId() {
		return id;
	}
	public String getComment_to_user_acct() {
		return comment_to_user_acct;
	}
	public void setComment_to_user_acct(String comment_to_user_acct) {
		this.comment_to_user_acct = comment_to_user_acct;
	}
	public int getComment_type() {
		return comment_type;
	}
	public void setComment_type(int comment_type) {
		this.comment_type = comment_type;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getComment_user_acct() {
		return comment_user_acct;
	}
	public void setComment_user_acct(String comment_user_acct) {
		this.comment_user_acct = comment_user_acct;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getComment_date() {
		return comment_date;
	}
	public void setComment_date(String comment_date) {
		this.comment_date = comment_date;
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
    public int getFather_id() {
		return father_id;
	}
	public void setFather_id(int father_id) {
		this.father_id = father_id;
	}
}
