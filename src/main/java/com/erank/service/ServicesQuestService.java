package com.erank.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erank.dto.ServicesQuestionDto;
import com.erank.model.Options;
import com.erank.model.SectionTable;
import com.erank.model.ServicesQuestions;
import com.erank.model.ServicesTable;
import com.erank.repo.OptionsRepositary;
import com.erank.repo.SectionTableRepositary;
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
	
	@Autowired
	private SectionTableRepositary secRepo;
	
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
    	
    	SectionTable sectionTable = secRepo.findById(serveQues.getSection_id()).get();
    	sectionTable.setSection_id(serveQues.getSection_id());
    	
    	Options opt = optionRepo.findById(serveQues.getQuestion_type()).get();
    	opt.setQuestion_type(serveQues.getQuestion_type());
    	
    	
    	ServicesQuestions sevQues = new ServicesQuestions();
    	sevQues.setServiceTable(serviceTab);
    	sevQues.setSectionTable(sectionTable);
    	sevQues.setOptionsTable(opt);
    	sevQues.setQuestion(serveQues.getQuestion());
    	sevQues.setIs_enabled(false);
        return sQuesRepo.save(sevQues);
	}
    
    public ServicesQuestions updateQuestions(Long id,ServicesQuestionDto serveQues) {
    	
    	LocalDate modified_date = LocalDate.now();
    	ServicesTable serviceTab = sTabRepo.findById(serveQues.getServices_id()).get();
    	serviceTab.setServices_id(serviceTab.getServices_id());
    	
    	SectionTable sectionTable = secRepo.findById(serveQues.getSection_id()).get();
    	sectionTable.setSection_id(serveQues.getSection_id());
    	
    	Options opt = optionRepo.findById(serveQues.getQuestion_type()).get();
    	opt.setQuestion_type(serveQues.getQuestion_type());
    	
    	ServicesQuestions  updateQuestion = sQuesRepo.findById(id).orElse(null);
    	updateQuestion.setSectionTable(sectionTable);
    	updateQuestion.setModified_date(modified_date);
    	updateQuestion.setOptionsTable(opt);
    	updateQuestion.setQuestion(serveQues.getQuestion());
    	updateQuestion.setServiceTable(serviceTab);
    	updateQuestion.setIs_enabled(false);
    	return sQuesRepo.save(updateQuestion);
    }
    
    
   /* public Map<String , List<ServicesQuestions>> questions(Long servicesId) {
    	Long servicesquestion_id;
    	String question;
        Long services_id;
    	Long question_type;
    	LocalDate modified_date;
    	Long section_id;
    	Map<String , List<ServicesQuestions>> outPutObj = (Map<String, List<ServicesQuestions>>) sQuesRepo.findById(servicesId).get();
    	
    	
    	if(outPutObj == null) {
    		List<ServicesQuestions>  listObj = new ArrayList<ServicesQuestions>();
    		listObj.add(new ServicesQuestions());
    		outPutObj.put(, listObj);
    	}
    	
		return outPutObj;
    	
    	
    }*/
}
