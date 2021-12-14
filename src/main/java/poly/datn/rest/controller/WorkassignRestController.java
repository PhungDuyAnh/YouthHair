package poly.datn.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import poly.datn.entity.Voucher;
import poly.datn.entity.Voucherdetail;
import poly.datn.entity.Workassign;
import poly.datn.service.VoucherDetailService;
import poly.datn.service.WorkassignService;
import poly.datn.service.dto.VoucherDetailInfoDTO;

@RestController
public class WorkassignRestController {
	
	@Autowired
	WorkassignService workassignService;
	
	@GetMapping("/rest/Workassign")
	public List<Workassign> findAll(){
		return workassignService.findAll();
	}
	
	@PostMapping("/rest/Workassign")
	public Workassign save(@RequestBody Workassign workassign){
		return workassignService.save(workassign);
	}
	
	@PutMapping("/rest/Workassign")
	public Workassign update(@RequestBody Workassign workassign){
		return workassignService.save(workassign);
	}
}
