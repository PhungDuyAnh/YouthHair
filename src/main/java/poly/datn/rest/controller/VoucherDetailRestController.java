package poly.datn.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import poly.datn.entity.Voucher;
import poly.datn.entity.Voucherdetail;
import poly.datn.service.VoucherDetailService;

@RestController
public class VoucherDetailRestController {
	
	@Autowired
	VoucherDetailService voucherDetailService;
	
	@GetMapping("/rest/voucherdetail")
	public List<Voucherdetail> getAll(){
		return voucherDetailService.findAll();
	}

}
