package poly.datn.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import poly.datn.service.BookingCustomerService;

@RestController
public class BookingCustomerRestController {

	@Autowired
	BookingCustomerService bcService;
	
	@PostMapping("rest/bookingCus")
	public void AddInFo() {
		bcService.AddInfoBookingCustomer();
	}
}
