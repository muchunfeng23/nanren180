package com.mcf.service.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mcf.mybatis.mapper.PerdayThinkingMapper;
import com.mcf.mybatis.model.PerdayThinking;
import com.mcf.service.PerdayThinkingService;

@Service
public class PerdayThinkingServiceImpl implements PerdayThinkingService {
	private Logger logger = LoggerFactory.getLogger(PerdayThinkingServiceImpl.class);
	@Autowired
	private PerdayThinkingMapper perdayThinkingMapper;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int addPerdayThinking(PerdayThinking perdayThinking) {
		return perdayThinkingMapper.addPerdayThinking(perdayThinking);
	}

	@Override
	public String getOneDayThinking(String openId, String whichDay) {
		Map<String, String> queryMap = new HashMap<String, String>();
		queryMap.put("openId", openId);
		queryMap.put("whichDay", whichDay);
		return perdayThinkingMapper.getOneDayThinking(queryMap);
	}

	@Override
	@Transactional
	public int updatePerdayThinking(PerdayThinking perdayThinking) {
		// Map<String,String> senderMap = new HashMap<String,String>();
		// senderMap.put("content", perdayThinking.getContent());
		// senderMap.put("openId", perdayThinking.getOpenId());
		// senderMap.put("whichDay", perdayThinking.getWhichDay());
		// return perdayThinkingMapper.updatePerdayThinking(perdayThinking);
		logger.info("jdbcTemplate更新操作");
		return jdbcTemplate.update("update perdayThinking set content = ? where openId =? and whichDay = ?",
				new PreparedStatementSetter() {
					@Override
					public void setValues(PreparedStatement ps) throws SQLException {
						ps.setString(1, perdayThinking.getContent());
						ps.setString(2, perdayThinking.getOpenId());
						ps.setString(3, perdayThinking.getWhichDay());
					}
				});
	}

	@Override
	public List<String> getAllThinkingDates(String openId) {
		return perdayThinkingMapper.getAllThinkingDates(openId);
	}

}
