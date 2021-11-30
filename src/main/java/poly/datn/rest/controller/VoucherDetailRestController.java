package poly.datn.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import poly.datn.entity.Voucher;
import poly.datn.entity.Voucherdetail;
import poly.datn.service.VoucherDetailService;
import poly.datn.service.dto.VoucherDetailInfoDTO;

@RestController
public class VoucherDetailRestController {
	
	@Autowired
	VoucherDetailService voucherDetailService;
	
	@GetMapping("/rest/voucherdetailByCustomer/{id}")
	public List<Voucher> getvoucherByCus(@PathVariable("id") Integer id){

		return voucherDetailService.VoucherByCus(id);
	}

	@PostMapping("/rest/voucherdetailByCustomer")
	public VoucherDetailInfoDTO PayBooking(VoucherDetailInfoDTO voucherDetailInfoDTO){
		return voucherDetailService.completeBooking(voucherDetailInfoDTO);
	}

}
