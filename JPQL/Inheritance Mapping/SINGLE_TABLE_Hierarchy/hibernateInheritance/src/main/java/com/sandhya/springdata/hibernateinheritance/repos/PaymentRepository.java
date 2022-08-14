package com.sandhya.springdata.hibernateinheritance.repos;

import org.springframework.data.repository.CrudRepository;

import com.sandhya.springdata.hibernateinheritance.entities.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Integer> {

}
