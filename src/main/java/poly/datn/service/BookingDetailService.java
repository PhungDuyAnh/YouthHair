package poly.datn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import poly.datn.entity.BookingDetail;
import poly.datn.entity.BookingDetailPK;

public interface BookingDetailService {

	List<BookingDetail> findAll();

	List<BookingDetail> getServiceByIdBooking(Integer id);

}
