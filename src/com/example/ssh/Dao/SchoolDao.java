package com.example.ssh.Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.example.ssh.Pojo.School;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class SchoolDao  extends HibernateDaoSupport{
	
	/**
	 * 所有信息的个数
	 * @return
	 */
	public int findAllCount() {
		// TODO Auto-generated method stub
		String hpl ="select  count(*) from School";
		List <Long> list = this.getHibernateTemplate().find(hpl);
		if(list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}
	/**
	 * 根据页面数来查询数据
	 * @param begin
	 * @param pageSize
	 * @return
	 */
	public List<School> findByPage(int begin, int pageSize) {
		DetachedCriteria criteria =DetachedCriteria.forClass(School.class);
		List<School> list = this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		return list;
		// TODO Auto-generated method stub
		
	}
	/**
	 * 搜索的查询总数
	 * @param s_search
	 * @return
	 */
	public int findSearchCount(String s_search) {
		// TODO Auto-generated method stub
		String hpl ="select  count(*) from School where s_name like '%"+s_search+"%' or s_address like '%"+s_search+"%' ";
		List <Long> list = this.getHibernateTemplate().find(hpl);
		if(list.size()>0){
			System.out.println("/*********"+list.get(0).intValue()+"********/");
			return list.get(0).intValue();
		}
		return 0;
	}
	/**
	 * 搜索的查询
	 * @param s_search
	 * @return
	 */
	public List<School> findByPageSreach(int begin, int pageSize, String s_search) {
		// TODO Auto-generated method stub
		Session session = null;
        // 获取被Spring托管的session
        session = this.getHibernateTemplate().getSessionFactory().openSession();
		String hqlString = "FROM School  WHERE s_name LIKE '%"+s_search+"%' OR s_address LIKE '%"+s_search+"%'";
		List<School> list = new  ArrayList<School>();
		Query query = session.createQuery(hqlString);
		query.setMaxResults(pageSize);
		query.setFirstResult(begin); 
		list = query.list();
		return list;
	}
	
	public void add(School school) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(school);
	}
	
	public School finById(Integer s_id) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(School.class, s_id);
	}
	
	public void updata(School school) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(school);
	}
	public void delete(School school) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(school);
	}

}
