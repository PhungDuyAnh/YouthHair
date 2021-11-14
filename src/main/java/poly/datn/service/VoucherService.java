package poly.datn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import poly.datn.entity.Voucher;

public interface VoucherService {

	<S extends Voucher> List<S> findAll(Example<S> example, Sort sort);

	<S extends Voucher> List<S> findAll(Example<S> example);

	Voucher getById(String id);

	void deleteAll();

	void deleteAll(Iterable<? extends Voucher> entities);

	Voucher getOne(String id);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends String> ids);

	void delete(Voucher entity);

	void deleteAllByIdInBatch(Iterable<String> ids);

	void deleteById(String id);

	long count();

	void deleteAllInBatch(Iterable<Voucher> entities);

	<S extends Voucher> boolean exists(Example<S> example);

	<S extends Voucher> long count(Example<S> example);

	void deleteInBatch(Iterable<Voucher> entities);

	<S extends Voucher> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends Voucher> List<S> saveAllAndFlush(Iterable<S> entities);

	boolean existsById(String id);

	<S extends Voucher> S saveAndFlush(S entity);

	void flush();

	<S extends Voucher> List<S> saveAll(Iterable<S> entities);

	Optional<Voucher> findById(String id);

	List<Voucher> findAllById(Iterable<String> ids);

	List<Voucher> findAll(Sort sort);

	List<Voucher> findAll();

	Page<Voucher> findAll(Pageable pageable);

	<S extends Voucher> Optional<S> findOne(Example<S> example);

	<S extends Voucher> S save(S entity);

}
