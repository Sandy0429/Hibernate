package com.sandhya.springdata.associations;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sandhya.springdata.associations.onetomany.entities.Customer;
import com.sandhya.springdata.associations.onetomany.entities.PhoneNumber;
import com.sandhya.springdata.associations.onetomany.repos.CustomerRepository;

@SpringBootTest
class AssociationsApplicationTests {

	@Autowired
	CustomerRepository repository;

	@Test
	void contextLoads() {
	}

	@Test
	public void testCreateCustomer() {

		Customer customer = new Customer();
		customer.setName("John");
		
		HashSet<PhoneNumber> numbers = new HashSet<PhoneNumber>();
		
		PhoneNumber ph1 = new PhoneNumber();
		ph1.setNumber("1234567890");
		ph1.setType("Cell");
		ph1.setCustomer(customer);// this is to save the foreign key
		
		numbers.add(ph1);
		
		
		PhoneNumber ph2 = new PhoneNumber();
		ph2.setNumber("098754321");
		ph2.setType("Home");
		numbers.add(ph2);
		ph2.setCustomer(customer);
		
		customer.setNumbers(numbers);

		repository.save(customer);
	}
	
	@Test
	public void testCreateCustomerEasyForeignKeySet() {

		//cleaner way of Adding foreign key value to the table
		Customer customer = new Customer();
		customer.setName("Duggu");
		
		
		PhoneNumber ph1 = new PhoneNumber();
		ph1.setNumber("1234567890");
		ph1.setType("Cell");
					
		
		PhoneNumber ph2 = new PhoneNumber();
		ph2.setNumber("098754321");
		ph2.setType("Home");
		
		
		
		customer.addPhoneNumber(ph1);
		customer.addPhoneNumber(ph2);

		repository.save(customer);
	}
	
	

}
