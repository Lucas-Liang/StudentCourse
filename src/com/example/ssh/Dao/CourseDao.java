package com.example.ssh.Dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.example.ssh.Pojo.Course;
import com.example.ssh.Pojo.User;
import com.example.ssh.Service.SchoolService;


public class CourseDao extends HibernateDaoSupport{
	
	/**
	 * 获取所有课程信息的数量
	 * @return
	 */
	public int findAllCount() {
		// TODO Auto-generated method stub
		String hpl ="select  count(*) from Course";
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
	public List<Course> findByPage(int begin, int pageSize) {
		DetachedCriteria criteria =DetachedCriteria.forClass(Course.class);
		List<Course> list = this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		
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
		String hpl ="select  count(*) from Class where c_name like '%"+s_search+"%' or c_info like '%"+s_search+"%' ";
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
	public List<Course> findByPageSreach(int begin, int pageSize, String c_search) {
		// TODO Auto-generated method stub
		Session session = null;
        // 获取被Spring托管的session
        session = this.getHibernateTemplate().getSessionFactory().openSession();
		String hqlString = "FROM  Course  WHERE c_name LIKE '%"+c_search+"%' OR c_info LIKE '%"+c_search+"%'";
		List<Course> list = new  ArrayList<Course>();
		Query query = session.createQuery(hqlString);
		query.setMaxResults(pageSize);
		query.setFirstResult(begin); 
		list = query.list();
		
		for (int i = 0; i < list.size(); i++) {
			User user = (User)ServletActionContext.getRequest().getAttribute("user");
			list.get(i).setUser(user);
		
		}
		
		return list;
	}
	
	public void add(Course course) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(course);
	}
	
	public Course finById(Integer c_id) {
		// TODO Auto-generated method stub
		Course course = this.getHibernateTemplate().get(Course.class, c_id);
		return course;
	}
	
	public void updata(Course course) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(course);
	}
	
	public void delete(Course class1) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(class1);
	}

}

