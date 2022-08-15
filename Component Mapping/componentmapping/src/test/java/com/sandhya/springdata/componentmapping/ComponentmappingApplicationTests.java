package com.sandhya.springdata.componentmapping;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sandhya.springdata.componentmapping.entities.Address;
import com.sandhya.springdata.componentmapping.entities.Employee;
import com.sandhya.springdata.componentmapping.repos.EmployeeRepository;

@SpringBootTest
class ComponentmappingApplicationTests {

	@Autowired
	EmployeeRepository repository;
	
	@Test
	public void testCreate() {
		
		Employee emp = new Employee();
		emp.setId(123);
		emp.setName("Sandhya");
		
		Address address = new Address();
		address.setCity("Austin");
		address.setStreetaddress("Spicewood Springs");
		address.setCountry("USA");
		address.setState("Texas");
		address.setZipcode("78750");
		emp.setAddress(address);
		
		repository.save(emp);
	}

}
