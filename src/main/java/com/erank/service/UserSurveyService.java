package com.erank.service;

import java.util.ArrayList;
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
	public List<UserSurvey> saveUsers(List<UserSurveyDto> userSurveys){
			
		List<UserSurvey> userSurveyList = new ArrayList<UserSurvey>();
		User user = null;
		for(UserSurveyDto userSurveyDto:userSurveys) {
			
			UserSurvey  uSurvey = new UserSurvey();
			
			if(user==null) {
			user = userRepo.findById(userSurveyDto.getUserid()).get();
			user.setId(user.getId());
			}
			uSurvey.setUser(user);
			long response;
			
			String responseLabel = userSurveyDto.getResponse_label();
			switch(responseLabel) {
			case "Excellent" : response = 5;
			break;
			case "Good" : response =  4;
			break;
			case "Average" : response =  3;
			break;
			case "Below Average" : response =  2;
			break;
			case "Unacceptable" : response =  1;
			break;
			case "Yes" : response =  5;
			break;
			case "No" : response =  1;
			break;
			default: response =  1;  
		    break;  
			}
				
			
			long score = (response - 1) * 25 ;
			
			ServicesQuestions serQues = squesRepo.findById(userSurveyDto.getServicesquestion_id()).get();
			serQues.setServicesquestion_id(serQues.getServicesquestion_id());
		    uSurvey.setServicesQuestions(serQues);
			
		    uSurvey.setPatient_name(userSurveyDto.getPatient_name());
		    uSurvey.setEmail(userSurveyDto.getEmail());
		    uSurvey.setPhNum(userSurveyDto.getPhNum());
		    uSurvey.setUhid_no(userSurveyDto.getUhid_no());
		    uSurvey.setResponse_label(userSurveyDto.getResponse_label());
			uSurvey.setResponse(response);
			uSurvey.setScore(score);
			userSurveyList.add(uSurvey);
		 }

		return userSurveyRepo.saveAll(userSurveyList);
	}
	
	public List<UserSurvey> getUserSurvey(){
		return userSurveyRepo.findAll();
	}
	
	public Optional<UserSurvey> getById(Long id){
		return userSurveyRepo.findById(id);
	}
	
//	public UserSurvey saveUserSurvey(List<UserSurveyDto> surveyDto) {
//		User user = userRepo.findById(surveyDto.getUserid()).get();
//		user.setId(user.getId());
//		
//		ServicesQuestions serQues = squesRepo.findById(surveyDto.getServicesquestion_id()).get();
//		serQues.setServicesquestion_id(serQues.getServicesquestion_id());
//		
//		UserSurvey  uSurvey = new UserSurvey();
//		uSurvey.setUser(user);
//		uSurvey.setServicesQuestions(serQues);
//		uSurvey.setUser_answer(surveyDto.getUser_answer());
//		uSurvey.setUser_rating(surveyDto.getUser_rating());
//		return userSurveyRepo.saveAll(uSurvey);
//		
//	}
	
	public UserSurvey saveSurvey(UserSurveyDto surveyDto) {
		
		User user = userRepo.findById(surveyDto.getUserid()).get();
		user.setId(user.getId());
		
		ServicesQuestions serQues = squesRepo.findById(surveyDto.getServicesquestion_id()).get();
		serQues.setServicesquestion_id(serQues.getServicesquestion_id());
		
		UserSurvey  uSurvey = new UserSurvey();
		uSurvey.setUser(user);
		uSurvey.setServicesQuestions(serQues);
		uSurvey.setResponse_label(surveyDto.getResponse_label());
		uSurvey.setResponse(surveyDto.getResponse());
		return userSurveyRepo.save(uSurvey);
	}
}
