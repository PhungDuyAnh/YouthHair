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
import poly.datn.service.WorkassignService;
import poly.datn.service.dto.BookingCustomerDTO;
import poly.datn.service.dto.VoucherDetailInfoDTO;

@Service
public class WorkassignServiceImpl implements WorkassignService{

	@Autowired
	WorkassignDAO workassignDAO;

	@Override
	public List<Workassign> findAll() {
		return workassignDAO.findAll();
	}

	@Override
	public Workassign save(Workassign workassign) {
		return workassignDAO.save(workassign);
	}

	
}
