package com.qjs.biz.impl;

import global.tool.QueryItems;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.StringType;

import com.qjs.biz.Base2Biz;
import com.qjs.dao.Base2DAO;
import com.qjs.entity.Base2;

public class Base2BizImpl implements Base2Biz {
	
	private Base2DAO base2DAO;	
	
	public Base2DAO getBase2DAO() {
		return base2DAO;
	}

	public void setBase2DAO(Base2DAO base2DAO) {
		this.base2DAO = base2DAO;
	}

	@Override
	public Object addBase2(Base2 base2) {
		@SuppressWarnings("unchecked")
		List<Base2> bridgeList = (List<Base2>) base2DAO.findEntityListByProperty("id", base2.getId(), StandardBasicTypes.INTEGER);
		if (bridgeList.size() != 0) {
			return false;
		}
		base2DAO.addEntity(base2);
		return true;
	}

	@Override
	public List<?> getAllBase2() {
		return base2DAO.getAll();
	}

	@Override
	public boolean updateBase2(Base2 base2) {
		base2DAO.updateEntity(base2);
		return true;
	}

	@Override
	public boolean deleteBase2ById(int id) {
		@SuppressWarnings("unchecked")
		List<Base2> BridgeList = (List<Base2>) base2DAO.findEntityListByProperty("id", id, StandardBasicTypes.INTEGER);
		if(BridgeList.size() != 0) {
			return false;
		}	
		
		int count = base2DAO.deleteEntityByProperty("id", id, StandardBasicTypes.INTEGER);
		if (count != 1)
			return false;
		return true;
	}

	@Override
	public Map<?,?> getAllDetailBase2(QueryItems qi) {
		Map<?,?> res =new HashMap<String, Object>();
		res = base2DAO.findEntityListByProperties(qi);
		@SuppressWarnings("unchecked")
		List<Base2> Bridgelist = (List<Base2>) res.get("result");
		List<Map<String, Object>> bginfo = new ArrayList<Map<String, Object>>();
		for(Base2 bil:Bridgelist){
			Map<String, Object> obj = new HashMap<String,Object>();
			
			obj.put("bg_id", bil.getBg_id());
			obj.put("bridge_classify", bil.getBridge_classify());
			obj.put("design_load", bil.getDesign_load());
			obj.put("bridge_use", bil.getBridge_use());
			obj.put("bridge_status", bil.getBridge_status());
			obj.put("material_code", bil.getMaterial_code());			
			obj.put("bridge_panel", bil.getBridge_panel());
			obj.put("stress_pattern", bil.getStress_pattern());
			obj.put("support_type", bil.getSupport_type());
			obj.put("bridge_type", bil.getBridge_type());
			bginfo.add(obj);
		}
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("count", res.get("count"));
		result.put("result", bginfo);
		return result;
	}

	@Override
	public Base2 getBase2ById(int id) {
		@SuppressWarnings("unchecked")
		List<Base2> Bridgelist = (List<Base2>) base2DAO.findEntityListByProperty("id", id, StandardBasicTypes.INTEGER);
		if (Bridgelist != null && Bridgelist.size() == 1) {
			return Bridgelist.get(0);
		}
		return null;
	}
	
	@Override
	public Base2 getBase2ByBridgeCode(String bridgeCode) {
		@SuppressWarnings("unchecked")
		List<Base2> Bridgelist = (List<Base2>) base2DAO.findEntityListByProperty("bg_id", bridgeCode, StringType.INSTANCE);
		
		if (Bridgelist != null && Bridgelist.size() == 1) {
			return Bridgelist.get(0);
		}
		return null;
	}
}
