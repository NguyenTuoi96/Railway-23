package com.vti.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.vti.entity.Account;

public interface IAccountService {
	public Page<Account> getAllAccounts(Pageable pageable);
	
	public Account getAccountByID(short id);
	
	public Account getAccountByName(String name);
	
	public void createAccount(Account account);
	
	public void updateAccount(Account account);
	
	public void deleteAccount(short id);
	
	public boolean isAccountExistsByID(short id);
	
	public boolean isAccountExistsByName(String name);
}
