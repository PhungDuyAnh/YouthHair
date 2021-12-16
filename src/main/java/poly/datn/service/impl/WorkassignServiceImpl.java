package poly.datn.service.impl;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.Tuple;

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
import poly.datn.service.dto.*;

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

	@Override
	public List<Workassign> checkWorkassignNull(Integer id) {
		return workassignDAO.checkWorkassignNull(id);
	}

	
	public List<WorkassignDateDTO> disctinctDate() {
		List<Tuple> stockDateTuples = workassignDAO.disctinctDate();
		List<WorkassignDateDTO> stockTotalDto = stockDateTuples.stream()
				.map(t -> new WorkassignDateDTO(
						t.get(0, Date.class)
				))
				.collect(Collectors.toList());
		
		return stockTotalDto;
	}

	@Override
	public List<Workassign> findWorkassignStylist(Date date) {
		return workassignDAO.findWorkassignStylist(date);
	}

	public Workassign selectShiftByEmployeeId(Integer id, Date date){
		return workassignDAO.selectShiftByEmployeeId(id,date);
	}
}
