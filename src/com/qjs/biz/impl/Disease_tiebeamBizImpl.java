package com.qjs.biz.impl;

import global.tool.OtherFunction;
import global.tool.QueryItems;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.StringType;

import com.qjs.biz.Disease_tiebeamBiz;
import com.qjs.dao.Disease_tiebeamDAO;
import com.qjs.entity.Disease_tiebeam;

public class Disease_tiebeamBizImpl implements Disease_tiebeamBiz {
	
	private Disease_tiebeamDAO disease_tiebeamDAO;	
	
	public Disease_tiebeamDAO getDisease_tiebeamDAO() {
		return disease_tiebeamDAO;
	}

	public void setDisease_tiebeamDAO(Disease_tiebeamDAO disease_tiebeamDAO) {
		this.disease_tiebeamDAO = disease_tiebeamDAO;
	}

	@Override
	public Object addDisease_tiebeam(Disease_tiebeam disease_tiebeam) {
		@SuppressWarnings("unchecked")
		List<Disease_tiebeam> diseaselist = (List<Disease_tiebeam>) disease_tiebeamDAO.findEntityListByProperty("id", disease_tiebeam.getId(), StandardBasicTypes.INTEGER);
		if (diseaselist.size() != 0) {
			return false;
		}
		disease_tiebeamDAO.addEntity(disease_tiebeam);
		return true;
	}

	@Override
	public List<?> getAllDisease_tiebeam() {
		return disease_tiebeamDAO.getAll();
	}

	@Override
	public boolean updateDisease_tiebeam(Disease_tiebeam disease_tiebeam) {
		disease_tiebeamDAO.updateEntity(disease_tiebeam);
		return true;
	}

	@Override
	public boolean deleteDisease_tiebeamById(int id) {
		@SuppressWarnings("unchecked")
		List<Disease_tiebeam> diseaseList = (List<Disease_tiebeam>) disease_tiebeamDAO.findEntityListByProperty("id", id, StandardBasicTypes.INTEGER);
		if(diseaseList.size() != 0) {
			return false;
		}	
		
		int count = disease_tiebeamDAO.deleteEntityByProperty("id", id, StandardBasicTypes.INTEGER);
		if (count != 1)
			return false;
		return true;
	}

	@Override
	public Map<?,?> getAllDetailDisease_tiebeam(QueryItems qi) {
		Map<?,?> res =new HashMap<String, Object>();
		res = disease_tiebeamDAO.findEntityListByProperties(qi);
		@SuppressWarnings("unchecked")
		List<Disease_tiebeam> diseaselist = (List<Disease_tiebeam>) res.get("result");
		List<Map<String, Object>> disinfo = new ArrayList<Map<String, Object>>();
		for(Disease_tiebeam dil:diseaselist){
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
	public Disease_tiebeam getDisease_tiebeamById(int id) {
		@SuppressWarnings("unchecked")
		List<Disease_tiebeam> diseaselist = (List<Disease_tiebeam>) disease_tiebeamDAO.findEntityListByProperty("id", id, StandardBasicTypes.INTEGER);
		if (diseaselist != null && diseaselist.size() == 1) {
			return diseaselist.get(0);
		}
		return null;
	}
	
	@Override
	public Disease_tiebeam getDisease_tiebeamByBridgeCode(String bridgeCode) {
		@SuppressWarnings("unchecked")
		List<Disease_tiebeam> diseaselist = (List<Disease_tiebeam>) disease_tiebeamDAO.findEntityListByProperty("bg_id", bridgeCode, StringType.INSTANCE);
		if (diseaselist != null && diseaselist.size() == 1) {
			return diseaselist.get(0);
		}
		return null;
	}

	@Override
	public int getDisease_tiebeamCodeByBridgeCode(String bridgeCode) {
		@SuppressWarnings("unchecked")
		List<Disease_tiebeam> diseaselist = (List<Disease_tiebeam>) disease_tiebeamDAO.findEntityListByProperty("bg_id", bridgeCode, StringType.INSTANCE);
		if (diseaselist != null)
			return diseaselist.size();
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> getAllDisease_tiebeamByBridgeCode(String bridgeCode) {
		List<Disease_tiebeam> diseaselist = (List<Disease_tiebeam>) disease_tiebeamDAO.findEntityListByPropertySort("bg_id", "u.parts_id, u.item_name, u.rg_feature", bridgeCode, StringType.INSTANCE);
		
		List<Map<String, Object>> disinfo = new ArrayList<Map<String, Object>>();
		for (Disease_tiebeam dil:diseaselist) {
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
