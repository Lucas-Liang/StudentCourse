package com.example.ssh.Action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.ssh.Pojo.Class;
import com.example.ssh.Pojo.IndexPage;
import com.example.ssh.Pojo.School;
import com.example.ssh.Pojo.Student;
import com.example.ssh.Service.CourseService;
import com.example.ssh.Service.StudentService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class StudentAction extends ActionSupport implements ModelDriven<Student>{
	
	private Student student =new Student();
	private StudentService studentService;
	private Integer IndexPage =1;
	
	@Override
	public Student getModel() {
		// TODO Auto-generated method stub
		return student;
	}
	public void setIndexPage(Integer indexPage) {
		IndexPage = indexPage;
	}
	
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	
	public String findAll() {
		IndexPage<Student> index = studentService.findByPage(IndexPage);
		ActionContext.getContext().getValueStack().push(index);
		return "findAll";
	}
	public String search() throws UnsupportedEncodingException {
		String c = ServletActionContext.getRequest().getParameter("st_search");   //获取用户名  
		String c_search = new String(c.getBytes("iso-8859-1"),"UTF-8");
		System.out.println("当前搜索--》"+c_search);
		IndexPage<Student> search = studentService.findBySearch(c_search,IndexPage);
		ActionContext.getContext().getValueStack().push(search);
		return "search";
	}
	public String save() {
		String c = ServletActionContext.getRequest().getParameter("c_id");   //获取用户名  
//		String c_search = new String(c.getBytes("iso-8859-1"),"UTF-8");
		com.example.ssh.Pojo.Class class1 =new com.example.ssh.Pojo.Class();
		class1.setC_id(Integer.parseInt(c));
		student.setClass1(class1);
		studentService.add(student);
		IndexPage<Student> index = studentService.findByPage(IndexPage);
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
		String s = ServletActionContext.getRequest().getParameter("st_id");   //获取用户名  
		int c_id = Integer.parseInt(s);
		//		String s_search = new String(s.getBytes("iso-8859-1"),"UTF-8");
		student = studentService.findById(c_id);
		return "edit";
	}
	public String update() {
		String c = ServletActionContext.getRequest().getParameter("c_id");   //获取用户名  
		com.example.ssh.Pojo.Class class1 =new com.example.ssh.Pojo.Class();
		class1.setC_id(Integer.parseInt(c));
		student.setClass1(class1);
		studentService.updata(student);
		IndexPage<Student> index = studentService.findByPage(IndexPage);
		ActionContext.getContext().getValueStack().push(index);
		return "findAll";
	}
	
	public void  AjaxSchoolList() throws IOException{
//		com.example.ssh.Util.JsonUitl.writeJson(classService.getSchoolList().toString());//获取省份集合
		try {
		 JSONArray jsonArray = new JSONArray();
		 List<School> list = studentService.getSchoolList();
		 for (int i = 0; i < list.size(); i++) {
			 JSONObject jsonObject = new JSONObject();
			 jsonObject.put("s_id", list.get(i).getS_id());
			 jsonObject.put("s_name", list.get(i).getS_name());
			 jsonArray.put(i, jsonObject);
		}
		
		 ServletActionContext.getResponse().setHeader("Cache-Control", "no-cache"); //取消浏览器缓存
		 ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
	     ServletActionContext.getResponse().getWriter().write(jsonArray.toString());
		 ServletActionContext.getResponse().getWriter().flush();
		 ServletActionContext.getResponse().getWriter().close();
		
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void  AjaxClassList() throws IOException{
//		com.example.ssh.Util.JsonUitl.writeJson(classService.getSchoolList().toString());//获取省份集合
		String s = ServletActionContext.getRequest().getParameter("s_id");   //获取用户名  
		int c_id = Integer.parseInt(s);
		try {
		 JSONArray jsonArray = new JSONArray();
		 List<com.example.ssh.Pojo.Class> list = studentService.getClassList(c_id);
		 for (int i = 0; i < list.size(); i++) {
			 JSONObject jsonObject = new JSONObject();
			 jsonObject.put("c_id", list.get(i).getC_id());
			 jsonObject.put("c_name", list.get(i).getC_name());
			 jsonArray.put(i, jsonObject);
		}
		
		 ServletActionContext.getResponse().setHeader("Cache-Control", "no-cache"); //取消浏览器缓存
		 ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
	     ServletActionContext.getResponse().getWriter().write(jsonArray.toString());
		 ServletActionContext.getResponse().getWriter().flush();
		 ServletActionContext.getResponse().getWriter().close();
		
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String delete(){
		studentService.delete(student);
		IndexPage<Student> index = studentService.findByPage(IndexPage);
		ActionContext.getContext().getValueStack().push(index);
		return "findAll";
	}
	

}

