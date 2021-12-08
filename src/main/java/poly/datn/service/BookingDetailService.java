package poly.datn.service;

import java.util.List;

import poly.datn.entity.BookingDetail;
import poly.datn.service.dto.BookingDetailServiceDTO;
import poly.datn.service.dto.ServicesIdDTO;

public interface BookingDetailService {

	List<BookingDetail> findAll();

	List<BookingDetailServiceDTO> getServiceByIdBooking(Integer id);

    List<ServicesIdDTO> getBookingByIDBooking(Integer id);
}
