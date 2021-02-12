package com.erank.repo;


import java.time.LocalDate;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.erank.dto.UserSurveyDto;
import com.erank.model.UserSurvey;

@Repository
public interface UserSurveyRepo extends JpaRepository<UserSurvey, Long>{
	UserSurvey save(UserSurveyDto surveyDto);

	//List<UserSurvey> saveAll(List<UserSurvey> userSurveys);

	//List<UserSurvey> saveAll(UserSurveyDto uSurvey);
	
	@Query(nativeQuery = true, value="select * FROM user_survey where DATE(created_date) BETWEEN DATE(IFNULL(:startDate,created_date)) "
			+ "		AND  DATE(IFNULL(:endDate,CURDATE())) AND service_name = IFNULL(:serName, service_name) "
			+ "			AND response_label = IFNULL(:respns, response_label) order by user_survey_id")
	public List<UserSurvey> findBySearch(@Param("startDate") LocalDate start_date,@Param("endDate") LocalDate end_date,@Param("serName") String serName,@Param("respns") String response_label);

	
}
