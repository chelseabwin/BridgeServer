package com.qjs.biz.impl;

import global.tool.QueryItems;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.StringType;

import com.qjs.biz.Pier_addBiz;
import com.qjs.dao.Pier_addDAO;
import com.qjs.entity.Pier_add;

public class Pier_addBizImpl implements Pier_addBiz {
	
	private Pier_addDAO pier_addDAO;	
	
	public Pier_addDAO getPier_addDAO() {
		return pier_addDAO;
	}

	public void setPier_addDAO(Pier_addDAO pier_addDAO) {
		this.pier_addDAO = pier_addDAO;
	}

	@Override
	public Object addPier_add(Pier_add pier_add) {
		@SuppressWarnings("unchecked")
		List<Pier_add> bridgeList = (List<Pier_add>) pier_addDAO.findEntityListByProperty("id", pier_add.getId(), StandardBasicTypes.INTEGER);
		if (bridgeList.size() != 0) {
			return false;
		}
		pier_addDAO.addEntity(pier_add);
		return true;
	}

	@Override
	public List<?> getAllPier_add() {
		return pier_addDAO.getAll();
	}

	@Override
	public boolean updatePier_add(Pier_add pier_add) {
		pier_addDAO.updateEntity(pier_add);
		return true;
	}

	@Override
	public boolean deletePier_addById(int id) {
		@SuppressWarnings("unchecked")
		List<Pier_add> BridgeList = (List<Pier_add>) pier_addDAO.findEntityListByProperty("id", id, StandardBasicTypes.INTEGER);
		if(BridgeList.size() != 0) {
			return false;
		}	
		
		int count = pier_addDAO.deleteEntityByProperty("id", id, StandardBasicTypes.INTEGER);
		if (count != 1)
			return false;
		return true;
	}

	@Override
	public Map<?,?> getAllDetailPier_add(QueryItems qi) {
		Map<?,?> res =new HashMap<String, Object>();
		res = pier_addDAO.findEntityListByProperties(qi);
		@SuppressWarnings("unchecked")
		List<Pier_add> Bridgelist = (List<Pier_add>) res.get("result");
		List<Map<String, Object>> bginfo = new ArrayList<Map<String, Object>>();
		for(Pier_add bil:Bridgelist){
			Map<String, Object> obj = new HashMap<String,Object>();
			
			obj.put("bg_id", bil.getBg_id());
			obj.put("start_pier", bil.getStart_pier());
			obj.put("end_pier", bil.getEnd_pier());
			obj.put("per_pier", bil.getPer_pier());
			obj.put("bent_cap", bil.getBent_cap());
			obj.put("tie_beam", bil.getTie_beam());
			obj.put("tap", bil.getTap());
			bginfo.add(obj);
		}
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("count", res.get("count"));
		result.put("result", bginfo);
		return result;
	}
	
	@Override
	public Map<?,?> getDetailPier_addByBridgeCode(String bridgeCode) {
		System.out.println("6666:" + bridgeCode);
		Map<?,?> res =new HashMap<String, Object>();
		res = pier_addDAO.findEntityListByProperties(bridgeCode);
		@SuppressWarnings("unchecked")
		List<Pier_add> Bridgelist = (List<Pier_add>) res.get("result");
		List<Map<String, Object>> bginfo = new ArrayList<Map<String, Object>>();
		for(Pier_add bil:Bridgelist){
			Map<String, Object> obj = new HashMap<String,Object>();
			System.out.println("3333:" + bil.getBg_id());
			obj.put("bg_id", bil.getBg_id());
			obj.put("start_pier", bil.getStart_pier());
			obj.put("end_pier", bil.getEnd_pier());
			obj.put("per_pier", bil.getPer_pier());
			obj.put("bent_cap", bil.getBent_cap());
			obj.put("tie_beam", bil.getTie_beam());
			obj.put("tap", bil.getTap());
			bginfo.add(obj);
		}
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("count", res.get("count"));
		result.put("result", bginfo);
		return result;
	}

	@Override
	public Pier_add getPier_addById(int id) {
		@SuppressWarnings("unchecked")
		List<Pier_add> Bridgelist = (List<Pier_add>) pier_addDAO.findEntityListByProperty("id", id, StandardBasicTypes.INTEGER);
		if (Bridgelist != null && Bridgelist.size() == 1) {
			return Bridgelist.get(0);
		}
		return null;
	}
	
	@Override
	public Pier_add getPier_addByBridgeCode(String bridgeCode) {
		@SuppressWarnings("unchecked")
		List<Pier_add> Bridgelist = (List<Pier_add>) pier_addDAO.findEntityListByProperty("bg_id", bridgeCode, StringType.INSTANCE);
		if (Bridgelist != null && Bridgelist.size() == 1) {
			return Bridgelist.get(0);
		}
		return null;
	}
}
