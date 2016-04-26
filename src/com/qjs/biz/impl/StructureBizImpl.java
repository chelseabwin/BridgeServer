package com.qjs.biz.impl;

import global.tool.QueryItems;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.StringType;

import com.qjs.biz.StructureBiz;
import com.qjs.dao.StructureDAO;
import com.qjs.entity.Structure;

public class StructureBizImpl implements StructureBiz {
	
	private StructureDAO structureDAO;	
	
	public StructureDAO getStructureDAO() {
		return structureDAO;
	}

	public void setStructureDAO(StructureDAO structureDAO) {
		this.structureDAO = structureDAO;
	}

	@Override
	public Object addStructure(Structure structure) {
		@SuppressWarnings("unchecked")
		List<Structure> bridgeList = (List<Structure>) structureDAO.findEntityListByProperty("id", structure.getId(), StandardBasicTypes.INTEGER);
		if (bridgeList.size() != 0) {
			return false;
		}
		structureDAO.addEntity(structure);
		return true;
	}

	@Override
	public List<?> getAllStructure() {
		return structureDAO.getAll();
	}

	@Override
	public boolean updateStructure(Structure structure) {
		structureDAO.updateEntity(structure);
		return true;
	}

	@Override
	public boolean deleteStructureById(int id) {
		@SuppressWarnings("unchecked")
		List<Structure> BridgeList = (List<Structure>) structureDAO.findEntityListByProperty("id", id, StandardBasicTypes.INTEGER);
		if(BridgeList.size() != 0) {
			return false;
		}	
		
		int count = structureDAO.deleteEntityByProperty("id", id, StandardBasicTypes.INTEGER);
		if (count != 1)
			return false;
		return true;
	}

	@Override
	public Map<?,?> getAllDetailStructure(QueryItems qi) {
		Map<?,?> res =new HashMap<String, Object>();
		res = structureDAO.findEntityListByProperties(qi);
		@SuppressWarnings("unchecked")
		List<Structure> Bridgelist = (List<Structure>) res.get("result");
		List<Map<String, Object>> bginfo = new ArrayList<Map<String, Object>>();
		for(Structure bil:Bridgelist){
			Map<String, Object> obj = new HashMap<String,Object>();
			
			obj.put("bg_id", bil.getBg_id());
			obj.put("bridge_span", bil.getBridge_span());
			obj.put("longest_span", bil.getLongest_span());
			obj.put("total_len", bil.getTotal_len());
			obj.put("bridge_wide", bil.getBridge_wide());
			obj.put("full_wide", bil.getFull_wide());			
			obj.put("clear_wide", bil.getClear_wide());
			obj.put("bridge_high", bil.getBridge_high());
			obj.put("high_limit", bil.getHigh_limit());
			obj.put("building_time", bil.getBuilding_time());
			obj.put("navigation_level", bil.getNavigation_level());
			obj.put("section_high", bil.getSection_high());
			obj.put("deck_profile_grade", bil.getDeck_profile_grade());
			bginfo.add(obj);
		}
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("count", res.get("count"));
		result.put("result", bginfo);
		return result;
	}

	@Override
	public Structure getStructureById(int id) {
		@SuppressWarnings("unchecked")
		List<Structure> Bridgelist = (List<Structure>) structureDAO.findEntityListByProperty("id", id, StandardBasicTypes.INTEGER);
		if (Bridgelist != null && Bridgelist.size() == 1) {
			return Bridgelist.get(0);
		}
		return null;
	}
	
	@Override
	public Structure getStructureByBridgeCode(String bridgeCode) {
		@SuppressWarnings("unchecked")
		List<Structure> Bridgelist = (List<Structure>) structureDAO.findEntityListByProperty("bg_id", bridgeCode, StringType.INSTANCE);
		if (Bridgelist != null && Bridgelist.size() == 1) {
			return Bridgelist.get(0);
		}
		return null;
	}
}
