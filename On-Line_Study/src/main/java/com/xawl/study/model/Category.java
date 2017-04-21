package com.xawl.study.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Category")
public class Category {
	private int categoryId;			//种类id
	private String categoryName;	//种类名
	private String categoryLink;	//种类链接
	private int beLongToInterestID; //所属兴趣ID
	
	@Id
	@GeneratedValue
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryLink() {
		return categoryLink;
	}
	public void setCategoryLink(String categoryLink) {
		this.categoryLink = categoryLink;
	}
	public int getBeLongToInterestID() {
		return beLongToInterestID;
	}
	public void setBeLongToInterestID(int beLongToInterestID) {
		this.beLongToInterestID = beLongToInterestID;
	}
	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName="
				+ categoryName + ", categoryLink=" + categoryLink
				+ ", beLongToInterestID=" + beLongToInterestID + "]";
	}

	
	
	
}
