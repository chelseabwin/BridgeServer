package com.qjs.biz.impl;

import global.tool.OtherFunction;
import global.tool.QueryItems;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.StringType;

import com.qjs.biz.Disease_watertightBiz;
import com.qjs.dao.Disease_watertightDAO;
import com.qjs.entity.Disease_watertight;

public class Disease_watertightBizImpl implements Disease_watertightBiz {
	
	private Disease_watertightDAO disease_watertightDAO;	
	
	public Disease_watertightDAO getDisease_watertightDAO() {
		return disease_watertightDAO;
	}

	public void setDisease_watertightDAO(Disease_watertightDAO disease_watertightDAO) {
		this.disease_watertightDAO = disease_watertightDAO;
	}

	@Override
	public Object addDisease_watertight(Disease_watertight disease_watertight) {
		@SuppressWarnings("unchecked")
		List<Disease_watertight> diseaselist = (List<Disease_watertight>) disease_watertightDAO.findEntityListByProperty("id", disease_watertight.getId(), StandardBasicTypes.INTEGER);
		if (diseaselist.size() != 0) {
			return false;
		}
		disease_watertightDAO.addEntity(disease_watertight);
		return true;
	}

	@Override
	public List<?> getAllDisease_watertight() {
		return disease_watertightDAO.getAll();
	}

	@Override
	public boolean updateDisease_watertight(Disease_watertight disease_watertight) {
		disease_watertightDAO.updateEntity(disease_watertight);
		return true;
	}

	@Override
	public boolean deleteDisease_watertightById(int id) {
		@SuppressWarnings("unchecked")
		List<Disease_watertight> diseaseList = (List<Disease_watertight>) disease_watertightDAO.findEntityListByProperty("id", id, StandardBasicTypes.INTEGER);
		if(diseaseList.size() != 0) {
			return false;
		}	
		
		int count = disease_watertightDAO.deleteEntityByProperty("id", id, StandardBasicTypes.INTEGER);
		if (count != 1)
			return false;
		return true;
	}

	@Override
	public Map<?,?> getAllDetailDisease_watertight(QueryItems qi) {
		Map<?,?> res =new HashMap<String, Object>();
		res = disease_watertightDAO.findEntityListByProperties(qi);
		@SuppressWarnings("unchecked")
		List<Disease_watertight> diseaselist = (List<Disease_watertight>) res.get("result");
		List<Map<String, Object>> disinfo = new ArrayList<Map<String, Object>>();
		for(Disease_watertight dil:diseaselist){
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
	public Disease_watertight getDisease_watertightById(int id) {
		@SuppressWarnings("unchecked")
		List<Disease_watertight> diseaselist = (List<Disease_watertight>) disease_watertightDAO.findEntityListByProperty("id", id, StandardBasicTypes.INTEGER);
		if (diseaselist != null && diseaselist.size() == 1) {
			return diseaselist.get(0);
		}
		return null;
	}
	
	@Override
	public Disease_watertight getDisease_watertightByBridgeCode(String bridgeCode) {
		@SuppressWarnings("unchecked")
		List<Disease_watertight> diseaselist = (List<Disease_watertight>) disease_watertightDAO.findEntityListByProperty("bg_id", bridgeCode, StringType.INSTANCE);
		if (diseaselist != null && diseaselist.size() == 1) {
			return diseaselist.get(0);
		}
		return null;
	}

	@Override
	public int getDisease_watertightCodeByBridgeCode(String bridgeCode) {
		@SuppressWarnings("unchecked")
		List<Disease_watertight> diseaselist = (List<Disease_watertight>) disease_watertightDAO.findEntityListByProperty("bg_id", bridgeCode, StringType.INSTANCE);
		if (diseaselist != null)
			return diseaselist.size();
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> getAllDisease_watertightByBridgeCode(String bridgeCode) {
		List<Disease_watertight> diseaselist = (List<Disease_watertight>) disease_watertightDAO.findEntityListByPropertySort("bg_id", "u.parts_id, u.item_name, u.rg_feature", bridgeCode, StringType.INSTANCE);
		
		List<Map<String, Object>> disinfo = new ArrayList<Map<String, Object>>();
		for (Disease_watertight dil:diseaselist) {
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
