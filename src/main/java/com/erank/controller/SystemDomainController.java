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

import com.erank.model.SystemDomain;
import com.erank.service.SystemDomainService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/domain")
public class SystemDomainController {
	
	@Autowired
	private SystemDomainService domainService;
    
	 @GetMapping("/all")
	    public List<SystemDomain> findAll(){
	    	return domainService.getServicesQuestions();
	    }

	 @GetMapping("/{id}")
		public Optional<SystemDomain> findById(@PathVariable Long id) {
			return domainService.getQuestionsById(id);
		} 
	 
	 @PostMapping("/add")
	 public SystemDomain add(@RequestBody SystemDomain servTab) {
		 return domainService.addDomain(servTab);
	 }
}
