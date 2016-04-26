package com.qjs.biz.impl;

import global.tool.QueryItems;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.StringType;

import com.qjs.biz.General_detailBiz;
import com.qjs.dao.General_detailDAO;
import com.qjs.entity.General_detail;

public class General_detailBizImpl implements General_detailBiz {
	
	private General_detailDAO general_detailDAO;	
	
	public General_detailDAO getGeneral_detailDAO() {
		return general_detailDAO;
	}

	public void setGeneral_detailDAO(General_detailDAO general_detailDAO) {
		this.general_detailDAO = general_detailDAO;
	}

	@Override
	public Object addGeneral_detail(General_detail general_detail) {
		@SuppressWarnings("unchecked")
		List<General_detail> bridgeList = (List<General_detail>) general_detailDAO.findEntityListByProperty("id", general_detail.getId(), StandardBasicTypes.INTEGER);
		if (bridgeList.size() != 0) {
			return false;
		}
		general_detailDAO.addEntity(general_detail);
		return true;
	}

	@Override
	public List<?> getAllGeneral_detail() {
		return general_detailDAO.getAll();
	}

	@Override
	public boolean updateGeneral_detail(General_detail general_detail) {
		general_detailDAO.updateEntity(general_detail);
		return true;
	}

	@Override
	public boolean deleteGeneral_detailById(int id) {
		@SuppressWarnings("unchecked")
		List<General_detail> BridgeList = (List<General_detail>) general_detailDAO.findEntityListByProperty("id", id, StandardBasicTypes.INTEGER);
		if(BridgeList.size() != 0) {
			return false;
		}	
		
		int count = general_detailDAO.deleteEntityByProperty("id", id, StandardBasicTypes.INTEGER);
		if (count != 1)
			return false;
		return true;
	}

	@Override
	public Map<?,?> getAllDetailGeneral_detail(QueryItems qi) {
		Map<?,?> res =new HashMap<String, Object>();
		res = general_detailDAO.findEntityListByProperties(qi);
		@SuppressWarnings("unchecked")
		List<General_detail> Bridgelist = (List<General_detail>) res.get("result");
		List<Map<String, Object>> bginfo = new ArrayList<Map<String, Object>>();
		for(General_detail bil:Bridgelist){
			Map<String, Object> obj = new HashMap<String,Object>();
			
			obj.put("bg_id", bil.getBg_id());
			obj.put("General_details", bil.getGeneral_details());
			obj.put("general_nums", bil.getGeneral_nums());
			bginfo.add(obj);
		}
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("count", res.get("count"));
		result.put("result", bginfo);
		return result;
	}

	@Override
	public General_detail getGeneral_detailById(int id) {
		@SuppressWarnings("unchecked")
		List<General_detail> Bridgelist = (List<General_detail>) general_detailDAO.findEntityListByProperty("id", id, StandardBasicTypes.INTEGER);
		if (Bridgelist != null && Bridgelist.size() == 1) {
			return Bridgelist.get(0);
		}
		return null;
	}
	
	@Override
	public General_detail getGeneral_detailByBridgeCode(String bridgeCode) {
		@SuppressWarnings("unchecked")
		List<General_detail> Bridgelist = (List<General_detail>) general_detailDAO.findEntityListByProperty("bg_id", bridgeCode, StringType.INSTANCE);
		if (Bridgelist != null && Bridgelist.size() == 1) {
			return Bridgelist.get(0);
		}
		return null;
	}
}
