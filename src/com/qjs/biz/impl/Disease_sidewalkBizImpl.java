package com.qjs.biz.impl;

import global.tool.QueryItems;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.StringType;

import com.qjs.biz.Disease_sidewalkBiz;
import com.qjs.dao.Disease_sidewalkDAO;
import com.qjs.entity.Disease_sidewalk;

public class Disease_sidewalkBizImpl implements Disease_sidewalkBiz {
	
	private Disease_sidewalkDAO disease_sidewalkDAO;	
	
	public Disease_sidewalkDAO getDisease_sidewalkDAO() {
		return disease_sidewalkDAO;
	}

	public void setDisease_sidewalkDAO(Disease_sidewalkDAO disease_sidewalkDAO) {
		this.disease_sidewalkDAO = disease_sidewalkDAO;
	}

	@Override
	public Object addDisease_sidewalk(Disease_sidewalk disease_sidewalk) {
		@SuppressWarnings("unchecked")
		List<Disease_sidewalk> diseaselist = (List<Disease_sidewalk>) disease_sidewalkDAO.findEntityListByProperty("id", disease_sidewalk.getId(), StandardBasicTypes.INTEGER);
		if (diseaselist.size() != 0) {
			return false;
		}
		disease_sidewalkDAO.addEntity(disease_sidewalk);
		return true;
	}

	@Override
	public List<?> getAllDisease_sidewalk() {
		return disease_sidewalkDAO.getAll();
	}

	@Override
	public boolean updateDisease_sidewalk(Disease_sidewalk disease_sidewalk) {
		disease_sidewalkDAO.updateEntity(disease_sidewalk);
		return true;
	}

	@Override
	public boolean deleteDisease_sidewalkById(int id) {
		@SuppressWarnings("unchecked")
		List<Disease_sidewalk> diseaseList = (List<Disease_sidewalk>) disease_sidewalkDAO.findEntityListByProperty("id", id, StandardBasicTypes.INTEGER);
		if(diseaseList.size() != 0) {
			return false;
		}	
		
		int count = disease_sidewalkDAO.deleteEntityByProperty("id", id, StandardBasicTypes.INTEGER);
		if (count != 1)
			return false;
		return true;
	}

	@Override
	public Map<?,?> getAllDetailDisease_sidewalk(QueryItems qi) {
		Map<?,?> res =new HashMap<String, Object>();
		res = disease_sidewalkDAO.findEntityListByProperties(qi);
		@SuppressWarnings("unchecked")
		List<Disease_sidewalk> diseaselist = (List<Disease_sidewalk>) res.get("result");
		List<Map<String, Object>> disinfo = new ArrayList<Map<String, Object>>();
		for(Disease_sidewalk dil:diseaselist){
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
	public Disease_sidewalk getDisease_sidewalkById(int id) {
		@SuppressWarnings("unchecked")
		List<Disease_sidewalk> diseaselist = (List<Disease_sidewalk>) disease_sidewalkDAO.findEntityListByProperty("id", id, StandardBasicTypes.INTEGER);
		if (diseaselist != null && diseaselist.size() == 1) {
			return diseaselist.get(0);
		}
		return null;
	}
	
	@Override
	public Disease_sidewalk getDisease_sidewalkByBridgeCode(String bridgeCode) {
		@SuppressWarnings("unchecked")
		List<Disease_sidewalk> diseaselist = (List<Disease_sidewalk>) disease_sidewalkDAO.findEntityListByProperty("bg_id", bridgeCode, StringType.INSTANCE);
		if (diseaselist != null && diseaselist.size() == 1) {
			return diseaselist.get(0);
		}
		return null;
	}

	@Override
	public int getDisease_sidewalkCodeByBridgeCode(String bridgeCode) {
		@SuppressWarnings("unchecked")
		List<Disease_sidewalk> diseaselist = (List<Disease_sidewalk>) disease_sidewalkDAO.findEntityListByProperty("bg_id", bridgeCode, StringType.INSTANCE);
		if (diseaselist != null)
			return diseaselist.size();
		return 0;
	}
}
