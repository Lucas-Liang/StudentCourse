package com.example.ssh.Pojo;

import java.util.Set;

public class User {
	private Integer u_id;//�û�id
	private String u_usename;//�û���
	private String u_password;//����
	private Integer u_power;//Ȩ��
	private String u_powercode;//Ȩ����Ȩ��
	private String u_name;//����
	private Set<Course> course;
	private Set<ChoiceCourseInfo> choiceCourseInfo;
	

	
	
	public Set<ChoiceCourseInfo> getChoiceCourseInfo() {
		return choiceCourseInfo;
	}
	public void setChoiceCourseInfo(Set<ChoiceCourseInfo> choiceCourseInfo) {
		this.choiceCourseInfo = choiceCourseInfo;
	}
	public Set<Course> getCourse() {
		return course;
	}
	public void setCourse(Set<Course> course) {
		this.course = course;
	}
	public Integer getU_id() {
		return u_id;
	}
	public void setU_id(Integer u_id) {
		this.u_id = u_id;
	}
	public String getU_usename() {
		return u_usename;
	}
	public void setU_usename(String u_usename) {
		this.u_usename = u_usename;
	}
	public String getU_password() {
		return u_password;
	}
	public void setU_password(String u_password) {
		this.u_password = u_password;
	}
	public Integer getU_power() {
		return u_power;
	}
	public void setU_power(Integer u_power) {
		this.u_power = u_power;
	}
	public String getU_powercode() {
		return u_powercode;
	}
	public void setU_powercode(String u_powercode) {
		this.u_powercode = u_powercode;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

}
