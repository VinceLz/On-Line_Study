package com.xawl.study.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * @author think
 *
 */
@Entity
@Table(name="classlog")
public class ClassLog {
	private int id;					//id
	private int belongToInterestID;	//所属兴趣id
	private int belongToDegreeID;	//所属级别id
	private int resourceID;			//资源id
	private int classNameID;		//课程名字id
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBelongToInterestID() {
		return belongToInterestID;
	}
	public void setBelongToInterestID(int belongToInterestID) {
		this.belongToInterestID = belongToInterestID;
	}
	public int getBelongToDegreeID() {
		return belongToDegreeID;
	}
	public void setBelongToDegreeID(int belongToDegreeID) {
		this.belongToDegreeID = belongToDegreeID;
	}
	public int getResourceID() {
		return resourceID;
	}
	public void setResourceID(int resourceID) {
		this.resourceID = resourceID;
	}
	public int getClassNameID() {
		return classNameID;
	}
	public void setClassNameID(int classNameID) {
		this.classNameID = classNameID;
	}
	@Override
	public String toString() {
		return "ClassLog [id=" + id + ", belongToInterestID="
				+ belongToInterestID + ", belongToDegreeID=" + belongToDegreeID
				+ ", resourceID=" + resourceID + ", classNameID=" + classNameID
				+ "]";
	}
	
	
}
