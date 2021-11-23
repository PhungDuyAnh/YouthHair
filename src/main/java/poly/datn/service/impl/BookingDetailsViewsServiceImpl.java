package poly.datn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import poly.datn.dao.BookingDetailsViewsDAO;
import poly.datn.entity.BookingDetailView;
import poly.datn.service.BookingDetailsViewsService;

import java.util.List;
import java.util.Optional;

@Service
public class BookingDetailsViewsServiceImpl implements BookingDetailsViewsService {

    @Autowired
    BookingDetailsViewsDAO bookingViewsDAO;


    @Override
    public List<BookingDetailView> findAll() {
        return bookingViewsDAO.findAll();
    }

    @Override
    public List<BookingDetailView> findAll(Sort sort) {
        return bookingViewsDAO.findAll(sort);
    }

    @Override
    public List<BookingDetailView> findAllById(Iterable<Integer> integers) {
        return bookingViewsDAO.findAllById(integers);
    }

    @Override
    public <S extends BookingDetailView> List<S> saveAll(Iterable<S> entities) {
        return bookingViewsDAO.saveAll(entities);
    }

    @Override
    public void flush() {
        bookingViewsDAO.flush();
    }

    @Override
    public <S extends BookingDetailView> S saveAndFlush(S entity) {
        return bookingViewsDAO.saveAndFlush(entity);
    }

    @Override
    public <S extends BookingDetailView> List<S> saveAllAndFlush(Iterable<S> entities) {
        return bookingViewsDAO.saveAllAndFlush(entities);
    }

    @Override
    @Deprecated
    public void deleteInBatch(Iterable<BookingDetailView> entities) {
        bookingViewsDAO.deleteInBatch(entities);
    }

    @Override
    public void deleteAllInBatch(Iterable<BookingDetailView> entities) {
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
    public BookingDetailView getOne(Integer integer) {
        return bookingViewsDAO.getOne(integer);
    }

    @Override
    public BookingDetailView getById(Integer integer) {
        return bookingViewsDAO.getById(integer);
    }

    @Override
    public <S extends BookingDetailView> List<S> findAll(Example<S> example) {
        return bookingViewsDAO.findAll(example);
    }

    @Override
    public <S extends BookingDetailView> List<S> findAll(Example<S> example, Sort sort) {
        return bookingViewsDAO.findAll(example, sort);
    }

    @Override
    public Page<BookingDetailView> findAll(Pageable pageable) {
        return bookingViewsDAO.findAll(pageable);
    }

    @Override
    public <S extends BookingDetailView> S save(S entity) {
        return bookingViewsDAO.save(entity);
    }

    @Override
    public Optional<BookingDetailView> findById(Integer integer) {
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
    public void delete(BookingDetailView entity) {
        bookingViewsDAO.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {
        bookingViewsDAO.deleteAllById(integers);
    }

    @Override
    public void deleteAll(Iterable<? extends BookingDetailView> entities) {
        bookingViewsDAO.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        bookingViewsDAO.deleteAll();
    }

    @Override
    public <S extends BookingDetailView> Optional<S> findOne(Example<S> example) {
        return bookingViewsDAO.findOne(example);
    }

    @Override
    public <S extends BookingDetailView> Page<S> findAll(Example<S> example, Pageable pageable) {
        return bookingViewsDAO.findAll(example, pageable);
    }

    @Override
    public <S extends BookingDetailView> long count(Example<S> example) {
        return bookingViewsDAO.count(example);
    }

    @Override
    public <S extends BookingDetailView> boolean exists(Example<S> example) {
        return bookingViewsDAO.exists(example);
    }

    @Override
    public List<BookingDetailView> findByStatusName(String statusName) {
        return bookingViewsDAO.findByStatusName(statusName);
    }
}
