package com.sandhya.springdata.associations.onetomany.repos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.sandhya.springdata.associations.onetomany.entities.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
	
	

}
