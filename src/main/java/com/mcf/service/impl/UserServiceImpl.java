package com.mcf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcf.mybatis.mapper.UserMapper;
import com.mcf.mybatis.model.UserInfo;
import com.mcf.service.UserService;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    public UserInfo getUserInfo(){
        UserInfo user=userMapper.findUserInfo();
        return user;
    }
    
    public void addAUser(UserInfo user){
    	userMapper.addUser(user);
    }
    
    public boolean isExist(String openId){
    	return userMapper.isExist(openId) > 0;
    }

    public void addLoginLog(String openId){
    	userMapper.addLoginLog(openId);
    }

	@Override
	public String getRegisterDateStr(String openId) {
		return userMapper.getRegisterDate(openId);
	}
}
