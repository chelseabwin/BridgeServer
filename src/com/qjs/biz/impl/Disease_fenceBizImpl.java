package com.qjs.biz.impl;

import global.tool.QueryItems;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.StringType;

import com.qjs.biz.Disease_fenceBiz;
import com.qjs.dao.Disease_fenceDAO;
import com.qjs.entity.Disease_fence;

public class Disease_fenceBizImpl implements Disease_fenceBiz {
	
	private Disease_fenceDAO disease_fenceDAO;	
	
	public Disease_fenceDAO getDisease_fenceDAO() {
		return disease_fenceDAO;
	}

	public void setDisease_fenceDAO(Disease_fenceDAO disease_fenceDAO) {
		this.disease_fenceDAO = disease_fenceDAO;
	}

	@Override
	public Object addDisease_fence(Disease_fence disease_fence) {
		@SuppressWarnings("unchecked")
		List<Disease_fence> diseaselist = (List<Disease_fence>) disease_fenceDAO.findEntityListByProperty("id", disease_fence.getId(), StandardBasicTypes.INTEGER);
		if (diseaselist.size() != 0) {
			return false;
		}
		disease_fenceDAO.addEntity(disease_fence);
		return true;
	}

	@Override
	public List<?> getAllDisease_fence() {
		return disease_fenceDAO.getAll();
	}

	@Override
	public boolean updateDisease_fence(Disease_fence disease_fence) {
		disease_fenceDAO.updateEntity(disease_fence);
		return true;
	}

	@Override
	public boolean deleteDisease_fenceById(int id) {
		@SuppressWarnings("unchecked")
		List<Disease_fence> diseaseList = (List<Disease_fence>) disease_fenceDAO.findEntityListByProperty("id", id, StandardBasicTypes.INTEGER);
		if(diseaseList.size() != 0) {
			return false;
		}	
		
		int count = disease_fenceDAO.deleteEntityByProperty("id", id, StandardBasicTypes.INTEGER);
		if (count != 1)
			return false;
		return true;
	}

	@Override
	public Map<?,?> getAllDetailDisease_fence(QueryItems qi) {
		Map<?,?> res =new HashMap<String, Object>();
		res = disease_fenceDAO.findEntityListByProperties(qi);
		@SuppressWarnings("unchecked")
		List<Disease_fence> diseaselist = (List<Disease_fence>) res.get("result");
		List<Map<String, Object>> disinfo = new ArrayList<Map<String, Object>>();
		for(Disease_fence dil:diseaselist){
			Map<String, Object> obj = new HashMap<String,Object>();
			
			obj.put("id", dil.getId());
			obj.put("bg_id", dil.getBg_id());
			obj.put("parts_id", dil.getParts_id());
			obj.put("item_name", dil.getItem_name());
			obj.put("rg_feature", dil.getRg_feature());
			obj.put("add_content", dil.getAdd_content());
			obj.put("disease_image", dil.getDisease_image());
			disinfo.add(obj);
		}
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("count", res.get("count"));
		result.put("result", disinfo);
		return result;
	}

	@Override
	public Disease_fence getDisease_fenceById(int id) {
		@SuppressWarnings("unchecked")
		List<Disease_fence> diseaselist = (List<Disease_fence>) disease_fenceDAO.findEntityListByProperty("id", id, StandardBasicTypes.INTEGER);
		if (diseaselist != null && diseaselist.size() == 1) {
			return diseaselist.get(0);
		}
		return null;
	}
	
	@Override
	public Disease_fence getDisease_fenceByBridgeCode(String bridgeCode) {
		@SuppressWarnings("unchecked")
		List<Disease_fence> diseaselist = (List<Disease_fence>) disease_fenceDAO.findEntityListByProperty("bg_id", bridgeCode, StringType.INSTANCE);
		if (diseaselist != null && diseaselist.size() == 1) {
			return diseaselist.get(0);
		}
		return null;
	}

	@Override
	public int getDisease_fenceCodeByBridgeCode(String bridgeCode) {
		@SuppressWarnings("unchecked")
		List<Disease_fence> diseaselist = (List<Disease_fence>) disease_fenceDAO.findEntityListByProperty("bg_id", bridgeCode, StringType.INSTANCE);
		if (diseaselist != null)
			return diseaselist.size();
		return 0;
	}
}
