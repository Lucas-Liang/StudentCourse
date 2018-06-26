package com.example.ssh.Service;

import java.util.List;

import com.example.ssh.Dao.CourseDao;
import com.example.ssh.Dao.SchoolDao;
import com.example.ssh.Pojo.Course;
import com.example.ssh.Pojo.IndexPage;


public class CourseService {
	private CourseDao courseDao;

	public void setcourseDao(CourseDao courseDao) {
		this.courseDao = courseDao;
	}
	/**
	 * ∑÷“≥≤È—Ø
	 * @param indexPage
	 * @return
	 */
	public IndexPage<Course> findByPage(Integer indexPage) {
		// TODO Auto-generated method stub
		IndexPage<Course> inPage =new IndexPage<Course>();
		inPage.setIndexPage(indexPage);
		int pageSize=3;
		inPage.setPageSize(pageSize);
		int pageCount =courseDao.findAllCount();
		inPage.setPageCount(pageCount);
		double num = pageCount;
		Double indexCount =  Math.ceil(num/pageSize);
		inPage.setIndexCount(indexCount.intValue());
		int begin = (indexPage-1)*pageSize;
		List<Course> list = courseDao.findByPage(begin,pageSize);
		inPage.setList(list);
		return inPage;
	}
	public IndexPage<Course> findBySearch(String s_search, Integer indexPage) {
		// TODO Auto-generated method stub
		IndexPage<Course> inPage =new IndexPage<Course>();
		inPage.setIndexPage(indexPage);
		int pageSize=3;
		inPage.setPageSize(pageSize);
		int pageCount =courseDao.findSearchCount(s_search);
		inPage.setPageCount(pageCount);
		double num = pageCount;
		Double indexCount =  Math.ceil(num/pageSize);
		inPage.setIndexCount(indexCount.intValue());
		int begin = (indexPage-1)*pageSize;
		List<Course> list = courseDao.findByPageSreach(begin,pageSize,s_search);
		inPage.setList(list);
		System.out.println("----------->"+inPage);
		return inPage;
	}
	public void add(Course course) {
		// TODO Auto-generated method stub
		courseDao.add(course);
	}
	public Course findById(Integer c_id) {
		// TODO Auto-generated method stub
		return courseDao.finById(c_id);
	}
	public void updata(Course course) {
		// TODO Auto-generated method stub
		courseDao.updata(course);
	}
	public void delete(Course course) {
		// TODO Auto-generated method stub
		courseDao.delete(course);
	}
	

}
