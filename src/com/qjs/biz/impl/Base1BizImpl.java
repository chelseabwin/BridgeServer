package com.qjs.biz.impl;

import global.tool.QueryItems;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.StringType;

import com.qjs.biz.Base1Biz;
import com.qjs.dao.Base1DAO;
import com.qjs.entity.Base1;

public class Base1BizImpl implements Base1Biz {
	
	private Base1DAO base1DAO;	
	
	public Base1DAO getBase1DAO() {
		return base1DAO;
	}

	public void setBase1DAO(Base1DAO base1DAO) {
		this.base1DAO = base1DAO;
	}

	@Override
	public Object addBase1(Base1 base1) {
		@SuppressWarnings("unchecked")
		List<Base1> bridgeList = (List<Base1>) base1DAO.findEntityListByProperty("id", base1.getId(), StandardBasicTypes.INTEGER);
		if (bridgeList.size() != 0) {
			return false;
		}
		base1DAO.addEntity(base1);
		return true;
	}

	@Override
	public List<?> getAllBase1() {
		return base1DAO.getAll();
	}

	@Override
	public boolean updateBase1(Base1 base1) {
		base1DAO.updateEntity(base1);
		return true;
	}

	@Override
	public boolean deleteBase1ById(int id) {
		@SuppressWarnings("unchecked")
		List<Base1> BridgeList = (List<Base1>) base1DAO.findEntityListByProperty("id", id, StandardBasicTypes.INTEGER);
		if(BridgeList.size() != 0) {
			return false;
		}	
		
		int count = base1DAO.deleteEntityByProperty("id", id, StandardBasicTypes.INTEGER);
		if (count != 1)
			return false;
		return true;
	}

	@Override
	public Map<?,?> getAllDetailBase1(QueryItems qi) {
		Map<?,?> res =new HashMap<String, Object>();
		res = base1DAO.findEntityListByProperties(qi);
		@SuppressWarnings("unchecked")
		List<Base1> Bridgelist = (List<Base1>) res.get("result");
		List<Map<String, Object>> bginfo = new ArrayList<Map<String, Object>>();
		for(Base1 bil:Bridgelist){
			Map<String, Object> obj = new HashMap<String,Object>();
			
			obj.put("bridge_code", bil.getBridge_code());
			obj.put("bridge_name", bil.getBridge_name());
			obj.put("path_num", bil.getPath_num());
			obj.put("path_name", bil.getPath_name());
			obj.put("path_type", bil.getPath_type());
			obj.put("rode_grade", bil.getRode_grade());			
			obj.put("order_num", bil.getOrder_num());
			obj.put("location", bil.getLocation());
			obj.put("center_stake", bil.getCenter_stake());
			obj.put("custody_unit", bil.getCustody_unit());
			obj.put("across_name", bil.getAcross_name());
			obj.put("across_Type", bil.getAcross_type());
			obj.put("bridge_nature", bil.getBridge_nature());
			obj.put("detect_time", bil.getDetect_time());
			obj.put("bridge_image1", bil.getBridge_image1());
			obj.put("bridge_image2", bil.getBridge_image2());
			obj.put("image1_type", bil.getImage1_type());
			obj.put("image2_type", bil.getImage2_type());
			bginfo.add(obj);
		}
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("count", res.get("count"));
		result.put("result", bginfo);
		return result;
	}

	@Override
	public Base1 getBase1ById(int id) {
		@SuppressWarnings("unchecked")
		List<Base1> Bridgelist = (List<Base1>) base1DAO.findEntityListByProperty("id", id, StandardBasicTypes.INTEGER);
		if (Bridgelist != null && Bridgelist.size() == 1) {
			return Bridgelist.get(0);
		}
		return null;
	}
	
	@Override
	public Base1 getBase1ByBridgeCode(String bridgeCode) {
		@SuppressWarnings("unchecked")
		List<Base1> Bridgelist = (List<Base1>) base1DAO.findEntityListByProperty("bridge_code", bridgeCode, StringType.INSTANCE);
		if (Bridgelist != null && Bridgelist.size() == 1) {
			return Bridgelist.get(0);
		}
		return null;
	}
}
