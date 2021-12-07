package poly.datn.service;

import poly.datn.entity.Booking;
import poly.datn.service.dto.BookingCustomerDTO;
import poly.datn.service.dto.BookingIatDTO;

import java.util.List;

public interface BookingCustomerService {
	BookingCustomerDTO AddInfoBookingCustomer(BookingCustomerDTO bookingCustomerDTO);
	Booking bookingStatusIAT(Integer id);
	List<BookingIatDTO> bookingIAT();

    Booking checkBookingIAT(String phone);
}
