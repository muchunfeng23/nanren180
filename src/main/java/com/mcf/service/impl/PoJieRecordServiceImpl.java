package com.mcf.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcf.mybatis.mapper.PoJieRecordMapper;
import com.mcf.mybatis.mapper.ThinkingMapper;
import com.mcf.mybatis.model.PoJieRecord;
import com.mcf.mybatis.model.Thinking;
import com.mcf.service.PoJieService;

@Service
public class PoJieRecordServiceImpl implements PoJieService{
	private Logger logger = LoggerFactory.getLogger(PoJieRecordServiceImpl.class);
	
	@Autowired
	private PoJieRecordMapper pojieRecordMapper;
	@Autowired
	private ThinkingMapper thinkingMapper;
	
	@Override
	public boolean recordPoJie(String openId) {
		PoJieRecord poJieRecord = new PoJieRecord();
		poJieRecord.setOpenId(openId);
		//写数据库
		pojieRecordMapper.addPoJieRecord(poJieRecord);
		return true;
	}

	@Override
	public boolean addThinking(String thinkingstr, String openId) {
		Thinking thinking = new Thinking();
		thinking.setOpenId(openId);
		thinking.setMyThinking(thinkingstr);
		thinkingMapper.addThinking(thinking);
		return true;
	}

	@Override
	public List<PoJieRecord> getAllPoJieRecords(String openId) {
		List<PoJieRecord> allPoJieRecords = pojieRecordMapper.getAllPoJieRecords(openId);
		return allPoJieRecords;
	}

	@Override
	public List<Thinking> getAllThinkings(String openId) {
		List<Thinking> allThinkings = thinkingMapper.getAllThinkings(openId);
		return allThinkings;
	}

}
