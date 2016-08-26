package com.qjs.dao.impl;

import global.tool.Constant;
import global.tool.QueryItems;
import global.tool.QueryObject;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.Type;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.qjs.dao.UserDAO;
import com.qjs.entity.User;

public class UserDAOImpl extends HibernateDaoSupport implements UserDAO {
	
	private Session getNewSession(){
		return super.getHibernateTemplate().getSessionFactory().getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAll() {
		String hql = "from User";
		Query qobj = this.getNewSession().createQuery(hql);
		return (List<User>)qobj.list();
	}

	@Override
	public Object addEntity(Object obj) {
		return super.getHibernateTemplate().save((User)obj);
	}

	@Override
	public int deleteEntityByProperty(String propertyName, Object value, Type type) {
		String hql = "delete User as u where u."+propertyName+"=?";
		Query qobj = this.getNewSession().createQuery(hql);
		qobj.setParameter(0, value, type);
		int count = qobj.executeUpdate();
		return count;
	}

	@Override
	public void updateEntity(Object obj) {
		super.getHibernateTemplate().update((User)obj);		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findEntityListByProperty(String propertyName, Object value, Type type) {
		String hql = "from User as u where u."+propertyName+"=?";
		Query qobj = this.getNewSession().createQuery(hql);
		qobj.setParameter(0, value, type);
		return (List<User>)qobj.list();
	}

	@Override
	public List<?> findEntityListByPropertyArray(String propertyName, Collection<?> valueList) {
		if(valueList == null || valueList.size() == 0) return null;
		Criteria criteria = this.getNewSession().createCriteria(User.class);
		Criterion criterion = Restrictions.in(propertyName, valueList);
		criteria.add(criterion);
		return criteria.list();
	}

	@Override
	public Map<?, ?> findEntityListByProperties(QueryItems qi) {
		Criteria criteria = this.getNewSession().createCriteria(User.class);
		List<QueryObject> qoList = qi.getQueryObjects();
		if (qoList != null & qoList.size() > 0) {
			for(QueryObject qo:qoList){
				criteria.add(Restrictions.like(qo.getPropertyName(), "%"+qo.getObject()+"%"));
			}
		}
		int pageNo = 1;
		if (qi.getPageNo() != null && qi.getPageNo() > 0) {
			pageNo = qi.getPageNo();
		}
		int pageSize = Constant.PAGE_SIZE;
		if (qi.getPageSize() != null && qi.getPageSize() > 0) {
			pageSize = qi.getPageSize();
		}
		Map<Object, Object> result = new HashMap<Object, Object>();
		Integer total = new Integer(criteria.list().size());
		criteria.setFirstResult((pageNo-1)*pageSize);
		criteria.setMaxResults(pageSize);
		List<?> res = criteria.list();
		result.put("count", total);
		result.put("result", res);
		return result;
	}

	@Override
	public List<?> findEntityListByPropertySort(String propertyName, String sortStr, Object value, Type type) {
		// TODO Auto-generated method stub
		return null;
	}
}
