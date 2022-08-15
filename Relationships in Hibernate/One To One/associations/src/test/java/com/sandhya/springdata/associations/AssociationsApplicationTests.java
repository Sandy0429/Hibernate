package com.sandhya.springdata.associations;

import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.sandhya.springdata.associations.manytomany.entities.Programmer;
import com.sandhya.springdata.associations.manytomany.entities.Project;
import com.sandhya.springdata.associations.manytomany.repos.ProgrammerRepository;
import com.sandhya.springdata.associations.onetomany.entities.Customer;
import com.sandhya.springdata.associations.onetomany.entities.PhoneNumber;
import com.sandhya.springdata.associations.onetomany.repos.CustomerRepository;
import com.sandhya.springdata.associations.onetoone.entities.License;
import com.sandhya.springdata.associations.onetoone.entities.Person;
import com.sandhya.springdata.associations.onetoone.repos.LicenseRepository;

@SpringBootTest
class AssociationsApplicationTests {

	@Autowired
	CustomerRepository repository;
	
	@Autowired
	ProgrammerRepository prepo;
	
	@Autowired
	LicenseRepository lrepo;

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

		// cleaner way of Adding foreign key value to the table
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

	@Test
	@Transactional
	public void testReterieveAllData() {

		// getting all data
		Iterable<Customer> findAll = repository.findAll();
		for (Customer c : findAll) {
			System.out.println(c.getName());
		}

		// Getting one data
		Optional<Customer> findById = repository.findById(5l);
		System.out.println(findById.get().getName());

		Set<PhoneNumber> numbers = findById.get().getNumbers();
		numbers.forEach(number -> System.out.println(number.getNumber()));

	}

//	updating operation
	@Test
	public void testUpdateCustomer() {

		// Getting one data
		Optional<Customer> findById = repository.findById(3l);
		// System.out.println(findById.get().getName());
		findById.get().setName("Sandy");

		Set<PhoneNumber> numbers = findById.get().getNumbers();
		numbers.forEach(number -> number.setType("Cell Update"));

		repository.save(findById.get()); // as findById is optional so it will give error if we didn't put .get()
	}

	// Delete
	@Test
	public void testDelete() {
		repository.deleteById(4l);
	}
	
	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>MANY TO MANY>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
	@Test
	public void testmtomCreateProgrammer() {
		Programmer programmer = new Programmer();
		programmer.setName("John");
		programmer.setSalary(10000);
		
		HashSet<Project> projects = new HashSet<Project>();
		Project project = new Project();
		project.setName("Hibernate Project");
		projects.add(project);
		programmer.setProjects(projects);
		
		prepo.save(programmer);
	}
	
	@Test
	@Transactional //if we are not using EAGER then we can use transactional in place of it it will solve the problem
	public void testmtomFindProgrammer() {
		Optional<Programmer> programmer = prepo.findById(1);
		
		System.out.println(programmer.get());
		System.out.println(programmer.get().getProjects());
		
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
