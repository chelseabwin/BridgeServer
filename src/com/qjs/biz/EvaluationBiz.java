package com.qjs.biz;

import global.tool.QueryItems;

import java.util.List;
import java.util.Map;

import com.qjs.entity.Evaluation;

public interface EvaluationBiz {
	
	public Object addEvaluation(Evaluation evaluation);
	
	public List<?> getAllEvaluation();
	
	public boolean updateEvaluation(Evaluation evaluation);
	
	public boolean deleteEvaluationById(int id);
	
	public Map<?, ?> getAllDetailEvaluation(QueryItems qi);
	
	public Evaluation getEvaluationById(int id);
	
	public Evaluation getEvaluationByBridgeCode(String bridgeCode);
	
	public Evaluation getEvaluationExactly(String tableName, String bridgeCode, String disId);
	
	public List<Map<String, String>> getEvaluationByTwo(String tableName, String bridgeCode);
}
