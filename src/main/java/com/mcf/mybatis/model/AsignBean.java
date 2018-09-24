package com.mcf.mybatis.model;

import java.util.Date;

public class AsignBean {
	private String openId;
	private String fromWhere;
	private Date asignDate;
	private String asignDateStr;
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getFromWhere() {
		return fromWhere;
	}
	public void setFromWhere(String fromWhere) {
		this.fromWhere = fromWhere;
	}
	public Date getAsignDate() {
		return asignDate;
	}
	public void setAsignDate(Date asignDate) {
		this.asignDate = asignDate;
	}
	public String getAsignDateStr() {
		return asignDateStr;
	}
	public void setAsignDateStr(String asignDateStr) {
		this.asignDateStr = asignDateStr;
	}
}
