package poly.datn.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.datn.entity.Contact;
import poly.datn.entity.Employee;
import poly.datn.service.ContactService;
import poly.datn.service.EmployeeService;
import poly.datn.service.IServiceService;

@Controller
public class IndexController {
	
	@Autowired
	IServiceService iService;
	
	@Autowired
	ContactService contactService;

	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("sers",iService.findAll());
		List<Employee> listStylist = employeeService.loadStylist();
		model.addAttribute("stylist",listStylist);
		
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
	public String contact(@ModelAttribute Contact contact, Model model) {
//		model.addAttribute("contact", contact);
		return "layout/contact";
	}
	
//	@PostMapping("/contact/save")
//	public String saveContact(
//			Contact contact
//			) {
//		
//			contactService.save(new Contact(new Date(), contact.getEmail(), contact.getFullName(), contact.getNote(), contact.getPhone(), false));
//			
//			return "redirect:/"; 
//		
//	}
	
	@RequestMapping("/about")
	public String about() {
		
		return "layout/about";
	}

	@RequestMapping("/booking")
	public String booking(Model model) {
		model.addAttribute("sers",iService.findAll());
		List<Employee> listStylist = employeeService.loadStylist();
		model.addAttribute("stylist",listStylist);
//		for(int i=0; i<listStylist.size();i++){
//			model.addAttribute("bookingIAT",bookingCustomerService.bookingStatusIAT(listStylist.get(i).getId()));
//		}
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
