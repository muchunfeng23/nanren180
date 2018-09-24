package com.mcf.mybatis.model;

import java.util.Date;

public class PoJieRecord {
	private String openId;
	private Date pojieDate;
	private String poJieDateStr;
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public Date getPojieDate() {
		return pojieDate;
	}
	public void setPojieDate(Date pojieDate) {
		this.pojieDate = pojieDate;
	}
	public String getPoJieDateStr() {
		return poJieDateStr;
	}
	public void setPoJieDateStr(String poJieDateStr) {
		this.poJieDateStr = poJieDateStr;
	}
}
