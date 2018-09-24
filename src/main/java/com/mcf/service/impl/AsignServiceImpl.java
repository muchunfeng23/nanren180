package com.mcf.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;

import com.mcf.bean.AsignDateAndFromWhere;
import com.mcf.dao.AsignDao;
import com.mcf.mybatis.mapper.AsignMapper;
import com.mcf.mybatis.model.AsignBean;
import com.mcf.service.AssignService;
import com.mcf.util.dateTime.DateUtil;

@Service
public class AsignServiceImpl implements AssignService{
	private Logger logger = LoggerFactory.getLogger(AsignServiceImpl.class);
	
	@Autowired
	private AsignMapper asignMapper;
	
	@Override
	public String assign(String openId, String fromWhere) {
		//来到这也应该先判断是否存在当日的签到，如果存在，后续不进行
		if(fromWhere == null){
			return "parameter error";
		}
		//
		AsignBean asignBean = new AsignBean();
		asignBean.setFromWhere(fromWhere);
		asignBean.setOpenId(openId);
		Date now = new Date(System.currentTimeMillis());
		//格式的大小写不同，结果会不同
		String nowStr = DateUtil.format(now, "yyyy-MM-dd");
		asignBean.setAsignDate(now);
		asignBean.setAsignDateStr(nowStr);
		Map<String,String> searchMap = new HashMap<String,String>();
		searchMap.put("openId", openId);
		searchMap.put("asignDateStr", nowStr);
		//返回的是fromWhere
		String existFromWhere = asignMapper.existTodayAsign(searchMap);
		if(existFromWhere == null){
			asignMapper.addAsign(asignBean);
		}else if(existFromWhere.equals("everyNotOk")){
			return "have asigned";
		}else if(existFromWhere.equals("everyok")){
			if(fromWhere.equals("everyok")){
				return "have asigned";
			}else{
				asignMapper.updateAsign(asignBean);
			}
		}
		return "asign ok";
	}
	
	@Override
	public List<String> getAllAsign(String openId, String fromWhere){
		Map<String,String> searchMap = new HashMap<String,String>();
		searchMap.put("openId", openId);
		searchMap.put("fromWhere", fromWhere);
		List<String> asignResult = asignMapper.getAllAsignDatesPerProject(searchMap);
		return asignResult;
	}

	@Override
	public List<AsignDateAndFromWhere> getAllAsignDateAndFromWhere(String openId) {
		return asignMapper.getAllAsignDateAndFromWhere(openId);
	}
}
