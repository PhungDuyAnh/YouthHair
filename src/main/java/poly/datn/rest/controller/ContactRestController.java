package poly.datn.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import poly.datn.entity.Contact;
import poly.datn.entity.Customer;
import poly.datn.service.ContactService;
import poly.datn.service.CustomerService;

@RestController
public class ContactRestController {
	
		@Autowired
		ContactService contactService;
		
		@Autowired
		CustomerService customerService;
		
		@GetMapping("/rest/contact")
		public List<Contact> getAll(){
			return contactService.findAll(Sort.by(Sort.Direction.ASC, "createDate"));
		}
		
		@PostMapping("/rest/contact")
		public Contact save(@RequestBody Contact contact) {
			return contactService.save(contact);
		}
		
		@PutMapping("/rest/contact/{id}")
		public Contact update(@PathVariable("id")Integer id,@RequestBody Contact contact) {
			return contactService.save(contact);
		}
		
		@DeleteMapping("/rest/contact/{id}")
		public void delete(@PathVariable("id")Integer id) {
			contactService.deleteById(id);
		}
		
		@GetMapping("/rest/contact/DXL")
		public List<Contact> getContactsDXL(String keyword){
			return contactService.findContactStatus(true, keyword);
		}
		
		@GetMapping("/rest/contact/CXL")
		public List<Contact> getContactsCXL(@Param("keyword") String keyword){
			return contactService.findContactStatus(false, keyword);
		}

}
