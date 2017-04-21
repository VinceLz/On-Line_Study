package com.xawl.study.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="indexModel")
public class IndexModel {
	private int indexId;			//菜单id
	private String logoImageSrc;	//logo图位置
	private String logoTitle;		//logo主题名
	private String summaryMain;		//摘要（通过视频、在线服务传播创新知识）
	private String summarySub;		//摘要（激发青年创新的力量）
	private String advantage1;			//优势1主标题（国际名校公开课）
	private String advantage1Sub;		//优势1副标（免费视频来自世界各地顶级名校的课程盛宴课随你变）
	private String advantage1ImageSrc;	//优势1图
	private String advantage2;			//优势2主标题（定制课后练习）
	private String advantage2Sub;		//优势2副标（观看视频完成练习 巩固知识 记录重点 专业助力）
	private String advantage2ImageSrc;	//优势2图
	private String merit1;				//优点1主标题（白驹过隙）
	private String merit1Sub;			//优点1副标题（时代需要更方便,更快捷的学习方式）
	private String merit1ImageSrc;		//优点1图
	private String merit2;				//优点2主标题（响应式设计）
	private String merit2Sub;			//优点2副标题（适用于各种屏幕 不限设备 想学就学）
	private String merit2ImageSrc;		//优点2图
	private String merit3;				//优点3主标题
	private String merit3Sub;			//优点3副标题
	private String merit3ImageSrc;		//优点3图
	private String merit4;				//优点4主标题
	private String merit4Sub;			//优点4副标题
	private String merit4ImageSrc;		//优点4图
	private String footerAboutUs;		//页脚关于我们（Spring是一个致力于便捷。。。）
	private String footerWeChat;		//页脚微信
	private int isUse;					//是否启用
	
	@Id
	@GeneratedValue
	public int getIndexId() {
		return indexId;
	}
	public void setIndexId(int indexId) {
		this.indexId = indexId;
	}
	public String getLogoImageSrc() {
		return logoImageSrc;
	}
	public void setLogoImageSrc(String logoImageSrc) {
		this.logoImageSrc = logoImageSrc;
	}
	public String getLogoTitle() {
		return logoTitle;
	}
	public void setLogoTitle(String logoTitle) {
		this.logoTitle = logoTitle;
	}
	public String getSummaryMain() {
		return summaryMain;
	}
	public void setSummaryMain(String summaryMain) {
		this.summaryMain = summaryMain;
	}
	public String getSummarySub() {
		return summarySub;
	}
	public void setSummarySub(String summarySub) {
		this.summarySub = summarySub;
	}
	public String getAdvantage1() {
		return advantage1;
	}
	public void setAdvantage1(String advantage1) {
		this.advantage1 = advantage1;
	}
	public String getAdvantage1Sub() {
		return advantage1Sub;
	}
	public void setAdvantage1Sub(String advantage1Sub) {
		this.advantage1Sub = advantage1Sub;
	}
	public String getAdvantage1ImageSrc() {
		return advantage1ImageSrc;
	}
	public void setAdvantage1ImageSrc(String advantage1ImageSrc) {
		this.advantage1ImageSrc = advantage1ImageSrc;
	}
	public String getAdvantage2() {
		return advantage2;
	}
	public void setAdvantage2(String advantage2) {
		this.advantage2 = advantage2;
	}
	public String getAdvantage2Sub() {
		return advantage2Sub;
	}
	public void setAdvantage2Sub(String advantage2Sub) {
		this.advantage2Sub = advantage2Sub;
	}
	public String getAdvantage2ImageSrc() {
		return advantage2ImageSrc;
	}
	public void setAdvantage2ImageSrc(String advantage2ImageSrc) {
		this.advantage2ImageSrc = advantage2ImageSrc;
	}
	public String getMerit1() {
		return merit1;
	}
	public void setMerit1(String merit1) {
		this.merit1 = merit1;
	}
	public String getMerit1Sub() {
		return merit1Sub;
	}
	public void setMerit1Sub(String merit1Sub) {
		this.merit1Sub = merit1Sub;
	}
	public String getMerit1ImageSrc() {
		return merit1ImageSrc;
	}
	public void setMerit1ImageSrc(String merit1ImageSrc) {
		this.merit1ImageSrc = merit1ImageSrc;
	}
	public String getMerit2() {
		return merit2;
	}
	public void setMerit2(String merit2) {
		this.merit2 = merit2;
	}
	public String getMerit2Sub() {
		return merit2Sub;
	}
	public void setMerit2Sub(String merit2Sub) {
		this.merit2Sub = merit2Sub;
	}
	public String getMerit2ImageSrc() {
		return merit2ImageSrc;
	}
	public void setMerit2ImageSrc(String merit2ImageSrc) {
		this.merit2ImageSrc = merit2ImageSrc;
	}
	public String getMerit3() {
		return merit3;
	}
	public void setMerit3(String merit3) {
		this.merit3 = merit3;
	}
	public String getMerit3Sub() {
		return merit3Sub;
	}
	public void setMerit3Sub(String merit3Sub) {
		this.merit3Sub = merit3Sub;
	}
	public String getMerit3ImageSrc() {
		return merit3ImageSrc;
	}
	public void setMerit3ImageSrc(String merit3ImageSrc) {
		this.merit3ImageSrc = merit3ImageSrc;
	}
	public String getMerit4() {
		return merit4;
	}
	public void setMerit4(String merit4) {
		this.merit4 = merit4;
	}
	public String getMerit4Sub() {
		return merit4Sub;
	}
	public void setMerit4Sub(String merit4Sub) {
		this.merit4Sub = merit4Sub;
	}
	public String getMerit4ImageSrc() {
		return merit4ImageSrc;
	}
	public void setMerit4ImageSrc(String merit4ImageSrc) {
		this.merit4ImageSrc = merit4ImageSrc;
	}
	public String getFooterAboutUs() {
		return footerAboutUs;
	}
	public void setFooterAboutUs(String footerAboutUs) {
		this.footerAboutUs = footerAboutUs;
	}
	public String getFooterWeChat() {
		return footerWeChat;
	}
	public void setFooterWeChat(String footerWeChat) {
		this.footerWeChat = footerWeChat;
	}
	public int getIsUse() {
		return isUse;
	}
	public void setIsUse(int isUse) {
		this.isUse = isUse;
	}
	@Override
	public String toString() {
		return "IndexModel [indexId=" + indexId + ", logoImageSrc="
				+ logoImageSrc + ", logoTitle=" + logoTitle + ", summaryMain="
				+ summaryMain + ", summarySub=" + summarySub + ", advantage1="
				+ advantage1 + ", advantage1Sub=" + advantage1Sub
				+ ", advantage1ImageSrc=" + advantage1ImageSrc
				+ ", advantage2=" + advantage2 + ", advantage2Sub="
				+ advantage2Sub + ", advantage2ImageSrc=" + advantage2ImageSrc
				+ ", merit1=" + merit1 + ", merit1Sub=" + merit1Sub
				+ ", merit1ImageSrc=" + merit1ImageSrc + ", merit2=" + merit2
				+ ", merit2Sub=" + merit2Sub + ", merit2ImageSrc="
				+ merit2ImageSrc + ", merit3=" + merit3 + ", merit3Sub="
				+ merit3Sub + ", merit3ImageSrc=" + merit3ImageSrc
				+ ", merit4=" + merit4 + ", merit4Sub=" + merit4Sub
				+ ", merit4ImageSrc=" + merit4ImageSrc + ", footerAboutUs="
				+ footerAboutUs + ", footerWeChat=" + footerWeChat + ", isUse="
				+ isUse + "]";
	}
		
}
