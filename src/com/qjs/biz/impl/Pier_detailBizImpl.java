package com.qjs.biz.impl;

import global.tool.QueryItems;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.StringType;

import com.qjs.biz.Pier_detailBiz;
import com.qjs.dao.Pier_detailDAO;
import com.qjs.entity.Pier_detail;

public class Pier_detailBizImpl implements Pier_detailBiz {
	
	private Pier_detailDAO pier_detailDAO;	
	
	public Pier_detailDAO getPier_detailDAO() {
		return pier_detailDAO;
	}

	public void setPier_detailDAO(Pier_detailDAO pier_detailDAO) {
		this.pier_detailDAO = pier_detailDAO;
	}

	@Override
	public Object addPier_detail(Pier_detail pier_detail) {
		@SuppressWarnings("unchecked")
		List<Pier_detail> bridgeList = (List<Pier_detail>) pier_detailDAO.findEntityListByProperty("id", pier_detail.getId(), StandardBasicTypes.INTEGER);
		if (bridgeList.size() != 0) {
			return false;
		}
		pier_detailDAO.addEntity(pier_detail);
		return true;
	}

	@Override
	public List<?> getAllPier_detail() {
		return pier_detailDAO.getAll();
	}

	@Override
	public boolean updatePier_detail(Pier_detail pier_detail) {
		pier_detailDAO.updateEntity(pier_detail);
		return true;
	}

	@Override
	public boolean deletePier_detailById(int id) {
		@SuppressWarnings("unchecked")
		List<Pier_detail> BridgeList = (List<Pier_detail>) pier_detailDAO.findEntityListByProperty("id", id, StandardBasicTypes.INTEGER);
		if(BridgeList.size() != 0) {
			return false;
		}	
		
		int count = pier_detailDAO.deleteEntityByProperty("id", id, StandardBasicTypes.INTEGER);
		if (count != 1)
			return false;
		return true;
	}

	@Override
	public Map<?,?> getAllDetailPier_detail(QueryItems qi) {
		Map<?,?> res =new HashMap<String, Object>();
		res = pier_detailDAO.findEntityListByProperties(qi);
		@SuppressWarnings("unchecked")
		List<Pier_detail> Bridgelist = (List<Pier_detail>) res.get("result");
		List<Map<String, Object>> bginfo = new ArrayList<Map<String, Object>>();
		for(Pier_detail bil:Bridgelist){
			Map<String, Object> obj = new HashMap<String,Object>();
			
			obj.put("bg_id", bil.getBg_id());
			obj.put("pier_details", bil.getPier_details());
			obj.put("pier_nums", bil.getPier_nums());
			obj.put("bent_cap_nums", bil.getBent_cap_nums());
			obj.put("tie_beam_nums", bil.getTie_beam_nums());
			bginfo.add(obj);
		}
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("count", res.get("count"));
		result.put("result", bginfo);
		return result;
	}

	@Override
	public Pier_detail getPier_detailById(int id) {
		@SuppressWarnings("unchecked")
		List<Pier_detail> Bridgelist = (List<Pier_detail>) pier_detailDAO.findEntityListByProperty("id", id, StandardBasicTypes.INTEGER);
		if (Bridgelist != null && Bridgelist.size() == 1) {
			return Bridgelist.get(0);
		}
		return null;
	}
	
	@Override
	public Pier_detail getPier_detailByBridgeCode(String bridgeCode) {
		@SuppressWarnings("unchecked")
		List<Pier_detail> Bridgelist = (List<Pier_detail>) pier_detailDAO.findEntityListByProperty("bg_id", bridgeCode, StringType.INSTANCE);
		if (Bridgelist != null && Bridgelist.size() == 1) {
			return Bridgelist.get(0);
		}
		return null;
	}
}
