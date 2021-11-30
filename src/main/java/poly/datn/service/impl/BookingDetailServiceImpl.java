package poly.datn.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import poly.datn.dao.BookingDetailDAO;
import poly.datn.entity.BookingDetail;
import poly.datn.entity.BookingDetailPK;
import poly.datn.service.BookingDetailService;

@Service
public class BookingDetailServiceImpl implements BookingDetailService {

	@Autowired
	BookingDetailDAO BookingDetailDAO;


	@Override
	public List<BookingDetail> findAll() {
		return BookingDetailDAO.findAll();
	}

	public List<BookingDetail> getServiceByIdBooking(Integer id){

		return BookingDetailDAO.selectServiceByIdBooking(id);
	}
}
