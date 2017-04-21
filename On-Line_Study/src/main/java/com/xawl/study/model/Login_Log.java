package com.xawl.study.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="login_log")
public class Login_Log {
public String uuid;
public String login_Account;
public String login_Time;
public String login_Month;
public String login_Ip;
public String rerv1;
public String rerv2;
public String rerv3;
public String rerv4;
public String rerv5;
public String rerv6;
public String rerv7;
public String rerv8;
@Id
@GeneratedValue(generator="uuid")
@GenericGenerator(name="uuid",strategy="uuid")
public String getUuid() {
	return uuid;
}

public void setUuid(String uuid) {
	this.uuid = uuid;
}
public String getLogin_Account() {
	return login_Account;
}
public void setLogin_Account(String login_Account) {
	this.login_Account = login_Account;
}
public String getLogin_Time() {
	return login_Time;
}
public void setLogin_Time(String login_Time) {
	this.login_Time = login_Time;
}
public String getLogin_Month() {
	return login_Month;
}
public void setLogin_Month(String login_Month) {
	this.login_Month = login_Month;
}
public String getLogin_Ip() {
	return login_Ip;
}
public void setLogin_Ip(String login_Ip) {
	this.login_Ip = login_Ip;
}
public String getRerv1() {
	return rerv1;
}
public void setRerv1(String rerv1) {
	this.rerv1 = rerv1;
}
public String getRerv2() {
	return rerv2;
}
public void setRerv2(String rerv2) {
	this.rerv2 = rerv2;
}
public String getRerv3() {
	return rerv3;
}
public void setRerv3(String rerv3) {
	this.rerv3 = rerv3;
}
public String getRerv4() {
	return rerv4;
}
public void setRerv4(String rerv4) {
	this.rerv4 = rerv4;
}
public String getRerv5() {
	return rerv5;
}
public void setRerv5(String rerv5) {
	this.rerv5 = rerv5;
}
public String getRerv6() {
	return rerv6;
}
public void setRerv6(String rerv6) {
	this.rerv6 = rerv6;
}
public String getRerv7() {
	return rerv7;
}
public void setRerv7(String rerv7) {
	this.rerv7 = rerv7;
}
public String getRerv8() {
	return rerv8;
}
public void setRerv8(String rerv8) {
	this.rerv8 = rerv8;
}

}
