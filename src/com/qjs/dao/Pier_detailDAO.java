package com.qjs.dao;

import global.tool.QueryItems;

import java.util.List;
import java.util.Map;

public interface Pier_detailDAO extends BaseDAO{
	
	public Map<?, ?> findEntityListByProperties(QueryItems qi);
	
	public Map<?, ?> findAllEntityListByProperties(QueryItems qi);
	
	public Map<?, ?> findEntityListByOwner(QueryItems qi);
	
	public List<?> findEntityListByPropertyWithSql(String propertyName);

}
