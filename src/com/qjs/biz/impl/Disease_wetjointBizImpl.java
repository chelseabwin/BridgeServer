package com.qjs.biz.impl;

import global.tool.QueryItems;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.StringType;

import com.qjs.biz.Disease_wetjointBiz;
import com.qjs.dao.Disease_wetjointDAO;
import com.qjs.entity.Disease_wetjoint;

public class Disease_wetjointBizImpl implements Disease_wetjointBiz {
	
	private Disease_wetjointDAO disease_wetjointDAO;	
	
	public Disease_wetjointDAO getDisease_wetjointDAO() {
		return disease_wetjointDAO;
	}

	public void setDisease_wetjointDAO(Disease_wetjointDAO disease_wetjointDAO) {
		this.disease_wetjointDAO = disease_wetjointDAO;
	}

	@Override
	public Object addDisease_wetjoint(Disease_wetjoint disease_wetjoint) {
		@SuppressWarnings("unchecked")
		List<Disease_wetjoint> diseaselist = (List<Disease_wetjoint>) disease_wetjointDAO.findEntityListByProperty("id", disease_wetjoint.getId(), StandardBasicTypes.INTEGER);
		if (diseaselist.size() != 0) {
			return false;
		}
		disease_wetjointDAO.addEntity(disease_wetjoint);
		return true;
	}

	@Override
	public List<?> getAllDisease_wetjoint() {
		return disease_wetjointDAO.getAll();
	}

	@Override
	public boolean updateDisease_wetjoint(Disease_wetjoint disease_wetjoint) {
		disease_wetjointDAO.updateEntity(disease_wetjoint);
		return true;
	}

	@Override
	public boolean deleteDisease_wetjointById(int id) {
		@SuppressWarnings("unchecked")
		List<Disease_wetjoint> diseaseList = (List<Disease_wetjoint>) disease_wetjointDAO.findEntityListByProperty("id", id, StandardBasicTypes.INTEGER);
		if(diseaseList.size() != 0) {
			return false;
		}	
		
		int count = disease_wetjointDAO.deleteEntityByProperty("id", id, StandardBasicTypes.INTEGER);
		if (count != 1)
			return false;
		return true;
	}

	@Override
	public Map<?,?> getAllDetailDisease_wetjoint(QueryItems qi) {
		Map<?,?> res =new HashMap<String, Object>();
		res = disease_wetjointDAO.findEntityListByProperties(qi);
		@SuppressWarnings("unchecked")
		List<Disease_wetjoint> diseaselist = (List<Disease_wetjoint>) res.get("result");
		List<Map<String, Object>> disinfo = new ArrayList<Map<String, Object>>();
		for(Disease_wetjoint dil:diseaselist){
			Map<String, Object> obj = new HashMap<String,Object>();
			
			obj.put("id", dil.getId());
			obj.put("bg_id", dil.getBg_id());
			obj.put("parts_id", dil.getParts_id());
			obj.put("item_name", dil.getItem_name());
			obj.put("rg_feature", dil.getRg_feature());
			obj.put("rg_fissure", dil.getRg_fissure());
			obj.put("sp_otherDisease", dil.getSp_otherDisease());			
			obj.put("l1_start", dil.getL1_start());
			obj.put("l1_end", dil.getL1_end());
			obj.put("l1_area", dil.getL1_area());
			obj.put("l2_start", dil.getL2_start());
			obj.put("l2_length", dil.getL2_length());
			obj.put("l2_width", dil.getL2_width());
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
	public Disease_wetjoint getDisease_wetjointById(int id) {
		@SuppressWarnings("unchecked")
		List<Disease_wetjoint> diseaselist = (List<Disease_wetjoint>) disease_wetjointDAO.findEntityListByProperty("id", id, StandardBasicTypes.INTEGER);
		if (diseaselist != null && diseaselist.size() == 1) {
			return diseaselist.get(0);
		}
		return null;
	}
	
	@Override
	public Disease_wetjoint getDisease_wetjointByBridgeCode(String bridgeCode) {
		@SuppressWarnings("unchecked")
		List<Disease_wetjoint> diseaselist = (List<Disease_wetjoint>) disease_wetjointDAO.findEntityListByProperty("bg_id", bridgeCode, StringType.INSTANCE);
		if (diseaselist != null && diseaselist.size() == 1) {
			return diseaselist.get(0);
		}
		return null;
	}

	@Override
	public int getDisease_wetjointCodeByBridgeCode(String bridgeCode) {
		@SuppressWarnings("unchecked")
		List<Disease_wetjoint> diseaselist = (List<Disease_wetjoint>) disease_wetjointDAO.findEntityListByProperty("bg_id", bridgeCode, StringType.INSTANCE);
		if (diseaselist != null)
			return diseaselist.size();
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> getAllDisease_wetjointByBridgeCode(String bridgeCode) {
		List<Disease_wetjoint> diseaselist = (List<Disease_wetjoint>) disease_wetjointDAO.findEntityListByPropertySort("bg_id", "u.parts_id, u.item_name, u.rg_feature", bridgeCode, StringType.INSTANCE);
		
		List<Map<String, Object>> disinfo = new ArrayList<Map<String, Object>>();
		for (Disease_wetjoint dil:diseaselist) {
			Map<String, Object> obj = new HashMap<String, Object>();
			
			obj.put("id", dil.getId());
			obj.put("bg_id", dil.getBg_id());
			obj.put("parts_id", dil.getParts_id());
			obj.put("item_name", dil.getItem_name());
			obj.put("rg_feature", dil.getRg_feature());
			obj.put("rg_fissure", dil.getRg_fissure());
			obj.put("sp_otherDisease", dil.getSp_otherDisease());			
			obj.put("l1_start", dil.getL1_start());
			obj.put("l1_end", dil.getL1_end());
			obj.put("l1_area", dil.getL1_area());
			obj.put("l2_start", dil.getL2_start());
			obj.put("l2_length", dil.getL2_length());
			obj.put("l2_width", dil.getL2_width());
			obj.put("add_content", dil.getAdd_content());
			obj.put("disease_image", dil.getDisease_image());
			obj.put("image_type", dil.getImage_type());
			obj.put("evaluation", dil.getEvaluation());
			disinfo.add(obj);
		}
		return disinfo;
	}
}
