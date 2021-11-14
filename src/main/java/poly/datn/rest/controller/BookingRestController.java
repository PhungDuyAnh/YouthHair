package poly.datn.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import poly.datn.entity.Booking;
import poly.datn.service.BookingService;

@RestController
public class BookingRestController {

	@Autowired
	BookingService bookingService;
	
	@GetMapping("/rest/booking")
	public List<Booking> getAll(){ 
		return bookingService.findAll();
	}
}
