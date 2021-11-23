package poly.datn.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poly.datn.entity.Booking;
import poly.datn.service.BookingService;

@RestController
@RequestMapping("/rest/booking")
public class BookingRestController {

	@Autowired
	BookingService bookingService;

	@GetMapping("")
	public List<Booking> getAll(){
		return bookingService.findAll();
	}

	@GetMapping("/WFC")
	public List<Booking> getByStatusBooking(){
		List<Booking> list= bookingService.findBookingByStatusbooking("WFC");
		return  list;
	}

	@GetMapping("/WFP")
	public List<Booking> getByStatusBookingWFP(){return bookingService.findBookingByStatusbooking("WFP");}

	@GetMapping("/UCF")
	public List<Booking> getByStatusBookingUCF(){return bookingService.findBookingByStatusbooking("UCF");}

}
