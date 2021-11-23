package poly.datn.service;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import poly.datn.entity.BookingDetailView;

import java.util.List;
import java.util.Optional;

public interface BookingDetailsViewsService {
    List<BookingDetailView> findAll();

    List<BookingDetailView> findAll(Sort sort);

    List<BookingDetailView> findAllById(Iterable<Integer> integers);

    <S extends BookingDetailView> List<S> saveAll(Iterable<S> entities);

    void flush();

    <S extends BookingDetailView> S saveAndFlush(S entity);

    <S extends BookingDetailView> List<S> saveAllAndFlush(Iterable<S> entities);

    @Deprecated
    void deleteInBatch(Iterable<BookingDetailView> entities);

    void deleteAllInBatch(Iterable<BookingDetailView> entities);

    void deleteAllByIdInBatch(Iterable<Integer> integers);

    void deleteAllInBatch();

    @Deprecated
    BookingDetailView getOne(Integer integer);

    BookingDetailView getById(Integer integer);

    <S extends BookingDetailView> List<S> findAll(Example<S> example);

    <S extends BookingDetailView> List<S> findAll(Example<S> example, Sort sort);

    Page<BookingDetailView> findAll(Pageable pageable);

    <S extends BookingDetailView> S save(S entity);

    Optional<BookingDetailView> findById(Integer integer);

    boolean existsById(Integer integer);

    long count();

    void deleteById(Integer integer);

    void delete(BookingDetailView entity);

    void deleteAllById(Iterable<? extends Integer> integers);

    void deleteAll(Iterable<? extends BookingDetailView> entities);

    void deleteAll();

    <S extends BookingDetailView> Optional<S> findOne(Example<S> example);

    <S extends BookingDetailView> Page<S> findAll(Example<S> example, Pageable pageable);

    <S extends BookingDetailView> long count(Example<S> example);

    <S extends BookingDetailView> boolean exists(Example<S> example);

    List<BookingDetailView> findByStatusName(String statusName);
}
