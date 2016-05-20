package com.qjs.biz;

import global.tool.QueryItems;

import java.util.List;
import java.util.Map;

import com.qjs.entity.Disease_girder;

public interface Disease_girderBiz {
	
	public Object addDisease_girder(Disease_girder disease_girder);
	
	public List<?> getAllDisease_girder();
	
	public boolean updateDisease_girder(Disease_girder disease_girder);
	
	public boolean deleteDisease_girderById(int id);
	
	public Map<?, ?> getAllDetailDisease_girder(QueryItems qi);
	
	public Disease_girder getDisease_girderById(int id);
	
	public Disease_girder getDisease_girderByBridgeCode(String bridgeCode);
	
	public int getDisease_girderCodeByBridgeCode(String bridgeCode);
}
