package com.sandhya.springdata.transactionmanagement.repos;

import org.springframework.data.repository.CrudRepository;

import com.sandhya.springdata.transactionmanagement.entities.BankAccount;

public interface BankAccountRepository extends CrudRepository<BankAccount, Integer> {

}
