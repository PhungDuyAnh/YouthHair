package poly.datn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import poly.datn.entity.BookingDetail;
import poly.datn.entity.BookingDetailPK;

public interface BookingDetailService {

	<S extends BookingDetail> List<S> findAll(Example<S> example, Sort sort);

	<S extends BookingDetail> List<S> findAll(Example<S> example);

	BookingDetail getById(BookingDetailPK id);

	void deleteAll();

	void deleteAll(Iterable<? extends BookingDetail> entities);

	BookingDetail getOne(BookingDetailPK id);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends BookingDetailPK> ids);

	void delete(BookingDetail entity);

	void deleteAllByIdInBatch(Iterable<BookingDetailPK> ids);

	void deleteById(BookingDetailPK id);

	long count();

	void deleteAllInBatch(Iterable<BookingDetail> entities);

	<S extends BookingDetail> boolean exists(Example<S> example);

	<S extends BookingDetail> long count(Example<S> example);

	void deleteInBatch(Iterable<BookingDetail> entities);

	<S extends BookingDetail> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends BookingDetail> List<S> saveAllAndFlush(Iterable<S> entities);

	boolean existsById(BookingDetailPK id);

	<S extends BookingDetail> S saveAndFlush(S entity);

	void flush();

	<S extends BookingDetail> List<S> saveAll(Iterable<S> entities);

	Optional<BookingDetail> findById(BookingDetailPK id);

	List<BookingDetail> findAllById(Iterable<BookingDetailPK> ids);

	List<BookingDetail> findAll(Sort sort);

	List<BookingDetail> findAll();

	Page<BookingDetail> findAll(Pageable pageable);

	<S extends BookingDetail> Optional<S> findOne(Example<S> example);

	<S extends BookingDetail> S save(S entity);

}
