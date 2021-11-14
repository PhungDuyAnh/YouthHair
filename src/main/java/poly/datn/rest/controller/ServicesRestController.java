package poly.datn.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import poly.datn.entity.Services;
import poly.datn.service.IServiceService;

@RestController
public class ServicesRestController {

	@Autowired
	IServiceService iServiceService;
	
	@GetMapping("/rest/service")
	public List<Services> getAll(){
		return iServiceService.findAll();
	}
	

}
