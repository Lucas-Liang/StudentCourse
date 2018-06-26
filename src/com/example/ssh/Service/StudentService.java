package com.example.ssh.Service;

import java.util.List;

import com.example.ssh.Dao.CourseDao;
import com.example.ssh.Dao.StudentDao;
import com.example.ssh.Pojo.IndexPage;
import com.example.ssh.Pojo.School;
import com.example.ssh.Pojo.Student;

public class StudentService {
	
	private StudentDao studentDao;

	
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	/**
	 * ∑÷“≥≤È—Ø
	 * @param indexPage
	 * @return
	 */
	public IndexPage<Student> findByPage(Integer indexPage) {
		// TODO Auto-generated method stub
		IndexPage<Student> inPage =new IndexPage<Student>();
		inPage.setIndexPage(indexPage);
		int pageSize=3;
		inPage.setPageSize(pageSize);
		int pageCount =studentDao.findAllCount();
		inPage.setPageCount(pageCount);
		double num = pageCount;
		Double indexCount =  Math.ceil(num/pageSize);
		inPage.setIndexCount(indexCount.intValue());
		int begin = (indexPage-1)*pageSize;
		List<Student> list = studentDao.findByPage(begin,pageSize);
		inPage.setList(list);
		return inPage;
	}
	public IndexPage<Student> findBySearch(String s_search, Integer indexPage) {
		// TODO Auto-generated method stub
		IndexPage<Student> inPage =new IndexPage<Student>();
		inPage.setIndexPage(indexPage);
		int pageSize=3;
		inPage.setPageSize(pageSize);
		int pageCount =studentDao.findSearchCount(s_search);
		inPage.setPageCount(pageCount);
		double num = pageCount;
		Double indexCount =  Math.ceil(num/pageSize);
		inPage.setIndexCount(indexCount.intValue());
		int begin = (indexPage-1)*pageSize;
		List<Student> list = studentDao.findByPageSreach(begin,pageSize,s_search);
		inPage.setList(list);
		System.out.println("----------->"+inPage);
		return inPage;
	}
	public void add(Student class1) {
		// TODO Auto-generated method stub
		studentDao.add(class1);
		
	}
	public Student findById(Integer s_id) {
		// TODO Auto-generated method stub
		return studentDao.finById(s_id);
	}
	public void updata(Student class1) {
		// TODO Auto-generated method stub
		System.out.println(class1);
		studentDao.updata(class1);
		
	}
	public List<com.example.ssh.Pojo.Class> getClassList(Integer s_id) {
		// TODO Auto-generated method stub
		return studentDao.getClassList(s_id);
	}
	public List<School> getSchoolList() {
		// TODO Auto-generated method stub
		return studentDao.getSchoolList();
	}
	public void delete(Student student) {
		// TODO Auto-generated method stub
		studentDao.delete(student);
	}
	

}

