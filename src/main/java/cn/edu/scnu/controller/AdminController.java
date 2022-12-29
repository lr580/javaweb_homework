package cn.edu.scnu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cn.edu.scnu.pojo.User;
import cn.edu.scnu.service.UserService;
import cn.edu.scnu.vo.SysResult;

@RestController
public class AdminController {
    @Autowired
    private UserService userService;
    @RequestMapping("user/checkadmin/{ticket}")
    public SysResult checkIsAdmin(@PathVariable String ticket) {
        User user = userService.queryUserJson(ticket);
        if(user==null || user.getUserType()==0) {
            return SysResult.build(201, "您无权进入该页面", null);
        }
        return SysResult.build(200, "ok", null);
    }
}
