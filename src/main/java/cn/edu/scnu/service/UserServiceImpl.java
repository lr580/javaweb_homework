package cn.edu.scnu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.scnu.dao.UserDao;
import cn.edu.scnu.po.Admin;
import cn.edu.scnu.po.User;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public User login(User user) {
		return userDao.login(user);
	}

	@Override
	public boolean checkUsername(String username) {
		if (userDao.checkUsername(username) != null) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public int regist(User user) {
		return userDao.regist(user);
	}

	@Override
	public Admin adminlogin(Admin admin) {
		// TODO Auto-generated method stub
		return userDao.adminlogin(admin);
	}

}
