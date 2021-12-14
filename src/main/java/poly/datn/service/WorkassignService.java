package poly.datn.service;

import java.util.Date;
import java.util.List;

import poly.datn.entity.Employee;
import poly.datn.entity.Voucher;
import poly.datn.entity.Voucherdetail;
import poly.datn.entity.Workassign;
import poly.datn.service.dto.VoucherDetailInfoDTO;
import poly.datn.service.dto.WorkassignDateDTO;

public interface WorkassignService {
	
	List<Workassign> findAll();

	Workassign save(Workassign workassign);

	List<Workassign> checkWorkassignNull(Integer id);

	List<WorkassignDateDTO> disctinctDate();

	List<Workassign> findWorkassignStylist(Date date);
}
