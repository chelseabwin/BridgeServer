package com.qjs.biz.impl;

import global.tool.OtherFunction;
import global.tool.QueryItems;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.StringType;

import com.qjs.biz.Disease_deckBiz;
import com.qjs.dao.Disease_deckDAO;
import com.qjs.entity.Disease_deck;

public class Disease_deckBizImpl implements Disease_deckBiz {
	
	private Disease_deckDAO disease_deckDAO;	
	
	public Disease_deckDAO getDisease_deckDAO() {
		return disease_deckDAO;
	}

	public void setDisease_deckDAO(Disease_deckDAO disease_deckDAO) {
		this.disease_deckDAO = disease_deckDAO;
	}

	@Override
	public Object addDisease_deck(Disease_deck disease_deck) {
		@SuppressWarnings("unchecked")
		List<Disease_deck> diseaselist = (List<Disease_deck>) disease_deckDAO.findEntityListByProperty("id", disease_deck.getId(), StandardBasicTypes.INTEGER);
		if (diseaselist.size() != 0) {
			return false;
		}
		disease_deckDAO.addEntity(disease_deck);
		return true;
	}

	@Override
	public List<?> getAllDisease_deck() {
		return disease_deckDAO.getAll();
	}

	@Override
	public boolean updateDisease_deck(Disease_deck disease_deck) {
		disease_deckDAO.updateEntity(disease_deck);
		return true;
	}

	@Override
	public boolean deleteDisease_deckById(int id) {
		@SuppressWarnings("unchecked")
		List<Disease_deck> diseaseList = (List<Disease_deck>) disease_deckDAO.findEntityListByProperty("id", id, StandardBasicTypes.INTEGER);
		if(diseaseList.size() != 0) {
			return false;
		}	
		
		int count = disease_deckDAO.deleteEntityByProperty("id", id, StandardBasicTypes.INTEGER);
		if (count != 1)
			return false;
		return true;
	}

	@Override
	public Map<?,?> getAllDetailDisease_deck(QueryItems qi) {
		Map<?,?> res =new HashMap<String, Object>();
		res = disease_deckDAO.findEntityListByProperties(qi);
		@SuppressWarnings("unchecked")
		List<Disease_deck> diseaselist = (List<Disease_deck>) res.get("result");
		List<Map<String, Object>> disinfo = new ArrayList<Map<String, Object>>();
		for(Disease_deck dil:diseaselist){
			Map<String, Object> obj = new HashMap<String,Object>();
			
			obj.put("id", dil.getId());
			obj.put("bg_id", dil.getBg_id());
			obj.put("parts_id", dil.getParts_id());
			obj.put("item_name", dil.getItem_name());
			obj.put("rg_feature", dil.getRg_feature());
			obj.put("add_content", dil.getAdd_content());
			obj.put("disease_image", dil.getDisease_image());
			obj.put("image_type", dil.getImage_type());
			obj.put("evaluation", dil.getEvaluation());
			obj.put("score", dil.getScore());
			obj.put("detect_time", dil.getDetect_time());
			disinfo.add(obj);
		}
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("count", res.get("count"));
		
		// ∞¥’’parts_id…˝À≥–Ú≈≈¡–
		try {
			new OtherFunction().listSort(disinfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		result.put("result", disinfo);
		return result;
	}

	@Override
	public Disease_deck getDisease_deckById(int id) {
		@SuppressWarnings("unchecked")
		List<Disease_deck> diseaselist = (List<Disease_deck>) disease_deckDAO.findEntityListByProperty("id", id, StandardBasicTypes.INTEGER);
		if (diseaselist != null && diseaselist.size() == 1) {
			return diseaselist.get(0);
		}
		return null;
	}
	
	@Override
	public Disease_deck getDisease_deckByBridgeCode(String bridgeCode) {
		@SuppressWarnings("unchecked")
		List<Disease_deck> diseaselist = (List<Disease_deck>) disease_deckDAO.findEntityListByProperty("bg_id", bridgeCode, StringType.INSTANCE);
		if (diseaselist != null && diseaselist.size() == 1) {
			return diseaselist.get(0);
		}
		return null;
	}

	@Override
	public int getDisease_deckCodeByBridgeCode(String bridgeCode) {
		@SuppressWarnings("unchecked")
		List<Disease_deck> diseaselist = (List<Disease_deck>) disease_deckDAO.findEntityListByProperty("bg_id", bridgeCode, StringType.INSTANCE);
		if (diseaselist != null)
			return diseaselist.size();
		return 0;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> getAllDisease_deckByBridgeCode(String bridgeCode) {
		List<Disease_deck> diseaselist = (List<Disease_deck>) disease_deckDAO.findEntityListByPropertySort("bg_id", "u.parts_id, u.item_name, u.rg_feature", bridgeCode, StringType.INSTANCE);
		
		List<Map<String, Object>> disinfo = new ArrayList<Map<String, Object>>();
		for (Disease_deck dil:diseaselist) {
			Map<String, Object> obj = new HashMap<String, Object>();
			
			obj.put("id", dil.getId() + "");
			obj.put("bg_id", dil.getBg_id());
			obj.put("parts_id", dil.getParts_id());
			obj.put("item_name", dil.getItem_name());
			obj.put("rg_feature", dil.getRg_feature());
			obj.put("add_content", dil.getAdd_content());
			obj.put("disease_image", dil.getDisease_image());
			obj.put("image_type", dil.getImage_type());
			obj.put("evaluation", dil.getEvaluation());
			obj.put("score", dil.getScore());
			obj.put("detect_time", dil.getDetect_time());
			disinfo.add(obj);
		}
		return disinfo;
	}
}
