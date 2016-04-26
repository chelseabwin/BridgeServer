package com.qjs.biz.impl;

import global.tool.QueryItems;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.StringType;

import com.qjs.biz.Support_detailBiz;
import com.qjs.dao.Support_detailDAO;
import com.qjs.entity.Support_detail;

public class Support_detailBizImpl implements Support_detailBiz {
	
	private Support_detailDAO support_detailDAO;	
	
	public Support_detailDAO getSupport_detailDAO() {
		return support_detailDAO;
	}

	public void setSupport_detailDAO(Support_detailDAO support_detailDAO) {
		this.support_detailDAO = support_detailDAO;
	}

	@Override
	public Object addSupport_detail(Support_detail support_detail) {
		@SuppressWarnings("unchecked")
		List<Support_detail> bridgeList = (List<Support_detail>) support_detailDAO.findEntityListByProperty("id", support_detail.getId(), StandardBasicTypes.INTEGER);
		if (bridgeList.size() != 0) {
			return false;
		}
		support_detailDAO.addEntity(support_detail);
		return true;
	}

	@Override
	public List<?> getAllSupport_detail() {
		return support_detailDAO.getAll();
	}

	@Override
	public boolean updateSupport_detail(Support_detail support_detail) {
		support_detailDAO.updateEntity(support_detail);
		return true;
	}

	@Override
	public boolean deleteSupport_detailById(int id) {
		@SuppressWarnings("unchecked")
		List<Support_detail> BridgeList = (List<Support_detail>) support_detailDAO.findEntityListByProperty("id", id, StandardBasicTypes.INTEGER);
		if(BridgeList.size() != 0) {
			return false;
		}	
		
		int count = support_detailDAO.deleteEntityByProperty("id", id, StandardBasicTypes.INTEGER);
		if (count != 1)
			return false;
		return true;
	}

	@Override
	public Map<?,?> getAllDetailSupport_detail(QueryItems qi) {
		Map<?,?> res =new HashMap<String, Object>();
		res = support_detailDAO.findEntityListByProperties(qi);
		@SuppressWarnings("unchecked")
		List<Support_detail> Bridgelist = (List<Support_detail>) res.get("result");
		List<Map<String, Object>> bginfo = new ArrayList<Map<String, Object>>();
		for(Support_detail bil:Bridgelist){
			Map<String, Object> obj = new HashMap<String,Object>();
			
			obj.put("bg_id", bil.getBg_id());
			obj.put("Support_details", bil.getSupport_details());
			obj.put("support_nums", bil.getSupport_nums());
			bginfo.add(obj);
		}
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("count", res.get("count"));
		result.put("result", bginfo);
		return result;
	}

	@Override
	public Support_detail getSupport_detailById(int id) {
		@SuppressWarnings("unchecked")
		List<Support_detail> Bridgelist = (List<Support_detail>) support_detailDAO.findEntityListByProperty("id", id, StandardBasicTypes.INTEGER);
		if (Bridgelist != null && Bridgelist.size() == 1) {
			return Bridgelist.get(0);
		}
		return null;
	}
	
	@Override
	public Support_detail getSupport_detailByBridgeCode(String bridgeCode) {
		@SuppressWarnings("unchecked")
		List<Support_detail> Bridgelist = (List<Support_detail>) support_detailDAO.findEntityListByProperty("bg_id", bridgeCode, StringType.INSTANCE);
		if (Bridgelist != null && Bridgelist.size() == 1) {
			return Bridgelist.get(0);
		}
		return null;
	}
}
