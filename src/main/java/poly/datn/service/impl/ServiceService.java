package poly.datn.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import poly.datn.dao.ServiceDAO;
import poly.datn.entity.Services;
import poly.datn.service.IServiceService;

@Service
public class ServiceService implements IServiceService {
    @Autowired
    ServiceDAO serviceDAO;

    @Override
    public <S extends Services> S save(S entity) {
        return serviceDAO.save(entity);
    }

    @Override
    public <S extends Services> Optional<S> findOne(Example<S> example) {
        return serviceDAO.findOne(example);
    }

    @Override
    public Page<Services> findAll(Pageable pageable) {
        return serviceDAO.findAll(pageable);
    }

    @Override
    public List<Services> findAll() {
        return serviceDAO.findAll();
    }

    @Override
    public List<Services> findAll(Sort sort) {
        return serviceDAO.findAll(sort);
    }

    @Override
    public List<Services> findAllById(Iterable<Integer> ids) {
        return serviceDAO.findAllById(ids);
    }

    @Override
    public Services findById(Integer id) {
        return serviceDAO.findById(id).get();
    }

    @Override
    public <S extends Services> List<S> saveAll(Iterable<S> entities) {
        return serviceDAO.saveAll(entities);
    }

    @Override
    public void flush() {
        serviceDAO.flush();
    }

    @Override
    public <S extends Services> S saveAndFlush(S entity) {
        return serviceDAO.saveAndFlush(entity);
    }

    @Override
    public boolean existsById(Integer id) {
        return serviceDAO.existsById(id);
    }

    @Override
    public <S extends Services> List<S> saveAllAndFlush(Iterable<S> entities) {
        return serviceDAO.saveAllAndFlush(entities);
    }

    @Override
    public <S extends Services> Page<S> findAll(Example<S> example, Pageable pageable) {
        return serviceDAO.findAll(example, pageable);
    }

    @Override
    public void deleteInBatch(Iterable<Services> entities) {
        serviceDAO.deleteInBatch(entities);
    }

    @Override
    public <S extends Services> long count(Example<S> example) {
        return serviceDAO.count(example);
    }

    @Override
    public <S extends Services> boolean exists(Example<S> example) {
        return serviceDAO.exists(example);
    }

    @Override
    public void deleteAllInBatch(Iterable<Services> entities) {
        serviceDAO.deleteAllInBatch(entities);
    }

    @Override
    public long count() {
        return serviceDAO.count();
    }

    @Override
    public void deleteById(Integer id) {
        serviceDAO.deleteById(id);
    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> ids) {
        serviceDAO.deleteAllByIdInBatch(ids);
    }

    @Override
    public void delete(Integer id) {
        serviceDAO.deleteById(id);
    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> ids) {
        serviceDAO.deleteAllById(ids);
    }

    @Override
    public void deleteAllInBatch() {
        serviceDAO.deleteAllInBatch();
    }

    @Override
    public Services getOne(Integer id) {
        return serviceDAO.getOne(id);
    }

    @Override
    public void deleteAll(Iterable<? extends Services> entities) {
        serviceDAO.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        serviceDAO.deleteAll();
    }

    @Override
    public Services getById(Integer id) {
        return serviceDAO.getById(id);
    }

    @Override
    public <S extends Services> List<S> findAll(Example<S> example) {
        return serviceDAO.findAll(example);
    }

    @Override
    public <S extends Services> List<S> findAll(Example<S> example, Sort sort) {
        return serviceDAO.findAll(example, sort);
    }

    @Override
    public Services update(Services services) {
        return serviceDAO.save(services);
    }


}
