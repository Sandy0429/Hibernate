package com.sandhya.springdata.transactionmanagement.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sandhya.springdata.transactionmanagement.entities.BankAccount;
import com.sandhya.springdata.transactionmanagement.repos.BankAccountRepository;

@Service
public class BankAccountServiceImpl implements BankAccountService {

	@Autowired
	BankAccountRepository repository;

	@Override
	@Transactional
	public void transfer(int amount) {

		Optional<BankAccount> obamasAccount = repository.findById(1);

			obamasAccount.get().setBal(obamasAccount.get().getBal() - amount);
		repository.save(obamasAccount.get());
		
		
		Optional<BankAccount> trumpsAccount = repository.findById(2);

			trumpsAccount.get().setBal(trumpsAccount.get().getBal() + amount);
		repository.save(trumpsAccount.get());

	}

}
