package com.example.ssh.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.example.ssh.Pojo.Class;
import com.example.ssh.Pojo.School;
import com.example.ssh.Pojo.Student;
import com.example.ssh.Service.CourseService;

public class StudentDao extends HibernateDaoSupport{
	
	/**
	 * 所有信息的个数
	 * @return
	 */
	public int findAllCount() {
		// TODO Auto-generated method stub
		String hpl ="select  count(*) from Student";
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
	public List<Student> findByPage(int begin, int pageSize) {
		DetachedCriteria criteria =DetachedCriteria.forClass(Student.class);
		List<Student> list = this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		for (int i = 0; i < list.size(); i++) {
			int c_id= list.get(i).getClass1().getC_id();
			System.out.println("  "+c_id);
			com.example.ssh.Pojo.Class class1 = this.getHibernateTemplate().get(com.example.ssh.Pojo.Class.class, c_id);
			School school =this.getHibernateTemplate().get(School.class, class1.getSchool().getS_id());
			class1.setSchool(school);
			System.out.println("  "+school.getS_name());
			list.get(i).setClass1(class1);
			
		}
		return list;
		
		
	}
	
	/**
	 * 搜索的查询总数
	 * @param s_search
	 * @return
	 */
	public int findSearchCount(String s_search) {
		// TODO Auto-generated method stub
		String hpl ="select  count(*) from Student where st_name like '%"+s_search+"%' or st_address like '%"+s_search+"%' ";
		List <Long> list = this.getHibernateTemplate().find(hpl);
		if(list.size()>0){
			System.out.println("/*********"+list.get(0).intValue()+"********/");
			System.out.print("搜索结果："+list.get(0).intValue());
			return list.get(0).intValue();
		}
		return 0;
	}
	/**
	 * 搜索的查询
	 * @param s_search
	 * @return
	 */
	public List<Student> findByPageSreach(int begin, int pageSize, String s_search) {
		
		String hqlString = "FROM  Student  WHERE st_name LIKE '%"+s_search+"%' OR st_address LIKE '%"+s_search+"%'";
//		List<Student> list = this.getHibernateTemplate().executeFind( new HibernateCallback ( ) {
//            public Object doInHibernate ( Session session ) throws HibernateException, SQLException {
//                Query query = session.createQuery ( hqlString ) ;
//                query.setMaxResults(pageSize);
//        		query.setFirstResult(begin);
//                List list = query.list ( ) ;
//                return list ;
//            }});
		
        // 获取被Spring托管的session
        
		String hql = "FROM  Student  WHERE st_name LIKE '%"+s_search+"%' OR st_address LIKE '%"+s_search+"%'";
		List<Student> list = new  ArrayList<Student>();
		Query query = this.getHibernateTemplate().getSessionFactory().openSession().createQuery(hqlString);
		query.setMaxResults(pageSize);
		query.setFirstResult(begin); 
		list = query.list();
		
        for (int i = 0; i < list.size(); i++) {
    			int c_id= list.get(i).getClass1().getC_id();
    			System.out.println("  "+c_id);
    			com.example.ssh.Pojo.Class class1 = this.getHibernateTemplate().get(com.example.ssh.Pojo.Class.class, c_id);
    			School school =this.getHibernateTemplate().get(School.class, class1.getSchool().getS_id());
    			class1.setSchool(school);
    			System.out.println("  "+school.getS_name());
    			list.get(i).setClass1(class1);
    		}
		
		
		return list;
	}
	/**新增学生的信息*/
	public void add(Student student) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(student);
	}
	/**根据学生的id来返回学生对象*/
	public Student finById(Integer st_id) {
		// TODO Auto-generated method stub
		Student student = this.getHibernateTemplate().get(Student.class, st_id);
		com.example.ssh.Pojo.Class class1 = this.getHibernateTemplate().get(com.example.ssh.Pojo.Class.class, student.getClass1().getC_id());
		School school =this.getHibernateTemplate().get(School.class, class1.getSchool().getS_id());
		class1.setSchool(school);
		System.out.println("  "+school.getS_name());
		student.setClass1(class1);
		return student;
	}
	public com.example.ssh.Pojo.Class findById_Class(Integer s_id) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(com.example.ssh.Pojo.Class.class, s_id);
	}
	/**更新学生信息*/
	public void updata(Student student) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(student);
	}
	/**获取班级的列表*/
	public List<com.example.ssh.Pojo.Class> getClassList(Integer s_id) {
		Session session = null;
        // 获取被Spring托管的session
        session = this.getHibernateTemplate().getSessionFactory().openSession();
		String hqlString = "FROM  Class where s_id ="+s_id+"";
		List<com.example.ssh.Pojo.Class> list = new  ArrayList<com.example.ssh.Pojo.Class>();
		Query query = session.createQuery(hqlString); 
		list = query.list();
		System.out.println("--------->"+list.size());
		session.close();
		// TODO Auto-generated method stub
		return list;
	}
	public List<School> getSchoolList() {
		Session session = null;
        // 获取被Spring托管的session
        session = this.getHibernateTemplate().getSessionFactory().openSession();
		String hqlString = "FROM  School ";
		List<School> list = new  ArrayList<School>();
		Query query = session.createQuery(hqlString); 
		list = query.list();
		System.out.println("--------->"+list.size());
		session.close();
		return list;
	}
	public void delete(Student student) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(student);
	}

}


