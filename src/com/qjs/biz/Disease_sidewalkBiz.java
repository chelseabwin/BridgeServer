package com.qjs.biz;

import global.tool.QueryItems;

import java.util.List;
import java.util.Map;

import com.qjs.entity.Disease_sidewalk;

public interface Disease_sidewalkBiz {
	
	public Object addDisease_sidewalk(Disease_sidewalk disease_sidewalk);
	
	public List<?> getAllDisease_sidewalk();
	
	public boolean updateDisease_sidewalk(Disease_sidewalk disease_sidewalk);
	
	public boolean deleteDisease_sidewalkById(int id);
	
	public Map<?, ?> getAllDetailDisease_sidewalk(QueryItems qi);
	
	public Disease_sidewalk getDisease_sidewalkById(int id);
	
	public Disease_sidewalk getDisease_sidewalkByBridgeCode(String bridgeCode);
	
	public int getDisease_sidewalkCodeByBridgeCode(String bridgeCode);
}
