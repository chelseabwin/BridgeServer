package com.qjs.biz.impl;

import global.tool.QueryItems;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.StringType;

import com.qjs.biz.Disease_girderBiz;
import com.qjs.dao.Disease_girderDAO;
import com.qjs.entity.Disease_girder;

public class Disease_girderBizImpl implements Disease_girderBiz {
	
	private Disease_girderDAO disease_girderDAO;
	
	public Disease_girderDAO getDisease_girderDAO() {
		return disease_girderDAO;
	}

	public void setDisease_girderDAO(Disease_girderDAO disease_girderDAO) {
		this.disease_girderDAO = disease_girderDAO;
	}

	@Override
	public Object addDisease_girder(Disease_girder disease_girder) {
		@SuppressWarnings("unchecked")
		List<Disease_girder> diseaselist = (List<Disease_girder>) disease_girderDAO.findEntityListByProperty("id", disease_girder.getId(), StandardBasicTypes.INTEGER);
		if (diseaselist.size() != 0) {
			return false;
		}
		disease_girderDAO.addEntity(disease_girder);
		return true;
	}

	@Override
	public List<?> getAllDisease_girder() {
		return disease_girderDAO.getAll();
	}

	@Override
	public boolean updateDisease_girder(Disease_girder disease_girder) {
		disease_girderDAO.updateEntity(disease_girder);
		return true;
	}

	@Override
	public boolean deleteDisease_girderById(int id) {
		@SuppressWarnings("unchecked")
		List<Disease_girder> diseaseList = (List<Disease_girder>) disease_girderDAO.findEntityListByProperty("id", id, StandardBasicTypes.INTEGER);
		if(diseaseList.size() != 0) {
			return false;
		}	
		
		int count = disease_girderDAO.deleteEntityByProperty("id", id, StandardBasicTypes.INTEGER);
		if (count != 1)
			return false;
		return true;
	}

	@Override
	public Map<?,?> getAllDetailDisease_girder(QueryItems qi) {
		Map<?,?> res =new HashMap<String, Object>();
		res = disease_girderDAO.findEntityListByProperties(qi);
		@SuppressWarnings("unchecked")
		List<Disease_girder> diseaselist = (List<Disease_girder>) res.get("result");
		List<Map<String, Object>> disinfo = new ArrayList<Map<String, Object>>();
		for(Disease_girder dil:diseaselist){
			Map<String, Object> obj = new HashMap<String,Object>();
			
			obj.put("id", dil.getId());
			obj.put("bg_id", dil.getBg_id());
			obj.put("parts_id", dil.getParts_id());
			obj.put("item_name", dil.getItem_name());
			obj.put("rg_feature", dil.getRg_feature());
			obj.put("rg_fissure", dil.getRg_fissure());
			obj.put("sp_otherDisease", dil.getSp_otherDisease());
			obj.put("start", dil.getStart());
			obj.put("end", dil.getEnd());
			obj.put("area", dil.getArea());
			obj.put("length", dil.getLength());
			obj.put("width", dil.getWidth());
			obj.put("side_start", dil.getSide_start());
			obj.put("side_end", dil.getSide_end());
			obj.put("side_length", dil.getSide_length());
			obj.put("side_width", dil.getSide_width());
			obj.put("rg_location", dil.getRg_location());
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
	public Disease_girder getDisease_girderById(int id) {
		@SuppressWarnings("unchecked")
		List<Disease_girder> diseaselist = (List<Disease_girder>) disease_girderDAO.findEntityListByProperty("id", id, StandardBasicTypes.INTEGER);
		if (diseaselist != null && diseaselist.size() == 1) {
			return diseaselist.get(0);
		}
		return null;
	}
	
	@Override
	public Disease_girder getDisease_girderByBridgeCode(String bridgeCode) {
		@SuppressWarnings("unchecked")
		List<Disease_girder> diseaselist = (List<Disease_girder>) disease_girderDAO.findEntityListByProperty("bg_id", bridgeCode, StringType.INSTANCE);
		if (diseaselist != null && diseaselist.size() == 1) {
			return diseaselist.get(0);
		}
		return null;
	}

	@Override
	public int getDisease_girderCodeByBridgeCode(String bridgeCode) {
		@SuppressWarnings("unchecked")
		List<Disease_girder> diseaselist = (List<Disease_girder>) disease_girderDAO.findEntityListByProperty("bg_id", bridgeCode, StringType.INSTANCE);
		if (diseaselist != null)
			return diseaselist.size();
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> getAllDisease_girderByBridgeCode(String bridgeCode) {
		List<Disease_girder> diseaselist = (List<Disease_girder>) disease_girderDAO.findEntityListByPropertySort("bg_id", "u.parts_id, u.item_name, u.rg_feature", bridgeCode, StringType.INSTANCE);
		
		List<Map<String, Object>> disinfo = new ArrayList<Map<String, Object>>();
		for (Disease_girder dil:diseaselist) {
			Map<String, Object> obj = new HashMap<String, Object>();
			
			obj.put("id", dil.getId());
			obj.put("bg_id", dil.getBg_id());
			obj.put("parts_id", dil.getParts_id());
			obj.put("item_name", dil.getItem_name());
			obj.put("rg_feature", dil.getRg_feature());
			obj.put("rg_fissure", dil.getRg_fissure());
			obj.put("sp_otherDisease", dil.getSp_otherDisease());
			obj.put("start", dil.getStart());
			obj.put("end", dil.getEnd());
			obj.put("area", dil.getArea());
			obj.put("length", dil.getLength());
			obj.put("width", dil.getWidth());
			obj.put("side_start", dil.getSide_start());
			obj.put("side_end", dil.getSide_end());
			obj.put("side_length", dil.getSide_length());
			obj.put("side_width", dil.getSide_width());
			obj.put("rg_location", dil.getRg_location());
			obj.put("add_content", dil.getAdd_content());
			obj.put("disease_image", dil.getDisease_image());
			obj.put("image_type", dil.getImage_type());
			obj.put("evaluation", dil.getEvaluation());
			disinfo.add(obj);
		}
		return disinfo;
	}
}
