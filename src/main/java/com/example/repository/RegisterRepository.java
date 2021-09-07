package com.example.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.model.entity;

public interface RegisterRepository extends CrudRepository <entity, Integer>{
	 List<entity> findByEmpname(String empname);

	 
}
