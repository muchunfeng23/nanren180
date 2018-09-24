package com.mcf.mybatis.model;

import java.util.Date;

public class PerdayThinking {
	private long id;
	private String openId;
	private String whichDay;
	private String content;
	private Date addDate;
	private String forDate;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getWhichDay() {
		return whichDay;
	}
	public void setWhichDay(String whichDay) {
		this.whichDay = whichDay;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getAddDate() {
		return addDate;
	}
	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
	public String getForDate() {
		return forDate;
	}
	public void setForDate(String forDate) {
		this.forDate = forDate;
	}
}
