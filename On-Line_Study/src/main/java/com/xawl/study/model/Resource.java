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
	private String resourceName; // ��Դ��
	private Date uploadeDate; // �ϴ�ʱ��
	private String src; // ��Դ������·��
	private int category; // ����id
	private int beLongToInterestID; // ������Ȥid
	private int beLongToDegreeID; // �����ȼ�id
	private String resume; // ժҪ
	private int classNameID; // �γ�id
	private int score; // ������֣�
	private String showImageSrc; // ����ͼ
	private int resourceType; // ��Դ���ͣ���Ƶ0���ĵ�1��ͼƬ2��������
	private String linkSrc; // ��ҳ���ӵ�ַ
	private String frontClassName; // ǰ̨class��
	private int likeSum; // ������
	private String download_src;// ����·��
	private int ok_read; // �Ƿ������Ԥ��
	private int type;// 0 ��ʾͨ����Դ��������ʾ��ʦid

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
