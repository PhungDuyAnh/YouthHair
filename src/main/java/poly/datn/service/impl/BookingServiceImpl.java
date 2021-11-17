package poly.datn.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import poly.datn.dao.BookingDAO;
import poly.datn.entity.Booking;
import poly.datn.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	BookingDAO bookingDAO;

	@Override
	public <S extends Booking> S save(S entity) {
		return bookingDAO.save(entity);
	}

	@Override
	public <S extends Booking> Optional<S> findOne(Example<S> example) {
		return bookingDAO.findOne(example);
	}

	@Override
	public Page<Booking> findAll(Pageable pageable) {
		return bookingDAO.findAll(pageable);
	}

	@Override
	public List<Booking> findAll() {
		return bookingDAO.findAll();
	}

	@Override
	public List<Booking> findAll(Sort sort) {
		return bookingDAO.findAll(sort);
	}

	@Override
	public List<Booking> findAllById(Iterable<Integer> ids) {
		return bookingDAO.findAllById(ids);
	}

	@Override
	public Optional<Booking> findById(Integer id) {
		return bookingDAO.findById(id);
	}

	@Override
	public <S extends Booking> List<S> saveAll(Iterable<S> entities) {
		return bookingDAO.saveAll(entities);
	}

	@Override
	public void flush() {
		bookingDAO.flush();
	}

	@Override
	public <S extends Booking> S saveAndFlush(S entity) {
		return bookingDAO.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(Integer id) {
		return bookingDAO.existsById(id);
	}

	@Override
	public <S extends Booking> List<S> saveAllAndFlush(Iterable<S> entities) {
		return bookingDAO.saveAllAndFlush(entities);
	}

	@Override
	public <S extends Booking> Page<S> findAll(Example<S> example, Pageable pageable) {
		return bookingDAO.findAll(example, pageable);
	}

	@Override
	public void deleteInBatch(Iterable<Booking> entities) {
		bookingDAO.deleteInBatch(entities);
	}

	@Override
	public <S extends Booking> long count(Example<S> example) {
		return bookingDAO.count(example);
	}

	@Override
	public <S extends Booking> boolean exists(Example<S> example) {
		return bookingDAO.exists(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<Booking> entities) {
		bookingDAO.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return bookingDAO.count();
	}

	@Override
	public void deleteById(Integer id) {
		bookingDAO.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Integer> ids) {
		bookingDAO.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(Booking entity) {
		bookingDAO.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		bookingDAO.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		bookingDAO.deleteAllInBatch();
	}

	@Override
	public Booking getOne(Integer id) {
		return bookingDAO.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends Booking> entities) {
		bookingDAO.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		bookingDAO.deleteAll();
	}

	@Override
	public Booking getById(Integer id) {
		return bookingDAO.getById(id);
	}

	@Override
	public <S extends Booking> List<S> findAll(Example<S> example) {
		return bookingDAO.findAll(example);
	}

	@Override
	public <S extends Booking> List<S> findAll(Example<S> example, Sort sort) {
		return bookingDAO.findAll(example, sort);
	}

	@Override
	public List<Booking> findBookingByStatusbooking(String status){
		return bookingDAO.bookingByStatus(status);
	}
}
