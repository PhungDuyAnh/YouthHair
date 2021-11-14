package poly.datn.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import poly.datn.dao.BookingDetailDAO;
import poly.datn.entity.BookingDetail;
import poly.datn.entity.BookingDetailPK;
import poly.datn.service.BookingDetailService;

@Service
public class BookingDetailServiceImpl implements BookingDetailService {

	@Autowired
	BookingDetailDAO BookingDetailDAO;

	@Override
	public <S extends BookingDetail> S save(S entity) {
		return BookingDetailDAO.save(entity);
	}

	@Override
	public <S extends BookingDetail> Optional<S> findOne(Example<S> example) {
		return BookingDetailDAO.findOne(example);
	}

	@Override
	public Page<BookingDetail> findAll(Pageable pageable) {
		return BookingDetailDAO.findAll(pageable);
	}

	@Override
	public List<BookingDetail> findAll() {
		return BookingDetailDAO.findAll();
	}

	@Override
	public List<BookingDetail> findAll(Sort sort) {
		return BookingDetailDAO.findAll(sort);
	}

	@Override
	public List<BookingDetail> findAllById(Iterable<BookingDetailPK> ids) {
		return BookingDetailDAO.findAllById(ids);
	}

	@Override
	public Optional<BookingDetail> findById(BookingDetailPK id) {
		return BookingDetailDAO.findById(id);
	}

	@Override
	public <S extends BookingDetail> List<S> saveAll(Iterable<S> entities) {
		return BookingDetailDAO.saveAll(entities);
	}

	@Override
	public void flush() {
		BookingDetailDAO.flush();
	}

	@Override
	public <S extends BookingDetail> S saveAndFlush(S entity) {
		return BookingDetailDAO.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(BookingDetailPK id) {
		return BookingDetailDAO.existsById(id);
	}

	@Override
	public <S extends BookingDetail> List<S> saveAllAndFlush(Iterable<S> entities) {
		return BookingDetailDAO.saveAllAndFlush(entities);
	}

	@Override
	public <S extends BookingDetail> Page<S> findAll(Example<S> example, Pageable pageable) {
		return BookingDetailDAO.findAll(example, pageable);
	}

	@Override
	public void deleteInBatch(Iterable<BookingDetail> entities) {
		BookingDetailDAO.deleteInBatch(entities);
	}

	@Override
	public <S extends BookingDetail> long count(Example<S> example) {
		return BookingDetailDAO.count(example);
	}

	@Override
	public <S extends BookingDetail> boolean exists(Example<S> example) {
		return BookingDetailDAO.exists(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<BookingDetail> entities) {
		BookingDetailDAO.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return BookingDetailDAO.count();
	}

	@Override
	public void deleteById(BookingDetailPK id) {
		BookingDetailDAO.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<BookingDetailPK> ids) {
		BookingDetailDAO.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(BookingDetail entity) {
		BookingDetailDAO.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends BookingDetailPK> ids) {
		BookingDetailDAO.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		BookingDetailDAO.deleteAllInBatch();
	}

	@Override
	public BookingDetail getOne(BookingDetailPK id) {
		return BookingDetailDAO.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends BookingDetail> entities) {
		BookingDetailDAO.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		BookingDetailDAO.deleteAll();
	}

	@Override
	public BookingDetail getById(BookingDetailPK id) {
		return BookingDetailDAO.getById(id);
	}

	@Override
	public <S extends BookingDetail> List<S> findAll(Example<S> example) {
		return BookingDetailDAO.findAll(example);
	}

	@Override
	public <S extends BookingDetail> List<S> findAll(Example<S> example, Sort sort) {
		return BookingDetailDAO.findAll(example, sort);
	}
	
	
}
