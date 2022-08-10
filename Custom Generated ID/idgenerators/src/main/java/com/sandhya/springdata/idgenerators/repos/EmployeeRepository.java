package com.sandhya.springdata.idgenerators.repos;

import org.springframework.data.repository.CrudRepository;

import com.sandhya.springdata.idgenerators.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
