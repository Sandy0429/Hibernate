package com.sandhya.springdata.associations.manytomany.repos;

import org.springframework.data.repository.CrudRepository;

import com.sandhya.springdata.associations.manytomany.entities.Programmer;

public interface ProgrammerRepository extends CrudRepository<Programmer, Integer> {

}
