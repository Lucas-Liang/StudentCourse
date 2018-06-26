package com.example.ssh.Pojo;

public class Course {
	
	private Integer c_id;//课程id
	private String c_name;//课程的名称
	private String c_info;//课程的介绍
	private Integer c_num;//设置人数
	private Integer c_numChoice;//选择的人数
	private String c_statu;//课程状态
	private User  user;
	private ChoiceCourseInfo choiceCourseInfo;
	
	
	public ChoiceCourseInfo getChoiceCourseInfo() {
		return choiceCourseInfo;
	}
	public void setChoiceCourseInfo(ChoiceCourseInfo choiceCourseInfo) {
		this.choiceCourseInfo = choiceCourseInfo;
	}
	
	public Integer getC_id() {
		return c_id;
	}
	public void setC_id(Integer c_id) {
		this.c_id = c_id;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getC_info() {
		return c_info;
	}
	public void setC_info(String c_info) {
		this.c_info = c_info;
	}
	public Integer getC_num() {
		return c_num;
	}
	public void setC_num(Integer c_num) {
		this.c_num = c_num;
	}
	public Integer getC_numChoice() {
		return c_numChoice;
	}
	public void setC_numChoice(Integer c_numChoice) {
		this.c_numChoice = c_numChoice;
	}
	public String getC_statu() {
		return c_statu;
	}
	public void setC_statu(String c_statu) {
		this.c_statu = c_statu;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	

}
