package com.sandhya.springdata.associations;

import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.sandhya.springdata.associations.onetoone.entities.License;
import com.sandhya.springdata.associations.onetoone.entities.Person;
import com.sandhya.springdata.associations.onetoone.repos.LicenseRepository;

@SpringBootTest
class AssociationsApplicationTests {

	
	@Autowired
	LicenseRepository lrepo;

	@Test
	void contextLoads() {
	}
	
	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>One To One>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
	@Test
	public void testOneToOneCreateLicense() {
		License license = new License();
		license.setType("CAR");
		license.setValidFrom(new Date());
		license.setValidTo(new Date());
		
		Person person = new Person();
		person.setFirstName("John");
		person.setLastName("Smith");
		person.setAge(35);
		license.setPerson(person);
		lrepo.save(license);
	}
}
