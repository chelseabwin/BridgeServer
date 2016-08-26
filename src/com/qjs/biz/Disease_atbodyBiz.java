package com.qjs.biz;

import global.tool.QueryItems;

import java.util.List;
import java.util.Map;

import com.qjs.entity.Disease_atbody;

public interface Disease_atbodyBiz {
	
	public Object addDisease_atbody(Disease_atbody disease_atbody);
	
	public List<?> getAllDisease_atbody();
	
	public boolean updateDisease_atbody(Disease_atbody disease_atbody);
	
	public boolean deleteDisease_atbodyById(int id);
	
	public Map<?, ?> getAllDetailDisease_atbody(QueryItems qi);
	
	public Disease_atbody getDisease_atbodyById(int id);
	
	public Disease_atbody getDisease_atbodyByBridgeCode(String bridgeCode);
	
	public int getDisease_atbodyCodeByBridgeCode(String bridgeCode);
	
	public List<Map<String, Object>> getAllDisease_atbodyByBridgeCode(String bridgeCode);
}
