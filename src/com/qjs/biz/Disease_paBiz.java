package com.qjs.biz;

import global.tool.QueryItems;

import java.util.List;
import java.util.Map;

import com.qjs.entity.Disease_pa;

public interface Disease_paBiz {
	
	public Object addDisease_pa(Disease_pa disease_pa);
	
	public List<?> getAllDisease_pa();
	
	public boolean updateDisease_pa(Disease_pa disease_pa);
	
	public boolean deleteDisease_paById(int id);
	
	public Map<?, ?> getAllDetailDisease_pa(QueryItems qi);
	
	public Disease_pa getDisease_paById(int id);
	
	public Disease_pa getDisease_paByBridgeCode(String bridgeCode);
	
	public int getDisease_paCodeByBridgeCode(String bridgeCode);
	
	public List<Map<String, Object>> getAllDisease_paByBridgeCode(String bridgeCode);
}
