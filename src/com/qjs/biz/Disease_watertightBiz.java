package com.qjs.biz;

import global.tool.QueryItems;

import java.util.List;
import java.util.Map;

import com.qjs.entity.Disease_watertight;

public interface Disease_watertightBiz {
	
	public Object addDisease_watertight(Disease_watertight disease_watertight);
	
	public List<?> getAllDisease_watertight();
	
	public boolean updateDisease_watertight(Disease_watertight disease_watertight);
	
	public boolean deleteDisease_watertightById(int id);
	
	public Map<?, ?> getAllDetailDisease_watertight(QueryItems qi);
	
	public Disease_watertight getDisease_watertightById(int id);
	
	public Disease_watertight getDisease_watertightByBridgeCode(String bridgeCode);
	
	public int getDisease_watertightCodeByBridgeCode(String bridgeCode);
	
	public List<Map<String, Object>> getAllDisease_watertightByBridgeCode(String bridgeCode);
}
