package com.example.ssh.Action;

import com.example.ssh.Pojo.School;
import com.example.ssh.Service.SchoolService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.org.apache.bcel.internal.generic.NEW;

import javafx.concurrent.ScheduledService;

import java.io.UnsupportedEncodingException;

import org.apache.struts2.ServletActionContext;

import com.example.ssh.Pojo.IndexPage;;

public class SchoolAction extends ActionSupport implements ModelDriven<School> {
	private School school =new School();
	private SchoolService schoolService;
	private Integer IndexPage =1;
	public void setIndexPage(Integer indexPage) {
		IndexPage = indexPage;
	}
	@Override
	public School getModel() {
		// TODO Auto-generated method stub
		return school;
	}
	public void setSchoolService(SchoolService schoolService) {
		this.schoolService = schoolService;
	}
	public String findAll() {
		IndexPage<School> index = schoolService.findByPage(IndexPage);
		ActionContext.getContext().getValueStack().push(index);
		return "findAll";
	}
	public String search() throws UnsupportedEncodingException {
		String s = ServletActionContext.getRequest().getParameter("s_search");   //获取用户名  
		String s_search = new String(s.getBytes("iso-8859-1"),"UTF-8");
		IndexPage<School> search = schoolService.findBySearch(s_search,IndexPage);
		ActionContext.getContext().getValueStack().push(search);
		return "search";
	}
	public String save() {
		schoolService.add(school);
		IndexPage<School> index = schoolService.findByPage(IndexPage);
		ActionContext.getContext().getValueStack().push(index);
		return "findAll";
	}
	/**
	 * 跳转到添加学校的页面
	 * @return
	 */
	public String add() {
		return "add";
	}
	/**
	 * 根据Id来查询School
	 * @return
	 */
	public String edit() {
		String s = ServletActionContext.getRequest().getParameter("s_id");   //获取用户名  
		int s_id = Integer.parseInt(s);
		//		String s_search = new String(s.getBytes("iso-8859-1"),"UTF-8");
		school = schoolService.findById(s_id);
		return "edit";
	}
	public String update() {
		schoolService.updata(school);
		IndexPage<School> index = schoolService.findByPage(IndexPage);
		ActionContext.getContext().getValueStack().push(index);
		return "findAll";
	}
	public String delete(){
		schoolService.delete(school);
		IndexPage<School> index = schoolService.findByPage(IndexPage);
		ActionContext.getContext().getValueStack().push(index);
		return "findAll";
	}
	
}
