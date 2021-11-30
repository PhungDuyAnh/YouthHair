package poly.datn.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import poly.datn.dao.VoucherDetailDAO;
import poly.datn.entity.Voucherdetail;
import poly.datn.service.VoucherDetailService;
import poly.datn.service.dto.VoucherDetailInfoDTO;

@Service
public class VoucherDetailServiceImpl implements VoucherDetailService{

	@Autowired
	VoucherDetailDAO voucherDetailDAO;

	public List<VoucherDetailInfoDTO> VoucherByCus(Integer id){

		return voucherDetailDAO.selectVoucherByCus(id);
	}
}
