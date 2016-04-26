package com.qjs.dao;

import java.util.Collection;
import java.util.List;

import org.hibernate.type.Type;

public interface Permission_navigation_barDAO extends BaseDAO {
	
	public List<?> findEntityIdListByProperty(String propertyName, String value, Type type);
	
	public List<?> findEntityListByPropertyArray(String propertyName, Collection<?> valueList);

}
