package com.erank.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erank.dto.ServicesQuestionDto;
import com.erank.model.ServicesQuestions;


@Repository
public interface ServiceQuestionsRepo extends JpaRepository<ServicesQuestions, Long>{
	ServicesQuestions save(ServicesQuestionDto serveQues);
	
}
