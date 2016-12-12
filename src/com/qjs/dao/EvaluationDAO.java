package com.qjs.dao;

import global.tool.QueryItems;

import java.util.List;
import java.util.Map;

public interface EvaluationDAO extends BaseDAO{
	
	public Map<?, ?> findEntityListByProperties(QueryItems qi);
	
	public Map<?, ?> findAllEntityListByProperties(QueryItems qi);
	
	public Map<?, ?> findEntityListByOwner(QueryItems qi);
	
	public List<?> findEntityListByPropertyWithSql(String propertyName);
	
	public List<?> findEntityListByPropertyByTwoProperty(String propertyName1, String propertyName2, String value1, String value2);
	
	public List<?> findEntityListByPropertyByThreeProperty(String propertyName1, String propertyName2, String propertyName3, String value1, String value2, String value3);
	
}
