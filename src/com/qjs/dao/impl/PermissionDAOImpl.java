package com.qjs.dao.impl;

import global.tool.Constant;
import global.tool.QueryItems;
import global.tool.QueryObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.Type;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.qjs.dao.PermissionDAO;
import com.qjs.entity.Permission;

public class PermissionDAOImpl extends HibernateDaoSupport implements PermissionDAO{
	
	private Session getNewSession(){
		return super.getHibernateTemplate().getSessionFactory().getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<?> getAll() {
		String hql = "from Permission";
		Query qobj = this.getNewSession().createQuery(hql);
		return (List<Permission>)qobj.list();
	}

	@Override
	public Object addEntity(Object obj) {
		return super.getHibernateTemplate().save((Permission)obj);
	}

	@Override
	public int deleteEntityByProperty(String propertyName, Object value,
			Type type) {
		String hql = "delete Permission as u where u."+propertyName+"=?";
		Query qobj = this.getNewSession().createQuery(hql);
		qobj.setParameter(0, value, type);
		int count = qobj.executeUpdate();
		return count;
	}

	@Override
	public void updateEntity(Object obj) {
		super.getHibernateTemplate().update((Permission)obj);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<?> findEntityListByProperty(String propertyName, Object value,
			Type type) {
		String hql = "from Permission as u where u."+propertyName+"=?";
		Query qobj = this.getNewSession().createQuery(hql);
		qobj.setParameter(0, value, type);
		return (List<Permission>)qobj.list();
	}

	@Override
	public Map<String, Object> findEntityListByProperties(QueryItems qi) {
		Criteria criteria = this.getNewSession().createCriteria(Permission.class);
		List<QueryObject> qoList = qi.getQueryObjects();
		if(qoList!=null&qoList.size()>0){
			for(QueryObject qo:qoList){
				criteria.add(Restrictions.like(qo.getPropertyName(), "%"+qo.getObject()+"%"));
			}
		}
		int pageNo=1;
		if(qi.getPageNo()!=null&&qi.getPageNo()>0){
			pageNo = qi.getPageNo();
		}
		int pageSize=Constant.PAGE_SIZE;
		if(qi.getPageSize()!=null&&qi.getPageSize()>0){
			pageSize = qi.getPageSize();
		}
		Map<String,Object> result = new HashMap<String, Object>();
		Integer total = new Integer(criteria.list().size());
		criteria.setFirstResult((pageNo-1)*pageSize);
		criteria.setMaxResults(pageSize);
		List<?> res = criteria.list();
		result.put("count", total);
		result.put("result", res);
		return result;
	}

}
