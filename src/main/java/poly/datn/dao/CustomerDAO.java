package poly.datn.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import poly.datn.entity.Customer;

public interface CustomerDAO extends JpaRepository<Customer, Integer> {

}
