package com.mcf.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.mcf.bean.AsignDateAndFromWhere;
import com.mcf.bean.WriteDateAndFromWhere;
import com.mcf.service.AssignService;
import com.mcf.service.PerdayThinkingService;

@RestController
public class AsignController {
	private Logger logger=LoggerFactory.getLogger(AsignController.class);
	private Gson gson = new Gson();
	
	@Autowired
	private AssignService assignService;
	@Autowired
	private PerdayThinkingService perdayThinkingService;
	
	@RequestMapping(value="/asign/{fromWhere}",produces="text/plain;charset=UTF-8")
	public @ResponseBody String asign(@PathVariable String fromWhere,HttpServletRequest request){
		String openId = (String)request.getAttribute("openId");
		String result = assignService.assign(openId, fromWhere);
		return result;
	}
	
	//这个只获取日期
	@RequestMapping(value="/allAsigns/{fromWhere}",produces="text/json;charset=UTF-8")
	public String getAllAsign(@PathVariable String fromWhere,HttpServletRequest request){
		String openId = (String)request.getAttribute("openId");
//		String openId = "helloWorld";
		List<String> allAsigns = assignService.getAllAsign(openId, fromWhere);
		String result = gson.toJson(allAsigns);
		logger.info("result = " + result);
		return result;
	}
	
	/*
	 * V1.0版本使用
	 */
	@RequestMapping(value="/allMyAsigns",produces="text/json;charset=UTF-8")
	public String getAllAsignObj(HttpServletRequest request){
		String openId = (String)request.getAttribute("openId");
		List<AsignDateAndFromWhere> allAsigns = assignService.getAllAsignDateAndFromWhere(openId);
		String result = gson.toJson(allAsigns);
		logger.info(result);
		return result;
	}
	
	/*
	 * V2.0版本使用
	 */
	@RequestMapping(value="/allMyAsignsAndWrittens",produces="text/json;charset=UTF-8")
	public String getAllAsignObjV2(HttpServletRequest request){
		String openId = (String)request.getAttribute("openId");
		List<AsignDateAndFromWhere> asignDates = assignService.getAllAsignDateAndFromWhere(openId);
		List<String> thinkingDates = perdayThinkingService.getAllThinkingDates(openId);
		List<WriteDateAndFromWhere> resultList = new ArrayList<WriteDateAndFromWhere>();
		for(AsignDateAndFromWhere asignDate : asignDates){
			boolean hasWritten = false;
			for(String thinkingDate : thinkingDates){
				if(asignDate.getAsignDateStr().equals(thinkingDate)){
					hasWritten = true;
					break;
				}
			}
			WriteDateAndFromWhere forDateAndFromWhere = new WriteDateAndFromWhere();
			forDateAndFromWhere.setForDate(asignDate.getAsignDateStr());
			forDateAndFromWhere.setFromWhere(asignDate.getFromWhere());
			if(!hasWritten){
				forDateAndFromWhere.setWriteDate("");
			}else{
				forDateAndFromWhere.setWriteDate(asignDate.getAsignDateStr());
			}
			resultList.add(forDateAndFromWhere);
		}
		for(String thinkingDate : thinkingDates){
			boolean hasAsigned = false;
			for(AsignDateAndFromWhere asignDate : asignDates){
				if(thinkingDate.equals(asignDate.getAsignDateStr())){
					hasAsigned = true;
				}
			}
			if(!hasAsigned){
				WriteDateAndFromWhere forDateAndFromWhere = new WriteDateAndFromWhere();
				forDateAndFromWhere.setForDate(thinkingDate);
				forDateAndFromWhere.setFromWhere("notAsign");
				forDateAndFromWhere.setWriteDate(thinkingDate);
				resultList.add(forDateAndFromWhere);
			}
		}
		String result = gson.toJson(resultList);
		logger.info(result);
		return result;
	}
}
