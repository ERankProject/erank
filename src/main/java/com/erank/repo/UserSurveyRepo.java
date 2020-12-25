package com.erank.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erank.dto.UserSurveyDto;
import com.erank.model.UserSurvey;

@Repository
public interface UserSurveyRepo extends JpaRepository<UserSurvey, Long>{
	UserSurvey save(UserSurveyDto surveyDto); 
}
