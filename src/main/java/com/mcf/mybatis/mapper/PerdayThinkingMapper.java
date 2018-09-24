package com.mcf.mybatis.mapper;

import java.util.List; 
import java.util.Map;

import com.mcf.mybatis.model.PerdayThinking;

public interface PerdayThinkingMapper {
   public int addPerdayThinking(PerdayThinking perdayThinking);
   public int updatePerdayThinking(PerdayThinking perdayThinking);
   //获取某一天的thinking内容
   public String getOneDayThinking(Map<String,String> queryMap);
   //或许所有写过thnking的日期的集合
   public List<String> getAllThinkingDates(String openId);
}
