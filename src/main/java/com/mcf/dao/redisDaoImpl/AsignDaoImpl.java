package com.mcf.dao.redisDaoImpl;

import java.util.Date; 
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import com.mcf.dao.AsignDao;
import com.mcf.util.dateTime.DateUtil;

@Component
public class AsignDaoImpl implements AsignDao{
private Logger logger=LoggerFactory.getLogger(SessionDaoImpl.class);  
	@Autowired
	private ValueOperations<Object,Object> valOps;
	
	@Override
	public boolean assign(String fromWhere,String openId) {
		String newKey = openId+"|"+fromWhere;
		@SuppressWarnings("unchecked")
		Map<String,Integer> asignDates = (Map<String,Integer>)valOps.get(newKey);
		String today = DateUtil.format(new Date(System.currentTimeMillis()));
		if(asignDates == null){
			asignDates = new HashMap<String,Integer>();
			asignDates.put(today, 1);
			valOps.set(newKey, asignDates);
			logger.info("添加redis成功" + newKey + "  today = " + today + " 第一次添加");
			return true;
		}else{
			if(asignDates.get(today) == 1){
				logger.info("添加redis失败" + newKey + "  today = " + today + " 已经添加过");
				return false;
			}else{
				logger.info("添加redis成功" + newKey + "  today = " + today);
				asignDates.put(today, 1);
				valOps.set(newKey, asignDates);
				return true;
			}
		}
	}

}
