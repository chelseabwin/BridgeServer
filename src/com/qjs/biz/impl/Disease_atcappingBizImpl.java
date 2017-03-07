package com.qjs.biz.impl;

import global.tool.OtherFunction;
import global.tool.QueryItems;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.StringType;

import com.qjs.biz.Disease_atcappingBiz;
import com.qjs.dao.Disease_atcappingDAO;
import com.qjs.entity.Disease_atcapping;

public class Disease_atcappingBizImpl implements Disease_atcappingBiz {
	
	private Disease_atcappingDAO disease_atcappingDAO;	
	
	public Disease_atcappingDAO getDisease_atcappingDAO() {
		return disease_atcappingDAO;
	}

	public void setDisease_atcappingDAO(Disease_atcappingDAO disease_atcappingDAO) {
		this.disease_atcappingDAO = disease_atcappingDAO;
	}

	@Override
	public Object addDisease_atcapping(Disease_atcapping disease_atcapping) {
		@SuppressWarnings("unchecked")
		List<Disease_atcapping> diseaselist = (List<Disease_atcapping>) disease_atcappingDAO.findEntityListByProperty("id", disease_atcapping.getId(), StandardBasicTypes.INTEGER);
		if (diseaselist.size() != 0) {
			return false;
		}
		disease_atcappingDAO.addEntity(disease_atcapping);
		return true;
	}

	@Override
	public List<?> getAllDisease_atcapping() {
		return disease_atcappingDAO.getAll();
	}

	@Override
	public boolean updateDisease_atcapping(Disease_atcapping disease_atcapping) {
		disease_atcappingDAO.updateEntity(disease_atcapping);
		return true;
	}

	@Override
	public boolean deleteDisease_atcappingById(int id) {
		@SuppressWarnings("unchecked")
		List<Disease_atcapping> diseaseList = (List<Disease_atcapping>) disease_atcappingDAO.findEntityListByProperty("id", id, StandardBasicTypes.INTEGER);
		if(diseaseList.size() != 0) {
			return false;
		}	
		
		int count = disease_atcappingDAO.deleteEntityByProperty("id", id, StandardBasicTypes.INTEGER);
		if (count != 1)
			return false;
		return true;
	}

	@Override
	public Map<?,?> getAllDetailDisease_atcapping(QueryItems qi) {
		Map<?,?> res =new HashMap<String, Object>();
		res = disease_atcappingDAO.findEntityListByProperties(qi);
		@SuppressWarnings("unchecked")
		List<Disease_atcapping> diseaselist = (List<Disease_atcapping>) res.get("result");
		List<Map<String, Object>> disinfo = new ArrayList<Map<String, Object>>();
		for(Disease_atcapping dil:diseaselist){
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
	public Disease_atcapping getDisease_atcappingById(int id) {
		@SuppressWarnings("unchecked")
		List<Disease_atcapping> diseaselist = (List<Disease_atcapping>) disease_atcappingDAO.findEntityListByProperty("id", id, StandardBasicTypes.INTEGER);
		if (diseaselist != null && diseaselist.size() == 1) {
			return diseaselist.get(0);
		}
		return null;
	}
	
	@Override
	public Disease_atcapping getDisease_atcappingByBridgeCode(String bridgeCode) {
		@SuppressWarnings("unchecked")
		List<Disease_atcapping> diseaselist = (List<Disease_atcapping>) disease_atcappingDAO.findEntityListByProperty("bg_id", bridgeCode, StringType.INSTANCE);
		if (diseaselist != null && diseaselist.size() == 1) {
			return diseaselist.get(0);
		}
		return null;
	}

	@Override
	public int getDisease_atcappingCodeByBridgeCode(String bridgeCode) {
		@SuppressWarnings("unchecked")
		List<Disease_atcapping> diseaselist = (List<Disease_atcapping>) disease_atcappingDAO.findEntityListByProperty("bg_id", bridgeCode, StringType.INSTANCE);
		if (diseaselist != null)
			return diseaselist.size();
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> getAllDisease_atcappingByBridgeCode(String bridgeCode) {
		List<Disease_atcapping> diseaselist = (List<Disease_atcapping>) disease_atcappingDAO.findEntityListByPropertySort("bg_id", "u.parts_id, u.item_name, u.rg_feature", bridgeCode, StringType.INSTANCE);
		
		List<Map<String, Object>> disinfo = new ArrayList<Map<String, Object>>();
		for (Disease_atcapping dil:diseaselist) {
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
