package poly.datn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	@RequestMapping("/check")
	public String test() {
		
		return "redirect:/admin/charts.html";
	}
	@RequestMapping("/")
	public String index() {
		
		return "layout/home";
	}
	
	@RequestMapping("/services")
	public String service() {
		
		return "layout/services";
	}
	
	@RequestMapping("/haircut")
	public String haircut() {
		
		return "layout/haircut";
	}
	
	@RequestMapping("/contact")
	public String contact() {
		
		return "layout/contact";
	}
	
	@RequestMapping("/about")
	public String about() {
		
		return "layout/about";
	}
	
	@RequestMapping("/booking")
	public String booking() {
		
		return "layout/booking";
	}
	
	@RequestMapping("/profile")
	public String profile() {
		
		return "layout/profile";
	}

	@RequestMapping("/admin")
	public String admin() {
		return "redirect:/admin/templates/index.html";
	}
}
