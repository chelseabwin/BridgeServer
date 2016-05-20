package com.qjs.biz;

import global.tool.QueryItems;

import java.util.List;
import java.util.Map;

import com.qjs.entity.Disease_conslope;

public interface Disease_conslopeBiz {
	
	public Object addDisease_conslope(Disease_conslope disease_conslope);
	
	public List<?> getAllDisease_conslope();
	
	public boolean updateDisease_conslope(Disease_conslope disease_conslope);
	
	public boolean deleteDisease_conslopeById(int id);
	
	public Map<?, ?> getAllDetailDisease_conslope(QueryItems qi);
	
	public Disease_conslope getDisease_conslopeById(int id);
	
	public Disease_conslope getDisease_conslopeByBridgeCode(String bridgeCode);
	
	public int getDisease_conslopeCodeByBridgeCode(String bridgeCode);
}
