package com.mcf.mybatis.mapper;

import java.util.List;
import java.util.Map;

import com.mcf.bean.AsignDateAndFromWhere;
import com.mcf.mybatis.model.AsignBean;

public interface AsignMapper {
    public void addAsign(AsignBean asignBean);
    public List<String> getAllAsignDatesPerProject(Map<String,String> searchMap);
    public List<AsignDateAndFromWhere> getAllAsignDateAndFromWhere(String openId);
    
    public String existTodayAsign(Map<String,String> searchMap);
    public void updateAsign(AsignBean asignBean);
}
