package com.pharmalens.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pharmalens.entity.Bill;


public interface BillRepository extends JpaRepository<Bill, Long> {

}