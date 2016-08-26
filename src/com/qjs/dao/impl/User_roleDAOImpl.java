package com.qjs.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.type.Type;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.qjs.dao.User_roleDAO;
import com.qjs.entity.User_role;

public class User_roleDAOImpl  extends HibernateDaoSupport implements User_roleDAO {
	
	private Session getNewSession(){
		return super.getHibernateTemplate().getSessionFactory().getCurrentSession();
	}

	@Override
	public List<?> getAll() {
		return null;
	}

	@Override
	public Object addEntity(Object obj) {
		return super.getHibernateTemplate().save((User_role)obj);
		
	}

	@Override
	public int deleteEntityByProperty(String propertyName, Object value, Type type) {
		String hql = "delete User_role as u where u."+propertyName+"=?";
		Query qobj = this.getNewSession().createQuery(hql);
		qobj.setParameter(0, value, type);
		int count = qobj.executeUpdate();
		return count;
	}

	@Override
	public void updateEntity(Object obj) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<?> findEntityListByProperty(String propertyName, Object value,Type type) {
		String hql = "from User_role as u where u."+propertyName+"=?";
		Query qobj = this.getNewSession().createQuery(hql);
		qobj.setParameter(0, value, type);
		return (List<User_role>)qobj.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<?> findEntityIdListByProperty(String propertyName, String value, Type type) {
		String hql = "select u.user_role_id from User_role as u where u."+propertyName+"=?";
		Query qobj = this.getNewSession().createQuery(hql);
		qobj.setParameter(0, value, type);
		return (List<Integer>)qobj.list();
	}

	@Override
	public List<?> findEntityListByPropertySort(String propertyName, String sortStr, Object value, Type type) {
		// TODO Auto-generated method stub
		return null;
	}

}
