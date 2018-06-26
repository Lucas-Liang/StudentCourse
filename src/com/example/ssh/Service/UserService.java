package com.example.ssh.Service;


import org.springframework.transaction.annotation.Transactional;

import com.example.ssh.Dao.UserDao;
import com.example.ssh.Pojo.User;
@Transactional
public class UserService {
	private UserDao userDao;
	

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


	public User login(User users) {
		User user = userDao.findByUsernameAndPassword(users);
		return user;
	}


	public boolean save(User users) {
		// TODO Auto-generated method stub
		boolean rs =  userDao.save(users);
		return rs;
	}


	public void update(User users) {
		 userDao.update(users);
	}


	public User findById(Integer u_id) {
		User user = userDao.findById(u_id);
		return user;
	}
	

}
