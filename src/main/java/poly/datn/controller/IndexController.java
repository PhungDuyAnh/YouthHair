package poly.datn.controller;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import poly.datn.entity.Contact;
import poly.datn.entity.Customer;
import poly.datn.service.ContactService;
import poly.datn.service.CustomerService;
import poly.datn.service.IServiceService;

@Controller
public class IndexController {
	
	@Autowired
	IServiceService iService;
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	ContactService contactService;
	
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
	public String contact(Model model) {
		
		return "layout/contact";
	}
	
	@RequestMapping(value = "/contact/save", method = RequestMethod.POST)
	public String saveContact(Contact contact, 
			@RequestParam("fullName") String fullName,
			@RequestParam("email") String email,
			@RequestParam("phone") String phone,
			@RequestParam("note") String note
			) {
		contact.setFullName(fullName);
		contact.setEmail(email);
		contact.setPhone(phone);
		contact.setNote(note);
		contact.setCreateDate(new Date());
		contact.setStatus(false);
		contactService.save(contact);
		return "redirect:/contact"; 
	}
	
	@RequestMapping("/about")
	public String about() {
		
		return "layout/about";
	}
	
	@RequestMapping("/booking")
	public String booking() {
		
		return "layout/booking";
	}
	
//	@RequestMapping("/profile")
//	public String profile() {
//		
//		return "layout/profile";
//	}

	@RequestMapping("/admin")
	public String admin() {
		return "redirect:/admin/templates/index.html";
	}
}
