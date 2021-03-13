package com.erank.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erank.dto.SystemClientDto;
import com.erank.model.SystemClients;
import com.erank.service.SystemClientService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/client")
public class SystemClientController {

	@Autowired
	private SystemClientService sysClient;
	
	 @GetMapping("/all")
	    public List<SystemClients> findAll(){
	    	return sysClient.getServicesQuestions();
	    }

	 @GetMapping("/{id}")
		public Optional<SystemClients> findById(@PathVariable Long id) {
			return sysClient.getQuestionsById(id);
		} 
	 
	 @PostMapping("/add")
	 public SystemClients add(@RequestBody SystemClientDto clientDto) {
		 return sysClient.addClient(clientDto);
	 }
	 
	 @PutMapping("/update")
	 public SystemClients update(@PathVariable Long id,@RequestBody SystemClientDto clientDto) {
		 return sysClient.updateClient(id, clientDto);
	 }
}
