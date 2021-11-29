package poly.datn.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import poly.datn.entity.Booking;
import poly.datn.service.BookingCustomerService;
import poly.datn.service.dto.BookingCustomerDTO;
import poly.datn.service.impl.ServiceService;

@RestController
public class BookingCustomerRestController {

	@Autowired
	BookingCustomerService bcService;

	@Autowired
	ServiceService serService;

	@PostMapping("rest/bookingCus")
	public BookingCustomerDTO AddBookingInfo(@RequestBody BookingCustomerDTO bookingCustomerDTO) {
		return bcService.AddInfoBookingCustomer(bookingCustomerDTO);
	}

	@GetMapping("rest/bookingCusByStylist/{id}")
	public Booking bookingCusByStylist(@PathVariable("id") Integer id){
		return bcService.bookingStatusIAT(id);
	}

}
