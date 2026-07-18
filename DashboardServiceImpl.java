package com.pharmalens.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pharmalens.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}