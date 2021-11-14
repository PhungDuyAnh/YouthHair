package poly.datn.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import poly.datn.entity.Voucher;
import poly.datn.service.VoucherDetailService;
import poly.datn.service.VoucherService;

@RestController
public class VoucherRestController {

	@Autowired
	VoucherService voucherService;
	
	@GetMapping("/rest/voucher")
	public List<Voucher> getAll(){
		return voucherService.findAll();
	}
}
