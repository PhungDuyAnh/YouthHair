package poly.datn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poly.datn.dao.AccountDAO;
import poly.datn.dao.AuthorityDAO;
import poly.datn.entity.Account;
import poly.datn.entity.Authority;
import poly.datn.service.AccountService;
import poly.datn.service.AuthorityService;

import java.util.List;
import java.util.Optional;


@Service
public class AuthorityServiceImpl implements AuthorityService {

	
	@Autowired
	AuthorityDAO authorityDAO;

	@Override
	public Optional<Authority> findById(Integer id) {
		return authorityDAO.findById(id);
	}

}
