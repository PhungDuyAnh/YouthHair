package poly.datn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import poly.datn.entity.Voucherdetail;

public interface VoucherDetailService {

	<S extends Voucherdetail> List<S> findAll(Example<S> example, Sort sort);

	<S extends Voucherdetail> List<S> findAll(Example<S> example);

	Voucherdetail getById(Integer id);

	void deleteAll();

	void deleteAll(Iterable<? extends Voucherdetail> entities);

	Voucherdetail getOne(Integer id);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends Integer> ids);

	void delete(Voucherdetail entity);

	void deleteAllByIdInBatch(Iterable<Integer> ids);

	void deleteById(Integer id);

	long count();

	void deleteAllInBatch(Iterable<Voucherdetail> entities);

	<S extends Voucherdetail> boolean exists(Example<S> example);

	<S extends Voucherdetail> long count(Example<S> example);

	void deleteInBatch(Iterable<Voucherdetail> entities);

	<S extends Voucherdetail> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends Voucherdetail> List<S> saveAllAndFlush(Iterable<S> entities);

	boolean existsById(Integer id);

	<S extends Voucherdetail> S saveAndFlush(S entity);

	void flush();

	<S extends Voucherdetail> List<S> saveAll(Iterable<S> entities);

	Optional<Voucherdetail> findById(Integer id);

	List<Voucherdetail> findAllById(Iterable<Integer> ids);

	List<Voucherdetail> findAll(Sort sort);

	List<Voucherdetail> findAll();

	Page<Voucherdetail> findAll(Pageable pageable);

	<S extends Voucherdetail> Optional<S> findOne(Example<S> example);

	<S extends Voucherdetail> S save(S entity);

}
