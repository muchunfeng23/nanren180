package com.mcf.mybatis.mapper;

import com.mcf.mybatis.model.UserInfo;

/**
 * Created by zl on 2015/8/27.
 */
public interface UserMapper {
    public UserInfo findUserInfo();
    public void addUser(UserInfo user);
    public Integer isExist(String openId);
    public void addLoginLog(String openId);
    public String getRegisterDate(String openId);
}
