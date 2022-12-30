package cn.edu.scnu.service;

import cn.edu.scnu.po.Admin;
import cn.edu.scnu.po.User;

public interface UserService {
	//�û���¼���ܣ�����User����� 
	public User login(User user);
	
	//����û��Ƿ��ѱ�ע�� 
	public boolean checkUsername(String username);
	
	//ע���û�
	public int regist(User user);
//	��̨��¼
	public Admin adminlogin(Admin admin);

}
