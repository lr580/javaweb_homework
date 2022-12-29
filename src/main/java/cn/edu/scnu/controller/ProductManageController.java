package cn.edu.scnu.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cn.edu.scnu.vo.SysResult;

@RestController
public class ProductManageController {
    @RequestMapping("user/uploadImg")
    public SysResult uploadImg(@ModelAttribute FileDomain fileDomain, HttpServletRequest request) {
        
    }
}
