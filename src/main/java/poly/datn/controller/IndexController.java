package poly.datn.controller;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public String contact(Model model,
			@RequestParam("fullName") String fullName,
			@RequestParam("phone") String phone,
			@RequestParam("email") String email,
			@RequestParam("note") String note
			) {
		
		Optional<Customer> customer = customerService.checkCustomerContact(phone, email);
		//Kiem tra khach hang ton tai
		if(customer.isPresent()) {
			try {
				//them moi contact
				Contact nContact = new Contact(); 	
				nContact.setFullName(fullName);
				nContact.setEmail(email);
				nContact.setPhone(phone);
				nContact.setNote(note);
				nContact.setCreateDate(new Date());
				nContact.setStatus(false);
				nContact.setCustomer(customer.get());
				contactService.save(nContact);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			try {
				//them moi khach hang
				Customer nCustomer = new Customer();
				try {
					nCustomer.setFullName(fullName);
					nCustomer.setEmail(email);
					nCustomer.setPhone(phone);
					customerService.save(nCustomer);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				//them moi contact
				Contact nContact = new Contact(); 	
				nContact.setFullName(fullName);
				nContact.setEmail(email);
				nContact.setPhone(phone);
				nContact.setNote(note);
				nContact.setCreateDate(new Date());
				nContact.setStatus(false);
				nContact.setCustomer(nCustomer);
				contactService.save(nContact);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
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
