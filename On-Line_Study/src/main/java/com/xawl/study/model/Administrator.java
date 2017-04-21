package com.xawl.study.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="administrator")
public class Administrator {
     private int id;
     private String account;//账号
     private String pwd;//密码
     private int rank;//级别
     private String cell;//电话
     private String picture;
     private String nikename;
     private int logintime;
     @Id
     @GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getCell() {
		return cell;
	}
	public void setCell(String cell) {
		this.cell = cell;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getNikename() {
		return nikename;
	}
	public void setNikename(String nikename) {
		this.nikename = nikename;
	}
	public int getLogintime() {
		return logintime;
	}
	public void setLogintime(int logintime) {
		this.logintime = logintime;
	}
     
}
