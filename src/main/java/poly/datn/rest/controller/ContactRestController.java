package poly.datn.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
		
		@PutMapping("/rest/contact/{id}")
		public Contact update(@PathVariable("id")Integer id,@RequestBody Contact contact) {
			return contactService.save(contact);
		}
		
		@DeleteMapping("/rest/contact/{id}")
		public void delete(@PathVariable("id")Integer id) {
			contactService.deleteById(id);
		}

}
