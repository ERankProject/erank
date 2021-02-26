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

import com.erank.dto.UserSurveyDto;
import com.erank.model.UserSurvey;
import com.erank.service.UserSurveyService;




@CrossOrigin(origins="*")
@RestController
@RequestMapping("/survey")
public class UserSurveyController {

	
	@Autowired
	 private UserSurveyService surveyService;
	
//	@PostMapping("/add")
//	public UserSurvey save(UserSurvey userSurvey) {
//		return surveyService.saveUser(userSurvey);
//	}
//	
	@PostMapping("/saveAll")
	public List<UserSurvey> saveAll(@RequestBody List<UserSurveyDto> userSurveys){ 
		return surveyService.saveUsers(userSurveys);
	}
	
	@GetMapping("/findAll")
	public List<UserSurvey> findAll(){
		return surveyService.getUserSurvey();
	}
	
	@GetMapping("/{id}")
	public Optional<UserSurvey> getSurveyById(@PathVariable Long id){
		return surveyService.getById(id);
	}
	
	@PostMapping("/add")
	public UserSurvey updateSurvey(@RequestBody UserSurveyDto surveyDto) {
		return surveyService.saveSurvey(surveyDto); 
	}
	
	@PostMapping("/search")
	public List<UserSurvey> getSearch(@RequestBody UserSurveyDto surveyDto) {
		return surveyService.getBySearch(surveyDto);
		
	}
	
	
	@GetMapping("/allGraphs")
	public List<UserSurvey> getGraphs(){
		return surveyService.graph();
	}
		
}
