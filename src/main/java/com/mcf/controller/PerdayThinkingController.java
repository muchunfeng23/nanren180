package com.mcf.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.mcf.mybatis.model.PerdayThinking;
import com.mcf.service.PerdayThinkingService;


@RestController
public class PerdayThinkingController {
	private Logger logger = LoggerFactory.getLogger(PerdayThinkingController.class);
	private Gson gson = new Gson();
	@Autowired
	private PerdayThinkingService perdayThinkingService;
	
//	http://localhost:8080/addPerdayThinking/modify?whichDay=2017-03-03&content=helloworld123&forDate=2017-03-03
	@RequestMapping(value="/addPerdayThinking/{action}",produces="text/plain;charset=UTF-8")
	public String addPerdayThinking(@PathVariable String action,
			@RequestParam String whichDay,
			@RequestParam String content,
			@RequestParam String forDate,
			HttpServletRequest request){
		if(action == null){
			logger.error("传入的action为null");
			return "notOk";
		}
		String openId = (String)request.getAttribute("openId");
//		String openId = "oj0cK0YGZ5v_24dhlrAiyjcvXa_U";
		PerdayThinking perdayThinking = new PerdayThinking();
		perdayThinking.setOpenId(openId);
		perdayThinking.setWhichDay(whichDay);
		perdayThinking.setContent(content);
		perdayThinking.setForDate(forDate);
		int addResult = 0;
		if(action.equals("add")){
			addResult = perdayThinkingService.addPerdayThinking(perdayThinking);
		}else{
			addResult = perdayThinkingService.updatePerdayThinking(perdayThinking);
		}
		if(addResult == 1){
			logger.info("add thinking content ok");
			return "ok";
		}else{
			logger.info("add thinking content not ok " +  new Date(System.currentTimeMillis()));
			return "notOk";
		}
	}

	
	@RequestMapping(value="/getPerdayThinking",produces="text/plain;charset=UTF-8")
	public String getPerdayThinkingContentOfOneDay(@RequestParam String whichDay,HttpServletRequest request){
		String openId = (String)request.getAttribute("openId");
//		String openId = "hello test";
		String content = perdayThinkingService.getOneDayThinking(openId, whichDay);
		logger.info("获得perday信息： " + content);
		return content;
	}
}
