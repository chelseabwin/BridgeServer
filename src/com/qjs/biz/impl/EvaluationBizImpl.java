package com.qjs.biz.impl;

import global.tool.QueryItems;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.StringType;

import com.qjs.biz.EvaluationBiz;
import com.qjs.dao.EvaluationDAO;
import com.qjs.entity.Evaluation;

public class EvaluationBizImpl implements EvaluationBiz {
	
	private EvaluationDAO EvaluationDAO;	
	
	public EvaluationDAO getEvaluationDAO() {
		return EvaluationDAO;
	}

	public void setEvaluationDAO(EvaluationDAO EvaluationDAO) {
		this.EvaluationDAO = EvaluationDAO;
	}

	@Override
	public Object addEvaluation(Evaluation Evaluation) {
		@SuppressWarnings("unchecked")
		List<Evaluation> bridgeList = (List<Evaluation>) EvaluationDAO.findEntityListByProperty("id", Evaluation.getId(), StandardBasicTypes.INTEGER);
		if (bridgeList.size() != 0) {
			return false;
		}
		EvaluationDAO.addEntity(Evaluation);
		return true;
	}

	@Override
	public List<?> getAllEvaluation() {
		return EvaluationDAO.getAll();
	}

	@Override
	public boolean updateEvaluation(Evaluation Evaluation) {
		EvaluationDAO.updateEntity(Evaluation);
		return true;
	}

	@Override
	public boolean deleteEvaluationById(int id) {
		@SuppressWarnings("unchecked")
		List<Evaluation> BridgeList = (List<Evaluation>) EvaluationDAO.findEntityListByProperty("id", id, StandardBasicTypes.INTEGER);
		if(BridgeList.size() != 0) {
			return false;
		}	
		
		int count = EvaluationDAO.deleteEntityByProperty("id", id, StandardBasicTypes.INTEGER);
		if (count != 1)
			return false;
		return true;
	}

	@Override
	public Map<?,?> getAllDetailEvaluation(QueryItems qi) {
		Map<?,?> res =new HashMap<String, Object>();
		res = EvaluationDAO.findEntityListByProperties(qi);
		@SuppressWarnings("unchecked")
		List<Evaluation> Bridgelist = (List<Evaluation>) res.get("result");
		List<Map<String, Object>> bginfo = new ArrayList<Map<String, Object>>();
		for(Evaluation bil:Bridgelist){
			Map<String, Object> obj = new HashMap<String,Object>();
			
			obj.put("table_name", bil.getTable_name());
			obj.put("bg_id", bil.getBg_id());
			obj.put("parts_id", bil.getParts_id());
			obj.put("dis_id", bil.getDis_id());
			obj.put("evaluation", bil.getEvaluation());
			obj.put("score", bil.getScore());
			bginfo.add(obj);
		}
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("count", res.get("count"));
		result.put("result", bginfo);
		return result;
	}

	@Override
	public Evaluation getEvaluationById(int id) {
		@SuppressWarnings("unchecked")
		List<Evaluation> Bridgelist = (List<Evaluation>) EvaluationDAO.findEntityListByProperty("id", id, StandardBasicTypes.INTEGER);
		if (Bridgelist != null && Bridgelist.size() == 1) {
			return Bridgelist.get(0);
		}
		return null;
	}
	
	@Override
	public Evaluation getEvaluationByBridgeCode(String bridgeCode) {
		@SuppressWarnings("unchecked")
		List<Evaluation> Bridgelist = (List<Evaluation>) EvaluationDAO.findEntityListByProperty("bg_id", bridgeCode, StringType.INSTANCE);
		if (Bridgelist != null && Bridgelist.size() == 1) {
			return Bridgelist.get(0);
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Evaluation getEvaluationExactly(String tableName, String bridgeCode, String disId) {
		List<Evaluation> evallist = (List<Evaluation>) EvaluationDAO.findEntityListByPropertyByThreeProperty("table_name", "bg_id", "dis_id", tableName, bridgeCode, disId);
		
		if (evallist != null && evallist.size() == 1) {
			return evallist.get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, String>> getEvaluationByTwo(String tableName, String bridgeCode) {
		List<Evaluation> evallist = (List<Evaluation>) EvaluationDAO.findEntityListByPropertyByTwoProperty("table_name", "bg_id", tableName, bridgeCode);
		
		List<Map<String, String>> disinfo = new ArrayList<Map<String, String>>();
		for (Evaluation dil:evallist) {
			Map<String, String> obj = new HashMap<String, String>();
			
			obj.put("id", dil.getId() + "");
			obj.put("table_name", dil.getTable_name());
			obj.put("bg_id", dil.getBg_id());
			obj.put("parts_id", dil.getParts_id());
			obj.put("dis_id", dil.getDis_id());
			obj.put("evaluation", dil.getEvaluation());
			obj.put("score", dil.getScore());
			disinfo.add(obj);
		}
		return disinfo;
	}
}
