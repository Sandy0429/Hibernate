package com.sandhya.springdata.hibernateInheritanceJoined.repos;

import org.springframework.data.repository.CrudRepository;

import com.sandhya.springdata.hibernateInheritanceJoined.entities.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Integer> {

}
