package com.xawl.study.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class City {
private int id;
private String cityID;
private String city;
private String fatherID;
@Id
@GeneratedValue
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getCityID() {
	return cityID;
}
public void setCityID(String cityID) {
	this.cityID = cityID;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getFatherID() {
	return fatherID;
}
public void setFatherID(String fatherID) {
	this.fatherID = fatherID;
}

}
