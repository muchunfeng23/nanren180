package com.mcf.mybatis.mapper;

import java.util.List;

import com.mcf.mybatis.model.Thinking;

public interface ThinkingMapper {
	public void addThinking(Thinking thinking);
	public List<Thinking> getAllThinkings(String openId);
}
