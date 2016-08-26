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

import com.qjs.dao.Disease_bedDAO;
import com.qjs.entity.Disease_bed;
import com.qjs.entity.Navigation_bar;

public class Disease_bedDAOImpl extends HibernateDaoSupport implements Disease_bedDAO {
	
	private Session getNewSession(){
		return super.getHibernateTemplate().getSessionFactory().getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<?> getAll() {
		String hql = "from Disease_bed";
		
		Query qobj = this.getNewSession().createQuery(hql);
		return (List<Navigation_bar>)qobj.list();
	}

	@Override
	public Object addEntity(Object obj) {
		return super.getHibernateTemplate().save((Disease_bed)obj);
	}

	@Override
	public int deleteEntityByProperty(String propertyName, Object value, Type type) {
		String hql = "delete Disease_bed as u where u."+propertyName+"=?";
		Query qobj = this.getNewSession().createQuery(hql);
		qobj.setParameter(0, value, type);
		int count = qobj.executeUpdate();
		return count;
	}

	@Override
	public void updateEntity(Object obj) {
		super.getHibernateTemplate().update((Disease_bed)obj);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<?> findEntityListByProperty(String propertyName, Object value, Type type) {
		String hql = "from Disease_bed as u where u."+propertyName+"=?";
		Query qobj = this.getNewSession().createQuery(hql);
		qobj.setParameter(0, value, type);
		return (List<Disease_bed>)qobj.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<?> findEntityListByPropertyWithSql(String propertyName) {
		String sql = "select * from Disease_bed where bridge_code=?";
		SQLQuery qobj = this.getNewSession().createSQLQuery(sql);
		qobj.setParameter(0, propertyName);
		return (List<Disease_bed>)qobj.list();
	}

	@Override
	public Map<?,?> findEntityListByProperties(QueryItems qi) {
		Map<String,Object> result = new HashMap<String,Object>();
		Criteria criteria = this.getNewSession().createCriteria(Disease_bed.class);
		
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
		Criteria criteria = this.getNewSession().createCriteria(Disease_bed.class);
		
		Integer total = new Integer(criteria.list().size());
		List<?> res = criteria.list();
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("count", total);
		result.put("result", res);
		return result;
	}

	@Override
	public Map<?,?> findEntityListByOwner(QueryItems qi) {
		Criteria criteria = this.getNewSession().createCriteria(Disease_bed.class);
		
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

	@SuppressWarnings("unchecked")
	@Override
	public List<?> findEntityListByPropertySort(String propertyName, String sortStr, Object value, Type type) {
		String hql = "from Disease_bed as u where u."+propertyName+"=? order by "+sortStr;
		Query qobj = this.getNewSession().createQuery(hql);
		qobj.setParameter(0, value, type);
		return (List<Disease_bed>)qobj.list();
	}
}
