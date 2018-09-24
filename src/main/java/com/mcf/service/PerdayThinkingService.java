package com.mcf.service;

import java.util.List;

import com.mcf.mybatis.model.PerdayThinking;

public interface PerdayThinkingService {
	public int addPerdayThinking(PerdayThinking perdayThinking);
	public int updatePerdayThinking(PerdayThinking perdayThinking);
	public String getOneDayThinking(String openId, String whichDay);
	public List<String> getAllThinkingDates(String openId);
}
