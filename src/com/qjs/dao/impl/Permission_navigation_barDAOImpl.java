package com.qjs.dao.impl;

import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.Type;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.qjs.dao.Permission_navigation_barDAO;
import com.qjs.entity.Permission_navigation_bar;

public class Permission_navigation_barDAOImpl extends HibernateDaoSupport implements Permission_navigation_barDAO{
	
	private Session getNewSession(){
		return super.getHibernateTemplate().getSessionFactory().getCurrentSession();
	}

	@Override
	public List<?> getAll() {
		return null;
	}

	@Override
	public Object addEntity(Object obj) {
		return super.getHibernateTemplate().save((Permission_navigation_bar)obj);
	}

	@Override
	public int deleteEntityByProperty(String propertyName, Object value, Type type) {
		String hql = "delete Permission_navigation_bar as u where u."+propertyName+"=?";
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
	public List<?> findEntityListByProperty(String propertyName, Object value, Type type) {
		String hql = "from Permission_navigation_bar as u where u."+propertyName+"=?";
		Query qobj = this.getNewSession().createQuery(hql);
		qobj.setParameter(0, value, type);
		return (List<Permission_navigation_bar>)qobj.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<?> findEntityIdListByProperty(String propertyName, String value, Type type) {
		String hql = "select u.permission_navigation_bar_id from Permission_navigation_bar as u where u."+propertyName+"=?";
		Query qobj = this.getNewSession().createQuery(hql);
		qobj.setParameter(0, value, type);
		return (List<Integer>)qobj.list();
	}
	
	@Override
	public List<?> findEntityListByPropertyArray(String propertyName,
			Collection<?> valueList) {
		if(valueList==null||valueList.size()==0) return null;
		Criteria criteria = this.getNewSession().createCriteria(Permission_navigation_bar.class);
		Criterion criterion = Restrictions.in(propertyName, valueList);
		criteria.add(criterion);
		return criteria.list();
	}

}
