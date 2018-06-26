package com.example.ssh.Service;

import java.util.List;

import com.example.ssh.Dao.SchoolDao;
import com.example.ssh.Pojo.School;
import com.example.ssh.Pojo.IndexPage;
public class SchoolService {
	private SchoolDao schoolDao;

	public void setSchoolDao(SchoolDao schoolDao) {
		this.schoolDao = schoolDao;
	}
	/**
	 * ∑÷“≥≤È—Ø
	 * @param indexPage
	 * @return
	 */
	public IndexPage<School> findByPage(Integer indexPage) {
		// TODO Auto-generated method stub
		IndexPage<School> inPage =new IndexPage<School>();
		inPage.setIndexPage(indexPage);
		int pageSize=3;
		inPage.setPageSize(pageSize);
		int pageCount =schoolDao.findAllCount();
		inPage.setPageCount(pageCount);
		double num = pageCount;
		Double indexCount =  Math.ceil(num/pageSize);
		inPage.setIndexCount(indexCount.intValue());
		int begin = (indexPage-1)*pageSize;
		List<School> list = schoolDao.findByPage(begin,pageSize);
		inPage.setList(list);
		System.out.println("----------->"+list.size());
		return inPage;
	}
	public IndexPage<School> findBySearch(String s_search, Integer indexPage) {
		// TODO Auto-generated method stub
		IndexPage<School> inPage =new IndexPage<School>();
		inPage.setIndexPage(indexPage);
		int pageSize=3;
		inPage.setPageSize(pageSize);
		int pageCount =schoolDao.findSearchCount(s_search);
		inPage.setPageCount(pageCount);
		
		double num = pageCount;
		Double indexCount =  Math.ceil(num/pageSize);
		inPage.setIndexCount(indexCount.intValue());
		
		int begin = (indexPage-1)*pageSize;
		List<School> list = schoolDao.findByPageSreach(begin,pageSize,s_search);
		inPage.setList(list);
		System.out.println("----------->"+inPage);
		return inPage;
	}
	public void add(School school) {
		// TODO Auto-generated method stub
		schoolDao.add(school);
		
	}
	public School findById(Integer s_id) {
		// TODO Auto-generated method stub
		return schoolDao.finById(s_id);
	}
	public void updata(School school) {
		// TODO Auto-generated method stub
		System.out.println(school);
		schoolDao.updata(school);
		
	}
	public void delete(School school) {
		// TODO Auto-generated method stub
		schoolDao.delete(school);
	}
	

}
