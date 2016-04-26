package com.qjs.biz.impl;

import global.tool.QueryItems;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.StringType;

import com.qjs.biz.Parts2Biz;
import com.qjs.dao.Parts2DAO;
import com.qjs.entity.Parts2;

public class Parts2BizImpl implements Parts2Biz {
	
	private Parts2DAO parts2DAO;	
	
	public Parts2DAO getParts2DAO() {
		return parts2DAO;
	}

	public void setParts2DAO(Parts2DAO parts2DAO) {
		this.parts2DAO = parts2DAO;
	}

	@Override
	public Object addParts2(Parts2 parts2) {
		@SuppressWarnings("unchecked")
		List<Parts2> bridgeList = (List<Parts2>) parts2DAO.findEntityListByProperty("id", parts2.getId(), StandardBasicTypes.INTEGER);
		if (bridgeList.size() != 0) {
			return false;
		}
		parts2DAO.addEntity(parts2);
		return true;
	}

	@Override
	public List<?> getAllParts2() {
		return parts2DAO.getAll();
	}

	@Override
	public boolean updateParts2(Parts2 parts2) {
		parts2DAO.updateEntity(parts2);
		return true;
	}

	@Override
	public boolean deleteParts2ById(int id) {
		@SuppressWarnings("unchecked")
		List<Parts2> BridgeList = (List<Parts2>) parts2DAO.findEntityListByProperty("id", id, StandardBasicTypes.INTEGER);
		if(BridgeList.size() != 0) {
			return false;
		}	
		
		int count = parts2DAO.deleteEntityByProperty("id", id, StandardBasicTypes.INTEGER);
		if (count != 1)
			return false;
		return true;
	}

	@Override
	public Map<?,?> getAllDetailParts2(QueryItems qi) {
		Map<?,?> res =new HashMap<String, Object>();
		res = parts2DAO.findEntityListByProperties(qi);
		@SuppressWarnings("unchecked")
		List<Parts2> Bridgelist = (List<Parts2>) res.get("result");
		List<Map<String, Object>> bginfo = new ArrayList<Map<String, Object>>();
		for(Parts2 bil:Bridgelist){
			Map<String, Object> obj = new HashMap<String,Object>();
			
			obj.put("bg_id", bil.getBg_id());
			obj.put("load_detail", bil.getLoad_detail());
			obj.put("general_detail", bil.getGeneral_detail());
			obj.put("support_detail", bil.getSupport_detail());
			obj.put("deck_num", bil.getDeck_num());
			obj.put("joint_num", bil.getJoint_num());			
			obj.put("sidewalk", bil.getSidewalk());
			obj.put("guardrail", bil.getGuardrail());
			obj.put("drainage_system", bil.getDrainage_system());
			obj.put("illuminated_sign", bil.getIlluminated_sign());
			bginfo.add(obj);
		}
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("count", res.get("count"));
		result.put("result", bginfo);
		return result;
	}

	@Override
	public Parts2 getParts2ById(int id) {
		@SuppressWarnings("unchecked")
		List<Parts2> Bridgelist = (List<Parts2>) parts2DAO.findEntityListByProperty("id", id, StandardBasicTypes.INTEGER);
		if (Bridgelist != null && Bridgelist.size() == 1) {
			return Bridgelist.get(0);
		}
		return null;
	}
	
	@Override
	public Parts2 getParts2ByBridgeCode(String bridgeCode) {
		@SuppressWarnings("unchecked")
		List<Parts2> Bridgelist = (List<Parts2>) parts2DAO.findEntityListByProperty("bg_id", bridgeCode, StringType.INSTANCE);
		if (Bridgelist != null && Bridgelist.size() == 1) {
			return Bridgelist.get(0);
		}
		return null;
	}
}
