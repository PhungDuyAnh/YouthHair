package poly.datn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {
	
	
	@RequestMapping("/security/login/form")
	public String loginForm( Model model) {
		System.out.println("loginForm");
		model.addAttribute("message","Vui lòng đăng nhập");
		return "login/login";
	}
	
	@RequestMapping("/security/login/success")
	public String loginSuccess(Model model) {

		System.out.println("loginSuccess");
		model.addAttribute("message","Đăng nhập thành công!");
		return "redirect:/admin/templates/index.html";
	}
	@RequestMapping("/security/login/error")
	public String loginError(Model model) {
		System.out.println("loginError");
		model.addAttribute("message","Sai thông tin đăng nhập!");
		return "login/login";
	}
	
	@RequestMapping("/security/unauthoried")
	public String unauthoried(Model model) {
		System.out.println("unauthoried");
		model.addAttribute("message","Không có quyền truy cập!");
		return "login/login";
	}
	
	@RequestMapping("/security/logoff/success")
	public String logoffSuccess(Model model) {
		System.out.println("logoffSuccess");
		model.addAttribute("message","Bạn đã đăng xuất!");
		return "login/login";
	}
//	@CrossOrigins("*")
	
}
