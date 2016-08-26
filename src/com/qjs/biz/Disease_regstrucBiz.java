package com.qjs.biz;

import global.tool.QueryItems;

import java.util.List;
import java.util.Map;

import com.qjs.entity.Disease_regstruc;

public interface Disease_regstrucBiz {
	
	public Object addDisease_regstruc(Disease_regstruc disease_regstruc);
	
	public List<?> getAllDisease_regstruc();
	
	public boolean updateDisease_regstruc(Disease_regstruc disease_regstruc);
	
	public boolean deleteDisease_regstrucById(int id);
	
	public Map<?, ?> getAllDetailDisease_regstruc(QueryItems qi);
	
	public Disease_regstruc getDisease_regstrucById(int id);
	
	public Disease_regstruc getDisease_regstrucByBridgeCode(String bridgeCode);
	
	public int getDisease_regstrucCodeByBridgeCode(String bridgeCode);
	
	public List<Map<String, Object>> getAllDisease_regstrucByBridgeCode(String bridgeCode);
}
