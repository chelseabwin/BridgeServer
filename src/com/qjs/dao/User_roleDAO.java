package com.qjs.dao;

import java.util.List;

import org.hibernate.type.Type;

public interface User_roleDAO extends BaseDAO{
	
	public List<?> findEntityIdListByProperty(String propertyName, String value, Type type);

}
