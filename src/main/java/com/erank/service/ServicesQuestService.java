package com.erank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erank.dto.ServicesQuestionDto;
import com.erank.model.ServicesQuestions;
import com.erank.model.ServicesTable;
import com.erank.repo.ServiceQuestionsRepo;
import com.erank.repo.ServiceTableRepo;

@Service
public class ServicesQuestService {

	
	@Autowired
	private ServiceQuestionsRepo sQuesRepo;
	
	@Autowired 
	private ServiceTableRepo sTabRepo;
	
	public List<ServicesQuestions> getServicesQuestions(){
		return sQuesRepo.findAll();
	}
	
	public Optional<ServicesQuestions> getQuestionsById(Long id) {
		return sQuesRepo.findById(id);
	}
	
    public ServicesQuestions saveQuestions(ServicesQuestionDto serveQues) {
    	
    	ServicesTable serviceTab = sTabRepo.findById(serveQues.getServices_id()).get();
    	serviceTab.setServices_id(serviceTab.getServices_id());
    	
    	ServicesQuestions sevQues = new ServicesQuestions();
    	sevQues.setServiceTable(serviceTab);
    	sevQues.setQuestion(serveQues.getQuestion());
    	sevQues.setOption_1(serveQues.getOption_1());
    	sevQues.setOption_2(serveQues.getOption_2());
    	sevQues.setOption_3(serveQues.getOption_3());
    	sevQues.setOption_4(serveQues.getOption_4());
    	sevQues.setOption_5(serveQues.getOption_5());
    	sevQues.setOption_6(serveQues.getOption_6());
    	return sQuesRepo.save(sevQues);
	}
}
