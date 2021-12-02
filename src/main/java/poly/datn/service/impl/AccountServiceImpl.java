package poly.datn.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.datn.dao.AccountDAO;
import poly.datn.entity.Account;
import poly.datn.service.AccountService;


@Service
public class AccountServiceImpl implements AccountService {

	
	@Autowired
	AccountDAO accountDAO;

	@Override
	public Optional<Account> findById(Integer id) {
		return accountDAO.findById(id);
	}

	@Override
	public Account findByName(String username) {
		return accountDAO.findByName(username);
	}

	@Override
	public List<Account> findAll() {
		return accountDAO.findAll();
	}


}
