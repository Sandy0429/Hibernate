package com.sandhya.springdata.hibernateInheritanceJoined;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sandhya.springdata.hibernateInheritanceJoined.repos.PaymentRepository;
import com.sandhya.springdata.hibernateInheritanceJoined.entities.Check;
import com.sandhya.springdata.hibernateInheritanceJoined.entities.CreditCard;

@SpringBootTest
class HibernateInheritanceJoinedApplicationTests {

	@Autowired
	PaymentRepository repository;
	@Test
	void contextLoads() {
	}

	@Test
	public void createPayment() {

		CreditCard cc = new CreditCard();
		cc.setId(123);
		cc.setAmount(1000);
		cc.setCardnumber("1234567890");
		repository.save(cc);
	}

	@Test
	public void createCheckPayment() {

		Check ch = new Check();
		ch.setId(124);
		ch.setAmount(1000);
		ch.setChecknumber("1234567890");
		repository.save(ch);
	}
}
