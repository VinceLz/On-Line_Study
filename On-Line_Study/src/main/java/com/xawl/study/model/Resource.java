package com.xawl.study.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "resource")
public class Resource {
	private int id; // id
	private String resourceName; // 资源名
	private Date uploadeDate; // 上传时间
	private String src; // 资源物理保存路径
	private int category; // 种类id
	private int beLongToInterestID; // 所属兴趣id
	private int beLongToDegreeID; // 所属等级id
	private String resume; // 摘要
	private int classNameID; // 课程id
	private int score; // 所需积分？
	private String showImageSrc; // 封面图
	private int resourceType; // 资源类型（视频0、文档1、图片2。。。）
	private String linkSrc; // 网页链接地址
	private String frontClassName; // 前台class名
	private int likeSum; // 点赞数
	private String download_src;// 下载路径
	private int ok_read; // 是否可在线预览
	private int type;// 0 表示通用资源，其他表示教师id

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getOk_read() {
		return ok_read;
	}

	public void setOk_read(int ok_read) {
		this.ok_read = ok_read;
	}

	public String getDownload_src() {
		return download_src;
	}

	public void setDownload_src(String download_src) {
		this.download_src = download_src;
	}

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getShowImageSrc() {
		return showImageSrc;
	}

	public void setShowImageSrc(String showImageSrc) {
		this.showImageSrc = showImageSrc;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String rescourceName) {
		this.resourceName = rescourceName;
	}

	public Date getUploadeDate() {
		return uploadeDate;
	}

	public void setUploadeDate(Date uploadeDate) {
		this.uploadeDate = uploadeDate;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public int getBeLongToInterestID() {
		return beLongToInterestID;
	}

	public void setBeLongToInterestID(int beLongToInterestID) {
		this.beLongToInterestID = beLongToInterestID;
	}

	public int getBeLongToDegreeID() {
		return beLongToDegreeID;
	}

	public void setBeLongToDegreeID(int beLongToDegreeID) {
		this.beLongToDegreeID = beLongToDegreeID;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public int getClassNameID() {
		return classNameID;
	}

	public void setClassNameID(int classNameID) {
		this.classNameID = classNameID;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getResourceType() {
		return resourceType;
	}

	public void setResourceType(int resourceType) {
		this.resourceType = resourceType;
	}

	public String getLinkSrc() {
		return linkSrc;
	}

	public void setLinkSrc(String linkSrc) {
		this.linkSrc = linkSrc;
	}

	public String getFrontClassName() {
		return frontClassName;
	}

	public void setFrontClassName(String frontClassName) {
		this.frontClassName = frontClassName;
	}

	public int getLikeSum() {
		return likeSum;
	}

	public void setLikeSum(int likeSum) {
		this.likeSum = likeSum;
	}

	@Override
	public String toString() {
		return "Resource [id=" + id + ", resourceName=" + resourceName
				+ ", uploadeDate=" + uploadeDate + ", src=" + src
				+ ", category=" + category + ", beLongToInterestID="
				+ beLongToInterestID + ", beLongToDegreeID=" + beLongToDegreeID
				+ ", resume=" + resume + ", classNameID=" + classNameID
				+ ", score=" + score + ", showImageSrc=" + showImageSrc
				+ ", resourceType=" + resourceType + ", linkSrc=" + linkSrc
				+ ", frontClassName=" + frontClassName + ", likeSum=" + likeSum
				+ "]";
	}

}
