package poly.datn.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import poly.datn.entity.Customer;
import poly.datn.service.CustomerSerivce;

@RestController
public class CustomerRestController {

	@Autowired
	CustomerSerivce customerSerivce;
	
	@GetMapping("/rest/customer")
	public List<Customer> getAll(){
		return customerSerivce.findAll();
	}
	
}
