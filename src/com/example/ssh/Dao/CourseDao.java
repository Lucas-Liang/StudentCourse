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
	 * ��ȡ���пγ���Ϣ��������ѧ����
	 * @return
	 */
	public int findAllCount() {
		String hpl ="select  count(*) from Course";
		List <Long> list = this.getHibernateTemplate().find(hpl);
		if(list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}
	/**
	 * ��ȡ���пγ���Ϣ����������ʦ��
	 * @return
	 */
	public int findAllCountTeacher() {
		User user = (User)ServletActionContext.getRequest().getAttribute("user");
		String hpl ="select  count(*) from Course where u_id="+user.getU_id();
		List <Long> list = this.getHibernateTemplate().find(hpl);
		if(list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}
	/**
	 * ����ҳ��������ѯ���ݣ�ѧ����
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
	 * ����ҳ��������ѯ���ݣ���ʦ��
	 * @param begin
	 * @param pageSize
	 * @return
	 */
	public List<Course> findByPageTeacher(int begin, int pageSize) {
		User user = (User)ServletActionContext.getRequest().getAttribute("user");
		DetachedCriteria criteria =DetachedCriteria.forClass(Course.class);
		List<Course> list = this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		List<Course> list1 =new ArrayList<Course>();
		for(int i = 0;i<list.size();i++){
			if(list.get(i).getUser().getU_id()==user.getU_id()){
				list1.add(list.get(i));
			}
		}
		return list1;
	}
	/**
	 * �����Ĳ�ѯ������ѧ����
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
	 * �����Ĳ�ѯ��������ʦ��
	 * @param s_search
	 * @return
	 */
	public int findSearchCountTeacher(String s_search) {
		// TODO Auto-generated method stub
		User user = (User)ServletActionContext.getRequest().getAttribute("user");
		String hpl ="select  count(*) from Class where c_name like '%"+s_search+"%' or c_info like '%"+s_search+"%' and u_id="+user.getU_id();
		List <Long> list = this.getHibernateTemplate().find(hpl);
		if(list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}
	/**
	 * �����Ĳ�ѯ(ѧ��)
	 * @param s_search
	 * @return
	 */
	public List<Course> findByPageSreach(int begin, int pageSize, String c_search) {
		// TODO Auto-generated method stub
		Session session = null;
        // ��ȡ��Spring�йܵ�session
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
	/**
	 * �����Ĳ�ѯ(��ʦ)
	 * @param s_search
	 * @return
	 */
	public List<Course> findByPageSreachTeacher(int begin, int pageSize, String c_search) {
		User user = (User)ServletActionContext.getRequest().getAttribute("user");
		Session session = null;
        // ��ȡ��Spring�йܵ�session
        session = this.getHibernateTemplate().getSessionFactory().openSession();
		String hqlString = "FROM  Course  WHERE c_name LIKE '%"+c_search+"%' OR c_info LIKE '%"+c_search+"%' and u_id="+user.getU_id();
		List<Course> list = new  ArrayList<Course>();
		Query query = session.createQuery(hqlString);
		query.setMaxResults(pageSize);
		query.setFirstResult(begin); 
		list = query.list();
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setUser(user);
		}
		
		return list;
	}
	/**����γ���Ϣ*/
	public void add(Course course) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(course);
	}
	
	public Course finByIdCourse(Integer c_id) {
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

