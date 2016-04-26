package com.qjs.dao;

import global.tool.QueryItems;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface Navigation_barDAO extends BaseDAO {
	
	public List<?> findEntityListByPropertyArray(String propertyName, Collection<?> valueList);
	
	public Map<?, ?> findEntityListByPropertiesInOrder(QueryItems qi);

}
