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

@Service
public class VoucherDetailServiceImpl implements VoucherDetailService{

	@Autowired
	VoucherDetailDAO voucherDetailDAO;

	@Override
	public <S extends Voucherdetail> S save(S entity) {
		return voucherDetailDAO.save(entity);
	}

	@Override
	public <S extends Voucherdetail> Optional<S> findOne(Example<S> example) {
		return voucherDetailDAO.findOne(example);
	}

	@Override
	public Page<Voucherdetail> findAll(Pageable pageable) {
		return voucherDetailDAO.findAll(pageable);
	}

	@Override
	public List<Voucherdetail> findAll() {
		return voucherDetailDAO.findAll();
	}

	@Override
	public List<Voucherdetail> findAll(Sort sort) {
		return voucherDetailDAO.findAll(sort);
	}

	@Override
	public List<Voucherdetail> findAllById(Iterable<Integer> ids) {
		return voucherDetailDAO.findAllById(ids);
	}

	@Override
	public Optional<Voucherdetail> findById(Integer id) {
		return voucherDetailDAO.findById(id);
	}

	@Override
	public <S extends Voucherdetail> List<S> saveAll(Iterable<S> entities) {
		return voucherDetailDAO.saveAll(entities);
	}

	@Override
	public void flush() {
		voucherDetailDAO.flush();
	}

	@Override
	public <S extends Voucherdetail> S saveAndFlush(S entity) {
		return voucherDetailDAO.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(Integer id) {
		return voucherDetailDAO.existsById(id);
	}

	@Override
	public <S extends Voucherdetail> List<S> saveAllAndFlush(Iterable<S> entities) {
		return voucherDetailDAO.saveAllAndFlush(entities);
	}

	@Override
	public <S extends Voucherdetail> Page<S> findAll(Example<S> example, Pageable pageable) {
		return voucherDetailDAO.findAll(example, pageable);
	}

	@Override
	public void deleteInBatch(Iterable<Voucherdetail> entities) {
		voucherDetailDAO.deleteInBatch(entities);
	}

	@Override
	public <S extends Voucherdetail> long count(Example<S> example) {
		return voucherDetailDAO.count(example);
	}

	@Override
	public <S extends Voucherdetail> boolean exists(Example<S> example) {
		return voucherDetailDAO.exists(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<Voucherdetail> entities) {
		voucherDetailDAO.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return voucherDetailDAO.count();
	}

	@Override
	public void deleteById(Integer id) {
		voucherDetailDAO.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Integer> ids) {
		voucherDetailDAO.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(Voucherdetail entity) {
		voucherDetailDAO.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		voucherDetailDAO.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		voucherDetailDAO.deleteAllInBatch();
	}

	@Override
	public Voucherdetail getOne(Integer id) {
		return voucherDetailDAO.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends Voucherdetail> entities) {
		voucherDetailDAO.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		voucherDetailDAO.deleteAll();
	}

	@Override
	public Voucherdetail getById(Integer id) {
		return voucherDetailDAO.getById(id);
	}

	@Override
	public <S extends Voucherdetail> List<S> findAll(Example<S> example) {
		return voucherDetailDAO.findAll(example);
	}

	@Override
	public <S extends Voucherdetail> List<S> findAll(Example<S> example, Sort sort) {
		return voucherDetailDAO.findAll(example, sort);
	}
	
	
	
}
