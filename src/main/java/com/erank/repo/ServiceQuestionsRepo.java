package com.erank.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.erank.dto.ServicesQuestionDto;
import com.erank.model.ServicesQuestions;


@Repository
public interface ServiceQuestionsRepo extends JpaRepository<ServicesQuestions, Long>{
	ServicesQuestions save(ServicesQuestionDto serveQues);
	
	@Query(nativeQuery = true, value="select * from service_questions where services_id = :service_id")
	public List<ServicesQuestions> findByServiceId(@Param("service_id") Long servId);
}
