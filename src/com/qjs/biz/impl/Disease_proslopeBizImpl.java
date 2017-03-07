package com.qjs.biz.impl;

import global.tool.OtherFunction;
import global.tool.QueryItems;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.StringType;

import com.qjs.biz.Disease_proslopeBiz;
import com.qjs.dao.Disease_proslopeDAO;
import com.qjs.entity.Disease_proslope;

public class Disease_proslopeBizImpl implements Disease_proslopeBiz {
	
	private Disease_proslopeDAO disease_proslopeDAO;	
	
	public Disease_proslopeDAO getDisease_proslopeDAO() {
		return disease_proslopeDAO;
	}

	public void setDisease_proslopeDAO(Disease_proslopeDAO disease_proslopeDAO) {
		this.disease_proslopeDAO = disease_proslopeDAO;
	}

	@Override
	public Object addDisease_proslope(Disease_proslope disease_proslope) {
		@SuppressWarnings("unchecked")
		List<Disease_proslope> diseaselist = (List<Disease_proslope>) disease_proslopeDAO.findEntityListByProperty("id", disease_proslope.getId(), StandardBasicTypes.INTEGER);
		if (diseaselist.size() != 0) {
			return false;
		}
		disease_proslopeDAO.addEntity(disease_proslope);
		return true;
	}

	@Override
	public List<?> getAllDisease_proslope() {
		return disease_proslopeDAO.getAll();
	}

	@Override
	public boolean updateDisease_proslope(Disease_proslope disease_proslope) {
		disease_proslopeDAO.updateEntity(disease_proslope);
		return true;
	}

	@Override
	public boolean deleteDisease_proslopeById(int id) {
		@SuppressWarnings("unchecked")
		List<Disease_proslope> diseaseList = (List<Disease_proslope>) disease_proslopeDAO.findEntityListByProperty("id", id, StandardBasicTypes.INTEGER);
		if(diseaseList.size() != 0) {
			return false;
		}	
		
		int count = disease_proslopeDAO.deleteEntityByProperty("id", id, StandardBasicTypes.INTEGER);
		if (count != 1)
			return false;
		return true;
	}

	@Override
	public Map<?,?> getAllDetailDisease_proslope(QueryItems qi) {
		Map<?,?> res =new HashMap<String, Object>();
		res = disease_proslopeDAO.findEntityListByProperties(qi);
		@SuppressWarnings("unchecked")
		List<Disease_proslope> diseaselist = (List<Disease_proslope>) res.get("result");
		List<Map<String, Object>> disinfo = new ArrayList<Map<String, Object>>();
		for(Disease_proslope dil:diseaselist){
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
	public Disease_proslope getDisease_proslopeById(int id) {
		@SuppressWarnings("unchecked")
		List<Disease_proslope> diseaselist = (List<Disease_proslope>) disease_proslopeDAO.findEntityListByProperty("id", id, StandardBasicTypes.INTEGER);
		if (diseaselist != null && diseaselist.size() == 1) {
			return diseaselist.get(0);
		}
		return null;
	}
	
	@Override
	public Disease_proslope getDisease_proslopeByBridgeCode(String bridgeCode) {
		@SuppressWarnings("unchecked")
		List<Disease_proslope> diseaselist = (List<Disease_proslope>) disease_proslopeDAO.findEntityListByProperty("bg_id", bridgeCode, StringType.INSTANCE);
		if (diseaselist != null && diseaselist.size() == 1) {
			return diseaselist.get(0);
		}
		return null;
	}

	@Override
	public int getDisease_proslopeCodeByBridgeCode(String bridgeCode) {
		@SuppressWarnings("unchecked")
		List<Disease_proslope> diseaselist = (List<Disease_proslope>) disease_proslopeDAO.findEntityListByProperty("bg_id", bridgeCode, StringType.INSTANCE);
		if (diseaselist != null)
			return diseaselist.size();
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> getAllDisease_proslopeByBridgeCode(String bridgeCode) {
		List<Disease_proslope> diseaselist = (List<Disease_proslope>) disease_proslopeDAO.findEntityListByPropertySort("bg_id", "u.parts_id, u.item_name, u.rg_feature", bridgeCode, StringType.INSTANCE);
		
		List<Map<String, Object>> disinfo = new ArrayList<Map<String, Object>>();
		for (Disease_proslope dil:diseaselist) {
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
