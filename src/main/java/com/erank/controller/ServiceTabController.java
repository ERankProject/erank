package com.erank.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erank.model.ServicesTable;
import com.erank.service.ServicesTableService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/services")
public class ServiceTabController { 
	
	 @Autowired
	 private ServicesTableService stService;
	 
	 @GetMapping("/tables")
	    public List<ServicesTable> findAll(){
	    	return stService.getServices();
	    }
  
	 @GetMapping("/{id}")
		public Optional<ServicesTable> findById(@PathVariable Long id) {
			return stService.getTableById(id);
		} 
	 
	 @PostMapping("/add")
	 public ServicesTable addService(@RequestBody ServicesTable servTab) {
		 return stService.saveService(servTab);
	 }
}
