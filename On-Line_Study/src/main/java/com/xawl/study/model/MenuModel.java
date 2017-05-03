package com.xawl.study.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="MenuModel")
public class MenuModel {
	private int menuId;//�˵�id
	private int parentMenuId;//�����˵�id
	private String menuName; //�˵�����	
	private String menuAddr;//�˵�������
	private int menuOrder;//˳��
	private int isUse;//�Ƿ�����
	
	
	@Id
	@GeneratedValue
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getMenuAddr() {
		return menuAddr;
	}
	public void setMenuAddr(String menuAddr) {
		this.menuAddr = menuAddr;
	}
	public int getIsUse() {
		return isUse;
	}
	public void setIsUse(int isUse) {
		this.isUse = isUse;
	}
	public int getParentMenuId() {
		return parentMenuId;
	}
	public void setParentMenuId(int parentMenuId) {
		this.parentMenuId = parentMenuId;
	}
	
	public int getMenuOrder() {
		return menuOrder;
	}
	public void setMenuOrder(int menuOrder) {
		this.menuOrder = menuOrder;
	}
	@Override
	public String toString() {
		return "MenuModel [menuId=" + menuId + ", parentMenuId=" + parentMenuId
				+ ", menuName=" + menuName + ", menuAddr=" + menuAddr
				+ ", menuOrder=" + menuOrder + ", isUse=" + isUse + "]";
	}


	

}
