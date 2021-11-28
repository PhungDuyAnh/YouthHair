package poly.datn.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import poly.datn.entity.Customer;

public interface CustomerDAO extends JpaRepository<Customer, Integer> {
    @Query(value = "SELECT b FROM Customer b WHERE b.phone= ?1")
    Customer customerByPhone(String phone);
}
