package poly.datn.service;

import poly.datn.entity.Booking;
import poly.datn.service.dto.BookingCustomerDTO;

public interface BookingCustomerService {
	BookingCustomerDTO AddInfoBookingCustomer(BookingCustomerDTO bookingCustomerDTO);
	Booking bookingStatusIAT(Integer id);

}
