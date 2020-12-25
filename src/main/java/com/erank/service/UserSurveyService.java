package com.erank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erank.dto.UserSurveyDto;
import com.erank.model.ServicesQuestions;
import com.erank.model.User;
import com.erank.model.UserSurvey;
import com.erank.repo.ServiceQuestionsRepo;
import com.erank.repo.UserRepository;
import com.erank.repo.UserSurveyRepo;

@Service
public class UserSurveyService { 
	
	@Autowired
	private UserSurveyRepo userSurveyRepo; 
	
	@Autowired
	private ServiceQuestionsRepo squesRepo;
 
	@Autowired
	private UserRepository userRepo;
	
//	public UserSurvey saveUser(UserSurvey userSurvey) {
//		return userSurveyRepo.save(userSurvey);
//	}
//	
//	public List<UserSurvey> saveUsers(List<UserSurvey> userSurveys){
//		return userSurveyRepo.saveAll(userSurveys);
//	}
	
	public List<UserSurvey> getUserSurvey(){
		return userSurveyRepo.findAll();
	}
	
	public Optional<UserSurvey> getById(Long id){
		return userSurveyRepo.findById(id);
	}
	
	public UserSurvey saveSurvey(UserSurveyDto surveyDto) {
		
		User user = userRepo.findById(surveyDto.getUserid()).get();
		user.setId(user.getId());
		
		ServicesQuestions serQues = squesRepo.findById(surveyDto.getServicesquestion_id()).get();
		serQues.setServicesquestion_id(serQues.getServicesquestion_id());
		
		UserSurvey  uSurvey = new UserSurvey();
		uSurvey.setUser(user);
		uSurvey.setServicesQuestions(serQues);
		uSurvey.setUser_answer(surveyDto.getUser_answer());
		uSurvey.setUser_rating(surveyDto.getUser_rating());
		return userSurveyRepo.save(uSurvey);
	}
}
