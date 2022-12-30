package cn.edu.scnu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import cn.edu.scnu.exception.UserLoginNoException;

@Controller
public class BaseController {
	@ModelAttribute
	public void isLogin(HttpSession session, HttpServletRequest request) throws UserLoginNoException {
		if (session.getAttribute("user") == null) {
			throw new UserLoginNoException("û�е�½�����ȵ�¼��");
		}
	}
}
