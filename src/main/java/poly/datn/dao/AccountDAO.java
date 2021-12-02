package poly.datn.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import poly.datn.entity.Account;
import poly.datn.entity.Booking;

import java.util.List;

public interface AccountDAO extends JpaRepository<Account, Integer> {

    @Query(value = "SELECT b FROM Account b WHERE b.username = ?1")
    Account findByName(String username);

}
