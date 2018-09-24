package com.mcf.service;

import java.util.List;

import com.mcf.mybatis.model.PoJieRecord;
import com.mcf.mybatis.model.Thinking;

public interface PoJieService {
	public boolean recordPoJie(String openId);
	
	public boolean addThinking(String thinking,String openId);
	
	public List<PoJieRecord> getAllPoJieRecords(String openId);
	
	public List<Thinking> getAllThinkings(String openId);
}
