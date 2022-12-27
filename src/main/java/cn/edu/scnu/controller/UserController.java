package cn.edu.scnu.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cn.edu.scnu.utils.MapperUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import cn.edu.scnu.pojo.User;
import cn.edu.scnu.service.UserService;
import cn.edu.scnu.utils.MD5Util;
import cn.edu.scnu.utils.MapperUtil;
import cn.edu.scnu.utils.CookieUtils;
import cn.edu.scnu.vo.SysResult;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
    @RequestMapping("/user/login")
    public SysResult login(String userName,String userPassword,HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        User user = userService.selectByUsername(userName);
        if (user == null) {
            return SysResult.build(201, "您输入的用户名错误", null);
        } else if (user.getUserPassword().equals(MD5Util.md5(userPassword))) {
            session.setAttribute("user", user);         
            CookieUtils.setCookie(request, response, "EM_TICKET", user.getUserId());
            return SysResult.ok();
        } else {
            return SysResult.build(201, "您输入的密码错误", null);
        }
    }
}
