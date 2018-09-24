package com.mcf.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.mcf.service.PraiseArticleService;

@RestController
public class PraiseArticleController {
	private Logger logger = LoggerFactory.getLogger(PraiseArticleController.class);
	private Gson gson = new Gson();
	
	@Autowired
	private PraiseArticleService praiseArticleService;
	
	@RequestMapping(value="/addAPraise",produces="text/plain;charset=UTF-8")
	public String addAPraise(@RequestParam String title,HttpServletRequest request){
		String openId = (String)request.getAttribute("openId");
		praiseArticleService.addAZan(openId, title);
		return "ok";
	}
}
