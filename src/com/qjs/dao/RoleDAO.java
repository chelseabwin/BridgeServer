package com.qjs.dao;

import global.tool.QueryItems;

import java.util.Map;

public interface RoleDAO extends BaseDAO {
	
	public Map<?, ?> findEntityListByProperties(QueryItems qi);

}
