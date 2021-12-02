package poly.datn.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.datn.dao.BookingDetailDAO;
import poly.datn.entity.BookingDetail;
import poly.datn.service.BookingDetailService;
import poly.datn.service.dto.BookingDetailServiceDTO;

import javax.persistence.Tuple;

@Service
public class BookingDetailServiceImpl implements BookingDetailService {

	@Autowired
	BookingDetailDAO bookingDetailDAO;


	@Override
	public List<BookingDetail> findAll() {
		return bookingDetailDAO.findAll();
	}

	public List<BookingDetailServiceDTO> getServiceByIdBooking(Integer id){
		List<Tuple> stockTotalTuples = bookingDetailDAO.selectServiceByIdBooking(id);
		List<BookingDetailServiceDTO> stockTotalDto = stockTotalTuples.stream()
				.map(t -> new BookingDetailServiceDTO(
						t.get(0, String.class),
						t.get(1, String.class)

				))
				.collect(Collectors.toList());

		return stockTotalDto;
	}
}
