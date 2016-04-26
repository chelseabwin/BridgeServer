package com.qjs.dao;

import global.tool.QueryItems;

import java.util.Map;

public interface PermissionDAO extends BaseDAO{
	
	public Map<?, ?> findEntityListByProperties(QueryItems qi);

}
