package cn.edu.scnu.service;
import cn.edu.scnu.pojo.User;
import cn.edu.scnu.vo.EasyUIResult;
public interface UserService {
	public User selectByUsername(String userName);
}
