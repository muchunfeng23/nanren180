package com.mcf.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.mcf.mybatis.model.PoJieRecord;
import com.mcf.mybatis.model.Thinking;
import com.mcf.service.PoJieService;

@RestController
public class PoJieController {
	private Logger logger=LoggerFactory.getLogger(PoJieController.class);
	Gson gson = new Gson();
	
	@Autowired
	private PoJieService poJieService;
	
	@RequestMapping("/pojie")
	public String pojieRecord(HttpServletRequest request){
		String openId = (String)request.getAttribute("openId");
		poJieService.recordPoJie(openId);
		return "ok";
	}
	
	@RequestMapping(value="/addThinking")
	public String addThinking(HttpServletRequest request){
		String openId = (String)request.getAttribute("openId");
		String thinking = (String)request.getParameter("thinking");
		poJieService.addThinking(thinking, openId);
		return "ok";
	}
	
	@RequestMapping(value="/getPoJies",produces="text/json;charset=UTF-8")
	public String getMyAllPoJieRecords(HttpServletRequest request){
		String openId = (String)request.getAttribute("openId");
		List<PoJieRecord> allPoJieRecords = poJieService.getAllPoJieRecords(openId);
		String result = gson.toJson(allPoJieRecords);
		return result;
	}
	
	@RequestMapping(value="/getAllThinkings",produces="text/json;charset=UTF-8")
	public String getAllThinkings(HttpServletRequest request){
		String openId = (String)request.getAttribute("openId");
		List<Thinking> allThinkings = poJieService.getAllThinkings(openId);
		String result = gson.toJson(allThinkings);
		return result;
	}
}
