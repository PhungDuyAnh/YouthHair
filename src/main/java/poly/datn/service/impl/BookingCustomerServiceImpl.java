package poly.datn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.datn.dao.BookingDAO;
import poly.datn.dao.BookingDetailDAO;
import poly.datn.dao.CustomerDAO;
import poly.datn.dao.ServiceDAO;
import poly.datn.service.BookingCustomerService;

@Service

public class BookingCustomerServiceImpl  implements BookingCustomerService{

	@Autowired
	BookingDAO bookingDao;
	
	@Autowired
	BookingDetailDAO bDetailDAO;
	
	@Autowired
	ServiceDAO serDao;
	
	@Autowired
	CustomerDAO cusDAO;
	
	public void AddInfoBookingCustomer() {
		
	    cusDAO.save(null);
	    cusDAO.findById(null);
		
		bookingDao.save(null);
		bookingDao.findById(null);
		
		serDao.findById(null);
		
	   bDetailDAO.save(null);
	}
}
