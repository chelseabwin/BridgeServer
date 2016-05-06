package com.qjs.biz;

import global.tool.QueryItems;

import java.util.List;
import java.util.Map;

import com.qjs.entity.Disease_support;

public interface Disease_supportBiz {
	
	public Object addDisease_support(Disease_support disease_support);
	
	public List<?> getAllDisease_support();
	
	public boolean updateDisease_support(Disease_support disease_support);
	
	public boolean deleteDisease_supportById(int id);
	
	public Map<?, ?> getAllDetailDisease_support(QueryItems qi);
	
	public Disease_support getDisease_supportById(int id);
	
	public Disease_support getDisease_supportByBridgeCode(String bridgeCode);
}
