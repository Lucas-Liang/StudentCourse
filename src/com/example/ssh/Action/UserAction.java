package com.example.ssh.Action;

import org.springframework.ui.Model;

import com.example.ssh.Pojo.User;
import com.example.ssh.Service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


public class UserAction extends ActionSupport implements ModelDriven<User>{
	
	private User users = new User();
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return users;
	}
	
	public String login(){
		System.out.println("/**********登录**********/");
		User user = userService.login(users);
		ActionContext.getContext().getSession().clear();
		if(user==null){
//			登录失败
			this.addActionError("用户名和密码错误！！");
			return "Error";
		}else {
			if(user.getU_power()==0&&user.getU_power()!=null){
//				老师用户的登录的界面
				ActionContext.getContext().getSession().put("User",user);
				return "Teacher";
			}
//				学生用户的登录的界面
			ActionContext.getContext().getSession().put("User",user);
			return "Student";
		}
	}
	public String save(){
		System.out.println("/**********保存**********/");
		boolean rs = userService.save(users);
		if(rs){
			return "Error";
		}else {
			return "Error";
		}
	}
	public String update(){
		System.out.println("/**********更新**********/");
		userService.update(users);
		return "678";
	}
	public User findById(Integer u_id){
		System.out.println("/**********根据ID来查询用户的名称**********/");
		User user =userService.findById(u_id);
		return user;
	}

}
