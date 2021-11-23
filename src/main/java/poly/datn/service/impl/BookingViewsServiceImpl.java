package poly.datn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import poly.datn.dao.BookingViewsDAO;
import poly.datn.entity.BookingView;
import poly.datn.service.BookingViewsService;

import java.util.List;
import java.util.Optional;

@Service
public class BookingViewsServiceImpl implements BookingViewsService {
    @Autowired
    BookingViewsDAO bookingViewsDAO;

    @Override
    public List<BookingView> findByStatusName(String statusName) {
        return bookingViewsDAO.findByStatusName(statusName);
    }

    @Override
    public List<BookingView> findAll() {
        return bookingViewsDAO.findAll();
    }

    @Override
    public List<BookingView> findAll(Sort sort) {
        return bookingViewsDAO.findAll(sort);
    }

    @Override
    public List<BookingView> findAllById(Iterable<Integer> integers) {
        return bookingViewsDAO.findAllById(integers);
    }

    @Override
    public <S extends BookingView> List<S> saveAll(Iterable<S> entities) {
        return bookingViewsDAO.saveAll(entities);
    }

    @Override
    public void flush() {
        bookingViewsDAO.flush();
    }

    @Override
    public <S extends BookingView> S saveAndFlush(S entity) {
        return bookingViewsDAO.saveAndFlush(entity);
    }

    @Override
    public <S extends BookingView> List<S> saveAllAndFlush(Iterable<S> entities) {
        return bookingViewsDAO.saveAllAndFlush(entities);
    }

    @Override
    @Deprecated
    public void deleteInBatch(Iterable<BookingView> entities) {
        bookingViewsDAO.deleteInBatch(entities);
    }

    @Override
    public void deleteAllInBatch(Iterable<BookingView> entities) {
        bookingViewsDAO.deleteAllInBatch(entities);
    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {
        bookingViewsDAO.deleteAllByIdInBatch(integers);
    }

    @Override
    public void deleteAllInBatch() {
        bookingViewsDAO.deleteAllInBatch();
    }

    @Override
    @Deprecated
    public BookingView getOne(Integer integer) {
        return bookingViewsDAO.getOne(integer);
    }

    @Override
    public BookingView getById(Integer integer) {
        return bookingViewsDAO.getById(integer);
    }

    @Override
    public <S extends BookingView> List<S> findAll(Example<S> example) {
        return bookingViewsDAO.findAll(example);
    }

    @Override
    public <S extends BookingView> List<S> findAll(Example<S> example, Sort sort) {
        return bookingViewsDAO.findAll(example, sort);
    }

    @Override
    public Page<BookingView> findAll(Pageable pageable) {
        return bookingViewsDAO.findAll(pageable);
    }

    @Override
    public <S extends BookingView> S save(S entity) {
        return bookingViewsDAO.save(entity);
    }

    @Override
    public Optional<BookingView> findById(Integer integer) {
        return bookingViewsDAO.findById(integer);
    }

    @Override
    public boolean existsById(Integer integer) {
        return bookingViewsDAO.existsById(integer);
    }

    @Override
    public long count() {
        return bookingViewsDAO.count();
    }

    @Override
    public void deleteById(Integer integer) {
        bookingViewsDAO.deleteById(integer);
    }

    @Override
    public void delete(BookingView entity) {
        bookingViewsDAO.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {
        bookingViewsDAO.deleteAllById(integers);
    }

    @Override
    public void deleteAll(Iterable<? extends BookingView> entities) {
        bookingViewsDAO.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        bookingViewsDAO.deleteAll();
    }

    @Override
    public <S extends BookingView> Optional<S> findOne(Example<S> example) {
        return bookingViewsDAO.findOne(example);
    }

    @Override
    public <S extends BookingView> Page<S> findAll(Example<S> example, Pageable pageable) {
        return bookingViewsDAO.findAll(example, pageable);
    }

    @Override
    public <S extends BookingView> long count(Example<S> example) {
        return bookingViewsDAO.count(example);
    }

    @Override
    public <S extends BookingView> boolean exists(Example<S> example) {
        return bookingViewsDAO.exists(example);
    }

}
