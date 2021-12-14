package poly.datn.service;

import java.util.List;

import poly.datn.entity.Shifts;

public interface ShiftsService {
	
	List<Shifts> findAll();

	Shifts save(Shifts shifts);

}
