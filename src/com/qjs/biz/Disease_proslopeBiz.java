package com.qjs.biz;

import global.tool.QueryItems;

import java.util.List;
import java.util.Map;

import com.qjs.entity.Disease_proslope;

public interface Disease_proslopeBiz {
	
	public Object addDisease_proslope(Disease_proslope disease_proslope);
	
	public List<?> getAllDisease_proslope();
	
	public boolean updateDisease_proslope(Disease_proslope disease_proslope);
	
	public boolean deleteDisease_proslopeById(int id);
	
	public Map<?, ?> getAllDetailDisease_proslope(QueryItems qi);
	
	public Disease_proslope getDisease_proslopeById(int id);
	
	public Disease_proslope getDisease_proslopeByBridgeCode(String bridgeCode);
	
	public int getDisease_proslopeCodeByBridgeCode(String bridgeCode);
}
