package com.xawl.study.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Province {
private int id;
private String provinceID;
private String province;
@Id
@GeneratedValue
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getProvinceID() {
	return provinceID;
}
public void setProvinceID(String provinceID) {
	this.provinceID = provinceID;
}
public String getProvince() {
	return province;
}
public void setProvince(String province) {
	this.province = province;
}

}
