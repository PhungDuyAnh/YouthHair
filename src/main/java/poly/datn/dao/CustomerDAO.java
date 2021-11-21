package poly.datn.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import poly.datn.entity.Customer;

public interface CustomerDAO extends JpaRepository<Customer, Integer> {

	@Query("SELECT c FROM Customer c WHERE c.phone = ?1 AND c.email = ?2")
	Optional<Customer> checkCustomerContact(String phone, String email);

}
