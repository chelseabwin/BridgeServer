package com.qjs.biz.impl;

import global.tool.QueryItems;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.StringType;

import com.qjs.biz.Disease_bedBiz;
import com.qjs.dao.Disease_bedDAO;
import com.qjs.entity.Disease_bed;

public class Disease_bedBizImpl implements Disease_bedBiz {
	
	private Disease_bedDAO disease_bedDAO;	
	
	public Disease_bedDAO getDisease_bedDAO() {
		return disease_bedDAO;
	}

	public void setDisease_bedDAO(Disease_bedDAO disease_bedDAO) {
		this.disease_bedDAO = disease_bedDAO;
	}

	@Override
	public Object addDisease_bed(Disease_bed disease_bed) {
		@SuppressWarnings("unchecked")
		List<Disease_bed> diseaselist = (List<Disease_bed>) disease_bedDAO.findEntityListByProperty("id", disease_bed.getId(), StandardBasicTypes.INTEGER);
		if (diseaselist.size() != 0) {
			return false;
		}
		disease_bedDAO.addEntity(disease_bed);
		return true;
	}

	@Override
	public List<?> getAllDisease_bed() {
		return disease_bedDAO.getAll();
	}

	@Override
	public boolean updateDisease_bed(Disease_bed disease_bed) {
		disease_bedDAO.updateEntity(disease_bed);
		return true;
	}

	@Override
	public boolean deleteDisease_bedById(int id) {
		@SuppressWarnings("unchecked")
		List<Disease_bed> diseaseList = (List<Disease_bed>) disease_bedDAO.findEntityListByProperty("id", id, StandardBasicTypes.INTEGER);
		if(diseaseList.size() != 0) {
			return false;
		}	
		
		int count = disease_bedDAO.deleteEntityByProperty("id", id, StandardBasicTypes.INTEGER);
		if (count != 1)
			return false;
		return true;
	}

	@Override
	public Map<?,?> getAllDetailDisease_bed(QueryItems qi) {
		Map<?,?> res =new HashMap<String, Object>();
		res = disease_bedDAO.findEntityListByProperties(qi);
		@SuppressWarnings("unchecked")
		List<Disease_bed> diseaselist = (List<Disease_bed>) res.get("result");
		List<Map<String, Object>> disinfo = new ArrayList<Map<String, Object>>();
		for(Disease_bed dil:diseaselist){
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
	public Disease_bed getDisease_bedById(int id) {
		@SuppressWarnings("unchecked")
		List<Disease_bed> diseaselist = (List<Disease_bed>) disease_bedDAO.findEntityListByProperty("id", id, StandardBasicTypes.INTEGER);
		if (diseaselist != null && diseaselist.size() == 1) {
			return diseaselist.get(0);
		}
		return null;
	}
	
	@Override
	public Disease_bed getDisease_bedByBridgeCode(String bridgeCode) {
		@SuppressWarnings("unchecked")
		List<Disease_bed> diseaselist = (List<Disease_bed>) disease_bedDAO.findEntityListByProperty("bg_id", bridgeCode, StringType.INSTANCE);
		if (diseaselist != null && diseaselist.size() == 1) {
			return diseaselist.get(0);
		}
		return null;
	}

	@Override
	public int getDisease_bedCodeByBridgeCode(String bridgeCode) {
		@SuppressWarnings("unchecked")
		List<Disease_bed> diseaselist = (List<Disease_bed>) disease_bedDAO.findEntityListByProperty("bg_id", bridgeCode, StringType.INSTANCE);
		if (diseaselist != null)
			return diseaselist.size();
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> getAllDisease_bedByBridgeCode(String bridgeCode) {
		List<Disease_bed> diseaselist = (List<Disease_bed>) disease_bedDAO.findEntityListByPropertySort("bg_id", "u.parts_id, u.item_name, u.rg_feature", bridgeCode, StringType.INSTANCE);
		
		List<Map<String, Object>> disinfo = new ArrayList<Map<String, Object>>();
		for (Disease_bed dil:diseaselist) {
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
