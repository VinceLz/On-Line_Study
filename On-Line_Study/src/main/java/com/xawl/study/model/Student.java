package com.xawl.study.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="student")
public class Student {
	private String id;			//id
	private String account;		//�˻�
	private String pwd;			//����
	private String nickName;	//�ǳ�
	private String profession;	//ְҵ
	private String sex;			//�Ա�	
	private String province;	//ʡ
	private String city;		//��
	private String e_mail;		//�����ʼ�
	private String interest;	//��Ȥ����
	private String degree;		//�ȼ����̶�
	private String resume;		//ժҪ
	private String signature;	//����ǩ��
	private String date;			//ע������
	private String picture;   //�û�ͷ��
	private ClassName classId;
	
	
	
	@OneToOne
	@JoinColumn(name = "classId")
	public ClassName getClassId() {
		return classId;
	}
	public void setClassId(ClassName classId) {
		this.classId = classId;
	}
	@Id
	@GeneratedValue(generator="myGenerator")  
	@GenericGenerator(name="myGenerator", strategy="uuid")  
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getE_mail() {
		return e_mail;
	}
	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}
	public String getInterest() {
		return interest;
	}
	public void setInterest(String interest) {
		this.interest = interest;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}

}
