package com.mcf.mybatis.model;

import java.util.Date;

public class Thinking {
	private String openId;
	private String myThinking;
	private Date addDate;
	private String addDateStr;
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getMyThinking() {
		return myThinking;
	}
	public void setMyThinking(String myThinking) {
		this.myThinking = myThinking;
	}
	public Date getAddDate() {
		return addDate;
	}
	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
	public String getAddDateStr() {
		return addDateStr;
	}
	public void setAddDateStr(String addDateStr) {
		this.addDateStr = addDateStr;
	}
}
