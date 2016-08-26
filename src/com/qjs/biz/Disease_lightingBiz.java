package com.qjs.biz;

import global.tool.QueryItems;

import java.util.List;
import java.util.Map;

import com.qjs.entity.Disease_lighting;

public interface Disease_lightingBiz {
	
	public Object addDisease_lighting(Disease_lighting disease_lighting);
	
	public List<?> getAllDisease_lighting();
	
	public boolean updateDisease_lighting(Disease_lighting disease_lighting);
	
	public boolean deleteDisease_lightingById(int id);
	
	public Map<?, ?> getAllDetailDisease_lighting(QueryItems qi);
	
	public Disease_lighting getDisease_lightingById(int id);
	
	public Disease_lighting getDisease_lightingByBridgeCode(String bridgeCode);
	
	public int getDisease_lightingCodeByBridgeCode(String bridgeCode);
	
	public List<Map<String, Object>> getAllDisease_lightingByBridgeCode(String bridgeCode);
}
