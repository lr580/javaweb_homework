package cn.edu.scnu.service;
import cn.edu.scnu.pojo.User;
import cn.edu.scnu.vo.EasyUIResult;
public interface UserService {
	User selectByUsername(String userName);
	User queryUserJson(String ticket);
	public void userSave(User user);
}
