package cn.edu.scnu.service;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.edu.scnu.utils.MD5Util;
import cn.edu.scnu.mapper.UserMapper;
import cn.edu.scnu.mapper.ProductMapper;
import cn.edu.scnu.pojo.Product;
import cn.edu.scnu.pojo.User;
@Service
public class UserServiceImpl  extends ServiceImpl<UserMapper,User> implements UserService{
	@Autowired
	private UserMapper userMapper;
	
	public User selectByUsername(String userName) {
		QueryWrapper<User> userQueryWrapper=new QueryWrapper<User>();
		userQueryWrapper.eq("user_name", userName);
		return userMapper.selectOne(userQueryWrapper);
	}
	
	public User queryUserJson(String userId) {
		return userMapper.selectById(userId);
	}

	public void userSave(User user) {
		user.setUserId(UUID.randomUUID().toString());
		user.setUserPassword(MD5Util.md5(user.getUserPassword()));
		userMapper.insert(user);	
	}
	
}