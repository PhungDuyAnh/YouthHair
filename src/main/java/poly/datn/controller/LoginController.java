package poly.datn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping("/login")
	public String login1() {
		
		return "login/login1";
	}
	
	@RequestMapping("/login2")
	public String login2() {
		
		return "login/login2";
	}
	
	@RequestMapping("/fogotpassword")
	public String fogotpassword() {
		
		return "login/fogot";
	}
	
	@RequestMapping("/newpassword")
	public String newpassword() {
		
		return "login/login3";
	}
}
