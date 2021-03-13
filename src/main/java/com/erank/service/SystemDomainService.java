package com.erank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erank.model.SystemDomain;
import com.erank.repo.SystemDomainRepositary;

@Service
public class SystemDomainService {
	
	@Autowired
	private SystemDomainRepositary domainRepositary;
	
	public List<SystemDomain> getServicesQuestions(){
		return domainRepositary.findAll();
	}
	
	public Optional<SystemDomain> getQuestionsById(Long system_domain_id) {
		return domainRepositary.findById(system_domain_id);
	}
	
	public SystemDomain addDomain(SystemDomain sysDomain) {
		return domainRepositary.save(sysDomain);
	}
	

}
