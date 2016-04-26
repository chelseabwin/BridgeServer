package com.qjs.dao.impl;

import global.tool.Constant;
import global.tool.QueryItems;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.type.Type;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.qjs.dao.Base2DAO;
import com.qjs.entity.Base2;
import com.qjs.entity.Navigation_bar;

public class Base2DAOImpl extends HibernateDaoSupport implements Base2DAO {
	
	private Session getNewSession(){
		return super.getHibernateTemplate().getSessionFactory().getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<?> getAll() {
		String hql = "from Base2";
		
		Query qobj = this.getNewSession().createQuery(hql);
		return (List<Navigation_bar>)qobj.list();
	}

	@Override
	public Object addEntity(Object obj) {
		return super.getHibernateTemplate().save((Base2)obj);
	}

	@Override
	public int deleteEntityByProperty(String propertyName, Object value, Type type) {
		String hql = "delete Base2 as u where u."+propertyName+"=?";
		Query qobj = this.getNewSession().createQuery(hql);
		qobj.setParameter(0, value, type);
		int count = qobj.executeUpdate();
		return count;
	}

	@Override
	public void updateEntity(Object obj) {
		super.getHibernateTemplate().update((Base2)obj);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<?> findEntityListByProperty(String propertyName, Object value, Type type) {
		String hql = "from Base2 as u where u."+propertyName+"=?";
		Query qobj = this.getNewSession().createQuery(hql);
		qobj.setParameter(0, value, type);
		return (List<Base2>)qobj.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<?> findEntityListByPropertyWithSql(String propertyName) {
		String sql = "select * from Base2 where bridge_code=?";
		SQLQuery qobj = this.getNewSession().createSQLQuery(sql);
		qobj.setParameter(0, propertyName);
		return (List<Base2>)qobj.list();
	}

	@Override
	public Map<?,?> findEntityListByProperties(QueryItems qi) {
		Map<String,Object> result = new HashMap<String,Object>();
		Criteria criteria = this.getNewSession().createCriteria(Base2.class);
		
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
		Criteria criteria = this.getNewSession().createCriteria(Base2.class);
		
		Integer total = new Integer(criteria.list().size());
		List<?> res = criteria.list();
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("count", total);
		result.put("result", res);
		return result;
	}

	@Override
	public Map<?,?> findEntityListByOwner(QueryItems qi) {
		Criteria criteria = this.getNewSession().createCriteria(Base2.class);
		
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
