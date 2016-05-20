package com.qjs.dao.impl;

import global.tool.Constant;
import global.tool.QueryItems;
import global.tool.QueryObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.Type;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.qjs.dao.Disease_sidewalkDAO;
import com.qjs.entity.Disease_sidewalk;
import com.qjs.entity.Navigation_bar;

public class Disease_sidewalkDAOImpl extends HibernateDaoSupport implements Disease_sidewalkDAO {
	
	private Session getNewSession(){
		return super.getHibernateTemplate().getSessionFactory().getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<?> getAll() {
		String hql = "from Disease_sidewalk";
		
		Query qobj = this.getNewSession().createQuery(hql);
		return (List<Navigation_bar>)qobj.list();
	}

	@Override
	public Object addEntity(Object obj) {
		return super.getHibernateTemplate().save((Disease_sidewalk)obj);
	}

	@Override
	public int deleteEntityByProperty(String propertyName, Object value, Type type) {
		String hql = "delete Disease_sidewalk as u where u."+propertyName+"=?";
		Query qobj = this.getNewSession().createQuery(hql);
		qobj.setParameter(0, value, type);
		int count = qobj.executeUpdate();
		return count;
	}

	@Override
	public void updateEntity(Object obj) {
		super.getHibernateTemplate().update((Disease_sidewalk)obj);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<?> findEntityListByProperty(String propertyName, Object value, Type type) {
		String hql = "from Disease_sidewalk as u where u."+propertyName+"=?";
		Query qobj = this.getNewSession().createQuery(hql);
		qobj.setParameter(0, value, type);
		return (List<Disease_sidewalk>)qobj.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<?> findEntityListByPropertyWithSql(String propertyName) {
		String sql = "select * from Disease_sidewalk where bridge_code=?";
		SQLQuery qobj = this.getNewSession().createSQLQuery(sql);
		qobj.setParameter(0, propertyName);
		return (List<Disease_sidewalk>)qobj.list();
	}

	@Override
	public Map<?,?> findEntityListByProperties(QueryItems qi) {
		Map<String,Object> result = new HashMap<String,Object>();
		Criteria criteria = this.getNewSession().createCriteria(Disease_sidewalk.class);
		
		for(QueryObject qo:qi.getQueryObjects()){
			if (qo.getPropertyName().equals("bg_id")) {
				criteria.add(Restrictions.like(qo.getPropertyName(), "%"+qo.getObject()+"%"));
			}
			else {
				criteria.add(Restrictions.eq(qo.getPropertyName(), qo.getObject()));
			}
		}
		
		for(QueryObject qo:qi.getQueryObjects()){
			if (qo.getPropertyName().equals("rg_feature")) {
				criteria.add(Restrictions.like(qo.getPropertyName(), "%"+qo.getObject()+"%"));
			}
			else {
				criteria.add(Restrictions.eq(qo.getPropertyName(), qo.getObject()));
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
		
		Integer total = new Integer(criteria.list().size());
		if (qi.getPageNo() != null && qi.getPageNo() == -1) {
			
		} else {
			criteria.setFirstResult((pageNo-1)*pageSize);
			criteria.setMaxResults(pageSize);
		}
		List<?> res = criteria.list();
		result.put("count", total);
		result.put("result", res);
		return result;
	}

	@Override
	public Map<?,?> findAllEntityListByProperties(QueryItems qi) {
		Criteria criteria = this.getNewSession().createCriteria(Disease_sidewalk.class);
		
		Integer total = new Integer(criteria.list().size());
		List<?> res = criteria.list();
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("count", total);
		result.put("result", res);
		return result;
	}

	@Override
	public Map<?,?> findEntityListByOwner(QueryItems qi) {
		Criteria criteria = this.getNewSession().createCriteria(Disease_sidewalk.class);
		
		int pageNo=1;
		if(qi.getPageNo()!=null&&qi.getPageNo()>0){
			pageNo = qi.getPageNo();
		}
		int pageSize=Constant.PAGE_SIZE;
		if(qi.getPageSize()!=null&&qi.getPageSize()>0){
			pageSize = qi.getPageSize();
		}
		Map<String,Object> result = new HashMap<String,Object>();
		Integer total = new Integer(criteria.list().size());
		if(qi.getPageNo()!=null&&qi.getPageNo()==-1){
			
		}else{
			criteria.setFirstResult((pageNo-1)*pageSize);
			criteria.setMaxResults(pageSize);
		}
		
		List<?> res = criteria.list();
		result.put("count", total);
		result.put("result", res);
		return result;
	}
}
