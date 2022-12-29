package easymall.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@RequestMapping("/manage")
	public String toManager() {
		return "admin/manage";
	}
	
	@RequestMapping("/login")
	public String toLogin() {
		return "admin/login";
	}
	
}
