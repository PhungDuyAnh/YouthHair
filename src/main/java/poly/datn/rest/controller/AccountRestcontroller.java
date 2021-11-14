package poly.datn.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import poly.datn.entity.Account;
import poly.datn.service.AccountService;

@RestController
public class AccountRestcontroller {
	
	@Autowired
	AccountService accountService;
	@GetMapping("/rest/account")
	public List<Account> getAll() {
		return accountService.findAll();
	}

}
