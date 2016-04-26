package com.qjs.biz.impl;

import global.tool.QueryItems;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.StringType;

import com.qjs.biz.Load_detailBiz;
import com.qjs.dao.Load_detailDAO;
import com.qjs.entity.Load_detail;

public class Load_detailBizImpl implements Load_detailBiz {
	
	private Load_detailDAO load_detailDAO;	
	
	public Load_detailDAO getLoad_detailDAO() {
		return load_detailDAO;
	}

	public void setLoad_detailDAO(Load_detailDAO load_detailDAO) {
		this.load_detailDAO = load_detailDAO;
	}

	@Override
	public Object addLoad_detail(Load_detail load_detail) {
		@SuppressWarnings("unchecked")
		List<Load_detail> bridgeList = (List<Load_detail>) load_detailDAO.findEntityListByProperty("id", load_detail.getId(), StandardBasicTypes.INTEGER);
		if (bridgeList.size() != 0) {
			return false;
		}
		load_detailDAO.addEntity(load_detail);
		return true;
	}

	@Override
	public List<?> getAllLoad_detail() {
		return load_detailDAO.getAll();
	}

	@Override
	public boolean updateLoad_detail(Load_detail load_detail) {
		load_detailDAO.updateEntity(load_detail);
		return true;
	}

	@Override
	public boolean deleteLoad_detailById(int id) {
		@SuppressWarnings("unchecked")
		List<Load_detail> BridgeList = (List<Load_detail>) load_detailDAO.findEntityListByProperty("id", id, StandardBasicTypes.INTEGER);
		if(BridgeList.size() != 0) {
			return false;
		}	
		
		int count = load_detailDAO.deleteEntityByProperty("id", id, StandardBasicTypes.INTEGER);
		if (count != 1)
			return false;
		return true;
	}

	@Override
	public Map<?,?> getAllDetailLoad_detail(QueryItems qi) {
		Map<?,?> res =new HashMap<String, Object>();
		res = load_detailDAO.findEntityListByProperties(qi);
		@SuppressWarnings("unchecked")
		List<Load_detail> Bridgelist = (List<Load_detail>) res.get("result");
		List<Map<String, Object>> bginfo = new ArrayList<Map<String, Object>>();
		for(Load_detail bil:Bridgelist){
			Map<String, Object> obj = new HashMap<String,Object>();
			
			obj.put("bg_id", bil.getBg_id());
			obj.put("Load_details", bil.getLoad_details());
			obj.put("load_nums", bil.getLoad_nums());
			bginfo.add(obj);
		}
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("count", res.get("count"));
		result.put("result", bginfo);
		return result;
	}

	@Override
	public Load_detail getLoad_detailById(int id) {
		@SuppressWarnings("unchecked")
		List<Load_detail> Bridgelist = (List<Load_detail>) load_detailDAO.findEntityListByProperty("id", id, StandardBasicTypes.INTEGER);
		if (Bridgelist != null && Bridgelist.size() == 1) {
			return Bridgelist.get(0);
		}
		return null;
	}
	
	@Override
	public Load_detail getLoad_detailByBridgeCode(String bridgeCode) {
		@SuppressWarnings("unchecked")
		List<Load_detail> Bridgelist = (List<Load_detail>) load_detailDAO.findEntityListByProperty("bg_id", bridgeCode, StringType.INSTANCE);
		if (Bridgelist != null && Bridgelist.size() == 1) {
			return Bridgelist.get(0);
		}
		return null;
	}
}
