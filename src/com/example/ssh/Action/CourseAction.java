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
	 * �鿴���еĿγ���Ϣ(ѧ��)
	 * @return
	 */
	public String findAllStudent() {
		IndexPage<Course> index = courseService.findByPageStudent(IndexPage);
		ActionContext.getContext().getValueStack().push(index);
		return "findAllStudent";
	}
	/**
	 * �鿴���еĿγ���Ϣ(��ǰ��ʦ���˻���ʦ)
	 * @return
	 */
	public String findAllTeacher() {
		IndexPage<Course> index = courseService.findByPageTeacher(IndexPage);
		ActionContext.getContext().getValueStack().push(index);
		return "findAllTeacher";
	}
	/**
	 * �����γ���Ϣ��ѧ����
	 * @return
	 */
	public String search() throws UnsupportedEncodingException {
		String c = ServletActionContext.getRequest().getParameter("c_search");   //��ȡ�û���  
		String c_search = new String(c.getBytes("iso-8859-1"),"UTF-8");
		IndexPage<Course> search = courseService.findBySearch(c_search,IndexPage);
		ActionContext.getContext().getValueStack().push(search);
		return "Search";
	}
	/**
	 * �����γ���Ϣ����ʦ��
	 * @return
	 */
	public String searchTeacher() throws UnsupportedEncodingException {
		String c = ServletActionContext.getRequest().getParameter("c_search");   //��ȡ�û���  
		String c_search = new String(c.getBytes("iso-8859-1"),"UTF-8");
		IndexPage<Course> search = courseService.findBySearchTeacher(c_search,IndexPage);
		ActionContext.getContext().getValueStack().push(search);
		return "SearchTeacher";
	}
	
	
	/**
	 * ����γ���Ϣ(��ʦȨ��)
	 * @return
	 */
	public String saveCourse() {
		User user =(User)ServletActionContext.getRequest().getSession().getAttribute("User");
		course.setUser(user);
		course.setC_numChoice(0);
		course.setC_statu("δ����");
		courseService.add(course);
		IndexPage<Course> index = courseService.findByPageTeacher(IndexPage);
		ActionContext.getContext().getValueStack().push(index);
		return "findAllTeacher";
	}
	/**
	 * ��ת����ӿγ̵�ҳ��(��ʦ)
	 * @return
	 */
	public String add() {
		return "add";
	}
	/**
	 * ����Id����ѯ�γ�
	 * @return
	 */
	public String editCourse() {
		String s = ServletActionContext.getRequest().getParameter("c_id");     
		int c_id = Integer.parseInt(s);
		course = courseService.findByIdCourse(c_id);
		return "edit";
	}
	/**
	 * �޸Ŀγ���Ϣ����ʦȨ�ޣ�
	 * @return
	 */
	public String updateCourse() {
		User user =(User)ServletActionContext.getRequest().getSession().getAttribute("User");
		course.setUser(user);
		courseService.updata(course);
		IndexPage<Course> index = courseService.findByPageTeacher(IndexPage);
		ActionContext.getContext().getValueStack().push(index);
		return "findAllTeacher";
	}
	/**
	 * ɾ���γ���Ϣ����ʦȨ�ޣ�
	 * @return
	 */
	public String delete() {
		courseService.delete(course);
		IndexPage<Course> index = courseService.findByPageTeacher(IndexPage);
		ActionContext.getContext().getValueStack().push(index);
		return "findAllTeacher";
	}
	
	

}
