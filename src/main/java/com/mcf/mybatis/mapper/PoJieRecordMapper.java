package com.mcf.mybatis.mapper;

import java.util.List;

import com.mcf.mybatis.model.PoJieRecord;

public interface PoJieRecordMapper {
	public void addPoJieRecord(PoJieRecord poJieRecord);
	
	public List<PoJieRecord> getAllPoJieRecords(String openId);
}
