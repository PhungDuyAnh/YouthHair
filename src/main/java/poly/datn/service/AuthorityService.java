package poly.datn.service;

import poly.datn.entity.Account;
import poly.datn.entity.Authority;

import java.util.List;
import java.util.Optional;

public interface AuthorityService {

    Optional<Authority> findById(Integer id);

}
