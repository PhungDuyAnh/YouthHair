package poly.datn.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import poly.datn.entity.Account;
import poly.datn.entity.Authority;

public interface AuthorityDAO extends JpaRepository<Authority, Integer> {
}
