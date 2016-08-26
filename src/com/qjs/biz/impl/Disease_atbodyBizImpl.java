package com.qjs.biz.impl;

import global.tool.QueryItems;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.StringType;

import com.qjs.biz.Disease_atbodyBiz;
import com.qjs.dao.Disease_atbodyDAO;
import com.qjs.entity.Disease_atbody;

public class Disease_atbodyBizImpl implements Disease_atbodyBiz {
	
	private Disease_atbodyDAO disease_atbodyDAO;	
	
	public Disease_atbodyDAO getDisease_atbodyDAO() {
		return disease_atbodyDAO;
	}

	public void setDisease_atbodyDAO(Disease_atbodyDAO disease_atbodyDAO) {
		this.disease_atbodyDAO = disease_atbodyDAO;
	}

	@Override
	public Object addDisease_atbody(Disease_atbody disease_atbody) {
		@SuppressWarnings("unchecked")
		List<Disease_atbody> diseaselist = (List<Disease_atbody>) disease_atbodyDAO.findEntityListByProperty("id", disease_atbody.getId(), StandardBasicTypes.INTEGER);
		if (diseaselist.size() != 0) {
			return false;
		}
		disease_atbodyDAO.addEntity(disease_atbody);
		return true;
	}

	@Override
	public List<?> getAllDisease_atbody() {
		return disease_atbodyDAO.getAll();
	}

	@Override
	public boolean updateDisease_atbody(Disease_atbody disease_atbody) {
		disease_atbodyDAO.updateEntity(disease_atbody);
		return true;
	}

	@Override
	public boolean deleteDisease_atbodyById(int id) {
		@SuppressWarnings("unchecked")
		List<Disease_atbody> diseaseList = (List<Disease_atbody>) disease_atbodyDAO.findEntityListByProperty("id", id, StandardBasicTypes.INTEGER);
		if(diseaseList.size() != 0) {
			return false;
		}	
		
		int count = disease_atbodyDAO.deleteEntityByProperty("id", id, StandardBasicTypes.INTEGER);
		if (count != 1)
			return false;
		return true;
	}

	@Override
	public Map<?,?> getAllDetailDisease_atbody(QueryItems qi) {
		Map<?,?> res =new HashMap<String, Object>();
		res = disease_atbodyDAO.findEntityListByProperties(qi);
		@SuppressWarnings("unchecked")
		List<Disease_atbody> diseaselist = (List<Disease_atbody>) res.get("result");
		List<Map<String, Object>> disinfo = new ArrayList<Map<String, Object>>();
		for(Disease_atbody dil:diseaselist){
			Map<String, Object> obj = new HashMap<String,Object>();
			
			obj.put("id", dil.getId());
			obj.put("bg_id", dil.getBg_id());
			obj.put("parts_id", dil.getParts_id());
			obj.put("item_name", dil.getItem_name());
			obj.put("rg_feature", dil.getRg_feature());
			obj.put("sp_otherDisease", dil.getSp_otherDisease());
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
	public Disease_atbody getDisease_atbodyById(int id) {
		@SuppressWarnings("unchecked")
		List<Disease_atbody> diseaselist = (List<Disease_atbody>) disease_atbodyDAO.findEntityListByProperty("id", id, StandardBasicTypes.INTEGER);
		if (diseaselist != null && diseaselist.size() == 1) {
			return diseaselist.get(0);
		}
		return null;
	}
	
	@Override
	public Disease_atbody getDisease_atbodyByBridgeCode(String bridgeCode) {
		@SuppressWarnings("unchecked")
		List<Disease_atbody> diseaselist = (List<Disease_atbody>) disease_atbodyDAO.findEntityListByProperty("bg_id", bridgeCode, StringType.INSTANCE);
		if (diseaselist != null && diseaselist.size() == 1) {
			return diseaselist.get(0);
		}
		return null;
	}

	@Override
	public int getDisease_atbodyCodeByBridgeCode(String bridgeCode) {
		@SuppressWarnings("unchecked")
		List<Disease_atbody> diseaselist = (List<Disease_atbody>) disease_atbodyDAO.findEntityListByProperty("bg_id", bridgeCode, StringType.INSTANCE);
		if (diseaselist != null)
			return diseaselist.size();
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> getAllDisease_atbodyByBridgeCode(String bridgeCode) {
		List<Disease_atbody> diseaselist = (List<Disease_atbody>) disease_atbodyDAO.findEntityListByPropertySort("bg_id", "u.parts_id, u.item_name, u.rg_feature", bridgeCode, StringType.INSTANCE);
		
		List<Map<String, Object>> disinfo = new ArrayList<Map<String, Object>>();
		for (Disease_atbody dil:diseaselist) {
			Map<String, Object> obj = new HashMap<String, Object>();
			
			obj.put("id", dil.getId());
			obj.put("bg_id", dil.getBg_id());
			obj.put("parts_id", dil.getParts_id());
			obj.put("item_name", dil.getItem_name());
			obj.put("rg_feature", dil.getRg_feature());
			obj.put("sp_otherDisease", dil.getSp_otherDisease());
			obj.put("add_content", dil.getAdd_content());
			obj.put("disease_image", dil.getDisease_image());
			obj.put("image_type", dil.getImage_type());
			obj.put("evaluation", dil.getEvaluation());
			disinfo.add(obj);
		}
		return disinfo;
	}
}
