package com.erank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erank.model.Options;
import com.erank.repo.OptionsRepositary;

@Service
public class OptionService {

	
	
	@Autowired
	private OptionsRepositary optionRepo;
	
	public List<Options> getServicesQuestions(){
		return optionRepo.findAll();
	}
	
	public Options addOptions(Options opt) {
		return optionRepo.save(opt);
	}
	
	public Optional<Options> getById(Long id) {
		return optionRepo.findById(id);
	}
}
