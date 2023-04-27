package com.demo.spring.jpa.h2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.spring.jpa.h2.model.Ssn;

public interface SsnRepository extends JpaRepository<Ssn, Long> {
 

}
