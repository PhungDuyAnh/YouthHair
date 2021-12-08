package poly.datn.service;

import java.util.List;

import poly.datn.entity.Account;

public interface AccountService {

    Account findById(String id);

    Account findByName(String username);

    List<Account> findAll();
}
