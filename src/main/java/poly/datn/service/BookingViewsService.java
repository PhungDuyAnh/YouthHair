package poly.datn.service;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import poly.datn.entity.BookingView;

import java.util.List;
import java.util.Optional;

public interface BookingViewsService {

    List<BookingView> findByStatusName(String statusName);

    List<BookingView> findAll();

    List<BookingView> findAll(Sort sort);

    List<BookingView> findAllById(Iterable<Integer> integers);

    <S extends BookingView> List<S> saveAll(Iterable<S> entities);

    void flush();

    <S extends BookingView> S saveAndFlush(S entity);

    <S extends BookingView> List<S> saveAllAndFlush(Iterable<S> entities);

    @Deprecated
    void deleteInBatch(Iterable<BookingView> entities);

    void deleteAllInBatch(Iterable<BookingView> entities);

    void deleteAllByIdInBatch(Iterable<Integer> integers);

    void deleteAllInBatch();

    @Deprecated
    BookingView getOne(Integer integer);

    BookingView getById(Integer integer);

    <S extends BookingView> List<S> findAll(Example<S> example);

    <S extends BookingView> List<S> findAll(Example<S> example, Sort sort);

    Page<BookingView> findAll(Pageable pageable);

    <S extends BookingView> S save(S entity);

    Optional<BookingView> findById(Integer integer);

    boolean existsById(Integer integer);

    long count();

    void deleteById(Integer integer);

    void delete(BookingView entity);

    void deleteAllById(Iterable<? extends Integer> integers);

    void deleteAll(Iterable<? extends BookingView> entities);

    void deleteAll();

    <S extends BookingView> Optional<S> findOne(Example<S> example);

    <S extends BookingView> Page<S> findAll(Example<S> example, Pageable pageable);

    <S extends BookingView> long count(Example<S> example);

    <S extends BookingView> boolean exists(Example<S> example);
}
