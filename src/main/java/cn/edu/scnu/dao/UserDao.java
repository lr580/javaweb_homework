package cn.edu.scnu.dao;

import java.util.List;
import java.util.Map;

import cn.edu.scnu.po.User;

public interface UserDao {
	public User login(String username);
	public int regist(User user);
	public List<User> allUsers();
	public void saveUser(User user);
	public User oneUser(Integer id);
	public void updateUser(Map<String,Object> map);
}
