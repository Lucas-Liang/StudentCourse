package com.example.ssh.Pojo;

import java.util.Set;

public class Course {
	
	private Integer c_id;//�γ�id
	private String c_name;//�γ̵�����
	private String c_info;//�γ̵Ľ���
	private Integer c_num;//��������
	private Integer c_numChoice;//ѡ�������
	private String c_statu;//�γ�״̬
	private User  user;
	private Set<ChoiceCourseInfo> choiceCourseInfo;
	
	
	public Set<ChoiceCourseInfo> getChoiceCourseInfo() {
		return choiceCourseInfo;
	}
	public void setChoiceCourseInfo(Set<ChoiceCourseInfo> choiceCourseInfo) {
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
