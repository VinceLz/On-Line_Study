package com.xawl.study.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="RES_SUPPORT")
public class Res_Support {
	private String id;
	private int support_res;
	private String support_account;
	private String support_date;
	private String rsrv1;
	private String rsrv2;
	private String rsrv3;
	private String rsrv4;
	private String rsrv5;
	private String rsrv6;
	private String rsrv7;
	private String rsrv8;
	@Id
	@GeneratedValue(generator="uuid")
	@GenericGenerator(name="uuid",strategy="uuid")
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getSupport_res() {
		return support_res;
	}
	public void setSupport_res(int support_res) {
		this.support_res = support_res;
	}
	public String getSupport_account() {
		return support_account;
	}
	public void setSupport_account(String support_account) {
		this.support_account = support_account;
	}
	public String getSupport_date() {
		return support_date;
	}
	public void setSupport_date(String support_date) {
		this.support_date = support_date;
	}
	public String getRsrv1() {
		return rsrv1;
	}
	public void setRsrv1(String rsrv1) {
		this.rsrv1 = rsrv1;
	}
	public String getRsrv2() {
		return rsrv2;
	}
	public void setRsrv2(String rsrv2) {
		this.rsrv2 = rsrv2;
	}
	public String getRsrv3() {
		return rsrv3;
	}
	public void setRsrv3(String rsrv3) {
		this.rsrv3 = rsrv3;
	}
	public String getRsrv4() {
		return rsrv4;
	}
	public void setRsrv4(String rsrv4) {
		this.rsrv4 = rsrv4;
	}
	public String getRsrv5() {
		return rsrv5;
	}
	public void setRsrv5(String rsrv5) {
		this.rsrv5 = rsrv5;
	}
	public String getRsrv6() {
		return rsrv6;
	}
	public void setRsrv6(String rsrv6) {
		this.rsrv6 = rsrv6;
	}
	public String getRsrv7() {
		return rsrv7;
	}
	public void setRsrv7(String rsrv7) {
		this.rsrv7 = rsrv7;
	}
	public String getRsrv8() {
		return rsrv8;
	}
	public void setRsrv8(String rsrv8) {
		this.rsrv8 = rsrv8;
	}
	

}
