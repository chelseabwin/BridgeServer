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

import com.qjs.dao.Role_permissionDAO;
import com.qjs.entity.Role_permission;

public class Role_permissionDAOImpl extends HibernateDaoSupport implements Role_permissionDAO{
	
	private Session getNewSession(){
		return super.getHibernateTemplate().getSessionFactory().getCurrentSession();
	}

	@Override
	public List<?> getAll() {
		return null;
	}

	@Override
	public Object addEntity(Object obj) {
		return super.getHibernateTemplate().save((Role_permission)obj);
	}

	@Override
	public int deleteEntityByProperty(String propertyName, Object value, Type type) {
		String hql = "delete Role_permission as u where u."+propertyName+"=?";
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
		String hql = "from Role_permission as u where u."+propertyName+"=?";
		Query qobj = this.getNewSession().createQuery(hql);
		qobj.setParameter(0, value, type);
		return (List<Role_permission>)qobj.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<?> findEntityIdListByProperty(String propertyName, String value, Type type) {
		String hql = "select u.role_permission_id from Role_permission as u where u."+propertyName+"=?";
		Query qobj = this.getNewSession().createQuery(hql);
		qobj.setParameter(0, value, type);
		return (List<Integer>)qobj.list();
	}

	@Override
	public List<?> findEntityListByPropertyArray(String propertyName,
			Collection<?> valueList) {
		if(valueList==null||valueList.size()==0) return null;
		Criteria criteria = this.getNewSession().createCriteria(Role_permission.class);
		Criterion criterion = Restrictions.in(propertyName, valueList);
		criteria.add(criterion);
		return criteria.list();
	}

	@Override
	public List<?> findEntityListByPropertySort(String propertyName, String sortStr, Object value, Type type) {
		// TODO Auto-generated method stub
		return null;
	}

}
