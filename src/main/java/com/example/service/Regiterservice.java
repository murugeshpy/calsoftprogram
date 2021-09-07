package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.entity;
import com.example.repository.RegisterRepository;

@Service
public class Regiterservice {
	
	@Autowired
	RegisterRepository registerrepository;
	
	public List<entity> getAll(){
		List<entity> mylist = (List<entity>) registerrepository.findAll();
		return mylist;
	}
	
	public entity getById(int id) {
		return registerrepository.findById(id).get();
	}
	
	public void update(entity en, int id) {
		
		registerrepository.save(en);
	}
	
	public void save(entity en) {
		
		registerrepository.save(en);
	}
	
	public void delete(int id) {
		registerrepository.deleteById(id);
	}
	
	public void deleteall() {
		registerrepository.deleteAll();
	}
	
	public String check(String empname) {
		List<entity> value = registerrepository.findByEmpname(empname);
		
		if(value.isEmpty()) {
			return "User is not available";
		}
		else
		{
		if(value.get(0).getEmpage()>18) {
			return "Eligible to vote";
		}
		else
			return "Not Eligible to vote";
		}
	}
	
	public String role(String empname) {
		List<entity> year = registerrepository.findByEmpname(empname);
		if(year.isEmpty()) {
			return "not user available";
		}
		if(year.get(0).getExperience()>=1 & year.get(0).getExperience()<=2 ) {
			return "Software Developer";
		}
		else if(year.get(0).getExperience()>=3 & year.get(0).getExperience()<=4) {
			return "Group lead";
		}
		else if(year.get(0).getExperience()>=5 & year.get(0).getExperience()<=6) {
			return "Team lead";
		}
		else {
			return "Manager";
		}
	}
	
	}


