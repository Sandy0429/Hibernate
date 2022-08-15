package com.sandhya.springdata.componentmapping.repos;

import org.springframework.data.repository.CrudRepository;

import com.sandhya.springdata.componentmapping.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
