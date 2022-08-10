package com.sandhya.springdata.idgenerators;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sandhya.springdata.idgenerators.entities.Employee;
import com.sandhya.springdata.idgenerators.repos.EmployeeRepository;

@SpringBootTest
class IdgeneratorsApplicationTests {

	@Autowired
	EmployeeRepository er;
	@Test
	void testCreateEmployee() {
		
		Employee emp =new Employee();		
		emp.setName("Duggu");
		
		er.save(emp);
		
	}

}
