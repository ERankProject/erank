package com.erank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erank.model.ServicesTable;
import com.erank.repo.ServiceTableRepo;


@Service
public class ServicesTableService { 
	
	@Autowired
	private ServiceTableRepo stableRepo;
	
//	public List<ServicesTable> saveServices(List<ServicesTable> services){
//		return stableRepo.saveAll(services);
//	}
	
	public List<ServicesTable> getServices(){
		return stableRepo.findAll();
	}
	
	public Optional<ServicesTable> getTableById(Long id) {
		return stableRepo.findById(id);
	}
	
	public ServicesTable saveService(ServicesTable serveTab) {
		
		return stableRepo.save(serveTab);
		
	}
	
}

