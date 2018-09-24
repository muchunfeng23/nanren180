package com.mcf.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcf.mybatis.mapper.PraiseArticleMapper;
import com.mcf.service.PraiseArticleService;

@Service
public class PraiseArticleServiceImpl implements PraiseArticleService{
	private Logger logger = LoggerFactory.getLogger(PraiseArticleServiceImpl.class);
	@Autowired
	private PraiseArticleMapper praiseArticleMapper;
	
	@Override
	public int addAZan(String openId, String title) {
		// TODO Auto-generated method stub
		Map<String,String> senderMap = new HashMap<String,String>();
		senderMap.put("fromWho", openId);
		senderMap.put("title", title);
		logger.info("fromWho = " + openId + " title = " + title);
		return praiseArticleMapper.addAZan(senderMap);
	}
	
	
}
