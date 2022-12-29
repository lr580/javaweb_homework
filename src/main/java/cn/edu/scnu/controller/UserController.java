package easymall.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import easymall.po.Admin;
import easymall.po.User;
import easymall.service.UserService;

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
			return "redirect:/index.jsp";	// 跳转到主页
		} else {
			model.addAttribute("message", "用户名密码错误！");
			return "login";
		}
	}
//	adminlogin
	@RequestMapping("/adminlogin")
	public String adminlogin(Admin admin, HttpSession session, Model model) {
		Admin admin1 = userService.adminlogin(admin);
		if (admin1 != null) {
			session.setAttribute("admin", admin1);
			return "admin/manage";	// 跳转到后台主页
		} else {
			model.addAttribute("message", "用户名密码错误！");
			return "admin/login";
		}
	}
	
	@RequestMapping("/regist")
	public String regist(User user,String valistr,HttpSession session,Model model) {
		if (user.getUsername() == null || user.getUsername() == "") {
			model.addAttribute("msg", "用户名不能为空！");
			return "regist";
		}
		if (user.getPassword() == null || user.getPassword() == "") {
			model.addAttribute("msg", "密码不能为空！");
			return "regist";
		}
		if (!valistr.equalsIgnoreCase(session.getAttribute("code").toString())) {
			model.addAttribute("msg", "验证码错误！");
			return "regist";
		}
		if (userService.regist(user) > 0){
			model.addAttribute("msg", "注册成功");
			return "regist";
		} else {
			model.addAttribute("msg", "注册失败");
			return "regist";				
		}
	}


	
	@RequestMapping(value = "/checkUser", method = RequestMethod.POST)
	public void check(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String username = request.getParameter("username");
		if (userService.checkUsername(username)) {
			response.getWriter().print("用户名" + username + "已被注册！");
		} else {
			response.getWriter().print("恭喜您，" + username + "可以使用！");
		}
	}
	
}
