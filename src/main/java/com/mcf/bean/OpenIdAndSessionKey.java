package com.mcf.bean;

import java.io.Serializable;
import java.util.Map;

public class OpenIdAndSessionKey implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String openid;
	private String session_key;
	
	public OpenIdAndSessionKey(){
		
	}
	
	public static OpenIdAndSessionKey parseFromMap(Map<String,Object> fromJson){
		if(fromJson == null){
			return null;
		}
		OpenIdAndSessionKey openIdAndSessionKey = new OpenIdAndSessionKey();
		openIdAndSessionKey.setOpenid((String)fromJson.get("openid"));
		openIdAndSessionKey.setSession_key((String)fromJson.get("session_key"));
		return openIdAndSessionKey;
	}
	
	public OpenIdAndSessionKey(String openId,String sessionKey){
		this.openid = openId;
		this.session_key = sessionKey;
	}
	
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getSession_key() {
		return session_key;
	}
	public void setSession_key(String session_key) {
		this.session_key = session_key;
	}
}
