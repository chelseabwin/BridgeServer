package com.qjs.biz;

import global.tool.QueryItems;

import java.util.List;
import java.util.Map;

import com.qjs.entity.Disease_joint;

public interface Disease_jointBiz {
	
	public Object addDisease_joint(Disease_joint disease_joint);
	
	public List<?> getAllDisease_joint();
	
	public boolean updateDisease_joint(Disease_joint disease_joint);
	
	public boolean deleteDisease_jointById(int id);
	
	public Map<?, ?> getAllDetailDisease_joint(QueryItems qi);
	
	public Disease_joint getDisease_jointById(int id);
	
	public Disease_joint getDisease_jointByBridgeCode(String bridgeCode);
	
	public int getDisease_jointCodeByBridgeCode(String bridgeCode);
	
	public List<Map<String, Object>> getAllDisease_jointByBridgeCode(String bridgeCode);
}
