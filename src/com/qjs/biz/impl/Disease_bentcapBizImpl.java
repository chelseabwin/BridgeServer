package com.qjs.biz.impl;

import global.tool.OtherFunction;
import global.tool.QueryItems;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.StringType;

import com.qjs.biz.Disease_bentcapBiz;
import com.qjs.dao.Disease_bentcapDAO;
import com.qjs.entity.Disease_bentcap;

public class Disease_bentcapBizImpl implements Disease_bentcapBiz {
	
	private Disease_bentcapDAO disease_bentcapDAO;	
	
	public Disease_bentcapDAO getDisease_bentcapDAO() {
		return disease_bentcapDAO;
	}

	public void setDisease_bentcapDAO(Disease_bentcapDAO disease_bentcapDAO) {
		this.disease_bentcapDAO = disease_bentcapDAO;
	}

	@Override
	public Object addDisease_bentcap(Disease_bentcap disease_bentcap) {
		@SuppressWarnings("unchecked")
		List<Disease_bentcap> diseaselist = (List<Disease_bentcap>) disease_bentcapDAO.findEntityListByProperty("id", disease_bentcap.getId(), StandardBasicTypes.INTEGER);
		if (diseaselist.size() != 0) {
			return false;
		}
		disease_bentcapDAO.addEntity(disease_bentcap);
		return true;
	}

	@Override
	public List<?> getAllDisease_bentcap() {
		return disease_bentcapDAO.getAll();
	}

	@Override
	public boolean updateDisease_bentcap(Disease_bentcap disease_bentcap) {
		disease_bentcapDAO.updateEntity(disease_bentcap);
		return true;
	}

	@Override
	public boolean deleteDisease_bentcapById(int id) {
		@SuppressWarnings("unchecked")
		List<Disease_bentcap> diseaseList = (List<Disease_bentcap>) disease_bentcapDAO.findEntityListByProperty("id", id, StandardBasicTypes.INTEGER);
		if(diseaseList.size() != 0) {
			return false;
		}	
		
		int count = disease_bentcapDAO.deleteEntityByProperty("id", id, StandardBasicTypes.INTEGER);
		if (count != 1)
			return false;
		return true;
	}

	@Override
	public Map<?,?> getAllDetailDisease_bentcap(QueryItems qi) {
		Map<?,?> res =new HashMap<String, Object>();
		res = disease_bentcapDAO.findEntityListByProperties(qi);
		@SuppressWarnings("unchecked")
		List<Disease_bentcap> diseaselist = (List<Disease_bentcap>) res.get("result");
		List<Map<String, Object>> disinfo = new ArrayList<Map<String, Object>>();
		for(Disease_bentcap dil:diseaselist){
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
	public Disease_bentcap getDisease_bentcapById(int id) {
		@SuppressWarnings("unchecked")
		List<Disease_bentcap> diseaselist = (List<Disease_bentcap>) disease_bentcapDAO.findEntityListByProperty("id", id, StandardBasicTypes.INTEGER);
		if (diseaselist != null && diseaselist.size() == 1) {
			return diseaselist.get(0);
		}
		return null;
	}
	
	@Override
	public Disease_bentcap getDisease_bentcapByBridgeCode(String bridgeCode) {
		@SuppressWarnings("unchecked")
		List<Disease_bentcap> diseaselist = (List<Disease_bentcap>) disease_bentcapDAO.findEntityListByProperty("bg_id", bridgeCode, StringType.INSTANCE);
		if (diseaselist != null && diseaselist.size() == 1) {
			return diseaselist.get(0);
		}
		return null;
	}

	@Override
	public int getDisease_bentcapCodeByBridgeCode(String bridgeCode) {
		@SuppressWarnings("unchecked")
		List<Disease_bentcap> diseaselist = (List<Disease_bentcap>) disease_bentcapDAO.findEntityListByProperty("bg_id", bridgeCode, StringType.INSTANCE);
		if (diseaselist != null)
			return diseaselist.size();
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> getAllDisease_bentcapByBridgeCode(String bridgeCode) {
		List<Disease_bentcap> diseaselist = (List<Disease_bentcap>) disease_bentcapDAO.findEntityListByPropertySort("bg_id", "u.parts_id, u.item_name, u.rg_feature", bridgeCode, StringType.INSTANCE);
		
		List<Map<String, Object>> disinfo = new ArrayList<Map<String, Object>>();
		for (Disease_bentcap dil:diseaselist) {
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
