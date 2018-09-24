package com.mcf.service;

import java.util.List;

import com.mcf.bean.AsignDateAndFromWhere;

public interface AssignService {
	public String assign(String openId,String fromWhere);
	public List<String> getAllAsign(String openId, String fromWhere);
	
	public List<AsignDateAndFromWhere> getAllAsignDateAndFromWhere(String openId);
}
