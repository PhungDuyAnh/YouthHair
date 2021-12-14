package poly.datn.service;

import java.util.List;

import poly.datn.entity.Voucher;
import poly.datn.entity.Voucherdetail;
import poly.datn.entity.Workassign;
import poly.datn.service.dto.VoucherDetailInfoDTO;

public interface WorkassignService {
	
	List<Workassign> findAll();

	Workassign save(Workassign workassign);

}
