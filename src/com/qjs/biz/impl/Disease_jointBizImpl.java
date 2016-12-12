package com.qjs.biz.impl;

import global.tool.OtherFunction;
import global.tool.QueryItems;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.StringType;

import com.qjs.biz.Disease_jointBiz;
import com.qjs.dao.Disease_jointDAO;
import com.qjs.entity.Disease_joint;

public class Disease_jointBizImpl implements Disease_jointBiz {
	
	private Disease_jointDAO disease_jointDAO;	
	
	public Disease_jointDAO getDisease_jointDAO() {
		return disease_jointDAO;
	}

	public void setDisease_jointDAO(Disease_jointDAO disease_jointDAO) {
		this.disease_jointDAO = disease_jointDAO;
	}

	@Override
	public Object addDisease_joint(Disease_joint disease_joint) {
		@SuppressWarnings("unchecked")
		List<Disease_joint> diseaselist = (List<Disease_joint>) disease_jointDAO.findEntityListByProperty("id", disease_joint.getId(), StandardBasicTypes.INTEGER);
		if (diseaselist.size() != 0) {
			return false;
		}
		disease_jointDAO.addEntity(disease_joint);
		return true;
	}

	@Override
	public List<?> getAllDisease_joint() {
		return disease_jointDAO.getAll();
	}

	@Override
	public boolean updateDisease_joint(Disease_joint disease_joint) {
		disease_jointDAO.updateEntity(disease_joint);
		return true;
	}

	@Override
	public boolean deleteDisease_jointById(int id) {
		@SuppressWarnings("unchecked")
		List<Disease_joint> diseaseList = (List<Disease_joint>) disease_jointDAO.findEntityListByProperty("id", id, StandardBasicTypes.INTEGER);
		if(diseaseList.size() != 0) {
			return false;
		}	
		
		int count = disease_jointDAO.deleteEntityByProperty("id", id, StandardBasicTypes.INTEGER);
		if (count != 1)
			return false;
		return true;
	}

	@Override
	public Map<?,?> getAllDetailDisease_joint(QueryItems qi) {
		Map<?,?> res =new HashMap<String, Object>();
		res = disease_jointDAO.findEntityListByProperties(qi);
		@SuppressWarnings("unchecked")
		List<Disease_joint> diseaselist = (List<Disease_joint>) res.get("result");
		List<Map<String, Object>> disinfo = new ArrayList<Map<String, Object>>();
		for(Disease_joint dil:diseaselist){
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
	public Disease_joint getDisease_jointById(int id) {
		@SuppressWarnings("unchecked")
		List<Disease_joint> diseaselist = (List<Disease_joint>) disease_jointDAO.findEntityListByProperty("id", id, StandardBasicTypes.INTEGER);
		if (diseaselist != null && diseaselist.size() == 1) {
			return diseaselist.get(0);
		}
		return null;
	}
	
	@Override
	public Disease_joint getDisease_jointByBridgeCode(String bridgeCode) {
		@SuppressWarnings("unchecked")
		List<Disease_joint> diseaselist = (List<Disease_joint>) disease_jointDAO.findEntityListByProperty("bg_id", bridgeCode, StringType.INSTANCE);
		if (diseaselist != null && diseaselist.size() == 1) {
			return diseaselist.get(0);
		}
		return null;
	}

	@Override
	public int getDisease_jointCodeByBridgeCode(String bridgeCode) {
		@SuppressWarnings("unchecked")
		List<Disease_joint> diseaselist = (List<Disease_joint>) disease_jointDAO.findEntityListByProperty("bg_id", bridgeCode, StringType.INSTANCE);
		if (diseaselist != null)
			return diseaselist.size();
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> getAllDisease_jointByBridgeCode(String bridgeCode) {
		List<Disease_joint> diseaselist = (List<Disease_joint>) disease_jointDAO.findEntityListByPropertySort("bg_id", "u.parts_id, u.item_name, u.rg_feature", bridgeCode, StringType.INSTANCE);
		
		List<Map<String, Object>> disinfo = new ArrayList<Map<String, Object>>();
		for (Disease_joint dil:diseaselist) {
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
			disinfo.add(obj);
		}
		return disinfo;
	}
}
