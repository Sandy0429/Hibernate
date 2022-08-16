package com.sandhya.springdata.transactionmanagement;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sandhya.springdata.transactionmanagement.services.BankAccountService;

@SpringBootTest
class TransactionManagementApplicationTests {

	@Autowired
	BankAccountService service;
	
	@Test
	public void testTransfer() {
		service.transfer(500);
	}

}
