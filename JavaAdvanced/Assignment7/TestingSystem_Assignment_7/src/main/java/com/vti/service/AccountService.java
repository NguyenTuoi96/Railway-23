package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.vti.entity.Account;
import com.vti.respository.IAccountRespository;

@Service
public class AccountService implements IAccountService {
	
	@Autowired
	private IAccountRespository accountRepository;

	@Override
	public Page<Account> getAllAccounts(Pageable pageable) {
		
		return accountRepository.findAll(pageable);
	}

	@Override
	public Account getAccountByID(short id) {
		
		return accountRepository.findById(id).get();
	}

	@Override
	public Account getAccountByName(String name) {

		return accountRepository.findByUsername(name);
	}

	@Override
	public void createAccount(Account account) {
		
		accountRepository.save(account);		
	}

	@Override
	public void updateAccount(Account account) {
		accountRepository.save(account);
	}

	@Override
	public void deleteAccount(short id) {
		
		accountRepository.deleteById(id);;
	}

	@Override
	public boolean isAccountExistsByID(short id) {
		
		return accountRepository.existsById(id);
	}

	@Override
	public boolean isAccountExistsByName(String name) {
		Account account = getAccountByName(name);

		if (account == null) {
			return false;
		}
		return true;
	}
	
	
}
