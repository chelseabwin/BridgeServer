package com.qjs.biz.impl;

import global.tool.QueryItems;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.StringType;

import com.qjs.biz.Parts1Biz;
import com.qjs.dao.Parts1DAO;
import com.qjs.entity.Parts1;

public class Parts1BizImpl implements Parts1Biz {
	
	private Parts1DAO parts1DAO;	
	
	public Parts1DAO getParts1DAO() {
		return parts1DAO;
	}

	public void setParts1DAO(Parts1DAO parts1DAO) {
		this.parts1DAO = parts1DAO;
	}

	@Override
	public Object addParts1(Parts1 parts1) {
		@SuppressWarnings("unchecked")
		List<Parts1> bridgeList = (List<Parts1>) parts1DAO.findEntityListByProperty("id", parts1.getId(), StandardBasicTypes.INTEGER);
		if (bridgeList.size() != 0) {
			return false;
		}
		parts1DAO.addEntity(parts1);
		return true;
	}

	@Override
	public List<?> getAllParts1() {
		return parts1DAO.getAll();
	}

	@Override
	public boolean updateParts1(Parts1 parts1) {
		parts1DAO.updateEntity(parts1);
		return true;
	}

	@Override
	public boolean deleteParts1ById(int id) {
		@SuppressWarnings("unchecked")
		List<Parts1> BridgeList = (List<Parts1>) parts1DAO.findEntityListByProperty("id", id, StandardBasicTypes.INTEGER);
		if(BridgeList.size() != 0) {
			return false;
		}	
		
		int count = parts1DAO.deleteEntityByProperty("id", id, StandardBasicTypes.INTEGER);
		if (count != 1)
			return false;
		return true;
	}

	@Override
	public Map<?,?> getAllDetailParts1(QueryItems qi) {
		Map<?,?> res =new HashMap<String, Object>();
		res = parts1DAO.findEntityListByProperties(qi);
		@SuppressWarnings("unchecked")
		List<Parts1> Bridgelist = (List<Parts1>) res.get("result");
		List<Map<String, Object>> bginfo = new ArrayList<Map<String, Object>>();
		for(Parts1 bil:Bridgelist){
			Map<String, Object> obj = new HashMap<String,Object>();
			
			obj.put("bg_id", bil.getBg_id());
			obj.put("wing_wall", bil.getWing_wall());
			obj.put("conical_slope", bil.getConical_slope());
			obj.put("protection_slope", bil.getProtection_slope());
			obj.put("pier_detail", bil.getPier_detail());
			obj.put("abutment_num", bil.getAbutment_num());			
			obj.put("pa_num", bil.getPa_num());
			obj.put("bed_num", bil.getBed_num());
			obj.put("reg_structure", bil.getReg_structure());
			bginfo.add(obj);
		}
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("count", res.get("count"));
		result.put("result", bginfo);
		return result;
	}

	@Override
	public Parts1 getParts1ById(int id) {
		@SuppressWarnings("unchecked")
		List<Parts1> Bridgelist = (List<Parts1>) parts1DAO.findEntityListByProperty("id", id, StandardBasicTypes.INTEGER);
		if (Bridgelist != null && Bridgelist.size() == 1) {
			return Bridgelist.get(0);
		}
		return null;
	}
	
	@Override
	public Parts1 getParts1ByBridgeCode(String bridgeCode) {
		@SuppressWarnings("unchecked")
		List<Parts1> Bridgelist = (List<Parts1>) parts1DAO.findEntityListByProperty("bg_id", bridgeCode, StringType.INSTANCE);
		if (Bridgelist != null && Bridgelist.size() == 1) {
			return Bridgelist.get(0);
		}
		return null;
	}
}
