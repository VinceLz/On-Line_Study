package com.xawl.study.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



@Entity
public class Area {
private int id;//���
private String areaID;//�ؼ�id
private String area;//�ؼ�����
private String fatherID;//��ID��Ҳ��������ʡ��ID
@Id
@GeneratedValue
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getAreaID() {
	return areaID;
}
public void setAreaID(String areaID) {
	this.areaID = areaID;
}
public String getArea() {
	return area;
}
public void setArea(String area) {
	this.area = area;
}
public String getFatherID() {
	return fatherID;
}
public void setFatherID(String fatherID) {
	this.fatherID = fatherID;
}

}
