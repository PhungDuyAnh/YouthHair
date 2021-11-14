package poly.datn.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import poly.datn.entity.Employee;
import poly.datn.service.EmployeeService;

@RestController
public class EmployeeeRestController {

	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/rest/employee")
	public List<Employee> getAll(){
		return employeeService.findAll();
	}
}
