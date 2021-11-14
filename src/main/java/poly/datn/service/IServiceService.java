package poly.datn.service;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import poly.datn.entity.Services;

import java.util.List;
import java.util.Optional;

public interface IServiceService {
    <S extends Services> List<S> findAll(Example<S> example, Sort sort);

    <S extends Services> List<S> findAll(Example<S> example);

    Services getById(Integer id);

    void deleteAll();

    void deleteAll(Iterable<? extends Services> entities);

    Services getOne(Integer id);

    void deleteAllInBatch();

    void deleteAllById(Iterable<? extends Integer> ids);

    void delete(Integer id);

    void deleteAllByIdInBatch(Iterable<Integer> ids);

    void deleteById(Integer id);

    long count();

    void deleteAllInBatch(Iterable<Services> entities);

    <S extends Services> boolean exists(Example<S> example);

    <S extends Services> long count(Example<S> example);

    void deleteInBatch(Iterable<Services> entities);

    <S extends Services> Page<S> findAll(Example<S> example, Pageable pageable);

    <S extends Services> List<S> saveAllAndFlush(Iterable<S> entities);

    boolean existsById(Integer id);

    <S extends Services> S saveAndFlush(S entity);

    void flush();

    <S extends Services> List<S> saveAll(Iterable<S> entities);

    Services findById(Integer id);

    List<Services> findAllById(Iterable<Integer> ids);

    List<Services> findAll(Sort sort);

    List<Services> findAll();

    Page<Services> findAll(Pageable pageable);

    <S extends Services> Optional<S> findOne(Example<S> example);

    <S extends Services> S save(S entity);

//	List<Product> findByCategoryId(String cid);


    Services update(Services services);


}
