package com.qjs.biz;

import global.tool.QueryItems;

import java.util.List;
import java.util.Map;

import com.qjs.entity.Disease_deck;

public interface Disease_deckBiz {
	
	public Object addDisease_deck(Disease_deck disease_deck);
	
	public List<?> getAllDisease_deck();
	
	public boolean updateDisease_deck(Disease_deck disease_deck);
	
	public boolean deleteDisease_deckById(int id);
	
	public Map<?, ?> getAllDetailDisease_deck(QueryItems qi);
	
	public Disease_deck getDisease_deckById(int id);
	
	public Disease_deck getDisease_deckByBridgeCode(String bridgeCode);
	
	public int getDisease_deckCodeByBridgeCode(String bridgeCode);
	
	public List<Map<String, Object>> getAllDisease_deckByBridgeCode(String bridgeCode);
}
