package poly.datn.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import poly.datn.entity.Customer;

public interface CustomerDAO extends JpaRepository<Customer, Integer> {

}
