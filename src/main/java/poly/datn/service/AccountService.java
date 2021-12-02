package poly.datn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import poly.datn.entity.Account;

public interface AccountService {

    Optional<Account> findById(Integer id);

    Account findByName(String username);

    List<Account> findAll();
}
