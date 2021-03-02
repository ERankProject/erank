package com.erank.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erank.dto.SectionTableDto;
import com.erank.model.SectionTable;
import com.erank.model.ServicesTable;
import com.erank.repo.SectionTableRepositary;
import com.erank.repo.ServiceTableRepo;

@Service
public class SectionTableService {

	@Autowired
	private SectionTableRepositary sectionRepo;
	
	//@Autowired
	//private ServiceTableRepo  servTab;
	
	
	public List<SectionTable> getSections(){
		return sectionRepo.findAll();
	}
	
	public Optional<SectionTable> getTableById(Long id) {
		return sectionRepo.findById(id);
	}
	
	public SectionTable addSection(SectionTableDto secTab) {
		
		//ServicesTable tab = servTab.findById(secTab.getServices_id()).get();
		//tab.setServices_id(tab.getServices_id());
		
		String Created_by = "admin";
		
		SectionTable secTable = new SectionTable();
		//secTable.setServiceTable(tab);
		secTable.setSection_name(secTab.getSection_name());
		secTable.setIs_enabled(true);
		secTable.setCreated_date(LocalDate.now());
		secTable.setCreated_by(Created_by);
		return sectionRepo.save(secTab);
	}
	
	public SectionTable updateSection(Long id,SectionTableDto secTabDto) {
		
		LocalDate modified_date = LocalDate.now();
		
		//ServicesTable tab = servTab.findById(secTabDto.getServices_id()).get();
		//tab.setServices_id(tab.getServices_id());
		
		String Modified_by = "Editor";
		
		SectionTable secTable = sectionRepo.findById(id).orElse(null);
		
		secTable.setModified_date(modified_date);
		secTable.setModified_by(Modified_by);
        secTable.setSection_name(secTabDto.getSection_name());
        //secTable.setServiceTable(tab);
        return sectionRepo.save(secTable);
		
	}
}
