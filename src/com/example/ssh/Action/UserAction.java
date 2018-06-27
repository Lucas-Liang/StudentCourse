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
		System.out.println("/**********��¼**********/");
		User user = userService.login(users);
		ActionContext.getContext().getSession().clear();
		if(user==null){
//			��¼ʧ��
			this.addActionError("�û�����������󣡣�");
			return "Error";
		}else {
			if(user.getU_power()==0&&user.getU_power()!=null){
//				��ʦ�û��ĵ�¼�Ľ���
				ActionContext.getContext().getSession().put("User",user);
				return "Teacher";
			}
//				ѧ���û��ĵ�¼�Ľ���
			ActionContext.getContext().getSession().put("User",user);
			return "Student";
		}
	}
	public String save(){
		System.out.println("/**********����**********/");
		boolean rs = userService.save(users);
		if(rs){
			return "Error";
		}else {
			return "Error";
		}
	}
	public String update(){
		System.out.println("/**********����**********/");
		userService.update(users);
		return "678";
	}
	public User findById(Integer u_id){
		System.out.println("/**********����ID����ѯ�û�������**********/");
		User user =userService.findById(u_id);
		return user;
	}

}
