package com.qjs.biz.impl;

import global.tool.OtherFunction;
import global.tool.QueryItems;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.StringType;

import com.qjs.biz.Disease_wingwallBiz;
import com.qjs.dao.Disease_wingwallDAO;
import com.qjs.entity.Disease_wingwall;

public class Disease_wingwallBizImpl implements Disease_wingwallBiz {
	
	private Disease_wingwallDAO disease_wingwallDAO;	
	
	public Disease_wingwallDAO getDisease_wingwallDAO() {
		return disease_wingwallDAO;
	}

	public void setDisease_wingwallDAO(Disease_wingwallDAO disease_wingwallDAO) {
		this.disease_wingwallDAO = disease_wingwallDAO;
	}

	@Override
	public Object addDisease_wingwall(Disease_wingwall disease_wingwall) {
		@SuppressWarnings("unchecked")
		List<Disease_wingwall> diseaselist = (List<Disease_wingwall>) disease_wingwallDAO.findEntityListByProperty("id", disease_wingwall.getId(), StandardBasicTypes.INTEGER);
		if (diseaselist.size() != 0) {
			return false;
		}
		disease_wingwallDAO.addEntity(disease_wingwall);
		return true;
	}

	@Override
	public List<?> getAllDisease_wingwall() {
		return disease_wingwallDAO.getAll();
	}

	@Override
	public boolean updateDisease_wingwall(Disease_wingwall disease_wingwall) {
		disease_wingwallDAO.updateEntity(disease_wingwall);
		return true;
	}

	@Override
	public boolean deleteDisease_wingwallById(int id) {
		@SuppressWarnings("unchecked")
		List<Disease_wingwall> diseaseList = (List<Disease_wingwall>) disease_wingwallDAO.findEntityListByProperty("id", id, StandardBasicTypes.INTEGER);
		if(diseaseList.size() != 0) {
			return false;
		}	
		
		int count = disease_wingwallDAO.deleteEntityByProperty("id", id, StandardBasicTypes.INTEGER);
		if (count != 1)
			return false;
		return true;
	}

	@Override
	public Map<?,?> getAllDetailDisease_wingwall(QueryItems qi) {
		Map<?,?> res =new HashMap<String, Object>();
		res = disease_wingwallDAO.findEntityListByProperties(qi);
		@SuppressWarnings("unchecked")
		List<Disease_wingwall> diseaselist = (List<Disease_wingwall>) res.get("result");
		List<Map<String, Object>> disinfo = new ArrayList<Map<String, Object>>();
		for(Disease_wingwall dil:diseaselist){
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
	public Disease_wingwall getDisease_wingwallById(int id) {
		@SuppressWarnings("unchecked")
		List<Disease_wingwall> diseaselist = (List<Disease_wingwall>) disease_wingwallDAO.findEntityListByProperty("id", id, StandardBasicTypes.INTEGER);
		if (diseaselist != null && diseaselist.size() == 1) {
			return diseaselist.get(0);
		}
		return null;
	}
	
	@Override
	public Disease_wingwall getDisease_wingwallByBridgeCode(String bridgeCode) {
		@SuppressWarnings("unchecked")
		List<Disease_wingwall> diseaselist = (List<Disease_wingwall>) disease_wingwallDAO.findEntityListByProperty("bg_id", bridgeCode, StringType.INSTANCE);
		if (diseaselist != null && diseaselist.size() == 1) {
			return diseaselist.get(0);
		}
		return null;
	}

	@Override
	public int getDisease_wingwallCodeByBridgeCode(String bridgeCode) {
		@SuppressWarnings("unchecked")
		List<Disease_wingwall> diseaselist = (List<Disease_wingwall>) disease_wingwallDAO.findEntityListByProperty("bg_id", bridgeCode, StringType.INSTANCE);
		if (diseaselist != null)
			return diseaselist.size();
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> getAllDisease_wingwallByBridgeCode(String bridgeCode) {
		List<Disease_wingwall> diseaselist = (List<Disease_wingwall>) disease_wingwallDAO.findEntityListByPropertySort("bg_id", "u.parts_id, u.item_name, u.rg_feature", bridgeCode, StringType.INSTANCE);
		
		List<Map<String, Object>> disinfo = new ArrayList<Map<String, Object>>();
		for (Disease_wingwall dil:diseaselist) {
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
