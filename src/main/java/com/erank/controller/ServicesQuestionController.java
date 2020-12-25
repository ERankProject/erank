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

import com.erank.dto.ServicesQuestionDto;
import com.erank.model.ServicesQuestions;
import com.erank.service.ServicesQuestService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/servQuest")
public class ServicesQuestionController {

	 @Autowired
	 private ServicesQuestService servQuestion;
	 
	 @GetMapping("/questions")
	 public List<ServicesQuestions> findAll(){
			return servQuestion.getServicesQuestions();
		}
	 @GetMapping("/{id}")
     public Optional<ServicesQuestions> findById(@PathVariable Long id) {
			return servQuestion.getQuestionsById(id);
		}
	 
	 @PostMapping("/add")
	 public ServicesQuestions addQuestions(@RequestBody ServicesQuestionDto servQuestions) {
		 return servQuestion.saveQuestions(servQuestions);
	 }
}
