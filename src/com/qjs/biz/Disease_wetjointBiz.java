package com.qjs.biz;

import global.tool.QueryItems;

import java.util.List;
import java.util.Map;

import com.qjs.entity.Disease_wetjoint;

public interface Disease_wetjointBiz {
	
	public Object addDisease_wetjoint(Disease_wetjoint disease_wetjoint);
	
	public List<?> getAllDisease_wetjoint();
	
	public boolean updateDisease_wetjoint(Disease_wetjoint disease_wetjoint);
	
	public boolean deleteDisease_wetjointById(int id);
	
	public Map<?, ?> getAllDetailDisease_wetjoint(QueryItems qi);
	
	public Disease_wetjoint getDisease_wetjointById(int id);
	
	public Disease_wetjoint getDisease_wetjointByBridgeCode(String bridgeCode);
	
	public int getDisease_wetjointCodeByBridgeCode(String bridgeCode);
	
	public List<Map<String, Object>> getAllDisease_wetjointByBridgeCode(String bridgeCode);
}
