package com.qjs.biz.impl;

import global.tool.QueryItems;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.StringType;

import com.qjs.biz.Disease_paBiz;
import com.qjs.dao.Disease_paDAO;
import com.qjs.entity.Disease_pa;

public class Disease_paBizImpl implements Disease_paBiz {
	
	private Disease_paDAO disease_paDAO;	
	
	public Disease_paDAO getDisease_paDAO() {
		return disease_paDAO;
	}

	public void setDisease_paDAO(Disease_paDAO disease_paDAO) {
		this.disease_paDAO = disease_paDAO;
	}

	@Override
	public Object addDisease_pa(Disease_pa disease_pa) {
		@SuppressWarnings("unchecked")
		List<Disease_pa> diseaselist = (List<Disease_pa>) disease_paDAO.findEntityListByProperty("id", disease_pa.getId(), StandardBasicTypes.INTEGER);
		if (diseaselist.size() != 0) {
			return false;
		}
		disease_paDAO.addEntity(disease_pa);
		return true;
	}

	@Override
	public List<?> getAllDisease_pa() {
		return disease_paDAO.getAll();
	}

	@Override
	public boolean updateDisease_pa(Disease_pa disease_pa) {
		disease_paDAO.updateEntity(disease_pa);
		return true;
	}

	@Override
	public boolean deleteDisease_paById(int id) {
		@SuppressWarnings("unchecked")
		List<Disease_pa> diseaseList = (List<Disease_pa>) disease_paDAO.findEntityListByProperty("id", id, StandardBasicTypes.INTEGER);
		if(diseaseList.size() != 0) {
			return false;
		}	
		
		int count = disease_paDAO.deleteEntityByProperty("id", id, StandardBasicTypes.INTEGER);
		if (count != 1)
			return false;
		return true;
	}

	@Override
	public Map<?,?> getAllDetailDisease_pa(QueryItems qi) {
		Map<?,?> res =new HashMap<String, Object>();
		res = disease_paDAO.findEntityListByProperties(qi);
		@SuppressWarnings("unchecked")
		List<Disease_pa> diseaselist = (List<Disease_pa>) res.get("result");
		List<Map<String, Object>> disinfo = new ArrayList<Map<String, Object>>();
		for(Disease_pa dil:diseaselist){
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
	public Disease_pa getDisease_paById(int id) {
		@SuppressWarnings("unchecked")
		List<Disease_pa> diseaselist = (List<Disease_pa>) disease_paDAO.findEntityListByProperty("id", id, StandardBasicTypes.INTEGER);
		if (diseaselist != null && diseaselist.size() == 1) {
			return diseaselist.get(0);
		}
		return null;
	}
	
	@Override
	public Disease_pa getDisease_paByBridgeCode(String bridgeCode) {
		@SuppressWarnings("unchecked")
		List<Disease_pa> diseaselist = (List<Disease_pa>) disease_paDAO.findEntityListByProperty("bg_id", bridgeCode, StringType.INSTANCE);
		if (diseaselist != null && diseaselist.size() == 1) {
			return diseaselist.get(0);
		}
		return null;
	}

	@Override
	public int getDisease_paCodeByBridgeCode(String bridgeCode) {
		@SuppressWarnings("unchecked")
		List<Disease_pa> diseaselist = (List<Disease_pa>) disease_paDAO.findEntityListByProperty("bg_id", bridgeCode, StringType.INSTANCE);
		if (diseaselist != null)
			return diseaselist.size();
		return 0;
	}
}
