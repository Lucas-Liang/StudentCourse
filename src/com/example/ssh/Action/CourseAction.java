package com.example.ssh.Action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTML;

import org.apache.struts2.ServletActionContext;
import org.hibernate.classic.Session;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.ssh.Pojo.Course;
import com.example.ssh.Pojo.IndexPage;
import com.example.ssh.Pojo.User;
import com.example.ssh.Service.CourseService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.org.apache.bcel.internal.generic.NEW;



public class CourseAction extends ActionSupport implements ModelDriven<Course>{
	
	private Course course =new Course();
	private CourseService courseService;
	private Integer IndexPage =1;
	
	@Override
	public Course getModel() {
		// TODO Auto-generated method stub
		return course;
	}
	public void setIndexPage(Integer indexPage) {
		IndexPage = indexPage;
	}
	public void setcourseService(CourseService courseService) {
		this.courseService = courseService;
	}
	/**
	 * 查看所有的课程信息
	 * @return
	 */
	public String findAll() {
		IndexPage<Course> index = courseService.findByPage(IndexPage);
		ActionContext.getContext().getValueStack().push(index);
		return "findAll";
	}
	/**
	 * 搜索课程信息
	 * @return
	 */
	public String search() throws UnsupportedEncodingException {
		String c = ServletActionContext.getRequest().getParameter("c_search");   //获取用户名  
		String c_search = new String(c.getBytes("iso-8859-1"),"UTF-8");
		IndexPage<Course> search = courseService.findBySearch(c_search,IndexPage);
		ActionContext.getContext().getValueStack().push(search);
		return "search";
	}
	/**
	 * 保存课程信息(老师权限)
	 * @return
	 */
	public String save() {
		
		User user = (User)ServletActionContext.getRequest().getAttribute("user");
		course.setUser(user);
		courseService.add(course);
		IndexPage<Course> index = courseService.findByPage(IndexPage);
		ActionContext.getContext().getValueStack().push(index);
		return "findAll";
	}
	/**
	 * 跳转到添加课程的页面(老师)
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
		String s = ServletActionContext.getRequest().getParameter("c_id");     
		int c_id = Integer.parseInt(s);
		course = courseService.findById(c_id);
		return "edit";
	}
	public String update() {
		courseService.updata(course);
		IndexPage<Course> index = courseService.findByPage(IndexPage);
		ActionContext.getContext().getValueStack().push(index);
		return "findAll";
	}
	
	public String delete() {
//		String s = ServletActionContext.getRequest().getParameter("c_id");   //获取用户名  
//		int c_id = Integer.parseInt(s);
		courseService.delete(course);
		IndexPage<Course> index = courseService.findByPage(IndexPage);
		ActionContext.getContext().getValueStack().push(index);
		return "findAll";
	}
	
	

}
