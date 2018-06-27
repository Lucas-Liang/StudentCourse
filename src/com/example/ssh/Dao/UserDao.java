package com.example.ssh.Dao;

import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.example.ssh.Pojo.User;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class UserDao  extends HibernateDaoSupport{
	
	/**
	 * 用户登录
	 * @param users
	 */
	public User findByUsernameAndPassword(User user) {
		// TODO Auto-generated method stub
		System.out.println("开始执行登录验证.....");
		System.out.println(""+user.getU_usename());
		String hqlString = "from User where u_usename=? and u_password=? ";
		List<User> list =this.getHibernateTemplate().find(hqlString,user.getU_usename(),user.getU_password());
		System.out.println("12"+list.size());
		
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}
	/**
	 * 注册用户
	 * @param users
	 */
	public boolean save(User users) {
		// TODO Auto-generated method stub
		if(users.getU_powercode().equals("STCM16")){
//			设置老师的权限
			users.setU_power(0);
		}else {
			users.setU_powercode(null);
//			设置学生的权限
			users.setU_power(1);
		}
		this.getHibernateTemplate().save(users);
		boolean rs = true;
		return rs;
		
		
	}
/**
 * 更新用户的信息
 * @param users
 */
	public void update(User users) {
		this.getHibernateTemplate().update(users);
	}
	public User findById(Integer u_id) {
	// TODO Auto-generated method stub
	return null;
	} 

}
