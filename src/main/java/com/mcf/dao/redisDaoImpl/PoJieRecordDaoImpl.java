package com.mcf.dao.redisDaoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import com.mcf.dao.PoJieRecordDao;

@Component
public class PoJieRecordDaoImpl implements PoJieRecordDao{
	@Autowired
	private ValueOperations<Object,Object> valOps;
	@Override
	public boolean recordPoJie(String openId) {
		String newKey = openId+"|"+"pojie";
		
		return false;
	}

}
