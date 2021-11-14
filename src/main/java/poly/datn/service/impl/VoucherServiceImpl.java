package poly.datn.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import poly.datn.dao.VoucherDAO;
import poly.datn.entity.Voucher;
import poly.datn.service.VoucherService;

@Service
public class VoucherServiceImpl implements VoucherService{

	@Autowired
	VoucherDAO voucherDAO;

	@Override
	public <S extends Voucher> S save(S entity) {
		return voucherDAO.save(entity);
	}

	@Override
	public <S extends Voucher> Optional<S> findOne(Example<S> example) {
		return voucherDAO.findOne(example);
	}

	@Override
	public Page<Voucher> findAll(Pageable pageable) {
		return voucherDAO.findAll(pageable);
	}

	@Override
	public List<Voucher> findAll() {
		return voucherDAO.findAll();
	}

	@Override
	public List<Voucher> findAll(Sort sort) {
		return voucherDAO.findAll(sort);
	}

	@Override
	public List<Voucher> findAllById(Iterable<String> ids) {
		return voucherDAO.findAllById(ids);
	}

	@Override
	public Optional<Voucher> findById(String id) {
		return voucherDAO.findById(id);
	}

	@Override
	public <S extends Voucher> List<S> saveAll(Iterable<S> entities) {
		return voucherDAO.saveAll(entities);
	}

	@Override
	public void flush() {
		voucherDAO.flush();
	}

	@Override
	public <S extends Voucher> S saveAndFlush(S entity) {
		return voucherDAO.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(String id) {
		return voucherDAO.existsById(id);
	}

	@Override
	public <S extends Voucher> List<S> saveAllAndFlush(Iterable<S> entities) {
		return voucherDAO.saveAllAndFlush(entities);
	}

	@Override
	public <S extends Voucher> Page<S> findAll(Example<S> example, Pageable pageable) {
		return voucherDAO.findAll(example, pageable);
	}

	@Override
	public void deleteInBatch(Iterable<Voucher> entities) {
		voucherDAO.deleteInBatch(entities);
	}

	@Override
	public <S extends Voucher> long count(Example<S> example) {
		return voucherDAO.count(example);
	}

	@Override
	public <S extends Voucher> boolean exists(Example<S> example) {
		return voucherDAO.exists(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<Voucher> entities) {
		voucherDAO.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return voucherDAO.count();
	}

	@Override
	public void deleteById(String id) {
		voucherDAO.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<String> ids) {
		voucherDAO.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(Voucher entity) {
		voucherDAO.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends String> ids) {
		voucherDAO.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		voucherDAO.deleteAllInBatch();
	}

	@Override
	public Voucher getOne(String id) {
		return voucherDAO.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends Voucher> entities) {
		voucherDAO.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		voucherDAO.deleteAll();
	}

	@Override
	public Voucher getById(String id) {
		return voucherDAO.getById(id);
	}

	@Override
	public <S extends Voucher> List<S> findAll(Example<S> example) {
		return voucherDAO.findAll(example);
	}

	@Override
	public <S extends Voucher> List<S> findAll(Example<S> example, Sort sort) {
		return voucherDAO.findAll(example, sort);
	}
	
	
}
