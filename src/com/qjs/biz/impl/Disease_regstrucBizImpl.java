package com.qjs.biz.impl;

import global.tool.QueryItems;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.StringType;

import com.qjs.biz.Disease_regstrucBiz;
import com.qjs.dao.Disease_regstrucDAO;
import com.qjs.entity.Disease_regstruc;

public class Disease_regstrucBizImpl implements Disease_regstrucBiz {
	
	private Disease_regstrucDAO disease_regstrucDAO;	
	
	public Disease_regstrucDAO getDisease_regstrucDAO() {
		return disease_regstrucDAO;
	}

	public void setDisease_regstrucDAO(Disease_regstrucDAO disease_regstrucDAO) {
		this.disease_regstrucDAO = disease_regstrucDAO;
	}

	@Override
	public Object addDisease_regstruc(Disease_regstruc disease_regstruc) {
		@SuppressWarnings("unchecked")
		List<Disease_regstruc> diseaselist = (List<Disease_regstruc>) disease_regstrucDAO.findEntityListByProperty("id", disease_regstruc.getId(), StandardBasicTypes.INTEGER);
		if (diseaselist.size() != 0) {
			return false;
		}
		disease_regstrucDAO.addEntity(disease_regstruc);
		return true;
	}

	@Override
	public List<?> getAllDisease_regstruc() {
		return disease_regstrucDAO.getAll();
	}

	@Override
	public boolean updateDisease_regstruc(Disease_regstruc disease_regstruc) {
		disease_regstrucDAO.updateEntity(disease_regstruc);
		return true;
	}

	@Override
	public boolean deleteDisease_regstrucById(int id) {
		@SuppressWarnings("unchecked")
		List<Disease_regstruc> diseaseList = (List<Disease_regstruc>) disease_regstrucDAO.findEntityListByProperty("id", id, StandardBasicTypes.INTEGER);
		if(diseaseList.size() != 0) {
			return false;
		}	
		
		int count = disease_regstrucDAO.deleteEntityByProperty("id", id, StandardBasicTypes.INTEGER);
		if (count != 1)
			return false;
		return true;
	}

	@Override
	public Map<?,?> getAllDetailDisease_regstruc(QueryItems qi) {
		Map<?,?> res =new HashMap<String, Object>();
		res = disease_regstrucDAO.findEntityListByProperties(qi);
		@SuppressWarnings("unchecked")
		List<Disease_regstruc> diseaselist = (List<Disease_regstruc>) res.get("result");
		List<Map<String, Object>> disinfo = new ArrayList<Map<String, Object>>();
		for(Disease_regstruc dil:diseaselist){
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
			disinfo.add(obj);
		}
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("count", res.get("count"));
		result.put("result", disinfo);
		return result;
	}

	@Override
	public Disease_regstruc getDisease_regstrucById(int id) {
		@SuppressWarnings("unchecked")
		List<Disease_regstruc> diseaselist = (List<Disease_regstruc>) disease_regstrucDAO.findEntityListByProperty("id", id, StandardBasicTypes.INTEGER);
		if (diseaselist != null && diseaselist.size() == 1) {
			return diseaselist.get(0);
		}
		return null;
	}
	
	@Override
	public Disease_regstruc getDisease_regstrucByBridgeCode(String bridgeCode) {
		@SuppressWarnings("unchecked")
		List<Disease_regstruc> diseaselist = (List<Disease_regstruc>) disease_regstrucDAO.findEntityListByProperty("bg_id", bridgeCode, StringType.INSTANCE);
		if (diseaselist != null && diseaselist.size() == 1) {
			return diseaselist.get(0);
		}
		return null;
	}

	@Override
	public int getDisease_regstrucCodeByBridgeCode(String bridgeCode) {
		@SuppressWarnings("unchecked")
		List<Disease_regstruc> diseaselist = (List<Disease_regstruc>) disease_regstrucDAO.findEntityListByProperty("bg_id", bridgeCode, StringType.INSTANCE);
		if (diseaselist != null)
			return diseaselist.size();
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> getAllDisease_regstrucByBridgeCode(String bridgeCode) {
		List<Disease_regstruc> diseaselist = (List<Disease_regstruc>) disease_regstrucDAO.findEntityListByPropertySort("bg_id", "u.parts_id, u.item_name, u.rg_feature", bridgeCode, StringType.INSTANCE);
		
		List<Map<String, Object>> disinfo = new ArrayList<Map<String, Object>>();
		for (Disease_regstruc dil:diseaselist) {
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
			disinfo.add(obj);
		}
		return disinfo;
	}
}
