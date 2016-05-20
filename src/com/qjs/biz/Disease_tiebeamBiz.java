package com.qjs.biz;

import global.tool.QueryItems;

import java.util.List;
import java.util.Map;

import com.qjs.entity.Disease_tiebeam;

public interface Disease_tiebeamBiz {
	
	public Object addDisease_tiebeam(Disease_tiebeam disease_tiebeam);
	
	public List<?> getAllDisease_tiebeam();
	
	public boolean updateDisease_tiebeam(Disease_tiebeam disease_tiebeam);
	
	public boolean deleteDisease_tiebeamById(int id);
	
	public Map<?, ?> getAllDetailDisease_tiebeam(QueryItems qi);
	
	public Disease_tiebeam getDisease_tiebeamById(int id);
	
	public Disease_tiebeam getDisease_tiebeamByBridgeCode(String bridgeCode);
	
	public int getDisease_tiebeamCodeByBridgeCode(String bridgeCode);
}
