package com.vti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vti.entity.Account;
import com.vti.service.IAccountService;

@RestController
@RequestMapping(value = "api/v1/accounts")
public class AccountController {
	@Autowired
	private IAccountService accountService;
	
	@GetMapping()
	public Page<Account> getAllAccounts(Pageable pageable){
		return accountService.getAllAccounts(pageable);
	}
	
	@GetMapping(value = "/{id}")
	public Account getAccountById(@PathVariable(name = "id") short id) {
		return accountService.getAccountByID(id);
	}
	
	@GetMapping(value = "/name")
	public Account getAccountByName(@RequestParam(name = "name") String name) {
		return accountService.getAccountByName(name);
	}
	
	@PostMapping()
	public void createAccount(@RequestBody Account account) {
		accountService.createAccount(account);
	}

	@PutMapping(value = "/{id}")
	public void updateAccount(@PathVariable(name = "id") short id, @RequestBody Account account) {
		account.setAccountId(id);
		accountService.updateAccount(account);
	}

	@DeleteMapping(value = "/{id}")
	public void deleteAccount(@PathVariable(name = "id") short id) {
		accountService.deleteAccount(id);
	}
}
