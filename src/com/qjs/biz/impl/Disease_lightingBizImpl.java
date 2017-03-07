package com.qjs.biz.impl;

import global.tool.OtherFunction;
import global.tool.QueryItems;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.StringType;

import com.qjs.biz.Disease_lightingBiz;
import com.qjs.dao.Disease_lightingDAO;
import com.qjs.entity.Disease_lighting;

public class Disease_lightingBizImpl implements Disease_lightingBiz {
	
	private Disease_lightingDAO disease_lightingDAO;	
	
	public Disease_lightingDAO getDisease_lightingDAO() {
		return disease_lightingDAO;
	}

	public void setDisease_lightingDAO(Disease_lightingDAO disease_lightingDAO) {
		this.disease_lightingDAO = disease_lightingDAO;
	}

	@Override
	public Object addDisease_lighting(Disease_lighting disease_lighting) {
		@SuppressWarnings("unchecked")
		List<Disease_lighting> diseaselist = (List<Disease_lighting>) disease_lightingDAO.findEntityListByProperty("id", disease_lighting.getId(), StandardBasicTypes.INTEGER);
		if (diseaselist.size() != 0) {
			return false;
		}
		disease_lightingDAO.addEntity(disease_lighting);
		return true;
	}

	@Override
	public List<?> getAllDisease_lighting() {
		return disease_lightingDAO.getAll();
	}

	@Override
	public boolean updateDisease_lighting(Disease_lighting disease_lighting) {
		disease_lightingDAO.updateEntity(disease_lighting);
		return true;
	}

	@Override
	public boolean deleteDisease_lightingById(int id) {
		@SuppressWarnings("unchecked")
		List<Disease_lighting> diseaseList = (List<Disease_lighting>) disease_lightingDAO.findEntityListByProperty("id", id, StandardBasicTypes.INTEGER);
		if(diseaseList.size() != 0) {
			return false;
		}	
		
		int count = disease_lightingDAO.deleteEntityByProperty("id", id, StandardBasicTypes.INTEGER);
		if (count != 1)
			return false;
		return true;
	}

	@Override
	public Map<?,?> getAllDetailDisease_lighting(QueryItems qi) {
		Map<?,?> res =new HashMap<String, Object>();
		res = disease_lightingDAO.findEntityListByProperties(qi);
		@SuppressWarnings("unchecked")
		List<Disease_lighting> diseaselist = (List<Disease_lighting>) res.get("result");
		List<Map<String, Object>> disinfo = new ArrayList<Map<String, Object>>();
		for(Disease_lighting dil:diseaselist){
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
	public Disease_lighting getDisease_lightingById(int id) {
		@SuppressWarnings("unchecked")
		List<Disease_lighting> diseaselist = (List<Disease_lighting>) disease_lightingDAO.findEntityListByProperty("id", id, StandardBasicTypes.INTEGER);
		if (diseaselist != null && diseaselist.size() == 1) {
			return diseaselist.get(0);
		}
		return null;
	}
	
	@Override
	public Disease_lighting getDisease_lightingByBridgeCode(String bridgeCode) {
		@SuppressWarnings("unchecked")
		List<Disease_lighting> diseaselist = (List<Disease_lighting>) disease_lightingDAO.findEntityListByProperty("bg_id", bridgeCode, StringType.INSTANCE);
		if (diseaselist != null && diseaselist.size() == 1) {
			return diseaselist.get(0);
		}
		return null;
	}

	@Override
	public int getDisease_lightingCodeByBridgeCode(String bridgeCode) {
		@SuppressWarnings("unchecked")
		List<Disease_lighting> diseaselist = (List<Disease_lighting>) disease_lightingDAO.findEntityListByProperty("bg_id", bridgeCode, StringType.INSTANCE);
		if (diseaselist != null)
			return diseaselist.size();
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> getAllDisease_lightingByBridgeCode(String bridgeCode) {
		List<Disease_lighting> diseaselist = (List<Disease_lighting>) disease_lightingDAO.findEntityListByPropertySort("bg_id", "u.parts_id, u.item_name, u.rg_feature", bridgeCode, StringType.INSTANCE);
		
		List<Map<String, Object>> disinfo = new ArrayList<Map<String, Object>>();
		for (Disease_lighting dil:diseaselist) {
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
