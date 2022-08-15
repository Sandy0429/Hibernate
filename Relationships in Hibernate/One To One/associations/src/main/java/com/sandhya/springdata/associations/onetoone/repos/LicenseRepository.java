package com.sandhya.springdata.associations.onetoone.repos;

import org.springframework.data.repository.CrudRepository;

import com.sandhya.springdata.associations.onetoone.entities.License;

public interface LicenseRepository extends CrudRepository<License, Long> {

}
