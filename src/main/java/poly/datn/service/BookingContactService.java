package poly.datn.service;

import java.util.List;

import poly.datn.entity.Booking;
import poly.datn.service.dto.BookingContactDTO;
import poly.datn.service.dto.BookingIatDTO;

public interface BookingContactService {
	BookingContactDTO AddInfoBookingCustomer(BookingContactDTO bookingContactDTO);
	Booking bookingStatusIAT(Integer id);
	List<BookingIatDTO> bookingIAT();

    Booking checkBookingUCF(String phone);
}
