package com.qjs.biz.impl;

import global.tool.QueryItems;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.StringType;

import com.qjs.biz.Base3Biz;
import com.qjs.dao.Base3DAO;
import com.qjs.entity.Base3;

public class Base3BizImpl implements Base3Biz {
	
	private Base3DAO base3DAO;	
	
	public Base3DAO getBase3DAO() {
		return base3DAO;
	}

	public void setBase3DAO(Base3DAO base3DAO) {
		this.base3DAO = base3DAO;
	}

	@Override
	public Object addBase3(Base3 base3) {
		@SuppressWarnings("unchecked")
		List<Base3> bridgeList = (List<Base3>) base3DAO.findEntityListByProperty("id", base3.getId(), StandardBasicTypes.INTEGER);
		if (bridgeList.size() != 0) {
			return false;
		}
		base3DAO.addEntity(base3);
		return true;
	}

	@Override
	public List<?> getAllBase3() {
		return base3DAO.getAll();
	}

	@Override
	public boolean updateBase3(Base3 base3) {
		base3DAO.updateEntity(base3);
		return true;
	}

	@Override
	public boolean deleteBase3ById(int id) {
		@SuppressWarnings("unchecked")
		List<Base3> BridgeList = (List<Base3>) base3DAO.findEntityListByProperty("id", id, StandardBasicTypes.INTEGER);
		if(BridgeList.size() != 0) {
			return false;
		}	
		
		int count = base3DAO.deleteEntityByProperty("id", id, StandardBasicTypes.INTEGER);
		if (count != 1)
			return false;
		return true;
	}

	@Override
	public Map<?,?> getAllDetailBase3(QueryItems qi) {
		Map<?,?> res =new HashMap<String, Object>();
		res = base3DAO.findEntityListByProperties(qi);
		@SuppressWarnings("unchecked")
		List<Base3> Bridgelist = (List<Base3>) res.get("result");
		List<Map<String, Object>> bginfo = new ArrayList<Map<String, Object>>();
		for(Base3 bil:Bridgelist){
			Map<String, Object> obj = new HashMap<String,Object>();
			
			obj.put("bg_id", bil.getBg_id());
			obj.put("pier_material", bil.getPier_material());
			obj.put("section_form", bil.getSection_form());
			obj.put("pier_type", bil.getPier_type());
			obj.put("section_shape", bil.getSection_shape());
			obj.put("abutment_material", bil.getAbutment_material());			
			obj.put("abutment_type", bil.getAbutment_type());
			obj.put("pier_abutment_material", bil.getPier_abutment_material());
			obj.put("pier_abutment_base", bil.getPier_abutment_base());
			obj.put("deck_type", bil.getDeck_type());
			obj.put("joint_type", bil.getJoint_type());
			bginfo.add(obj);
		}
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("count", res.get("count"));
		result.put("result", bginfo);
		return result;
	}

	@Override
	public Base3 getBase3ById(int id) {
		@SuppressWarnings("unchecked")
		List<Base3> Bridgelist = (List<Base3>) base3DAO.findEntityListByProperty("id", id, StandardBasicTypes.INTEGER);
		if (Bridgelist != null && Bridgelist.size() == 1) {
			return Bridgelist.get(0);
		}
		return null;
	}
	
	@Override
	public Base3 getBase3ByBridgeCode(String bridgeCode) {
		@SuppressWarnings("unchecked")
		List<Base3> Bridgelist = (List<Base3>) base3DAO.findEntityListByProperty("bg_id", bridgeCode, StringType.INSTANCE);
		if (Bridgelist != null && Bridgelist.size() == 1) {
			return Bridgelist.get(0);
		}
		return null;
	}
}
