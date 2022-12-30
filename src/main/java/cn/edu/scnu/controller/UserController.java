package cn.edu.scnu.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.scnu.po.Admin;
import cn.edu.scnu.po.User;
import cn.edu.scnu.service.UserService;

@Controller("userController")
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/login")
	public String login(User user, HttpSession session, Model model) {
		User mUser = userService.login(user);
		if (mUser != null) {
			session.setAttribute("user", mUser);
			return "redirect:/index.jsp";	// ��ת����ҳ
		} else {
			model.addAttribute("message", "�û����������");
			return "login";
		}
	}
//	adminlogin
	@RequestMapping("/adminlogin")
	public String adminlogin(Admin admin, HttpSession session, Model model) {
		Admin admin1 = userService.adminlogin(admin);
		if (admin1 != null) {
			session.setAttribute("admin", admin1);
			return "admin/manage";	// ��ת����̨��ҳ
		} else {
			model.addAttribute("message", "�û����������");
			return "admin/login";
		}
	}
	
	@RequestMapping("/regist")
	public String regist(User user,String valistr,HttpSession session,Model model) {
		if (user.getUsername() == null || user.getUsername() == "") {
			model.addAttribute("msg", "�û�������Ϊ�գ�");
			return "regist";
		}
		if (user.getPassword() == null || user.getPassword() == "") {
			model.addAttribute("msg", "���벻��Ϊ�գ�");
			return "regist";
		}
		if (!valistr.equalsIgnoreCase(session.getAttribute("code").toString())) {
			model.addAttribute("msg", "��֤�����");
			return "regist";
		}
		if (userService.regist(user) > 0){
			model.addAttribute("msg", "ע��ɹ�");
			return "regist";
		} else {
			model.addAttribute("msg", "ע��ʧ��");
			return "regist";				
		}
	}


	
	@RequestMapping(value = "/checkUser", method = RequestMethod.POST)
	public void check(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String username = request.getParameter("username");
		if (userService.checkUsername(username)) {
			response.getWriter().print("�û���" + username + "�ѱ�ע�ᣡ");
		} else {
			response.getWriter().print("��ϲ����" + username + "����ʹ�ã�");
		}
	}
	
}
