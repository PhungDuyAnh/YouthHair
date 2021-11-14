package poly.datn.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import poly.datn.entity.Account;

public interface AccountDAO extends JpaRepository<Account, Integer> {

}
