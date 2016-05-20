package com.qjs.biz;

import global.tool.QueryItems;

import java.util.List;
import java.util.Map;

import com.qjs.entity.Disease_atcapping;

public interface Disease_atcappingBiz {
	
	public Object addDisease_atcapping(Disease_atcapping disease_atcapping);
	
	public List<?> getAllDisease_atcapping();
	
	public boolean updateDisease_atcapping(Disease_atcapping disease_atcapping);
	
	public boolean deleteDisease_atcappingById(int id);
	
	public Map<?, ?> getAllDetailDisease_atcapping(QueryItems qi);
	
	public Disease_atcapping getDisease_atcappingById(int id);
	
	public Disease_atcapping getDisease_atcappingByBridgeCode(String bridgeCode);
	
	public int getDisease_atcappingCodeByBridgeCode(String bridgeCode);
}
