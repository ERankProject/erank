package com.erank.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erank.dto.ServicesQuestionDto;
import com.erank.model.Options;
import com.erank.model.ServicesQuestions;
import com.erank.model.ServicesTable;
import com.erank.repo.OptionsRepositary;
import com.erank.repo.ServiceQuestionsRepo;
import com.erank.repo.ServiceTableRepo;

@Service
public class ServicesQuestService {

	
	@Autowired
	private ServiceQuestionsRepo sQuesRepo;
	
	@Autowired 
	private ServiceTableRepo sTabRepo;
	
	@Autowired
	private OptionsRepositary optionRepo;
	
	public List<ServicesQuestions> getServicesQuestions(){
		return sQuesRepo.findAll();
	}
	
	
	public Optional<ServicesQuestions> getQuestionsById(Long services_id) {
		return sQuesRepo.findById(services_id);
	}
	
	public List<ServicesQuestions> getByServId(ServicesQuestionDto serveQues){
		return sQuesRepo.findByServiceId(serveQues.getServices_id());
	}
	
    public ServicesQuestions saveQuestions(ServicesQuestionDto serveQues) {
    	
    	ServicesTable serviceTab = sTabRepo.findById(serveQues.getServices_id()).get();
    	serviceTab.setServices_id(serviceTab.getServices_id());
    	
    	Options opt = optionRepo.findById(serveQues.getQuestion_type()).get();
    	opt.setQuestion_type(serveQues.getQuestion_type());
    	
    	
    	ServicesQuestions sevQues = new ServicesQuestions();
    	sevQues.setServiceTable(serviceTab);
    	sevQues.setOptionsTable(opt);
    	sevQues.setQuestion(serveQues.getQuestion());
        return sQuesRepo.save(sevQues);
	}
    
    public ServicesQuestions updateQuestions(Long id,ServicesQuestionDto serveQues) {
    	
    	LocalDate modified_date = LocalDate.now();
    	ServicesTable serviceTab = sTabRepo.findById(serveQues.getServices_id()).get();
    	serviceTab.setServices_id(serviceTab.getServices_id());
    	
    	Options opt = optionRepo.findById(serveQues.getQuestion_type()).get();
    	opt.setQuestion_type(serveQues.getQuestion_type());
    	
    	ServicesQuestions  updateQuestion = sQuesRepo.findById(id).orElse(null);
    	updateQuestion.setModified_date(modified_date);
    	updateQuestion.setOptionsTable(opt);
    	updateQuestion.setQuestion(serveQues.getQuestion());
    	updateQuestion.setServiceTable(serviceTab);
    	return sQuesRepo.save(updateQuestion);
    }
}
