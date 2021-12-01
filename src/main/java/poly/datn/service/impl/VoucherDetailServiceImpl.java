package poly.datn.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import poly.datn.dao.*;
import poly.datn.entity.*;
import poly.datn.service.VoucherDetailService;
import poly.datn.service.dto.BookingCustomerDTO;
import poly.datn.service.dto.VoucherDetailInfoDTO;

@Service
public class VoucherDetailServiceImpl implements VoucherDetailService{

	@Autowired
	VoucherDetailDAO voucherDetailDAO;

	@Autowired
	BookingDAO bookingDAO;

	@Autowired
	VotingDAO votingDAO;

	@Autowired
	StatusBookingDAO statusBookingDAO;

	public List<Voucher> VoucherByCus(Integer id){

		return voucherDetailDAO.selectVoucherByCus(id);
	}

	public VoucherDetailInfoDTO completeBooking(VoucherDetailInfoDTO voucherDetailInfoDTO ){

		try {
			System.out.println(voucherDetailInfoDTO.getTotalPrice());
			Voucherdetail voucherdetail =new Voucherdetail();
			if(voucherDetailInfoDTO.getVoucherId() != null){
				 voucherdetail = voucherDetailDAO.selectVoucherDetailByCus(voucherDetailInfoDTO.getVoucherId());
				voucherdetail.setStatus(false);
				voucherDetailDAO.save(voucherdetail);
			}else{
				System.out.println("voucherDetailInfoDTO.getVoucherId() = null");
			}

			Statusbooking statusbooking= statusBookingDAO.StatusbookingbyIdCPM();
			Voting voting = votingDAO.selectVotingById(voucherDetailInfoDTO.getVoting());

			Booking booking = bookingDAO.bookingCusByCusWFP(voucherDetailInfoDTO.getCusId());
			if (booking != null) {
				booking.setStatusbooking(statusbooking);
				booking.setVoting(voting);
				booking.setVoucherdetails(voucherdetail);
				booking.setTotalPrice(voucherDetailInfoDTO.getTotalPrice());
				bookingDAO.save(booking);
			}else{
				System.out.println("booking = null");
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return voucherDetailInfoDTO;
	}

	@Override
	public List<Voucherdetail> findAll() {		
		return voucherDetailDAO.findAll();
	}

	@Override
	public Voucherdetail save(Voucherdetail voucherDetail) {
		return voucherDetailDAO.save(voucherDetail);
	}
}
