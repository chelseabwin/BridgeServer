package com.qjs.biz.impl;

import global.tool.QueryItems;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.StringType;

import com.qjs.biz.Disease_supportBiz;
import com.qjs.dao.Disease_supportDAO;
import com.qjs.entity.Disease_support;

public class Disease_supportBizImpl implements Disease_supportBiz {
	
	private Disease_supportDAO disease_supportDAO;	
	
	public Disease_supportDAO getDisease_supportDAO() {
		return disease_supportDAO;
	}

	public void setDisease_supportDAO(Disease_supportDAO disease_supportDAO) {
		this.disease_supportDAO = disease_supportDAO;
	}

	@Override
	public Object addDisease_support(Disease_support disease_support) {
		@SuppressWarnings("unchecked")
		List<Disease_support> diseaselist = (List<Disease_support>) disease_supportDAO.findEntityListByProperty("id", disease_support.getId(), StandardBasicTypes.INTEGER);
		if (diseaselist.size() != 0) {
			return false;
		}
		disease_supportDAO.addEntity(disease_support);
		return true;
	}

	@Override
	public List<?> getAllDisease_support() {
		return disease_supportDAO.getAll();
	}

	@Override
	public boolean updateDisease_support(Disease_support disease_support) {
		disease_supportDAO.updateEntity(disease_support);
		return true;
	}

	@Override
	public boolean deleteDisease_supportById(int id) {
		@SuppressWarnings("unchecked")
		List<Disease_support> diseaseList = (List<Disease_support>) disease_supportDAO.findEntityListByProperty("id", id, StandardBasicTypes.INTEGER);
		if(diseaseList.size() != 0) {
			return false;
		}	
		
		int count = disease_supportDAO.deleteEntityByProperty("id", id, StandardBasicTypes.INTEGER);
		if (count != 1)
			return false;
		return true;
	}

	@Override
	public Map<?,?> getAllDetailDisease_support(QueryItems qi) {
		Map<?,?> res =new HashMap<String, Object>();
		res = disease_supportDAO.findEntityListByProperties(qi);
		@SuppressWarnings("unchecked")
		List<Disease_support> diseaselist = (List<Disease_support>) res.get("result");
		List<Map<String, Object>> disinfo = new ArrayList<Map<String, Object>>();
		for(Disease_support dil:diseaselist){
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
	public Disease_support getDisease_supportById(int id) {
		@SuppressWarnings("unchecked")
		List<Disease_support> diseaselist = (List<Disease_support>) disease_supportDAO.findEntityListByProperty("id", id, StandardBasicTypes.INTEGER);
		if (diseaselist != null && diseaselist.size() == 1) {
			return diseaselist.get(0);
		}
		return null;
	}
	
	@Override
	public Disease_support getDisease_supportByBridgeCode(String bridgeCode) {
		@SuppressWarnings("unchecked")
		List<Disease_support> diseaselist = (List<Disease_support>) disease_supportDAO.findEntityListByProperty("bg_id", bridgeCode, StringType.INSTANCE);
		if (diseaselist != null && diseaselist.size() == 1) {
			return diseaselist.get(0);
		}
		return null;
	}

	@Override
	public int getDisease_supportCodeByBridgeCode(String bridgeCode) {
		@SuppressWarnings("unchecked")
		List<Disease_support> diseaselist = (List<Disease_support>) disease_supportDAO.findEntityListByProperty("bg_id", bridgeCode, StringType.INSTANCE);
		if (diseaselist != null)
			return diseaselist.size();
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> getAllDisease_supportByBridgeCode(String bridgeCode) {
		List<Disease_support> diseaselist = (List<Disease_support>) disease_supportDAO.findEntityListByPropertySort("bg_id", "u.parts_id, u.item_name, u.rg_feature", bridgeCode, StringType.INSTANCE);
		
		List<Map<String, Object>> disinfo = new ArrayList<Map<String, Object>>();
		for (Disease_support dil:diseaselist) {
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
