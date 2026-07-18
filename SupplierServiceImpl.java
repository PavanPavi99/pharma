package com.pharmalens.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pharmalens.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

}