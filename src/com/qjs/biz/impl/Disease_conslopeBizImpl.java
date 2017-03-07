package com.qjs.biz.impl;

import global.tool.OtherFunction;
import global.tool.QueryItems;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.StringType;

import com.qjs.biz.Disease_conslopeBiz;
import com.qjs.dao.Disease_conslopeDAO;
import com.qjs.entity.Disease_conslope;

public class Disease_conslopeBizImpl implements Disease_conslopeBiz {
	
	private Disease_conslopeDAO disease_conslopeDAO;	
	
	public Disease_conslopeDAO getDisease_conslopeDAO() {
		return disease_conslopeDAO;
	}

	public void setDisease_conslopeDAO(Disease_conslopeDAO disease_conslopeDAO) {
		this.disease_conslopeDAO = disease_conslopeDAO;
	}

	@Override
	public Object addDisease_conslope(Disease_conslope disease_conslope) {
		@SuppressWarnings("unchecked")
		List<Disease_conslope> diseaselist = (List<Disease_conslope>) disease_conslopeDAO.findEntityListByProperty("id", disease_conslope.getId(), StandardBasicTypes.INTEGER);
		if (diseaselist.size() != 0) {
			return false;
		}
		disease_conslopeDAO.addEntity(disease_conslope);
		return true;
	}

	@Override
	public List<?> getAllDisease_conslope() {
		return disease_conslopeDAO.getAll();
	}

	@Override
	public boolean updateDisease_conslope(Disease_conslope disease_conslope) {
		disease_conslopeDAO.updateEntity(disease_conslope);
		return true;
	}

	@Override
	public boolean deleteDisease_conslopeById(int id) {
		@SuppressWarnings("unchecked")
		List<Disease_conslope> diseaseList = (List<Disease_conslope>) disease_conslopeDAO.findEntityListByProperty("id", id, StandardBasicTypes.INTEGER);
		if(diseaseList.size() != 0) {
			return false;
		}	
		
		int count = disease_conslopeDAO.deleteEntityByProperty("id", id, StandardBasicTypes.INTEGER);
		if (count != 1)
			return false;
		return true;
	}

	@Override
	public Map<?,?> getAllDetailDisease_conslope(QueryItems qi) {
		Map<?,?> res =new HashMap<String, Object>();
		res = disease_conslopeDAO.findEntityListByProperties(qi);
		@SuppressWarnings("unchecked")
		List<Disease_conslope> diseaselist = (List<Disease_conslope>) res.get("result");
		List<Map<String, Object>> disinfo = new ArrayList<Map<String, Object>>();
		for(Disease_conslope dil:diseaselist){
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
	public Disease_conslope getDisease_conslopeById(int id) {
		@SuppressWarnings("unchecked")
		List<Disease_conslope> diseaselist = (List<Disease_conslope>) disease_conslopeDAO.findEntityListByProperty("id", id, StandardBasicTypes.INTEGER);
		if (diseaselist != null && diseaselist.size() == 1) {
			return diseaselist.get(0);
		}
		return null;
	}
	
	@Override
	public Disease_conslope getDisease_conslopeByBridgeCode(String bridgeCode) {
		@SuppressWarnings("unchecked")
		List<Disease_conslope> diseaselist = (List<Disease_conslope>) disease_conslopeDAO.findEntityListByProperty("bg_id", bridgeCode, StringType.INSTANCE);
		if (diseaselist != null && diseaselist.size() == 1) {
			return diseaselist.get(0);
		}
		return null;
	}

	@Override
	public int getDisease_conslopeCodeByBridgeCode(String bridgeCode) {
		@SuppressWarnings("unchecked")
		List<Disease_conslope> diseaselist = (List<Disease_conslope>) disease_conslopeDAO.findEntityListByProperty("bg_id", bridgeCode, StringType.INSTANCE);
		if (diseaselist != null)
			return diseaselist.size();
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> getAllDisease_conslopeByBridgeCode(String bridgeCode) {
		List<Disease_conslope> diseaselist = (List<Disease_conslope>) disease_conslopeDAO.findEntityListByPropertySort("bg_id", "u.parts_id, u.item_name, u.rg_feature", bridgeCode, StringType.INSTANCE);
		
		List<Map<String, Object>> disinfo = new ArrayList<Map<String, Object>>();
		for (Disease_conslope dil:diseaselist) {
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
