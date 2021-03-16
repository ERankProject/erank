package com.erank.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erank.model.Options;
import com.erank.service.OptionService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/option")
public class OptionController {
    
	@Autowired
	private  OptionService optionService;
	
	@GetMapping("/all")
	public List<Options> getAllOptions(){
		return optionService.getServicesQuestions();
	}
	
	@GetMapping("/{id}")
	public Optional<Options> getById(Long id) {
		return optionService.getById(id);
	}
	
	@PostMapping("/add")
	public Options add(Options opt) {
		return optionService.addOptions(opt);
	}
}
