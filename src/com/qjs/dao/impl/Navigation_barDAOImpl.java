package com.qjs.dao.impl;

import global.tool.QueryItems;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.Type;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.qjs.dao.Navigation_barDAO;
import com.qjs.entity.Navigation_bar;


public class Navigation_barDAOImpl extends HibernateDaoSupport implements Navigation_barDAO{
	
	private Session getNewSession(){
		return super.getHibernateTemplate().getSessionFactory().getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<?> getAll() {
		String hql = "from Navigation_bar";
		
		Query qobj = this.getNewSession().createQuery(hql);
		return (List<Navigation_bar>)qobj.list();
	}

	@Override
	public Object addEntity(Object obj) {
		return super.getHibernateTemplate().save((Navigation_bar)obj);
	}

	@Override
	public int deleteEntityByProperty(String propertyName, Object value, Type type) {
		String hql = "delete Navigation_bar as u where u."+propertyName+"=?";
		Query qobj = this.getNewSession().createQuery(hql);
		qobj.setParameter(0, value, type);
		int count = qobj.executeUpdate();
		return count;
	}

	@Override
	public void updateEntity(Object obj) {
		super.getHibernateTemplate().update((Navigation_bar)obj);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Navigation_bar> findEntityListByProperty(String propertyName, Object value, Type type) {
		String hql = "from Navigation_bar as u where u."+propertyName+"=?";
		Query qobj = this.getNewSession().createQuery(hql);
		qobj.setParameter(0, value, type);
		return (List<Navigation_bar>)qobj.list();
	}

	@Override
	public List<?> findEntityListByPropertyArray(String propertyName,
			Collection<?> valueList) {
		if(valueList==null||valueList.size()==0) return null;
		Criteria criteria = this.getNewSession().createCriteria(Navigation_bar.class);
		Criterion criterion = Restrictions.in(propertyName, valueList);
		criteria.add(criterion);
		criteria.addOrder(Order.asc("priority"));
		return criteria.list();
	}

	@Override
	public Map<?,?> findEntityListByPropertiesInOrder(QueryItems qi) {
		Map<String,Object> result = new HashMap<String, Object>();
		Criteria criteria = this.getNewSession().createCriteria(Navigation_bar.class);
		Integer total = new Integer(criteria.list().size());
		criteria.add(Restrictions.eq("level", 1));
		criteria.addOrder(Order.asc("priority"));
		
		@SuppressWarnings("unchecked")
		List<Navigation_bar> resLevel1 = criteria.list();
		Criteria criteria2 = this.getNewSession().createCriteria(Navigation_bar.class);
		criteria2.add(Restrictions.eq("level", 2));
		criteria2.addOrder(Order.asc("priority"));
		
		@SuppressWarnings("unchecked")
		List<Navigation_bar> resLevel2 = criteria2.list();
		List<Navigation_bar> newList = new ArrayList<Navigation_bar>();
		for(Navigation_bar r1:resLevel1){
			newList.add(r1);
			for(Navigation_bar r2:resLevel2){
				if(r2.getUp().equals(r1.getNavigation_bar_id())){
					newList.add(r2);
				}
			}
		}
		result.put("count", total);
		result.put("result", newList);
		return result;
	}

	@Override
	public List<?> findEntityListByPropertySort(String propertyName, String sortStr, Object value, Type type) {
		// TODO Auto-generated method stub
		return null;
	}

}
