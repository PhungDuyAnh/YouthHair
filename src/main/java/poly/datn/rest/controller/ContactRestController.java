package poly.datn.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import poly.datn.entity.Contact;
import poly.datn.service.ContactService;

@RestController
public class ContactRestController {
	
		@Autowired
		ContactService contactService;
		
		@GetMapping("/rest/contact")
		public List<Contact> getAll(){
			return contactService.findAll();
		}

}
