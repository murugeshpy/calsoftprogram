package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.entity;
import com.example.service.Regiterservice;

@RestController
@RequestMapping("api")
public class RegisterController {

	@Autowired
	Regiterservice register;
	
	@GetMapping("/getall")
	private List<entity> getAll()
	{
		return register.getAll();
	}
	
	
	@GetMapping("/getid/{id}")  
	private entity getById(@PathVariable("id") int id)   
	{  
	return register.getById(id);  
	}  

	
	@DeleteMapping("/delete/{id}")  
	private void delete(@PathVariable("id") int id)   
	{  
		register.delete(id);  
	}  
	
	@DeleteMapping("/deleteall")  
	private void deleteall()   
	{  
		register.deleteall();  
	}  
	
	
	@PostMapping("/save")  
	private void save(@RequestBody entity en) 
	{   
	 register.save(en);
	}  
	
	
	@PutMapping("/update/{id}")  
	private entity update(@RequestBody entity en, @PathVariable("id") int id)   
	{  
		register.update(en, id);  
	return en;  
	}
	
	@GetMapping("/check/{empname}")
	private String check(@PathVariable("empname") String empname)
	{
		return register.check(empname);
		
	}
	
	@GetMapping("/role/{empname}")
	private String role(@PathVariable("empname") String empname)
	{
		return register.role(empname);
	}
}
