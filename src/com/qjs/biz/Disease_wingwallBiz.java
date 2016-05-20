package com.qjs.biz;

import global.tool.QueryItems;

import java.util.List;
import java.util.Map;

import com.qjs.entity.Disease_wingwall;

public interface Disease_wingwallBiz {
	
	public Object addDisease_wingwall(Disease_wingwall disease_wingwall);
	
	public List<?> getAllDisease_wingwall();
	
	public boolean updateDisease_wingwall(Disease_wingwall disease_wingwall);
	
	public boolean deleteDisease_wingwallById(int id);
	
	public Map<?, ?> getAllDetailDisease_wingwall(QueryItems qi);
	
	public Disease_wingwall getDisease_wingwallById(int id);
	
	public Disease_wingwall getDisease_wingwallByBridgeCode(String bridgeCode);
	
	public int getDisease_wingwallCodeByBridgeCode(String bridgeCode);
}
