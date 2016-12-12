package com.qjs.biz.impl;

import global.tool.OtherFunction;
import global.tool.QueryItems;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.StringType;

import com.qjs.biz.Disease_pierBiz;
import com.qjs.dao.Disease_pierDAO;
import com.qjs.entity.Disease_pier;

public class Disease_pierBizImpl implements Disease_pierBiz {
	
	private Disease_pierDAO disease_pierDAO;	
	
	public Disease_pierDAO getDisease_pierDAO() {
		return disease_pierDAO;
	}

	public void setDisease_pierDAO(Disease_pierDAO disease_pierDAO) {
		this.disease_pierDAO = disease_pierDAO;
	}

	@Override
	public Object addDisease_pier(Disease_pier disease_pier) {
		@SuppressWarnings("unchecked")
		List<Disease_pier> diseaselist = (List<Disease_pier>) disease_pierDAO.findEntityListByProperty("id", disease_pier.getId(), StandardBasicTypes.INTEGER);
		if (diseaselist.size() != 0) {
			return false;
		}
		disease_pierDAO.addEntity(disease_pier);
		return true;
	}

	@Override
	public List<?> getAllDisease_pier() {
		return disease_pierDAO.getAll();
	}

	@Override
	public boolean updateDisease_pier(Disease_pier disease_pier) {
		disease_pierDAO.updateEntity(disease_pier);
		return true;
	}

	@Override
	public boolean deleteDisease_pierById(int id) {
		@SuppressWarnings("unchecked")
		List<Disease_pier> diseaseList = (List<Disease_pier>) disease_pierDAO.findEntityListByProperty("id", id, StandardBasicTypes.INTEGER);
		if(diseaseList.size() != 0) {
			return false;
		}	
		
		int count = disease_pierDAO.deleteEntityByProperty("id", id, StandardBasicTypes.INTEGER);
		if (count != 1)
			return false;
		return true;
	}

	@Override
	public Map<?,?> getAllDetailDisease_pier(QueryItems qi) {
		Map<?,?> res =new HashMap<String, Object>();
		res = disease_pierDAO.findEntityListByProperties(qi);
		@SuppressWarnings("unchecked")
		List<Disease_pier> diseaselist = (List<Disease_pier>) res.get("result");
		List<Map<String, Object>> disinfo = new ArrayList<Map<String, Object>>();
		for(Disease_pier dil:diseaselist){
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
			obj.put("score", dil.getScore());
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
	public Disease_pier getDisease_pierById(int id) {
		@SuppressWarnings("unchecked")
		List<Disease_pier> diseaselist = (List<Disease_pier>) disease_pierDAO.findEntityListByProperty("id", id, StandardBasicTypes.INTEGER);
		if (diseaselist != null && diseaselist.size() == 1) {
			return diseaselist.get(0);
		}
		return null;
	}
	
	@Override
	public Disease_pier getDisease_pierByBridgeCode(String bridgeCode) {
		@SuppressWarnings("unchecked")
		List<Disease_pier> diseaselist = (List<Disease_pier>) disease_pierDAO.findEntityListByProperty("bg_id", bridgeCode, StringType.INSTANCE);
		if (diseaselist != null && diseaselist.size() == 1) {
			return diseaselist.get(0);
		}
		return null;
	}

	@Override
	public int getDisease_pierCodeByBridgeCode(String bridgeCode) {
		@SuppressWarnings("unchecked")
		List<Disease_pier> diseaselist = (List<Disease_pier>) disease_pierDAO.findEntityListByProperty("bg_id", bridgeCode, StringType.INSTANCE);
		if (diseaselist != null)
			return diseaselist.size();
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> getAllDisease_pierByBridgeCode(String bridgeCode) {
		List<Disease_pier> diseaselist = (List<Disease_pier>) disease_pierDAO.findEntityListByPropertySort("bg_id", "u.parts_id, u.item_name, u.rg_feature", bridgeCode, StringType.INSTANCE);
		
		List<Map<String, Object>> disinfo = new ArrayList<Map<String, Object>>();
		for (Disease_pier dil:diseaselist) {
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
			obj.put("score", dil.getScore());
			disinfo.add(obj);
		}
		return disinfo;
	}
}
