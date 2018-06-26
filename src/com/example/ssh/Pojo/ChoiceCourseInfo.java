package com.example.ssh.Pojo;

public class ChoiceCourseInfo {
	private Integer cc_id;//选课信息表的ID
	private User user;//用户的id
	private Course course;//课程的id
	public Integer getCc_id() {
		return cc_id;
	}
	public void setCc_id(Integer cc_id) {
		this.cc_id = cc_id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	
	

}
