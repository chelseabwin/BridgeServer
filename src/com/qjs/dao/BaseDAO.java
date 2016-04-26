package com.qjs.dao;

import java.util.List;
import org.hibernate.type.Type;

public interface BaseDAO {
	
	public List<?> getAll();
	
	public Object addEntity(Object obj);
	
	public int deleteEntityByProperty(String propertyName, Object value, Type type);
	
	public void updateEntity(Object obj);
	
	public List<?> findEntityListByProperty(String propertyName, Object value, Type type);

}
