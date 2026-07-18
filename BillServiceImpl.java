package com.pharmalens.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pharmalens.entity.BillItem;


public interface BillItemRepository extends JpaRepository<BillItem, Long> {

}